package com.mohit.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class BillingService {
    public double calculatePrice(Ticket ticket, LocalDateTime exitTime) {
        Long hours = Duration.between(ticket.entryTime, exitTime).toHours();
        if (hours == 0) {
            return 10;
        }
        return hours * ratePerhour(ticket.parkingSpot.spotType);


    }

    double ratePerhour(SpotType spotType) {
        return switch (spotType) {
            case SpotType.Bike ->  22;
            case SpotType.Car -> 33;
        };
    }
}
