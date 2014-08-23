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
        Assert.assertEquals(4, garageConfiguration.getGarageLevels());
    }

    @Test
    public void testGetSlotsPerLevel() throws Exception {
        String[] strings = garageConfiguration.getSlotsPerLevel();
        Assert.assertEquals("1", strings[0]);
        Assert.assertEquals("2", strings[1]);
        Assert.assertEquals("3", strings[2]);
        Assert.assertEquals("4", strings[3]);
    }
}
