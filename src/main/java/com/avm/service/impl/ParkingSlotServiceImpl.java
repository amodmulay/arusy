package com.avm.service.impl;

import com.avm.domain.GarageParkingSlot;
import com.avm.service.ParkingSlotService;
import com.avm.util.ParkingSlotPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 */
@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {
    @Autowired
    private ParkingSlotPool parkingSlotPool;

    @Override
    public GarageParkingSlot getParkingSlot() {
        return parkingSlotPool.checkOutSlot();
    }

    @Override
    public void releaseParkingSlot(final GarageParkingSlot garageParkingSlot) {
        parkingSlotPool.checkInSlot(garageParkingSlot);
    }

    @Override
    public int getEmptySlotCount() {
        return parkingSlotPool.getEmptySlotSize();
    }

    @Override
    public int getOccupiedSlotCount() {
        return parkingSlotPool.getOccupiedSlotSize();
    }


}
