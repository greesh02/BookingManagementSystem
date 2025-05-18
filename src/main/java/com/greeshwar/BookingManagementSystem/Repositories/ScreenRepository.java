package com.greeshwar.BookingManagementSystem.Repositories;

import com.greeshwar.BookingManagementSystem.Models.City;
import com.greeshwar.BookingManagementSystem.Models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ScreenRepository extends JpaRepository<Screen,Long> {
    Optional<Screen> findById(Long id);
}
