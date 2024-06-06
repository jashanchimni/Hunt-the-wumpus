import javax.swing.JFrame;
import java.awt.*;
import java.util.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Menu extends JFrame {

    private JPanel buttonPanel;
    private JPanel buttonPanel2;

    public Menu(ArrayList<Button> options, JLabel BG, String title) {
        setTitle(title);
        setSize(600, 400);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Set the layout to use a BorderLayout
        setLayout(new BorderLayout());

        // Set the size and layout of the background label
        BG.setPreferredSize(new Dimension(640, 480));
        BG.setLayout(new GridLayout(2,0,300,0));

        // Create a new JPanel for the buttons
        this.buttonPanel = new JPanel(new GridLayout(0, 1, 10, 50));
        this.buttonPanel2 = new JPanel(new GridLayout(0, 1, 10, 50));
        BG.add(buttonPanel2, BorderLayout.SOUTH);
        buttonPanel2.setOpaque(false);
        buttonPanel.setSize(100,100);
        BG.add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setOpaque(false); // Make the buttonPanel background transparent

        // Add the buttons to the buttonPanel
        addButtons(options);

        // Add the background label and the button panel to the frame
        add(BG);

        draw();
    }
    public void close(){
        dispose();
    }
    public void addButtons(ArrayList<Button>options){
        System.out.println("Working?");
            Button b = new Button("ha", "He", 6);
        this.add(b);
       // this.add(buttonPanel);
        for (Button option : options) {
            option.setSize(100,100);
            this.buttonPanel.add(option, BorderLayout.EAST);
        }
    }
    public void draw() {
        this.setVisible(true);
    }
}