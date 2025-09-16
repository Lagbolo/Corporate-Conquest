public class StartRoom extends Room {
  private TextColours textColour = new TextColours();
  public StartRoom() {
    super();
    setLayout(8, 4, textColour.setColour("E","blue"));
    for (int i = 0; i < Main.randInt(2, 3); i++) {
      int x = Main.randInt(2, 7);
      int y = Main.randInt(2, 7);
      if (!(x == 1 && y == 4)) {
        setLayout(x, y, textColour.setColour("X","red"));
      }
    }
    setRoom(getLayout());
  }
}