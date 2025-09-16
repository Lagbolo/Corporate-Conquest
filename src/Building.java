import java.util.ArrayList;

public class Building {
  private ArrayList<Floor> floors = new ArrayList<>();
  
  public Building() {
    for (int i = 0; i < 10; i++) {
      Floor floor = new Floor();
      floors.add(floor);
    }
  }
  protected ArrayList<Floor> getFloors() {
    return floors;
  }
}