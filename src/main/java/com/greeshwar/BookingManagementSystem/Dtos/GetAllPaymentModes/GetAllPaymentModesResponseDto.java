package com.greeshwar.BookingManagementSystem.Dtos.GetAllPaymentModes;

import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Models.Show;

import java.util.List;

public class GetAllPaymentModesResponseDto {
    private List<String> paymentModes;
    private ResponseInfo responseInfo;

    public List<String> getPaymentModes() {
        return paymentModes;
    }

    public void setPaymentModes(List<String> paymentModes) {
        this.paymentModes = paymentModes;
    }

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }
}
