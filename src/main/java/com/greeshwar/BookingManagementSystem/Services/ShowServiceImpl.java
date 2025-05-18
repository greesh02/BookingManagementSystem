package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Enums.Feature;
import com.greeshwar.BookingManagementSystem.Enums.Language;
import com.greeshwar.BookingManagementSystem.Enums.SeatType;
import com.greeshwar.BookingManagementSystem.Enums.ShowSeatStatus;
import com.greeshwar.BookingManagementSystem.Exceptions.CityNotFoundException;
import com.greeshwar.BookingManagementSystem.Exceptions.MovieNotFoundException;
import com.greeshwar.BookingManagementSystem.Models.*;
import com.greeshwar.BookingManagementSystem.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements  ShowService{
    private ShowRepository showRepository;
    private ShowSeatTypeRepository showSeatTypeRepository;
    private ShowSeatRepository showSeatRepository;
    private MovieRepository movieRepository;

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ScreenRepository screenRepository;

    @Autowired
    private SeatRepository seatRepository;

    public ShowServiceImpl(ShowRepository showRepository,ShowSeatTypeRepository showSeatTypeRepository,ShowSeatRepository showSeatRepository,MovieRepository movieRepository){
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.movieRepository = movieRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;

    }

   public Show createShow(Long movie_id, Long screen_id, Long city_id, String language, List<String> features,Long startTime){
       Show show = new Show();
       Movie movie = this.movieRepository.findById(movie_id).get();
       show.setMovie(movie);

       List<Feature> fs = new ArrayList<>();
       for(String f:features){
           fs.add(Feature.valueOf(f));
       }
       show.setFeatures(fs);
       show.setLanguage(Language.valueOf(language));
       show.setCity(this.cityRepository.findById(city_id).get());
       Screen screen = this.screenRepository.findById(screen_id).get();
       show.setScreen(screen);
       show.setStartTime(new Date(startTime));
       show.setEndTime(new Date(startTime+movie.getDurationInMillis()));

        this.showRepository.save(show);
       List<Seat>seats  = this.seatRepository.findAllByScreen(screen);

       for(Seat seat:seats){
           ShowSeat showSeat = new ShowSeat();
           showSeat.setShow(show);
           showSeat.setSeat(seat);
           showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
           this.showSeatRepository.save(showSeat);
       }
       double p = 100;
       for(SeatType seatType:SeatType.values()){
           ShowSeatType showSeatType = new ShowSeatType();
           showSeatType.setSeatType(seatType);
           showSeatType.setShow(show);
           showSeatType.setPrice(p);
           this.showSeatTypeRepository.save(showSeatType);
           p += 50;

       }

       return show;

   }

    public List<Show> getAllShows(Long movie_id,Long city_id){
        // fetch all shows by movie and city
        Optional<City> opcity = this.cityRepository.findById(city_id);

        if(opcity.isEmpty()){
            throw new CityNotFoundException("city id "+city_id+" not found");
        }
        City city = opcity.get();

        Optional<Movie> optionalMovie = this.movieRepository.findById(movie_id);
        if(optionalMovie.isEmpty()){
            throw new MovieNotFoundException("movie id "+movie_id+" not found");
        }

        Movie movie = optionalMovie.get();

        List<Show> shows = this.showRepository.findAllByCityAndMovie(city,movie);

        return shows;

    }



}
