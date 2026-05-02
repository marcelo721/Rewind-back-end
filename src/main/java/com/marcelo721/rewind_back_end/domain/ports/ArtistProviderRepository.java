package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.Artist;
import com.marcelo721.rewind_back_end.domain.model.entities.ArtistSummary;

import java.util.List;

public interface ArtistProviderRepository {
    List<ArtistSummary> getArtistsByName(String name);
    Artist getArtistById(String artistId);
}
