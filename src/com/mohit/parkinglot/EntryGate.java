package com.mohit.parkinglot;

import java.time.LocalDateTime;
import java.util.UUID;

public class EntryGate {
    ParkingStrategy parkingStrategy;
    public EntryGate(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public Ticket generateTicket(Vehicle v, ParkingLot parkingLot) {
        Spot spot = parkingStrategy.findSpot(v,parkingLot);
        if (spot == null) {
            return null;
        }

        return new Ticket(UUID.randomUUID().toString(),spot, LocalDateTime.now());

    }
}
