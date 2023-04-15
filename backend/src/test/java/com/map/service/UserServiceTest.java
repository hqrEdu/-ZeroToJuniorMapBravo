package com.map.service;

import com.map.dto.UserDto;
import com.map.exception.UserAlreadyExistException;
import com.map.model.User;
import com.map.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @BeforeEach
    void init() {
        when(userRepository.getConnection()).thenReturn(mock(Connection.class));
    }

    @Test
    void shouldCorrectlyAddUser() {
        User user = new User();
        user.setNickname("nickname");
        user.setCity("city");
        user.setCountry("country");
        user.setZipCode("zipCode");

        UserDto userDto = new UserDto("nickname", "city", "zipCode", "country");

        when(userService.createUser(userDto)).thenReturn(user);
        when(userRepository.getUserByNickname("nickname")).thenReturn(user);
        assertEquals("city", user.getCity());
        assertEquals("nickname", user.getNickname());
        assertEquals("zipCode", user.getZipCode());
        assertEquals("country", user.getCountry());
    }

    @Test
    void shouldThrowUserAlreadyExistException() {
        User user = new User();
        user.setNickname("nickname");
        user.setCity("city");
        user.setCountry("country");
        user.setZipCode("zipCode");

        UserDto userDto = new UserDto("nickname", "city", "zipCode", "country");
        UserDto userDto2 = new UserDto("nickname", "city", "zipCode", "country");

        when(userService.createUser(userDto)).thenReturn(user);
        when(userRepository.getUserByNickname("nickname")).thenReturn(user);
        when(userService.createUser(userDto2)).thenThrow(UserAlreadyExistException.class);
        assertThrows(UserAlreadyExistException.class, () -> userService.createUser(userDto2), String.format("User with nickname exists. {nickname=%s}", userDto2.getNickname()));
    }

    @Test
    void shouldCorrectlyGetAllUsers() {
        User user = new User(1,"nickname", "city", "zipCode", "country",1, 1);
        User user1 = new User(2, "nickname2", "city", "zipCode", "country",1, 1);
        User user2 = new User(3, "nickname3", "city", "zipCode", "country",1, 1);
        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);

        when(userService.getUsers()).thenReturn(users);
        assertEquals(users.size(), 3);
    }
}