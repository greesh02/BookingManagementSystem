package com.greeshwar.BookingManagementSystem.Services;

import com.greeshwar.BookingManagementSystem.Models.City;
import com.greeshwar.BookingManagementSystem.Repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService{
    private CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository){
        this.cityRepository = cityRepository;
    }
    public List<City> getAllCities(){
        return this.cityRepository.findAll();
    }
}
