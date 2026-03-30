package com.marcelo721.rewind_back_end.Application.useCasesImpl;


import com.marcelo721.rewind_back_end.Application.useCases.MovieDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import com.marcelo721.rewind_back_end.domain.repositories.MovieDetailsRepository;
import com.marcelo721.rewind_back_end.domain.repositories.MovieProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class MovieDetailsServiceImpl implements MovieDetailsUseCases {

    private final MovieDetailsRepository repository;
    private final MovieProviderRepository provider;

    public MovieDetailsServiceImpl(MovieDetailsRepository repository, MovieProviderRepository omdbProvider) {
        this.repository = repository;
        this.provider = omdbProvider;
    }

    @Override
    @Transactional(readOnly = true)
    public MovieDetails findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void create(MovieDetails movieDetails) {
        repository.create(movieDetails);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MovieDetails> findAll() {
        return repository.findAll();
    }

    @Override
    public MovieDetails getFromProvider(String imdbId) {
        return provider.getByImdbId(imdbId);
    }

    @Override
    public List<MovieSummary> searchByTitle(String title) {
        return provider.searchByTitle(title);
    }
}
