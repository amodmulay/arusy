package com.avm.util;

import com.avm.domain.Garage;
import com.avm.domain.GarageConfiguration;
import com.avm.domain.GarageLevel;
import com.avm.domain.GarageParkingSlot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Creates {@link GarageParkingSlot} according to the Garage configuration
 */
@Component
public class GarageBuilder {

    @Autowired
    private GarageConfiguration garageConfiguration;

    @Autowired
    private ParkingSlotPool parkingSlotPool;

    @Autowired
    private NumberPlateRegistry numberPlateRegistry;

    @Autowired
    private GarageRegistry garageRegistry;

    /**
     * Builds the garage based on the configuration provided in the configuration file
     */
    public Garage buildGarage() {
        resetGarage();
        //first validate the configuration settings
        garageConfiguration.validateConfiguration();
        //Actually there is no need to call for number of levels.
        String[] slotsPerLevel = garageConfiguration.getSlotsPerLevel();

        List<GarageLevel> garageLevels = new ArrayList<GarageLevel>();
        for (int i = 1; i <= slotsPerLevel.length; i++) {
            //this means at level i the number of slots are slotsPerLevel[i-1]
            int slots = Integer.parseInt(slotsPerLevel[i - 1]);
            List<GarageParkingSlot> garageParkingSlots = new ArrayList<GarageParkingSlot>();
            //Create a list of slot objects
            while (slots != 0) {
                GarageParkingSlot parkingSlot = new GarageParkingSlot(slots, i);
                //add garage slot to the pool of slots
                parkingSlotPool.checkInSlot(parkingSlot);
                garageParkingSlots.add(parkingSlot);
                slots--;
            }

            garageLevels.add(new GarageLevel(i, garageParkingSlots));
        }
        return new Garage(garageLevels);
    }

    /**
     * Rests all the values in the garage
     */
    public void resetGarage() {
        parkingSlotPool.resetParkingSlotPool();
        numberPlateRegistry.resetNumberPlateRegistry();
        garageRegistry.resetGarageRegistry();
    }
}
