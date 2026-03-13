package com.mohit.parkinglot;

import java.time.LocalDateTime;

public class Ticket {
    String id;
    Spot parkingSpot;
    LocalDateTime entryTime;
    public Ticket(String id, Spot spot, LocalDateTime entryTime) {
        this.id = id;
        this.parkingSpot = spot;
        this.entryTime = entryTime;
    }

    public void printInfo() {
        System.out.println("here is the detail " + ".." + id + ".. " + entryTime);
    }
}
