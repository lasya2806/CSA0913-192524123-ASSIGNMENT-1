
class Vehicle {

    String registrationNumber;
    String type;

    Vehicle(String registrationNumber, String type) {
        this.registrationNumber = registrationNumber;
        this.type = type;
    }

    double calculateFee(int minutes) {

        if (minutes == 0) {
            return 0;
        }

        int hours = (minutes + 59) / 60;

        if (type.equalsIgnoreCase("Bike")) {
            return 10 + (hours - 1) * 10;
        } else {
            return 30 + (hours - 1) * 20;
        }
    }
}

class ParkingTicket {

    Vehicle vehicle;
    int slotNumber;
    int minutes;

    ParkingTicket(Vehicle vehicle, int slotNumber, int minutes) {
        this.vehicle = vehicle;
        this.slotNumber = slotNumber;
        this.minutes = minutes;
    }

    double getFee() {
        return vehicle.calculateFee(minutes);
    }
}

class ParkingSystem {

    private ParkingTicket[] tickets = new ParkingTicket[3];
    private double totalCollection = 0;

    // Find a vehicle by registration number
    private boolean isDuplicate(String regNo) {
        for (ParkingTicket ticket : tickets) {
            if (ticket != null &&
                ticket.vehicle.registrationNumber.equals(regNo)) {
                return true;
            }
        }
        return false;
    }

    // Find the next available slot
    private int findFreeSlot() {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                return i;
            }
        }
        return -1;
    }

    // Create vehicle based on type
    private Vehicle createVehicle(String regNo, String type) {

        if (type.equalsIgnoreCase("Bike")) {
            return new Vehicle(regNo, "Bike");
        }

        if (type.equalsIgnoreCase("Car")) {
            return new Vehicle(regNo, "Car");
        }

        return null;
    }

    // Park a vehicle automatically
    public void parkVehicle(String regNo, String type, int minutes) {

        if (minutes < 0) {
            System.out.println("Invalid parking duration");
            return;
        }

        if (isDuplicate(regNo)) {
            System.out.println("Duplicate registration: " + regNo);
            return;
        }

        Vehicle vehicle = createVehicle(regNo, type);

        if (vehicle == null) {
            System.out.println("Unknown vehicle type: " + type);
            return;
        }

        int slot = findFreeSlot();

        if (slot == -1) {
            System.out.println("Parking is full");
            return;
        }

        tickets[slot] = new ParkingTicket(vehicle, slot + 1, minutes);

        System.out.println(regNo + " parked in slot " + (slot + 1));
    }

    // Check whether a slot number is valid
    public void checkSlotNumber(int slotNumber) {

        if (slotNumber < 1 || slotNumber > tickets.length) {
            System.out.println("Invalid slot number: " + slotNumber);
        } else {
            System.out.println("Valid slot number: " + slotNumber);
        }
    }

    // Remove vehicle and calculate fee
    public void exitVehicle(String regNo) {

        for (int i = 0; i < tickets.length; i++) {

            if (tickets[i] != null &&
                tickets[i].vehicle.registrationNumber.equals(regNo)) {

                double fee = tickets[i].getFee();

                System.out.println(
                    regNo + " exited. Parking Fee: Rs " + fee);

                totalCollection += fee;
                tickets[i] = null;
                return;
            }
        }

        System.out.println("Vehicle not found: " + regNo);
    }

    public void displayCollection() {
        System.out.println(
            "Total Daily Collection: Rs " + totalCollection);
    }
}

public class Main {

    public static void main(String[] args) {

        ParkingSystem parking = new ParkingSystem();

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println();

        // Normal operation
        System.out.println("1. NORMAL PARKING");
        parking.parkVehicle("BIKE01", "Bike", 60);
        parking.parkVehicle("CAR01", "Car", 60);

        // Zero-minute parking and last available slot
        System.out.println();
        System.out.println("2. BOUNDARY TESTING");
        parking.parkVehicle("ZERO01", "Car", 0);
        parking.exitVehicle("ZERO01");

        parking.parkVehicle("CAR02", "Car", 120);

        // Parking lot is full
        parking.parkVehicle("BIKE02", "Bike", 30);

        // Invalid cases
        System.out.println();
        System.out.println("3. INVALID CASE TESTING");

        parking.parkVehicle("CAR01", "Car", 60);
        parking.parkVehicle("BUS01", "Bus", 60);
        parking.checkSlotNumber(5);

        // Exit vehicles
        System.out.println();
        System.out.println("4. VEHICLE EXIT");

        parking.exitVehicle("BIKE01");
        parking.exitVehicle("CAR01");
        parking.exitVehicle("CAR02");

        // Daily collection
        System.out.println();
        System.out.println("5. DAILY COLLECTION");

        parking.displayCollection();
    }
}

