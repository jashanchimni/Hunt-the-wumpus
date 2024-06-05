import java.awt.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Maze{
  
    
  // PROPERTIES
  private int height;
  private int width;
  private int size;
  private ArrayList<Cave> caves;
  private Random rand;
  Protagonist p;
  Monster monster;

  // CONSTRUCTORS
  public Maze(int width, int height, Protagonist p, Monster monster){
    this.width = width;
    this.height = height;
    this.size = width * height;
    this.caves = new ArrayList<Cave>();
    this.rand = new Random();
    this.p = p;
    this.monster = monster;
    generateMap();
    removeRandomWalls();
    removeRandomWalls();

  }

  // METHODS

  // Loops while the player is in the caves
  // Asks them for a direction and moves the player
  // Actions are performed if the player encounters a hazard
public void caving(){
  Scanner s = new Scanner(System.in);
  int choice = 0;
  Cave current = getCaves().get(1);
  p.move(1, this.caves.get(p.getCord()), this.caves.get(1));

  while(choice != 6){

    draw();
    System.out.println();

    Cave now = this.caves.get(p.getCord());

    for(int i = 0; i < 6; i++){
      Cave check = getCave(now, i);
      Hazard haz = check.getHazard();
      if(haz != null){
        String symbol = haz.getSymbol();
        if(canMove(p.getCord(), check.getCord())){
          if(symbol.equals("M")){
            System.out.println("I smell a Wumpus!");
          }
          if(symbol.equals("B")){
            System.out.println("Bats Nearby");
          }
          if(symbol.equals("P")){
            System.out.println("I feel a draft");
          }
        
        }

      }
    }


    System.out.println();
    System.out.println("Current position: " + p.getCord());
    System.out.print("Enter direction: ");
    choice = s.nextInt();
    while (choice >= 6){
      System.out.println("Sorry, it needs to be below 6 and above -1");
      choice = s.nextInt();
    }
    

    current = getCaves().get(p.getCord());
    Cave next = getCave(current, choice);

    if(next != null){
      if(canMove(current.getCord(), next.getCord())){
        p.move(next.getCord(), current, next);
        
      }
    }

    // Perform action based on hazard
    if(next.getPlayer() && next.getHazard() != null){
      System.out.println();
      int num = next.getHazard().interactWithPlayer();
      if(num == -1){
        System.out.println("You fell to your death!");
        p.die();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        choice = 6;
      }
      if(num == 0){
    System.out.println("You stumble into a monster lair");
    ArrayList<Button>monsterList = new ArrayList<Button>();
    Button fight = new Button("Fight", "f", 2);
    Button run = new Button("Run", "r", 2);
    Button heal = new Button("Heal", "h", 2);
    monsterList.add(fight);
    monsterList.add(run);
    monsterList.add(heal);
    ImageIcon imageIcon = new ImageIcon("BattleGround.jpg");
    JLabel j = new JLabel(imageIcon);
    Menu battleground = new Menu(monsterList, j, "BattleField");
    battleground.draw();
    Main.main.draw();
    monster.battle();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        choice = 6;

      }
      if(num > 0){
        System.out.println("You were picked up by bats!");
        int old = p.getCord();
        int end = rand.nextInt(30) + 1;
        while(end == old){
          end = rand.nextInt(30) + 1;
        }
        next.setHazard(null);
        p.move(end, next, this.caves.get(end));
        placeBat();
      }
    }

    
  }

}


  // Get the maze of caves
  public ArrayList<Cave> getCaves(){
    return this.caves;
  }
  
  // Creates a new, randomized map
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

  // Places hazards randomly into the map
  public void placeHazards(){
    ArrayList<Hazard> hazards = new ArrayList<Hazard>();
    hazards.add(new Bat());
    hazards.add(new Bat());
    hazards.add(new Pit());
    hazards.add(new Pit());
    hazards.add(monster);
    
    while(hazards.size() > 0){
      int randNum = rand.nextInt(this.size - 1) + 2;
      Cave cave = this.caves.get(randNum);
      if(cave.getHazard() == null){
        cave.setHazard(hazards.get(0));
        hazards.remove(0);
      }
    }
  }

  // Places a bat in a random location
  public void placeBat(){
    int randNum = rand.nextInt(this.size) + 1;
    while(caves.get(randNum).getHazard() != null || caves.get(randNum).getPlayer()){
      randNum = rand.nextInt(this.size) + 1;
    }

    caves.get(randNum).setHazard(new Bat());
    
  }

  // Get a random neighboring cave
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

  // Remove walls between 2 caves in a certain direction
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

  // Draws the maze in the console
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

  // Fixes a coordinate so that it is not out of bounds
  public int adjustNum(int num){

    if(num <= 0){
      return this.size + num;
    }

    if(num > this.size){
      return num - this.size;
    }

    return num;
  }

  // Removes random walls between caves, but not if the cave has less than 4 walls
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

  // Gets a neighboring cave in the direction specified
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

  // Returns the cave located to the top
  public int getTop(int cord){
    int top = cord - this.width;
    
    top = adjustNum(top);

    return top;
  }

  // Returns the cave located to the top right
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

  // Returns the cave located to the top left
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

  // Returns the cave located to the bottom
  public int getBottom(int cord){
    int bottom = 0;
    
    bottom = cord + this.width;

    bottom = adjustNum(bottom);

    return bottom;
  }

  // Returns the cave located to the bottom right
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

  // Returns the cave located to the bottom left
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

  // Returns if there is a passageway between two caves
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

  // Gets the coordinate of the monster
  public int getMonsterCord(){
    Hazard h = null;

    for(int i = 1; i <= this.size; i++){
      h = this.caves.get(i).getHazard();
      if(h != null){
        if(h.getSymbol().equals("M")){
          return i;
        }
      }
    }

    return -1;
  }
  
}