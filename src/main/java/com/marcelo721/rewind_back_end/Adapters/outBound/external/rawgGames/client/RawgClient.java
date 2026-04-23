package com.marcelo721.rewind_back_end.Adapters.outBound.external.rawgGames.client;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class RawgClient {

    private final String apiKey = System.getenv("RAWG_API_KEY");
    private final String BASE_URL = "https://api.rawg.io/api";

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> searchGames(String name) {
        String url = BASE_URL + "/games?key=" + apiKey + "&search=" + name;
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> getGameDetails(String id) {
        String url = BASE_URL + "/games/" + id + "?key=" + apiKey;
        return restTemplate.getForObject(url, Map.class);
    }
}
