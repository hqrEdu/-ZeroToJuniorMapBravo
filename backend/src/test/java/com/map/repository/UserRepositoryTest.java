package com.map.repository;

import com.map.configuration.DatabaseConnection;
import com.map.exception.UserAlreadyExistException;
import com.map.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = UserRepository.class)
@ExtendWith(SpringExtension.class)
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    @MockBean
    private DatabaseConnection databaseConnection;
    @Mock
    private PreparedStatement preparedStatement;
    @Mock
    private Statement statement;
    @Mock
    private ResultSet resultSet;

    @BeforeEach
    public void setup() throws SQLException {
        when(databaseConnection.getConnection()).thenReturn(mock(Connection.class));
        when(databaseConnection.getConnection().prepareStatement(anyString())).thenReturn(preparedStatement);
        when(databaseConnection.getConnection().prepareStatement(anyString(), anyInt())).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        when(databaseConnection.getConnection().createStatement()).thenReturn(statement);
        when(statement.executeQuery(anyString())).thenReturn(resultSet);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getString("nickname")).thenReturn("nickname");
        when(resultSet.getString("city")).thenReturn("city");
        when(resultSet.getString("country")).thenReturn("country");
        when(resultSet.getString("zipCode")).thenReturn("zipCode");
        when(resultSet.getFloat("latitude")).thenReturn(1f);
        when(resultSet.getFloat("longitude")).thenReturn(1f);
    }

    @Test
    void shouldCorrectlyAddUser() throws SQLException {
        User user = new User(1, "nickname2", "city", "country", "zipCode", 1f, 1f);
        userRepository.addUser(user);
        String query = "insert into map.user (nickname, city, country, zipCode, latitude, longitude) values (?, ?, ?, ?, ?, ?)";
        verify(databaseConnection.getConnection()).prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        verify(preparedStatement).setString(1, user.getNickname());
        verify(preparedStatement).setString(2, user.getCity());
        verify(preparedStatement).setString(3, user.getCountry());
        verify(preparedStatement).setString(4, user.getZipCode());
        verify(preparedStatement).setFloat(5, user.getLatitude());
        verify(preparedStatement).setFloat(6, user.getLongitude());
        verify(preparedStatement).executeUpdate();
    }

    @Test
    void shouldThrowUserAlreadyExistException() {
        User user = new User(1, "nickname", "city", "country", "zipCode", 1f, 1f);
        assertThrows(UserAlreadyExistException.class, () -> userRepository.addUser(user), String.format("User with nickname exists. {nickname=%s}", user.getNickname()));
    }

    @Test
    void shouldCorrectlyGetAllUsers() {
        assertEquals(userRepository.getAllUsers().size(), 1);
    }

    @Test
    void shouldCorrectlyReturnUserWithGivenNickname() throws SQLException {
        User user = new User();
        String nickname = "nickname";
        userRepository.getUserByNickname(nickname);
        String query = "select nickname from map.user where nickname=?";
        verify(databaseConnection.getConnection()).prepareStatement(query);
        verify(preparedStatement).setString(1, nickname);
        user.setNickname(resultSet.getString("nickname"));
        user.setCity(resultSet.getString("city"));
        user.setCountry(resultSet.getString("country"));
        user.setZipCode(resultSet.getString("zipCode"));
        user.setLatitude(resultSet.getFloat("latitude"));
        user.setLongitude(resultSet.getFloat("longitude"));

        assertEquals("nickname", user.getNickname());
        assertEquals("city", user.getCity());
        assertEquals("country", user.getCountry());
        assertEquals("zipCode", user.getZipCode());
        assertEquals(1f, user.getLatitude());
        assertEquals(1f, user.getLongitude());
    }
}