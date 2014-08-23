package com.avm.service;

import com.avm.domain.GarageConfiguration;
import com.avm.domain.GarageParkingSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Creates {@link GarageParkingSlot} according to the Garage configuration
 */
@Component
public class GarageBuilder {

    @Autowired
    private GarageConfiguration garageConfiguration;


    /**
     * Builds the garage depending on the state of the garage object
     * @param garage
     */
   /* public void buildGarage(final Garage garage) {
        List<GarageLevel> garageLevels = garage.getGarageLevelList();
        for (GarageLevel garageLevel : garageLevels) {
            int slots = garageLevel.getNumberOfSlots();
            for (int i = 1; i <= slots; i++) {
                ParkingSlotPool.checkInSlot(new GarageParkingSlot(i,garageLevel.getLevel()));
            }
        }
    }*/
}
