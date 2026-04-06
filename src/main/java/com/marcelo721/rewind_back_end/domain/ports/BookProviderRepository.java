package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;

import java.util.List;

public interface BookProviderRepository {
    MovieDetails FindById(String id);
    List<MovieSummary> searchByTitle(String title);
}
