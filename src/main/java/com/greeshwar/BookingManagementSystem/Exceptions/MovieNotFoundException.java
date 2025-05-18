package com.greeshwar.BookingManagementSystem.Exceptions;

import com.greeshwar.BookingManagementSystem.Models.Movie;

public class MovieNotFoundException extends RuntimeException{
    public MovieNotFoundException(String msg){
        super(msg);
    }
}
