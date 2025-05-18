package com.greeshwar.BookingManagementSystem.Dtos;

import com.greeshwar.BookingManagementSystem.Models.Ticket;

import java.util.List;

public class GetUserTicketsResponseDto {
    private List<Ticket> tickets;
    private ResponseInfo responseInfo;

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
