package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.userRepositories;


import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<JpaUserEntity, UUID> {
}
