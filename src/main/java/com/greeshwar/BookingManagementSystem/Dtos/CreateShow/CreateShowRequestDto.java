package com.greeshwar.BookingManagementSystem.Dtos.CreateShow;

import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;

import java.util.List;

public class CreateShowRequestDto {
    private Long movie_id;
    private Long screen_id;
    private Long city_id;
    private String language;
    private Long start_time;
    private List<String> features;



    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Long getScreen_id() {
        return screen_id;
    }

    public void setScreen_id(Long screen_id) {
        this.screen_id = screen_id;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Long getStart_time() {
        return start_time;
    }

    public void setStart_time(Long start_time) {
        this.start_time = start_time;
    }
}
