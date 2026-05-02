package com.marcelo721.rewind_back_end.domain.ports;

import com.marcelo721.rewind_back_end.domain.model.entities.Album;

import java.util.List;

public interface AlbumProviderRepository {
    List<Album> getAlbumsByArtist(String artistId);
}
