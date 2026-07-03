package com.mohit.carrental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Main {
    static void main() {


        List<User> users = new ArrayList<>();
        VehicleManager vehicleManager;

        Vehicle vehicle = new Vehicle();
        vehicle.id = UUID.randomUUID().toString();
        vehicle.status = Status.AVAILABLE;

        vehicleManager  = new VehicleManager(Arrays.asList(vehicle));

        User user = new User();
        user.username = "mohit";
        user.userId = UUID.randomUUID().toString();


        boolean isDone = vehicleManager.reserveVehicle(vehicle,user);
        if(isDone){
            System.out.println("Vehicle Reserved");
        } else {
            System.out.println("Vehicle Not Reserved");
        }

        isDone = vehicleManager.reserveVehicle(vehicle,user);
        if(isDone){
            System.out.println("Vehicle Reserved");
        } else {
            System.out.println("Vehicle Not Reserved");
        }
        vehicleManager.unreserveVehicle(vehicle,user);



    }
}