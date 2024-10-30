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

        while (true) {
            System.out.print("Enter food name (or 'exit' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter calories for " + name + ": ");
            int calories = scanner.nextInt();

            System.out.print("Enter protein for " + name + " (grams): ");
            int protein = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            System.out.print("Enter category (e.g., Breakfast, Lunch, Dinner, Snacks): ");
            String category = scanner.nextLine();

            FoodItem item = new FoodItem(name, calories, protein, category);
            tracker.addFoodItem(item);
        }

        tracker.displayTotalCalories();
        tracker.displayGoalsStatus();
        scanner.close();
    }
}
