package com.marcelo721.rewind_back_end.domain.repositories;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;

import java.util.List;

public interface MovieGenreProviderRepository {
    List<MovieSummary> searchByGenre(String genre, int page );

}
