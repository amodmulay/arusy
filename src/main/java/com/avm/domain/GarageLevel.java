package com.avm.domain;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/20/14
 * Time: 10:00 PM
 * To change this template use File | Settings | File Templates.
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
