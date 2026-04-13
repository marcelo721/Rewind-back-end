package com.marcelo721.rewind_back_end.Application.useCasesImpl;


import com.marcelo721.rewind_back_end.Application.useCases.MovieDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import com.marcelo721.rewind_back_end.domain.ports.MovieProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieDetailsServiceImpl implements MovieDetailsUseCases {

   private final MovieProviderRepository movieProviderRepository;

   public MovieDetailsServiceImpl(MovieProviderRepository movieProviderRepository) {
       this.movieProviderRepository = movieProviderRepository;
   }

    @Override
    public MovieDetails getFromProvider(String imdbId) {
        return movieProviderRepository.getByImdbId(imdbId);
    }

    @Override
    public List<MovieSummary> searchByTitle(String title) {
        return movieProviderRepository.searchByTitle(title);
    }

    @Override
    public List<MovieDetails> searchByGenre(String genre, int page) {
        if (page < 1) page = 1;

        return movieProviderRepository.searchByGenre(genre, page)
                .stream()
                .map(MovieSummary::getId)
                .filter(Objects::nonNull)
                .limit(10)
                .parallel()
                .map(movieProviderRepository::getByImdbId)
                .filter(Objects::nonNull)
                .toList();
    }
}
