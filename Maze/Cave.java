package Maze;

import java.util.ArrayList;
import java.util.Random;

public class Cave{

  // PROPERTIES
  private int cord;
  private boolean[] walls;
  private boolean visited;

  // CONSTRUCTORS
  public Cave(int cord){
    this.cord = cord;

    // 0 = top
    // 1 = top right
    // 2 = bottom right
    // 3 = bottom
    // 4 = bottom left
    // 5 = top left
    this.walls = new boolean[6];
    for(int i = 0; i < 6; i++){
      this.walls[i] = true;
    }

    this.visited = false;
    
  }

  // METHODS
  public int getCord(){
    return this.cord;
  }

  public boolean getVisited(){
    return this.visited;
  }

  public void setVisited(boolean visited){
    this.visited = visited;
  }

  public void removeWall(int i){
    this.walls[i] = false;
  }

  public int getTotalWalls(){
    int total = 0;
    for(int i = 0; i < 6; i++){
      if(this.walls[i]){
        total++;
      }
    }
    return total;
  }

  public int getRandomWall(){
    ArrayList<Integer> possible = new ArrayList<Integer>();
    Random rand = new Random();
    for(int i = 0; i < 6; i++){
      if(this.walls[i]){
        possible.add(i);
      }
    }
    int randNum = rand.nextInt(possible.size());
    if(possible.size() > 0){
      return possible.get(randNum);
    }
    return -1;
  }

  public String printHex(int half){

    String str = "";

    if(half == 0){
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

    if(half == 1){
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