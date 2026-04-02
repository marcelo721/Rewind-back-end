package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.MovieDetailsRepositories;


import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers.MovieDetailsPersistenceMapper;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.ports.MovieDetailsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class MovieRepositoryImpl implements MovieDetailsRepository {

    private final JpaMovieDetailsRepository repository;

    public MovieRepositoryImpl(JpaMovieDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public MovieDetails findById(UUID id) {
        return this.repository.findById(id)
                .map(MovieDetailsPersistenceMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void create(MovieDetails movieDetails) {
        this.repository.save(
                MovieDetailsPersistenceMapper.toEntity(movieDetails)
        );
    }

    @Override
    public List<MovieDetails> findAll() {
        return this.repository.findAll()
                .stream()
                .map(MovieDetailsPersistenceMapper::toDomain)
                .toList();
    }
}
