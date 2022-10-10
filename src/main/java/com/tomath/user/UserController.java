package com.tomath.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> loadListUsers() {
        return new ResponseEntity<>(userService.getUsersList(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Long> insertUsers(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setNameUser(userDTO.getNameUser());
        user.setTypeUser(userDTO.getTypeUser());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return new ResponseEntity<>(userService.createUser(user),
                HttpStatus.CREATED);
    }

    @GetMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody UserDTO login) {
        return new ResponseEntity<>(userService.loadUser(login.getEmail()),
                HttpStatus.OK);
    }
}
