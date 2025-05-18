package com.greeshwar.BookingManagementSystem.Services;


import com.greeshwar.BookingManagementSystem.Models.Ticket;
import org.springframework.stereotype.Service;
import java.util.*;

public interface BookingService {
    Ticket bookTicket(Long userId,List<Long> showSeatsIds,Long showId);
}
