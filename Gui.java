import javax.swing.*;
import java.awt.event.*;
// GUI 
class Gui implements ActionListener{

  // EMPTY CONSTRUCTOR - no purpose except to make Gui constructable
  public Gui() {
    
  }  
  // ACTION LISTENER - when an action is picked up by Gui, this method is called
  public void actionPerformed(ActionEvent e){
    System.out.println("buh");
  }
}