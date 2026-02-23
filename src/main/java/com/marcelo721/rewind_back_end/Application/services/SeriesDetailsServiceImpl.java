package com.marcelo721.rewind_back_end.Application.services;

import com.marcelo721.rewind_back_end.Application.useCases.ContentUseCases;
import com.marcelo721.rewind_back_end.Application.useCases.SeriesDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import com.marcelo721.rewind_back_end.domain.repositories.SeriesDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SeriesDetailsServiceImpl implements SeriesDetailsUseCases {

    private final SeriesDetailsRepository repository;
    private final ContentUseCases contentUseCases;

    public SeriesDetailsServiceImpl(SeriesDetailsRepository repository, ContentUseCases contentUseCases) {
        this.repository = repository;
        this.contentUseCases = contentUseCases;
    }

    @Override
    @Transactional(readOnly = true)
    public SeriesDetails findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void create(SeriesDetails seriesDetails) {
        Content content = contentUseCases.findById(seriesDetails.getContent().getId());
        seriesDetails.setContent(content);
        repository.create(seriesDetails);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SeriesDetails> findAll() {
        return repository.findAll();
    }
}
