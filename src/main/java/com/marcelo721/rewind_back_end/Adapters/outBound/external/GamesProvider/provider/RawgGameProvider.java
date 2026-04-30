package com.marcelo721.rewind_back_end.Adapters.outBound.external.GamesProvider.provider;


import com.marcelo721.rewind_back_end.Adapters.outBound.external.GamesProvider.client.RawgClient;
import com.marcelo721.rewind_back_end.Adapters.outBound.external.GamesProvider.mapper.RawgMapper;
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

        return results.stream()
                .map(RawgMapper::toGameSummary)
                .toList();
    }

    @Override
    public GameDetails getById(String id) {

        Map<String, Object> response = client.getGameDetails(id);

        return RawgMapper.toGameDetails(response);
    }
}
