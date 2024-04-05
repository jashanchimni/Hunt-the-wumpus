package Maze;

import java.util.ArrayList;
import java.util.Random;

public class Maze{
  
  public static void main(String[] args) {

    Maze myMaze = new Maze(10);

  }

  // PROPERTIES
  private int size;
  private Cave[][] map;
  private Random rand;

  // CONSTRUCTORS
  public Maze(int size){
    this.size = size;
    this.map = new Cave[size][size];
    this.rand = new Random();

    generateMap();
    
    draw();
  }

  // METHODS
  public int getSize(){
    return this.size;
  }

  public void generateMap(){

    for(int y = 0; y < this.size; y++){
      for(int x = y % 2; x < this.size; x+= 2){
        this.map[y][x] = new Cave(this, x, y);
      }
    }

    
    ArrayList<Cave> stack = new ArrayList<Cave>();
    Cave current = this.map[0][0];
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
        removeWalls(current, next);
        current = next;
      }
      else if(stack.size() > 0){
        current = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
      }
    }
    
    
  }

  public Cave getNext(Cave cave){
    int x = cave.getX();
    int y = cave.getY();

    ArrayList<Cave> caves = new ArrayList<Cave>();

    if(x > 0 && y > 0){
      if(!this.map[y-1][x-1].getVisited()){
        caves.add(this.map[y-1][x-1]);
      }
    }
    if(x > 0 && y < this.size - 1){
      if(!this.map[y+1][x-1].getVisited()){
        caves.add(this.map[y+1][x-1]);
      }
    }
    if(x < this.size - 1 && y > 0){
      if(!this.map[y-1][x+1].getVisited()){
        caves.add(this.map[y-1][x+1]);
      }
    }
    if(x < this.size - 1 && y < this.size - 1){
      if(!this.map[y+1][x+1].getVisited()){
        caves.add(this.map[y+1][x+1]);
      }
    }
    if(y < this.size - 2){
      if(!this.map[y+2][x].getVisited()){
        caves.add(this.map[y+2][x]);
      }
    }
    if(y > 1){
      if(!this.map[y-2][x].getVisited()){
        caves.add(this.map[y-2][x]);
      }
    }

    if(caves.size() > 0){
      Cave thing = caves.get(rand.nextInt(caves.size()));
      //System.out.println("Returned: " + thing.cordsToString());
      return thing;
    }
    return null;
  }

  public void removeWalls(Cave cave1, Cave cave2){
    int x1 = cave1.getX();
    int y1 = cave1.getY();
    int x2 = cave2.getX();
    int y2 = cave2.getY();

    int xd = x2-x1;
    int yd = y2-y1;

    //System.out.println(cave1.cordsToString() + " to " + cave2.cordsToString() + " - Xd:" + xd + " Yd:" + yd);

    if(xd == 0 && yd == 2){
      cave1.removeWall(3);
      cave2.removeWall(0);
    }
    if(xd == 0 && yd == -2){
      cave1.removeWall(0);
      cave2.removeWall(3);
    }
    if(xd == 1 && yd == -1){
      cave1.removeWall(1);
      cave2.removeWall(4);
    }
    if(xd == 1 && yd == 1){
      cave1.removeWall(2);
      cave2.removeWall(5);
    }
    if(xd == -1 && yd == 1){
      cave1.removeWall(4);
      cave2.removeWall(1);
    }
    if(xd == -1 && yd == -1){
      cave1.removeWall(5);
      cave2.removeWall(2);
    }

    
    //System.out.println(cave1.printHex(0) + cave2.printHex(0));
    //System.out.println(cave1.printHex(1) + cave2.printHex(1));
    
  }

  public void draw(){
    
    for(int y = 0; y < this.size; y++){
      for(int x = y % 2; x < this.size; x+= 2){
        if(y == 0){
          System.out.print(this.map[y][x].printHex(0));
          System.out.print("   ");
        }
        else if(y % 2 == 1){
          if(y > 0 && x > 0){
            System.out.print(this.map[y-1][x-1].printHex(1));
          }
          System.out.print(this.map[y][x].printHex(0));
        }
        else{
          System.out.print(this.map[y][x].printHex(0));
          if(y > 0 && x < this.size - 1){
            System.out.print(this.map[y-1][x+1].printHex(1));
          }
        }
      }
      System.out.println();
    }
    
    for(int x = (this.size - 1) % 2; x < this.size; x+= 2){
      if((this.size - 1) % 2 == 0){
        System.out.print(this.map[this.size - 1][x].printHex(1));
        System.out.print("   ");
      }
      else{
        System.out.print("   ");
        System.out.print(this.map[this.size - 1][x].printHex(1));
      }
    }

    System.out.println();

    /*
    for(int y = 0; y < this.size - 1; y++){
      for(int x = y % 2; x < this.size; x+= 2){
        System.out.println(this.map[y][x].cordsToString() + " - " + this.map[y][x].wallsToString());
      }
    }
    */
  }
  
}
