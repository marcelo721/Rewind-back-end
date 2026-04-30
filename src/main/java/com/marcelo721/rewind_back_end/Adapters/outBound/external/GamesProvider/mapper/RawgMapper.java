package com.marcelo721.rewind_back_end.Adapters.outBound.external.GamesProvider.mapper;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.GamesProvider.utils.RawgUtils;
import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.GameSummary;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class RawgMapper {
    public static GameSummary toGameSummary(Map<String, Object> item) {

        String id = String.valueOf(item.get("id"));
        String name = (String) item.get("name");
        String released = (String) item.get("released");
        String image = (String) item.get("background_image");

        String year = (released != null && !released.isEmpty())
                ? released.substring(0, 4)
                : "N/A";

        return new GameSummary(id, name, year, image);
    }

    public static GameDetails toGameDetails(Map<String, Object> response) {

        String title = (String) response.get("name");

        String rawDescription = (String) response.get("description");
        String description = RawgUtils.cleanHtml(rawDescription);

        String released = (String) response.get("released");
        String image = (String) response.get("background_image");

        Double rating = response.get("rating") != null
                ? Double.valueOf(response.get("rating").toString())
                : null;

        return new GameDetails(
                title,
                description,
                RawgUtils.parseDate(released),
                extractGenres(response),
                extractPlatforms(response),
                rating,
                image
        );
    }

    private static List<String> extractGenres(Map<String, Object> response) {
        if (response.get("genres") == null) return List.of();

        return ((List<Map<String, Object>>) response.get("genres"))
                .stream()
                .map(g -> (String) g.get("name"))
                .toList();
    }

    private static List<String> extractPlatforms(Map<String, Object> response) {
        if (response.get("platforms") == null) return List.of();

        return ((List<Map<String, Object>>) response.get("platforms"))
                .stream()
                .map(p -> {
                    Map<String, Object> platform =
                            (Map<String, Object>) p.get("platform");

                    return platform != null
                            ? (String) platform.get("name")
                            : null;
                })
                .filter(Objects::nonNull)
                .toList();
    }
}
