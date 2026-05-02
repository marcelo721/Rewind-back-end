package com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.provider;


import com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.client.MusicBrainzClient;
import com.marcelo721.rewind_back_end.domain.model.entities.Album;
import com.marcelo721.rewind_back_end.domain.model.entities.Track;
import com.marcelo721.rewind_back_end.domain.ports.AlbumProviderRepository;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicBrainzAlbumProviderImpl implements AlbumProviderRepository {
    private final MusicBrainzClient client;
    private final ObjectMapper mapper = new ObjectMapper();

    public MusicBrainzAlbumProviderImpl(MusicBrainzClient client) {
        this.client = client;
    }

    @Override
    public List<Album> getAlbumsByArtist(String artistId) {
        try {
            String response = client.getArtistAlbums(artistId);
            JsonNode releaseGroups = mapper.readTree(response).path("release-groups");

            List<Album> albums = new ArrayList<>();

            for (JsonNode releaseGroup : releaseGroups) {

                String primaryType = releaseGroup.path("primary-type").asText("");
                JsonNode secondaryTypesNode = releaseGroup.path("secondary-types");

                boolean isAlbum = "Album".equalsIgnoreCase(primaryType);
                boolean isEp = "EP".equalsIgnoreCase(primaryType);

                boolean isLive = false;
                boolean shouldExclude = false;

                if (secondaryTypesNode.isArray()) {
                    for (JsonNode typeNode : secondaryTypesNode) {

                        String secondaryType = typeNode.asText("").toLowerCase();

                        if ("live".equals(secondaryType)) {
                            isLive = true;
                        }

                        if ("compilation".equals(secondaryType)
                                || "remix".equals(secondaryType)
                                || "soundtrack".equals(secondaryType)
                                || "spokenword".equals(secondaryType)
                                || "audiobook".equals(secondaryType)
                                || "demo".equals(secondaryType)) {
                            shouldExclude = true;
                        }
                    }
                }


                if (!(isAlbum || isEp || isLive) || shouldExclude) {
                    continue;
                }

                String artistName = "";

                if (releaseGroup.has("artist-credit")
                        && releaseGroup.path("artist-credit").isArray()
                        && releaseGroup.path("artist-credit").size() > 0) {

                    artistName = releaseGroup.path("artist-credit")
                            .get(0)
                            .path("name")
                            .asText("");
                }

                albums.add(new Album(
                        releaseGroup.path("id").asText(),
                        releaseGroup.path("title").asText(),
                        artistName,
                        releaseGroup.path("first-release-date").asText()
                ));
            }

            return albums;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar álbuns do artista", e);
        }
    }
}
