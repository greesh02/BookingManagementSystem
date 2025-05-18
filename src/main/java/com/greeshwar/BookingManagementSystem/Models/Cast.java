package com.greeshwar.BookingManagementSystem.Models;


import com.greeshwar.BookingManagementSystem.Enums.CastType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Cast extends BaseModel{
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private CastType castType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
