package com.example.fitnesshelp.dao;

import java.sql.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class SingletonConnection {

    private static SingletonConnection instance;
    private static Connection connection;

    // private constructor to prevent multiple instance construction
    private SingletonConnection() throws IOException, java.sql.SQLException {
        connectToDB();
    }

    // to ensure only one instance of the singleton class is created and returned
    public static synchronized SingletonConnection getInstance() throws IOException, SQLException {
        if (instance == null) {
            instance = new SingletonConnection();
        }
        return instance;
    }

    private static void connectToDB() throws IOException, java.sql.SQLException {
        Properties properties = new Properties();
        InputStream is = SingletonConnection.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(is);

        String dbUrl = properties.getProperty("db.url");
        String dbUsername = properties.getProperty("db.username");
        String dbPassword = properties.getProperty("db.password");

        connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    public Connection getConnection() {
        return connection;
    }

    public static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
