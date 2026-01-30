package com.marcelo721.rewind_back_end.domain.repositories;

import com.marcelo721.rewind_back_end.domain.model.entities.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {

    User findById(UUID id);
    void createUser(User user);
    List<User> findAll();
}
