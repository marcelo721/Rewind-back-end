package com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.client;


import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Base64;
import java.util.Map;

@Component
public class SpotifyClient {

    private final WebClient authClient;
    private final WebClient apiClient;

    private final String clientId = System.getenv("CLIENT_ID");
    private final String clientSecret = System.getenv("CLIENT_SECRET");

    private String accessToken;

    public SpotifyClient(WebClient.Builder webClientBuilder) {
        this.authClient = webClientBuilder
                .baseUrl("https://accounts.spotify.com")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .build();

        this.apiClient = webClientBuilder
                .baseUrl("https://api.spotify.com/v1")
                .build();
    }

    private String getAccessToken() {
        if (accessToken != null) {
            return accessToken;
        }

        String credentials = clientId + ":" + clientSecret;
        String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());

        Map response = authClient.post()
                .uri("/api/token")
                .header(HttpHeaders.AUTHORIZATION, "Basic " + encodedCredentials)
                .bodyValue("grant_type=client_credentials")
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        accessToken = (String) response.get("access_token");
        accessToken = (String) response.get("access_token");
        System.out.println("Spotify Token: " + accessToken);
        return accessToken;
    }

    public Map searchArtistByName(String artistName) {
        String token = getAccessToken();

        return apiClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search")
                        .queryParam("q", artistName)
                        .queryParam("type", "artist")
                        .queryParam("limit", 1)
                        .build())
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }

    public Map getArtistById(String artistId) {
        String token = getAccessToken();

        return apiClient.get()
                .uri("/artists/{id}", artistId)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
