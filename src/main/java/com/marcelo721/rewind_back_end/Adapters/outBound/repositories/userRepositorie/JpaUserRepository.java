package com.marcelo721.rewind_back_end.Adapters.outBound.repositories.userRepositorie;


import com.marcelo721.rewind_back_end.Adapters.outBound.entities.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<JpaUserEntity, UUID> {
}
