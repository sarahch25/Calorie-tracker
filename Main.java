import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Set daily goals
        System.out.print("Enter your daily calorie goal: ");
        int calorieGoal = scanner.nextInt();
        System.out.print("Enter your daily protein goal (grams): ");
        int proteinGoal = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        CalorieTracker tracker = new CalorieTracker(calorieGoal, proteinGoal);

        System.out.println("Welcome to the Calorie Tracker!");

        // Display predefined food items
        System.out.println("Available food items:");
        displayFoodItems();

        while (true) {
            System.out.print("Choose an option: (1) Select food item, (2) Add custom food, (exit to finish): ");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("exit")) {
                break;
            }

            if (option.equals("1")) {
                System.out.print("Select food item by number: ");
                int index = scanner.nextInt() - 1; // Convert to zero-based index
                scanner.nextLine(); // Consume the newline character
                if (index >= 0 && index < FoodDatabase.getFoodItems().size()) {
                    FoodItem selectedItem = FoodDatabase.getFoodItems().get(index);

                    // Prompt for quantity
                    System.out.printf("Enter the quantity in %s: ", selectedItem.getMeasurementUnit());
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    tracker.addFoodItem(selectedItem, quantity); // Adjusted to pass quantity
                    System.out.printf("Added %s (quantity: %d %s) to your tracker.%n",
                            selectedItem.getName(), quantity, selectedItem.getMeasurementUnit());
                } else {
                    System.out.println("Invalid selection, please try again.");
                }
            } else if (option.equals("2")) {
                // Adding custom food item
                System.out.print("Enter food name: ");
                String name = scanner.nextLine();

                System.out.print("Enter calories for " + name + ": ");
                int calories = scanner.nextInt();

                System.out.print("Enter protein for " + name + " (grams): ");
                int protein = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                System.out.print("Enter category (e.g., Breakfast, Lunch, Dinner, Snacks): ");
                String category = scanner.nextLine();

                // Prompt for measurement unit and serving size
                System.out.print("Enter measurement unit (e.g., grams, cups): ");
                String measurementUnit = scanner.nextLine();

                System.out.print("Enter standard serving size for " + name + ": ");
                int servingSize = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                FoodItem customItem = new FoodItem(name, calories, protein, category, measurementUnit, servingSize);
                FoodDatabase.addFoodItem(customItem);
                System.out.printf("Added %s to the food database.%n", customItem.getName());
            } else {
                System.out.println("Invalid option, please try again.");
            }
        }

        tracker.displayTotalCalories();
        tracker.displayGoalsStatus();
        scanner.close();
    }

    // Method to display food items
    private static void displayFoodItems() {
        for (int i = 0; i < FoodDatabase.getFoodItems().size(); i++) {
            FoodItem item = FoodDatabase.getFoodItems().get(i);
            System.out.printf("%d. %s: %d calories, %d g protein, measurement: %s%n",
                    i + 1, item.getName(), item.getCalories(), item.getProtein(), item.getMeasurementUnit());
        }
    }
}
