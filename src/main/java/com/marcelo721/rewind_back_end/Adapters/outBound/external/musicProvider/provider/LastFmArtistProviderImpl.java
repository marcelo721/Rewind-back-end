package com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.provider;


import com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.client.LastFmClient;
import com.marcelo721.rewind_back_end.domain.model.entities.Artist;
import com.marcelo721.rewind_back_end.domain.model.entities.ArtistSummary;
import com.marcelo721.rewind_back_end.domain.ports.ArtistProviderRepository;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class LastFmArtistProviderImpl implements ArtistProviderRepository {

    private final LastFmClient client;
    private final ObjectMapper mapper = new ObjectMapper();

    public LastFmArtistProviderImpl(LastFmClient client) {
        this.client = client;
    }

    @Override
    public List<ArtistSummary> getArtistsByName(String name) {

        try {
            String response = client.getArtistInfo(name);

            JsonNode artistsNode = mapper.readTree(response)
                    .path("results")
                    .path("artistmatches")
                    .path("artist");

            List<ArtistSummary> artists = new ArrayList<>();

            String searchTerm = name.toLowerCase().trim();

            for (JsonNode artistNode : artistsNode) {

                String artistName = artistNode.path("name").asText("").trim();
                String normalized = artistName.toLowerCase();

                String artistId = artistNode.path("mbid").asText("");

                if (artistId.isEmpty()) {
                    continue;
                }

                if (!normalized.contains(searchTerm)) {
                    continue;
                }

                if (normalized.contains("feat")
                        || normalized.contains("ft")
                        || normalized.contains("featuring")
                        || normalized.contains("|")
                        || normalized.contains("•")
                        || normalized.contains("topic")
                        || normalized.contains("www")
                        || normalized.contains("download")
                        || normalized.contains("lossless")
                        || normalized.contains("\"")
                        || normalized.contains("🔴")
                        || normalized.contains("/")
                        || normalized.contains(":")
                        || normalized.contains("&")
                        || normalized.contains(" x ")
                        || normalized.contains(" with ")
                        || normalized.contains(",")) {
                    continue;
                }

                long listeners = artistNode.path("listeners").asLong(0);

                artists.add(new ArtistSummary(
                        artistName,
                        artistId,
                        listeners
                ));
            }

            artists.sort(Comparator.comparingLong(ArtistSummary::getListeners).reversed());

            return artists.stream()
                    .limit(10)
                    .toList();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar artistas", e);
        }
    }

    @Override
    public Artist getArtistById(String artistId) {

        try {
            String response = client.getArtistById(artistId);

            JsonNode artistNode = mapper.readTree(response)
                    .path("artist");

            if (artistNode.isMissingNode() || artistNode.isEmpty()) {
                throw new RuntimeException("Artista não encontrado");
            }

            String biography = artistNode.path("bio")
                    .path("summary")
                    .asText("");

            long listeners = artistNode.path("stats")
                    .path("listeners")
                    .asLong(0);

            long playCount = artistNode.path("stats")
                    .path("playcount")
                    .asLong(0);

            List<String> genres = new ArrayList<>();

            JsonNode tags = artistNode.path("tags").path("tag");

            if (tags.isArray()) {
                for (JsonNode tag : tags) {
                    String genre = tag.path("name").asText("");
                    if (!genre.isEmpty()) {
                        genres.add(genre);
                    }
                }
            }

            return new Artist(
                    artistNode.path("mbid").asText(),
                    artistNode.path("name").asText(),
                    biography,
                    genres,
                    listeners,
                    playCount
            );

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar artista por ID", e);
        }
    }
}