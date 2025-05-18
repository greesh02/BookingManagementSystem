package com.greeshwar.BookingManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.greeshwar.BookingManagementSystem.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat extends BaseModel{
    private String number;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;


    @ManyToOne
    @JsonIgnore
    private Screen screen;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }
}
