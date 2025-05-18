package com.greeshwar.BookingManagementSystem.Strategies.PaymentProcessing;

import com.greeshwar.BookingManagementSystem.Enums.PaymentMode;
import com.greeshwar.BookingManagementSystem.Enums.PaymentStatus;
import com.greeshwar.BookingManagementSystem.Models.Ticket;


public abstract class PaymentProcessingStrategy {
    private PaymentStatus paymentStatus;
    public PaymentProcessingStrategy(PaymentStatus ps){
        this.paymentStatus = ps;
    }

    public PaymentStatus getPaymentStatus(){
        return this.paymentStatus;
    }
    public abstract Ticket processPayment(PaymentMode paymentMode,Ticket ticket);
}
