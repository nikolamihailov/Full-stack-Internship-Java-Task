// Car extends Vehicle and it's methods and properties

public class Car extends Vehicle{
    private int safetyRating;
    // constants for fixed values
    private final static double DAILY_RENTAL_COST = 20;
    private final static double DAILY_RENTAL_COST_F0R_LONG_PERIOD = 15;

    public Car(String brand, String model, double value, int rentDays, int safetyRating) {
        super(brand, model, value, rentDays);
        // checking for safety rating 1-5 on creation of new object
        setSafetyRating(safetyRating);
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
        return this.value*0.0001;
    }

    public int getSafetyRating() {
        return safetyRating;
    }

    public void setSafetyRating(int safetyRating) {
        if(safetyRating<1 || safetyRating>5){
            throw new Error("Invalid Safety rating! Rating must be 1-5!");
        }
        this.safetyRating = safetyRating;
    }

    public String toString() {
        return String.format("A car that is valued at $%.2f and has a security rating of %d:\n", getValue(), getSafetyRating());
    }
}
