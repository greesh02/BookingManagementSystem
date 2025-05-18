package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Dtos.GetMovies.GetMoviesMovieServiceResponseDto;
import com.greeshwar.BookingManagementSystem.Enums.Language;
import com.greeshwar.BookingManagementSystem.Exceptions.CityNotFoundException;
import com.greeshwar.BookingManagementSystem.Models.City;
import com.greeshwar.BookingManagementSystem.Models.Movie;
import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Repositories.CityRepository;
import com.greeshwar.BookingManagementSystem.Repositories.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService{

    private CityRepository cityRepository;
    private ShowRepository showRepository;
    public MovieServiceImpl(CityRepository cityRepository,ShowRepository showRepository){
        this.cityRepository = cityRepository;
        this.showRepository = showRepository;
    }
    public GetMoviesMovieServiceResponseDto getMoviesByCity(Long cityId){
        Optional<City> optionalCity = this.cityRepository.findById(cityId);
        if(optionalCity.isEmpty()){
            throw new CityNotFoundException("city with "+cityId+" not found");
        }

        City city = optionalCity.get();
        List< Show>shows = this.showRepository.findAllByCity(city);
        Set<Movie> movies = new HashSet<>();
        Set<Language> languages = new HashSet<>();
        for(Show show:shows){
            movies.add(show.getMovie());
            languages.add(show.getLanguage());
        }

        GetMoviesMovieServiceResponseDto res = new GetMoviesMovieServiceResponseDto();
        res.setMovies(new ArrayList<>(movies));
        res.setLanguages(new ArrayList<>(languages));
        return res;
    }


}
