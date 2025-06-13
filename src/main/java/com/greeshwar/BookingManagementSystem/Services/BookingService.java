package com.greeshwar.BookingManagementSystem.Services;


import com.greeshwar.BookingManagementSystem.Models.Ticket;
import org.springframework.stereotype.Service;
import java.util.*;

public interface BookingService {
    Ticket bookTicket(String email,List<Long> showSeatsIds,Long showId);
}
