package com.greeshwar.BookingManagementSystem.Models;

import com.greeshwar.BookingManagementSystem.Enums.Feature;
import com.greeshwar.BookingManagementSystem.Enums.Language;
import com.greeshwar.BookingManagementSystem.Enums.MovieRating;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String descripion;

    @ManyToMany
    private List<Cast> cast;
    private Long durationInMillis;

    @Enumerated(EnumType.STRING)
    private MovieRating movieRating;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Language> languages;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Feature> features;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public Long getDurationInMillis() {
        return durationInMillis;
    }

    public void setDurationInMillis(Long durationInMillis) {
        this.durationInMillis = durationInMillis;
    }

    public MovieRating getMovieRating() {
        return movieRating;
    }

    public void setMovieRating(MovieRating movieRating) {
        this.movieRating = movieRating;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public boolean equals(Object obj){
        Movie o = (Movie) obj;
        return (this.getId().equals(o.getId()));
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getId());
    }
}
