package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.contentRepositories;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.entities.JpaContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaContentRepository extends JpaRepository<JpaContentEntity, UUID> {
}
