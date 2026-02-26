package com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.GameDetailsDto;

import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public record GameDetailsResponseDto(
        UUID id,
        UUID contentId,
        String title,
        String description,
        LocalDate releaseDate,
        String status,
        Integer metaCriticScore,
        List<String> platforms,
        List<String> genres,
        String developer
) {

    public static GameDetailsResponseDto toDto(GameDetails game) {
        return new GameDetailsResponseDto(
                game.getId(),
                game.getContent().getId(),
                game.getTitle(),
                game.getDescription(),
                game.getReleaseDate(),
                game.getStatus(),
                game.getMetaCriticScore(),
                game.getPlatforms(),
                game.getGenres(),
                game.getDeveloper()
        );
    }

    public static List<GameDetailsResponseDto> toListDto(List<GameDetails> games) {
        List<GameDetailsResponseDto> list = new ArrayList<>();

        for (GameDetails g : games) {
            list.add(toDto(g));
        }

        return list;
    }
}
