package com.parking.domain;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static java.time.LocalDateTime.now;

@NoArgsConstructor
@EqualsAndHashCode()
@Getter
public abstract class Vehicle {
    String licensePlate;
    @EqualsAndHashCode.Exclude LocalDateTime entryTime;
    @EqualsAndHashCode.Exclude LocalDateTime exitTime;
    @EqualsAndHashCode.Exclude ArrayList<String> spotTaken;
    @EqualsAndHashCode.Exclude VehicleType vehicleType;

    public Vehicle(String licensePlate, VehicleType vehicleType) {
        this.licensePlate = licensePlate;
        this.vehicleType = vehicleType;
    }

    Double calculateFair(LocalDateTime entryTime, LocalDateTime exitTime) {
        Duration duration = Duration.between(entryTime, exitTime);
        return duration.toHours() * this.vehicleType.getPricePerHour();
    }

    void enter() {
        this.entryTime = now();
    }

    void exit() {
        this.exitTime = now();
    }


}
