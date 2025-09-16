import java.util.ArrayList;

public class Floor {
  private ArrayList<Room> rooms = new ArrayList<>();
  
  public Floor() {
    StartRoom startRoom = new StartRoom();
    ShopRoom shopRoom = new ShopRoom();
    EndRoom endRoom = new EndRoom();
    rooms.add(startRoom);
    for (int i = 0; i < 4; i++) {
      CombatRoom room = new CombatRoom();
      rooms.add(room);
    }
    rooms.add(shopRoom);
    rooms.add(endRoom);
  }
  protected ArrayList<Room> getRooms() {
    return rooms;
  }
  protected void addRoom(Room room) {
    rooms.add(room);
  }
  protected void printFloor() {
    for (Room room : rooms) {
      room.printRoom();
    }
  }
}