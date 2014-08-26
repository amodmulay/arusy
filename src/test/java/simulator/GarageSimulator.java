package simulator;

import com.avm.domain.GarageParkingSlot;
import com.avm.exception.GarageException;
import com.avm.service.AbstractTest;
import com.avm.service.GarageService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class simulates the Garage:
 */
public class GarageSimulator extends AbstractTest {

    private static final String CAR_PLATE_1 = "MH12DE8428";
    private static final String CAR_PLATE_2 = "MH10DE8427";
    private static final String CAR_PLATE_3 = "MH11DE8426";
    private static final String CAR_PLATE_4 = "MH13DE8425";
    private static final String MOTORCYCLE_PLATE_1 = "MH01DE4986";
    private static final String MOTORCYCLE_PLATE_2 = "MH02DE4985";
    private static final String MOTORCYCLE_PLATE_3 = "MH02DE4984";
    @Autowired
    private GarageService garageService;

    @Test
    public void startSimulator() {
        //Let's build the Garage based on provided configuration
        garageService.buildGarage();
        garageService.prettyPrintConfig();
        System.out.println("-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->CAR1");
        garageService.parkCar(CAR_PLATE_1);
        garageService.prettyPrint();
        System.out.println("-->-->-->-->-->---->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->>CAR2");
        garageService.parkCar(CAR_PLATE_2);
        garageService.prettyPrint();
        System.out.println("-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->MOTORCYCLE1");
        garageService.parkMotorcycle(MOTORCYCLE_PLATE_1);
        garageService.prettyPrint();
        System.out.println("<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--MOTORCYCLE1");
        garageService.removeMotorcycle(MOTORCYCLE_PLATE_1);
        garageService.prettyPrint();
        System.out.println("<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--<--CAR1");
        garageService.removeCar(CAR_PLATE_1);
        garageService.prettyPrint();

        try {
            System.out.println("-->-->-->-->-->---->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->>CAR2-REPEAT-ERROR-CONDITION");
            garageService.parkCar(CAR_PLATE_2);
        } catch (GarageException e) {
            System.out.println("################################" + e.getMessage());
        }
        garageService.prettyPrint();
        System.out.println("-->-->-->-->-->---->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->>CAR1");
        garageService.parkCar(CAR_PLATE_1);
        garageService.prettyPrint();
        System.out.println("-->-->-->-->-->---->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->>CAR3");
        garageService.parkCar(CAR_PLATE_3);
        garageService.prettyPrint();
        System.out.println("-->-->-->-->-->---->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->>CAR4");
        garageService.parkCar(CAR_PLATE_4);
        garageService.prettyPrint();
        System.out.println("-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->MOTORCYCLE1");
        garageService.parkMotorcycle(MOTORCYCLE_PLATE_1);
        garageService.prettyPrint();
        System.out.println("-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->MOTORCYCLE2");
        garageService.parkMotorcycle(MOTORCYCLE_PLATE_2);
        garageService.prettyPrint();
        try {
            System.out.println("-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->-->MOTORCYCLE3-FULLPARKING");
            garageService.parkMotorcycle(MOTORCYCLE_PLATE_3);
            garageService.prettyPrint();
        } catch (GarageException e) {
            System.out.println("################################" + e.getMessage());
        }

        GarageParkingSlot garageParkingSlot = garageService.getVehicleLocation(CAR_PLATE_1);
        System.out.println(String.format("Vehicle location query for MH12DE8428: Level: %s and Slot Number: %s", garageParkingSlot.getGarageLevel(), garageParkingSlot.getSlotId()));
    }
}
