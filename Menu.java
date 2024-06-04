import javax.swing.JFrame;
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
public class Menu extends JFrame{
    

    public Menu(ArrayList<Button>options, JLabel BG, int layout){
    setTitle("Home Menu");
    setSize(610,400);
    setLayout(new FlowLayout());
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
     // Set the layout to use a BorderLayout
        setLayout(new BorderLayout());

        // Set the size and layout of the background label
        BG.setPreferredSize(new Dimension(640, 480));
        BG.setLayout(new GridBagLayout());
 // Add the background label and the button panel to the frame
 add(BG, BorderLayout.CENTER);

 setVisible(true);

        if(layout == 1){
    for(int y = 0; y < options.size(); y++){
        options.get(y).setSize(100,100);
        options.get(y).setVisible(true);
        if(y != 0){
        setLocationRelativeTo(options.get(y-1));
            add(options.get(y));
    }
    else{
        options.get(y).setLocation(100,100);
    }
    setAlwaysOnTop(true);
}
    }
}
}
