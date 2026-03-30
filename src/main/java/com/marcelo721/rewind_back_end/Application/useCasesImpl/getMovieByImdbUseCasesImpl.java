package com.marcelo721.rewind_back_end.Application.useCasesImpl;


import com.marcelo721.rewind_back_end.Application.useCases.GetMovieByImdbIdUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import com.marcelo721.rewind_back_end.domain.repositories.MovieProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class getMovieByImdbUseCasesImpl implements GetMovieByImdbIdUseCases {

    private final MovieProviderRepository provider;

    public getMovieByImdbUseCasesImpl(MovieProviderRepository provider) {
        this.provider = provider;
    }

    public MovieDetails findByImdbId(String imdbId) {
        return provider.getByImdbId(imdbId);
    }

    public List<MovieSummary> searchByTitle (String title) {
        return provider.searchByTitle(title);
    }
}
