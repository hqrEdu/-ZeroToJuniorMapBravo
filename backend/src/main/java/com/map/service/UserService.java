package com.map.service;

import com.map.configuration.DatabaseConnection;
import com.map.dto.UserDto;
import lombok.AllArgsConstructor;
import com.map.model.User;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

@Service
@AllArgsConstructor
public class UserService {

    private static final String ADD_QUERY = "insert into map.user (nickname, city, country, zipCode) values (?, ?, ?, ?)";
    private final DatabaseConnection databaseConnection;

    public User createUser(UserDto userDto) {
        User user = User.builder()
                .nickname(userDto.getNickname())
                .zipCode(userDto.getZipCode())
                .city(userDto.getCity())
                .country(userDto.getCountry())
                .build();
        return addUser(user);
    }

    private User addUser(User user) {
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