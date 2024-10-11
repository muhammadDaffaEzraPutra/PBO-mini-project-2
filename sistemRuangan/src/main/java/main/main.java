package main;

import model.Classroom;
import model.Laboratory;
import model.Room;
import service.RoomService;
import service.RoomServiceImpl;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        RoomService roomService = new RoomServiceImpl();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("==== Campus Room Management ====");
            System.out.println("1. Add Room");
            System.out.println("2. Display All Rooms");
            System.out.println("3. Search Room");
            System.out.println("4. Update Room");
            System.out.println("5. Delete Room");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.println("Add Room (1. Classroom, 2. Laboratory)");
                    int roomType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Room Number: ");
                    String roomNumber = scanner.nextLine();
                    System.out.print("Enter Room Capacity: ");
                    int capacity = scanner.nextInt();
                    
                    if (roomType == 1) {
                        Room classroom = new Classroom(roomNumber, capacity);
                        roomService.addRoom(classroom);
                    } else if (roomType == 2) {
                        Room laboratory = new Laboratory(roomNumber, capacity);
                        roomService.addRoom(laboratory);
                    }
                    break;
                    
                case 2:
                    System.out.println("All Rooms:");
                    for (Room room : roomService.getAllRooms()) {
                        room.displayRoomInfo();
                    }
                    break;
                    
                case 3:
                    System.out.print("Enter Room Number: ");
                    String searchRoomNumber = scanner.nextLine();
                    Room room = roomService.getRoomByNumber(searchRoomNumber);
                    if (room != null) {
                        room.displayRoomInfo();
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                    
                case 4:
                    System.out.print("Enter Room Number to Update: ");
                    String updateRoomNumber = scanner.nextLine();
                    System.out.print("Enter New Room Capacity: ");
                    int newCapacity = scanner.nextInt();
                    Room updatedRoom = new Classroom(updateRoomNumber, newCapacity); // Contoh update
                    boolean updated = roomService.updateRoom(updateRoomNumber, updatedRoom);
                    if (updated) {
                        System.out.println("Room updated successfully.");
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                    
                case 5:
                    System.out.print("Enter Room Number to Delete: ");
                    String deleteRoomNumber = scanner.nextLine();
                    boolean deleted = roomService.deleteRoom(deleteRoomNumber);
                    if (deleted) {
                        System.out.println("Room deleted successfully.");
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                    
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
