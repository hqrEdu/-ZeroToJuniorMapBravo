package com.map.repository;

import com.map.configuration.DatabaseConnection;
import com.map.model.User;
import lombok.AllArgsConstructor;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
@AllArgsConstructor
public class UserRepository {

    private static final Logger log = Logger.getLogger(UserRepository.class);
    private final DatabaseConnection databaseConnection;

    public User addUser(User user) {
        try {
            String ADD_QUERY = "insert into map.user (nickname, city, country, zipCode) values (?, ?, ?, ?)";
            PreparedStatement ps = databaseConnection.getConnection().prepareStatement(ADD_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getNickname());
            ps.setString(2, user.getCity());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getZipCode());
            ps.executeUpdate();
            ps.close();
            log.info("User has been added correctly.");
        } catch (SQLException e) {
            log.info("Error while creating user:" + e.getMessage());
        }
        return user;
    }
}
