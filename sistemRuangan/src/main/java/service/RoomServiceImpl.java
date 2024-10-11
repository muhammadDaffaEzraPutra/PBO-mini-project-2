/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Lenovo
 */


import model.Room;
import java.util.ArrayList;
import java.util.List;

public class RoomServiceImpl implements RoomService {
    private static List<Room> roomList = new ArrayList<>(); // Static ArrayList

    @Override
    public void addRoom(Room room) {
        roomList.add(room);
        System.out.println("Room added successfully.");
    }

    @Override
    public List<Room> getAllRooms() {
        return roomList;
    }

    @Override
    public Room getRoomByNumber(String roomNumber) {
        for (Room room : roomList) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    @Override
    public boolean updateRoom(String roomNumber, Room updatedRoom) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null) {
            room.setRoomNumber(updatedRoom.getRoomNumber());
            room.setCapacity(updatedRoom.getCapacity());
            room.setAvailable(updatedRoom.isAvailable());
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRoom(String roomNumber) {
        Room room = getRoomByNumber(roomNumber);
        if (room != null) {
            roomList.remove(room);
            return true;
        }
        return false;
    }
}
