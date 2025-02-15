import javax.swing.*;
import java.awt.*;

public class JListSetListDataExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JListSetListDataExample().createGUI());
    }

    private void createGUI() {
        JFrame frame = new JFrame("JList setListData Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        // Create JList without specifying data initially
        JList<String> list = new JList<>();

        // Initialize list with an array
        String[] initialData = {"Item 1", "Item 2", "Item 3"};
        list.setListData(initialData);

        // Add JList inside a JScrollPane
        frame.add(new JScrollPane(list), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}