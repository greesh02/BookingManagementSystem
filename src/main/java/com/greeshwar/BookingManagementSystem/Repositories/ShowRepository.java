package com.greeshwar.BookingManagementSystem.Repositories;

import com.greeshwar.BookingManagementSystem.Models.City;
import com.greeshwar.BookingManagementSystem.Models.Movie;
import com.greeshwar.BookingManagementSystem.Models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {

    Optional<Show> findById(Long id);
    List<Show> findAllByCity(City city);
    List<Show> findAllByCityAndMovie(City city, Movie movie);
}
