package com.avm.domain;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Extends the vehicle class and represent an entity which can be used to block a parking slot for maintenance/reservation etc
 */
public class BlockingVehicle extends Vehicle {

    public BlockingVehicle(NumberPlate numberPlate) {
        this.type = VehicleType.CAR;
        this.numberPlate = numberPlate;
    }

}
