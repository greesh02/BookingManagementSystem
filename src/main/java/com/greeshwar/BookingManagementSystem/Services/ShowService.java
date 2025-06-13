package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;

import java.util.List;

public interface ShowService {

    Show createShow(String userEmail,Long movie_id, Long screen_id, Long city_id, String language, List<String> features, Long startTime);

    List<Show> getAllShows(Long movie_id,Long city_id);


}
