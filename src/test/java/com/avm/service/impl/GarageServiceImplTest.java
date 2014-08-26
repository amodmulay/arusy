package com.avm.service.impl;

import com.avm.exception.GarageException;
import com.avm.service.AbstractTest;
import com.avm.service.GarageService;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Test to test the Garage Service. Is actually tested in the simulator!
 */
public class GarageServiceImplTest extends AbstractTest {

    private static final String CAR_PLATE = "MH12DE8428";
    private static final String MOTORCYCLE_PLATE = "MH12DE4986";
    private static final String BLOCKING_PLATE = "BLOCKING";

    @Autowired
    GarageService garageService;

    @Test
    public void testParkingVehicles() throws Exception {

        //build garage
        garageService.buildGarage();

        //verify garage setup
        verifyStaticSetup();
        Assert.assertEquals(6, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(0, garageService.getNumberOfOccupiedSlots());

        //Test for parking cars
        garageService.parkCar(CAR_PLATE);
        verifyStaticSetup();
        Assert.assertEquals(5, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(1, garageService.getNumberOfOccupiedSlots());

        //Test for parking motorcycle
        garageService.parkMotorcycle(MOTORCYCLE_PLATE);
        verifyStaticSetup();
        Assert.assertEquals(4, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(2, garageService.getNumberOfOccupiedSlots());

        //Test for blocking slot
        garageService.parkBlockingVehicle(BLOCKING_PLATE);
        verifyStaticSetup();
        Assert.assertEquals(3, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(3, garageService.getNumberOfOccupiedSlots());

        //Test for removing Motorcycle
        garageService.removeMotorcycle(MOTORCYCLE_PLATE);
        verifyStaticSetup();
        Assert.assertEquals(4, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(2, garageService.getNumberOfOccupiedSlots());

        //Test for removing car
        garageService.removeCar(CAR_PLATE);
        verifyStaticSetup();
        Assert.assertEquals(5, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(1, garageService.getNumberOfOccupiedSlots());

        //Test for removing Blocking
        garageService.removeBlockingVehicle(BLOCKING_PLATE);
        verifyStaticSetup();
        Assert.assertEquals(6, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(0, garageService.getNumberOfOccupiedSlots());


    }

    @Test(expected = GarageException.class)
    public void testParkingVehicleBadCase1() {
        //build garage
        garageService.buildGarage();

        //verify garage setup
        verifyStaticSetup();
        Assert.assertEquals(6, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(0, garageService.getNumberOfOccupiedSlots());

        garageService.parkCar(CAR_PLATE);
        verifyStaticSetup();
        Assert.assertEquals(5, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(1, garageService.getNumberOfOccupiedSlots());

        garageService.parkMotorcycle(CAR_PLATE);
    }

    @Test(expected = GarageException.class)
    public void testParkingVehicleBadCase2() {
        //build garage
        garageService.buildGarage();

        //verify garage setup
        verifyStaticSetup();
        Assert.assertEquals(6, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(0, garageService.getNumberOfOccupiedSlots());

        garageService.parkCar(CAR_PLATE);
        verifyStaticSetup();
        Assert.assertEquals(5, garageService.getNumberOfEmptySlots());
        Assert.assertEquals(1, garageService.getNumberOfOccupiedSlots());

        garageService.removeCar(MOTORCYCLE_PLATE);
    }

    private void verifyStaticSetup() {
        Assert.assertEquals(6, garageService.getAvailableGarageParkingSlots().size());
    }
}
