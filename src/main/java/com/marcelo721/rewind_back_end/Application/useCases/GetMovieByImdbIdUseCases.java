package com.marcelo721.rewind_back_end.Application.useCases;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;

import java.util.List;

public interface GetMovieByImdbIdUseCases {
    public MovieDetails findByImdbId(String imdbId);
    public List<MovieSummary> searchByTitle (String title);
}
