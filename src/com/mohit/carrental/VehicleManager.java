package com.mohit.carrental;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleManager {
    List<Vehicle> vehicles;
    Map<String, Vehicle> vehicleUserMap = new HashMap<String, Vehicle>();
    public VehicleManager(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public Vehicle getVehiclebyID(String id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.id.equals(id)) {
                return vehicle;
            }
        }
        return null;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public boolean reserveVehicle(Vehicle vehicle,User user) {
        for(Vehicle v : vehicles) {
            if(v.id.equals(vehicle.id)) {
                if(v.status == Status.AVAILABLE) {
                    v.status = Status.BOOKED;
                    vehicleUserMap.put(vehicle.id, vehicle);
                    return true;
                }
            }

        }
        return false;
    }

    public void unreserveVehicle(Vehicle vehicle,User user) {
        for(Vehicle v : vehicles) {
            if(v.id.equals(vehicle.id)) {
                v.status = Status.AVAILABLE;
                vehicleUserMap.remove(vehicle.id);
            }
        }

    }


}
