package com.marcelo721.rewind_back_end.domain.repositories;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;

import java.util.List;
import java.util.UUID;

public interface SeriesDetailsRepository {
    SeriesDetails findById(UUID id);
    void create(SeriesDetails seriesDetails);
    List<SeriesDetails> findAll();
}
