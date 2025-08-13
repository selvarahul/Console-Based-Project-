public interface ISlot {
    int getSlotNumber();
    boolean isOccupied();
    void parkVehicle(Vehicle vehicle);
    void unparkVehicle();
    Vehicle getParkedVehicle();
}
