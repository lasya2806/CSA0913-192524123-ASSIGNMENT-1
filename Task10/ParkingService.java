
package parking.service;

import parking.model.ParkingSlot;

public class ParkingService {

    public void parkVehicle(ParkingSlot slot) {

        if (!slot.isOccupied()) {
            slot.setOccupied(true);
            System.out.println(
                "Vehicle parked in slot " +
                slot.getSlotNumber());
        } else {
            System.out.println("Slot is already occupied");
        }
    }

    public void releaseSlot(ParkingSlot slot) {

        slot.setOccupied(false);
        System.out.println(
            "Slot " + slot.getSlotNumber() +
            " is now free");
    }
}

