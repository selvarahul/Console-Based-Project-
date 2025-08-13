public class Car extends Vehicle {
    public Car(String regNumber) {
        super(regNumber);
    }
    @Override
    public String getType() {
        return "Car";
    }
}
