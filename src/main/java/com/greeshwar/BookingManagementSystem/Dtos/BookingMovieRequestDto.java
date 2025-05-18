package com.greeshwar.BookingManagementSystem.Dtos;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class BookingMovieRequestDto {
    private Long userId;
    private List<Long> showSeatIds;
    private Long showId;

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setShowSeatIds(List<Long> showSeatIds) {
        this.showSeatIds = showSeatIds;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Long> getShowSeatIds() {
        return showSeatIds;
    }

    public Long getShowId() {
        return showId;
    }
}
