package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesSummary;

import java.util.List;

public interface SeriesProviderRepository {
    SeriesDetails getByImdbId(String imdbId);
    List<SeriesSummary> searchByTitle(String title);
}
