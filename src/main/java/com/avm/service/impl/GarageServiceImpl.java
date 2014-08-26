package com.avm.service.impl;

import com.avm.domain.GarageParkingSlot;
import com.avm.domain.Vehicle;
import com.avm.domain.VehicleType;
import com.avm.service.GarageService;
import com.avm.service.ParkingSlotService;
import com.avm.util.GarageBuilder;
import com.avm.util.GarageRegistry;
import com.avm.util.VehicleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: amodmulay
 * Implementation for the Garage
 */
@Service
public class GarageServiceImpl implements GarageService {


    @Autowired
    private VehicleFactory vehicleFactory;
    @Autowired
    private GarageRegistry garageRegistry;
    @Autowired
    private ParkingSlotService parkingSlotService;
    @Autowired
    private GarageBuilder garageBuilder;

    @Override
    public void buildGardge() {
        garageBuilder.buildGarage();
    }

    @Override
    public void parkCar(final String numberPlate) {
        Vehicle car = vehicleFactory.getVehicleObject(VehicleType.CAR, numberPlate);
        parkVehicle(car);
    }

    @Override
    public void removeCar(String numberPlate) {
        removeVehicle(numberPlate);
    }

    @Override
    public void parkMotorcycle(String numberPlate) {
        Vehicle motorcycle = vehicleFactory.getVehicleObject(VehicleType.CAR, numberPlate);
        parkVehicle(motorcycle);
    }

    @Override
    public void removeMotorcycle(String numberPlate) {
        removeVehicle(numberPlate);
    }

    @Override
    public void parkBlockingVehicle(String numberPlate) {
        Vehicle blockingVehicle = vehicleFactory.getVehicleObject(VehicleType.CAR, numberPlate);
        parkVehicle(blockingVehicle);
    }

    @Override
    public void removeBlockingVehicle(String numberPlate) {
        removeVehicle(numberPlate);
    }

    @Override
    public GarageParkingSlot getVehicleLocation(String numberPlate) {
        GarageParkingSlot garageParkingSlot = garageRegistry.getParkingSlot(numberPlate);
        return garageParkingSlot;
    }

    @Override
    public List<GarageParkingSlot> getAvailableGarageParkingSlots() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getNumberOfSlots() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getNumberOfEmptySlots() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int getNumberOfOccupiedSlots() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void parkVehicle(final Vehicle vehicle) {
        GarageParkingSlot garageParkingSlot = parkingSlotService.getParkingSlot();
        garageParkingSlot.setVehicle(vehicle);
        garageRegistry.register(vehicle, garageParkingSlot);
    }

    private void removeVehicle(final String numberPlate) {
        GarageParkingSlot garageParkingSlot = garageRegistry.getParkingSlot(numberPlate);
        garageRegistry.deRegister(garageParkingSlot.getVehicle());
    }
}
