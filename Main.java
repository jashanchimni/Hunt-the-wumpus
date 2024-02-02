//Noah Wichman and Cole Anderson
//Hunt The Wumpus
//11/21/2023
//Period 6


// REiber probaly wants us to have a team of 3 becs that what the slides said 3-8
// I can be a pseudo-member ig -oliver kemper


// Random Maze
/* HOW TO MAKE THE RANDOM MAZE
//Get 3 random location on a 5 by 5 grid (maybe 5 x 5 x 5) 
//Make sure the 3 random locations ARE NOT one the same tile
//Define location as a bottom less pit
//One location as Wumpus
//One location as Bats


*/

//3 judges 
//TO THE SPEC
//CREATIVTY / innovative (???)
//CODE IS CLEAN











//------------------------- Importing Labs --------------------------------\\

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import java.awt.desktop.QuitStrategy;
import javax.swing.*;
import java.awt.event.*;

//--------------------------- Main Class -----------------------------------\\

class Main implements ActionListener{

  // ------------------------------ COLORS -----------------------------------\\
// import java.awt.Color;
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

    // ------------------------------ General Frameing -----------------------------\\
    
    JFrame jf = new JFrame(" --------------------------------------------------- Hunt the Wumpus! --------------------------------------------------- ");                  
                                                       // Making frame 
    JPanel p = new JPanel();                           // Making a Panel 
    jf.setSize(1366, 768);                              // Making frame visable 
    jf.add(p);                                         // Ading panel to frame

    
    Gui gui = new Gui();         //Gui - where input gets sent to b/c Main is static
    
    
    
    MyButton startButton = new MyButton("Start");  //Making a start button
    p.add(startButton);                                          //Adding start button to panel

    MyButton caveButton = new MyButton("Cave");   //Making a cave button
    p.add(caveButton);                                          //Adding cave button to panel
    caveButton.setIcon("Images/Monsters/Wumpus.jpeg", 200, 300);


    /*
    JButton cave = imageBtn("Images/Monsters/Wumpus.jpeg", 200, 300);       // Making Cave button 
    JButton quit = imageBtn("Images/Meun-Items/Quit.jpg", 200, 300);        // Making Quit button 
    JButton shop = imageBtn("Images/Meun-Items/Shop.png", 200, 300);       // Making Shop button 
    JButton upgrade   = imageBtn("Images/Meun-Items/Up.png", 200, 300);    // Making Up button 
    JButton downgrade = imageBtn("Images/Meun-Items/Down.png", 200, 300);  // Making Down button 


    p.add(cave);                                            // Ading button to panel
    cave.addActionListener(gui);
    p.add(quit);                                            // Ading button to panel 
    quit.addActionListener(gui);
    p.add(shop);                                            // Ading button to panel 
    p.add(upgrade);                                         // Ading button to panel 
    p.add(downgrade);                                       // Ading button to panel 

    cave.setLocation(50, 100);                              // Setting the location of the button 
    quit.setLocation(50, 100);                              // Setting the location of the button 
    shop.setLocation(50, 100);                              // Setting the location of the button 
    upgrade.setLocation(50, 100);                           // Setting the location of the button 
    downgrade.setLocation(50, 100);                         // Setting the location of the button 
    */

    jf.setVisible(true);                               // Making the frame visable
    jf.setLayout(null);                                // Setting Layout
    p.setLayout(null);                                 // Setting Layout
    
    //Action listener


    // ---------------------------------------------------------------------------\\
    
     Scanner user = new Scanner(System.in);            // Creating A Scanner 
     Random RandomN = new Random();                    // Making Random
     boolean playing = true;                           // Making a Boolean
     int[] coordinateList = getRandomLocations();      // Getting A Random Location From a method
     Protagonist prot = new Protagonist(15,40, user);  // Creating the Protagonist
    Town village = new Town();
    
     Monster wumpus = new Monster (coordinateList[0], coordinateList[1], 10, 10, "wumpus", RandomN, prot); // Creating the monster 
     Shop Weaponsmith = new Shop(1, "Monster-Slaying Goods","weapon" );                                    // Creating the a shop 

    
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


        /*  
      else if (townChoice.equalsIgnoreCase("s")){
        for(var t = 0; t < 25; t++){
          prot.inventory[t] = village.Town_Inventory[t + village.value]
        }
        */
        //village.Town_Inventory = prot.inventory
        
        // Checking to see if the user wanted to go to the shop
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
    // Close the scanner so that the program properly ends
    user.close();
  }


  
  // -------------------- Getting A random Location Method -------------------\\

  public static int[] getRandomLocations() {
    Random RandomN = new Random();                // Creating The Random Object 
    int rand_X = RandomN.nextInt(6) + 0;          // Getting the Random Values (0-5) 
    int rand_Y = RandomN.nextInt(6) + 0;          // Getting the Random Values (0-5) 
    return new int[] { rand_X, rand_Y };          // Returning the values in a list 
    //Reccomendation: make a Point data type with getX and getY methods
    //Also getDist() and other methods will make math easier
  }


  // ------------------------ actionPerformed ------------------------ \\
  public void actionPerformed(ActionEvent e){
    System.out.println("buh");
  }
}

// ---------------------------------------------------------------------------\\

