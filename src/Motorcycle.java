// Motorcycle extends Vehicle and it's methods and properties

public class Motorcycle extends Vehicle{
    private int driversAge;
    // constants for fixed values
    private final static double DAILY_RENTAL_COST = 15;
    private final static double DAILY_RENTAL_COST_F0R_LONG_PERIOD = 10;

    public Motorcycle(String brand, String model, double value, int rentDays, int driversAge ) {
        super(brand, model, value, rentDays);
        this.driversAge = driversAge;
    }

    @Override
    public double getDailyRentalCost() {
        return DAILY_RENTAL_COST;
    }

    @Override
    public double getDailyRentalCostForLongPeriod() {
        return DAILY_RENTAL_COST_F0R_LONG_PERIOD;
    }

    @Override
    public double getDailyInsuranceCost() {
        return this.value*0.0002;
    }

    public int getDriversAge() {
        return driversAge;
    }

    public void setDriversAge(int driversAge) {
        this.driversAge = driversAge;
    }

    public String toString() {
        return String.format("A motorcycle valued at $%.2f and the driver is %d years old:", getValue(), getDriversAge());
    }
}
