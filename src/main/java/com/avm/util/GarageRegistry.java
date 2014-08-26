package com.avm.util;

import com.avm.domain.GarageParkingSlot;
import com.avm.domain.Vehicle;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
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


}
