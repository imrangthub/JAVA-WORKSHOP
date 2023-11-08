package com.imranmadbar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyMain {
    public static void main(String[] args) {
        // Define the database connection parameters
        String url = "jdbc:mysql://192.168.1.1:3306/apihub?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "username";
        String password = "dbpass";

        try {
            // Register the MySQL JDBC driver (if not already done)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement for executing SQL queries
            Statement statement = connection.createStatement();

            // Execute a simple query (e.g., selecting data from a table)
            String sqlQuery = "SELECT * FROM bookdb.book-customer where costomer-id=01916894486";
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            // Process the query results
            while (resultSet.next()) {
                // Access and print the data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("reg-date");
                System.out.println("ID: " + id + ", StTime: " + name);
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database connection or query execution error.");
            e.printStackTrace();
        }
    }
}