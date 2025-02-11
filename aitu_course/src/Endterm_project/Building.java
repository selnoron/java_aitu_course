package Endterm_project;

import java.util.ArrayList;

class Building implements Manageable {
    private int id; // Добавляем поле id
    private String street;
    private int houseNumber;
    private double basePaymentPerSqM;
    private ArrayList<Room> rooms;

    public Building(String street, int houseNumber, double basePaymentPerSqM) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.basePaymentPerSqM = basePaymentPerSqM;
        this.rooms = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public double getBasePaymentPerSqM() {
        return basePaymentPerSqM;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        if (!rooms.contains(room)) { // Проверяем, что комната ещё не добавлена
            rooms.add(room);
        }
    }

    public void removeRoom(Room room) {
        // Удаляем комнату из списка
        rooms.remove(room);

        // Удаляем комнату из базы данных
        Database.deleteRoom(room);
    }

    public double getTotalArea() {
        double totalArea = 0;
        for (Room room : rooms) {
            totalArea += room.getArea();
        }
        return totalArea;
    }

    public void clearRooms() {
        rooms.clear();
    }

    @Override
    public void displayInfo() {
        System.out.println("Здание на улице " + street + ", дом " + houseNumber);
        System.out.println("Базовый платеж за кв.м: " + basePaymentPerSqM + " тенге");
        System.out.println("Общая площадь здания: " + getTotalArea() + " кв.м");

        if (rooms.isEmpty()) {
            System.out.println("Нет комнат в этом здании.");
        } else {
            System.out.println("Комнаты:");
            for (Room room : rooms) {
                room.displayInfo();
            }
        }
    }
}