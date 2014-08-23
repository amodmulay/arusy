package com.avm.util;

import com.avm.domain.GarageParkingSlot;

import java.util.LinkedList;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/21/14
 * Time: 8:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingSlotPool {

    private static LinkedList<GarageParkingSlot> emptySlot = new LinkedList<GarageParkingSlot>();
    private static LinkedList<GarageParkingSlot> occupiedSlot = new LinkedList<GarageParkingSlot>();

    private ParkingSlotPool() {
    }

    /**
     * Add a parking slot to the pool. Adding to the pool makes the slot available for reuse
     *
     * @param garageParkingSlot
     */
    public static void checkInSlot(final GarageParkingSlot garageParkingSlot) {
        garageParkingSlot.setEmpty(Boolean.TRUE);
        emptySlot.add(garageParkingSlot);
    }

    /**
     * Returns an empty slot and adds it to the list of occupied slots
     *
     * @return
     */
    public static GarageParkingSlot checkOutSlot() {
        GarageParkingSlot garageParkingSlot = emptySlot.removeFirst();
        garageParkingSlot.setEmpty(Boolean.FALSE);
        addToOccupiedList(garageParkingSlot);
        return garageParkingSlot;
    }

    private static void addToOccupiedList(final GarageParkingSlot garageParkingSlot) {
        occupiedSlot.add(garageParkingSlot);
    }

    public static int getEmptySlotSize() {
        return emptySlot.size();
    }

    public static int getOccupiedSlotSize() {
        return occupiedSlot.size();
    }

}
