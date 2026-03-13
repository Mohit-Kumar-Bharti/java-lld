package com.mohit.parkinglot;

public interface ParkingStrategy {
    Spot findSpot(Vehicle vehicle, ParkingLot parkingLot);
}

class NearestParkingSpot implements ParkingStrategy {

    @Override
    public Spot findSpot(Vehicle vehicle, ParkingLot parkingLot) {
        for(Spot spot : parkingLot.spots) {
            if ( spot.spotType == mapVehicleToSpotType(vehicle) && spot.isFree) {
                 return spot;
            }
        }
        return  null;
    }

    private SpotType mapVehicleToSpotType( Vehicle v) {
        return switch (v.vehicleType) {
            case Car -> SpotType.Car;
            case BIKE -> SpotType.Bike;
        };
    }
}
