package com.greeshwar.BookingManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greeshwar.BookingManagementSystem.Enums.PaymentMode;
import com.greeshwar.BookingManagementSystem.Enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private Double amount;
    private Long reference_id;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JsonIgnore
    private Ticket ticket;


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getReference_id() {
        return reference_id;
    }

    public void setReference_id(Long reference_id) {
        this.reference_id = reference_id;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
