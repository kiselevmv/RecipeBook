// Java program to construct Recipe book GUI
// Menu bar, viewers, toolbar (welcome to 2000)
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.System.*;
import java.util.ArrayList;
import java.util.Arrays;       // 

public class RecipeBookGUI extends JFrame {  

    private RecipeBook recipeBook = new RecipeBook();

    //Declare GUI elements

    // Menu options
	// create a menubar
    private JMenuBar menuBar = new JMenuBar();

    // create a menu
    private JMenu fileMenu = new JMenu("File");
    private JMenu recipeMenu = new JMenu("Recipe");

    // Menu items "File"
    private JMenuItem fileMenuSave = new JMenuItem("Save");
    private JMenuItem fileMenuLoad = new JMenuItem("Load");
    private JMenuItem fileMenuExport = new JMenuItem("Export to ...");
    private JMenuItem fileMenuImport = new JMenuItem("Import from ...");

    // Menu items "recipe"
    private JMenuItem recipeAdd = new JMenuItem("Add recipe");
    private JMenuItem recipeList = new JMenuItem("List of recipes");
    private JMenuItem recipeFind = new JMenuItem("Find recipe");
    private JMenuItem recipeRemoveFilter = new JMenuItem("Remove filter");
    /* Optional menu items
    private JMenuItem recipeLookForIngridients = new JMenuItem("Look for ingridients"); */
    // End menu

    // Create a labels
    private JLabel labRecipeName = new JLabel("Recipe name"); 
    private JLabel labRecipeDescription = new JLabel("Recipe desctription");
    private JLabel labRecipeTags = new JLabel("Tags (coma separated):");
    private JLabel lblRecipesList = new JLabel("Recipes list");
    private JLabel lblRecipeIngridients = new JLabel("Recipe ingridients (coma separated):");
    private JLabel lblRecipeQuantities = new JLabel("Quantity of ingridients (coma separated):");

    // End labels

    // Create a buttons
    private JButton btnAddRecipe = new JButton("Add recipe");
    private JButton btnRecipeBack = new JButton("Back");
    private JButton btnSaveRecipe = new JButton("Save recipe");
    private JButton btnRemoveFilter = new JButton("Remove filter");
    // End buttons

    // Create data input
    private JTextField txtRecipeName = new JTextField(30);
    private JTextArea txtRecipeDescription = new JTextArea(5, 40);
    private JTextField txtRecipeTags = new JTextField(200);
    private JTextField txtRecipeIngridients = new JTextField(200);
    private JTextField txtRecipeQuantities = new JTextField(200);
    // End text data input fields

    // Create a List of recipes
    private JList<String> lstRecipesList = new JList<>(); 

    // Create a Combo box for tags
    private JComboBox ctlTags;

    // Use the panel to group elements
    private JPanel mainPanel = new JPanel();
    private JPanel addRecipePanel = new JPanel();
    /* Optional future code
    private JPanel lookForIngridientsPanel = new JPanel(); */  
    private JPanel topPanel = new JPanel();

    private CardLayout cardlayout = new CardLayout();

    // Begin ActionListener section.
    // All callback functions for GUI are here
    private ActionListener addRecipeListener = new addRecipeListener();
    private ActionListener backRecipeListener = new backRecipeListener();
    private ActionListener saveRecipeListener = new saveRecipeListener();
    private ActionListener loadRecipeListener = new loadRecipeListener();
    private ActionListener saveNewRecipeListener = new saveNewRecipeListener();
    private ActionListener removeRecipeFilterListener = new removeRecipeFilterListener();
    private ItemListener  changedComboListener = new changedComboListener();
    // End Action Listener section


    public RecipeBookGUI() {
    	// Section: Add menu to a window
        fileMenu.add(fileMenuSave);
        fileMenu.add(fileMenuLoad);
        fileMenu.add(fileMenuExport);
        fileMenu.add(fileMenuImport);
        menuBar.add(fileMenu); 
        recipeMenu.add(recipeAdd);
        recipeMenu.add(recipeList);
        recipeMenu.add(recipeRemoveFilter);
        menuBar.add(recipeMenu); 
        setJMenuBar(menuBar);
        // End menu section    

        // Section: create main screen
        String[] recipes = recipeBook.recipeList();
        lstRecipesList.setListData(recipes);
        // Create a intial list or recipes
        mainPanel.setLayout(new BorderLayout());
        topPanel.setLayout(new FlowLayout());
        topPanel.add(lblRecipesList);
        JComboBox<String> ctlTags = new JComboBox<>(recipeBook.recipeUniqueTags());
        topPanel.add(ctlTags);
        topPanel.add(btnRemoveFilter);
        mainPanel.add(topPanel, BorderLayout.NORTH);
        // Create a top element with tag selector
        mainPanel.add(lstRecipesList, BorderLayout.CENTER);
        mainPanel.add(btnAddRecipe, BorderLayout.SOUTH);   
        // End section: create main screen     

        // Section: create add recipe screen
        addRecipePanel.setLayout(new GridLayout(6, 2));
        addRecipePanel.add(labRecipeName);
        addRecipePanel.add(txtRecipeName);
        addRecipePanel.add(labRecipeDescription);
        addRecipePanel.add(txtRecipeDescription);
        addRecipePanel.add(labRecipeTags);
        addRecipePanel.add(txtRecipeTags);
        addRecipePanel.add(lblRecipeIngridients);
        addRecipePanel.add(txtRecipeIngridients);
        addRecipePanel.add(lblRecipeQuantities);
        addRecipePanel.add(txtRecipeQuantities);
        addRecipePanel.add(btnAddRecipe);
        addRecipePanel.add(btnRecipeBack);
        // End section: create add recipe screen

        Container contentPane = this.getContentPane();
        contentPane.setLayout(cardlayout);

        // Add panel to a frame
        contentPane.add(mainPanel, "Panel 1");
        contentPane.add(addRecipePanel, "Panel 2");

        mainPanel.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Section: Apply action listeners to GUI elements
        recipeAdd.addActionListener(addRecipeListener);
        recipeRemoveFilter.addActionListener(removeRecipeFilterListener);
        btnRecipeBack.addActionListener(backRecipeListener);
        fileMenuSave.addActionListener(saveRecipeListener);
        fileMenuLoad.addActionListener(loadRecipeListener);
        btnAddRecipe.addActionListener(saveNewRecipeListener);
        ctlTags.addItemListener(changedComboListener);
        btnRemoveFilter.addActionListener(removeRecipeFilterListener);
        // End section: apply action listeners
    }

    public static void main(String[] args) {
		
        RecipeBookGUI window = new RecipeBookGUI(); // Create an object of the GUI class
        window.setTitle("Recipe book");             // Set window title
        window.setLocationRelativeTo(null);         // Center the frame
        window.setPreferredSize(new Dimension(300, 400));
        window.pack();                              // Populate a window with elemnts
        window.setVisible(true);                    // Show the frame
    }

    class addRecipeListener implements ActionListener { // inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.setVisible(false);
            addRecipePanel.setVisible(true);
            // Hide main form and show "add recipe" form
        }
    }

    class backRecipeListener implements ActionListener { // inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.setVisible(true);
            addRecipePanel.setVisible(false);
            // Show main form and hide "add recipe" form
        }
    }

    class saveRecipeListener implements ActionListener { // inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            recipeBook.recipeBookSave();
            // Save recipes list to a file
        }
    }

    class saveNewRecipeListener implements ActionListener { //inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            // ArrayList<String> ingridients = new ArrayList<String>();
            ArrayList<String> ingridients = new ArrayList<>(Arrays.asList(txtRecipeIngridients.getText().split(",")));
            ArrayList<String> quantity = new ArrayList<>(Arrays.asList(txtRecipeQuantities.getText().split(",")));
            ArrayList<String> tags = new ArrayList<>(Arrays.asList(txtRecipeTags.getText().split(",")));
            // Create an list of tag from comma-separated String
            String recipeName = txtRecipeName.getText();
            String recipeDescription = txtRecipeDescription.getText();
            Recipe newRecipe = new Recipe(recipeName, recipeDescription, ingridients, quantity, tags);
            recipeBook.addRecipe(newRecipe); 
            // Create a record with new recipe
            String recipes[]= recipeBook.recipeList();
            lstRecipesList.setListData(recipes);
            // Update ListView with updated recipes list
            txtRecipeName.setText("");
            txtRecipeDescription.setText("");
            txtRecipeTags.setText("");
            // Clear all fields before new input
        }
    }

    class loadRecipeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            recipeBook.recipeBookLoad();
            // Load recipe book from a file
            String recipes[] = recipeBook.recipeList();
            lstRecipesList.setListData(recipes);
            // Update list of recipes with new recipes
        }
    }

    class changedComboListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
            // Only update list of recipes if new tag is selected in combobox
                    String Tag = (String) event.getItem();
                    // Optionally: String Tag = event.getItem().toString();
                    if (Tag.equals("None")) {
                        String recipes[] = recipeBook.recipeList();
                        lstRecipesList.setListData(recipes);
                        // If tag == "none" we just remove filter and show all the recipes
                    } else {
                        String[] filtredRecipes = recipeBook.recipeFiltredList(Tag);
                        // Create an array of filtred recipe names
                        lstRecipesList.setListData(filtredRecipes);
                        // Update a list of recipes with new array of filtred recipe names   
                    }
                    
            // If new tag is choosen - show only items with this tag
            }
        }      
    }

    class removeRecipeFilterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String recipes[] = recipeBook.recipeList();
            lstRecipesList.setListData(recipes);
            // Update list of recipes with all recipes without filter applied
        }
    }
}