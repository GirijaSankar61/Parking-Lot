package com.parking;

import com.parking.domain.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.parking.domain.VehicleType.*;
import static com.parking.domain.VehicleType.COMPACT;


@SpringBootApplication
public class ParkingLotApplication {

    public static void main(String[] args) {
//		SpringApplication.run(ParkingLotApplication.class, args);

        ArrayList<Level> levels = new ArrayList<>();
        for (int level = 0; level < 2; level++) {
            ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
            Level level1 = new Level(level, 20, 20, parkingSpots);
            for (int row = 0; row < 2; row++) {
                for (int spot = 0; spot < 10; spot++) {
                    ParkingSpot parkingSpot = new ParkingSpot(level, row, spot, 1, 0, null);
                    parkingSpots.add(parkingSpot);
                }

            }
            levels.add(level1);
        }
        Map<String, ParkingSpot> map=new HashMap<>();
        ParkingLot parkingLot = new ParkingLot(2, levels,map);
//        System.out.println(parkingLot);
//        System.out.println(parkingLot.parkVehicle(new Car("ABC" , COMPACT)));
        for (int i = 0; i < 8; i++) {
            System.out.println(parkingLot.parkVehicle(new Car("ABC" + i, COMPACT)));
            System.out.println(parkingLot.parkVehicle(new Bus("ABC2" + i, LARGE)));
            System.out.println(parkingLot.parkVehicle(new Bike("ABC3" + i, MOTORCYCLE)));
        }
        System.out.println(map);
        System.out.println(map.get("ABC36"));
        
    }

}
