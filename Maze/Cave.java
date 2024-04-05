package Maze;

public class Cave{

  // PROPERTIES
  private int[] cords;
  private Maze maze;
  private boolean visited;
  private boolean[] walls;

  // CONSTRUCTORS
  public Cave(Maze maze, int x, int y){
    this.cords = new int[2];
    this.cords[0] = x;
    this.cords[1] = y;
    this.maze = maze;

    // 0 = top
    // 1 = top right
    // 2 = bottom right
    // 3 = bottom
    // 4 = bottom left
    // 5 = top left
    this.walls = new boolean[6];
    for(int i = 0; i < this.walls.length; i++){
      walls[i] = true;
    }

    this.visited = false;

  }

  // METHODS
  public String cordsToString(){
    return this.cords[0] + ", " + this.cords[1];
  }

  public String wallsToString(){
    return "Top: " + this.walls[0] + " Top Right: " + this.walls[1] + " Bottom Right: " + this.walls[2] + " Bottom: " + this.walls[3] + " Bottom Left: " + this.walls[4] + " Top Left: " + this.walls[5];
  }
  
  public int[] getCords(){
    return this.cords;
  }

  public boolean getVisited(){
    return this.visited;
  }

  public void setVisited(boolean visited){
    this.visited = visited;
  }

  public int getX(){
    return this.cords[0];
  }

  public int getY(){
    return this.cords[1];
  }

  public void removeWall(int i){
    //System.out.println(i + " removed!" + cordsToString());
    this.walls[i] = false;
  } 

  public String printHex(int row){

    String str = "";
    
    if(row == 0){
      if(this.walls[5]){
        str += "/";
      }
      else{
        str += " ";
      }
      if(this.walls[0]){
        str += "T";
      }
      else{
        str += " ";
      }
      if(this.walls[1]){
        str += "\\";
      }
      else{
        str += " ";
      }
    }

    if(row == 1){
      if(this.walls[4]){
        str += "\\";
      }
      else{
        str += " ";
      }
      if(this.walls[3]){
        str += "_";
      }
      else{
        str += " ";
      }
      if(this.walls[2]){
        str += "/";
      }
      else{
        str += " ";
      }
    }

    return str;
  }
}