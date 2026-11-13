
import java.util.Scanner;

public class DataRepresentationDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Jagged array representing three floors
        String[][] slots = {
            new String[2],
            new String[3],
            new String[2]
        };

        System.out.print("Enter vehicle number: ");
        String vehicleNo = sc.nextLine();

        System.out.print("Enter floor number (0-2): ");
        int floor = sc.nextInt();

        System.out.print("Enter slot number: ");
        int slot = sc.nextInt();

        if (floor >= 0 && floor < slots.length &&
            slot >= 0 && slot < slots[floor].length) {

            if (slots[floor][slot] == null) {
                slots[floor][slot] = vehicleNo;
                System.out.println("Vehicle parked successfully.");
            } else {
                System.out.println("Slot already occupied.");
            }

        } else {
            System.out.println("Invalid floor or slot.");
        }

        // Calculate parking duration
        int minutes = 90;
        double hours = minutes / 60.0;
        int billableHours = (minutes + 59) / 60;

        System.out.println("Parking duration: " + minutes + " minutes");
        System.out.println("Exact hours: " + hours);
        System.out.println("Billable hours: " + billableHours);

        sc.close();
    }
}

