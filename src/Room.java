import java.util.LinkedHashMap;
import java.util.Map;
public class Room {
  //variables
  private String[][] layout = new String[9][9];
  LinkedHashMap<String, Integer> items = new LinkedHashMap<>();
  //constructor
  public Room() {
    for (int x = 0; x < 9; x++) {
      layout[0][x] = "#";
      layout[8][x] = "#";
    }
    for (int y = 0; y < 9; y++) {
      layout[y][0] = "#";
      layout[y][8] = "#";
    }
  }
  //methods
  //sets all null values to period
  protected String[][] getLayout() {
    return layout;
  }
  protected void setLayout(int x, int y, String text) {
    layout[y][x] = text;
  }
  protected static void setRoom(String[][] layout) {
    for (int i = 0; i < layout.length; i++) {
      for (int j = 0; j < layout[i].length; j++) {
        if (layout[i][j] == null) {
          layout[i][j] = " ";
        }
      }
    }
  }
  //prints room
  protected void printRoom() {
    for (int i = 0; i < layout.length; i++) {
      for (int j = 0; j < layout[i].length; j++) {
        System.out.print(layout[i][j] + " ");
      }
      System.out.println(); // Move to the next line after each row
    }
  }
  protected LinkedHashMap<String, Integer> getItems() {
    return items;
  }
  protected <K, V> K getKeyByIndex(Map<K, V> map, int index) {
    if (map == null || index < 0 || index >= map.size()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }
    int currentIndex = 0;
    for (K key : map.keySet()) {
      if (currentIndex == index) {
        return key;
      }
      currentIndex++;
    }
    throw new IndexOutOfBoundsException("Invalid index");
  }

  protected <K, V> V getValueByIndex(Map<K, V> map, int index) {
    if (map == null || index < 0 || index >= map.size()) {
      throw new IndexOutOfBoundsException("Invalid index");
    }

    int currentIndex = 0;
    for (V value : map.values()) {
      if (currentIndex == index) {
        return value;
      }
      currentIndex++;
    }

    throw new IndexOutOfBoundsException("Invalid index");
  }
}