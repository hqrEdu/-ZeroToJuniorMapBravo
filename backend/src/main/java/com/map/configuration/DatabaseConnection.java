package com.map.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConnection {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseConnection.class);
    private Connection connection;

    public DatabaseConnection(@Value("${spring.datasource.url}") String url,
                              @Value("${spring.datasource.username}") String user,
                              @Value("${spring.datasource.password}") String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            LOG.info("Connected to the mapa-bravo database successfully");
        } catch (SQLException e) {
            LOG.info("Error while connecting to the database:" + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }
}