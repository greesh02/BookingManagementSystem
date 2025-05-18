package com.greeshwar.BookingManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greeshwar.BookingManagementSystem.Enums.Feature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Screen extends BaseModel{
    private String name;

    @OneToMany(mappedBy = "screen")
    @JsonIgnore
    private List<Seat> seats;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;

    @ManyToOne
    private Theatre theatre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }
}
