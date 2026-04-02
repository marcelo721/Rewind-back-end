package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;

import java.util.List;

public interface MovieProviderRepository {
    MovieDetails getByImdbId(String imdbId);
    List<MovieSummary> searchByTitle(String title);
}
