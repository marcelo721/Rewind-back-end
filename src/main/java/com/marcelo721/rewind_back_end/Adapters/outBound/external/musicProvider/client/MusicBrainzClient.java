package com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class MusicBrainzClient {

    private final WebClient webClient;
    private final String email = System.getenv("EMAIL");

    public MusicBrainzClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    public String getArtistAlbums(String artistId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("musicbrainz.org")
                        .path("/ws/2/release-group")
                        .queryParam("artist", artistId)
                        .queryParam("inc", "artist-credits")
                        .queryParam("fmt", "json")
                        .build())
                .header("User-Agent", "RewindApp/1.0 (" + email + ")")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getReleasesByReleaseGroup(String releaseGroupId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("musicbrainz.org")
                        .path("/ws/2/release")
                        .queryParam("release-group", releaseGroupId)
                        .queryParam("fmt", "json")
                        .build())
                .header("User-Agent", "RewindApp/1.0 (" + email + ")")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getAlbumTracks(String releaseId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .scheme("https")
                        .host("musicbrainz.org")
                        .path("/ws/2/release/" + releaseId)
                        .queryParam("inc", "recordings")
                        .queryParam("fmt", "json")
                        .build())
                .header("User-Agent", "RewindApp/1.0 (" + email + ")")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
