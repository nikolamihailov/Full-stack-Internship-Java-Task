// base abstract class to be inherited later by Car, Motorcycle, Cargo van

public abstract class Vehicle{
    protected String brand;
    protected String model;
    protected double value;
    protected int rentDays;

    public Vehicle(String brand, String model, double value, int rentDays) {
        setBrand(brand);
        setModel(model);
        setValue(value);
        setRentDays(rentDays);
    }

    public abstract double getDailyRentalCost();

    public abstract double getDailyRentalCostForLongPeriod();

    public abstract double getDailyInsuranceCost();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        if(brand.length()<3){
            throw new IllegalArgumentException("Invalid brand name! Must be at least 3 characters!");
        }
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(model.length()<2){
            throw new IllegalArgumentException("Invalid model name! Must be at least 2 characters!");
        }
        this.model = model;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        if(value<=0){
            throw new IllegalArgumentException("Invalid value! Value must be a positive number!");
        }
        this.value = value;
    }

    public int getRentDays() {
        return rentDays;
    }

    public void setRentDays(int rentDays) {
        if(rentDays<=0){
            throw new IllegalArgumentException("Rent days must be 1 and above!");
        }
        this.rentDays = rentDays;
    }
}
