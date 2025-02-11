package Endterm_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {
    private City city;
    private JTextArea infoTextArea;

    public MainGUI(City city) {
        this.city = city;
        setTitle("Urban Housing Registry");
        setSize(600, 500); // Увеличим размер окна для удобства
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1)); // Добавим больше кнопок

        JButton addBuildingButton = new JButton("Добавить здание");
        JButton addRoomButton = new JButton("Добавить комнату");
        JButton removeBuildingButton = new JButton("Удалить здание");
        JButton removeRoomButton = new JButton("Удалить комнату");
        JButton showInfoButton = new JButton("Показать информацию");
        JButton findBuildingButton = new JButton("Найти здание");

        // Обработчик для добавления здания
        addBuildingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addBuilding();
            }
        });

        // Обработчик для добавления комнаты
        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRoom();
            }
        });

        // Обработчик для удаления здания
        removeBuildingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBuilding();
            }
        });

        // Обработчик для удаления комнаты
        removeRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeRoom();
            }
        });

        // Обработчик для показа информации
        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showInfo();
            }
        });

        // Обработчик для поиска здания
        findBuildingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                findBuilding();
            }
        });

        // Добавляем кнопки на панель
        buttonPanel.add(addBuildingButton);
        buttonPanel.add(addRoomButton);
        buttonPanel.add(removeBuildingButton);
        buttonPanel.add(removeRoomButton);
        buttonPanel.add(showInfoButton);
        buttonPanel.add(findBuildingButton);

        // Создаем текстовое поле для вывода информации
        infoTextArea = new JTextArea();
        infoTextArea.setEditable(false); // Запрещаем редактирование
        JScrollPane scrollPane = new JScrollPane(infoTextArea); // Добавляем скроллбар

        // Добавляем панель с кнопками и текстовое поле на основное окно
        add(buttonPanel, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Метод для добавления здания
    private void addBuilding() {
        String street = JOptionPane.showInputDialog(this, "Введите улицу:");
        int houseNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите номер дома:"));
        double basePayment = Double.parseDouble(JOptionPane.showInputDialog(this, "Введите базовый платеж за кв.м:"));
        Building building = new Building(street, houseNumber, basePayment);
        city.addBuilding(building);
        Database.saveBuilding(building); // Сохраняем здание в базу данных
        JOptionPane.showMessageDialog(this, "Здание добавлено!");
    }

    // Метод для добавления комнаты
    private void addRoom() {
        String street = JOptionPane.showInputDialog(this, "Введите улицу здания:");
        int houseNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите номер дома:"));
        Building building = city.findBuilding(street, houseNumber);
        if (building != null) {
            int roomNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите номер комнаты:"));
            double area = Double.parseDouble(JOptionPane.showInputDialog(this, "Введите площадь комнаты:"));
            Room room = new Room(roomNumber, area, building);
            room.addRoom_db();
            JOptionPane.showMessageDialog(this, "Комната добавлена!");
        } else {
            JOptionPane.showMessageDialog(this, "Здание не найдено!");
        }
    }

    // Метод для удаления здания
    private void removeBuilding() {
        String street = JOptionPane.showInputDialog(this, "Введите улицу здания:");
        int houseNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите номер дома:"));
        Building building = city.findBuilding(street, houseNumber);
        if (building != null) {
            city.removeBuilding(building); // Удаляем здание и его комнаты
            JOptionPane.showMessageDialog(this, "Здание и его комнаты удалены!");
        } else {
            JOptionPane.showMessageDialog(this, "Здание не найдено!");
        }
    }

    // Метод для удаления комнаты
    private void removeRoom() {
        String street = JOptionPane.showInputDialog(this, "Введите улицу здания:");
        int houseNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите номер дома:"));
        Building building = city.findBuilding(street, houseNumber);
        if (building != null) {
            int roomNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите номер комнаты:"));
            Room roomToRemove = null;
            for (Room room : building.getRooms()) {
                if (room.getNumber() == roomNumber) {
                    roomToRemove = room;
                    break;
                }
            }
            if (roomToRemove != null) {
                building.removeRoom(roomToRemove); // Удаляем комнату из списка и базы данных
                JOptionPane.showMessageDialog(this, "Комната удалена!");
            } else {
                JOptionPane.showMessageDialog(this, "Комната не найдена!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Здание не найдено!");
        }
    }

    // Метод для отображения информации
    private void showInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Информация о городе: ").append(city.getName()).append("\n\n");

        for (Building building : city.getBuildings()) {
            info.append("Здание на улице ").append(building.getStreet())
                    .append(", дом ").append(building.getHouseNumber()).append("\n")
                    .append("Базовый платеж за кв.м: ").append(building.getBasePaymentPerSqM()).append(" тенге\n")
                    .append("Общая площадь здания: ").append(building.getTotalArea()).append(" кв.м\n");

            if (building.getRooms().isEmpty()) {
                info.append("Нет комнат в этом здании.\n");
            } else {
                info.append("Комнаты:\n");
                for (Room room : building.getRooms()) {
                    info.append("- Комната ").append(room.getNumber())
                            .append(", Площадь: ").append(room.getArea()).append(" кв.м\n");
                }
            }
            info.append("\n");
        }

        infoTextArea.setText(info.toString());
    }

    // Метод для поиска здания
    private void findBuilding() {
        String street = JOptionPane.showInputDialog(this, "Введите улицу здания:");
        int houseNumber = Integer.parseInt(JOptionPane.showInputDialog(this, "Введите номер дома:"));
        Building building = city.findBuilding(street, houseNumber);
        if (building != null) {
            StringBuilder info = new StringBuilder();
            info.append("Найденное здание:\n")
                    .append("Улица: ").append(building.getStreet()).append("\n")
                    .append("Дом: ").append(building.getHouseNumber()).append("\n")
                    .append("Базовый платеж за кв.м: ").append(building.getBasePaymentPerSqM()).append(" тенге\n")
                    .append("Общая площадь здания: ").append(building.getTotalArea()).append(" кв.м\n");

            if (building.getRooms().isEmpty()) {
                info.append("Нет комнат в этом здании.\n");
            } else {
                info.append("Комнаты:\n");
                for (Room room : building.getRooms()) {
                    info.append("- Комната ").append(room.getNumber())
                            .append(", Площадь: ").append(room.getArea()).append(" кв.м\n");
                }
            }

            infoTextArea.setText(info.toString());
        } else {
            JOptionPane.showMessageDialog(this, "Здание не найдено!");
        }
    }

    public static void main(String[] args) {
        // Инициализация базы данных
        Database.initializeDatabase();

        // Загрузка данных из базы данных
        City city = Database.loadCity("Астана");

        // Запуск GUI
        MainGUI gui = new MainGUI(city);
        gui.setVisible(true);
    }
}




