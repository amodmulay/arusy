package com.avm.util;

import com.avm.domain.NumberPlate;
import com.avm.exception.GarageException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * This class holds the list of all number plates that are registered into the garage system.
 * A number plate cannot exist more than once in this Garage System
 */
@Component
public class NumberPlateRegistry {

    private List<NumberPlate> numbers = new ArrayList<NumberPlate>();

    /**
     * Registers a number into the registry and also performs a uniqueness check
     *
     * @param numberPlate Vehicle number plate
     * @throws com.avm.exception.GarageException
     *          throws a runtime exception if the vehicle number plate exists
     */
    public synchronized void registerNumberPlate(final NumberPlate numberPlate) throws GarageException {
        if (validateNumberPlateExixts(numberPlate)) {
            throw new GarageException(String.format("Vehicle number plate: %s exists in the garage", numberPlate.getNumber()));
        }
        numbers.add(numberPlate);
    }

    /**
     * removes numberplate from the registry
     *
     * @param numberPlate Vehicle number plate
     */
    public void removeNumberPlate(final NumberPlate numberPlate) {
        numbers.remove(numberPlate);
    }

    private boolean validateNumberPlateExixts(final NumberPlate numberPlate) {
        return numbers.contains(numberPlate);
    }

    public void resetNumberPlateRegistry() {
        numbers = new ArrayList<NumberPlate>();
    }

}
