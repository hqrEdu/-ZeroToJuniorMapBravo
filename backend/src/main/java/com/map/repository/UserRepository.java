package com.map.repository;

import com.map.configuration.DatabaseConnection;
import com.map.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Repository
@AllArgsConstructor
public class UserRepository {

    private static final String ADD_QUERY = "insert into map.user (nickname, city, country, zipCode) values (?, ?, ?, ?)";
    private final DatabaseConnection databaseConnection;

    public User addUser(User user) {
        try {
            PreparedStatement ps = databaseConnection.getConnection().prepareStatement(ADD_QUERY, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getNickname());
            ps.setString(2, user.getCity());
            ps.setString(3, user.getCountry());
            ps.setString(4, user.getZipCode());
            ps.executeUpdate();
            ps.close();
            System.out.println("User has been added correctly.");
        } catch (SQLException e) {
            System.out.println("Something went wrong." + e.getMessage());
        }
        return user;
    }
}
