package com.bloodbank.bloodbankmanagementsystem;

import java.sql.Connection;
import com.bloodbank.bloodbankmanagementsystem.connection.DBConnection;

public class TestConnection {

    public static void main(String[] args) {

        Connection con = DBConnection.getConnection();

        if (con != null) {
            System.out.println("Database Connected Successfully!");
        } else {
            System.out.println("Connection Failed!");
        }
    }
}