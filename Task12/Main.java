
import java.time.LocalTime;

// Abstract parent class
abstract class Vehicle {
    protected String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}

// Car
class Car extends Vehicle {
    Car(String registrationNumber) {
        super(registrationNumber);
    }
}

// E-bike
class EBike extends Vehicle {
    EBike(String registrationNumber) {
        super(registrationNumber);
    }
}

// Delivery van
class DeliveryVan extends Vehicle {
    DeliveryVan(String registrationNumber) {
        super(registrationNumber);
    }
}

// One-day visitor pass
class DayPass {
    private double passFee = 100.0;
    private boolean valid = true;

    public double getPassFee() {
        return passFee;
    }

    public boolean isValid() {
        return valid;
    }

    public void usePass() {
        valid = false;
    }
}

// Centralised pricing rules
class PricingRule {

    public static double calculateFee(
            Vehicle vehicle, int hours, LocalTime entryTime) {

        if (vehicle instanceof EBike) {
            return 20.0;
        }

        if (vehicle instanceof DeliveryVan) {

            if (!entryTime.isBefore(
                    LocalTime.of(9, 0)) &&
                entryTime.isBefore(
                    LocalTime.of(17, 0))) {

                return hours * 60.0;
            }

            return hours * 30.0;
        }

        if (vehicle instanceof Car) {
            return hours * 30.0;
        }

        return 0.0;
    }
}

// Parking facility with five floors
class ParkingFacility {

    private int[][] slots = {
        new int[5],
        new int[8],
        new int[6],
        new int[10],
        new int[7]
    };

    public void displaySlots() {

        System.out.println("PARKING FLOOR DETAILS");

        for (int i = 0; i < slots.length; i++) {
            System.out.println(
                "Floor " + (i + 1) +
                " has " + slots[i].length +
                " slots");
        }
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        System.out.println("CAMPUS SMART PARKING SYSTEM");
        System.out.println();

        // Create vehicles
        Vehicle car = new Car("TN01AB1111");
        Vehicle bike = new EBike("TN02CD2222");
        Vehicle van = new DeliveryVan("TN03EF3333");

        // Calculate parking fees
        System.out.println("PARKING FEE DETAILS");

        System.out.println(
            "Car Fee: Rs " +
            PricingRule.calculateFee(
                car, 2, LocalTime.of(10, 0)));

        System.out.println(
            "E-Bike Fee: Rs " +
            PricingRule.calculateFee(
                bike, 2, LocalTime.of(10, 0)));

        System.out.println(
            "Delivery Van Fee: Rs " +
            PricingRule.calculateFee(
                van, 2, LocalTime.of(10, 0)));

        System.out.println();

        // One-day visitor pass
        DayPass pass = new DayPass();

        System.out.println("VISITOR DAY PASS");
        System.out.println(
            "Pass Fee: Rs " + pass.getPassFee());

        System.out.println(
            "Pass Valid: " + pass.isValid());

        pass.usePass();

        System.out.println(
            "Pass Valid After Use: " + pass.isValid());

        System.out.println();

        // Display five floors
        ParkingFacility facility = new ParkingFacility();
        facility.displaySlots();
    }
}

