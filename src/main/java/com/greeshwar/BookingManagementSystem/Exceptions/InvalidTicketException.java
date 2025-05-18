package com.greeshwar.BookingManagementSystem.Exceptions;

public class InvalidTicketException extends RuntimeException{
    public InvalidTicketException(String msg){
        super(msg);
    }
}
