package com.avm.util;

import com.avm.domain.Garage;
import com.avm.service.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Test class to test {@link com.avm.util.GarageBuilder}
 */
public class GarageBuilderTest extends AbstractTest {

    @Autowired
    private GarageBuilder garageBuilder;

    @Test
    public void testBuildGarage() throws Exception {
        Garage garage = garageBuilder.buildGarage();
        Assert.assertEquals(2, garage.getGarageLevelList().size());
        Assert.assertEquals(6, garage.getNoOfParkingSlots());
        Assert.assertEquals(2, garage.getGarageLevelList().get(0).getGarageParkingSlots().size());
        Assert.assertEquals(4, garage.getGarageLevelList().get(1).getGarageParkingSlots().size());
    }
}
