import java.util.HashMap;
public class TextColours {

  private HashMap<String, String> colours = new HashMap<>();
  
  public static final String resetColour = "\u001B[0m"; //white basically
  public static final String black = "\u001B[30m";
  public static final String red = "\u001B[31m";
  public static final String green = "\u001B[32m";
  public static final String yellow = "\u001B[33m";
  public static final String blue = "\u001B[34m";
  public static final String purple = "\u001B[35m";
  public static final String cyan = "\u001B[36m";
  public static final String white = "\u001B[37m";

  public TextColours() {
    colours.put("resetColour", "\u001B[0m");
    colours.put("black", "\u001B[30m");
    colours.put("red", "\u001B[31m");
    colours.put("green", "\u001B[32m");
    colours.put("yellow", "\u001B[33m");
    colours.put("blue", "\u001B[34m");
    colours.put("purple", "\u001B[35m");
    colours.put("cyan", "\u001B[36m");
    colours.put("white", "\u001B[37m" );
  }
  
  protected String setColour(String text, String colour) {
    return colours.get(colour) + text + colours.get("resetColour");
  }
}