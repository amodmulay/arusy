package com.avm.domain;

import com.avm.service.AbstractTest;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Test class for testing the configuration of the Garage provided in the arusy-config.properties
 */
public class GarageConfigurationTest extends AbstractTest {

    @Autowired
    private GarageConfiguration garageConfiguration;

    @Test
    public void testGetGarageLevels() throws Exception {
        Assert.assertEquals(2, garageConfiguration.getGarageLevels());
    }

    @Test
    public void testGetSlotsPerLevel() throws Exception {
        String[] strings = garageConfiguration.getSlotsPerLevel();
        Assert.assertEquals("2", strings[0]);
        Assert.assertEquals("4", strings[1]);
    }

    @Test
    public void testGetCarCharge() throws Exception {
        Assert.assertEquals("2.5", garageConfiguration.getChargeForCar());
    }

    @Test
    public void testGetMotorcycleCharge() throws Exception {
        Assert.assertEquals("1", garageConfiguration.getChargeForMotorcycle());
    }

}
