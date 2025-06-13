package com.greeshwar.BookingManagementSystem.Repositories;

import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> longs);
//    List<ShowSeat> saveAll(List<ShowSeat> showSeats);

    List<ShowSeat> findAllByShow(Show show);

//    @Lock(LockModeType.PESSIMISTIC_WRITE)
//    @Query("SELECT ss FROM ShowSeat ss WHERE ss.id IN :ids") // basically to lock reads
    List<ShowSeat> findAllByIdIn( List<Long> ids);
}
