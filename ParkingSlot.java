public class ParkingSlot implements ISlot {
    private final int slotNumber;
    private boolean occupied;
    private Vehicle vehicle;
    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
    }
    @Override
    public int getSlotNumber() {
        return slotNumber;
    }
    @Override
    public boolean isOccupied() {
        return occupied;
    }
    @Override
    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.occupied = true;
    }
    @Override
    public void unparkVehicle() {
        this.vehicle = null;
        this.occupied = false;
    }
    @Override
    public Vehicle getParkedVehicle() {
        return vehicle;
    }
}
