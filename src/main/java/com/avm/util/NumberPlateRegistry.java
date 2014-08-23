package com.avm.util;

import com.avm.domain.NumberPlate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * This class holds the list of all number plates that are registered into the garage system.
 * A number plate cannot exist more than once in this Garage System
 */
public class NumberPlateRegistry {

    private static List<NumberPlate> numbers = new ArrayList<NumberPlate>();

    /**
     * Registers a number into the registry and also performs a uniqueness check
     *
     * @param numberPlate
     * @throws VehicleExistsException throws a runtime exception if the vehicle number plate exists
     */
    public static synchronized void registerNumberPlate(final NumberPlate numberPlate) throws VehicleExistsException {
        if (validateNumberPlateExixts(numberPlate)) {
            throw new VehicleExistsException(String.format("Vehicle number plate %s exists in the garage", numberPlate));
        }
        numbers.add(numberPlate);
    }

    /**
     * removes numberplate from the registry
     *
     * @param numberPlate
     */
    public static void removeNumberPlate(final NumberPlate numberPlate) {
        numbers.remove(numberPlate);
    }

    private static boolean validateNumberPlateExixts(final NumberPlate numberPlate) {
        return numbers.contains(numberPlate);
    }

    public static class VehicleExistsException extends RuntimeException {
        public VehicleExistsException(final String format) {
        }
    }

}
