
class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
        System.out.println("Vehicle constructor called");
    }

    void displayDetails() {
        System.out.println("Registration Number: " + regNo);
    }
}

class TwoWheeler extends Vehicle {

    TwoWheeler(String regNo) {
        super(regNo);
        System.out.println("TwoWheeler constructor called");
    }
}

class Car extends Vehicle {

    Car(String regNo) {
        super(regNo);
        System.out.println("Car constructor called");
    }
}

class ElectricCar extends Car {

    ElectricCar(String regNo) {
        super(regNo);
        System.out.println("ElectricCar constructor called");
    }

    void chargingDetails() {
        System.out.println("Electric car charging is available");
    }
}

public class VehicleHierarchyDemo {

    public static void main(String[] args) {

        System.out.println("TWO WHEELER DETAILS");
        TwoWheeler bike = new TwoWheeler("TN01AB1111");
        bike.displayDetails();

        System.out.println();

        System.out.println("CAR DETAILS");
        Car car = new Car("TN02CD2222");
        car.displayDetails();

        System.out.println();

        System.out.println("ELECTRIC CAR DETAILS");
        ElectricCar ev = new ElectricCar("TN03EF3333");
        ev.displayDetails();
        ev.chargingDetails();
    }
}

