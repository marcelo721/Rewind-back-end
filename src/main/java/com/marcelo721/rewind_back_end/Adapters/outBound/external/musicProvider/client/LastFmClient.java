package com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.client;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class LastFmClient {

    private final WebClient webClient;


    private String apiKey = System. getenv("LAST_FM_API_KEY");

    public LastFmClient(WebClient.Builder webClient) {
        this.webClient = webClient.build();
    }

    public String getArtistInfo(String artistName) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("ws.audioscrobbler.com")
                        .path("/2.0/")
                        .queryParam("method", "artist.search")
                        .queryParam("artist", artistName)
                        .queryParam("api_key", apiKey)
                        .queryParam("format", "json")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getArtistById(String mbid) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("ws.audioscrobbler.com")
                        .path("/2.0/")
                        .queryParam("method", "artist.getinfo")
                        .queryParam("mbid", mbid)
                        .queryParam("api_key", apiKey)
                        .queryParam("format", "json")
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
