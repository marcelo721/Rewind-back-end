package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;


import com.marcelo721.rewind_back_end.Application.useCases.UserUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserUseCases useCases;

    public UserController(UserUseCases useCases) {
        this.useCases = useCases;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return useCases.findById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return useCases.findAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        useCases.createUser(user);
    }
}
