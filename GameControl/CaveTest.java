package GameControl;


import javax.swing.JButton;

public class CaveTest extends JButton{

  // PROPERTIES
  private String hazard;

  // CONSTRUCTORS
  public CaveTest(){
    setText("Empty");
    this.hazard = "Empty";
  }

  // METHODS
  public String getHazard(){
    return this.hazard;
  }

  public void setHazard(String hazard){
    this.hazard = hazard;
    setText(this.hazard);
  }
  
}
