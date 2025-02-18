import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;
import java.util.HashSet;   // Import the HashSet class
import java.util.Set;       // Import the Set class

public class RecipeBook implements Serializable{
    private ArrayList<Recipe> recipes;

    // Constructor
    public RecipeBook() {
        this.recipes = new ArrayList<>();
        initializeDefaultRecipes();
        // recipeBookLoad();
    }

    // Initialize default recipes
    private void initializeDefaultRecipes() {
        recipes.add(new Recipe(
            "Pizza",
            "1. Prepare dough. \n2. Add sauce and toppings. \n3. Bake in oven at 220°C for 15 minutes.",
            new ArrayList<>(Arrays.asList("Flour", "Tomato Sauce", "Cheese", "Yeast")),
            new ArrayList<>(Arrays.asList("500g", "200ml", "150g", "10g")),
            new ArrayList<>(Arrays.asList("Italian", "Baked", "Cheesy"))
        ));

        recipes.add(new Recipe(
            "Caesar Salad",
            "1. Chop lettuce. \n2. Add grilled chicken and croutons. \n3. Mix with Caesar dressing.",
            new ArrayList<>(Arrays.asList("Lettuce", "Chicken Breast", "Croutons", "Caesar Dressing")),
            new ArrayList<>(Arrays.asList("200g", "150g", "50g", "50ml")),
            new ArrayList<>(Arrays.asList("Salad", "Healthy", "Fresh"))
        ));

        recipes.add(new Recipe(
            "Borscht",
            "1. Boil beets, potatoes, and carrots. \n2. Add cabbage and meat. \n3. Simmer for 40 minutes and serve with sour cream.",
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
    public boolean removeRecipeByName(String recipeName) {
        for (Recipe recipe : recipes) {
            if (recipe.getRecipeName().equalsIgnoreCase(recipeName)) {
                recipes.remove(recipe);
                return true;
            }
        }
        return false;
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

    // Return a list of recipes filtred by tag
    public String[] recipeFiltredList(String Tag) {
    ArrayList<String> recipeFiltredList = new ArrayList();
        for (Recipe recipe : recipes) {
            if (recipe.getTags().contains(Tag)) {
                recipeFiltredList.add(recipe.getRecipeName());
                // If tag is found - add recipe to a filtred list  
                // Do nothing otherwise
            }
        }
        return recipeFiltredList.toArray(new String[0]);
    }

    // Return a list of unique tags
    public String[] recipeUniqueTags() {
        ArrayList<String> recipeTags = new ArrayList(); 
        recipeTags.add("None");
        // Add default "none" tag to remove filter
        for (Recipe recipe : recipes) {
            recipeTags.addAll(recipe.getTags());
        }
        // Now recipeTags is a list of all tags from all recipes
        // This is not optiamal resolution. But only way to improve is is database
        Set<String> uniqueTags = new HashSet<>(recipeTags);
        // HashSet could only keep unique elements
        return uniqueTags.toArray(new String[0]);
        // convert a Set to String Array before return
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
            System.out.println("Error saving recipe book: " + e.getMessage());
        }
    }

    // Load from file (deserialization)
    public void recipeBookLoad(){
        try {
            FileInputStream fis = new FileInputStream("RecipeBook.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            recipes = (ArrayList<Recipe>) ois.readObject();
            ois.close();
            System.out.println("Object has been deserialized");

        } catch (Exception e) {
            System.out.println("Error loading recipe book: " + e.getMessage());
        }
    }
}
