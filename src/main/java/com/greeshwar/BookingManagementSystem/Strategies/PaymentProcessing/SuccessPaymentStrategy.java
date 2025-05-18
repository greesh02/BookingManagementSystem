package com.greeshwar.BookingManagementSystem.Strategies.PaymentProcessing;

import com.greeshwar.BookingManagementSystem.Enums.PaymentMode;
import com.greeshwar.BookingManagementSystem.Enums.PaymentStatus;
import com.greeshwar.BookingManagementSystem.Enums.ShowSeatStatus;
import com.greeshwar.BookingManagementSystem.Enums.TicketStatus;
import com.greeshwar.BookingManagementSystem.Models.Payment;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Repositories.PaymentRepository;
import com.greeshwar.BookingManagementSystem.Repositories.ShowSeatRepository;
import com.greeshwar.BookingManagementSystem.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("SUCCESS")
public class SuccessPaymentStrategy extends PaymentProcessingStrategy{
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;


    public SuccessPaymentStrategy(){
        super(PaymentStatus.SUCCESS);
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    private List<ShowSeat> updateShowSeatStatus(List<ShowSeat> showSeats){
        for(ShowSeat showSeat:showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);

        }
        return this.showSeatRepository.saveAll(showSeats);
    }

    public Ticket processPayment(PaymentMode paymentMode, Ticket ticket){

        List<ShowSeat> showSeats = ticket.getShowSeats();

        // update show seats to booked
        ticket.setShowSeats(this.updateShowSeatStatus(showSeats));

        // save payment info
        Payment payment = new Payment();
        payment.setPaymentMode(paymentMode);
        payment.setPaymentStatus(this.getPaymentStatus());
        payment.setAmount(ticket.getAmount());
        payment.setTicket(ticket);

        this.paymentRepository.save(payment);

        // save ticket info
        ticket.setTicketStatus(TicketStatus.CONFIRMED);
        List<Payment> payments = ticket.getPayments();
        if(payments == null){
            payments = new ArrayList<>();
        }
        payments.add(payment);

        return this.ticketRepository.save(ticket);
    }
}
