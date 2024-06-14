// CargoVan extends Vehicle and it's methods and properties

public class CargoVan extends Vehicle {
    private int driversExperienceInYears;
    // constants for fixed values
    private final static double DAILY_RENTAL_COST = 50;
    private final static double DAILY_RENTAL_COST_F0R_LONG_PERIOD = 40;

    public CargoVan(String brand, String model, double value, int rentDays, int driversExperienceInYears) {
        super(brand, model, value, rentDays);
        this.driversExperienceInYears = driversExperienceInYears;
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
        return this.value * 0.0003;
    }

    public int getDriversExperienceInYears() {
        return driversExperienceInYears;
    }

    public void setDriversExperienceInYears(int driversExperienceInYears) {
        this.driversExperienceInYears = driversExperienceInYears;
    }

    public String toString() {
        return String.format("A cargo van valued at $%.2f and the driver has %d years of experience", getValue(), getDriversExperienceInYears());
    }
}