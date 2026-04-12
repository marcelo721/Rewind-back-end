package com.marcelo721.rewind_back_end.Application.useCasesImpl;

import com.marcelo721.rewind_back_end.Application.useCases.SeriesDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesSummary;
import com.marcelo721.rewind_back_end.domain.ports.SeriesProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesDetailsServiceImpl implements SeriesDetailsUseCases {

    private final SeriesProviderRepository seriesProviderRepository;

    public SeriesDetailsServiceImpl(SeriesProviderRepository seriesProviderRepository) {
        this.seriesProviderRepository = seriesProviderRepository;
    }

    @Override
    public SeriesDetails getByImdbId(String imdbId) {
        return seriesProviderRepository.getByImdbId(imdbId);
    }

    @Override
    public List<SeriesSummary> searchByTitle(String title) {
        return seriesProviderRepository.searchByTitle(title);
    }
}
