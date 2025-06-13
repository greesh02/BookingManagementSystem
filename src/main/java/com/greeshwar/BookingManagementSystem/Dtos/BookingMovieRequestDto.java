package com.greeshwar.BookingManagementSystem.Dtos;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class BookingMovieRequestDto {

    private List<Long> showSeatIds;
    private Long showId;



    public void setShowSeatIds(List<Long> showSeatIds) {
        this.showSeatIds = showSeatIds;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }


    public List<Long> getShowSeatIds() {
        return showSeatIds;
    }

    public Long getShowId() {
        return showId;
    }
}
