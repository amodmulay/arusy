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
    void buildGardge();

    /**
     * Provides a place  by assigning a parking slot to the car
     *
     * @param numberPlate
     */
    void parkCar(final String numberPlate);

    /**
     * Removes the car form the parking registry and releases the parking slot resource.
     *
     * @param numberPlate
     */
    void removeCar(final String numberPlate);

    /**
     * Provides a place  by assigning a parking slot to the motorcycle
     *
     * @param numberPlate
     */
    void parkMotorcycle(final String numberPlate);

    /**
     * Removes the motorcycle form the parking registry and releases the parking slot resource.
     *
     * @param numberPlate
     */
    void removeMotorcycle(final String numberPlate);

    /**
     * Blocks a place  by assigning a parking slot to the blocking vehicle
     *
     * @param numberPlate
     */
    void parkBlockingVehicle(final String numberPlate);

    /**
     * Removes the blocking vehicle form the parking registry and releases the parking slot resource.
     *
     * @param numberPlate
     */
    void removeBlockingVehicle(final String numberPlate);

    /**
     * Provides the Garage parking slot associated with the vehicle
     *
     * @param numberPlate
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
     * Count of the number of slots configured in the Garage system
     *
     * @return slot count
     */
    int getNumberOfSlots();

    /**
     * @return enpty slot count
     */
    int getNumberOfEmptySlots();

    /**
     * @return Occupied slot count
     */
    int getNumberOfOccupiedSlots();

}
