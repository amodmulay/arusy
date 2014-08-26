package com.avm.service;

import com.avm.domain.GarageParkingSlot;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Provides methods to register a car into the garage and unregister it. It is assumed that there will be only one entry and one exit.
 */
public interface GarageService {

    /**
     * Builds the garage based on the configuration
     */
    void buildGarage();

    /**
     * Provides a place  by assigning a parking slot to the car
     *
     * @param numberPlate Vehicle number plate
     */
    void parkCar(final String numberPlate);

    /**
     * Removes the car form the parking registry and releases the parking slot resource.
     *
     * @param numberPlate Vehicle number plate
     */
    void removeCar(final String numberPlate);

    /**
     * Provides a place  by assigning a parking slot to the motorcycle
     *
     * @param numberPlate Vehicle number plate
     */
    void parkMotorcycle(final String numberPlate);

    /**
     * Removes the motorcycle form the parking registry and releases the parking slot resource.
     *
     * @param numberPlate Vehicle number plate
     */
    void removeMotorcycle(final String numberPlate);

    /**
     * Blocks a place  by assigning a parking slot to the blocking vehicle
     *
     * @param numberPlate Vehicle number plate
     */
    void parkBlockingVehicle(final String numberPlate);

    /**
     * Removes the blocking vehicle form the parking registry and releases the parking slot resource.
     *
     * @param numberPlate Vehicle number plate
     */
    void removeBlockingVehicle(final String numberPlate);

    /**
     * Provides the Garage parking slot associated with the vehicle
     *
     * @param numberPlate Vehicle number plate
     * @return GarageParkingSlot Object
     */
    GarageParkingSlot getVehicleLocation(final String numberPlate);

    /**
     * Provides a list of all {@link GarageParkingSlot} configured in the Garage system
     *
     * @return List<GarageParkingSlot>
     */
    List<GarageParkingSlot> getAvailableGarageParkingSlots();

    /**
     * @return enpty slot count
     */
    int getNumberOfEmptySlots();

    /**
     * @return Occupied slot count
     */
    int getNumberOfOccupiedSlots();

    /**
     * Pretty prints the garage status
     */
    void prettyPrint();

    void prettyPrintConfig();
}
