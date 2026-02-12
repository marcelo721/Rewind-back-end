package com.marcelo721.rewind_back_end.Adapters.outBound.repositories;


import com.marcelo721.rewind_back_end.Adapters.outBound.entities.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaUserRepository extends JpaRepository<JpaUserEntity, UUID> {
}
