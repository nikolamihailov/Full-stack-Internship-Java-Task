public class VehicleCostsCalculator{
    public String getCostsInfo(Vehicle vehicle, int actualDays, int rentDays ){
        StringBuilder sb = new StringBuilder();
        double dailyRentCost = 0;
        double dailyInsuranceCost;
        double dailyInsuranceCostWithAdditionOrDiscount = 0;
        double dailyInsuranceCostDiff;
        double totalRent;
        double totalInsurance;
        double earlyReturnRentDiscount = 0;
        double earlyReturnInsuranceDiscount;
        double total;

        if(actualDays<=7){
            dailyRentCost = vehicle.getDailyRentalCost();
            sb.append("Rental cost per day: ").append(this.formatNum("$",dailyRentCost)).append("\n");
        }
        if(actualDays>7){
            dailyRentCost = vehicle.getDailyRentalCostForLongPeriod();
            sb.append("Rental cost per day: ").append(this.formatNum("$", dailyRentCost)).append("\n");
        }

        totalRent = dailyRentCost*rentDays;
        dailyInsuranceCost = vehicle.getDailyInsuranceCost();
        totalInsurance = dailyInsuranceCost*actualDays;

        if(!(vehicle instanceof Car) && !(vehicle instanceof Motorcycle) && !(vehicle instanceof CargoVan) ){
            throw new Error("Invalid vehicle type!");
        }

        if(vehicle instanceof Car){
            if(((Car) vehicle).getSafetyRating()==4 || ((Car) vehicle).getSafetyRating() ==5){
                sb.append("Initial insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n");
                dailyInsuranceCostWithAdditionOrDiscount = dailyInsuranceCost*0.9;
                dailyInsuranceCostDiff = dailyInsuranceCost - dailyInsuranceCostWithAdditionOrDiscount;
                sb.append("Insurance discount per day: ").append(this.formatNum("$", dailyInsuranceCostDiff)).append("\n");
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCostWithAdditionOrDiscount)).append("\n\n");
                totalInsurance = dailyInsuranceCostWithAdditionOrDiscount*actualDays;
            }else{
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n\n");
            }
        }


        if(vehicle instanceof Motorcycle){
            if(((Motorcycle) vehicle).getDriversAge()<25){
                sb.append("Initial insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n");
                dailyInsuranceCostWithAdditionOrDiscount = dailyInsuranceCost*1.2;
                dailyInsuranceCostDiff = dailyInsuranceCostWithAdditionOrDiscount - dailyInsuranceCost;
                sb.append("Insurance addition per day: ").append(this.formatNum("$", dailyInsuranceCostDiff)).append("\n");
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCostWithAdditionOrDiscount)).append("\n\n");
                totalInsurance = dailyInsuranceCostWithAdditionOrDiscount*actualDays;
            }else{
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n\n");
            }
        }

        if(vehicle instanceof CargoVan){
            if(((CargoVan) vehicle).getDriversExperienceInYears()>5){
                sb.append("Initial insurance per day: ").append(this.formatNum("$", dailyInsuranceCost)).append("\n");
                dailyInsuranceCostWithAdditionOrDiscount = dailyInsuranceCost*0.85;
                dailyInsuranceCostDiff = dailyInsuranceCost - dailyInsuranceCostWithAdditionOrDiscount;
                sb.append("Insurance discount per day: ").append(this.formatNum("$", dailyInsuranceCostDiff)).append("\n");
                sb.append("Insurance per day: ").append(this.formatNum("$", dailyInsuranceCostWithAdditionOrDiscount)).append("\n\n");
                totalInsurance = dailyInsuranceCostWithAdditionOrDiscount*actualDays;

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
}