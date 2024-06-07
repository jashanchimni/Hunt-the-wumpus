


import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
  static String purchased;
  int choice;
  static String[] wares = new String[5];
  static Protagonist prot;
  static Monster wumpus;
  int list;
  String[] doneList = new String[5];
  int gold;
  String TyPe;
  Button ware1;
  Button ware2;
  Button ware3;
  Button ware4;
  Button ware5;
  ArrayList<Button>waresList;
  Menu shopMenu;
  ImageIcon imageIcon;
  JLabel j;
  static String[] Swords;
  static String[] Knives;
  static String[] Bows;
  static String[] Guns;
  static String[] Specials;
  static String[] Armor;
  static String[] Pick;
  static String[] Axe;
  static String[] Shovel;
  static String[] Helmet;
  static String[][] MasterList;
  static Menu WeaponSmith;
  static Menu ToolSmith;
static Menu ArmorSmith;

  // ----------------------------- Items in shops -----------------------------\\

  // WeaponSmith
  
   // ------------------------------ Main Method -----------------------------\\

  public Shop(int rank, String name, String type) {

    // Delcaring Varibles \\
   Swords = new String[]{ "Copper Broadsword", "Iron Shortsword", "Double-gripped Shortsword", "Hellflame Shortsword",
      "Excalibur" };
  Knives = new String[]{ "Common Knife", "Jagged Shiv", "Bloodthirsted Knife", "Ghostly Stabber", "Champion's Sai" };
  Bows = new String[]{ "Wooden Longbow", "Iron Crossbow", "Temporal Shortbow", "Phantom's Strike", "Legend's String" };
  Guns = new String[]{ "Shock Eagle", "GLOCKE 99", "Reaper", "ForniteScar", "BJ-50" };
  Specials = new String[]{ "Ball and Chain", "Hydro Shurikens", "The Rimworld", "RC Dynamite", "Star Shield" };

  // AmourSmith
  Armor = new String[]{ "Chainmail Armor", "Phantom Armor", "Prism Armor", "Frostspire Gear", "Champions Mail" };

  // ToolSmith
  Pick = new String[]{ "Steel Pick", "Nature Pick", "Corrupt Pick", "Angelic Pick", "JackHammer" };
  Axe = new String[]{ "Woodcutter's Axe", "Hardened Axe", "Magician's Axe", "Horn Hatchet", "Lumberjacked Axe" };
  Shovel = new String[]{ "Iron Spade", "Spacial Shovel","Gardner's Spade", "Golden Shovel", "Interdimensional Digger"};
  Helmet = new String[]{ "Santa Cap", "Baseball Cap", "Princes Crown", "Champions Crown", "Helicopter Hat" };

  String[][] MasterList = {Swords, Knives, Bows, Guns, Specials, Armor, Pick, Axe, Shovel, Helmet};
    this.rank = rank;
    this.name = name;
    this.type = type;
    this.shop = new Scanner(System.in);
    this.list = 0;
    

  }

  // ------------------------------ Shop Method -----------------------------\\

  public void upgrade(String type, Protagonist prot, Monster wumpus, int tierChoice) {

    // Delcaring Variables \\
    System.out.println("You have " + prot.purse + " coins in your purse");
    this.purchased = "";
    this.type = type;
    this.prot = prot;

    // Checking what type of shop it is then putting shop invetory based on shop \\

    if (this.type.equalsIgnoreCase("w")) {
      System.out.println("Welcome to " + BLUE + "Monster Slaying Goods" + RESET);
      ware1 = new Button(this.Swords[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 0, 1, tierChoice, 0);
      ware2 = new Button (this.Bows[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 1, 1, tierChoice, 0);
      ware3 = new Button (this.Knives[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 2, 1, tierChoice, 0);
      ware4 = new Button (this.Guns[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 3, 1, tierChoice, 0);
      ware5 = new Button (this.Specials[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 4, 1, tierChoice, 0);
      waresList = new ArrayList<Button>();
      waresList.add(ware1);
      waresList.add(ware2);
      waresList.add(ware3);
      waresList.add(ware4);
      waresList.add(ware5);
      imageIcon = new ImageIcon("BattleGround.jpg");
      j = new JLabel(imageIcon);
      j.setSize(640,480);

      WeaponSmith = new Menu(waresList, j, "Weaponsmith");
      this.list = 0;
      this.TyPe = "attack";
    }

    else if (this.type.equalsIgnoreCase("a")) {
      System.out.println("Welcome to " + BLUE + "Gus' Armor Shop" + RESET);
      ware1 = new Button(this.Armor[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 0, 1, tierChoice, 1);
      ware2 = new Button("None Available", 1, 1, tierChoice, 1);
      ware3 = new Button("None Available", 2, 1, tierChoice, 1);
      ware4 = new Button("None Available", 3, 1, tierChoice, 1);
      ware5 = new Button("None Available", 4, 1, tierChoice, 1);
      waresList = new ArrayList<Button>();
      waresList.add(ware1);
      waresList.add(ware2);
      waresList.add(ware3);
      waresList.add(ware4);
      waresList.add(ware5);
      imageIcon = new ImageIcon("BattleGround.jpg");
      j = new JLabel(imageIcon);
      j.setSize(640,480);
      ArmorSmith = new Menu(waresList, j, "Armorsmith");
      this.list = 5;
      this.TyPe = "health";
    }

    else if (this.type.equalsIgnoreCase("t")){
      ware1 = new Button(this.Pick[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 0, 1, tierChoice, 2);
      ware2 = new Button(this.Axe[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 1, 1, tierChoice, 2);
      ware3 = new Button(this.Shovel[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 2, 1, tierChoice, 2);;
      ware4 = new Button(this.Helmet[tierChoice] + " Price: " + (10 +  (tierChoice*10)), 3, 1, tierChoice, 2);
      ware5 = new Button("None Available", 4, 1, tierChoice, 2);
      waresList = new ArrayList<Button>();
      waresList.add(ware1);
      waresList.add(ware2);
      waresList.add(ware3);
      waresList.add(ware4);
      waresList.add(ware5);
      imageIcon = new ImageIcon("BattleGround.jpg");
      j = new JLabel(imageIcon);
      j.setSize(640,480);
      ToolSmith = new Menu(waresList, j, "Toolsmith");
        this.list = 6;
        this.TyPe = "attack";
      }
    }
    

    

    
    
  

    // Printing the store inventory depending on lenth \\
public static String buy(int tierChoice, int type, int shop){
    // Asking what the user wants to buy \\

    // Getting there input

    /// Changing the Shops So the Purchased items show Purchased \\\
    if(shop == 0){
      if (type == 1 && !(Swords[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
        Swords[tierChoice] = "Purchased";
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        prot.purse -= (10 + (tierChoice*10));
        WeaponSmith.close();
        Main.main.draw();
      }
      else if (type == 2 && !(Bows[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
          Bows[tierChoice] = "Purchased";
          SoundTesting Money = new SoundTesting("!MoneyChing.wav");
          Money.playSound();
          prot.purse -= (10 + (tierChoice*10));
          WeaponSmith.close();
          Main.main.draw();
        }
      else if (type == 3 && !(Knives[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
        Knives[tierChoice] = "Purchased";
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        prot.purse -= (10 + (tierChoice*10));
        WeaponSmith.close();
        Main.main.draw();
      }
      else if (type == 4 && !(Guns[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
        Guns[tierChoice] = "Purchased";
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        prot.purse -= (10 + (tierChoice*10));
        WeaponSmith.close();
        Main.main.draw();
      }
      else if (type == 5 && !(Specials[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
        Specials[tierChoice] = "Purchased";

        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        prot.purse -= (10 + (tierChoice*10));
        WeaponSmith.close();
        Main.main.draw();
      }
      else{
        System.out.println("You are either too poor to buy this item or already have purchased it");
        WeaponSmith.close();
        Main.main.draw();
      }
    }

    else if(shop == 1){
      if(type == 1 && !(Armor[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
        Armor[tierChoice] = "Purchased";
        prot.purse -= (10 + (tierChoice*10));
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        ArmorSmith.close();
        Main.main.draw();
      }
      else{
        System.out.println("You are either too poor to buy this Item or already have purchased it");
        Main.main.draw();
      }
    }
    

    else if(shop == 2){
      System.out.println(prot.purse);
      if (type == 1 && !(Pick[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
        Pick[tierChoice] = "Purchased";
        prot.purse -= (10 + (tierChoice*10));
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        ToolSmith.close();

        Main.main.draw();
      }
      else if (type == 2 && !(Axe[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
          Axe[tierChoice] = "Purchased";
          prot.purse -= (10 + (tierChoice*10));
          SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        ToolSmith.close();
        Main.main.draw();
        }
      else if (type == 3 && !(Shovel[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
        Shovel[tierChoice] = "Purchased";
        prot.purse -= (10 + (tierChoice*10));
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        ToolSmith.close();
        Main.main.draw();
      }
      else if (type == 4 && !(Helmet[tierChoice].equals("Purchased")) && prot.purse >= tierChoice * 10){
        Helmet[tierChoice] = "Purchased";
        prot.purse -= (10 + (tierChoice*10));
        SoundTesting Money = new SoundTesting("!MoneyChing.wav");
        Money.playSound();
        ToolSmith.close();
        Main.main.draw();
      }
      else{
        System.out.println("You are either too poor to buy this Item or already have purchased it");
        ToolSmith.close();
        Main.main.draw();
      }

  return "Hehehehe";
  }

 
    // Finding out what they bought and returning it \\
    purchased = wares[type];


    if(shop%2 == 0){
      prot.attack += tierChoice * 5;
    }
    else{
        prot.health += tierChoice * 10;
        prot.truehealth += tierChoice * 10;
    }

    prot.inventory[wumpus.lastID] = purchased;
    if (wumpus.lastID == 24) {
      wumpus.lastID = 23;
      System.out.println(RED + "You're inventory is full! Return to the village to deposit materials.");
      System.out.println("The last item in your inventory will be overwritten" + RESET);
    }
    wumpus.lastID += 1;
    return purchased;
  }
}

// ---------------------------------------------------------------------------\\