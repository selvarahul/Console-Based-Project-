public class ParkingManager {
    public static void main(String[] args) {
        IParkingLotService service = new ParkingLotServiceImpl(10);
        ConsoleUI ui = new ConsoleUI(service);
        ui.start();
    }
}
