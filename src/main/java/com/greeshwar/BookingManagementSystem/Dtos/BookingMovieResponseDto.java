package com.greeshwar.BookingManagementSystem.Dtos;

import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class BookingMovieResponseDto {
    private Ticket ticket;
    private ResponseInfo responseInfo;

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }


}
