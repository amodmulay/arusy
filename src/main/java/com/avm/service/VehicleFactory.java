package com.avm.service;

import com.avm.domain.NumberPlate;
import com.avm.domain.Vehicle;
import com.avm.domain.VehicleType;
import com.avm.util.NumberPlateRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Creates unique Vehicles and raises an exception if a Vehicle with the same licence number is already created
 */
public class VehicleFactory {

    private static List<String> licenseNumberList = new ArrayList<String>();

    private VehicleFactory() {
    }

    /**
     *
     * @param vehicleType
     * @param numberPlate
     * @return  Returns a new Vehicle instance
     * @throws NumberPlateRegistry.VehicleExistsException  If vehicle number plate exists then throws this exception
     */
    public static Vehicle getVehicleObject(final VehicleType vehicleType, final String numberPlate) throws NumberPlateRegistry.VehicleExistsException {

        NumberPlateRegistry.registerNumberPlate(new NumberPlate(numberPlate));
        return new Vehicle(vehicleType,numberPlate);
    }

    public static void removeVehicle(final Vehicle vehicle)
    {
        NumberPlateRegistry.removeNumberPlate(vehicle.getNumberPlate());
    }
}
