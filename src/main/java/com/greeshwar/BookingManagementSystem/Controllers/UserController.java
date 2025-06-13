package com.greeshwar.BookingManagementSystem.Controllers;


import com.greeshwar.BookingManagementSystem.Dtos.GetUserTicketsResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Dtos.SignUpRequestDto;
import com.greeshwar.BookingManagementSystem.Dtos.SignUpResponseDto;
import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Models.User;
import com.greeshwar.BookingManagementSystem.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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



    @GetMapping("/tickets")
    GetUserTicketsResponseDto getTickets(){
        GetUserTicketsResponseDto res = new GetUserTicketsResponseDto();
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User currentUser = (User) authentication.getPrincipal();
            List<Ticket> tickets = this.us.getAllTickets(currentUser.getEmail());
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

    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        // current user info
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = (User) authentication.getPrincipal();
        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        List <User> users = us.allUsers();
        return ResponseEntity.ok(users);
    }



}
