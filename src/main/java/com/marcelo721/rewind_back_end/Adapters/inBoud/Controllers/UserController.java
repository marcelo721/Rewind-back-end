package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;


import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.userDto.CreateUserDto;
import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.userDto.UserResponseDto;
import com.marcelo721.rewind_back_end.Application.useCases.UserUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.User;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserUseCases service;

    public UserController(UserUseCases useCases) {
        this.service = useCases;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody @Valid CreateUserDto user) {
        User obj = user.toUser();
        service.createUser(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable UUID id) {
        User obj = service.findById(id);
        return ResponseEntity.ok(UserResponseDto.toDto(obj));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() {
        List<User> users = service.findAll();
        return ResponseEntity.ok(UserResponseDto.toListDto(users));
    }


}
