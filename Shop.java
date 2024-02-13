//--------------------------- Importing Labs --------------------------------\\

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

  // ----------------------------- Teirs of Items -----------------------------\\

  // WeaponSmith Items
  // Teirs of Swords 0: Copper Broadsword 1: Iron Shortsword 2: Double-gripped
  // Shortsword 3: Hellflame Shortsword 4: Excalibur
  // Teirs of Bows 0: Wooden Longbow 1: Iron Crossbow 2: Temporal Shortbow 3:
  // Phantom's Strike 4: Legend's String
  // Teirs of Knives 0: Common Knife 1: Jagged Shiv 2: Bloodthirsted Knife 3:
  // Ghostly Stabber 4: Champion's Sai
  // Teirs of Guns 0: Shock Eagle 1: GLOCKE 99 2: Reaper 3: HO-HO-HEATER 4: BJ-50
  // Teirs of Specials 0: Ball and Chain 1: Hydro Shurikens 2: The Rimworld 3:
  // Mirror Shield 4: The Sea Breeze Shield

  // AmourSmith Items \\
  // Teirs of Armor 0: Chainmail Armor 1: Phantom Armor 2: Prism Armor 3:
  // Frostspire Gear 4: Champions Mail

  // Toolsmith Items \\
  // Teirs of Pick 0: Steel Pick 1: Bejeweled Pick 2: Corroded Pick 3: Angelic
  // Pick 4: Miner's Gear
  // Teirs of Axe 0: Woodcutter's Axe 1: Hardened Axe 2: Magician's Axe 3: Horn
  // Hatchet 4: Lumberjacked Axe
  // Teirs of Shovel 0: Iron Spade 1: Jackhammer 2: Spacial Shovel 3:
  // Interdimensional Digger 4: Gardner's Spade
  // Teirs of Helmet 0: Santa Cap 1: Baseball Cap 2: Crown of Thorns 3: Champions
  // Crown 4: Helicopter Hat

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
    }

    else if (this.type.equalsIgnoreCase("a")) {
      System.out.println("Welcome to " + BLUE + "Gus' Armor Shop" + RESET);
      wares[0] = this.Armor[Protagonist.tier];
      wares[1] = RED + "None Available" + RESET;
      wares[2] = RED + "None Available" + RESET;
      wares[3] = RED + "None Available" + RESET;
      wares[4] = RED + "None Available" + RESET;
      this.list = 5;
    }

    else {
      if (this.type.equalsIgnoreCase("t")) {
        System.out.println("Welcome to " + BLUE + "Crazy Craig's Tools" + RESET);
        wares[0] = RED + this.Pick[Protagonist.tier] + RESET;
        wares[1] = CYAN + this.Axe[Protagonist.tier] + RESET;
        wares[2] = PURPLE + this.Shovel[Protagonist.tier] + RESET;
        wares[3] = GREEN + this.Helmet[Protagonist.tier] + RESET;
        wares[4] = YELLOW + "None Available" + RESET;
        this.list = 6;
      }
    }

    // Printing the store inventory depending on lenth \\

    for (var g = 0; g < this.wares.length; g++) {
      System.out.println(g + 1 + ". " + this.wares[g]);
    }

    // Asking what the user wants to buy \\

    System.out.print(RESET + "What upgrade would you like to ");
    System.out.print(GREEN + "purchase? " + RESET);
    System.out.println("('1', '2', etc) ");

    // Getting there input

    this.choice = shop.nextInt();

    /// Changing the Shops So the Purchased items show Purchased \\\
    if(this.type.equalsIgnoreCase("w")){
      if (this.choice == 1){
        this.Swords[Protagonist.tier] = "Purchased";
      }
      else if (this.choice == 2){
          this.Bows[Protagonist.tier] = "Purchased";
        }
      else if (this.choice == 3){
        this.Knives[Protagonist.tier] = "Purchased";
      }
      else if (this.choice == 4){
        this.Guns[Protagonist.tier] = "Purchased";
      }
      else if (this.choice == 5){
        this.Specials[Protagonist.tier] = "Purchased";
      }
    }

    else if(this.type.equalsIgnoreCase("a")){
      if(this.choice == 1){
        this.Armor[Protagonist.tier] = "Purchased";
      }
    }

    else{
      if (this.choice == 1){
        this.Pick[Protagonist.tier] = "Purchased";
      }
      else if (this.choice == 2){
          this.Axe[Protagonist.tier] = "Purchased";
        }
      else if (this.choice == 3){
        this.Shovel[Protagonist.tier] = "Purchased";
      }
      else if (this.choice == 4){
        this.Helmet[Protagonist.tier] = "Purchased";
      }
    }

    // Finding out what they bought and returning it \\

    this.purchased = this.wares[choice - 1];
    prot.inventory[wumpus.lastID] = this.purchased;
    if (wumpus.lastID == 24) {
      wumpus.lastID = 23;
      System.out.println(RED + "You're inventory is full! Return to the village to deposit materials.");
      System.out.println("The last item in your inventory will be overwritten" + RESET);
    }
    wumpus.lastID += 1;
    return this.purchased;

  }

}

// ---------------------------------------------------------------------------\\