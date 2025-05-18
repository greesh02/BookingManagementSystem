package com.greeshwar.BookingManagementSystem.Factories;

import com.greeshwar.BookingManagementSystem.Enums.PaymentStatus;
import com.greeshwar.BookingManagementSystem.Strategies.PaymentProcessing.OtherPaymentStrategy;
import com.greeshwar.BookingManagementSystem.Strategies.PaymentProcessing.PaymentProcessingStrategy;
import com.greeshwar.BookingManagementSystem.Strategies.PaymentProcessing.SuccessPaymentStrategy;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class PaymentProcessingFactory {

    private Map<String,PaymentProcessingStrategy> mp;
    // map injected by DI container
    public PaymentProcessingFactory(Map<String,PaymentProcessingStrategy> mp){
        this.mp = mp;
    }

    public PaymentProcessingStrategy getPaymentProcessingStrategy(PaymentStatus paymentStatus){
        if(paymentStatus.equals(PaymentStatus.SUCCESS)){
//            return new SuccessPaymentStrategy();
            return mp.get(paymentStatus.toString());
        }
        else{
//            return new OtherPaymentStrategy(paymentStatus);
            return mp.get("OTHER");
        }

    }
}
