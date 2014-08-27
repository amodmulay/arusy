package com.avm.util;

import com.avm.domain.GarageParkingSlot;
import com.avm.domain.Vehicle;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Register a parking slot into the registry of parked cars. This holds the real time
 * data of which vehicle is parked at what location in the garage
 */
@Component
public class GarageRegistry {

    private Map<String, GarageParkingSlot> garageParkingSlotMap = new HashMap<String, GarageParkingSlot>();

    /**
     * Puts a vehicle in the Number --> slot map
     *
     * @param vehicle           vehicle object
     * @param garageParkingSlot lot to be assigned
     */
    public void register(final Vehicle vehicle, final GarageParkingSlot garageParkingSlot) {
        garageParkingSlotMap.put(vehicle.getNumberPlate().getNumber(), garageParkingSlot);
    }

    /**
     * Removes the vehicle from the map
     *
     * @param vehicle vehicle oject to be deregistered
     */
    public void deRegister(final Vehicle vehicle) {
        garageParkingSlotMap.remove(vehicle.getNumberPlate().getNumber());
    }

    /**
     * Get the parking slot associated with a number plate
     *
     * @param numberPlate the number plate
     * @return Associated parking slot
     */
    public GarageParkingSlot getParkingSlot(final String numberPlate) {
        return garageParkingSlotMap.get(numberPlate);
    }

    public void resetGarageRegistry() {
        garageParkingSlotMap = new HashMap<String, GarageParkingSlot>();
    }

}
