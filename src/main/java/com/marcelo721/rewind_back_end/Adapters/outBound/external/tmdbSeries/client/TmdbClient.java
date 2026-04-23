package com.marcelo721.rewind_back_end.Adapters.outBound.external.tmdbSeries.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class TmdbClient {

    private final String apiKey = System.getenv("API_KEY_TMDB");
    private final String BASE_URL = "https://api.themoviedb.org/3";

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> searchSeries(String title) {
        String url = BASE_URL + "/search/tv?api_key=" + apiKey + "&query=" + title;
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> getSeriesDetails(String id) {
        String url = BASE_URL + "/tv/" + id + "?api_key=" + apiKey;
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> getExternalIds(String id) {
        String url = BASE_URL + "/tv/" + id + "/external_ids?api_key=" + apiKey;
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> getProviders(String id) {
        String url = BASE_URL + "/tv/" + id + "/watch/providers?api_key=" + apiKey;
        return restTemplate.getForObject(url, Map.class);
    }

    public Map<String, Object> getWatchProviders(String id) {
        return restTemplate.getForObject(
                BASE_URL + "/tv/" + id + "/watch/providers?api_key=" + apiKey,
                Map.class
        );
    }
}
