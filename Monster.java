
//--------------------------- Importing Labs --------------------------------\\

import java.util.Random;
import java.util.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


//--------------------------- Monster Class --------------------------------\\

public class Monster extends Hazard{

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

  // Other Variables \\

  int x;
  int y;
  int health;
  int damage;
  String type;
  Random random;
  String[] wumpusDrops;
  Protagonist prot;
  String protChoice;
  int basehealth;
  String drop;
  int lastID;
  

  // ------------------------------ Main Method -----------------------------\\

  public Monster(int x, int y, int health, int damage, String type, Random random, Protagonist prot) {

    // Delcaring Variables \\
    super("M");
    this.random = random;
    this.x = x;
    this.y = y;
    this.health = health;
    this.damage = damage;
    this.type = type;
    this.prot = prot;
    this.lastID = 0;
    this.basehealth = health;
    this.wumpusDrops = new String[] { this.type + " Horn",this.type +  " Horn",this.type +  " Horn",this.type +  " Horn",this.type +  " Teeth",this.type +  " Teeth",this.type +  " Teeth",this.type +  " Guts",this.type +  " Guts",this.type +  " Crown"};
  }

  // --------------------------- Monster Methods ----------------------------\\

  public void run(Monster monster) {

    this.x += random.nextInt(7) - 3;                      //Setting a random x value
    this.y += random.nextInt(7) - 3;                      //Setting a random y value

  }

  

  public void battle() {                                                          //Battle METHod

    // Variables \\
    SoundTesting Roar = new SoundTesting("!MonsterRoar.wav");       //Making a monster roar sound clip
    Roar.playSound();                                                             //Playing the roar
    SoundTesting Battle = new SoundTesting("!Battle.wav");          //Making a battle music sound clip
    Battle.playSound();                                                           //Playing battle music
    boolean battling = true;                                                      //Ma
    int turn = 1;
    ArrayList<Button>monsterList = new ArrayList<Button>();
    Button fight = new Button("Fight", "f");
    Button run = new Button("Run", "r");
    Button heal = new Button("Heal", "h");
    monsterList.add(fight);
    monsterList.add(run);
    monsterList.add(heal);
    ImageIcon imageIcon = new ImageIcon("Cave.gif");
    JLabel j = new JLabel(imageIcon);
    Menu cave = new Menu(monsterList, j);

    System.out.println("The " + CYAN + this.type + RESET + " has found you!");        //Saying what type of monster is attack you
    System.out.println("The " + RED + "battle" + RESET + " has begun");               //Printing the fight statement


    while (battling) {                   //While battling do the following
      

      System.out.println("--------------------------- " + BLUE + "Turn " + turn + RESET + "-------------------------------"); // Turn print statement 
      

      protChoice = prot.choice();                      // Getting user input 

      
      if (protChoice.equals("a")) {          // If they choose to attack:

        

        System.out.println("You deal " + RED + prot.attack + " damage" + RESET);   // Print dealing damage 
        this.health -= prot.attack;                                                //Changing value

        System.out.println("The " + CYAN + this.type + RESET + " has " + GREEN + this.health + RESET + " health points remaining");    // Printing Remaing Health points 

      }

      else if (protChoice.equals("h")) {                                                  //If they choose to heal:
        

        System.out.println("You heal " + GREEN + prot.heal + " health points" + RESET);           //Printing out hwo much they heal
        prot.health += prot.heal;                                                                 //ADd health
        if(prot.health >= prot.truehealth){                                                       //If they have to much health
          prot.health = prot.truehealth;                                                          //Make their health the right amount
        }

        

        System.out.println("The " + CYAN + this.type + RESET + " has " + this.health + " health points remaining"); // Printing out how much health the monster has 
      }

      

      else {                                          // If nothing else assume they choose Run away  

        

        System.out.println("You ran away");   // Printing you ran away 
        this.health = basehealth;               //Reasting health
        Battle.stopSound();                     //Stopping sound
        battling = !battling;                   //End loop
        
        break;                                  //Break

      }

      // Printint out how much damage the monster does \\

      System.out.println("The " + this.type + " deals " + RED + this.damage + " damage" + RESET);
      prot.health -= this.damage;

      // Printing out your health after turn \\

      System.out.println("You have " + GREEN + prot.health + RESET + " health points remaining");

      // Checking to see if the player is dead \\
      // strongly recommend: use getters + setters
      if (prot.health <= 0) {
        Battle.stopSound();

        prot.die();
                battling = false;
      }

      // Warning the player of his low health \\

      else if (prot.health <= 5) {

        System.out.println("You will die next Turn");
        System.out.println("Better Heal Up");

      }

      // Checking to see if the monster is dead \\

      if (this.health <= 0) {
        System.out.println("The " + this.type + " has fallen");
        this.health = basehealth;
        Battle.stopSound();
        this.death();
        battling = false;
      }

      // Allowing the monster a chance to escape if its almost dead \\

      else if (this.health <= 5) {

        System.out.println("The " + CYAN + this.type + RESET + " is dying");
        if(random.nextInt(10) > 9){
        System.out.println("The " + CYAN + this.type + RESET + " ran away");
        this.health = basehealth;
        battling = !battling;
        Battle.stopSound();
        }

      }

      // counting how many turns

      turn++;

    }

  }
  public void death() {
    
    this.drop = this.wumpusDrops[random.nextInt(this.wumpusDrops.length)];
    System.out.println("It dropped " + GREEN + drop + RESET);
    int moneyDrop = (random.nextInt(5)) + 1;
    if(random.nextInt(100) >= 50){
      System.out.println("You got a special drop: Money x2");
      moneyDrop *= 2;
    }
    if(random.nextInt(100) >= 75){
      System.out.println("You got a special drop: Money x5");
      moneyDrop *= 5;
    }
    if(random.nextInt(100) == 100){
      System.out.println("You got a legendary drop: Money x 10");
      moneyDrop *= 10;
    }
    
    prot.purse += moneyDrop;
    System.out.println("The " + this.type + " dropped " + moneyDrop + " coins.");
    int gained = this.health * this.damage / 20;
    System.out.println("You gained " + gained + " EXP!!");
    prot.EXP += gained;
    if(prot.EXP >= (50 * prot.tier) * (Protagonist.tier + 1) && Protagonist.tier < 10){
      prot.EXP = 0;
      Protagonist.tier += 1;
      System.out.println("YOU LEVELED UP TO LEVEL " + Protagonist.tier);
    }
    prot.inventory[prot.lastID] = this.wumpusDrops[random.nextInt(this.wumpusDrops.length)];
    if (prot.lastID == 24) {
      prot.lastID = 23;
      System.out.println(RED + "Your inventory is full! Return to the village to deposit materials.");
      System.out.println("The last item in your inventory will be overwritten" + RESET);
    }
    this.lastID += 1;
    if(this.type.equals("wumpus")){
      System.out.println("You have defeated the wumpus and completed the game!!");
      System.out.println("You ended at Level " + Protagonist.tier + " and " + prot.purse + "coins");
    }
  }
  public void pit(){
    System.out.println("You have fallen into a pit");
    prot.die();
  }
  public void bats(Cave current, Cave next){
    int old = prot.getCord();
    int end = random.nextInt(30) + 1;
    while(end == old){
      end = random.nextInt(30) + 1;
    }
    prot.move(end, current, next);
  }
}

// ---------------------------------------------------------------------------\\