package com.marcelo721.rewind_back_end.Adapters.outBound.repositories.MovieDetailsRepositories;

import com.marcelo721.rewind_back_end.Adapters.outBound.entities.JpaMovieDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaMovieDetailsRepository extends JpaRepository<JpaMovieDetailsEntity, UUID> {
}
