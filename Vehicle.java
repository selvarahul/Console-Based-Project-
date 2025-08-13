import java.time.LocalDateTime;
public abstract class Vehicle {
    private final String regNumber;
    private final LocalDateTime entryTime;
    public Vehicle(String regNumber) {
        this.regNumber = regNumber;
        this.entryTime = LocalDateTime.now();
    }
    public String getRegNumber() {
        return regNumber;
    }
    public LocalDateTime getEntryTime() {
        return entryTime;
    }
    public abstract String getType();
}
