package com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbSeries.client;


import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class OmdbClient {
    private final String apiKey = System.getenv("API_KEY");

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> getByImdbId(String imdbId) {
        String url = "http://www.omdbapi.com/?apikey=" + apiKey + "&i=" + imdbId;
        return restTemplate.getForObject(url, Map.class);
    }
}
