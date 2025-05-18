package com.greeshwar.BookingManagementSystem.Dtos.GetMovies;

import com.greeshwar.BookingManagementSystem.Enums.Language;
import com.greeshwar.BookingManagementSystem.Models.Movie;

import java.util.List;

public class GetMoviesMovieServiceResponseDto {

    private List<Movie> movies;
    private List<Language> languages;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}
