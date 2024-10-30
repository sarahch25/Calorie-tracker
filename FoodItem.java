public class FoodItem {
    private String name;
    private int calories;
    private int protein; // Protein in grams
    private String category;

    public FoodItem(String name, int calories, int protein, String category) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public String getCategory() {
        return category;
    }
}
