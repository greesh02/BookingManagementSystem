package com.greeshwar.BookingManagementSystem.Controllers;

import com.greeshwar.BookingManagementSystem.Dtos.GetAllCity.GetAllCityResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.GetAllPaymentModes.GetAllPaymentModesResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.Payment.PaymentRequestDto;
import com.greeshwar.BookingManagementSystem.Dtos.Payment.PaymentResponseDto;
import com.greeshwar.BookingManagementSystem.Dtos.ResponseInfo;
import com.greeshwar.BookingManagementSystem.Enums.ResponseStatus;
import com.greeshwar.BookingManagementSystem.Models.City;
import com.greeshwar.BookingManagementSystem.Models.Ticket;
import com.greeshwar.BookingManagementSystem.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/paymentMode")
    GetAllPaymentModesResponseDto getAllPaymentModes(){
        GetAllPaymentModesResponseDto res = new GetAllPaymentModesResponseDto();
        try{
            List<String> pm = this.paymentService.getAllPaymentModes();
            res.setPaymentModes(pm);
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

    @PostMapping("")
    public PaymentResponseDto generatePayment(@RequestBody PaymentRequestDto req){
        PaymentResponseDto res = new PaymentResponseDto();
        try{
            Ticket ticket = this.paymentService.proceedPayment( req.getUser_id(), req.getTicket_id(),req.getPayment_mode(), req.getPayment_status());
            res.setTicket(ticket);
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
