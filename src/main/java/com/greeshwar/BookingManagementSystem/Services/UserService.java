package com.greeshwar.BookingManagementSystem.Services;


import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User signup(String name,String email,String password);
    List<Ticket> getAllTickets(Long userId);
}
