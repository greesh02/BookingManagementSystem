package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Enums.ShowSeatStatus;
import com.greeshwar.BookingManagementSystem.Exceptions.ShowNotFoundException;
import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;
import com.greeshwar.BookingManagementSystem.Repositories.ShowRepository;
import com.greeshwar.BookingManagementSystem.Repositories.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShowSeatServiceImpl implements ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private ShowRepository showRepository;


    private Boolean blockedSeatAvailabilityCheck(ShowSeat showSeat){
        // Duration between currenttime and blocked time -> (currentTime - blockedTime)
        Long duration = Duration.between(showSeat.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes();
        System.out.println(duration);
        return (duration > 10);// true if blocked for more than 10 mins

    }

    public List<ShowSeat> getAllShowSeats(Long show_id){
        // check if showseat available if blocked and
        Optional<Show> optionalShow = this.showRepository.findById(show_id);

        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("show id "+show_id+" not found");
        }

        Show show = optionalShow.get();

        List<ShowSeat> showSeats = this.showSeatRepository.findAllByShow(show);
        for(ShowSeat showSeat:showSeats){
            // for making blocked seats as available
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.BLOCKED) && this.blockedSeatAvailabilityCheck(showSeat)) {
                showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
                this.showSeatRepository.save(showSeat);
            }
        }
        return showSeats;
    }
}
