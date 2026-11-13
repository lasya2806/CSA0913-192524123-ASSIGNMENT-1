
class ParkingTicket {
    int ticketNumber;
    String vehicleNumber;
    boolean active;

    ParkingTicket(int number, String vehicle) {
        ticketNumber = number;
        vehicleNumber = vehicle;
        active = true;
    }
}

class ParkingFacility {

    // Static variables shared by all facilities
    static int ticketCounter;
    static int totalOccupancy;

    int capacity;

    // Static block
    static {
        ticketCounter = 1000;
        totalOccupancy = 0;
        System.out.println("Parking System Initialized");
    }

    ParkingFacility(int capacity) {
        this.capacity = capacity;
    }

    // Method returns a ParkingTicket object
    ParkingTicket issueTicket(String vehicleNumber) {

        if (totalOccupancy >= capacity) {
            System.out.println("Parking capacity reached!");
            return null;
        }

        ticketCounter++;
        totalOccupancy++;

        ParkingTicket ticket =
            new ParkingTicket(ticketCounter, vehicleNumber);

        System.out.println("Ticket Issued: " + ticket.ticketNumber);
        System.out.println("Vehicle Number: " + ticket.vehicleNumber);

        return ticket;
    }

    // Method receives a ParkingTicket object
    void exitVehicle(ParkingTicket ticket) {

        if (ticket != null && ticket.active) {
            ticket.active = false;
            totalOccupancy--;

            System.out.println(
                "Vehicle " + ticket.vehicleNumber + " exited."
            );
        } else {
            System.out.println("Invalid ticket!");
        }
    }

    // Static method
    static void displayOccupancy() {
        System.out.println("Total Occupancy: " + totalOccupancy);
    }
}

public class ParkingSystemStaticDemo {

    public static void main(String[] args) {

        ParkingFacility northGate = new ParkingFacility(10);
        ParkingFacility southGate = new ParkingFacility(10);

        System.out.println("\nNORTH GATE");
        ParkingTicket t1 = northGate.issueTicket("TN01AB1111");

        System.out.println("\nSOUTH GATE");
        ParkingTicket t2 = southGate.issueTicket("TN02CD2222");

        System.out.println();
        ParkingFacility.displayOccupancy();

        System.out.println("\nVEHICLE EXIT");
        northGate.exitVehicle(t1);

        // Remove the reference to the ticket
        t1 = null;

        System.out.println();
        ParkingFacility.displayOccupancy();

        System.out.println("\nRemaining ticket: " + t2.ticketNumber);
    }
}

