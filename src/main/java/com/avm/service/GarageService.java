package com.avm.service;

import com.avm.domain.GarageParkingSlot;
import com.avm.domain.VehicleType;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Provides methods to register a car into the garage and unregister it. It is assumed that there will be only one entry and one exit.
 */
@Service
public interface GarageService {
    /**
     * Provides a place for incoming vehicle by assigning a parking slot to the car
     *
     * @param numberPlate
     */
    void parkCar(final String numberPlate, final VehicleType vehicleType);

    /**
     * Removes the car form the parking registry and releases the parking slot resource.
     *
     * @param numberPlate
     */
    void removeCar(final String numberPlate);


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
