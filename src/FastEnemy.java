public class FastEnemy extends Entity {
  public FastEnemy(int floor) {
    super();
    name = "Intern";
    baseHP = 3+floor;
    baseAttack = 1+floor;
    baseAP = 4;
  }
}