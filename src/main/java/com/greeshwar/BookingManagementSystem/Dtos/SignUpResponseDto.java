package com.greeshwar.BookingManagementSystem.Dtos;

import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.User;

public class SignUpResponseDto {
    private User user;
    private ResponseInfo responseInfo;

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
