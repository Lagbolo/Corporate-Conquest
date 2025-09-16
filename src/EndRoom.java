public class EndRoom extends Room {
  private TextColours textColour = new TextColours();
  public EndRoom() {
    super();
    setLayout(0, 4, textColour.setColour("E","blue"));
    setLayout(8, 4, textColour.setColour("U","purple"));
    setLayout(7, 4, textColour.setColour("B","red"));
    setRoom(getLayout());
  }
}