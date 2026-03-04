package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
DB_HOST=localhost
DB_NAME=Company_Listings
DB_USER=root
DB_PASSWORD=admin
 */

public class DatabaseConnect {
    // Database credentials
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "3306";
    private static final String DB_NAME = "Company_Listings";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "admin";

    // JDBC URL
    private static final String JDBC_URL = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    public static Connection getConnection() throws SQLException {
        try {
            // Load MySQL JDBC Driver (optional for newer versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            System.out.println("Successfully connected to MySQL database: " + DB_NAME);
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
            throw new SQLException("Driver not found", e);
        } catch (SQLException e) {
            System.err.println("Connection failed! Check credentials and database status.");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Get all table names in the current database
     */
    public static List<String> getAllTables(Connection connection) throws SQLException {
        List<String> tables = new ArrayList<>();
        DatabaseMetaData metaData = connection.getMetaData();
        ResultSet resultSet = metaData.getTables(DB_NAME, null, "%", new String[]{"TABLE"});

        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            tables.add(tableName);
        }
        resultSet.close();
        return tables;
    }

    /**
     * Get the record count for a specific table
     */
    public static int getRecordCount(Connection connection, String tableName) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM " + tableName;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        int count = 0;
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }

        resultSet.close();
        statement.close();
        return count;
    }

    /**
     * Display all tables and their record counts
     */
    public static void displayTablesAndRecordCounts(Connection connection) throws SQLException {
        List<String> tables = getAllTables(connection);

        System.out.println("\n" + "=".repeat(60));
        System.out.println("DATABASE: " + DB_NAME);
        System.out.println("=".repeat(60));
        System.out.println(String.format("%-40s %s", "TABLE NAME", "RECORD COUNT"));
        System.out.println("-".repeat(60));

        if (tables.isEmpty()) {
            System.out.println("No tables found in the database.");
        } else {
            for (String table : tables) {
                try {
                    int count = getRecordCount(connection, table);
                    System.out.println(String.format("%-40s %,d", table, count));
                } catch (SQLException e) {
                    System.out.println(String.format("%-40s %s", table, "Error: " + e.getMessage()));
                }
            }
        }

        System.out.println("=".repeat(60));
        System.out.println("Total tables: " + tables.size());
        System.out.println("=".repeat(60));
    }

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Connect to database
            connection = getConnection();
            System.out.println("Connection established successfully!");

            // Display all tables and their record counts
            displayTablesAndRecordCounts(connection);

        } catch (SQLException e) {
            System.err.println("Failed to connect to database.");
            e.printStackTrace();
        } finally {
            // Always close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("\nConnection closed.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
