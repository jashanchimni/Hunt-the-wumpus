package Maze;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Maze{
  
  public static void main(String[] args) {

    Maze maze = new Maze(6, 5);
    Scanner s = new Scanner(System.in);
    int choice = 0;
    Player p = new Player(1);
    Cave current = maze.getCaves().get(1);

    while(choice != 6){

      System.out.println();
      System.out.println("Current position: " + p.getCord());
      System.out.print("Enter direction: ");
      choice = s.nextInt();

      current = maze.getCaves().get(p.getCord());
      Cave next = maze.getCave(current, choice);

      if(next != null){
        if(maze.canMove(current.getCord(), next.getCord())){
          p.move(next.getCord());
          current.setPlayer(false);
          next.setPlayer(true);
        }
      }

      if(next.getPlayer() && next.getHazard() != null){
        System.out.println();
        int num = next.getHazard().interactWithPlayer();
        if(num == -1){
          System.out.println("You fell to your death! Game over!");
          choice = 6;
        }
        if(num == 0){
          System.out.println("You found the wumpas! You win!");
          choice = 6;
        }
        if(num > 0){
          System.out.println("You were picked up by bats!");
          p.move(num);
          maze.getCaves().get(p.getCord()).setPlayer(true);
          next.setPlayer(false);
          next.setHazard(null);
          maze.placeBat();
        }
      }

      maze.draw();
      
    }

  }

  // PROPERTIES
  private int height;
  private int width;
  private int size;
  private ArrayList<Cave> caves;
  private Random rand;

  // CONSTRUCTORS
  public Maze(int width, int height){
    this.width = width;
    this.height = height;
    this.size = width * height;
    this.caves = new ArrayList<Cave>();
    this.rand = new Random();

    generateMap();
    removeRandomWalls();
    removeRandomWalls();

    draw();

  }

  // METHODS
  public ArrayList<Cave> getCaves(){
    return this.caves;
  }
  
  public void generateMap(){

    caves.add(new Cave(0));
    
    for(int i = 1; i <= this.size; i++){
      caves.add(new Cave(i));
    }

    caves.get(1).setPlayer(true);

    placeHazards();

    ArrayList<Cave> stack = new ArrayList<Cave>();
    Cave current = this.caves.get(1);
    boolean first = true;

    while(stack.size() > 0 || first == true){
      first = false;
      //System.out.println("STACK LOOP");

      current.setVisited(true);
      Cave next = getNext(current);

      if(next != null){
        //System.out.println("Next: " + next.cordsToString());
        stack.add(current);
        next.setVisited(true);
        current = next;
      }
      else if(stack.size() > 0){
        current = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
      }
    }
    
  }

  public void placeHazards(){
    ArrayList<Hazard> hazards = new ArrayList<Hazard>();
    hazards.add(new Bat());
    hazards.add(new Pit());
    hazards.add(new Wumpas());
    
    while(hazards.size() > 0){
      int randNum = rand.nextInt(this.size - 1) + 2;
      Cave cave = this.caves.get(randNum);
      if(cave.getHazard() == null){
        cave.setHazard(hazards.get(0));
        hazards.remove(0);
      }
    }
  }

  public void placeBat(){
    int randNum = rand.nextInt(this.size) + 1;
    while(caves.get(randNum).getHazard() != null || caves.get(randNum).getPlayer()){
      randNum = rand.nextInt(this.size) + 1;
    }

    caves.get(randNum).setHazard(new Bat());
    
  }

  public Cave getNext(Cave current){
    int cord = current.getCord();
    

    boolean even = (cord % 2 == 0);

    ArrayList<Cave> possible = new ArrayList<Cave>();
    ArrayList<Integer> directions = new ArrayList<Integer>();
    int next = 0;

    // check top
    next = getTop(cord);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(0);
    }

    // check top right
    next = getTopRight(cord);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(1);
    }

    // check top left
    next = getTopLeft(cord);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(5);
    }

    // check bottom
    next = getBottom(cord);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(3);
    }

    // check bottom right
    next = getBottomRight(cord);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(2);
    }

    // check bottom left
    next = getBottomLeft(cord);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(4);
    }

    if(possible.size() > 0){
      int randNum = rand.nextInt(possible.size());
      Cave nextCave = possible.get(randNum);
      int direction = directions.get(randNum);
      removeWalls(current, nextCave, direction);
      //System.out.println("Returned: " + thing.cordsToString());
      return nextCave;
    }
    return null;
    
  }

  public void removeWalls(Cave current, Cave next, int direction){

    current.removeWall(direction);
    next.removeWall((3+direction) % 6);    
  }

  public void removeWallInDirection(Cave current, int direction){
    int next = 0;
    int cord = current.getCord();
    if(direction == 0){
      next = getTop(cord);
    }
    if(direction == 1){
      next = getTopRight(cord);
    }
    if(direction == 2){
      next = getBottomRight(cord);
    }
    if(direction == 3){
      next = getBottom(cord);
    }
    if(direction == 4){
      next = getBottomLeft(cord);
    }
    if(direction == 5){
      next = getTopLeft(cord);
    }
    removeWalls(current, this.caves.get(next), direction);
  }

  public void draw(){

    boolean top = true;

    for(int i = 1; i <= this.size; i+=2){
      if(top){
        System.out.print(this.caves.get(i).printHex(0));
        if(i + 1 - width > 0){
          System.out.print(this.caves.get(i + 1 - width).printHex(1));
        }
        else{
          System.out.print("   ");
        }
      }
      else{
        System.out.print(this.caves.get(i).printHex(1));
        System.out.print(this.caves.get(i + 1).printHex(0));
      }
      if(i % this.width == this.width - 1){
        if(top){
          i -= this.width;
        }
        top = !top;
        System.out.println();
      }
    }
    for(int i = this.size - this.width + 2; i <= this.size; i += 2){
      System.out.print("   ");
      System.out.print(this.caves.get(i).printHex(1));
    }
  }

  public int adjustNum(int num){

    if(num <= 0){
      return this.size + num;
    }

    if(num > this.size){
      return num - this.size;
    }

    return num;
  }

  public void removeRandomWalls(){
    Cave current = new Cave(0);
    Cave next = null;
    for(int i = 1; i <= this.size; i++){
      current = this.caves.get(i);
      int direction = current.getRandomWall();
      next = getCave(current, direction);
      int randNum = rand.nextInt(10);
      if(randNum <= 7){
        if(current.getTotalWalls() > 3 && next.getTotalWalls() > 3){
          removeWallInDirection(current, direction);
        }
      }
    }
  }

  public Cave getCave(Cave current, int direction){
    int cord = current.getCord();
    if(direction == 0){
      return this.caves.get(getTop(cord));
    }
    if(direction == 1){
      return this.caves.get(getTopRight(cord));
    }
    if(direction == 2){
      return this.caves.get(getBottomRight(cord));
    }
    if(direction == 3){
      return this.caves.get(getBottom(cord));
    }
    if(direction == 4){
      return this.caves.get(getBottomLeft(cord));
    }
    if(direction == 5){
      return this.caves.get(getTopLeft(cord));
    }
    return null;
  }

  public int getTop(int cord){
    int top = cord - this.width;
    
    top = adjustNum(top);

    return top;
  }

  public int getTopRight(int cord){
    int topRight = 0;
    
    if(cord % 2 == 0){
      if(cord % width == 0){
        topRight = cord + 1 - width;
      }
      else{
        topRight = cord + 1;
      }
    }
    else{
      topRight = cord + 1 - width;
    }

    topRight = adjustNum(topRight);

    return topRight;
  }

  public int getTopLeft(int cord){
    int topLeft = 0;
    
    if(cord % 2 == 0){
      topLeft = cord - 1;
    }
    else{
      if(cord % width == 1){
        topLeft = cord - 1;
      }
      else{
        topLeft = cord - 1 - width;
      }
    }

    topLeft = adjustNum(topLeft);

    return topLeft;
  }

  public int getBottom(int cord){
    int bottom = 0;
    
    bottom = cord + this.width;

    bottom = adjustNum(bottom);

    return bottom;
  }

  public int getBottomRight(int cord){
    int bottomRight = 0;

    if(cord % 2 == 0){
      if(cord % width == 0){
        bottomRight = cord + 1;
      }
      else{
        bottomRight = cord + 1 + width;
      }
    }
    else{
      bottomRight = cord + 1;
    }

    bottomRight = adjustNum(bottomRight);

    return bottomRight;
    
  }

  public int getBottomLeft(int cord){
    int bottomLeft = 0;
    
    if(cord % 2 == 0){
      bottomLeft = cord - 1 + width;
    }
    else{
      if(cord % width == 1){
        bottomLeft = cord - 1 + width;
      }
      else{
        bottomLeft = cord - 1;
      }
    }

    bottomLeft = adjustNum(bottomLeft);

    return bottomLeft;
  }

  public boolean canMove(int cord1, int cord2){
    Cave cave1 = this.caves.get(cord1);
    Cave cave2 = this.caves.get(cord2);
    
    if(getTop(cord1) == cord2){
      if(cave1.getWall(0) == false && cave2.getWall(3) == false){
        return true;
      }
    }
    if(getTopRight(cord1) == cord2){
      if(cave1.getWall(1) == false && cave2.getWall(4) == false){
        return true;
      }
    }
    if(getBottomRight(cord1) == cord2){
      if(cave1.getWall(2) == false && cave2.getWall(5) == false){
        return true;
      }
    }
    if(getBottom(cord1) == cord2){
      if(cave1.getWall(3) == false && cave2.getWall(0) == false){
        return true;
      }
    }
    if(getBottomLeft(cord1) == cord2){
      if(cave1.getWall(4) == false && cave2.getWall(1) == false){
        return true;
      }
    }
    if(getTopLeft(cord1) == cord2){
      if(cave1.getWall(5) == false && cave2.getWall(2) == false){
        return true;
      }
    }

    return false;
  }
  
}