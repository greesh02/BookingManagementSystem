package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Enums.PaymentMode;
import com.greeshwar.BookingManagementSystem.Enums.PaymentStatus;
import com.greeshwar.BookingManagementSystem.Enums.TicketStatus;
import com.greeshwar.BookingManagementSystem.Exceptions.InvalidTicketException;
import com.greeshwar.BookingManagementSystem.Exceptions.UserNotFoundException;
import com.greeshwar.BookingManagementSystem.Factories.PaymentProcessingFactory;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Models.User;
import com.greeshwar.BookingManagementSystem.Repositories.TicketRepository;
import com.greeshwar.BookingManagementSystem.Repositories.UserRepository;
import com.greeshwar.BookingManagementSystem.Strategies.PaymentProcessing.PaymentProcessingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentProcessingFactory paymentProcessingFactory;

    public List<String> getAllPaymentModes(){
        List<String> ret = new ArrayList<>();
        for(PaymentMode pm:PaymentMode.values()){
            ret.add(pm.toString());
        }
        return ret;
    }
    public Ticket proceedPayment(Long userId, Long ticketId, String paymentMode, String paymentStatus){
        Optional< User> optionalUser = this.userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("user not found");
        }
        Optional<Ticket> optionalTicket = this.ticketRepository.findById(ticketId);
        if(optionalTicket.isEmpty() || !optionalTicket.get().getUser().getId().equals(userId)){
            throw new InvalidTicketException("invalid ticket or ticket doesnt match user");
        }
        Ticket ticket = optionalTicket.get();

        if(!ticket.getTicketStatus().equals(TicketStatus.PENDING)){
            throw new InvalidTicketException("either ticket booking failed or completed");
        }

        PaymentMode pm = PaymentMode.valueOf(paymentMode);
        PaymentStatus ps = PaymentStatus.valueOf(paymentStatus);

        PaymentProcessingStrategy paymentProcessingStrategy = this.paymentProcessingFactory.getPaymentProcessingStrategy(ps);



        ticket = paymentProcessingStrategy.processPayment(pm,ticket);
        return ticket;

    }
}
