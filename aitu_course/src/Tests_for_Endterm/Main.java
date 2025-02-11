package Tests_for_Endterm;

import java.sql.*;
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER,
                PASSWORD);
             Statement statement = connection.createStatement()) {
            // Display all students
            System.out.println("List of students:");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") +
                        ", Name: " + resultSet.getString("name") +
                        ", Age: " + resultSet.getInt("age") +
                        ", Major: " + resultSet.getString("major"));
            }
            // Add a new student
            String insertQuery = "INSERT INTO students (name, age, major) VALUES ('John', 20, 'Computer Science')";
            int rowsInserted = statement.executeUpdate(insertQuery);
            if (rowsInserted > 0) {
                System.out.println("New student added successfully.");
            }
            // Update student information
            String updateQuery = "UPDATE students SET age = 21 WHERE name = 'John'";
            int rowsUpdated = statement.executeUpdate(updateQuery);
            if (rowsUpdated > 0) {
                System.out.println("Student information updated successfully.");
            }
            // Delete a student
            String deleteQuery = "DELETE FROM students WHERE name = 'John'";
            int rowsDeleted = statement.executeUpdate(deleteQuery);
            if (rowsDeleted > 0) {
                System.out.println("Student deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}