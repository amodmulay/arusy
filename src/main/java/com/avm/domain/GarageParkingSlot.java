package com.avm.domain;

/**
 * Created with IntelliJ IDEA. User: amodmulay
 * 
 * Garage Parking slot represents a single parking space on a
 * {@link GarageLevel} It contains information about the number assigned to it,
 * the level it belongs to and if it is occupied or empty
 * 
 */
public class GarageParkingSlot {

    private int slotId;
    private int slotLevel;
    private boolean isEmpty = true;

    public GarageParkingSlot(final int slotId, final int slotLevel) {
        this.slotId = slotId;
        this.slotLevel = slotLevel;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public int getSlotLevel() {
        return slotLevel;
    }

    public void setSlotLevel(int slotLevel) {
        this.slotLevel = slotLevel;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }
}
