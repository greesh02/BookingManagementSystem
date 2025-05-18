package com.greeshwar.BookingManagementSystem.Repositories;

import com.greeshwar.BookingManagementSystem.Models.City;
import com.greeshwar.BookingManagementSystem.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    Optional<City> findById(Long id);

}
