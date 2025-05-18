package com.greeshwar.BookingManagementSystem.Exceptions;

public class CityNotFoundException extends RuntimeException{
    public CityNotFoundException(String msg){
        super(msg);
    }
}
