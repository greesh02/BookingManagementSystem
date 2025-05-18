package com.greeshwar.BookingManagementSystem.Controllers;


import com.greeshwar.BookingManagementSystem.Dtos.GetUserTicketsResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Dtos.SignUpRequestDto;
import com.greeshwar.BookingManagementSystem.Dtos.SignUpResponseDto;
import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Models.User;
import com.greeshwar.BookingManagementSystem.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService us;

    public UserController(UserService us){
        this.us = us;
    }

    @PostMapping("/signUp")
    public SignUpResponseDto signup(@RequestBody SignUpRequestDto req){
        SignUpResponseDto res = new SignUpResponseDto();
        try{
            User u = this.us.signup(req.getName(),req.getEmail(),req.getPassword());
            res.setUser(u);
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

    @GetMapping("/{id}/tickets")
    GetUserTicketsResponseDto getTickets(@PathVariable("id") Long userId){
        GetUserTicketsResponseDto res = new GetUserTicketsResponseDto();
        try{
            List<Ticket> tickets = this.us.getAllTickets(userId);
            res.setTickets(tickets);
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
