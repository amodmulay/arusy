package com.avm.service.impl;

import com.avm.domain.*;
import com.avm.exception.GarageException;
import com.avm.service.GarageService;
import com.avm.service.ParkingSlotService;
import com.avm.util.GarageBuilder;
import com.avm.util.GarageRegistry;
import com.avm.util.VehicleFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    private Garage garage;

    @Override
    public void buildGarage() {
        garage = garageBuilder.buildGarage();
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
        Vehicle motorcycle = vehicleFactory.getVehicleObject(VehicleType.MOTORCYCLE, numberPlate);
        parkVehicle(motorcycle);
    }

    @Override
    public void removeMotorcycle(String numberPlate) {
        removeVehicle(numberPlate);
    }

    @Override
    public void parkBlockingVehicle(String numberPlate) {
        Vehicle blockingVehicle = vehicleFactory.getVehicleObject(VehicleType.BLOCKING, numberPlate);
        parkVehicle(blockingVehicle);
    }

    @Override
    public void removeBlockingVehicle(String numberPlate) {
        removeVehicle(numberPlate);
    }

    @Override
    public GarageParkingSlot getVehicleLocation(String numberPlate) {
        return garageRegistry.getParkingSlot(numberPlate);
    }

    @Override
    public List<GarageParkingSlot> getAvailableGarageParkingSlots() {
        List<GarageParkingSlot> slots = new ArrayList<GarageParkingSlot>();
        for (GarageLevel garageLevel : garage.getGarageLevelList()) {
            slots.addAll(garageLevel.getGarageParkingSlots());
        }
        return slots;
    }

    @Override
    public int getNumberOfEmptySlots() {
        return parkingSlotService.getEmptySlotCount();
    }

    @Override
    public int getNumberOfOccupiedSlots() {
        return parkingSlotService.getOccupiedSlotCount();
    }

    private void parkVehicle(final Vehicle vehicle) {
        GarageParkingSlot garageParkingSlot = parkingSlotService.getParkingSlot();
        garageParkingSlot.setVehicle(vehicle);
        garageRegistry.register(vehicle, garageParkingSlot);
    }

    private synchronized void removeVehicle(final String numberPlate) {
        GarageParkingSlot garageParkingSlot = garageRegistry.getParkingSlot(numberPlate);
        if (null == garageParkingSlot) {
            throw new GarageException(String.format("Vehicle with numberplate: %s not available in the garage", numberPlate));
        }
        garageRegistry.deRegister(garageParkingSlot.getVehicle());
        parkingSlotService.releaseParkingSlot(garageParkingSlot);
        vehicleFactory.removeVehicle(garageParkingSlot.getVehicle());
    }

    @Override
    public void prettyPrintConfig() {
        //print configuration status
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("********************************Basic Configuration***********************************");
        System.out.println("Number Of Levels: " + garage.getGarageLevelList().size());
        System.out.println("Number Of Parking slots in the Garage: " + garage.getNoOfParkingSlots());
        for (GarageLevel garageLevel : garage.getGarageLevelList()) {
            System.out.println("********************************Level Configuration***********************************");
            System.out.println("Garage Level: " + garageLevel.getLevel());
            System.out.println("Number of parking slot at level: " + garageLevel.getGarageParkingSlots().size());
        }
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

    }

    @Override
    public void prettyPrint() {
        System.out.println("********************************Current State of Garage***********************************");
        //Print the current state of the Garage
        System.out.println("Number of Empty Parking Slots: " + getNumberOfEmptySlots());
        System.out.println("Number of Occupied Parking Slots: " + getNumberOfOccupiedSlots());
        for (GarageLevel garageLevel : garage.getGarageLevelList()) {
            System.out.println("********************************Level State***********************************");
            System.out.println("Garage Level: " + garageLevel.getLevel());
            List<GarageParkingSlot> parkingSlots = garageLevel.getGarageParkingSlots();
            for (GarageParkingSlot slot : parkingSlots) {
                System.out.println("Garage Slot Id: " + slot.getSlotId());
                if (!slot.isEmpty()) {
                    System.out.println("Slot is empty? " + slot.isEmpty());
                    System.out.println("Vehicle type: " + slot.getVehicle().getType());
                    System.out.println("Vehicle Number Plate: " + slot.getVehicle().getNumberPlate().getNumber());
                } else {
                    System.out.println("Slot is empty? " + slot.isEmpty());
                }
            }
        }
    }
}
