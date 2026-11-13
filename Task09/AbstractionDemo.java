
interface Chargeable {

    double chargingFee(int units);

    // Default method
    default void chargingMessage() {
        System.out.println("Charging facility is available");
    }

    // Static method
    static void displayInfo() {
        System.out.println("Electric Vehicle Charging System");
    }
}

// Abstract class
abstract class Vehicle {

    String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    abstract double calculateFee(int hours);

    void displayNumber() {
        System.out.println("Registration Number: " + registrationNumber);
    }
}

// Normal car
class Car extends Vehicle {

    Car(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 30;
    }
}

// Electric car
class ElectricCar extends Vehicle implements Chargeable {

    ElectricCar(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 30;
    }

    @Override
    public double chargingFee(int units) {
        return units * 12;
    }
}

public class AbstractionDemo {

    public static void main(String[] args) {

        Car car = new Car("TN01AB1111");
        ElectricCar electricCar =
                new ElectricCar("TN02CD2222");

        System.out.println("NORMAL CAR");
        car.displayNumber();
        System.out.println("Parking Fee: Rs " +
                car.calculateFee(2));

        System.out.println();

        System.out.println("ELECTRIC CAR");
        electricCar.displayNumber();
        System.out.println("Parking Fee: Rs " +
                electricCar.calculateFee(2));

        System.out.println("Charging Fee: Rs " +
                electricCar.chargingFee(5));

        electricCar.chargingMessage();

        System.out.println();

        Chargeable.displayInfo();
    }
}

