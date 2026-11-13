
class Vehicle {

    String vehicleNumber;
    String vehicleType;

    // No-argument constructor
    Vehicle() {
        vehicleNumber = "Not Assigned";
        vehicleType = "Unknown";
    }

    // Parameterized constructor
    Vehicle(String number, String type) {
        vehicleNumber = number;
        vehicleType = type;
    }

    void displayVehicle() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Vehicle Type: " + vehicleType);
    }
}

class ParkingSlot {

    int slotNumber;
    boolean occupied;

    // Constructor
    ParkingSlot(int number) {
        slotNumber = number;
        occupied = false;
    }

    void parkVehicle() {
        occupied = true;
        System.out.println("Vehicle parked in slot " + slotNumber);
    }

    void displaySlot() {
        System.out.println("Slot Number: " + slotNumber);
        System.out.println("Occupied: " + occupied);
    }
}

public class ParkingSystemDemo {

    public static void main(String[] args) {

        // Creating vehicle objects
        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Vehicle("TN01AB1111", "Car");

        System.out.println("DEFAULT CONSTRUCTOR");
        v1.displayVehicle();

        System.out.println();

        System.out.println("PARAMETERIZED CONSTRUCTOR");
        v2.displayVehicle();

        System.out.println();

        // Creating parking slot object
        ParkingSlot p1 = new ParkingSlot(101);

        System.out.println("PARKING SLOT DETAILS");
        p1.displaySlot();

        System.out.println();

        p1.parkVehicle();
        p1.displaySlot();
    }
}

