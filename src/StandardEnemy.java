public class StandardEnemy extends Entity {
  public StandardEnemy(int floor) {
    super();
    name = "Coworker";
    baseHP = 4 + floor;
    baseAttack = 1 + floor;
    baseAP = 3;
  }
}