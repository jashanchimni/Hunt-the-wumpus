package Maze;


public class Wumpas extends Hazard{

  // PROPERTIES

  // CONSTRUCTORS
  public Wumpas(){
    super("W");
  }

  // METHODS
  @Override
  public int interactWithPlayer(){
    return 0;
  }
}
