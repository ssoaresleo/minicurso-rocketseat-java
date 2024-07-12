package br.com.rocketseat.aula.java.todolist.controllers;

import br.com.rocketseat.aula.java.todolist.domain.User;
import br.com.rocketseat.aula.java.todolist.dto.UserDTO;
import br.com.rocketseat.aula.java.todolist.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UseController {

    private final UserService userService;

    public UseController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserDTO userData) {
        var userAlreadyExists = userService.findUser(userData.name());

        if(userAlreadyExists != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        userService.createUser(userData);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAllUsers();
    }
}
