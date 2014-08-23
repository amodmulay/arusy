package com.avm.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA. User: amodmulay
 * <p/>
 * Represents a Level/Floor in a {@link Garage}. GarageLevel is defined by the
 * level it belongs to and also contains information regarding number of parking
 * slots that are available at that level
 */
public class GarageLevel {

    private int level;
    private List<GarageParkingSlot> garageParkingSlots;

    public GarageLevel(final int level, final List<GarageParkingSlot> garageParkingSlots) {
        this.level = level;
        this.garageParkingSlots = garageParkingSlots;
    }

    public int getLevel() {
        return level;
    }

    public List<GarageParkingSlot> getGarageParkingSlots() {
        return garageParkingSlots;
    }
}
