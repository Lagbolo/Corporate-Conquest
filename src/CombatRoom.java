public class CombatRoom extends Room {
  private TextColours textColour = new TextColours();
  public CombatRoom() {
    super();
    getItems().put("small health potion", 2);
    getItems().put("medium health potion", 5);
    getItems().put("large health potion", 8);
    getItems().put("small damage potion", 2);
    getItems().put("medium damage potion", 5);
    getItems().put("large damage potion", 8);
    setLayout(0, 4, textColour.setColour("E","blue"));
    setLayout(8, 4, textColour.setColour("E","blue"));
    for (int i = 0; i < Main.randInt(4, 6); i++) {
      int x = Main.randInt(2, 7);
      int y = Main.randInt(2, 7);
      if (!(x == 1 && y == 4)) {
        setLayout(x, y, textColour.setColour("X","red"));
      }
    }
    for (int i = 0; i < (Main.randInt(1, 2) + Main.currentFloor); i++) {
      int x = Main.randInt(2, 7);
      int y = Main.randInt(2, 7);
      if (!(x == 1 && y == 4) && getLayout()[y][x] != "X") {
        setLayout(x, y, textColour.setColour("I","yellow"));
      }
    }
    setRoom(getLayout());
  }


}