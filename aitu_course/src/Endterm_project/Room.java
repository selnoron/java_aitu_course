package Endterm_project;

class Room implements Manageable {
    private int id;
    private int number;
    private double area;
    private Building building;

    public Room(int number, double area, Building building) {
        this.number = number;
        this.area = area;
        this.building = building;
        building.addRoom(this);// Сохраняем комнату в базу данных
    }

    public int getNumber() {
        return number;
    }

    public void addRoom_db() {
        Database.saveRoom(this);
    }

    public void deleteRoom_db() {
        Database.deleteRoom(this);
    }

    public int getId() {
        System.out.println(id);
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getArea() {
        return area;
    }

    public Building getBuilding() {
        return building;
    }

    @Override
    public void displayInfo() {
        System.out.println("- Комната " + number + ", Площадь: " + area + " кв.м");
    }
}