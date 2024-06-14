// class that will print invoice based on given vehicle and customer data

import java.time.LocalDate;

public class Invoice{
    private Vehicle vehicle;
    private String customerFirstName;
    private String customerLastName;
    private LocalDate startDate;
    private LocalDate returnDate;

    public Invoice(Vehicle vehicle, String customerFirstName, String customerLastName, LocalDate startDate, LocalDate returnDate) {
        this.vehicle = vehicle;
        this.customerFirstName = customerFirstName;
        this.customerLastName = customerLastName;
        this.startDate = startDate;
        this.returnDate = returnDate;
    }

    public void report() {
        StringBuilder sb = new StringBuilder();
        String vehicleDesc = getVehicle().toString();
        String separator = "XXXXXXXX";

        LocalDate now  = LocalDate.now();
        LocalDate endDate = startDate.plusDays(getVehicle().rentDays);


        String customerNames = getCustomerFirstName() + " " + getCustomerLastName();
        String rentedVehicle = getVehicle().getBrand() + " " + getVehicle().getModel();
        String reservedRentDays = getVehicle().getRentDays() +  " days";
        int daysDiff = Math.abs(getStartDate().getDayOfMonth()- getReturnDate().getDayOfMonth());
        String actualRentDays = daysDiff +  " days";

        VehicleCostsCalculator vc = new VehicleCostsCalculator();
        String vehicleRentInsuranceCosts = vc.getCostsInfo(getVehicle(), daysDiff, getVehicle().rentDays);


        sb.append(vehicleDesc).append("\n");
        sb.append(separator).append("\n");
        sb.append("Date: ").append(now).append("\n");
        sb.append("Customer Name: ").append(customerNames).append("\n");
        sb.append("Rented Vehicle: ").append(rentedVehicle).append("\n\n");

        sb.append("Reservation start date: ").append(getStartDate()).append("\n");
        sb.append("Reservation end date: ").append(endDate).append("\n");
        sb.append("Reserved rental days: ").append(reservedRentDays).append("\n\n");

        sb.append("Actual return date: ").append(getReturnDate()).append("\n");
        sb.append("Actual rental days: ").append(actualRentDays).append("\n\n");

        sb.append(vehicleRentInsuranceCosts);
        sb.append(separator).append("\n");

        System.out.print(sb);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}