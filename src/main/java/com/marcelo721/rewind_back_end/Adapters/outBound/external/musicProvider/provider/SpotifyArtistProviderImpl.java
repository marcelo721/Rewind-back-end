package com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.provider;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.client.SpotifyClient;
import com.marcelo721.rewind_back_end.domain.model.entities.Artist;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

    @Component
    public class SpotifyArtistProviderImpl {

        private final SpotifyClient spotifyClient;
        private final ObjectMapper mapper = new ObjectMapper();

        public SpotifyArtistProviderImpl(SpotifyClient spotifyClient) {
            this.spotifyClient = spotifyClient;
        }

        public Artist getArtistByName(String artistName) {

            try {
                var response = spotifyClient.searchArtistByName(artistName);

                JsonNode root = mapper.valueToTree(response);

                JsonNode items = root.path("artists").path("items");

                if (!items.isArray() || items.size() == 0) {
                    throw new RuntimeException("Artista não encontrado");
                }

                String artistId = items.get(0).path("id").asText("");
                return getArtistById(artistId);

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        public Artist getArtistById(String artistId) {

            try {

                var response = spotifyClient.getArtistById(artistId);

                JsonNode artistData = mapper.valueToTree(response);
                String name = artistData.path("name").asText("");

                JsonNode followersNode = artistData.path("followers");

                long followers = followersNode.path("total").asLong(0);

                JsonNode genresNode = artistData.path("genres");

                List<String> genres = new ArrayList<>();

                if (genresNode.isArray()) {
                    for (JsonNode g : genresNode) {
                        genres.add(g.asText());
                    }
                }

                JsonNode images = artistData.path("images");

                String imageUrl = "";

                if (images.isArray() && images.size() > 0) {
                    imageUrl = images.get(0).path("url").asText("");
                }


                Artist artist = new Artist(
                        artistId,
                        name,
                        "Biografia não disponível via Spotify API",
                        genres,
                        0,
                        0,
                        followers,
                        imageUrl
                );

                return artist;

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

}
