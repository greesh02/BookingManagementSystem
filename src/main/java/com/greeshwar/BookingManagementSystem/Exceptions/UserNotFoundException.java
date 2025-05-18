package com.greeshwar.BookingManagementSystem.Exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String msg){
        super(msg);
    }
}
