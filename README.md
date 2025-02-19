# Project idea

Recipe management system with simple GUI.

## Problem solving

Store recipes and requirements to ingridients. 
Gives easy access to add and view recipes.

## Key features

1. Input, 
2. Store, 
3. Demonstrate recipes from a database. 
4. User GUI
5. Optional: show recipes from a base by user-defined tags.
6. Optional: Export recipes to text (markdown, html, etc.)

## Time schedule

10.02 - minimal console application
Class "Recipe" with setters/getters - Arseni
Methods:
- Constructor
- Setter: Recipe description and list of ingridients
- Look for selected ingridients (optional) [incapsulation]
Fields:
- Description
- List of ingridients
- Quantity of ingridients
- Picture (optional)

Class RecipeBook: - Arseni & Mikhail
Methods:
- recipeBookSave; 	Save to file (serialization)
- recipeBookLoad;	Load from file (serialized)
- recipeBookSaveText;	Save to file (text/html/xml) (optional)
- recipeBookLoadText;	Load from file (text/xml) (optional)
- recipeBookAdd;	Add new recipe
- recipeBookRemove;	Remove recipe
- recipeBookList;	List all recipes from Recipe book.
- recipeBookFilter;	Select recipes with selected ingridients [filter] (optional)

Fields:
- ArrayList<Recipe>

Class Recipe; - Arseni & Mikhail
Getters:
- getRecipeName;	Get recipe Name.
- getRecipeDescription;	Get recipe desctiption.
- getRecipeIngredients();	Get recipe ingridients.
- getRecipeQuantity;	Get quontities of ingridients for a recipe.


13.02 - GUI application
Main window - Mikhail
Input recipe window - Mikhail
Show recipes by tag - Mikhail


17.02 - Optional feature and code polishing.  - Arseni & Mikhail

## Final goal

Functional application without errors. Useful for real life.








