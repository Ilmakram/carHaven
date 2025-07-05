import java.sql.SQLException;
import java.util.Scanner;

public class CarRentalApp {
    public static void main(String[] args) {
        try {
            DatabaseManager db = new DatabaseManager("jdbc:sqlite:car_rental.db");
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n1. Add Car\n2. Add Customer\n3. Rent Car\n4. Return Car\n5. Exit");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline
                if (choice == 1) {
                    System.out.print("Enter model: ");
                    String model = sc.nextLine();
                    System.out.print("Enter plate: ");
                    String plate = sc.nextLine();
                    System.out.print("Enter rent/day: ");
                    double rent = sc.nextDouble();
                    db.addCar(model, plate, rent);
                    System.out.println("Car added!");
                } else if (choice == 2) {
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();
                    db.addCustomer(name, phone);
                    System.out.println("Customer added!");
                } else if (choice == 3) {
                    System.out.print("Enter car ID: ");
                    int carId = sc.nextInt();
                    System.out.print("Enter customer ID: ");
                    int custId = sc.nextInt();
                    db.rentCar(carId, custId, java.time.LocalDate.now().toString());
                    System.out.println("Car rented!");
                } else if (choice == 4) {
                    System.out.print("Enter car ID to return: ");
                    int carId = sc.nextInt();
                    db.returnCar(carId, java.time.LocalDate.now().toString());
                    System.out.println("Car returned!");
                } else {
                    break;
                }
            }
            sc.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
