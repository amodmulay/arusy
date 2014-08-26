package com.avm.service;

import com.avm.domain.GarageParkingSlot;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/26/14
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ParkingSlotService {

    public GarageParkingSlot getParkingSlot();

    public void releaseParkingSlot(final GarageParkingSlot garageParkingSlot);

    public int getAvailableSlotCount();

    public int getOccupiedSlotCount();
}
