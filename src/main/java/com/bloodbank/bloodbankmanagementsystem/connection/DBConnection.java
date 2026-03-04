package com.bloodbank.bloodbankmanagementsystem.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String URL =
            "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String USER = "myuser";
    private static final String PASSWORD = "mypass";

    public static Connection getConnection() {

        try {
            Class.forName("oracle.jdbc.OracleDriver");

            Connection con =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            return con;

        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection failed.");
            e.printStackTrace();
        }

        return null;
    }
}