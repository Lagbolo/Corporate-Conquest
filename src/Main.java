import java.util.*;

class Main {
  static Scanner scan = new Scanner(System.in);
  static int currentRoom, currentFloor;
  static int x_coord, y_coord;
  static Building building = new Building();
  static Player player = new Player();
  private static TextColours textColour = new TextColours();
  
  public static void main(String[] args) {

    clearScreen();
    currentRoom = 0;
    currentFloor = 0;
    x_coord = 1;
    y_coord = 4;

    //intro screen
    System.out.println("Welcome to.");
    wait(1000);
    clearScreen();
    System.out.println("Welcome to..");
    wait(1000);

    clearScreen();
    System.out.println("Welcome to...");
    wait(1000);
    
    System.out.println();
    System.out.println("_________________________________________________________________________________________________________________________");
    wait(150);
    System.out.println("       _____ _________________ ___________  ___ _____ _____   _____ _____ _   _ _____ _   _ _____ _____ _____ ");
    wait(150);
    System.out.println("      /  __ \\  _  | ___ \\ ___ \\  _  | ___ \\/ _ \\_   _|  ___| /  __ \\  _  | \\ | |  _  | | | |  ___/  ___|_   _|");
    wait(150);
    System.out.println("      | /  \\/ | | | |_/ / |_/ / | | | |_/ / /_\\ \\| | | |__   | /  \\/ | | |  \\| | | | | | | | |__ \\ `--.  | |  ");
    wait(150);
    System.out.println("      | |   | | | |    /|  __/| | | |    /|  _  || | |  __|  | |   | | | | . ` | | | | | | |  __| `--. \\ | |  ");
    wait(150);
    System.out.println("      | \\__/\\ \\_/ / |\\ \\| |   \\ \\_/ / |\\ \\| | | || | | |___  | \\__/\\ \\_/ / |\\  \\  \\/ / |_| | |___/\\__/ / | |  ");
    wait(150);
    System.out.println("       \\____/\\___/\\_| \\_\\_|    \\___/\\_| \\_\\_| |_/\\_/ \\____/   \\____/\\___/\\_|  \\_/\\_/\\_\\___/\\____/\\____/  \\_/  ");
    wait(150);
    System.out.println("_________________________________________________________________________________________________________________________");
    wait(150);

    System.out.println();
    System.out.println();
    System.out.println("--------------------------------------------------  [ENTER] to START  ---------------------------------------------------");
    scan.nextLine();
    System.out.println();
    System.out.println("You are a lowly minumum wage employee of the mega company Money Co.");
    wait(1000);
    System.out.println("You show up everyday to your monotonous nine-to-five just to make ends meet.");
    wait(1000);
    System.out.println("You feel the life being drained from your soul as the mind-numbing stack up upon your desk in your cubicle.");
    wait(1000);
    System.out.println();
    wait(3000);
    System.out.println("As the days drag on, one day you finally decide that you've had enough...");
    wait(3000);

    promptEnterKey();
    clearScreen();
    
    System.out.println("Instructions:");
    wait(500);
    System.out.println("  -Your goal is to reach the top floor in order to overthrow the CEO of Money Co.\n");
    wait(150);
    System.out.println("  -To do this, you must reach the elevator at the end of each floor. \n   For some reason, they are only capable of going up one level. (Probably just to torture the employees...)\n");
    wait(150);
    System.out.println("  -However, between you and the elevators are your pesky coworkers who will do whatever it takes to impede your progress. \n   Unfortunately, this means that they must be... umm, taken care of if, you know what I mean.\n");
    wait(150);
    System.out.println("  -The good news is, the offices are equipped with plenty of useful supplies which I hope you can take advantage of. \n   As long as you have enough money to purchase it, you're good to go.\n");
    wait(150);
    System.out.println("  -One more thing. As you eliminate more employees, you will start to gain experience in this sort of thing. \n   You can use your experience to become more powerful at the end of each floor.\n");
    wait(150);
    System.out.println("  -But BEWARE! Watch out for the manager. They guard the elevators and are much tougher than your ordinary employees.\n");
    wait(150);
    System.out.println("  -You are now set for your conquest! (hopefully) Climb that corporate ladder and let no one stand in your way!\n");
    wait(150);
    System.out.println("  -GOOD LUCK and HAVE FUN!");

    promptEnterKey();
    clearScreen();
    
    //main gameplay loop
    while (true) {
      getCurrentRoom(building, currentFloor, currentRoom).setLayout(x_coord, y_coord, textColour.setColour("P","green"));
      System.out.println("Floor " + (currentFloor + 1) + "/10  Room " + (currentRoom + 1) + "/7");
      System.out.println(textColour.setColour("HP","red")+": " + player.getHP() + "/"+player.getBaseHP()+"  " + textColour.setColour("Money","yellow") + ": " + player.getMoney() + "  " + textColour.setColour("XP","blue") + ": " + player.getXP());
      System.out.println();
      getCurrentRoom(building, currentFloor, currentRoom).printRoom();
      getCurrentRoom(building, currentFloor, currentRoom).setLayout(x_coord, y_coord, " ");
      getInput();
      clearScreen();
    }
  }
  
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
  }

  public static void wait(int timeMs) {
    try {
      Thread.sleep(timeMs);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  
  public static int randInt(int min, int max) {
    Random rand = new Random();
    int randomNum = rand.nextInt((max - min) + 1) + min;
    return randomNum;
  }
  
  public static void promptEnterKey() {
    System.out.print("\n-----[ENTER] to Continue-----\n");
    scan.nextLine();
  }

  public static void inventory(Player player) {
    player.printInventory();
  }

  public static void upgradePlayer(int floor) {
    boolean upgrading = true;
    while (upgrading) {
      clearScreen();
      System.out.println(textColour.setColour("HP","red") + ": " + player.getHP() + "/"+player.getBaseHP() + "  " + textColour.setColour("Money","yellow") + ": " + player.getMoney() + "  " + textColour.setColour("XP","blue") + ": " + player.getXP());
      System.out.println();
      System.out.println(textColour.setColour("Current Stats:","yellow"));
      System.out.println("Max HP: " + player.getBaseHP());
      System.out.println("Base Attack: " + player.getBaseAttack());
      System.out.println("Speed (Turns): " + player.getBaseAP());
      System.out.println();
      System.out.println(textColour.setColour("-----Upgrades-----","yellow"));
      System.out.println("Each upgrade cost " + (floor+7) + " xp.");
      System.out.println("1. HP +1");
      System.out.println("2. Attack +1");
      System.out.println("3. Speed +1");
      System.out.println("4. Skip upgrading (Next upgrades available at end of next floor.");
      
      switch(scan.nextLine().trim().toLowerCase().replaceAll("\s+", "")) {
          
        case "1":
        case "hp+1":
          if (player.getXP() >= floor+7) {
            player.changeXP(-(floor + 7));
            player.changeBaseHP(1);
          }
          else {
            System.out.println("You do not have enough XP for that upgrade.");
            promptEnterKey();
          }
          break;
          
        case "2":
        case "attack+1":
          if (player.getXP() >= floor+7) {
            player.changeXP(-(floor+7));
            player.changeBaseAttack(1);
          }
          else {
            System.out.println("You do not have enough XP for that upgrade.");
            promptEnterKey();
          }
          break;
          
        case "3":
        case "speed +1":
          if (player.getXP() >= (floor+7)) {
            player.changeXP(-(floor+7));
            player.changeBaseAP(1);
          }
          else {
            System.out.println("You do not have enough XP for that upgrade.");
            promptEnterKey();
          }
          break;

        case "4":
        case "skipupgrading":
        case "skip":
        case "no":
        case "n":
          upgrading = false;
          break;

        default:
          System.out.println("Invalid choice. Try again.");
          promptEnterKey();
      }
    }
  }
  
  public static Room getCurrentRoom(Building building, int currentFloor, int currentRoom) {
    return building.getFloors().get(currentFloor).getRooms().get(currentRoom);
  }

  public static void gameOver() {
    clearScreen();
    System.out.println();
    System.out.println(textColour.setColour(" _____   ___  ___  ___ _____   _____  _   _ ___________ ","red"));
    System.out.println(textColour.setColour("|  __ \\ / _ \\ |  \\/  ||  ___| |  _  || | | |  ___| ___ \\","red"));
    System.out.println(textColour.setColour("| |   \\/ /_\\ \\| .  . || |__   | | | || | | | |__ | |_/ /","red"));
    System.out.println(textColour.setColour("| | __ |  _  || |\\/| ||  __|  | | | || | | |  __||    /","red"));
    System.out.println(textColour.setColour("| |_\\ \\| | | || |  | || |___  \\ \\_/ /\\ \\_/ / |___| |\\ \\","red"));
    System.out.println(textColour.setColour(" \\____/\\_| |_/\\_|  |_/\\____/   \\___/  \\___/\\____/\\_| \\_|","red"));
    System.exit(0);
  }

  public static void gameWon() {
    clearScreen();
    System.out.println(textColour.setColour("__   _______ _   _   _    _  _____ _   _ _ ","green"));
    System.out.println(textColour.setColour("\\ \\ / /  _  | | | | | |  | ||  _  | \\ | | |","green"));
    System.out.println(textColour.setColour(" \\ V /| | | | | | | | |  | || | | |  \\| | |","green"));
    System.out.println(textColour.setColour("  \\ / | | | | | | | | |/\\| || | | | . ` | |","green"));
    System.out.println(textColour.setColour("  | | \\ \\_/ / |_| | \\  /\\  / \\_/ / |\\  |_|","green"));
    System.out.println(textColour.setColour("  \\_/  \\___/ \\___/   \\/  \\/ \\___/\\_| \\_(_)","green"));
    System.exit(0);
  }

  public static void move(int x, int y, String text) {
    if (getCurrentRoom(building, currentFloor, currentRoom).getLayout()[y][x].equals(" ")) {
      if (text.equals("w")) {
        y_coord--;
      } 
      else if (text.equals("s")) {
        y_coord++;
      } 
      else if (text.equals("a")) {
        x_coord--;
      } 
      else if (text.equals("d")) {
        x_coord++;
      }
    } 
    else if (getCurrentRoom(building, currentFloor, currentRoom).getLayout()[y][x].equals("#")) {
      //do nothing
    } 
    else if (getCurrentRoom(building, currentFloor, currentRoom).getLayout()[y][x].equals(textColour.setColour("X","red"))) {
      if (combat(true)) {
        getCurrentRoom(building, currentFloor, currentRoom).setLayout(x, y, " ");
      } 
      else {
        gameOver();
      }
    } 
    else if (getCurrentRoom(building, currentFloor, currentRoom).getLayout()[y][x].equals(textColour.setColour("I","yellow"))) {
        if (inShop()) {
          getCurrentRoom(building, currentFloor, currentRoom).setLayout(x, y, " ");
        }
    } 
    else if (getCurrentRoom(building, currentFloor, currentRoom).getLayout()[y][x].equals(textColour.setColour("B", "red"))) {
        if (combat(false)) {
        getCurrentRoom(building, currentFloor, currentRoom).setLayout(x, y, " ");
      } 
      else {
      gameOver();
      }
    }
  }
  
  public static void getInput() {
    System.out.println();
    System.out.println(textColour.setColour("        Legend","yellow"));
    System.out.println(textColour.setColour("P","green") + ": Player      " + textColour.setColour("E","blue") + ": Exit");
    System.out.println(textColour.setColour("X","red") + ": Enemy       " + textColour.setColour("I","yellow") + ": Item");
    System.out.println("#: Wall        " + textColour.setColour("B","red") + ": Boss Fight");
    System.out.println(textColour.setColour("U","purple") + ": Elevator");
    System.out.println();
    System.out.println();
    System.out.println(textColour.setColour("      Actions:","yellow"));
    System.out.println("'W': Move North/Up");
    System.out.println("'S': Move South/Down");
    System.out.println("'A': Move West/Left");
    System.out.println("'D': Move East/Right");
    System.out.println("'[Name of item]': Use Item");
    System.out.println();
    System.out.println();
    System.out.println("Inventory:");
    inventory(player);
    System.out.println();
    System.out.print("Choose an action: ");
    
    switch (scan.nextLine().trim().toLowerCase()) {
      case "w":
        move(x_coord, (y_coord - 1), "w");
        break;
      case "s":
        move(x_coord, (y_coord + 1), "s");
        break;
      case "a":
        if (x_coord == 1 && y_coord == 4) {
          if (getCurrentRoom(building, currentFloor, currentRoom) instanceof CombatRoom || getCurrentRoom(building, currentFloor, currentRoom) instanceof EndRoom || getCurrentRoom(building, currentFloor, currentRoom) instanceof ShopRoom) {
            currentRoom--;
            x_coord = 8;
            y_coord = 4;
          }
        } 
        move((x_coord - 1), y_coord, "a");
        break;
      case "d":
        if (x_coord == 7 && y_coord == 4) {
          if (getCurrentRoom(building, currentFloor, currentRoom) instanceof EndRoom) {
            if (currentFloor == 9) {
            gameWon();
            }
            currentFloor++;
            currentRoom = 0;
            x_coord = 0;
            y_coord = 4;
            player.resetBonusAttack();
            upgradePlayer(currentFloor);
          }
          boolean allEnemiesDead = true;
          for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
              if (getCurrentRoom(building, currentFloor, currentRoom).getLayout()[y][x].equals(textColour.setColour("X", "red"))) {
                allEnemiesDead = false;
              }
            }
          } 
          if (allEnemiesDead) {  
            if (getCurrentRoom(building, currentFloor, currentRoom) instanceof CombatRoom || getCurrentRoom(building, currentFloor, currentRoom) instanceof StartRoom || getCurrentRoom(building, currentFloor, currentRoom) instanceof ShopRoom) {
              currentRoom++;
              player.resetBonusAttack();
              x_coord = 0;
              y_coord = 4;
            }
          } 
          else {
              System.out.println("You must kill all X's before entering next room.");
              promptEnterKey();
          }
        }
        move((x_coord + 1), y_coord, "d");
        break; 
      case "small damage potion":
        if (player.useItem("small damage potion")) {
          player.changeBonusAttack(1);
          System.out.println("You have used small damage potion.");
          promptEnterKey();
        }
        break;
      case "small health potion":
        if (player.useItem("small health potion")) {
          player.changeHP(1);
          if (player.getHP() > player.getBaseHP()) {
            player.resetHPChange();
          }
          System.out.println("You have used small health potion.");
          promptEnterKey();
        }
        break;
      case "medium damage potion":
        if (player.useItem("medium damage potion")) {
          player.changeBonusAttack(2);
          System.out.println("You have used medium damage potion.");
          promptEnterKey();
        }
        break;
      case "medium health potion":
        if (player.useItem("medium health potion")) {
          player.changeHP(3);
          if (player.getHP() > player.getBaseHP()) {
            player.resetHPChange();
          }
          System.out.println("You have used medium health potion");
          promptEnterKey();
        }
        break;
      case "large damage potion":
        if (player.useItem("large damage potion")) {
          player.changeBonusAttack(3);
          System.out.println("You have used large damage potion");
          promptEnterKey();
        }
        break;
      case "large health potion":
        if (player.useItem("large health potion")) {
          player.changeHP(5);
          if (player.getHP() > player.getBaseHP()) {
            player.resetHPChange();
          }
          System.out.println("You have used large health potion");
          promptEnterKey();
        }
        break;
      default:
        System.out.println("Invalid Input. Please choose one of the actions above.");
        promptEnterKey();
    }
  }

  public static boolean inShop() {
    System.out.println();
    int index = randInt(0,5);
    System.out.println("You have stumbled upon a " + getCurrentRoom(building, currentFloor, currentRoom).getKeyByIndex(getCurrentRoom(building, currentFloor, currentRoom).getItems(), index) + ".");
    System.out.println("It costs " + getCurrentRoom(building, currentFloor, currentRoom).getValueByIndex(getCurrentRoom(building, currentFloor, currentRoom).getItems(), index) + " money. Your wallet contains " + player.getMoney() + ".");
    System.out.print("Do you wish to buy? (y/n): ");
    while (true) {  
      String choice = scan.nextLine().trim().toLowerCase();
      switch (choice) {
        case "y":
        case "yes":
          if (player.getMoney() >= getCurrentRoom(building, currentFloor, currentRoom).getValueByIndex(getCurrentRoom(building, currentFloor, currentRoom).getItems(), index)) {
            player.addToInventory(getCurrentRoom(building, currentFloor, currentRoom).getKeyByIndex(getCurrentRoom(building, currentFloor, currentRoom).getItems(), index));
            player.changeMoney(-getCurrentRoom(building, currentFloor, currentRoom).getValueByIndex(getCurrentRoom(building, currentFloor, currentRoom).getItems(), index));
            System.out.println();
            System.out.println("You have purchased " + getCurrentRoom(building, currentFloor, currentRoom).getKeyByIndex(getCurrentRoom(building, currentFloor, currentRoom).getItems(), index));
            promptEnterKey();
            return true;
          } 
          else {
            System.out.println();
             System.out.println("You do not have enough money to purchase this item. Eliminate enemies to obtain more money.");
             promptEnterKey();
             return false;
          }
        case "n":
        case "no":
          return false;
        default:
          System.out.println("Invalid input.");
          System.out.println();
          System.out.print("Do you wish to buy? (y/n): ");
      }
    }
  }

  public static boolean combat(boolean notBossFight) {
    clearScreen();
    int attackStacks, addMoney, addXP, round = 0, totalDamage, totalBlock;
    Entity enemy = null;
    
    //create enemy
    if (notBossFight) {
      switch (randInt(0,3)) {
        case 0:
          enemy = new StandardEnemy(currentFloor);
          break;
        case 1:
          enemy = new FastEnemy(currentFloor);
          break;
        case 2:
          enemy = new TankEnemy(currentFloor);
          break;
        case 3:
          enemy = new StrongEnemy(currentFloor);
          break;
      }
    }
    else {
      enemy = new Boss(currentFloor);
      System.out.println(textColour.setColour("-----------------------------","red"));
      System.out.println(textColour.setColour("     !!!BOSS FIGHT!!!","red"));
      System.out.println(textColour.setColour("-----------------------------","red"));
    }
    
    //combat loop
    System.out.println("You have encountered a(n) " + enemy.getName() + ".");
    System.out.println();
    
    player.resetToBaseAP();
    enemy.resetToBaseAP();
    
    while (true) {
      
      System.out.println("Your " + textColour.setColour("HP","red") + ": " + player.getHP() + "/" + player.getBaseHP() + "  Enemy " + textColour.setColour("HP","red") + ": " + enemy.getHP() + "/" + enemy.getBaseHP());
      round++;
      System.out.println("Round "+round+".");
      System.out.println();

      //round
      //player turn
      attackStacks = 0;
      player.setCurrentExtraAP();
      for (int turn = player.getAP(); turn > 0; turn--) {
        System.out.println("You have "+turn+" turn(s) left.");
        System.out.println("  1. " + textColour.setColour("Attack","red") + " (will deal " + player.getAttack() + " damage)");
        System.out.println("  2. " + textColour.setColour("Block","blue") + " (blocks 1 damage)");
        System.out.println("  3. " + textColour.setColour("Extra Turn","yellow") + " (added to next round)");
        System.out.println("  4. '[Name of item]': Use Item");
        System.out.println();
        System.out.println("Inventory:");
        inventory(player);
        System.out.println();
        System.out.print("Choose an action:  ");
  
        boolean badInput = true;
        while (badInput) {
          badInput = false;
          
          switch (scan.nextLine().trim().toLowerCase()) {
            case "1":
            case "1.":
            case "a":
            case "attack":
              System.out.println("You chose attack.");
              attackStacks++;
              break;
    
            case "2":
            case "2.":
            case "b":
            case "block":
              System.out.println("You chose block.");
              player.addBlockStack();
              break;

            case "3":
            case "3.":
            case "extra turn":
              System.out.println("You chose an extra turn.");
              player.addNextExtraAP();
              break;

            case "small damage potion":
              if (player.useItem("small damage potion")) {
                player.changeBonusAttack(1);
                System.out.println("You have used small damage potion.");
                promptEnterKey();
              }
              break;
            case "small health potion":
              if (player.useItem("small health potion")) {
                player.changeHP(1);
                if (player.getHP() > player.getBaseHP()) {
                  player.resetHPChange();
                }
                System.out.println("You have used small health potion.");
                promptEnterKey();
              }
              break;
            case "medium damage potion":
              if (player.useItem("medium damage potion")) {
                player.changeBonusAttack(2);
                System.out.println("You have used medium damage potion.");
                promptEnterKey();
              }
              break;
            case "medium health potion":
              if (player.useItem("medium health potion")) {
                player.changeHP(3);
                if (player.getHP() > player.getBaseHP()) {
                  player.resetHPChange();
                }
                System.out.println("You have used medium health potion.");
                promptEnterKey();
              }
              break;
            case "large damage potion":
              if (player.useItem("large damage potion")) {
                player.changeBonusAttack(3);
                System.out.println("You have used large damage potion.");
                promptEnterKey();
              }
              break;
            case "large health potion":
              if (player.useItem("large health potion")) {
                player.changeHP(5);
                if (player.getHP() > player.getBaseHP()) {
                  player.resetHPChange();
                }
                System.out.println("You have used large health potion.");
                promptEnterKey();
              }
              break;
              
            default:
              System.out.println("Please select a valid action.");
              badInput = true;
              System.out.println();
              System.out.println("______________________________");
              System.out.println();
              System.out.println("Round "+round+".");
              System.out.println();
              System.out.println("You have "+turn+" turn(s) left.");
              System.out.println("  1. " + textColour.setColour("Attack","red") + " (will deal " + player.getAttack() + " damage)");
              System.out.println("  2. " + textColour.setColour("Block","blue") + " (blocks 1 damage)");
              System.out.println("  3. " + textColour.setColour("Extra Turn","yellow") + " (added to next round)");
              System.out.println("  4. '[Name of item]': Use Item");
              System.out.println();
              System.out.println("Inventory:");
              inventory(player);
              System.out.println();
              System.out.print("Choose an action:  ");
          }
        }
        System.out.println();
        System.out.println("______________________________");
        System.out.println();
      }
      
      totalBlock = (enemy.getBlockStacks() >= attackStacks*player.getAttack()) ? (attackStacks*player.getAttack()):enemy.getBlockStacks();
      totalDamage = (attackStacks*player.getAttack() - totalBlock);

      System.out.println(textColour.setColour("Result:","yellow"));
      System.out.println("  The " + enemy.getName() +" blocked " + totalBlock + " damage.");
      System.out.println("  You have dealt " + totalDamage + " damage.");
      System.out.println("  You have blocked " + player.getBlockStacks() + " time(s).");
      System.out.println("  You have " + player.getNextExtraAP() + " extra turns next round.");

      enemy.resetBlockStacks();
      enemy.changeHP(-totalDamage);
    
      if (enemy.getHP() < 1) {
        System.out.println();
        System.out.println(enemy.getName() + " has been defeated!");
        
        addMoney = randInt(1,3);
        addXP = randInt(1,3);
        player.changeMoney(addMoney);
        player.changeXP(addXP);
        System.out.println("You got " + addMoney + " dollars and " + addXP + " XP.");
        promptEnterKey();
        clearScreen();
        return true;
      }

      promptEnterKey();

      //enemy turn
      attackStacks = 0;
      enemy.setCurrentExtraAP();
      for (int turn = enemy.getAP(); turn > 0; turn--) {
        switch (randInt(0,2)) {
          case 0:
            attackStacks++;
            break;
          case 1:
            enemy.addBlockStack();
            break;
          case 2:
            enemy.addNextExtraAP();
            break;
        }
      }
      
      totalBlock = (player.getBlockStacks() >= attackStacks*enemy.getAttack()) ? (attackStacks*enemy.getAttack()):player.getBlockStacks();
      totalDamage = (attackStacks*enemy.getAttack() - totalBlock);

      System.out.println(textColour.setColour("Enemy Turn:","red"));
      System.out.println("  You blocked " + totalBlock + " damage.");
      System.out.println("  You have received " + totalDamage + " damage.");
      System.out.println("  Enemy has blocked " + enemy.getBlockStacks() + " times.");
      System.out.println("  Enemy has " + enemy.getNextExtraAP() + " extra turns.");
      promptEnterKey();

      player.resetBlockStacks();
      player.changeHP(-totalDamage);
      
      if (player.getHP() < 1) {
        clearScreen();
        return false;
      }
    }
  }
}