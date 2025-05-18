package com.greeshwar.BookingManagementSystem.Repositories;

import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);
//    List<ShowSeat> saveAll(List<ShowSeat> showSeats);

    List<ShowSeat> findAllByShow(Show show);
}
