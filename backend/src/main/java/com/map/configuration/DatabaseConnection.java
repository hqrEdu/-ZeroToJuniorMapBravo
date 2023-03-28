package com.map.configuration;

import com.map.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.sql.*;

@Configuration
public class DatabaseConnection {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConnection.class);
    private static final String URL = "jdbc:postgresql://localhost:5432/mapa-bravo";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pass123";

    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            LOG.info("Connected to the mapa-bravo database successfully");
        } catch (SQLException e) {
            LOG.info("Error while connecting to the database:" + e.getMessage());
        }
        return conn;
    }
}