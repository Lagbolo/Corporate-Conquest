import java.util.ArrayList;
public class Player extends Entity {
  private ArrayList<String> inventory = new ArrayList<>();

  public Player() {
    super();
    baseHP = 10;
    baseAttack = 1;
    baseAP = 3;
    bonusAttack = 0;
    attack = baseAttack+bonusAttack;
    xp = 0;
    money = 0;
  }

  protected ArrayList<String> getInventory() {
    return inventory;
  }
  protected void addToInventory(String item) {
    inventory.add(item);
  }
  
  protected void printInventory() {
    for (String element : inventory) {
      System.out.println(element);
    }
  }
  
  protected boolean useItem(String item) {
    try {
      inventory.remove(item);
      return true;
    } catch (IndexOutOfBoundsException e) {
      System.out.println("You don't have that item.");
      return false;
    }
  }  
}