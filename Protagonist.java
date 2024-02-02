//--------------------------- Importing Labs --------------------------------\\

import java.util.Random;
import java.io.*;
import java.util.Scanner;

//--------------------------- Protagonist Class ------------------------------\\

public class Protagonist {

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

  Scanner user;
  int attack;
  int health;
  String choose;
  int heal;
  static int tier;
  int truehealth;
  String[] inventory;
  int cave_X;
  int cave_Y;

  // ------------------------------ Main Method -----------------------------\\

  public Protagonist(int attack, int health, Scanner user) {

    // Delcaring Variables \\

    this.inventory = new String[25];
    this.truehealth = health;
    this.attack = attack;
    this.health = health;
    this.user = user;
    this.heal = 30;
    this.tier = 3;

  }

  // --------------------------- Protagonist Methods ----------------------------\\

  public String choice() {

    // Telling the player his choices
    System.out.print("Would you like to ");
    System.out.print(RED + "attack, (a) " + RESET);
    System.out.print(GREEN + "heal  (h) " + RESET);
    System.out.print("or ");
    System.out.println(BLUE + "run?" + RESET);
    System.out.println("______________________________________________________");
    System.out.println();

    // Getting user input then returning it \\
    choose = user.next();
    return choose;

  }

  public int tierUp() {

    // Adding to teir then returning the value \\
    this.tier += 1;
    return this.tier;

  }

// --------------------------- Mutators + Accesors ----------------------------\\

public Scanner getUser() {
	return user;
}

public void setUser(Scanner user) {
	this.user = user;
}

public int getAttack() {
	return attack;
}

public void setAttack(int attack) {
	this.attack = attack;
}

public int getHealth() {
	return health;
}

public void setHealth(int health) {
	this.health = health;
}

public int getHeal() {
	return heal;
}

public void setHeal(int heal) {
	this.heal = heal;
}

public static int getTier() {
	return tier;
}

public static void setTier(int tier) {
	Protagonist.tier = tier;
}

public int getTruehealth() {
	return truehealth;
}

public void setTruehealth(int truehealth) {
	this.truehealth = truehealth;
}

public String[] getInventory() {
	return inventory;
}

public void setInventory(String[] inventory) {
	this.inventory = inventory;
}
  // Setting the initial cave room
  public void set_Pos(int x, int y){
    this.cave_X = x;
    this.cave_Y = y;
  }
  // Moving one cave room to the right
  public void move_Pos_X(){
    this.cave_X += 1;
  }
  // Moving one Cave room down
  public void move_Pos_Y(){
    this.cave_Y += 1;
  }
  

}


// ---------------------------------------------------------------------------\\