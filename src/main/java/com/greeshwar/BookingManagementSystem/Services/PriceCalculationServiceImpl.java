package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Exceptions.ShowSeatTypeNotFoundException;
import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;
import com.greeshwar.BookingManagementSystem.Models.ShowSeatType;
import com.greeshwar.BookingManagementSystem.Repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PriceCalculationServiceImpl implements PriceCalculationService{
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculationServiceImpl(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public Double calculatePrice(List<ShowSeat> showSeats, Show show){
        List<ShowSeatType> showSeatTypes = this.showSeatTypeRepository.findAllByShow(show);
        Double amount = 0.0;
        for(ShowSeat showSeat:showSeats){
            boolean found = false;
            for(ShowSeatType showSeatType:showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                    found = true;
                    break;
                }

            }

            if(!found){
                throw new ShowSeatTypeNotFoundException(showSeat.getSeat().getSeatType().toString() +" not found");
            }
        }
        return amount;
    }
}
