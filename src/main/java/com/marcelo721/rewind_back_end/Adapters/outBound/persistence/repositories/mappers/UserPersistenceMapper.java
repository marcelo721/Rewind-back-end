package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaUserEntity;
import com.marcelo721.rewind_back_end.domain.model.entities.User;

public class UserPersistenceMapper {
    private UserPersistenceMapper() {}

    public static User toDomain(JpaUserEntity entity) {
        if (entity == null) return null;

        return new User(
                entity.getId(),
                entity.getNickName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getDescription(),
                entity.getUserType(),
                entity.getStatusAccount(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getCreatedBy(),
                entity.getUpdatedBy()
        );
    }

    public static JpaUserEntity toEntity(User user) {
        if (user == null) return null;

        JpaUserEntity entity = new JpaUserEntity();

        entity.setId(user.getID());
        entity.setNickName(user.getNickName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPassword());
        entity.setDescription(user.getDescription());
        entity.setUserType(user.getUserType());
        entity.setStatusAccount(user.getStatusAccount());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        entity.setCreatedBy(user.getCreatedBy());
        entity.setUpdatedBy(user.getUpdatedBy());

        return entity;
    }
}
