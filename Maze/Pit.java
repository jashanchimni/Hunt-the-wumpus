package Maze;

public class Pit extends Hazard{

  // PROPERTIES

  // CONSTRUCTORS
  public Pit(){
    super("P");
  }

  // METHODS
  @Override
  public int interactWithPlayer(){
    return -1;
  }
}
