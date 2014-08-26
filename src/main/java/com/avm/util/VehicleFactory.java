package com.avm.util;

import com.avm.domain.*;
import com.avm.exception.GarageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Creates unique Vehicles and raises an exception if a Vehicle with the same licence number is already created
 */
@Component
public class VehicleFactory {

    @Autowired
    private NumberPlateRegistry numberPlateRegistry;

    private VehicleFactory() {
    }

    /**
     * @param vehicleType type of vehicle
     * @param numberPlate Number plate of the vehicle
     * @return Returns a new Vehicle instance
     * @throws com.avm.exception.GarageException
     *          If vehicle number plate exists then throws this exception
     */
    public Vehicle getVehicleObject(final VehicleType vehicleType, final String numberPlate) throws GarageException {

        NumberPlate newNumberPlate = new NumberPlate(numberPlate);
        numberPlateRegistry.registerNumberPlate(newNumberPlate);
        switch (vehicleType) {
            case CAR:
                return new Car(newNumberPlate);
            case MOTORCYCLE:
                return new Motorcycle(newNumberPlate);
            case BLOCKING:
                return new BlockingVehicle(newNumberPlate);
            default:
                return new BlockingVehicle(newNumberPlate);
        }
    }

    public void removeVehicle(final Vehicle vehicle) {
        numberPlateRegistry.removeNumberPlate(vehicle.getNumberPlate());
    }
}
