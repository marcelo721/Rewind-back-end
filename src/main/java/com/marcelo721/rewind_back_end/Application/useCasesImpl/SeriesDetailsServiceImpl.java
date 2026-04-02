package com.marcelo721.rewind_back_end.Application.useCasesImpl;

import com.marcelo721.rewind_back_end.Application.useCases.SeriesDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import com.marcelo721.rewind_back_end.domain.ports.SeriesDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SeriesDetailsServiceImpl implements SeriesDetailsUseCases {

    private final SeriesDetailsRepository repository;

    public SeriesDetailsServiceImpl(SeriesDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public SeriesDetails findById(UUID id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public void create(SeriesDetails seriesDetails) {
        repository.create(seriesDetails);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SeriesDetails> findAll() {
        return repository.findAll();
    }
}
