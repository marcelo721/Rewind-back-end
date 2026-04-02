package com.marcelo721.rewind_back_end.Application.useCases;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;

import java.util.List;
import java.util.UUID;

public interface MovieDetailsUseCases {

    MovieDetails getFromProvider(String imdbId);
    List<MovieSummary> searchByTitle(String title);
    public List<MovieDetails> searchByGenre(String genre, int page);
}
