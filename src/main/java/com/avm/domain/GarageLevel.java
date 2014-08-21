package com.avm.domain;

/**
 * Created with IntelliJ IDEA. User: amodmulay
 * 
 * Represents a Level/Floor in a {@link Garage}. GarageLevel is defined by the
 * level it belongs to and also contains information regarding number of parking
 * slots that are available at that level
 */
public class GarageLevel {

    private int level;
    private int numberofSlots;

    public GarageLevel(final int level, final int numberofSlots) {
        this.level = level;
        this.numberofSlots = numberofSlots;
    }

    public int getLevel() {
        return level;
    }

    public int getNumberofSlots() {
        return numberofSlots;
    }
}
