package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.GameDetailsDto;

import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record GameDetailsCreateDto(
        @NotNull
        UUID contentId,

        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        LocalDate releaseDate,

        @NotBlank
        String status,

        @NotBlank
        Integer metaCriticScore,


        List<String> platforms,

        List<String> genres,

        String developer

) {

    public GameDetails toDomain(){
        GameDetails gameDetails = new GameDetails();
        gameDetails.setTitle(title);
        gameDetails.setDescription(description);
        gameDetails.setReleaseDate(releaseDate);
        gameDetails.setStatus(status);
        gameDetails.setMetaCriticScore(metaCriticScore);
        gameDetails.setPlatforms(platforms);
        gameDetails.setGenres(genres);
        gameDetails.setDeveloper(developer);

        return gameDetails;
    }
}
