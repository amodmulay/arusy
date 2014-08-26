package com.avm.util;

import com.avm.domain.GarageParkingSlot;
import com.avm.exception.GarageException;
import org.springframework.stereotype.Component;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * A pool of parkings slots. This Object hold a list of empty and occupied parking slots in the Garage
 */

@Component
public class ParkingSlotPool {

    private LinkedList<GarageParkingSlot> emptySlot = new LinkedList<GarageParkingSlot>();
    private LinkedList<GarageParkingSlot> occupiedSlot = new LinkedList<GarageParkingSlot>();

    private ParkingSlotPool() {
    }

    /**
     * Add a parking slot to the pool. Adding to the pool makes the slot available for reuse by setting the empty flag and removing the vehicle from the
     *
     * @param garageParkingSlot new or recycled parking slot
     */
    public synchronized void checkInSlot(final GarageParkingSlot garageParkingSlot) {
        garageParkingSlot.setEmpty(Boolean.TRUE);
        emptySlot.add(garageParkingSlot);
        occupiedSlot.remove(garageParkingSlot);
    }

    /**
     * Returns an empty slot and adds it to the list of occupied slots
     *
     * @return empty GarageParkingSlot
     */
    public synchronized GarageParkingSlot checkOutSlot() {
        if (emptySlot.size() == 0) {
            throw new GarageException("Garage is full. Better luck next time!");
        }
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

    public void resetParkingSlotPool() {
        emptySlot = new LinkedList<GarageParkingSlot>();
        occupiedSlot = new LinkedList<GarageParkingSlot>();
    }

}
