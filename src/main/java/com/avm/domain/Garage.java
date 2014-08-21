package com.avm.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Represents a parking building. This is hierarchically the top most in the pecking order.
 * It holds the levels and the total count of parking spots/slots
 */
public class Garage {

    private List<GarageLevel> garageLevelList;

    public Garage(final List<GarageLevel> garageLevelList) {
        this.garageLevelList = garageLevelList;
    }

    public List<GarageLevel> getGarageLevelList() {
        return garageLevelList;
    }

    public int getNoOfParkingSlots() {
        return calculateParkingSlots();
    }

    private int calculateParkingSlots() {
        int slotCount = 0;
        for (GarageLevel garageLevel : garageLevelList) {
            slotCount = +garageLevel.getNumberofSlots();
        }
        return slotCount * garageLevelList.size();
    }

}
