
//--------------------------- Importing Labs --------------------------------\\

import java.util.Random;


//--------------------------- Monster Class --------------------------------\\

public class Monster {

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

    this.x += random.nextInt(7) - 3;
    this.y += random.nextInt(7) - 3;

  }

  public void death() {


    
    this.drop = this.wumpusDrops[random.nextInt(this.wumpusDrops.length)];
    System.out.println("It dropped " + GREEN + drop + RESET);
    int moneyDrop = (random.nextInt(5)) + 1 * Protagonist.tier;
    if(random.nextInt(100) >= 10){
      System.out.println("You got a special drop: Money x2");
      moneyDrop *= 2;
    }
    if(random.nextInt(100) >= 50){
      System.out.println("You got a special drop: Money x5");
      moneyDrop *= 5;
    }
    if(random.nextInt(100) == 100){
      System.out.println("You got a legendary drop: Money x 10");
      moneyDrop *= 10;
    }
    
    prot.purse += moneyDrop;
    System.out.println("The " + this.type + " dropped " + moneyDrop + " coins.");
    int gained = this.health * this.damage;
    System.out.println("You gained " + gained + " EXP!!");
    prot.EXP += gained;
    if(prot.EXP >= 1 * (Protagonist.tier + 1) && Protagonist.tier < 4){
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

  public void battle() {

    // Variables \\

    boolean battling = true;
    int turn = 1;

    // Printing out infomation for the player \\

    System.out.println("The " + CYAN + this.type + RESET + " has found you!");
    SoundTesting.playSound("!MonsterRoar.wav");
    System.out.println("The " + RED + "battle" + RESET + " has begun");

    // While loop for battling \\

    while (battling) {

      // Turn print statement \\

      System.out
          .println("--------------------------- " + BLUE + "Turn " + turn + RESET + "-------------------------------");

      // Getting user input \\

      protChoice = prot.choice();

      // ------------ Attack choice ------------ \\
      if (protChoice.equals("a")) {

        SoundTesting.playSound("!Bang.wav");

        // Print and dealing damage \\

        System.out.println("You deal " + RED + prot.attack + " damage" + RESET);
        this.health -= prot.attack;

        // Printing Remaing Health points \\

        System.out.println(
            "The " + CYAN + this.type + RESET + " has " + GREEN + this.health + RESET + " health points remaining");

      }

      // ------------ Heal Choice ------------ \\
      else if (protChoice.equals("h")) {

        // Printing out how much heal you as well as adding it \\

        System.out.println("You heal " + GREEN + prot.heal + " health points" + RESET);
        prot.health += prot.heal;
        if(prot.health >= prot.truehealth){
          prot.health = prot.truehealth;
        }

        // Printing out how much health the monster has \\

        System.out.println("The " + CYAN + this.type + RESET + " has " + this.health + " health points remaining");
      }

      // Run away choice \\

      else {

        // Printing you ran away and ending loop

        System.out.println("You ran away");
        this.health = basehealth;
        battling = !battling;
        break;

      }

      // Printint out how much damage the monster does \\

      System.out.println("The " + this.type + " deals " + RED + this.damage + " damage" + RESET);
      prot.health -= this.damage;

      // Printing out your health after turn \\

      System.out.println("You have " + GREEN + prot.health + RESET + " health points remaining");

      // Checking to see if the player is dead \\
      // strongly recommend: use getters + setters
      if (prot.health <= 0) {
        
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
        this.death();
        battling = false;
      }

      // Allowing the monster a chance to escape if its almost dead \\

      else if (this.health <= 5) {

        System.out.println("The " + CYAN + this.type + RESET + " is dying");
        System.out.println("The " + CYAN + this.type + RESET + " ran away");
        this.health = basehealth;
        battling = !battling;

      }

      // counting how many turns

      turn++;

    }

  }
  public void pit(){
    System.out.println("You have fallen into a pit");
    prot.die();
  }
}

// ---------------------------------------------------------------------------\\