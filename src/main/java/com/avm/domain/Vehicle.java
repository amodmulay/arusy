package com.avm.domain;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/20/14
 * Time: 9:35 PM
 * To change this template use File | Settings | File Templates.
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
}
