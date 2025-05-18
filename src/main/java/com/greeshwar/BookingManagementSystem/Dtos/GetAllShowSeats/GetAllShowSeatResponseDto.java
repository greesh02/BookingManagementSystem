package com.greeshwar.BookingManagementSystem.Dtos.GetAllShowSeats;

import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;

import java.util.List;

public class GetAllShowSeatResponseDto {

    private ResponseInfo responseInfo;
    private List<ShowSeat> showSeats;

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }
}
