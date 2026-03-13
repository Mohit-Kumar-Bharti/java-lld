package com.mohit.parkinglot;


public class Vehicle {
    String id;
    VehicleType vehicleType;

    public Vehicle(String id, VehicleType vehicleType){
        this.id = id;
        this.vehicleType = vehicleType;
    }

    public void printInfo() {
        System.out.println("this is .." +  vehicleType + " .. " + id);
    }


}

class Bike extends Vehicle {
    public Bike(String id) {
        super(id, VehicleType.BIKE);
    }
}


class Car extends Vehicle {
    public Car(String id) {
        super(id, VehicleType.Car);
    }
}

class VehicleFactor{
    public static Vehicle createVehicle(String id, VehicleType type) {
        return switch (type) {
            case VehicleType.BIKE -> new Bike(id);
            case VehicleType.Car -> new Car(id);
        };
    }
}



