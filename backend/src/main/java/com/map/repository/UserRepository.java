package com.map.repository;

import com.map.configuration.DatabaseConnection;
import com.map.dto.UserDto;
import com.map.model.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
public class UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepository.class);
    private final DatabaseConnection databaseConnection;

    public User addUser(User user) {
        try {
            String query = "insert into map.user (nickname, city, country, zipCode) values (?, ?, ?, ?)";
            PreparedStatement ps = databaseConnection.getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getNickname());
            ps.setString(2, user.getCity());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getZipCode());
            ps.executeUpdate();
            ps.close();
            LOGGER.info("User [{}] has been added correctly.", user.getNickname());
        } catch (SQLException e) {
            LOGGER.info("Error while creating user:" + e.getMessage());
        }
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            String query = "select id, nickname, city, country, zipcode from map.user";
            Statement statement = databaseConnection.getConnection().createStatement();
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
            LOGGER.info("Error while fetching users:" + e.getMessage());
        }
        return users;
    }
}
