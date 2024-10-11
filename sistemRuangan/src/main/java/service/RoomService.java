// File: service/RoomService.java
package service;


import model.Room;
import java.util.List;

public interface RoomService {
    void addRoom(Room room);
    List<Room> getAllRooms();
    Room getRoomByNumber(String roomNumber);
    boolean updateRoom(String roomNumber, Room updatedRoom);
    boolean deleteRoom(String roomNumber);
}
