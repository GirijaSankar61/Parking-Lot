package com.parking.domain;


import lombok.Getter;

public enum VehicleType {
    MOTORCYCLE(1, 10d),
    COMPACT(2, 50d),
    LARGE(3, 100d);
    @Getter
    private final int size;
    @Getter
    private final double pricePerHour;

    VehicleType(int size, double pricePerHour) {
        this.size = size;
        this.pricePerHour = pricePerHour;
    }
}