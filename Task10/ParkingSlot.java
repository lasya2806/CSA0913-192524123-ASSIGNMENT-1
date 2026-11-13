
package parking.model;

public class ParkingSlot {

    private Integer slotNumber;
    private boolean occupied;
    private int parkingDuration;

    public ParkingSlot(Integer slotNumber) {
        setSlotNumber(slotNumber);
        occupied = false;
        parkingDuration = 0;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        if (slotNumber == null || slotNumber <= 0) {
            throw new IllegalArgumentException(
                "Invalid slot number");
        }
        this.slotNumber = slotNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getParkingDuration() {
        return parkingDuration;
    }

    public void setParkingDuration(int parkingDuration) {
        if (parkingDuration < 0) {
            throw new IllegalArgumentException(
                "Duration cannot be negative");
        }
        this.parkingDuration = parkingDuration;
    }
}

