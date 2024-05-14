


import java.util.Scanner;

//--------------------------- Shpp Class ------------------------------------\\

public class Shop {

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

  Scanner shop;
  int rank;
  String name;
  String type;
  String purchased;
  int choice;
  String[] wares = new String[5];
  Protagonist prot;
  Monster wumpus;
  int list;
  String[] doneList = new String[5];
  int gold;
  String TyPe;

  

  // ----------------------------- Items in shops -----------------------------\\

  // WeaponSmith
  String[] Swords = { "Copper Broadsword", "Iron Shortsword", "Double-gripped Shortsword", "Hellflame Shortsword",
      "Excalibur" };
  String[] Knives = { "Common Knife", "Jagged Shiv", "Bloodthirsted Knife", "Ghostly Stabber", "Champion's Sai" };
  String[] Bows = { "Wooden Longbow", "Iron Crossbow", "Temporal Shortbow", "Phantom's Strike", "Legend's String" };
  String[] Guns = { "Shock Eagle", "GLOCKE 99", "Reaper", "ForniteScar", "BJ-50" };
  String[] Specials = { "Ball and Chain", "Hydro Shurikens", "The Rimworld", "RC Dynamite", "Star Shield" };

  // AmourSmith
  String[] Armor = { "Chainmail Armor", "Phantom Armor", "Prism Armor", "Frostspire Gear", "Champions Mail" };

  // ToolSmith
  String[] Pick = { "Steel Pick", "Nature Pick", "Corrupt Pick", "Angelic Pick", "JackHammer" };
  String[] Axe = { "Woodcutter's Axe", "Hardened Axe", "Magician's Axe", "Horn Hatchet", "Lumberjacked Axe" };
  String[] Shovel = { "Iron Spade", "Spacial Shovel","Gardner's Spade", "Golden Shovel", "Interdimensional Digger"};
  String[] Helmet = { "Santa Cap", "Baseball Cap", "Princes Crown", "Champions Crown", "Helicopter Hat" };

  String[][] MasterList = {Swords, Knives, Bows, Guns, Specials, Armor, Pick, Axe, Shovel, Helmet};

  // TriviaWizard
  String[] Rank1 = { "What is 5 + 5? ", "What is the color of the Pacific Ocean? ", "What is the largest country in the world? ", "In greek mythology, who was the god of the seas? ", "How many teams are in the NFL? "};
  String[] Rank2 = { "What is the longest day of the year called? ", "How many days are in a leap year? ", "What is the first element in the periodic table? ", "Who is the current king/queen of the UK? ", " Jabba the Hut was the antagonist of what movie series? "};
  String[] Rank3 = {"What is the capital of Australia ?", "How many teams are in the NBA? ", "How many letters is Wiley's last name? ", "What continent is known for their species of bugs", ""};
  String[] Rank4 = {"What is the world’s largest desert?", "Who is the blue starter pokemon", "What is the remaining movement key on the keyboard: W, A, S, ...", "What is the coding language named after a snake", "How much is a bakers dozen"};
  String[] Rank5 = {"Fate of the universe is on the line, martians invading Earth, I pick _____ __________(hint: Max Kellerman) "," Who said the line ' what a bunch of hippy dippy balogne? '"," What is the #1 hardest university to get into in the United States","The E in PEMDAS stands for?","What holiday is a cornacopia associated with?"};
   // ------------------------------ Main Method -----------------------------\\

  public Shop(int rank, String name, String type) {

    // Delcaring Varibles \\

    this.rank = rank;
    this.name = name;
    this.type = type;
    this.shop = new Scanner(System.in);
    this.list = 0;
    

  }

  // ------------------------------ Shop Method -----------------------------\\

  public String upgrade(String type, Protagonist prot, Monster wumpus) {

    // Delcaring Variables \\

    this.purchased = "";
    this.type = type;

    // Checking what type of shop it is then putting shop invetory based on shop \\

    if (this.type.equalsIgnoreCase("w")) {
      System.out.println("Welcome to " + BLUE + "Monster Slaying Goods" + RESET);
      wares[0] = RED + this.Swords[Protagonist.tier] + RESET;
      wares[1] = CYAN + this.Bows[Protagonist.tier] + RESET;
      wares[2] = PURPLE + this.Knives[Protagonist.tier] + RESET;
      wares[3] = GREEN + this.Guns[Protagonist.tier] + RESET;
      wares[4] = YELLOW + this.Specials[Protagonist.tier] + RESET;
      this.list = 0;
      this.TyPe = "attack";
    }

    else if (this.type.equalsIgnoreCase("a")) {
      System.out.println("Welcome to " + BLUE + "Gus' Armor Shop" + RESET);
      wares[0] = this.Armor[Protagonist.tier];
      wares[1] = RED + "None Available" + RESET;
      wares[2] = RED + "None Available" + RESET;
      wares[3] = RED + "None Available" + RESET;
      wares[4] = RED + "None Available" + RESET;
      this.list = 5;
      this.TyPe = "health";
    }

    else if (this.type.equalsIgnoreCase("t")){
        System.out.println("Welcome to " + BLUE + "Crazy Craig's Tools" + RESET);
        wares[0] = RED + this.Pick[Protagonist.tier] + RESET;
        wares[1] = CYAN + this.Axe[Protagonist.tier] + RESET;
        wares[2] = PURPLE + this.Shovel[Protagonist.tier] + RESET;
        wares[3] = GREEN + this.Helmet[Protagonist.tier] + RESET;
        wares[4] = YELLOW + "None Available" + RESET;
        this.list = 6;
        this.TyPe = "attack";
      }

    else if (this.type.equalsIgnoreCase("tm")){
        System.out.println("Welcome to " + BLUE + "Trivia Master" + RESET);
        wares[0] = RED + this.Rank1[Protagonist.tier] + RESET;
        wares[1] = CYAN + this.Rank2[Protagonist.tier] + RESET;
        wares[2] = PURPLE + this.Rank3[Protagonist.tier] + RESET;
        wares[3] = GREEN + this.Rank4[Protagonist.tier] + RESET;
        wares[4] = YELLOW + this.Rank5[Protagonist.tier] + RESET;

    }

    
    
  

    // Printing the store inventory depending on lenth \\

    for (int g = 0; g < this.wares.length; g++) {
      System.out.println(g + 1 + ". " + this.wares[g]);
    }

    // Asking what the user wants to buy \\
    boolean validPurchase = false;
    while(!validPurchase){
    System.out.print(RESET + "What upgrade would you like to ");
    System.out.print(GREEN + "purchase? " + RESET);
    System.out.println("('1', '2', etc) ");

    // Getting there input

    this.choice = shop.nextInt();

    /// Changing the Shops So the Purchased items show Purchased \\\
    if(this.type.equalsIgnoreCase("w")){
      if (this.choice == 1 && !(this.Swords[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Swords[Protagonist.tier] = "Purchased";
        validPurchase = true;
        prot.purse -= Protagonist.tier*10;
      }
      else if (this.choice == 2 && !(this.Bows[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
          this.Bows[Protagonist.tier] = "Purchased";
          validPurchase = true;
          prot.purse -= Protagonist.tier*10;
        }
      else if (this.choice == 3 && !(this.Knives[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Knives[Protagonist.tier] = "Purchased";
        validPurchase = true;
        prot.purse -= Protagonist.tier*10;
      }
      else if (this.choice == 4 && !(this.Guns[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Guns[Protagonist.tier] = "Purchased";
        validPurchase = true;
        prot.purse -= Protagonist.tier*10;
      }
      else if (this.choice == 5 && !(this.Specials[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Specials[Protagonist.tier] = "Purchased";
        validPurchase = true;
        prot.purse -= Protagonist.tier*10;
      }
      else{
        System.out.println("You are either too poor to buy this item or already have purchased it");
      break;
      }
    }

    else if(this.type.equalsIgnoreCase("a")){
      if(this.choice == 1 && !(this.Armor[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Armor[Protagonist.tier] = "Purchased";
        validPurchase = true;
        prot.purse -= Protagonist.tier*10;
      }
      else{
        System.out.println("You are either too poor to buy this Item or already have purchased it");
      break;
      }
    }
    

    else{
      if (this.choice == 1 && !(this.Pick[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Pick[Protagonist.tier] = "Purchased";
        validPurchase = true;
        prot.purse -= Protagonist.tier*10;
      }
      else if (this.choice == 2 && !(this.Axe[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
          this.Axe[Protagonist.tier] = "Purchased";
          validPurchase = true;
          prot.purse -= Protagonist.tier*10;
        }
      else if (this.choice == 3 && !(this.Shovel[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Shovel[Protagonist.tier] = "Purchased";
        validPurchase = true;
        prot.purse -= Protagonist.tier*10;
      }
      else if (this.choice == 4 && !(this.Helmet[Protagonist.tier].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Helmet[Protagonist.tier] = "Purchased";
        validPurchase = true;
        prot.purse -= Protagonist.tier*10;
      }
      else{
        System.out.println("You are either too poor to buy this Item or already have purchased it");
      break;
      }
    }
    }

    // Finding out what they bought and returning it \\
    if(validPurchase){
    this.purchased = this.wares[choice - 1];


    if(this.TyPe.equals("attack")){
      prot.attack += Protagonist.tier * 5;
    }
    else{
        prot.health += Protagonist.tier * 10;
        prot.truehealth += Protagonist.tier * 10;
    }

    prot.inventory[wumpus.lastID] = this.purchased;
    if (wumpus.lastID == 24) {
      wumpus.lastID = 23;
      System.out.println(RED + "You're inventory is full! Return to the village to deposit materials.");
      System.out.println("The last item in your inventory will be overwritten" + RESET);
    }
    wumpus.lastID += 1;
  }
  else{
    this.purchased = "";
  }

    return this.purchased;
  }

}

// ---------------------------------------------------------------------------\\