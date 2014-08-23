package com.avm.service;

import com.avm.domain.GarageConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Date: 8/23/14
 * Time: 6:46 PM
 * To change this template use File | Settings | File Templates.
 */

public class GarageServiceTest extends AbstractTest {

    @Autowired
    private GarageConfiguration garageConfiguration;

    @Test
    @Ignore
    public void testBuildGarage() throws Exception {
        //GarageLevel garageLevel = new GarageLevel();
    }
}
