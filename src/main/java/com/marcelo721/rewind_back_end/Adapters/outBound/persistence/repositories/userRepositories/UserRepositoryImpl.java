package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.userRepositories;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers.UserPersistenceMapper;
import com.marcelo721.rewind_back_end.domain.model.entities.User;
import com.marcelo721.rewind_back_end.domain.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public User findById(UUID id) {
        return this.jpaUserRepository.findById(id)
                .map(UserPersistenceMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void createUser(User user) {
        this.jpaUserRepository.save(
                UserPersistenceMapper.toEntity(user)
        );
    }

    @Override
    public List<User> findAll() {
        return this.jpaUserRepository.findAll()
                .stream()
                .map(UserPersistenceMapper::toDomain)
                .toList();
    }
}
