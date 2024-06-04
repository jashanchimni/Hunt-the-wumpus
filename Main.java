/*

Hunt The Wumpus

Started on 11/21/2023


Members (Replit User)

NoahWichman
ColeAnderson6
cameronberry
WileyCase
JashandeepChimn


*/


//------------------------- Importing Libs --------------------------------\\

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


//--------------------------- Main Class -----------------------------------\\

public class Main{
public class ASCIIArt {
    public static void main() {
      System.out.println(" ___ ___               __                    ");
      System.out.println("/   |   \\ __ __  _____/  |_                  ");
      System.out.println("/    ~    \\  |  \\/    \\   __\\                 ");
      System.out.println("\\    Y    /  |  /   |  \\  |                   ");
      System.out.println(" \\___|_  /|____/|___|  /__|                   ");
      System.out.println("       \\/            \\/                       ");
      System.out.println("  __  .__                                      ");
      System.out.println("_/  |_|  |__   ____                           ");
      System.out.println("\\   __\\  |  \\_/ __ \\                          ");
      System.out.println(" |  | |   Y  \\  ___/                          ");
      System.out.println(" |__| |___|  /\\___  >                         ");
      System.out.println("           \\/     \\/                          ");
      System.out.println(" __      __                                    ");
      System.out.println("/  \\    /  \\__ __  _____ ______  __ __  ______");
      System.out.println("\\   \\/\\/   /  |  \\/     \\\\____ \\|  |  \\/  ___/");
      System.out.println(" \\        /|  |  /  Y Y  \\  |_> >  |  /\\___ \\ ");
      System.out.println("  \\__/\\  / |____/|__|_|  /   __/|____//____  >");
      System.out.println("       \\/              \\/|__|              \\/ ");
    }
}
  // ------------------------------ COLORS -----------------------------------\\
  public static ArrayList<Button>mainButtons = new ArrayList<Button>();
  static final String BLACK = "\u001B[30m";
  static final String RED = "\u001B[31m";
  static final String GREEN = "\u001B[32m";
  static final String YELLOW = "\u001B[33m";
  static final String BLUE = "\u001B[34m";
  static final String PURPLE = "\u001B[35m";
  static final String CYAN = "\u001B[36m";
  static final String WHITE = "\u001B[37m";
  static final String BLACK_BACKGROUND = "\u001B[40m";
  static final String RED_BACKGROUND = "\u001B[41m";
  static final String GREEN_BACKGROUND = "\u001B[42m";
  static final String YELLOW_BACKGROUND = "\u001B[43m";
  static final String BLUE_BACKGROUND = "\u001B[44m";
  static final String PURPLE_BACKGROUND = "\u001B[45m";
  static final String CYAN_BACKGROUND = "\u001B[46m";
  static final String WHITE_BACKGROUND = "\u001B[47m";
  static final String RESET = "\u001B[0m";
    public static Menu main;
     static Scanner user = new Scanner(System.in);            // Creating A Scanner 
     static Random RandomN = new Random();                    // Making Random
     static boolean playing = true;                           // Making a Boolean
    
     static int[] coordinateList = getRandomLocations();      // Getting A Random Location From a method
    
     static Protagonist prot = new Protagonist(15,40, user);  // Creating the Protagonist
    
     static  Town village = new Town();                        // Making the Village
    
     static Monster wumpus = new Monster (coordinateList[0], coordinateList[1], 150, 20, "Wumpus", RandomN, prot); // Creating the Wumpus
     static  Monster giant = new Monster (coordinateList[0], coordinateList[1], 200, 15, "Giant", RandomN, prot); // Creating the Giant
     static Monster kraken = new Monster (coordinateList[0], coordinateList[1], 100, 25, "Kraken", RandomN, prot); // Creating the Kraken
     static  Monster slime = new Monster (coordinateList[0], coordinateList[1], 50, 5, "Slime", RandomN, prot); // Creating the Slime
     static Monster goblin = new Monster (coordinateList[0], coordinateList[1], 15, 7, "Goblin", RandomN, prot); // Creating the Goblin
     static Monster curse = new Monster (coordinateList[0], coordinateList[1], 35, 8, "Curse", RandomN, prot); // Creating the Curse 

     static Monster[][] monsterList = new Monster[][]{{goblin, slime, curse},{goblin, giant, curse},{kraken, giant, wumpus}};

     static Shop Weaponsmith = new Shop(1, "Monster-Slaying Goods","weapon" ); 

  // ------------------------------ Main Method -----------------------------\\
  public Main(){
    ASCIIArt newt = new ASCIIArt();
    newt.main();
  }
  public static void main(String[] args) {
    //Askey Art
    System.out.println();

    
    System.out.println("Welcome to Hunt the Wumpus, a game where you will embark on a journey to slay the wumpus and save the town of Fierro");
    
    SoundTesting Start = new SoundTesting("!GameboySound.wav");
    Start.playSound();
    // ---------------------------------------------------------------------------\\
    while (playing){
    Button shop = new Button("Shop", "s", 0);
    Button cave = new Button("Cave", "c", 0);
    Button trivia = new Button("Trivia", "t", 0);
    mainButtons.add(shop);
    mainButtons.add(cave);
    mainButtons.add(trivia);
    ImageIcon imageIcon = new ImageIcon("Cave.gif");
    JLabel j = new JLabel(imageIcon);
    main = new Menu(mainButtons, j, "Main Menu");                                                       // Playing the game while the boolean is true
    playing = !playing;

    }
    // ---------------------------------------------------------------------------\\                                                                             // Getting user input from previous question


      
       // ---------------------------------------------------------------------------\\


      

      // ---------------------------------------------------------------------------\



      // ---------------------------------------------------------------------------\\



      // ---------------------------------------------------------------------------\\
    



    // ---------------------------------------------------------------------------\\

  } 
  // -------------------- Getting A random Location Method -------------------\\

  public static int[] getRandomLocations() {
    Random RandomN = new Random();                      // Creating The Random Object 
    int rand_X = RandomN.nextInt(6) + 0;          // Getting the Random Values (0-5) 
    int rand_Y = RandomN.nextInt(6) + 0;          // Getting the Random Values (0-5) 
    return new int[] { rand_X, rand_Y };                // Returning the values in a list 

  }

  public static void choice(String h){
main.close();
System.out.println(h);

int e1;
        if(h.equals("c")){   
                            // Checking to see if the user wanted to go to the cave
          System.out.println("You have " + prot.purse + " coins in your purse");  // Showing the user's Purse
          System.out.print("Here is your inventory ");                          // Telling the user what he has in his inv
          for (int t = 0; t < wumpus.lastID; t++){                                // for each item in the user invetory
            System.out.print(prot.inventory[t] + ", ");                           // Print the item
          }
          System.out.println();                                                   //Spacing out everything
          
          
          if(Protagonist.tier <= 3){            // Choosing the monster to fight
            e1 = 0;                             //Setting e1 to teir 0 if the hero is low level
          } 
          else if(Protagonist.tier <= 6){       //If hero is higher level
            e1 = 1;                             //Set e1 to teir 1
          }
          else{                                 //If hero is above all other levels
            e1 = 2;                             //Set e1 to 2
          }
          int ec = RandomN.nextInt(3);                                //Setting ec to a random num
          Monster encounter = monsterList[e1][ec];
          Maze m = new Maze(6,5,prot,encounter);
          m.caving();                          // Spacing                                                // Fighting the monster in the caves
        }



      // ---------------------------------------------------------------------------\\

  
      
      else if (h.equals("s")){                            // Checking to see if the user wanted to go to the shop
        SoundTesting shopEnter = new SoundTesting("!AnvilHit.wav");           //making a sound clip
        shopEnter.playSound();                                                              //Playing the shop Sound
        
        for(int t = 0; t < 25; t++){                                         // Giving the Player's inventory to their Town Storage For every spot in their inv
          prot.inventory[t] = village.Town_Inventory[t + village.value];     //Giving player inv to town
          prot.inventory[t] = "";                                            // Setting player inv to nothing
        }

        village.value += 25;                                                //Setting village value to 25
        wumpus.lastID = 0;                                                  //Resasting the lastID


        

        
        System.out.println("Would you like to go to the Weaponsmith, Armorsmith or Toolsmith? (w/a/t)");                                                        // Asking the user speficaly which shop he wants to vist
        String shopChoice = user.next();
        int e2;                                                                                                                          //Getting the user input 
        if(Protagonist.tier <= 2){            // Choosing the monster to fight
            e2 = 0;                             //Setting e1 to teir 0 if the hero is low level
          } 
          else if(Protagonist.tier <= 4){       //If hero is higher level
            e2 = 1;                             //Set e1 to teir 1
          }
          else if(Protagonist.tier <= 6){                                 //If hero is above all other levels
            e2 = 2;                             //Set e1 to 2
          }
          else if(Protagonist.tier <= 8){                                 //If hero is above all other levels
            e2 = 3;                             //Set e1 to 2
          }
          else {                                 //If hero is above all other levels
            e2 = 4;                             //Set e1 to 2
          }
        System.out.println("What tier of shop would you like to view? Any tier above your current tier bracket " + e2 + " will be taken as your current tier bracket. ");  //Asking which shop tier they want to shop at
        
        int tierChoice = user.nextInt();                                                                                                                          //Getting the user input

        if(tierChoice > Protagonist.tier){                                        //Checking to make sure tier is ok
          System.out.println("Woah there you havent unlocked that tier yet! "); //Printing out what happended
          tierChoice = e2;                                          //Setting tier choice to tier unlocked
        }
        
        Weaponsmith.upgrade(shopChoice, prot, wumpus, tierChoice);                     // Opening up the shop
        prot.health = prot.truehealth;                                                 // Regaing his healt
      }
      else if(h.equals("t")){
        Trivia.main();
        System.out.println("Hello World");
      }


  }




}

// ---------------------------------------------------------------------------\\

