
package parking.app;

import parking.model.ParkingSlot;
import parking.service.ParkingService;

public class Main {

    public static void main(String[] args) {

        ParkingSlot slot = new ParkingSlot(101);

        ParkingService service = new ParkingService();

        System.out.println("CAMPUS PARKING SYSTEM");

        System.out.println(
            "Slot Number: " + slot.getSlotNumber());

        System.out.println(
            "Occupied: " + slot.isOccupied());

        slot.setParkingDuration(120);

        System.out.println(
            "Parking Duration: " +
            slot.getParkingDuration() + " minutes");

        service.parkVehicle(slot);

        System.out.println(
            "Occupied: " + slot.isOccupied());

        service.releaseSlot(slot);

        System.out.println(
            "Occupied: " + slot.isOccupied());

        // Wrapper class and autoboxing
        Integer number = 101;

        System.out.println(
            "Wrapper Class Value: " + number);

        System.out.println(
            "Values Equal: " +
            number.equals(slot.getSlotNumber()));
    }
}

