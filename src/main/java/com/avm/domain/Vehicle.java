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
    private NumberPlate numberPlate;

    public Vehicle(final VehicleType type, final String licenceNumber) {
        this.type = type;
        this.numberPlate = new NumberPlate(licenceNumber);
    }

    public VehicleType getType() {
        return type;
    }

    public NumberPlate getNumberPlate() {
        return numberPlate;
    }
 }
