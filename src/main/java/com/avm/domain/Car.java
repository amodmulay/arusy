package com.avm.domain;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Car type vehicle
 */
public class Car extends Vehicle {

    public Car(NumberPlate numberPlate) {
        this.type = VehicleType.CAR;
        this.numberPlate = numberPlate;
    }
}
