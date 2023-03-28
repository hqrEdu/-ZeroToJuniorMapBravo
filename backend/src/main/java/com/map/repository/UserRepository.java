package com.map.repository;

import com.map.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private static final Logger LOG = LoggerFactory.getLogger(UserRepository.class);
    private Connection connection;

    public UserRepository(@Value("${spring.datasource.url}") String url,
                          @Value("${spring.datasource.username}") String user,
                          @Value("${spring.datasource.password}") String password) {
        try {
            connection = DriverManager.getConnection(url, user, password);
            LOG.info("Connected to the mapa-bravo database successfully");
        } catch (SQLException e) {
            LOG.info("Error while connecting to the database:" + e.getMessage());
        }
    }

    public User addUser(User user) {
        try {
            String query = "insert into map.user (nickname, city, country, zipCode) values (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getNickname());
            ps.setString(2, user.getCity());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getZipCode());
            ps.executeUpdate();
            ps.close();
            LOG.info("User [{}] has been added correctly.", user.getNickname());
        } catch (SQLException e) {
            LOG.info("Error while creating user:" + e.getMessage());
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            String query = "select id, nickname, city, country, zipcode from map.user";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nickname = rs.getString("nickname");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String zipCode = rs.getString("zipCode");
                users.add(new User(id, nickname, city, zipCode, country));
            }
        } catch (SQLException e) {
            LOG.info("Error while fetching users:" + e.getMessage());
        }
        return users;
    }

    public void deleteUser(String userNickname) {
        try {
            String query = "delete from map.user WHERE nickname = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, userNickname);
            ps.execute();
            LOG.info("User [{}] has been correctly removed.", userNickname);
        } catch (SQLException e) {
            LOG.info("Error while removing user:" + e.getMessage());
        }
    }
}
