package com.marcelo721.rewind_back_end.Adapters.outBound.repositories.contentRepositorie;

import com.marcelo721.rewind_back_end.Adapters.outBound.entities.JpaContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaContentRepository extends JpaRepository<JpaContentEntity, UUID> {
}
