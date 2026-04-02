package com.marcelo721.rewind_back_end.Application.useCasesImpl;

import com.marcelo721.rewind_back_end.Application.useCases.UserUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.User;
import com.marcelo721.rewind_back_end.domain.model.enums.StatusAccount;
import com.marcelo721.rewind_back_end.domain.model.enums.UserType;
import com.marcelo721.rewind_back_end.domain.ports.UserRepository;
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
        return userRepository.findById(id);
    }


    @Transactional
    @Override
    public void createUser(User user) {
        user.setUserType(UserType.CLIENT);
        user.setStatusAccount(StatusAccount.ACTIVE);
        userRepository.createUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
