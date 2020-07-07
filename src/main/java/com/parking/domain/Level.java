package com.parking.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Level {
    final int SPOTS_PER_ROW = 20;
    
    int floor ;
    int availableSpots;
    int numSpots ;
    
    ArrayList<ParkingSpot> parkingSpots;
    
    void spotFreed(){
        this.availableSpots= availableSpots+1;
        
    }
    
    ParkingSpot findAvailableSpot(Vehicle vehicle){
        return parkVehicle(vehicle);
    }
    
    void parkStartingAtSpot(ParkingSpot spot,Vehicle vehicle){
        int size = vehicle.vehicleType.getSize();
        int startingSpot = spot.getSpotNumber();
        for (int i=startingSpot;i<startingSpot+size;i++){
            ParkingSpot parkingSpot = parkingSpots.get(spot.getRow()*10+i);
            parkingSpot.parkVehicle(vehicle);
            this.availableSpots--;
        }
    }
    ParkingSpot parkVehicle(Vehicle vehicle){
        int size = vehicle.vehicleType.getSize();
        int temp=size;
        int prevRow=Integer.MIN_VALUE;
        for(int i=0;i<SPOTS_PER_ROW;i++){
            int recentRow=parkingSpots.get(i).getRow();
            if(parkingSpots.get(i).isAvailable()){
                if(prevRow==Integer.MIN_VALUE)
                    prevRow=recentRow;
                if(prevRow==recentRow){
                    temp--;
                }else{
                    temp=size-1;
                    prevRow=recentRow;
                }
                        
            }else {
                temp=size;
            }
            
            if(temp==0){
                return parkingSpots.get(i-size+1);
            }
        }
        return null;
    }
     void removeVehicle(Vehicle vehicle){
         ArrayList<Integer> spotsTaken = vehicle.getSpotTaken();
         
        
     }
    
}
