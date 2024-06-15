public class VehicleCostsCalculator{
    public double dailyInsuranceCostWithAdditionOrDiscount = 0;
    double dailyInsuranceCost;
    double dailyInsuranceCostDiff;
    double totalInsurance;
    double dailyRentCost = 0;
    double totalRent;
    double earlyReturnRentDiscount = 0;
    double earlyReturnInsuranceDiscount;
    double total;

    public String getCostsInfo(Vehicle vehicle, int actualDays, int rentDays ){
        StringBuilder sb = new StringBuilder();

        if(actualDays<=7){
            dailyRentCost = vehicle.getDailyRentalCost();
        }
        if(actualDays>7){
            dailyRentCost = vehicle.getDailyRentalCostForLongPeriod();
        }
        sb.append("Rental cost per day: ").append(this.formatNum("$",dailyRentCost)).append("\n");

        totalRent = dailyRentCost*rentDays;
        dailyInsuranceCost = vehicle.getDailyInsuranceCost();
        totalInsurance = dailyInsuranceCost*actualDays;

        if(!(vehicle instanceof Car) && !(vehicle instanceof Motorcycle) && !(vehicle instanceof CargoVan) ){
            throw new Error("Invalid vehicle type!");
        }

        if(vehicle instanceof Car){
            if(((Car) vehicle).getSafetyRating()==4 || ((Car) vehicle).getSafetyRating() ==5){
               sb.append( calcInsurance(0.9, actualDays));
            }else{
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n\n");
            }
        }

        if(vehicle instanceof Motorcycle){
            if(((Motorcycle) vehicle).getDriversAge()<25){
                sb.append(calcInsurance(1.2, actualDays));
            }else{
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n\n");
            }
        }

        if(vehicle instanceof CargoVan){
            if(((CargoVan) vehicle).getDriversExperienceInYears()>5){
                sb.append(calcInsurance(0.85, actualDays));
            }else{
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n\n");
            }
        }

        if(actualDays<rentDays){
            double daysDiff = rentDays-actualDays;

            earlyReturnRentDiscount = daysDiff*(dailyRentCost/2);
            earlyReturnInsuranceDiscount = daysDiff*dailyInsuranceCostWithAdditionOrDiscount;

            sb.append("Early return discount for rent: ").append(this.formatNum("$", earlyReturnRentDiscount)).append("\n");
            sb.append("Early return discount for insurance: ").append(this.formatNum("$", earlyReturnInsuranceDiscount)).append("\n\n");
        }

        sb.append("Total rent: ").append(this.formatNum("$", totalRent - earlyReturnRentDiscount)).append("\n");
        sb.append("Total insurance: ").append(this.formatNum("$", totalInsurance)).append("\n");

        total = totalRent+totalInsurance-earlyReturnRentDiscount;
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
        dailyInsuranceCostDiff = Math.abs(dailyInsuranceCost - dailyInsuranceCostWithAdditionOrDiscount);
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