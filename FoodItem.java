public class FoodItem {
    private String name;
    private int calories;  // calories per 100g (or per unit)
    private int protein;   // protein per 100g (or per unit)
    private String category;
    private String measurementUnit; // e.g., grams, cups
    private int servingSize; // standard serving size for calculations

    public FoodItem(String name, int calories, int protein, String category, String measurementUnit, int servingSize) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.category = category;
        this.measurementUnit = measurementUnit;
        this.servingSize = servingSize;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public int getServingSize() {
        return servingSize;
    }

    // Method to calculate calories based on the quantity
    public int calculateCalories(int quantity) {
        return (calories * quantity) / servingSize; // Adjusting for the quantity
    }

    // Method to calculate protein based on the quantity
    public int calculateProtein(int quantity) {
        return (protein * quantity) / servingSize; // Adjusting for the quantity
    }
}
