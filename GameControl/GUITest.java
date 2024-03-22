package GameControl;


import javax.swing.JFrame;
import java.awt.FlowLayout;

public class GUITest extends JFrame{

  // PROPERTIES

  // CONSTRUCTORS
  public GUITest(String title){
    setTitle(title);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 300);
    setLayout(null);

    setResizable(true);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  // METHODS
  public void addCave(CaveTest cave, int x, int y){
    add(cave);
    cave.setBounds(x, y, 100, 100);
  }
  
}
