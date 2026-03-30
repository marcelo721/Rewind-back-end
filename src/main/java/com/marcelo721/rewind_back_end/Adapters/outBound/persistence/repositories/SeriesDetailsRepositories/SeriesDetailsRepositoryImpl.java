package com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.SeriesDetailsRepositories;

import com.marcelo721.rewind_back_end.Adapters.outBound.persistence.repositories.mappers.SeriesDetailsPersistenceMapper;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import com.marcelo721.rewind_back_end.domain.repositories.SeriesDetailsRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class SeriesDetailsRepositoryImpl implements SeriesDetailsRepository {

    private final JpaSeriesDetailsRepository repository;

    public SeriesDetailsRepositoryImpl(JpaSeriesDetailsRepository repository) {
        this.repository = repository;
    }


    @Override
    public SeriesDetails findById(UUID id) {
        return this.repository.findById(id)
                .map(SeriesDetailsPersistenceMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void create(SeriesDetails seriesDetails) {
        this.repository.save(
                SeriesDetailsPersistenceMapper.toEntity(seriesDetails)
        );
    }

    @Override
    public List<SeriesDetails> findAll() {
        return this.repository.findAll()
                .stream()
                .map(SeriesDetailsPersistenceMapper::toDomain)
                .toList();
    }
}
