package com.greeshwar.BookingManagementSystem.Controllers;

import com.greeshwar.BookingManagementSystem.Dtos.GetMovies.GetMoviesMovieServiceResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.GetMovies.GetMoviesResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.Movie;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private MovieService movieService;
    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("")
    GetMoviesResponseDto getMovies(@RequestParam("city_id")Long cityId){

        GetMoviesResponseDto res = new GetMoviesResponseDto();

        try{
            GetMoviesMovieServiceResponseDto resp = this.movieService.getMoviesByCity(cityId);
            res.setMovies(resp.getMovies());
            res.setLanguages(resp.getLanguages());
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setResponseMessage("success");
            responseInfo.setResponseStatus(ResponseStatus.SUCCESS);
            res.setResponseInfo(responseInfo);

        }
        catch (Exception e){
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setResponseMessage(e.getMessage());
            responseInfo.setResponseStatus(ResponseStatus.FAILURE);
            res.setResponseInfo(responseInfo);
        }

        return res;
    }
}
