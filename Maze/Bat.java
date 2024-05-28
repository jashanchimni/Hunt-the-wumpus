package Maze;


import java.util.Random;

public class Bat extends Hazard{

  // PROPERTIES
  Random rand = new Random();

  // CONSTRUCTORS
  public Bat(){
    super("B");
  }

  // METHODS
  @Override
  public int interactWithPlayer(){
    return rand.nextInt(30) +1;
  }
}