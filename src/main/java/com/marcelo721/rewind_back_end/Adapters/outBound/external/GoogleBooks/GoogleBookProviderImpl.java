package com.marcelo721.rewind_back_end.Adapters.outBound.external.GoogleBooks;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import com.marcelo721.rewind_back_end.domain.ports.BookProviderRepository;

import java.util.List;

public class GoogleBookProviderImpl implements BookProviderRepository {
    @Override
    public MovieDetails FindById(String id) {
        return null;
    }

    @Override
    public List<MovieSummary> searchByTitle(String title) {
        return List.of();
    }
}
 