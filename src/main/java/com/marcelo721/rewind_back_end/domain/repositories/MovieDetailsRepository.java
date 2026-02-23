package com.marcelo721.rewind_back_end.domain.repositories;

import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;

import java.util.List;
import java.util.UUID;

public interface MovieDetailsRepository {

    MovieDetails findById(UUID id);
    void create(MovieDetails movieDetails);
    List<MovieDetails> findAll();
}
