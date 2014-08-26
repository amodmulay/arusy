package com.avm.service;

import com.avm.domain.Vehicle;
import com.avm.domain.VehicleType;
import com.avm.util.NumberPlateRegistry;
import com.avm.util.VehicleFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class VehicleFactoryTest extends AbstractTest {

    @Autowired
    VehicleFactory vehicleFactory;

    @Test
    public void getUniqueVehicleTestGood() throws NumberPlateRegistry.VehicleExistsException {
        Vehicle vehicle = vehicleFactory.getVehicleObject(VehicleType.CAR, "MH12DE8428");
        Assert.assertEquals("MH12DE8428", vehicle.getNumberPlate().getNumber());
        vehicleFactory.removeVehicle(vehicle);
    }

    @Test(expected = NumberPlateRegistry.VehicleExistsException.class)
    public void getUniqueVehicleTestBad() {
        Vehicle vehicle = vehicleFactory.getVehicleObject(VehicleType.CAR, "MH12DE8428");
        Assert.assertEquals("MH12DE8428", vehicle.getNumberPlate().getNumber());
        try {
            vehicleFactory.getVehicleObject(VehicleType.CAR, "MH12DE8428");
        } catch (NumberPlateRegistry.VehicleExistsException e) {
            vehicleFactory.removeVehicle(vehicle);
            throw new NumberPlateRegistry.VehicleExistsException(e.getMessage());
        }

    }

}
