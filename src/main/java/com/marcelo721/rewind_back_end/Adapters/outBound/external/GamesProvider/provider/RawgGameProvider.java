package com.marcelo721.rewind_back_end.Adapters.outBound.external.GamesProvider.provider;


import com.marcelo721.rewind_back_end.Adapters.outBound.external.GamesProvider.client.RawgClient;
import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.GameSummary;
import com.marcelo721.rewind_back_end.domain.ports.GameProviderRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Component
public class RawgGameProvider implements GameProviderRepository {

    private final RawgClient client;

    public RawgGameProvider(RawgClient client) {
        this.client = client;
    }

    @Override
    public List<GameSummary> searchByTitle(String title) {

        Map<String, Object> response = client.searchGames(title);

        List<Map<String, Object>> results =
                (List<Map<String, Object>>) response.get("results");

        return results.stream().map(item -> {

            String id = String.valueOf(item.get("id"));
            String name = (String) item.get("name");
            String released = (String) item.get("released");
            String image = (String) item.get("background_image");

            String year = (released != null && !released.isEmpty())
                    ? released.substring(0, 4)
                    : "N/A";

            return new GameSummary(id, name, year, image);

        }).toList();
    }

    @Override
    public GameDetails getById(String id) {

        Map<String, Object> response = client.getGameDetails(id);

        String title = (String) response.get("name");

        String rawDescription = (String) response.get("description");
        String description = rawDescription != null
                ? rawDescription.replaceAll("<[^>]*>", "")
                : null;

        String released = (String) response.get("released");
        String image = (String) response.get("background_image");

        Double rating = response.get("rating") != null
                ? Double.valueOf(response.get("rating").toString())
                : null;

        LocalDate releaseDate = parseDate(released);

        List<String> genres = List.of();

        if (response.get("genres") != null) {
            genres = ((List<Map<String, Object>>) response.get("genres"))
                    .stream()
                    .map(g -> (String) g.get("name"))
                    .toList();
        }

        List<String> platforms = List.of();

        if (response.get("platforms") != null) {
            platforms = ((List<Map<String, Object>>) response.get("platforms"))
                    .stream()
                    .map(p -> {
                        Map<String, Object> platform =
                                (Map<String, Object>) p.get("platform");

                        return platform != null
                                ? (String) platform.get("name")
                                : null;
                    })
                    .filter(p -> p != null)
                    .toList();
        }

        return new GameDetails(
                title,
                description,
                releaseDate,
                genres,
                platforms,
                rating,
                image
        );
    }
    
    private LocalDate parseDate(String date) {
        try {
            return (date != null && !date.isEmpty())
                    ? LocalDate.parse(date)
                    : null;
        } catch (Exception e) {
            return null;
        }
    }
}
