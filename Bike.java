public class Bike extends Vehicle {
    public Bike(String regNumber) {
        super(regNumber);
    }
    @Override
    public String getType() {
        return "Bike";
    }
}
