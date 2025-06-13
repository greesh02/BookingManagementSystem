package com.greeshwar.BookingManagementSystem.Controllers;

import com.greeshwar.BookingManagementSystem.Dtos.BookingMovieRequestDto;
import com.greeshwar.BookingManagementSystem.Dtos.BookingMovieResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Models.User;
import com.greeshwar.BookingManagementSystem.Services.BookingService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    private BookingService bs;

    public BookingController(BookingService bs){
        this.bs = bs;
    }

    @PostMapping("/book")
    public BookingMovieResponseDto bookMovie( @RequestBody BookingMovieRequestDto req){
        System.out.println("in");
        BookingMovieResponseDto res = new BookingMovieResponseDto();

        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User currentUser = (User) authentication.getPrincipal();
            Ticket t = this.bs.bookTicket(currentUser.getEmail(), req.getShowSeatIds(),req.getShowId());
            res.setTicket(t);
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
