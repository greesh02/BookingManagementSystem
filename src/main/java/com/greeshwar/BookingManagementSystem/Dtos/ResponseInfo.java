package com.greeshwar.BookingManagementSystem.Dtos;

import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;

public class ResponseInfo {
    private ResponseStatus responseStatus;
    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
