import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Destination {
    private String city;
    private String country;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double budget;
    private String weatherInfo;
    private String mapURL;

}

public class TravelItineraryPlanner {
    private static List<Destination> itinerary = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 
            handleChoice(choice);
        } while (choice != 4);
    }

    private static void displayMenu() {
        System.out.println("Travel Itinerary Planner");
        System.out.println("1. Add a destination");
        System.out.println("2. View itinerary");
        System.out.println("3. Calculate total budget");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                addDestination();
                break;
            case 2:
                viewItinerary();
                break;
            case 3:
                calculateTotalBudget();
                break;
            case 4:
                System.out.println("Thank you for using the Travel Itinerary Planner!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addDestination() {
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter country: ");
        String country = scanner.nextLine();
        System.out.print("Enter arrival date (yyyy-mm-dd): ");
        LocalDate arrivalDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter departure date (yyyy-mm-dd): ");
        LocalDate departureDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter budget for this destination: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); 

        Destination destination = new Destination();
        destination.setCity(city);
        destination.setCountry(country);
        destination.setArrivalDate(arrivalDate);
        destination.setDepartureDate(departureDate);
        destination.setBudget(budget);
)
        destination.setWeatherInfo("Sunny");
        destination.setMapURL("https://maps.google.com/");

        itinerary.add(destination);
        System.out.println("Destination added successfully!");
    }

    private static void viewItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is empty. Please add destinations.");
        } else {
            System.out.println("Your Travel Itinerary:");
            for (Destination destination : itinerary) {
                System.out.println("City: " + destination.getCity());
                System.out.println("Country: " + destination.getCountry());
                System.out.println("Arrival Date: " + destination.getArrivalDate());
                System.out.println("Departure Date: " + destination.getDepartureDate());
                System.out.println("Budget: $" + destination.getBudget());
                System.out.println("Weather Information: " + destination.getWeatherInfo());
                System.out.println("Map URL: " + destination.getMapURL());
                System.out.println();
            }
        }
    }

    private static void calculateTotalBudget() {
        double totalBudget = 0;
        for (Destination destination : itinerary) {
            totalBudget += destination.getBudget();
        }
        System.out.println("Total budget for your trip: $" + totalBudget);
    }
}