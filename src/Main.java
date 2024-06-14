import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Mitsubishi", "Mirage", 15000, 10, 3);
        //  Safety rating different from 1-5 will throw error
        // Car car2 = new Car("Mitsubishi", "Mirage", 15000, 10, 30);
        Motorcycle motorcycle = new Motorcycle("Triumph", "Tiger Sport 660", 10000, 10, 20);
        CargoVan cargoVan = new CargoVan("Citroen", "Jumper", 20000, 15, 8);

        LocalDate startDate = LocalDate.of(2024,6,3);
        LocalDate returnDate = LocalDate.of(2024,6,13);

        Invoice invoice = new Invoice(car, "John", "Doe", startDate, returnDate);
        Invoice invoice2 = new Invoice(motorcycle, "Mary", "Johnson", startDate, returnDate);
        Invoice invoice3 = new Invoice(cargoVan, "John", "Markson", startDate, returnDate);

        invoice.report();
        invoice2.report();
        invoice3.report();
    }
}