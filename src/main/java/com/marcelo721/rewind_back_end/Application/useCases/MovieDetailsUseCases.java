package com.marcelo721.rewind_back_end.Application.useCases;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;

import java.util.List;
import java.util.UUID;

public interface MovieDetailsUseCases {

    MovieDetails findById(UUID id);
    void create(MovieDetails movieDetails);
    List<MovieDetails> findAll();
}
