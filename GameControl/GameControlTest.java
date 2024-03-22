package GameControl;


import java.util.Random;


public class GameControlTest{

public static void main(String args[]){
    GameControlTest myGC = new GameControlTest();

    myGC.createMap();

    myGC.testPlayerSafety();
    
    System.out.println("Hello world!");
}

  // PROPERTIES
  GUITest gui;
  CaveTest[][] map;
  Random die;

  // CONSTRUCTORS
  public GameControlTest(){
    this.gui = new GUITest("Hunt the Wumpus");
    this.map = new CaveTest[3][3];
    this.die = new Random();
  }

  // METHODS
  public void createMap(){
    
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        CaveTest cave = new CaveTest();
        this.map[i][j] = cave;
        this.gui.addCave(cave, i*100, j*100);
      }
    }

    int i = 0;
    while(i < 4){
      String text = "";
      if(i == 0) text = "Pit";
      if(i == 1) text = "Wumpus";
      if(i == 2) text = "Bats";
      if(i == 3) text = "Player";
      int num = die.nextInt(3);
      int num2 = die.nextInt(3);
      if(map[num][num2].getHazard().equals("Empty")){
        map[num][num2].setHazard(text);
        i++;
      }
    }
  
  }

  public void testPlayerSafety(){
    int[] cords = new int[2];

    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 3; j++){
        if(map[i][j].getHazard().equals("Player")){
          cords[0] = i;
          cords[1] = j;
        }
      }
    }

    boolean safe = true;

    // Check Left
    if(cords[1] - 1 >= 0){
      if(!map[cords[0]][cords[1] - 1].getHazard().equals("Empty")){
        safe = false;
      }
    }

    // Check right
    if(cords[1] + 1 < 3){
      if(!map[cords[0]][cords[1] + 1].getHazard().equals("Empty")){
        safe = false;
      }
    }

    // Check up
    if(cords[0] - 1 >= 0){
      if(!map[cords[0] - 1][cords[1]].getHazard().equals("Empty")){
        safe = false;
      }
    }

    // Check down
    if(cords[0] + 1 < 3){
      if(!map[cords[0] + 1][cords[1]].getHazard().equals("Empty")){
        safe = false;
      }
    }

    if(safe){
      System.out.println("Player is safe!");
    }
    else{
      System.out.println("Player is in danger!");
    }
  }
}
