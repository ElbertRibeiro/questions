package com.tomath.user;

import com.tomath.util.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/users") public class UserController {

    @Autowired
    UserService userService;

    @GetMapping public ResponseEntity<List<UserDTO>> loadListUsers() {
        return new ResponseEntity<>(ObjectMapperUtils.mapAll(userService.getUsersList(), UserDTO.class), HttpStatus.OK);
    }

    @PostMapping("/create") public ResponseEntity<Long> insertUsers(@RequestBody UserDTO user) {
        return new ResponseEntity<>(userService.createUser(ObjectMapperUtils.map(user, User.class)),
                HttpStatus.CREATED);
    }

    @GetMapping("/login") public ResponseEntity<UserDTO> loginUser(@RequestBody UserDTO login) {
        return new ResponseEntity<>(
                ObjectMapperUtils.map(userService.loadUser(ObjectMapperUtils.map(login, User.class).getNameUser()),
                        UserDTO.class), HttpStatus.OK);
    }
}
