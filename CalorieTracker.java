import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CalorieTracker {
    private ArrayList<FoodItem> foodItems;
    private int dailyCalorieGoal;
    private int dailyProteinGoal;  // Protein goal in grams

    public CalorieTracker(int dailyCalorieGoal, int dailyProteinGoal) {
        this.foodItems = new ArrayList<>();
        this.dailyCalorieGoal = dailyCalorieGoal;
        this.dailyProteinGoal = dailyProteinGoal;
    }

    public void addFoodItem(FoodItem item) {
        foodItems.add(item);
    }

    public int getTotalCalories() {
        int totalCalories = 0;
        for (FoodItem item : foodItems) {
            totalCalories += item.getCalories();
        }
        return totalCalories;
    }

    public int getTotalProtein() {
        int totalProtein = 0;
        for (FoodItem item : foodItems) {
            totalProtein += item.getProtein();
        }
        return totalProtein;
    }

    public Map<String, Integer> getCaloriesByCategory() {
        Map<String, Integer> categoryCalories = new HashMap<>();
        for (FoodItem item : foodItems) {
            categoryCalories.put(
                    item.getCategory(),
                    categoryCalories.getOrDefault(item.getCategory(), 0) + item.getCalories()
            );
        }
        return categoryCalories;
    }

    public void displayTotalCalories() {
        System.out.println("Total calories for the day: " + getTotalCalories());
        System.out.println("Calories by category:");
        for (Map.Entry<String, Integer> entry : getCaloriesByCategory().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void displayGoalsStatus() {
        int caloriesLeft = dailyCalorieGoal - getTotalCalories();
        int proteinLeft = dailyProteinGoal - getTotalProtein();

        System.out.println("Calories remaining for the day: " + (caloriesLeft >= 0 ? caloriesLeft : 0));
        System.out.println("Protein remaining for the day: " + (proteinLeft >= 0 ? proteinLeft : 0));
    }
}
