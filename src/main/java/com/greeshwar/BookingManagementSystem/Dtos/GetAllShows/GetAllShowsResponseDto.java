package com.greeshwar.BookingManagementSystem.Dtos.GetAllShows;

import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Models.Show;
import java.util.*;
public class GetAllShowsResponseDto {
    private List<Show> shows;
    private ResponseInfo responseInfo;

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }
}
