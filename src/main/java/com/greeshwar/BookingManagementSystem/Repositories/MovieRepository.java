package com.greeshwar.BookingManagementSystem.Repositories;

import com.greeshwar.BookingManagementSystem.Models.Movie;
import com.greeshwar.BookingManagementSystem.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    Optional<Movie> findById(Long id);
}
