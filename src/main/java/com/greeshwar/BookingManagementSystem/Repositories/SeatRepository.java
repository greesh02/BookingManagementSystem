package com.greeshwar.BookingManagementSystem.Repositories;

import com.greeshwar.BookingManagementSystem.Models.Screen;
import com.greeshwar.BookingManagementSystem.Models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findAllByScreen(Screen screen);
}
