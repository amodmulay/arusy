package com.avm.domain;

/**
 * Created with IntelliJ IDEA. User: amodmulay
 * <p/>
 * Garage Parking slot represents a single parking space on a
 * {@link GarageLevel} It contains information about the number assigned to it,
 * the level it belongs to and if it is occupied or empty
 */
public class GarageParkingSlot {

    private int slotId;
    private int garageLevel;
    private Vehicle vehicle;
    private boolean isEmpty = Boolean.TRUE;

    /**
     * @param slotId
     * @param slotLevel
     */
    public GarageParkingSlot(final int slotId, final int slotLevel) {
        this.slotId = slotId;
        this.garageLevel = slotLevel;
    }

    public int getSlotId() {
        return slotId;
    }

    public int getGarageLevel() {
        return garageLevel;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setVehicle(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setEmpty(final boolean empty) {
        isEmpty = empty;
    }
}
