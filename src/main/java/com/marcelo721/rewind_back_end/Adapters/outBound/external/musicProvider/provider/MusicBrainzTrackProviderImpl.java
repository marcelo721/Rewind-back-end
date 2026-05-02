package com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.provider;

import com.marcelo721.rewind_back_end.Adapters.outBound.external.musicProvider.client.MusicBrainzClient;
import com.marcelo721.rewind_back_end.domain.model.entities.Track;
import com.marcelo721.rewind_back_end.domain.ports.TrackProviderRepository;
import org.springframework.stereotype.Component;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class MusicBrainzTrackProviderImpl implements TrackProviderRepository {

    private final MusicBrainzClient client;
    private final ObjectMapper mapper = new ObjectMapper();

    public MusicBrainzTrackProviderImpl(MusicBrainzClient client) {
        this.client = client;
    }

    @Override
    public List<Track> getTracksByAlbum(String albumId) {
        try {
            String releasesResponse = client.getReleasesByReleaseGroup(albumId);
            JsonNode releases = mapper.readTree(releasesResponse).path("releases");

            if (!releases.isArray() || releases.size() == 0) {
                return new ArrayList<>();
            }

            String releaseId = releases.get(0).path("id").asText();

            String response = client.getAlbumTracks(releaseId);
            JsonNode media = mapper.readTree(response).path("media");

            List<Track> tracks = new ArrayList<>();

            for (JsonNode medium : media) {
                for (JsonNode trackNode : medium.path("tracks")) {

                    tracks.add(new Track(
                            trackNode.path("id").asText(),
                            trackNode.path("title").asText(),
                            trackNode.path("length").asInt() / 1000
                    ));
                }
            }

            return tracks;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar tracks do álbum", e);
        }
    }

}
