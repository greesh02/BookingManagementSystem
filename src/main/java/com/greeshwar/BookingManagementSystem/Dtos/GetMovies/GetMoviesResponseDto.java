package com.greeshwar.BookingManagementSystem.Dtos.GetMovies;

import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Enums.Language;
import com.greeshwar.BookingManagementSystem.Models.Movie;

import java.util.List;

public class GetMoviesResponseDto {
    private List<Movie> movies;
    private List<Language> languages;
    private ResponseInfo responseInfo;

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

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
