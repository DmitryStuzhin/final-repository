package com.example.demo.Service;

import com.example.demo.Dto.UserDto;
import com.example.demo.Exception.UserAlreadyExsist;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public ResponseEntity<UserDto> findUserById(Integer id) {
        if(!userIsPresent(id))
            throw new UserNotFoundException("user not found");
        User user =
                userRepository.findUserById(id).get();
        return ResponseEntity.ok(
                UserDto.makeDto(user.getUsername(), user.getAge())
        );
    }

    public ResponseEntity<User> createUser(String username, int age) {
        if(userIsPresent(username))
            throw new UserAlreadyExsist("такой пользователь уже есть");

        return ResponseEntity.ok(
          userRepository.save(new User(username, age))
        );
    }

    private boolean userIsPresent(String username) {
        return userRepository.findUSerByUsername(username).isPresent();
    }
    private boolean userIsPresent(Integer id) {
        return userRepository.findUserById(id).isPresent();
    }
}
