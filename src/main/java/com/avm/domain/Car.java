package com.avm.domain;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/23/14
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class Car extends Vehicle {

    public Car(NumberPlate numberPlate) {
        this.type = VehicleType.CAR;
        this.numberPlate = numberPlate;
    }
}
