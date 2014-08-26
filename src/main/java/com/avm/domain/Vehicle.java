package com.avm.domain;

/**
 * Created with IntelliJ IDEA. User: amodmulay
 * <p/>
 * Represents a single entity in the {@link Garage}. It can either be a Car or a
 * Motorcycle. Every Vehicle entity contains a license number which can exist
 * only once in the system.
 */
public abstract class Vehicle {

    protected VehicleType type;
    protected NumberPlate numberPlate;
    protected float chargePerHour;

    public Float getChargePerHour() {
        return chargePerHour;
    }

    public void setChargePerHour(final Float chargePerHour) {
        this.chargePerHour = chargePerHour;
    }

    public VehicleType getType() {
        return type;
    }

    public NumberPlate getNumberPlate() {
        return numberPlate;
    }


}
