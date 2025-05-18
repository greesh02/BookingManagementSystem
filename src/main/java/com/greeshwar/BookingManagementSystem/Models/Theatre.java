package com.greeshwar.BookingManagementSystem.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Entity
@Getter
@Setter
public class Theatre extends BaseModel{

    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "theatre")
    @JsonIgnore
    private List<Screen>screens;
    @ManyToOne
    private City city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
