package com.marcelo721.rewind_back_end.Application.services;

import com.marcelo721.rewind_back_end.Application.useCases.UserUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.User;
import com.marcelo721.rewind_back_end.domain.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserUseCases {


    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public User findById(UUID id) {
        return null;
    }


    @Transactional
    @Override
    public void createUser(User user) {

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return List.of();
    }
}
