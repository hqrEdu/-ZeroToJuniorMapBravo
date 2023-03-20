package com.map.controller;

import com.map.dto.UserDto;
import com.map.model.User;
import com.map.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/new")
    ResponseEntity<User> addUser(@RequestBody UserDto userDto) {
        return ResponseEntity.accepted().body(userService.createUser(userDto));
    }
}
