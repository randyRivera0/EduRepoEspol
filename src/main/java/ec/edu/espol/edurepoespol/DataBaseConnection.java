package ec.edu.espol.edurepoespol;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User Dell
 */
public class DataBaseConnection {
    // Step 1: Create a private static instance of this class
    private static DataBaseConnection instance;

    // Step 2: Declare the Connection object
    private Connection connection;

    // Database credentials and URL
    private static final String URL = "jdbc:mysql://localhost:3306/g3"; // Modify as per your DB
    private static final String USER = "root"; // Modify with your MySQL username
    private static final String PASSWORD = "admin"; // Modify with your MySQL password

    // Step 3: Make the constructor private to prevent instantiation
    private DataBaseConnection() {
        try {
            // Step 4: Initialize the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace(); // You can use a logger here for better error tracking
        }
    }

    // Step 5: Provide a public static method that returns the instance of the class
    public static DataBaseConnection getInstance() {
        if (instance == null) {
            // Lazy initialization
            instance = new DataBaseConnection();
        }
        return instance;
    }

    // Step 6: Provide a public method to get the connection
    public Connection getConnection() {
        return connection;
    }
}
