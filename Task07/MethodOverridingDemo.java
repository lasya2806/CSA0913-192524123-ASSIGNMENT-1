
class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    // Method to be overridden
    public double calculateFee(int hours) {
        return 0;
    }

    // Final method cannot be overridden
    public final void displayMessage() {
        System.out.println("Welcome to Campus Parking");
    }

    // Override toString()
    @Override
    public String toString() {
        return "Vehicle Registration: " + regNo;
    }

    // Override equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Vehicle)) {
            return false;
        }

        Vehicle other = (Vehicle) obj;
        return regNo.equals(other.regNo);
    }

    // Override hashCode()
    @Override
    public int hashCode() {
        return regNo.hashCode();
    }
}

class TwoWheeler extends Vehicle {
    private final double rate = 10;

    TwoWheeler(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateFee(int hours) {
        return rate * hours;
    }
}

class Car extends Vehicle {
    private final double rate = 30;

    Car(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateFee(int hours) {
        return rate * hours;
    }
}

class ElectricCar extends Vehicle {
    private final double rate = 50;

    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    public double calculateFee(int hours) {
        return rate * hours;
    }
}

public class MethodOverridingDemo {
    public static void main(String[] args) {

        Vehicle bike = new TwoWheeler("TN01AB1111");
        Vehicle car = new Car("TN02CD2222");
        Vehicle ev = new ElectricCar("TN03EF3333");

        bike.displayMessage();

        System.out.println("\nPARKING FEE DETAILS");

        System.out.println(bike + " -> Rs " +
                bike.calculateFee(3));

        System.out.println(car + " -> Rs " +
                car.calculateFee(3));

        System.out.println(ev + " -> Rs " +
                ev.calculateFee(3));

        System.out.println("\nEQUALITY CHECK");

        Vehicle car1 = new Car("TN02CD2222");
        Vehicle car2 = new ElectricCar("TN02CD2222");

        System.out.println("Are vehicles equal? " +
                car1.equals(car2));

        System.out.println("Hash codes are equal? " +
                (car1.hashCode() == car2.hashCode()));
    }
}

