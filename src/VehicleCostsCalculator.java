// utility class for calculations of vehicle costs

public class VehicleCostsCalculator{
    private double dailyInsuranceCostWithAdditionOrDiscount = 0;
    private double dailyInsuranceCost;
    private double totalInsurance;
    private double dailyRentCost = 0;
    private double earlyReturnRentDiscount = 0;

    private static final double CAR_HIGH_SAFETY_DISCOUNT_PERCENT = 90;
    // !!! used with +1 because percent is added
    private static final double MOTORCYCLE_YOUNG_DRIVER_ADDITIONAL_PERCENT = 20;
    private static final double CARGOVAN_EXPERIENCED_DRIVER_DISCOUNT_PERCENT = 85;

    public String getCostsInfo(Vehicle vehicle, int actualDays, int rentDays ){
        StringBuilder sb = new StringBuilder();

        if(actualDays<=7){
            dailyRentCost = vehicle.getDailyRentalCost();
        }
        if(actualDays>7){
            dailyRentCost = vehicle.getDailyRentalCostForLongPeriod();
        }
        sb.append("Rental cost per day: ").append(this.formatNum("$",dailyRentCost)).append("\n");

        double totalRent = dailyRentCost * rentDays;
        dailyInsuranceCost = vehicle.getDailyInsuranceCost();
        totalInsurance = dailyInsuranceCost*actualDays;

        if(!(vehicle instanceof Car) && !(vehicle instanceof Motorcycle) && !(vehicle instanceof CargoVan) ){
            throw new Error("Invalid vehicle type!");
        }

        if(vehicle instanceof Car){
            if(((Car) vehicle).getSafetyRating()==4 || ((Car) vehicle).getSafetyRating() ==5){
               sb.append(calcInsurance(CAR_HIGH_SAFETY_DISCOUNT_PERCENT/100, actualDays));
            }else{
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n\n");
            }
        }

        if(vehicle instanceof Motorcycle){
            if(((Motorcycle) vehicle).getDriversAge()<25){
                sb.append(calcInsurance(MOTORCYCLE_YOUNG_DRIVER_ADDITIONAL_PERCENT/100 + 1, actualDays));
            }else{
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n\n");
            }
        }

        if(vehicle instanceof CargoVan){
            if(((CargoVan) vehicle).getDriversExperienceInYears()>5){
                sb.append(calcInsurance(CARGOVAN_EXPERIENCED_DRIVER_DISCOUNT_PERCENT/100, actualDays));
            }else{
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n\n");
            }
        }

        if(actualDays<rentDays){
            double daysDiff = rentDays-actualDays;

            earlyReturnRentDiscount = daysDiff*(dailyRentCost/2);
            double earlyReturnInsuranceDiscount;
            if(dailyInsuranceCostWithAdditionOrDiscount==0){
                earlyReturnInsuranceDiscount = daysDiff*dailyInsuranceCost;
            }else{
                earlyReturnInsuranceDiscount = daysDiff * dailyInsuranceCostWithAdditionOrDiscount;
            }
            sb.append("Early return discount for rent: ").append(this.formatNum("$", earlyReturnRentDiscount)).append("\n");
            sb.append("Early return discount for insurance: ").append(this.formatNum("$", earlyReturnInsuranceDiscount)).append("\n\n");
        }

        sb.append("Total rent: ").append(this.formatNum("$", totalRent - earlyReturnRentDiscount)).append("\n");
        sb.append("Total insurance: ").append(this.formatNum("$", totalInsurance)).append("\n");

        double total = totalRent + totalInsurance - earlyReturnRentDiscount;
        sb.append("Total: ").append(this.formatNum("$", total)).append("\n");

        return  sb.toString();
    }

    public String formatNum(String currency,double num){
        return String.format("%s%.2f", currency, num);
    }

    public String calcInsurance(double insuranceReduceIncreasePercent, int actualDays){
        StringBuilder sb = new StringBuilder();
        sb.append("Initial insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n");
        dailyInsuranceCostWithAdditionOrDiscount = dailyInsuranceCost*insuranceReduceIncreasePercent;
        double dailyInsuranceCostDiff = Math.abs(dailyInsuranceCost - dailyInsuranceCostWithAdditionOrDiscount);
        if(insuranceReduceIncreasePercent>1){
            sb.append("Insurance addition per day: ").append(this.formatNum("$", dailyInsuranceCostDiff)).append("\n");
        }else{
            sb.append("Insurance discount per day: ").append(this.formatNum("$", dailyInsuranceCostDiff)).append("\n");
        }
        sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCostWithAdditionOrDiscount)).append("\n\n");
        totalInsurance = dailyInsuranceCostWithAdditionOrDiscount*actualDays;
        return sb.toString();
    }
}