


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
 String[] Rank1 = { "What console did Microsoft create? ", "What is the feature on xbox that allows people to play online multiplayer games? ", " In what year did Microsoft announce Windows?", "Where did Microsoft's xbox launch party take place? ", "What was Bill Gates and Paul Allen's original name for Microsoft? "};
  String[] Rank2 = { "Microsoft has subsidiary offices in how many countries?", " Does the rolling hills wallpaper of Windows XP actually exist?(Yes/No)", "What is Microsoft's longest lived PC Game ", "Approximately how many emails are blocked by Microsoft email server per day? ", "  When was Microsofts first commerical aired?"};
  String[] Rank3 = {"Who made the original Hunt the Wumpus?", " When was Hunt the Wumpus created?", " What unique device was Hunt the Wumpus able to be played on(the general name)" , "What genre is the Hunt the Wumpus game? ", " How many more Wumpus games did the creator make after making Wumpus 1?"};
  String[] Rank4 = {"In what year was hunt the wumpus listed for the first time in Time's top 100 video games of all time? ", "What is the other animal besides the Wumpus that a user can find within the cave", "What trading cards did hunt the wumpus feature on? ", "What company did Microsoft help avoid bankruptcy", "What was Microsoft's first hardware product"};
  String[] Rank5 = {"Where was the creator of the game born? ","How many series has the creator published","What day did the creator of Hunt the Wumpus die? ","Who was Microsoft's first major deal with? ","What age was Bill Gates when he became a billionaire? "};
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

  public String upgrade(String type, Protagonist prot, Monster wumpus, int tierChoice) {

    // Delcaring Variables \\
    System.out.println("You have " + prot.purse + " coins in your purse");
    this.purchased = "";
    this.type = type;

    // Checking what type of shop it is then putting shop invetory based on shop \\

    if (this.type.equalsIgnoreCase("w")) {
      System.out.println("Welcome to " + BLUE + "Monster Slaying Goods" + RESET);
      wares[0] = RED + this.Swords[tierChoice] + " Price: " + (10 +  (tierChoice*10)) + RESET;
      wares[1] = CYAN + this.Bows[tierChoice] + " Price: " + (10 +  (tierChoice*10)) + RESET;
      wares[2] = PURPLE + this.Knives[tierChoice] + " Price: " + (10 +  (tierChoice*10)) + RESET;
      wares[3] = GREEN + this.Guns[tierChoice] + " Price: " + (10 +  (tierChoice*10)) + RESET;
      wares[4] = YELLOW + this.Specials[tierChoice] + " Price: " + (10 +  (tierChoice*10)) + RESET;
      this.list = 0;
      this.TyPe = "attack";
    }

    else if (this.type.equalsIgnoreCase("a")) {
      System.out.println("Welcome to " + BLUE + "Gus' Armor Shop" + RESET);
      wares[0] = this.Armor[tierChoice] + " Price: " + 10 + (tierChoice*10);
      wares[1] = RED + "None Available" + RESET;
      wares[2] = RED + "None Available" + RESET;
      wares[3] = RED + "None Available" + RESET;
      wares[4] = RED + "None Available" + RESET;
      this.list = 5;
      this.TyPe = "health";
    }

    else if (this.type.equalsIgnoreCase("t")){
        System.out.println("Welcome to " + BLUE + "Crazy Craig's Tools" + RESET);
        wares[0] = RED + this.Pick[tierChoice] + " Price: " + (10 +  (tierChoice*10)) + RESET;
        wares[1] = CYAN + this.Axe[tierChoice] + " Price: " + (10 +  (tierChoice*10)) + RESET;
        wares[2] = PURPLE + this.Shovel[tierChoice] + " Price: " + (10 +  (tierChoice*10)) + RESET;
        wares[3] = GREEN + this.Helmet[tierChoice] + " Price: " + (10 +  (tierChoice*10)) + RESET;
        wares[4] = YELLOW + "None Available" + RESET;
        this.list = 6;
        this.TyPe = "attack";
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
      if (this.choice == 1 && !(this.Swords[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Swords[tierChoice] = "Purchased";
        validPurchase = true;
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        prot.purse -= (10 + (tierChoice*10));
      }
      else if (this.choice == 2 && !(this.Bows[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
          this.Bows[tierChoice] = "Purchased";
          validPurchase = true;
          SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
          prot.purse -= (10 + (tierChoice*10));
        }
      else if (this.choice == 3 && !(this.Knives[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Knives[tierChoice] = "Purchased";
        validPurchase = true;
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        prot.purse -= (10 + (tierChoice*10));
      }
      else if (this.choice == 4 && !(this.Guns[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Guns[tierChoice] = "Purchased";
        validPurchase = true;
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        prot.purse -= (10 + (tierChoice*10));
      }
      else if (this.choice == 5 && !(this.Specials[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Specials[tierChoice] = "Purchased";
        validPurchase = true;
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        prot.purse -= (10 + (tierChoice*10));
      }
      else{
        System.out.println("You are either too poor to buy this item or already have purchased it");
      break;
      }
    }

    else if(this.type.equalsIgnoreCase("a")){
      if(this.choice == 1 && !(this.Armor[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Armor[tierChoice] = "Purchased";
        validPurchase = true;
        prot.purse -= (10 + (tierChoice*10));
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
      }
      else{
        System.out.println("You are either too poor to buy this Item or already have purchased it");
      break;
      }
    }
    

    else{
      if (this.choice == 1 && !(this.Pick[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Pick[tierChoice] = "Purchased";
        validPurchase = true;
        prot.purse -= (10 + (tierChoice*10));
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
      }
      else if (this.choice == 2 && !(this.Axe[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
          this.Axe[tierChoice] = "Purchased";
          validPurchase = true;
          prot.purse -= (10 + (tierChoice*10));
          SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        }
      else if (this.choice == 3 && !(this.Shovel[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Shovel[tierChoice] = "Purchased";
        validPurchase = true;
        prot.purse -= (10 + (tierChoice*10));
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
      }
      else if (this.choice == 4 && !(this.Helmet[tierChoice].equals("Purchased")) && prot.purse >= Protagonist.tier * 10){
        this.Helmet[tierChoice] = "Purchased";
        validPurchase = true;
        prot.purse -= (10 + (tierChoice*10));
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
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
      prot.attack += tierChoice * 5;
    }
    else{
        prot.health += tierChoice * 10;
        prot.truehealth += tierChoice * 10;
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