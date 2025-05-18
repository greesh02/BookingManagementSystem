package com.greeshwar.BookingManagementSystem.Strategies.PaymentProcessing;

import com.greeshwar.BookingManagementSystem.Enums.PaymentMode;
import com.greeshwar.BookingManagementSystem.Enums.PaymentStatus;
import com.greeshwar.BookingManagementSystem.Enums.TicketStatus;
import com.greeshwar.BookingManagementSystem.Models.Payment;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Repositories.PaymentRepository;
import com.greeshwar.BookingManagementSystem.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("OTHER")
public class OtherPaymentStrategy extends PaymentProcessingStrategy{
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public OtherPaymentStrategy(){
        super(PaymentStatus.FAILURE);
    }

    public Ticket processPayment(PaymentMode paymentMode, Ticket ticket){

        Payment payment = new Payment();
        payment.setPaymentMode(paymentMode);
        payment.setPaymentStatus(this.getPaymentStatus());
        payment.setAmount(ticket.getAmount());
        payment.setTicket(ticket);

        this.paymentRepository.save(payment);

        ticket.setTicketStatus(TicketStatus.FAILURE);
        List<Payment> payments = ticket.getPayments();
        if(payments == null){
            payments = new ArrayList<>();
        }
        payments.add(payment);

        return this.ticketRepository.save(ticket);
    }
}
