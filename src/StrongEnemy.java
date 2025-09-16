public class StrongEnemy extends Entity {
  public StrongEnemy(int floor) {
    super();
    name = "Warehouse Worker";
    baseHP = 4+floor;
    baseAttack = 2+floor;
    baseAP = 2;
  }
}