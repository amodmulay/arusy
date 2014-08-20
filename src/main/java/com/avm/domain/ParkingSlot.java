package com.avm.domain;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/20/14
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class ParkingSlot {

    private int slotId;
    private int slotLevel;
    private boolean isEmpty = true;

    public ParkingSlot(final int slotId, final int slotLevel) {
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
