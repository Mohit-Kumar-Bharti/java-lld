package com.mohit.parkinglot;


enum SpotType {
    Car,
    Bike;
}

public class Spot {
     String id;
     SpotType spotType;
     boolean isFree;

    public Spot(String id, SpotType spotType, boolean isFree) {
        this.id = id;
        this.spotType = spotType;
        this.isFree = isFree;
    }
}
