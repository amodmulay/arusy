package com.avm.service;

import com.avm.domain.GarageParkingSlot;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Service interface for Parking slots.
 */
public interface ParkingSlotService {

    public GarageParkingSlot getParkingSlot();

    public void releaseParkingSlot(final GarageParkingSlot garageParkingSlot);

    public int getEmptySlotCount();

    public int getOccupiedSlotCount();
}
