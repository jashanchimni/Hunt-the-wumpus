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


import java.util.Random;
import java.util.Scanner;


//--------------------------- Main Class -----------------------------------\\

public class Main{

  // ------------------------------ COLORS -----------------------------------\\
  
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

  // ------------------------------ Main Method -----------------------------\\

  public static void main(String[] args) {

    //WHEN EVER YOU WANT TO PLAY A SOUND USE THIS FORMAT
    SoundTesting Start = new SoundTesting("!GameboySound.wav");
    Start.playSound();
    // ---------------------------------------------------------------------------\\
    
     Scanner user = new Scanner(System.in);            // Creating A Scanner 
     Random RandomN = new Random();                    // Making Random
     boolean playing = true;                           // Making a Boolean
    
     int[] coordinateList = getRandomLocations();      // Getting A Random Location From a method
    
     Protagonist prot = new Protagonist(15,40, user);  // Creating the Protagonist
    
     Town village = new Town();                        // Making the Village
    
     Monster wumpus = new Monster (coordinateList[0], coordinateList[1], 150, 20, "Wumpus", RandomN, prot); // Creating the Wumpus
     Monster giant = new Monster (coordinateList[0], coordinateList[1], 200, 15, "Giant", RandomN, prot); // Creating the Giant
     Monster kraken = new Monster (coordinateList[0], coordinateList[1], 100, 25, "Kraken", RandomN, prot); // Creating the Kraken
     Monster slime = new Monster (coordinateList[0], coordinateList[1], 50, 5, "Slime", RandomN, prot); // Creating the Slime
     Monster goblin = new Monster (coordinateList[0], coordinateList[1], 15, 7, "Goblin", RandomN, prot); // Creating the Goblin
     Monster curse = new Monster (coordinateList[0], coordinateList[1], 35, 8, "Curse", RandomN, prot); // Creating the Curse 

    Monster[][] monsterList = new Monster[][]{{goblin, slime, curse},{goblin, giant, curse},{kraken, giant, wumpus}};

    Shop Weaponsmith = new Shop(1, "Monster-Slaying Goods","weapon" );                                    // Creating a shop 
    prot.set_Pos(0,0);                                                                                                //Setting the prot to 0 0                                                                                             
    
    // ---------------------------------------------------------------------------\\


    
     while(playing){                                                              // Playing the game while the boolean is true


      
    // ---------------------------------------------------------------------------\\

      
        System.out.println("Please choose whether you want to Cave, Shop, upgrade, degrade, or break: (c/s/u/d/b)"); //Each time through the loop it ask the player what it wants to do.
        String townChoice = user.next();                                                                               // Getting user input from previous question


      
       // ---------------------------------------------------------------------------\\


      int e1;
        if(townChoice.equalsIgnoreCase("c")){                       // Checking to see if the user wanted to go to the cave
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
          Monster encounter = monsterList[e1][ec];                          // Spacing 
          encounter.battle();                                               // Fighting the monster in the caves
        }



      // ---------------------------------------------------------------------------\\

  
      
      else if (townChoice.equalsIgnoreCase("s")){                             // Checking to see if the user wanted to go to the shop
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
          System.out.println("Woah their you havent unlocked that tier yet! "); //Printing out what happended
          tierChoice = e2;                                          //Setting tier choice to tier unlocked
        }
        
        Weaponsmith.upgrade(shopChoice, prot, wumpus, tierChoice);                     // Opening up the shop
        prot.health = prot.truehealth;                                                 // Regaing his healt
      }



      // ---------------------------------------------------------------------------\\


        
      else if(townChoice.equalsIgnoreCase("b")){                            //Checking to see if the user wanted to break
        break;                                                                            //Breaking
      }



      // ---------------------------------------------------------------------------\\


        
      else if(townChoice.equalsIgnoreCase("u")){                           //Checking to see if the user wanted to upgrade
        Protagonist.tier += 1;                                                           //adding to his teir
        if(Protagonist.tier == 5){                                                       //Making sure it didnt pass max
          Protagonist.tier = 4;                                                          //If the teir passed max going back down
        }
      }



      // ---------------------------------------------------------------------------\\


        
      else if(townChoice.equalsIgnoreCase("d")){                       //Checking to see he wanted to downgrade
        Protagonist.tier -= 1;                                                       //Subtracting his teir
        if(Protagonist.tier == -1){                                                  //If teir is to low
          Protagonist.tier = 0;                                                      //making teir 0
        }
      }



      // ---------------------------------------------------------------------------\\


        
      else{                                                 //If the user made a typo
       System.out.println("Sorry, invalid input");        //Telling him to try again
      }
    



    // ---------------------------------------------------------------------------\\

  }


  
  // -------------------- Getting A random Location Method -------------------\\

  }
  public static int[] getRandomLocations() {
    Random RandomN = new Random();                      // Creating The Random Object 
    int rand_X = RandomN.nextInt(6) + 0;          // Getting the Random Values (0-5) 
    int rand_Y = RandomN.nextInt(6) + 0;          // Getting the Random Values (0-5) 
    return new int[] { rand_X, rand_Y };                // Returning the values in a list 

  }




}

// ---------------------------------------------------------------------------\\

