package com.avm.util;

import com.avm.domain.Vehicle;
import com.avm.domain.VehicleType;
import com.avm.exception.GarageException;
import com.avm.service.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class VehicleFactoryTest extends AbstractTest {

    @Autowired
    VehicleFactory vehicleFactory;

    @Test
    public void getUniqueVehicleTestGood() throws GarageException {
        Vehicle vehicle = vehicleFactory.getVehicleObject(VehicleType.CAR, "MH12DE8428");
        Assert.assertEquals("MH12DE8428", vehicle.getNumberPlate().getNumber());
        vehicleFactory.removeVehicle(vehicle);
    }

    @Test(expected = GarageException.class)
    public void getUniqueVehicleTestBad() {
        Vehicle vehicle = vehicleFactory.getVehicleObject(VehicleType.CAR, "MH12DE8428");
        Assert.assertEquals("MH12DE8428", vehicle.getNumberPlate().getNumber());
        try {
            vehicleFactory.getVehicleObject(VehicleType.CAR, "MH12DE8428");
        } catch (GarageException e) {
            vehicleFactory.removeVehicle(vehicle);
            throw new GarageException(e.getMessage());
        }

    }

}
