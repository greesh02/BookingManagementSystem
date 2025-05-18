package com.greeshwar.BookingManagementSystem.Dtos.GetAllShows;

public class GetAllShowsRequestDto {
    private Long movie_id;
    private Long city_id;

    public Long getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Long movie_id) {
        this.movie_id = movie_id;
    }

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }
}
