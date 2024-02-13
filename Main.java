/*

Hunt The Wumpus

Started on 11/21/2023


Members (Replit User)

NoahWichman
ColeAnderson6
cameronberry
WileyCase
JashandeepChimn
OliverDavis4 (Sudo Member) (Superuser) (Root User)

*/

// ########################################################## //
// IF YOU ARE READING THIS AND HAVE READ THE PROGRAM WRITE UR NAME //
// ########################################################## //
// 
// Cole
// Noah
// Olive oil (you know who)
// Wiley
// Jashan
// Cameron

//------------------------- Importing Libs --------------------------------\\

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.desktop.QuitStrategy;
import javax.swing.*;
import java.awt.event.*;
aaaa
//--------------------------- Main Class -----------------------------------\\

class Main{

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


    // ---------------------------------------------------------------------------\\
    
     Scanner user = new Scanner(System.in);            // Creating A Scanner 
     Random RandomN = new Random();                    // Making Random
     boolean playing = true;                           // Making a Boolean
    
     int[] coordinateList = getRandomLocations();      // Getting A Random Location From a method
    
     Protagonist prot = new Protagonist(15,40, user);  // Creating the Protagonist
    
     Town village = new Town();                        // Making the Village
    
     Monster wumpus = new Monster (coordinateList[0], coordinateList[1], 10, 10, "wumpus", RandomN, prot); // Creating the monster 
     Shop Weaponsmith = new Shop(1, "Monster-Slaying Goods","weapon" );                                    // Creating a shop 

    
    // ---------------------------------------------------------------------------\\


    
     while(playing){                                                              // Playing the game while the boolean is true


       
    // ---------------------------------------------------------------------------\\

       
        System.out.println("Please choose whether you want to Cave, Shop, upgrade, degrade, or break: (c/s/u/d/b)");
                                                             //Each time through the loop it ask the player what it wants to do.
        String townChoice = user.next();                     // Getting user input from prevoius question


       
       // ---------------------------------------------------------------------------\\


       
        if(townChoice.equalsIgnoreCase("c")){                // Checking to see if the user wanted to go to the cave
          System.out.print("Here is your inventory ");       // Telling the user what he has in his inv
          for (var t = 0; t < wumpus.lastID; t++){           // for each item in the user invetory
            System.out.print(prot.inventory[t] + ", ");      // Print the item
          }
          System.out.println();                              // Spacing 
          wumpus.battle();                                   // Fighting the monster in the caves
        }



      // ---------------------------------------------------------------------------\\

  
      
      else if (townChoice.equalsIgnoreCase("s")){                            // Checking to see if the user wanted to go to the shop
        for(var t = 0; t < 25; t++){                                         // Giving the Player's inventory to their Town Storage For every spot in their inv
          prot.inventory[t] = village.Town_Inventory[t + village.value];     //Giving player inv to town
          prot.inventory[t] = "";                                            // Setting player inv to nothing
        }

        
        
        System.out.println("Would you like to go to the Weaponsmith, Armorsmith or Toolsmith? (w/a/t)");
                                                                           // Asking the user speficaly which shop he wants to vist
        String shopChoice = user.next();                                   // Getting the user input
        Weaponsmith.upgrade(shopChoice, prot, wumpus);                     // Opening up the shop
        prot.health = prot.truehealth;                                     // Regaing his healt
      }



      // ---------------------------------------------------------------------------\\


        
      else if(townChoice.equalsIgnoreCase("b")){                            //Checking to see if the user wanted to break
        break;                                                              //Breaking
      }



      // ---------------------------------------------------------------------------\\


        
      else if(townChoice.equalsIgnoreCase("u")){                           //Checking to see if the user wanted to upgrade
        prot.tier += 1;                                                    //adding to his teir
        if(prot.tier == 5){                                                //Making sure it didnt pass max
          prot.tier = 4;                                                   //If the teir passed max going back down
        }
      }



      // ---------------------------------------------------------------------------\\


        
      else if(townChoice.equalsIgnoreCase("d")){                       //Checking to see he wanted to downgrade
        prot.tier -= 1;                                                //Subtracting his teir
        if(prot.tier == -1){                                           //If teir is to low
          prot.tier = 0;                                               //making teir 0
        }
      }



      // ---------------------------------------------------------------------------\\


        
      else{                                               //If the user made a typo
       System.out.println("Sorry, invalid input");        //Telling him to try again
      }
    



    // ---------------------------------------------------------------------------\\


    
    // Ran without error Print statment \\
    System.out.print(RED + "R" + RESET);
    System.out.print(GREEN + "a" + RESET);
    System.out.print(BLUE + "n" + RESET);
    System.out.print(PURPLE + " w" + RESET);
    System.out.print(RED + "i" + RESET);
    System.out.print(YELLOW + "t" + RESET);
    System.out.print(CYAN + "h" + RESET);
    System.out.print(BLUE + "o" + RESET);
    System.out.print(PURPLE + "u" + RESET);
    System.out.print(CYAN + "t" + RESET);
    System.out.print(RED + " E" + RESET);
    System.out.print(PURPLE + "r" + RESET);
    System.out.print(BLUE + "r" + RESET);
    System.out.print(CYAN + "o" + RESET);
    System.out.println(GREEN + "r" + RESET);

  }


  
  // -------------------- Getting A random Location Method -------------------\\

  }
  public static int[] getRandomLocations() {
    Random RandomN = new Random();                // Creating The Random Object 
    int rand_X = RandomN.nextInt(6) + 0;          // Getting the Random Values (0-5) 
    int rand_Y = RandomN.nextInt(6) + 0;          // Getting the Random Values (0-5) 
    return new int[] { rand_X, rand_Y };          // Returning the values in a list 
    //Reccomendation: make a Point data type with getX and getY methods
    //Also getDist() and other methods will make math easier
  }




}

// ---------------------------------------------------------------------------\\

