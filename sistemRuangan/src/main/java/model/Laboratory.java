/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lenovo
 */
// File: model/Laboratory.java

public final class Laboratory extends Room {
    private final String type = "Laboratory";
    
    public Laboratory(String roomNumber, int capacity) {
        super(roomNumber, capacity);
    }

    @Override
    public void displayRoomInfo() {
        System.out.println("Room Number: " + roomNumber + ", Capacity: " + capacity + ", Type: " + type + ", Available: " + isAvailable);
    }
}

