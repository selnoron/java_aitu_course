package Assignment_4;

import java.util.ArrayList;
import java.util.Scanner;

// Interface for manageable entities
interface Manageable {
    void displayInfo();
}

// Main class for testing
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(new City("Астана"));
        cities.add(new City("Алматы"));

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить здание");
            System.out.println("2. Добавить комнату в здание");
            System.out.println("3. Показать информацию о городе");
            System.out.println("4. Выйти");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Введите название города: ");
                String cityName = scanner.nextLine();
                City city = findCity(cities, cityName);
                if (city != null) {
                    System.out.print("Введите улицу: ");
                    String street = scanner.nextLine();
                    System.out.print("Введите номер дома: ");
                    int houseNumber = scanner.nextInt();
                    System.out.print("Введите базовый платеж за кв.м: ");
                    double basePayment = scanner.nextDouble();
                    city.addBuilding(new Building(street, houseNumber, basePayment));
                    System.out.println("Здание добавлено!");
                } else {
                    System.out.println("Город не найден!");
                }
            } else if (choice == 2) {
                System.out.print("Введите название города: ");
                String cityName = scanner.nextLine();
                City city = findCity(cities, cityName);
                if (city != null) {
                    System.out.print("Введите улицу здания: ");
                    String street = scanner.nextLine();
                    System.out.print("Введите номер дома: ");
                    int houseNumber = scanner.nextInt();
                    Building building = city.findBuilding(street, houseNumber);
                    if (building != null) {
                        System.out.print("Введите номер комнаты: ");
                        int roomNumber = scanner.nextInt();
                        System.out.print("Введите площадь комнаты: ");
                        double area = scanner.nextDouble();
                        new Room(roomNumber, area, building);
                        System.out.println("Комната добавлена!");
                    } else {
                        System.out.println("Здание не найдено!");
                    }
                } else {
                    System.out.println("Город не найден!");
                }
            } else if (choice == 3) {
                System.out.print("Введите название города для просмотра информации: ");
                String cityName = scanner.nextLine();
                City city = findCity(cities, cityName);
                if (city != null) {
                    city.displayInfo();
                } else {
                    System.out.println("Город не найден!");
                }
            } else if (choice == 4) {
                System.out.println("Выход из программы...");
                break;
            } else {
                System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
        scanner.close();
    }

    private static City findCity(ArrayList<City> cities, String name) {
        for (City city : cities) {
            if (city.getName().equalsIgnoreCase(name)) {
                return city;
            }
        }
        return null;
    }
}
