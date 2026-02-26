package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.SerieDetailsDto;

import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record SeriesDetailsResponseDto(
        UUID id,
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

        String title,
        String description
) {
    public static SeriesDetailsResponseDto toDto(SeriesDetails series) {
        return new SeriesDetailsResponseDto(
                series.getId(),
                series.getContent() != null ? series.getContent().getId() : null,
                series.getCreators(),
                series.getGenres(),
                series.getCast(),
                series.getNumberOfSeasons(),
                series.getNumberOfEpisodes(),
                series.getStatus(),
                series.getFirstAirDate(),
                series.getLastAirDate(),
                series.getOriginalLanguage(),
                series.getCountry(),
                series.getStreamingPlatforms(),
                series.getImdbRating(),
                series.getMetascore(),
                series.getAwards(),
                series.getTitle(),
                series.getDescription()
        );
    }

    public static List<SeriesDetailsResponseDto> toListDto(List<SeriesDetails> list) {
        return list.stream()
                .map(SeriesDetailsResponseDto::toDto)
                .toList();
    }
}
