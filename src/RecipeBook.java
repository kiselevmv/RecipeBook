import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class RecipeBook implements Serializable{
    private ArrayList<Recipe> recipes;

    // Constructor
    public RecipeBook() {
        this.recipes = new ArrayList<>();
        initializeDefaultRecipes();
        this.recipeBookLoad();
    }

    // Initialize default recipes
    private void initializeDefaultRecipes() {
        recipes.add(new Recipe(
            "Pizza",
            "1. Prepare dough. 2. Add sauce and toppings. 3. Bake in oven at 220°C for 15 minutes.",
            new ArrayList<>(Arrays.asList("Flour", "Tomato Sauce", "Cheese", "Yeast")),
            new ArrayList<>(Arrays.asList("500g", "200ml", "150g", "10g")),
            new ArrayList<>(Arrays.asList("Italian", "Baked", "Cheesy"))
        ));

        recipes.add(new Recipe(
            "Caesar Salad",
            "1. Chop lettuce. 2. Add grilled chicken and croutons. 3. Mix with Caesar dressing.",
            new ArrayList<>(Arrays.asList("Lettuce", "Chicken Breast", "Croutons", "Caesar Dressing")),
            new ArrayList<>(Arrays.asList("200g", "150g", "50g", "50ml")),
            new ArrayList<>(Arrays.asList("Salad", "Healthy", "Fresh"))
        ));

        recipes.add(new Recipe(
            "Borscht",
            "1. Boil beets, potatoes, and carrots. 2. Add cabbage and meat. 3. Simmer for 40 minutes and serve with sour cream.",
            new ArrayList<>(Arrays.asList("Beets", "Potatoes", "Carrots", "Cabbage", "Meat")),
            new ArrayList<>(Arrays.asList("300g", "200g", "100g", "200g", "300g")),
            new ArrayList<>(Arrays.asList("Soup", "Traditional", "Russian"))
        ));
    }

    // Add recipe
    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    // Remove recipe by name
    public boolean removeRecipe(String recipeName) {
        return recipes.removeIf(recipe -> recipe.getRecipeName().equalsIgnoreCase(recipeName));
    }

    // Find recipe by name
    public Recipe findRecipe(String recipeName) {
        for (Recipe recipe : recipes) {
            if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
                return recipe;
            }
        }
        return null;
    }

    // Return a list of recipes
    public String[] recipeList() {
    ArrayList<String> recipeList = new ArrayList();	
    	for (Recipe recipe : recipes) {
    		recipeList.add(recipe.getRecipeName());
    	}
    	return recipeList.toArray(new String[0]);
    }

    // Save to file (serialization)
    public void recipeBookSave(){
        try {
            FileOutputStream fos = new FileOutputStream("RecipeBook.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(recipes);
            oos.close();
            System.out.println("Serialized object saved to a file");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Load from file (deserialization)
    public void recipeBookLoad(){
        try {
            FileInputStream fis = new FileInputStream("RecipeBook.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ois.readObject();
            ois.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
