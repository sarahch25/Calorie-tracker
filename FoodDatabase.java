import java.util.ArrayList;

public class FoodDatabase {
    private static final ArrayList<FoodItem> foodItems = new ArrayList<>();

    // Predefined food items
    static {
        foodItems.add(new FoodItem("Apple", 95, 0, "Snacks", "grams", 100));
        foodItems.add(new FoodItem("Banana", 105, 1, "Snacks", "grams", 100));
        foodItems.add(new FoodItem("Chicken Breast", 165, 31, "Dinner", "grams", 100));
        foodItems.add(new FoodItem("Rice", 206, 4, "Lunch", "grams", 100)); // Assuming 100g serving size
        foodItems.add(new FoodItem("Broccoli", 55, 4, "Lunch", "grams", 100));
    }


    // Method to get food items
    public static ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    // Method to add a custom food item
    public static void addFoodItem(FoodItem item) {
        foodItems.add(item);
    }
}
