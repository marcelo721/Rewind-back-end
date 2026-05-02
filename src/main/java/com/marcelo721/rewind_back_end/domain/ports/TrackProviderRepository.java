package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.Track;

import java.util.List;

public interface TrackProviderRepository {
    List<Track> getTracksByAlbum(String albumId);
}
