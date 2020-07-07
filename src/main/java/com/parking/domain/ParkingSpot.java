package com.parking.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Objects.nonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingSpot  {
    int level;
    int row;
    int spotNumber;
    int spotSize;
    int vehicleSize;
    Vehicle vehicle;

    boolean isAvailable() {
        return !nonNull(this.vehicle);
    }

    int  parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.spotSize=vehicle.vehicleType.getSize();
        vehicle.enter();
        vehicle.getSpotTaken().add(this.level+""+this.row+""+this.spotNumber);
        return this.spotNumber;
    }

    void removeVehicle(Vehicle vehicle){
        this.vehicle=null;
        this.spotSize=1;
        vehicle.exit();
    }

    @Override
    public String toString() {
        return this.getLevel()+""+this.getRow()+""+this.getSpotNumber();
    }
}
