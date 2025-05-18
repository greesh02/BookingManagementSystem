package com.greeshwar.BookingManagementSystem.Controllers;


import com.greeshwar.BookingManagementSystem.Dtos.GetAllCity.GetAllCityResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.City;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Services.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {
    private CityService cityService;
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("")
    GetAllCityResponseDto getAllCities(){
        GetAllCityResponseDto res = new GetAllCityResponseDto();
        try{
            List<City> cities = this.cityService.getAllCities();
            res.setCities(cities);
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setResponseMessage("success");
            responseInfo.setResponseStatus(ResponseStatus.SUCCESS);
            res.setResponseInfo(responseInfo);

        }
        catch (Exception e){
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setResponseMessage(e.getMessage());
            responseInfo.setResponseStatus(ResponseStatus.FAILURE);
            res.setResponseInfo(responseInfo);
        }

        return res;
    }
}
