package com.parking.domain;


import lombok.Data;

@Data
public class Car extends Vehicle {

    public Car(String licensePlate, VehicleType vehicleType) {
        super(licensePlate, vehicleType);
    }
}
