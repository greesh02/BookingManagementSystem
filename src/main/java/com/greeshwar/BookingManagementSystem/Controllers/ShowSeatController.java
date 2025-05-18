package com.greeshwar.BookingManagementSystem.Controllers;


import com.greeshwar.BookingManagementSystem.Dtos.GetAllShowSeats.GetAllShowSeatResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.GetAllShows.GetAllShowsResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Models.ShowSeat;
import com.greeshwar.BookingManagementSystem.Services.ShowSeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/showSeat")
public class ShowSeatController {

    private ShowSeatService showSeatService;
    public ShowSeatController(ShowSeatService showSeatService){
        this.showSeatService = showSeatService;
    }

    @GetMapping("")
    GetAllShowSeatResponseDto getAllShowSeats(@RequestParam("show_id") Long showId){
        GetAllShowSeatResponseDto res = new GetAllShowSeatResponseDto();
        try{
            List<ShowSeat> showSeats = this.showSeatService.getAllShowSeats(showId);
            res.setShowSeats(showSeats);
            ResponseInfo responseInfo = new ResponseInfo();
            responseInfo.setResponseMessage("success");
            responseInfo.setResponseStatus(com.greeshwar.BookingManagementSystem.Enums.ResponseStatus.SUCCESS);
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
