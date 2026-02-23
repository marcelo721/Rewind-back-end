package com.marcelo721.rewind_back_end.Application.useCases;

import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;

import java.util.List;
import java.util.UUID;

public interface SeriesDetailsUseCases {

    SeriesDetails findById(UUID id);
    void create(SeriesDetails seriesDetails);
    List<SeriesDetails> findAll();
}
