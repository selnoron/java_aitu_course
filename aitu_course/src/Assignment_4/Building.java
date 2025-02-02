package Assignment_4;

import java.util.ArrayList;

// Building class
class Building implements Manageable {
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

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public double getBasePaymentPerSqM() {
        return basePaymentPerSqM;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void displayInfo() {
        System.out.println("Здание на улице " + street + ", дом " + houseNumber);
        System.out.println("Базовый платеж за кв.м: " + basePaymentPerSqM + " тенге");
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