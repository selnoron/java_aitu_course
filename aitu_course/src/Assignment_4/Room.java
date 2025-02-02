package Assignment_4;

// Room class
class Room implements Manageable {
    private int number;
    private double area;
    private Building building;

    public Room(int number, double area, Building building) {
        this.number = number;
        this.area = area;
        this.building = building;
        building.addRoom(this);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    @Override
    public void displayInfo() {
        System.out.println("- Комната " + number + ", Площадь: " + area + " кв.м");
    }
}