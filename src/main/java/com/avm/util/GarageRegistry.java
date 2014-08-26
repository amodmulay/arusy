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

    public void register(final Vehicle vehicle, final GarageParkingSlot garageParkingSlot) {
        garageParkingSlotMap.put(vehicle.getNumberPlate().getNumber(), garageParkingSlot);
    }

    public void deRegister(final Vehicle vehicle) {
        garageParkingSlotMap.remove(vehicle.getNumberPlate().getNumber());
    }

    public GarageParkingSlot getParkingSlot(final String numberPlate) {
        return garageParkingSlotMap.get(numberPlate);
    }

    public void resetGarageRegistry() {
        garageParkingSlotMap = new HashMap<String, GarageParkingSlot>();
    }

}
