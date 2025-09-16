public class TankEnemy extends Entity {
  public TankEnemy(int floor) {
    super();
    name = "Overweight Coworker";
    baseHP = 5+floor;
    baseAttack = 1+floor;
    baseAP = 2;
  }
}