// Java program to construct Recipe book GUI
// Menu bar, viewers, toolbar (welcome to 2000)
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.System.*;

public class RecipeBookGUI extends JFrame {  

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
    /* Optional menu items
    private JMenuItem recipeLookForIngridients = new JMenuItem("Look for ingridients"); */

    // create a labels
    // private JLabel labelRecipe = new JLabel("no task "); 
    // private JLabel asID = new JLabel("Student's ID");
    // private JLabel asName = new JLabel("Student's name");

    // Create a buttons
    private JButton btnAddRecipe = new JButton("Add recipe");

    // private RecipeBook recipeBook = new RecipeBook();

    // Use the panel to group elements
    private JPanel mainPanel = new JPanel();
    private JPanel addRecipePanel = new JPanel();
    /* Optional future code
    private JPanel lookForIngridientsPanel = new JPanel(); */  

    private CardLayout cardlayout = new CardLayout();


    public RecipeBookGUI() {
    	// Add menu to a window
        fileMenu.add(fileMenuSave);
        fileMenu.add(fileMenuLoad);
        fileMenu.add(fileMenuExport);
        fileMenu.add(fileMenuImport);
        menuBar.add(fileMenu); 
        recipeMenu.add(recipeAdd);
        recipeMenu.add(recipeList);
        menuBar.add(recipeMenu); 

        setJMenuBar(menuBar);    

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(new JLabel("Input"), BorderLayout.CENTER);
        mainPanel.add(btnAddRecipe, BorderLayout.SOUTH);
        

        addRecipePanel.setLayout(new GridLayout(2, 2));
        addRecipePanel.add(new JLabel("Input"));
        addRecipePanel.add(btnAddRecipe);
        // Fill the rest of layout
        mainPanel.add(new JLabel(""));
        mainPanel.add(new JLabel(""));

        Container contentPane = this.getContentPane();
        contentPane.setLayout(cardlayout);

        // Add panel to a frame
        contentPane.add(mainPanel, "Panel 1");
        contentPane.add(addRecipePanel, "Panel 2");

        mainPanel.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        System.out.println ("Constructor created");

    }

    public static void main(String[] args) {
		
        // create an object of the class
        RecipeBookGUI window = new RecipeBookGUI();
        window.setTitle("Recipe book");
        window.setLocationRelativeTo(null); // Center the frame
        window.setPreferredSize(new Dimension(200, 300));

        // show the frame
        window.pack();
        window.setVisible(true);
    }
}