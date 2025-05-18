package com.greeshwar.BookingManagementSystem.Models;

import com.greeshwar.BookingManagementSystem.Enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ShowSeatType extends BaseModel{
    @ManyToOne
    private Show show;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private Double price;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
