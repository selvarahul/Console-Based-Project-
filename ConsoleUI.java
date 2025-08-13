import java.util.Scanner;

public class ConsoleUI {
    private final IParkingLotService service;
    private final Scanner scanner;

    public ConsoleUI(IParkingLotService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Park Vehicle");
            System.out.println("2. Unpark Vehicle");
            System.out.println("3. Display Status");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    handlePark();
                    break;
                case 2:
                    handleUnpark();
                    break;
                case 3:
                    service.displayStatus();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private void handlePark() {
        System.out.print("Enter Reg Number: ");
        String reg = scanner.nextLine();
        System.out.print("Enter Type (Car/Bike): ");
        String type = scanner.nextLine().toLowerCase(); // handle case-insensitive input

        Vehicle vehicle = null;
        if (type.equals("car")) {
            vehicle = new Car(reg);
        } else if (type.equals("bike")) {
            vehicle = new Bike(reg);
        } else {
            System.out.println("Unsupported vehicle type. Only Car and Bike allowed.");
            return;
        }
        service.parkVehicle(vehicle);
    }

    private void handleUnpark() {
        System.out.print("Enter slot number to unpark: ");
        int slot = scanner.nextInt();
        scanner.nextLine(); // clear buffer after int
        service.unparkVehicle(slot);
    }
}
