package com.mohit.parkinglot;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    static void main() {
        Vehicle v = VehicleFactor.createVehicle(UUID.randomUUID().toString(),VehicleType.BIKE);
        v.printInfo();
        List<Spot> spots = new ArrayList<>();
        spots.add(new Spot(UUID.randomUUID().toString(), SpotType.Bike, true));

        ParkingLot parkingLot = new ParkingLot(UUID.randomUUID().toString(), spots);

        EntryGate entryGate = new EntryGate(new NearestParkingSpot());
        Ticket ticket = entryGate.generateTicket(v,parkingLot);
        if (ticket == null) {
            System.out.println("spot not avaiable ");
        } else {
            ticket.printInfo();
        }

        ExitGate exitGate = new ExitGate(new BillingService());
        exitGate.processExit(ticket);




    }
}
