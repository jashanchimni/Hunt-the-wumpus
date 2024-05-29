import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GUI extends JFrame{


public GUI(){
    setTitle("Home Menu");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(640,480);
    setLayout(new FlowLayout());
    setResizable(false);
    setLocationRelativeTo(null);
    setVisible(true);
}
}
