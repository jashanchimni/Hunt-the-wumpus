package Maze;

public class Hazard{

  // PROPERTIES
  private String symbol;

  // CONSTRUCTORS
  public Hazard(String s){
    this.symbol = s;
  }

  // METHODS
  public int interactWithPlayer(){
    return 0;
  }

  public String getSymbol(){
    return this.symbol;
  }
}