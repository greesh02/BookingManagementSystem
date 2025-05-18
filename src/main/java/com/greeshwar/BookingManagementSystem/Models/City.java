package com.greeshwar.BookingManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "city")
    @JsonIgnore
    private List<Theatre> theatres;

    public List<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(List<Theatre> theatres) {
        this.theatres = theatres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
