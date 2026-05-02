package com.marcelo721.rewind_back_end.Application.useCases;

import com.marcelo721.rewind_back_end.domain.model.entities.Album;
import com.marcelo721.rewind_back_end.domain.model.entities.Artist;
import com.marcelo721.rewind_back_end.domain.model.entities.ArtistSummary;
import com.marcelo721.rewind_back_end.domain.model.entities.Track;

import java.util.List;

public interface MusicDetailsUseCases {
    List<ArtistSummary> getCompleteArtistProfile(String artistName);
    List<Album> getArtistAlbums(String artistId);
    List<Track> getAlbumTracks(String albumId);
    Artist getArtistById(String artistId);
}
