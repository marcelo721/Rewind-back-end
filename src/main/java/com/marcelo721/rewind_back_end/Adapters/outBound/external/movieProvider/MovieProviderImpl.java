package com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.omdbMovies.OmdbMovieProvider;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.movieProvider.tmdbMovies.TmdbMovieProvider;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import com.marcelo721.rewind_back_end.domain.ports.MovieProviderRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieProviderImpl implements MovieProviderRepository {

    private final TmdbMovieProvider tmdbMovieProvider;
    private final OmdbMovieProvider omdbMovieProvider;

    public MovieProviderImpl(TmdbMovieProvider tmdbMovieProvider, OmdbMovieProvider omdbMovieProvider) {
        this.tmdbMovieProvider = tmdbMovieProvider;
        this.omdbMovieProvider = omdbMovieProvider;
    }


    @Override
    public MovieDetails getByImdbId(String imdbId) {
        return omdbMovieProvider.getByImdbId(imdbId);
    }

    @Override
    public List<MovieSummary> searchByTitle(String title) {
        return omdbMovieProvider.searchByTitle(title);
    }

    @Override
    public List<MovieSummary> searchByGenre(String genre, int page) {
        return tmdbMovieProvider.searchByGenre(genre, page);
    }
}
