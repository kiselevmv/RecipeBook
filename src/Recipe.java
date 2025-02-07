import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable {
    private String recipeName;
    private String description;
    ArrayList<String> tags = new ArrayList<>();
    ArrayList<String> ingredients = new ArrayList<>();
    ArrayList<String> quantity = new ArrayList<>();
    // Test

    // Constructor
    public Recipe(String recipeName, String description, ArrayList<String> ingredients, ArrayList<String> quantity, ArrayList<String> tags) {
        this.recipeName = recipeName;
        this.description = description;
        this.ingredients = ingredients;
        this.quantity = quantity;
        this.tags = tags;
    }
    // Getters
    public String getRecipeName() {
        return recipeName;
    }
    public String getDescription() {
        return description;
    }
    public ArrayList<String> getIngredients() {
        return ingredients;
    }
    public ArrayList<String> getQuantity() {
        return quantity;
    }
}