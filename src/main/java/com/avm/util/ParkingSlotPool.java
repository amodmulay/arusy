package com.avm.util;

import com.avm.domain.GarageParkingSlot;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/21/14
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */

@Component
public class ParkingSlotPool {

    private static LinkedList<GarageParkingSlot> emptySlot = new LinkedList<GarageParkingSlot>();
    private static LinkedList<GarageParkingSlot> occupiedSlot = new LinkedList<GarageParkingSlot>();

    private ParkingSlotPool() {
    }

    /**
     * Add a parking slot to the pool. Adding to the pool makes the slot available for reuse by setting the emty flag and removning the vehicle from the
     *
     * @param garageParkingSlot
     */
    public void checkInSlot(final GarageParkingSlot garageParkingSlot) {
        garageParkingSlot.setEmpty(Boolean.TRUE);
        emptySlot.add(garageParkingSlot);
    }

    /**
     * Returns an empty slot and adds it to the list of occupied slots
     *
     * @return
     */
    public GarageParkingSlot checkOutSlot() {
        GarageParkingSlot garageParkingSlot = emptySlot.removeFirst();
        garageParkingSlot.setEmpty(Boolean.FALSE);
        addToOccupiedList(garageParkingSlot);
        return garageParkingSlot;
    }

    private void addToOccupiedList(final GarageParkingSlot garageParkingSlot) {
        occupiedSlot.add(garageParkingSlot);
    }

    public int getEmptySlotSize() {
        return emptySlot.size();
    }

    public int getOccupiedSlotSize() {
        return occupiedSlot.size();
    }

}
