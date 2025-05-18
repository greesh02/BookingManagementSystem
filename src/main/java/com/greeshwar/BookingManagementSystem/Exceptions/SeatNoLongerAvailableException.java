package com.greeshwar.BookingManagementSystem.Exceptions;

import com.greeshwar.BookingManagementSystem.Models.Seat;

public class SeatNoLongerAvailableException extends RuntimeException{
    public SeatNoLongerAvailableException(String msg){
        super(msg);
    }
}
