public class GameControl{
  // PROPERTIES

  // CONSTRUCTORS
  public GameControl(){
    System.out.println("This is game control!");
  }

  // METHODS
  public void initialize(){
    // Set up the game
    // Called by main
    // Show main menu
    // Set any info that need to be set (Ex: player stats)
    // Call gui
  }

  public void startGame(){
    // Start the game
    // Called by main
    // Show the map
    // Call GameLocation or Cave to get map
    // Call gui
  }

  public void endGame(){
    // End the game
    // Called by Player when dead? or Menu when don't want to play?
    // Calls Player to update stats to file
    // Show game over or main menu
    // Call gui
  }

  public void showMap(){
    // Show the current map
    // Called by main
    // Calls Cave or GameLocation to get the map
    // Calls gui
  }
  
  public boolean movePlayer(int direction){
    // Checks whether the player can move in the given direction
    // If cave if out of bounds, or there is a wall, returns false
    // If the passageway is clear, returns true
    // Calls GameLocation class
    return true;
  }

  public boolean checkLocationOfInterest(){
    // Checks if there is anything in the given cave
    // -------------------------------------
    // Might pass in a Cave as a parameter
    // And return hazard/monster
    // -------------------------------------
    // Calls the Cave class
    // Checks for hazards Ex: wumpus, bat, pit, shop, etc.
    // If there is nothing, returns false
    // If there is something, returns true
    return false;
  }
}