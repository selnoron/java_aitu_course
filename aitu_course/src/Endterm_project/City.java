package Endterm_project;

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

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    public void clearBuildings() {
        buildings.clear();
    }

    public void removeBuilding(Building building) {
        // Удаляем здание из списка
        buildings.remove(building);

        // Удаляем здание и его комнаты из базы данных
        Database.deleteBuilding(building);
    }

    public Building findBuilding(String street, int houseNumber) {
        for (Building building : buildings) {
            if (building.getStreet().equalsIgnoreCase(street) && building.getHouseNumber() == houseNumber) {
                return building; // Возвращаем найденное здание
            }
        }
        return null; // Если здание не найдено
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