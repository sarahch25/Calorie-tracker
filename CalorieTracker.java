public class CalorieTracker {
    private int calorieGoal;
    private int proteinGoal;
    private int totalCalories;
    private int totalProtein;

    public CalorieTracker(int calorieGoal, int proteinGoal) {
        this.calorieGoal = calorieGoal;
        this.proteinGoal = proteinGoal;
        this.totalCalories = 0;
        this.totalProtein = 0;
    }

    // Adjusted method to add food item with quantity
    public void addFoodItem(FoodItem item, int quantity) {
        totalCalories += item.calculateCalories(quantity);
        totalProtein += item.calculateProtein(quantity);
    }

    // Existing methods to display totals
    public void displayTotalCalories() {
        System.out.printf("Total Calories Consumed: %d / %d%n", totalCalories, calorieGoal);
    }

    public void displayGoalsStatus() {
        System.out.printf("Total Protein Consumed: %d / %d%n", totalProtein, proteinGoal);
    }
}
