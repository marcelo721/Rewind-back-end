package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.SerieDetailsDto;

import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record SeriesDetailsCreateDto(
        @NotNull
        UUID contentId,

        List<String> creators,
        List<String> genres,
        List<String> cast,

        Integer numberOfSeasons,
        Integer numberOfEpisodes,

        String status,

        LocalDate firstAirDate,
        LocalDate lastAirDate,

        String originalLanguage,
        String country,

        List<String> streamingPlatforms,

        Double imdbRating,
        Integer metascore,
        String awards,

        @NotBlank
        String title,

        @NotBlank
        String description
) {
    public SeriesDetails toDomain() {
        SeriesDetails seriesDetails = new SeriesDetails();
        seriesDetails.setCreators(creators);
        seriesDetails.setGenres(genres);
        seriesDetails.setCast(cast);
        seriesDetails.setNumberOfEpisodes(numberOfEpisodes);
        seriesDetails.setNumberOfSeasons(numberOfSeasons);
        seriesDetails.setStatus(status);
        seriesDetails.setFirstAirDate(firstAirDate);
        seriesDetails.setLastAirDate(lastAirDate);
        seriesDetails.setOriginalLanguage(originalLanguage);
        seriesDetails.setCountry(country);
        seriesDetails.setStreamingPlatforms(streamingPlatforms);
        seriesDetails.setImdbRating(imdbRating);
        seriesDetails.setMetascore(metascore);
        seriesDetails.setTitle(title);
        seriesDetails.setDescription(description);
        seriesDetails.setAwards(awards);

        return seriesDetails;
    }

}
