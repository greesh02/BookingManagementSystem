package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Models.Ticket;

import java.util.List;

public interface PaymentService {
    List<String> getAllPaymentModes();
    Ticket proceedPayment(String email,Long ticketId,String paymentMode,String paymentStatus);
}
