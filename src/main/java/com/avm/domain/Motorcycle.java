package com.avm.domain;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Class represents a motorcycle
 */
public class Motorcycle extends Vehicle {

    public Motorcycle(NumberPlate numberPlate) {
        this.type = VehicleType.MOTORCYCLE;
        this.numberPlate = numberPlate;
    }

}
