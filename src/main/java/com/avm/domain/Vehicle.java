package com.avm.domain;

/**
 * Created with IntelliJ IDEA. User: amodmulay
 * 
 * Represents a single entity in the {@link Garage}. It can either be a Car or a
 * Motorcycle. Every Vehicle entity contains a license number which can exist
 * only once in the system.
 */
public class Vehicle {

    private VehicleType type;
    private String licenceNumber;

    public Vehicle(final VehicleType type, final String licenceNumber) {
        this.type = type;
        this.licenceNumber = licenceNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehicle)) {
            return false;
        }

        Vehicle vehicle = (Vehicle) o;

        if (!licenceNumber.equals(vehicle.licenceNumber)) {
            return false;
        }
        if (type != vehicle.type) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return licenceNumber.hashCode();
    }
}
