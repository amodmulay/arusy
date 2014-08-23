package com.avm.service;

import com.avm.domain.Garage;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Test class to test {@link GarageBuilder}
 */
public class GarageBuilderTest extends AbstractTest {

    @Autowired
    private GarageBuilder garageBuilder;

    @Test
    public void testBuildGarage() throws Exception {
        Garage garage = garageBuilder.buildGarage();
        Assert.assertEquals(4, garage.getGarageLevelList().size());
        Assert.assertEquals(10, garage.getNoOfParkingSlots());
        Assert.assertEquals(1, garage.getGarageLevelList().get(0).getGarageParkingSlots().size());
        Assert.assertEquals(2, garage.getGarageLevelList().get(1).getGarageParkingSlots().size());
        Assert.assertEquals(3, garage.getGarageLevelList().get(2).getGarageParkingSlots().size());
        Assert.assertEquals(4, garage.getGarageLevelList().get(3).getGarageParkingSlots().size());

    }
}
