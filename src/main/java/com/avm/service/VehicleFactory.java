package com.avm.service;

import com.avm.domain.Vehicle;
import com.avm.domain.VehicleType;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates unique Vehicles and raises an exception if a Vehicle with the same licence number is already created
 */
public class VehicleFactory {

    private static List<String> licenseNumberList = new ArrayList<String>();

    private VehicleFactory() {
    }

    /**
     *
     * @param vehicleType
     * @param licenseNumber
     * @return Returns a new Vhicle instance
     * @throws VehicleExistsException If vehicle licence number exists then throws this exception
     */
    public static Vehicle getUniqueVehicle(final VehicleType vehicleType, final String licenseNumber) throws VehicleExistsException {
        if(licenseNumberList.contains(licenseNumber)){
            throw new VehicleExistsException(String.format("Vehicle numberplate %s exists in the garage",licenseNumber));
        }
        licenseNumberList.add(licenseNumber);
        return new Vehicle(vehicleType,licenseNumber);
    }

    public static void removeVehicle(final Vehicle vehicle)
    {
        licenseNumberList.remove(vehicle.getLicenceNumber());
    }

    public static class VehicleExistsException extends RuntimeException {
        public VehicleExistsException(final String format) {
        }
    }
}
