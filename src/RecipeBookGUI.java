// Java program to construct Recipe book GUI
// Menu bar, viewers, toolbar (welcome to 2000)
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RecipeBookGUI extends JFrame {  

	// create a menubar
    private JMenuBar mb = new JMenuBar();

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

    // private RecipeBook recipeBook = new RecipeBook();

    // Use the panel to group elements
    private JPanel mainPanel = new JPanel();
    private JPanel addRecipePanel = new JPanel();
    /* Optional future code
    private JPanel lookForIngridientsPanel = new JPanel(); */  

    private CardLayout cardlayout = new CardLayout();


  

    public void RecipeBook() {
    	// Add menu to a window
        fileMenu.add(fileMenuSave);
        fileMenu.add(fileMenuLoad);
        fileMenu.add(fileMenuExport);
        fileMenu.add(fileMenuImport);
        mb.add(fileMenu); 
        recipeMenu.add(recipeAdd);
        recipeMenu.add(recipeList);
        mb.add(recipeMenu); 

        setJMenuBar(mb);    

        Container contentPane = this.getContentPane();
        contentPane.setLayout(cardlayout);

        // Add panel to a frame
        contentPane.add(mainPanel, "Panel 1");
        contentPane.add(addRecipePanel, "Panel 2");

        mainPanel.setLayout(new GridLayout(0, 2));



    }

    public static void main(String[] args) {
		
        // create an object of the class
        RecipeBookGUI window = new RecipeBookGUI();
        window.setTitle("Recipe book");
        window.setLocationRelativeTo(null); // Center the frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the size of the frame
        // window.setSize(300, 500);
        window.setPreferredSize(new Dimension(200, 300));
        // show the frame
        window.pack();
        window.setVisible(true);
    }


}