package com.greeshwar.BookingManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greeshwar.BookingManagementSystem.Enums.Feature;
import com.greeshwar.BookingManagementSystem.Enums.Language;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Entity(name ="showTable")
@Getter
@Setter
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private City city;

    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;

    @Enumerated(EnumType.STRING)
    private Language language;

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }
}
