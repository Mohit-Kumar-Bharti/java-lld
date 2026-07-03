package com.mohit.carrental;

enum Status {
    AVAILABLE,
    BOOKED,
}

public class Vehicle {
    String id;
    VehicleType type;
    Status status;
    public Vehicle() {  }
}
