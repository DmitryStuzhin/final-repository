package com.example.demo.Controller;

import com.example.demo.Dto.UserDto;
import com.example.demo.Model.User;
import com.example.demo.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user-service/")
@RequiredArgsConstructor
public class UserController {
    public final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Integer id) {
        return userService.findUserById(id);
    }
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto.getUsername(), userDto.getAge());
    }
}
