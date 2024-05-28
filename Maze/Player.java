package Maze;

public class Player{

  // PROPERTIES
  private int cord;

  // CONSTRUCTORS
  public Player(int cord){
    this.cord = cord;
  }

  // METHODS
  public int getCord(){
    return this.cord;
  }

  public void move(int cord){
    this.cord = cord;
  }
}