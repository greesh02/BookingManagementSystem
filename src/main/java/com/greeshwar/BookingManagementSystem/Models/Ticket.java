package com.greeshwar.BookingManagementSystem.Models;

import com.greeshwar.BookingManagementSystem.Enums.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    private String number;

    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

    @ManyToOne
    private User user;
    private Double amount;
    @OneToMany(mappedBy = "ticket")
    private List<Payment> payments;
    @ManyToMany

    private List<ShowSeat> showSeats;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public void setShowSeats(List<ShowSeat> showSeats) {
        this.showSeats = showSeats;
    }
}
