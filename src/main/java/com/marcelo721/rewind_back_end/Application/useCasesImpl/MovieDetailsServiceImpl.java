package com.marcelo721.rewind_back_end.Application.useCasesImpl;


import com.marcelo721.rewind_back_end.Application.useCases.MovieDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import com.marcelo721.rewind_back_end.domain.ports.MovieGenreProviderRepository;
import com.marcelo721.rewind_back_end.domain.ports.MovieProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
public class MovieDetailsServiceImpl implements MovieDetailsUseCases {

    private final MovieProviderRepository omdb;
    private final MovieGenreProviderRepository tmdb;

    public MovieDetailsServiceImpl( MovieProviderRepository omdbProvider, MovieGenreProviderRepository tmdb) {
        this.omdb = omdbProvider;
        this.tmdb = tmdb;
    }

    @Override
    public MovieDetails getFromProvider(String imdbId) {
        return omdb.getByImdbId(imdbId);
    }

    @Override
    public List<MovieSummary> searchByTitle(String title) {
        return omdb.searchByTitle(title);
    }

    @Override
    public List<MovieDetails> searchByGenre(String genre, int page) {
        if (page < 1) page = 1;

        return tmdb.searchByGenre(genre, page)
                .stream()
                .map(MovieSummary::getId)
                .filter(Objects::nonNull)
                .limit(10)
                .parallel()
                .map(omdb::getByImdbId)
                .filter(Objects::nonNull)
                .toList();
    }
}
