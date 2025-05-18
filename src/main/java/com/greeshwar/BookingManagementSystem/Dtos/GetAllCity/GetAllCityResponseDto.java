package com.greeshwar.BookingManagementSystem.Dtos.GetAllCity;

import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Models.City;

import java.util.List;

public class GetAllCityResponseDto {
    private List<City> cities;
    private ResponseInfo responseInfo;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {

        this.cities = cities;
    }

    public ResponseInfo getResponseInfo() {
        return responseInfo;
    }

    public void setResponseInfo(ResponseInfo responseInfo) {
        this.responseInfo = responseInfo;
    }
}
