import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TourPackage {
    private int id;
    private String name;
    private double price;
    private int duration; // in days
    private String type; // e.g., Adventure, Beach, Desert

    public TourPackage(int id, String name, double price, int duration, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.duration = duration;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Price: $" + price + ", Duration: " + duration + " days, Type: " + type;
    }
}

public class TourPackageManagement {

    private static List<TourPackage> packages = new ArrayList<>();

    private static void initializePackages() {
        packages.add(new TourPackage(1, "Beach Paradise", 500.0, 5, "Beach"));
        packages.add(new TourPackage(2, "Mountain Adventure", 700.0, 7, "Adventure"));
        packages.add(new TourPackage(3, "Desert Safari", 300.0, 3, "Desert"));
        packages.add(new TourPackage(4, "Island Escape", 900.0, 10, "Beach"));
    }

    private static void displayAllPackages() {
        System.out.println("Available Tour Packages:");
        for (TourPackage tourPackage : packages) {
            System.out.println(tourPackage);
        }
    }

    private static void viewPackageById(int id) {
        for (TourPackage tourPackage : packages) {
            if (tourPackage.getId() == id) {
                System.out.println("Package Details:");
                System.out.println(tourPackage);
                return;
            }
        }
        System.out.println("Package with ID " + id + " not found.");
    }

    private static int getValidIntegerInput(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializePackages();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View All Packages");
            System.out.println("2. View Package by ID");
            System.out.println("3. Exit");
            int choice = getValidIntegerInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    displayAllPackages();
                    break;
                case 2:
                    int id = getValidIntegerInput(scanner, "Enter package ID: ");
                    viewPackageById(id);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
