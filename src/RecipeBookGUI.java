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

    // Create a labels
    private JLabel labRecipeName = new JLabel("Recipe name"); 
    private JLabel labRecipeDescription = new JLabel("Recipe desctription");
    private JLabel labRecipeTags = new JLabel("Tags (coma separated");

    // Create a buttons
    private JButton btnAddRecipe = new JButton("Add recipe");
    private JButton btnRecipeBack = new JButton("Back");

    // Create data input
    private JTextField txtRecipeName = new JTextField(30);
    private JTextField txtRecipeDescription = new JTextField(200);
    private JTextField txtRecipeTags = new JTextField(100);

    // Use the panel to group elements
    private JPanel mainPanel = new JPanel();
    private JPanel addRecipePanel = new JPanel();
    /* Optional future code
    private JPanel lookForIngridientsPanel = new JPanel(); */  

    private CardLayout cardlayout = new CardLayout();

    private ActionListener addRecipeListener = new addRecipeListener();
    private ActionListener backRecipeListener = new backRecipeListener();
    private ActionListener saveRecipeListener = new saveRecipeListener();
    // private ActionListener loadRecipeListener = new loadRecipeListener();

    private RecipeBook recipeBook = new RecipeBook();

    // private JList recipeList = new JList;


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

        String recipes[]= recipeBook.recipeList();
        JList recipeList = new JList(recipes);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(recipeList, BorderLayout.CENTER);
        mainPanel.add(btnAddRecipe, BorderLayout.SOUTH);        

        addRecipePanel.setLayout(new GridLayout(4, 2));
        addRecipePanel.add(labRecipeName);
        addRecipePanel.add(txtRecipeName);
        addRecipePanel.add(labRecipeDescription);
        addRecipePanel.add(txtRecipeDescription);
        addRecipePanel.add(labRecipeTags);
        addRecipePanel.add(txtRecipeTags);
        addRecipePanel.add(btnAddRecipe);
        addRecipePanel.add(btnRecipeBack);

        Container contentPane = this.getContentPane();
        contentPane.setLayout(cardlayout);

        // Add panel to a frame
        contentPane.add(mainPanel, "Panel 1");
        contentPane.add(addRecipePanel, "Panel 2");

        mainPanel.setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        recipeAdd.addActionListener(addRecipeListener);
        btnRecipeBack.addActionListener(backRecipeListener);
        fileMenuSave.addActionListener(saveRecipeListener);
        // fileMenuLoad.addActionListener(loadRecipeListener);

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

    class addRecipeListener implements ActionListener { // inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.setVisible(false);
            addRecipePanel.setVisible(true);
        }
    }

    class backRecipeListener implements ActionListener { // inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            mainPanel.setVisible(true);
            addRecipePanel.setVisible(false);
        }
    }

    class saveRecipeListener implements ActionListener { // inner class
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Going to save recipes to a file.");
            recipeBook.recipeBookSave();
        }
    }
}