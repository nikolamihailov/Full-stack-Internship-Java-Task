// base abstract class to be inherited later by Car, Motorcycle, Cargo van


public abstract class Vehicle{
    protected String brand;
    protected String model;
    protected double value;
    protected int rentDays;

    public Vehicle(String brand, String model, double value, int rentDays) {
        this.brand = brand;
        this.model = model;
        this.value = value;
        this.rentDays = rentDays;
    }

    public abstract double getDailyRentalCost();

    public abstract double getDailyRentalCostForLongPeriod();

    public abstract double getDailyInsuranceCost();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDays(int rentDays) {
        this.rentDays = rentDays;
    }
}
