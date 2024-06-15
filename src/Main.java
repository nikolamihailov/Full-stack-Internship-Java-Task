import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // cars
        Car car = new Car("Mitsubishi", "Mirage", 15000, 10, 3);
        Car car2 = new Car("Ford", "Mustang", 18000, 5, 5);
        Car car3 = new Car("BMW", "X7", 68000, 12, 5);

        // motorcycles
        Motorcycle motorcycle = new Motorcycle("Triumph", "Tiger Sport 660", 10000, 10, 20);
        Motorcycle motorcycle2 = new Motorcycle("Honda", "Hornet", 9999, 20, 30);

        // cargo vans
        CargoVan cargoVan = new CargoVan("Citroen", "Jumper", 20000, 15, 8);
        CargoVan cargoVan2 = new CargoVan("Citroen", "Jumper 2", 25000, 6, 4);

        // dates

        LocalDate startDate = LocalDate.of(2024,6,3);
        LocalDate returnDate = LocalDate.of(2024,6,13);
        LocalDate returnDate2 = LocalDate.of(2024,6,8);

        // invoice cars
        Invoice invoice = new Invoice(car, "John", "Doe", startDate, returnDate);
        Invoice invoice2 = new Invoice(car2, "Arnold", "Stallone", startDate, returnDate2);
        Invoice invoice3 = new Invoice(car3, "Steven", "Stallone", startDate, returnDate2);

        // invoice motorcycles
        Invoice invoice4 = new Invoice(motorcycle, "Mary", "Johnson", startDate, returnDate);
        Invoice invoice5 = new Invoice(motorcycle2, "Lily", "Clark", startDate, returnDate);

        // invoice cargo vans
        Invoice invoice6 = new Invoice(cargoVan, "Tom", "Jefferson", startDate, returnDate);
        Invoice invoice7 = new Invoice(cargoVan2, "John", "Markson", startDate, returnDate2);

        invoice.report();
        invoice2.report();
        invoice3.report();
        invoice4.report();
        invoice5.report();
        invoice6.report();
        invoice7.report();

        // invalid examples:

        // safety rating different from 1-5 - throws error
        // Car car2 = new Car("Mitsubishi", "Mirage", 15000, 10, 30);

        // value must be a positive number
        // Car car10 = new Car("Ford", "Mustang", 0, 5, 5);

        // rent days must be a positive number
        // Car car10 = new Car("Ford", "Mustang", 100000, 0, 5);

        // driver's age must be a valid value
        // Motorcycle motorcycle10 = new Motorcycle("Triumph", "Tiger Sport 660", 10000, 10, 5);
        // Motorcycle motorcycle11 = new Motorcycle("Triumph", "Tiger Sport 660", 10000, 10, 0);

        // driver's experience must be a valid value
        // CargoVan cargoVan10 = new CargoVan("Citroen", "Jumper", 20000, 15, -10);

        // invalid customer first name
        // Invoice invoice10 = new Invoice(car, "", "Doe", startDate, returnDate);

        // invalid customer last name
        // Invoice invoice10 = new Invoice(car, "John", "", startDate, returnDate);

        // invalid start date - before start of this year
        // LocalDate startDate10 = LocalDate.of(2023, 5, 6);
        // Invoice invoice10 = new Invoice(car, "John", "Doe", startDate10, returnDate);

        // return date before start date example - throws error
        // LocalDate returnDate2 = LocalDate.of(2024, 5, 10);
        // Invoice invoice10 = new Invoice(car, "John", "Doe", startDate, returnDate2);
    }
}