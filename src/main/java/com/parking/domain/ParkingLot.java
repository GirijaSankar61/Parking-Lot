package com.parking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLot {
    int numOfLevels;
    ArrayList<Level> levels;
    Map<String,ParkingSpot> vehicleMaps;
    
    public ParkingSpot parkVehicle(Vehicle vehicle){
        for(Level level:levels){
            ParkingSpot parkingSpot=level.findAvailableSpot(vehicle);
            if(Objects.nonNull(parkingSpot)){
                level.parkStartingAtSpot(parkingSpot,vehicle);
                vehicleMaps.put(vehicle.getLicensePlate(),parkingSpot);
                return parkingSpot;
            }
        }
        return null;
    }
    
    double removeVehicle(String noPlate){
        ParkingSpot parkingSpot=vehicleMaps.get(noPlate);
        System.out.println("removing vehicle from parking spot"+parkingSpot);
        ArrayList<String> spotTaken = parkingSpot.getVehicle().getSpotTaken();
        freeSpotTaken(spotTaken);
    }

    private void freeSpotTaken(ArrayList<String> spotTaken) {
        
    }


}
