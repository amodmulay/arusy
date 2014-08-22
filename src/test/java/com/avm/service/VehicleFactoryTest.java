package com.avm.service;

import com.avm.util.NumberPlateRegistry;
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
    public void getUniqueVehicleTestGood() throws NumberPlateRegistry.VehicleExistsException {
        Vehicle vehicle = VehicleFactory.getVehicleObject(VehicleType.CAR, "MH12DE8428");
        Assert.assertEquals("MH12DE8428", vehicle.getNumberPlate().getNumber());
        VehicleFactory.removeVehicle(vehicle);
    }

    @Test(expected = NumberPlateRegistry.VehicleExistsException.class)
    public void getUniqueVehicleTestBad(){
        Vehicle vehicle = VehicleFactory.getVehicleObject(VehicleType.CAR, "MH12DE8428");
        Assert.assertEquals("MH12DE8428", vehicle.getNumberPlate().getNumber());
        try {
            VehicleFactory.getVehicleObject(VehicleType.CAR, "MH12DE8428");
        }
        catch (NumberPlateRegistry.VehicleExistsException e)
        {
            VehicleFactory.removeVehicle(vehicle);
            throw new NumberPlateRegistry.VehicleExistsException(e.getMessage());
        }

    }

}
