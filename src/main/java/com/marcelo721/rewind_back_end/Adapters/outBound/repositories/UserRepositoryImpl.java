package com.marcelo721.rewind_back_end.Adapters.outBound.repositories;

import com.marcelo721.rewind_back_end.Adapters.outBound.entities.JpaUserEntity;
import com.marcelo721.rewind_back_end.domain.model.entities.User;
import com.marcelo721.rewind_back_end.domain.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User findById(UUID id) {
        Optional<JpaUserEntity> user = this.jpaUserRepository.findById(id);
        return user.map(jpaUserEntity -> new User(jpaUserEntity.getId(),
                jpaUserEntity.getNickName(), jpaUserEntity.getEmail(),
                jpaUserEntity.getPassword(),jpaUserEntity.getDescription(),
                jpaUserEntity.getUserType(), jpaUserEntity.getStatusAccount())).orElse(null);
    }

    @Override
    public void createUser(User user) {
        JpaUserEntity userEntity = new JpaUserEntity(user);
        this.jpaUserRepository.save(userEntity);
    }

    @Override
    public List<User> findAll() {
        return this.jpaUserRepository.findAll().stream().map(jpaUserEntity -> new User(jpaUserEntity.getId(),
                jpaUserEntity.getNickName(), jpaUserEntity.getEmail(),
                jpaUserEntity.getPassword(),jpaUserEntity.getDescription(),
                jpaUserEntity.getUserType(), jpaUserEntity.getStatusAccount())).collect(Collectors.toList());
    }
}
