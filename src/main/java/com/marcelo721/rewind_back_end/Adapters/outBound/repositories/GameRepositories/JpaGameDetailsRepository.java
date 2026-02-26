package com.marcelo721.rewind_back_end.Adapters.outBound.repositories.GameRepositories;

import com.marcelo721.rewind_back_end.Adapters.outBound.entities.JpaGameDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaGameDetailsRepository extends JpaRepository<JpaGameDetailsEntity, UUID> {
}
