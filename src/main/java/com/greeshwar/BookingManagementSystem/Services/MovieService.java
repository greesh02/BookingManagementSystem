package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Dtos.GetMovies.GetMoviesMovieServiceResponseDto;
import com.greeshwar.BookingManagementSystem.Models.Movie;

import java.util.List;

public interface MovieService {

    GetMoviesMovieServiceResponseDto getMoviesByCity(Long cityId);
}
