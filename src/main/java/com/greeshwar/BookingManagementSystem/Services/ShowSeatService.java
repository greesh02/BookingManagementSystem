package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Models.ShowSeat;

import java.util.List;

public interface ShowSeatService {
    List<ShowSeat> getAllShowSeats(Long show_id);
}
