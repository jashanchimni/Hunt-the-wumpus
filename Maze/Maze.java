package Maze;

import java.util.ArrayList;
import java.util.Random;

public class Maze{
  
  public static void main(String[] args) {

    Maze myMaze = new Maze(6, 5);

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

    draw();

  }

  // METHODS
  public void generateMap(){

    caves.add(new Cave(0));
    
    for(int i = 1; i <= this.size; i++){
      caves.add(new Cave(i));
    }

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

  public Cave getNext(Cave current){
    int cord = current.getCord();

    boolean even = (cord % 2 == 0);

    ArrayList<Cave> possible = new ArrayList<Cave>();
    ArrayList<Integer> directions = new ArrayList<Integer>();
    int next = 0;

    // check top
    next = cord - this.width;

    next = adjustNum(next);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(0);
    }

    // check top right
    if(even){
      if(cord % width == 0){
        next = cord + 1 - width;
      }
      else{
        next = cord + 1;
      }
    }
    else{
      next = cord + 1 - width;
    }

    next = adjustNum(next);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(1);
    }

    // check top left
    if(even){
      next = cord - 1;
    }
    else{
      if(cord % width == 1){
        next = cord - 1;
      }
      else{
        next = cord - 1 - width;
      }
    }

    next = adjustNum(next);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(5);
    }

    // check bottom
    next = cord + this.width;

    next = adjustNum(next);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(3);
    }

    // check bottom right
    if(even){
      if(cord % width == 0){
        next = cord + 1;
      }
      else{
        next = cord + 1 + width;
      }
    }
    else{
      next = cord + 1;
    }

    next = adjustNum(next);

    if(!this.caves.get(next).getVisited()){
      possible.add(this.caves.get(next));
      directions.add(2);
    }

    // check bottom left
    if(even){
      next = cord - 1 + width;
    }
    else{
      if(cord % width == 1){
        next = cord - 1 + width;
      }
      else{
        next = cord - 1;
      }
    }

    next = adjustNum(next);

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

}