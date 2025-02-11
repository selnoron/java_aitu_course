package Endterm_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/java_endterm";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    static {
        try {
            // Регистрируем драйвер PostgreSQL
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void initializeDatabase() {
        String createBuildingsTable = "CREATE TABLE IF NOT EXISTS buildings (" +
                "id SERIAL PRIMARY KEY, " +
                "street VARCHAR(255), " +
                "house_number INT, " +
                "base_payment DOUBLE PRECISION)";

        String createRoomsTable = "CREATE TABLE IF NOT EXISTS rooms (" +
                "id SERIAL PRIMARY KEY, " +
                "number INT, " +
                "area DOUBLE PRECISION, " +
                "building_id INT REFERENCES buildings(id))";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.execute(createBuildingsTable);
            stmt.execute(createRoomsTable);
            System.out.println("Таблицы созданы или уже существуют.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveBuilding(Building building) {
        String sql = "INSERT INTO buildings (street, house_number, base_payment) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, building.getStreet());
            pstmt.setInt(2, building.getHouseNumber());
            pstmt.setDouble(3, building.getBasePaymentPerSqM());
            pstmt.executeUpdate();

            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) {
                    building.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveRoom(Room room) {
        String sql = "INSERT INTO rooms (number, area, building_id) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, room.getNumber());
            pstmt.setDouble(2, room.getArea());
            pstmt.setInt(3, room.getBuilding().getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteBuilding(Building building) {
        String deleteRoomsSql = "DELETE FROM rooms WHERE building_id = ?";
        String deleteBuildingSql = "DELETE FROM buildings WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmtRooms = conn.prepareStatement(deleteRoomsSql);
             PreparedStatement pstmtBuilding = conn.prepareStatement(deleteBuildingSql)) {

            // Удаляем все комнаты здания
            pstmtRooms.setInt(1, building.getId());
            pstmtRooms.executeUpdate();

            // Удаляем само здание
            pstmtBuilding.setInt(1, building.getId());
            pstmtBuilding.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRoom(Room room) {
        String deleteRoomSql = "DELETE FROM rooms WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(deleteRoomSql)) {

            // Удаляем комнату
            pstmt.setInt(1, room.getId());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static City loadCity(String cityName) {
        City city = new City(cityName);

        // Очищаем существующие здания в городе
        city.clearBuildings();

        String sqlBuildings = "SELECT * FROM buildings";
        String sqlRooms = "SELECT * FROM rooms WHERE building_id = ?";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rsBuildings = stmt.executeQuery(sqlBuildings)) {

            while (rsBuildings.next()) {
                Building building = new Building(
                        rsBuildings.getString("street"),
                        rsBuildings.getInt("house_number"),
                        rsBuildings.getDouble("base_payment")
                );
                building.setId(rsBuildings.getInt("id"));

                // Очищаем существующие комнаты в здании
                building.clearRooms();

                city.addBuilding(building);

                // Загружаем комнаты для этого здания
                try (PreparedStatement pstmt = conn.prepareStatement(sqlRooms)) {
                    pstmt.setInt(1, building.getId());
                    ResultSet rsRooms = pstmt.executeQuery();
                    while (rsRooms.next()) {
                        Room room = new Room(
                                rsRooms.getInt("number"),
                                rsRooms.getDouble("area"),
                                building
                        );
                        room.setId(rsRooms.getInt("id"));
                        building.addRoom(room);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }
}