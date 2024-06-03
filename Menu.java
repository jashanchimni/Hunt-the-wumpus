import javax.swing.JFrame;
import java.awt.*;
import java.util.*;
public class Menu extends JFrame{
    

    public Menu(ArrayList<Button>options){
    setTitle("Home Menu");
    setSize(640,480);
    setLayout(new FlowLayout());
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);


    for(int y = 0; y < options.size(); y++){
            add(options.get(y));
    }
    }
}
