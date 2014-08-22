package com.avm.service;

import com.avm.domain.Garage;
import com.avm.domain.GarageLevel;
import com.avm.domain.GarageParkingSlot;
import com.avm.util.ParkingSlotPool;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Creates {@link GarageParkingSlot} according to the Garage configuration
 */
public class GarageService {

    /**
     *
     * @param garage
     */
    public void buildGarage(final Garage garage) {
        List<GarageLevel> garageLevels = garage.getGarageLevelList();
        for (GarageLevel garageLevel : garageLevels) {
            int slots = garageLevel.getNumberOfSlots();
            for (int i = 1; i <= slots; i++) {
                ParkingSlotPool.checkInSlot(new GarageParkingSlot(i,garageLevel.getLevel()));
            }
        }
    }
}
