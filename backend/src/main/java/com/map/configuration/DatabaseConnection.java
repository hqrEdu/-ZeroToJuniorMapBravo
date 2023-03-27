package com.map.configuration;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

@Configuration
public class DatabaseConnection {

    private static final Logger log = Logger.getLogger(DatabaseConnection.class);
    private static final String URL = "jdbc:postgresql://localhost:5432/mapa-bravo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pass123";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            log.info("Connected to the mapa-bravo database successfully");
        } catch (SQLException e) {
            log.info("Error while connecting to the database:" + e.getMessage());
        }
        return conn;
    }
}