package Assignment_4;

import java.util.ArrayList;


class City implements Manageable {
    private String name;
    private ArrayList<Building> buildings;

    public City(String name) {
        this.name = name;
        this.buildings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addBuilding(Building building) {
        buildings.add(building);
    }

    public void removeBuilding(Building building) {
        buildings.remove(building);
    }

    public Building findBuilding(String street, int houseNumber) {
        for (Building building : buildings) {
            if (building.getStreet().equals(street) && building.getHouseNumber() == houseNumber) {
                return building;
            }
        }
        return null;
    }

    @Override
    public void displayInfo() {
        System.out.println("Город: " + name);
        if (buildings.isEmpty()) {
            System.out.println("Нет зданий в этом городе.");
        } else {
            for (Building building : buildings) {
                building.displayInfo();
            }
        }
    }
}