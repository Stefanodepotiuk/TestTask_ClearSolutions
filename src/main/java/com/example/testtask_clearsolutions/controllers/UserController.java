package com.example.testtask_clearsolutions;

import com.example.testtask_clearsolutions.modela.dto.UserDTO;
import com.example.testtask_clearsolutions.modela.entity.User;
import com.example.testtask_clearsolutions.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) {
        return new ResponseEntity<>(userService.upDAte(user, id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> finaALLUsers() {
        return new ResponseEntity<>(userService.getALL(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findByIdUser(@PathVariable int id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<UserDTO>> deleteUser(@PathVariable int id) {
        return new ResponseEntity<>(userService.delete(id), HttpStatus.OK);
    }
}
