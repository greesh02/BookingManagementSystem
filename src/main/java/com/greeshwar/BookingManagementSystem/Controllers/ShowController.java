package com.greeshwar.BookingManagementSystem.Controllers;

import com.greeshwar.BookingManagementSystem.Dtos.CreateShow.CreateShowRequestDto;
import com.greeshwar.BookingManagementSystem.Dtos.CreateShow.CreateShowResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.GetAllShows.GetAllShowsResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.Show;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Models.User;
import com.greeshwar.BookingManagementSystem.Services.ShowService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/show")
public class ShowController {

    private ShowService showService;
    public ShowController(ShowService showService){
        this.showService = showService;
    }

    @PostMapping("/create")
    CreateShowResponseDto createShow(@RequestBody CreateShowRequestDto req){
        System.out.println("in");
        CreateShowResponseDto res = new CreateShowResponseDto();

        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User currentUser = (User) authentication.getPrincipal();
            Show show = this.showService.createShow(currentUser.getEmail(),req.getMovie_id(),req.getScreen_id(),req.getCity_id(),req.getLanguage(),req.getFeatures(),req.getStart_time());
            res.setShow(show);
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

    @GetMapping("")
    GetAllShowsResponseDto getAllShows(@RequestParam("movie_id") Long movieId,@RequestParam("city_id") Long cityId){
        GetAllShowsResponseDto res= new GetAllShowsResponseDto();
        try{
            List<Show> shows = this.showService.getAllShows(movieId,cityId);
            res.setShows(shows);
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
