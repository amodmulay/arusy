package com.avm.util;

import com.avm.domain.*;
import org.springframework.stereotype.Component;

/**
 * Creates unique Vehicles and raises an exception if a Vehicle with the same licence number is already created
 */
@Component
public class VehicleFactory {

    private VehicleFactory() {
    }

    /**
     * @param vehicleType
     * @param numberPlate
     * @return Returns a new Vehicle instance
     * @throws NumberPlateRegistry.VehicleExistsException
     *          If vehicle number plate exists then throws this exception
     */
    public Vehicle getVehicleObject(final VehicleType vehicleType, final String numberPlate) throws NumberPlateRegistry.VehicleExistsException {

        NumberPlate newNumberPlate = new NumberPlate(numberPlate);
        NumberPlateRegistry.registerNumberPlate(newNumberPlate);
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

    public static void removeVehicle(final Vehicle vehicle) {
        NumberPlateRegistry.removeNumberPlate(vehicle.getNumberPlate());
    }
}
