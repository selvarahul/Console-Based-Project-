import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
public class ParkingLotServiceImpl implements IParkingLotService {
    private final Map<Integer, Vehicle> slots;
    private final int capacity;
    public ParkingLotServiceImpl(int capacity) {
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }
    @Override
    public void parkVehicle(Vehicle vehicle) {
        for (int i = 1; i <= capacity; i++) {
            if (!slots.containsKey(i)) {
                slots.put(i, vehicle);
                System.out.println(vehicle.getType() + " parked in slot " + i +
                        " at " + vehicle.getEntryTime());
                return;
            }
        }
        System.out.println("Parking is full!");
    }
    @Override
    public void unparkVehicle(int slot) {
        Vehicle vehicle = slots.get(slot);
        if (vehicle != null) {
            LocalDateTime exitTime = LocalDateTime.now();
            long minutes = Duration.between(vehicle.getEntryTime(), exitTime).toMinutes();
            long cost = (minutes / 30) * 30;
            if (minutes % 30 != 0) {
                cost += 30;
            }
            System.out.println(vehicle.getType() + " with reg " + vehicle.getRegNumber() +
                    " removed from slot " + slot);
            System.out.println("Entry Time: " + vehicle.getEntryTime());
            System.out.println("Exit Time: " + exitTime);
            System.out.println("Total Time: " + minutes + " minutes");
            System.out.println("Parking Fee: ₹" + cost);
            slots.remove(slot);
        } else {
            System.out.println("Slot is already empty!");
        }
    }
    @Override
    public void displayStatus() {
        if (slots.isEmpty()) {
            System.out.println("No vehicles parked.");
            return;
        }
        for (Map.Entry<Integer, Vehicle> entry : slots.entrySet()) {
            System.out.println("Slot " + entry.getKey() + ": " + entry.getValue().getRegNumber() +
                    " (" + entry.getValue().getType() + ")");
        }
    }
}
