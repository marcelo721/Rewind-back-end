package com.marcelo721.rewind_back_end.Application.services;


import com.marcelo721.rewind_back_end.Application.useCases.MovieDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.repositories.ContentRepository;
import com.marcelo721.rewind_back_end.domain.repositories.MovieDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class MovieDetailsServiceImpl implements MovieDetailsUseCases {

    private final MovieDetailsRepository repository;

    public MovieDetailsServiceImpl(MovieDetailsRepository repository) {
        this.repository = repository;
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
}
