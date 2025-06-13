package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Enums.ShowSeatStatus;
import com.greeshwar.BookingManagementSystem.Enums.TicketStatus;
import com.greeshwar.BookingManagementSystem.Exceptions.SeatNoLongerAvailableException;
import com.greeshwar.BookingManagementSystem.Exceptions.ShowNotFoundException;
import com.greeshwar.BookingManagementSystem.Exceptions.UserNotFoundException;
import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Models.User;
import com.greeshwar.BookingManagementSystem.Repositories.ShowRepository;
import com.greeshwar.BookingManagementSystem.Repositories.ShowSeatRepository;
import com.greeshwar.BookingManagementSystem.Repositories.TicketRepository;
import com.greeshwar.BookingManagementSystem.Repositories.UserRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import javax.crypto.ShortBufferException;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculationService priceCalculationService;
    private TicketRepository ticketRepository;

    public BookingServiceImpl(UserRepository userRepository,ShowRepository showRepository,ShowSeatRepository showSeatRepository,PriceCalculationService priceCalculationService,TicketRepository ticketRepository){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculationService = priceCalculationService;
        this.ticketRepository = ticketRepository;
    }

    private Boolean checkShowSeatAvailability(ShowSeat showSeat){
        if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
            return true;
        }
        if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED)){
            // Duration between currenttime and blocked time -> (currentTime - blockedTime)
            Long duration = Duration.between(showSeat.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes();
            System.out.println(duration);
            return (duration > 10);// true if blocked for more than 10 mins
        }

        return false;
    }

    // obtains lock for thewhole operation
    @Transactional(isolation = Isolation.SERIALIZABLE) // whole operation is serializable
    private List<ShowSeat> reserveSeats(Show show,List<Long> showSeatsIds){
        // 3) fetch all show-seat matching pairs
        List<ShowSeat> showSeats = this.showSeatRepository.findAllByIdIn(showSeatsIds);

        //4) check if all seats present
        if(showSeats.size() != showSeatsIds.size()){
            throw new RuntimeException("missing seats");
        }
        // 5) validate if show seat status is available or not
        // also check if the seat belongs to that show
        for(ShowSeat ss:showSeats){
            System.out.println(ss.getShowSeatStatus()+" "+ss.getShow().getId() +" "+show.getId());
            if(!(ss.getShow().getId().equals(show.getId()) && this.checkShowSeatAvailability(ss))){
                throw new SeatNoLongerAvailableException("seat no longer available");
            }
            ss.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            // store the time at which it is blocked
            ss.setBlockedAt(new Date());
        }

        // 6) mark seats as blocked and proceed with payment
        return this.showSeatRepository.saveAll(showSeats);
    }

    public Ticket bookTicket(Long userId, List<Long> showSeatsIds, Long showId){

        if(showSeatsIds.size() == 0){
            throw new RuntimeException("please select some seats");
        }
        // 1) check if user present
        Optional<User> ou = this.userRepository.findById(userId);
        if(ou.isEmpty()){
            throw new UserNotFoundException("user not found");
        }

        User u = ou.get();

        // 2) check if show is present
        Optional<Show> os= this.showRepository.findById(showId);
        if(os.isEmpty()){
            throw new ShowNotFoundException( "show not found");
        }
        Show show = os.get();

        // LOCK from HERE------------------------------------------
        // 3) fetch all show-seat matching pairs
        //4) check if all seats present
        // 5) validate if show seat statusis available or not
        // 6) mark seats as blocked and proceed with payment

        List<ShowSeat> showSeats = this.reserveSeats(show,showSeatsIds);

        //7) create ticket
        Ticket t = new Ticket();
        t.setUser(u);
        t.setTicketStatus(TicketStatus.PENDING);
        t.setShowSeats(showSeats);

        //8) calculate price
        Double amount = this.priceCalculationService.calculatePrice(showSeats,show);
        t.setAmount(amount);


        // 9) save the ticket

        return this.ticketRepository.save(t);
    }
}
