public class Boss extends Entity {
  public Boss(int floor) {
    super();
    switch (Main.randInt(1,7)) {
      case 1:
        name = "Floor Manager";
        break;
      case 2:
        name = "Narc Boss";
        break;
      case 3:
        name = "Micromanager";
        break;
      case 4:
        name = "Karen";
        break;
      case 5:
        name = "Discord Mod";
        break;
      case 6:
        name = "Gorlock the Manager";
        break;
      case 7:
        name = "Toxic Boss";
        break;
    }
    baseHP = 15 + floor;
    baseAttack = 3 + floor;
    baseAP = 2;
  }
}