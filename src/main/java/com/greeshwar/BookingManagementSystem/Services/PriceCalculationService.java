package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;

import java.util.List;

public interface PriceCalculationService {

    Double calculatePrice(List<ShowSeat> showSeats, Show show);
}
