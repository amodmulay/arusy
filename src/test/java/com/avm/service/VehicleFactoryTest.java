package com.avm.service;

import org.junit.Assert;
import org.junit.Test;

import com.avm.domain.Vehicle;
import com.avm.domain.VehicleType;

/**
 * Date: 21.08.14
 * Time: 08:51
 */
public class VehicleFactoryTest{

    @Test
    public void getUniqueVehicleTestGood()
    {
        Vehicle vehicle = VehicleFactory.getUniqueVehicle(VehicleType.CAR, "MH12DE8428");
        Assert.assertEquals("MH12DE8428", vehicle.getLicenceNumber());
        VehicleFactory.removeVehicle(vehicle);
    }

    @Test(expected = VehicleFactory.VehicleExistsException.class)
    public void getUniqueVehicleTestBad()
    {
        Vehicle vehicle = VehicleFactory.getUniqueVehicle(VehicleType.CAR, "MH12DE8428");
        Assert.assertEquals("MH12DE8428", vehicle.getLicenceNumber());
        VehicleFactory.getUniqueVehicle(VehicleType.CAR, "MH12DE8428");

    }

}
