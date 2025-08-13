public interface IParkingLotService {
    void parkVehicle(Vehicle vehicle);
    void unparkVehicle(int slotNumber);
    void displayStatus();
}
