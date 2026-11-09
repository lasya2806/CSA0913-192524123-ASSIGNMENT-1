public class ParallelArrayDemo {
    public static void main(String[] args) {

        String[] regNo = {
            "TN01AB1111",
            "TN02CD2222"
        };

        String[] type = {
            "Car",
            "Bike"
        };

        String[] entryTime = {
            "09:00",
            "10:00"
        };

        for (int i = 0; i < regNo.length; i++) {
            System.out.println("Vehicle: " + regNo[i]);
            System.out.println("Type: " + type[i]);
            System.out.println("Entry Time: " + entryTime[i]);
            System.out.println();
        }
    }
}
