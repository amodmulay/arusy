package com.avm.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/20/14
 * Time: 9:38 PM
 * To change this template use File | Settings | File Templates.
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
