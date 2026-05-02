package com.marcelo721.rewind_back_end.Application.useCasesImpl;

import com.marcelo721.rewind_back_end.Application.useCases.MusicDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Album;
import com.marcelo721.rewind_back_end.domain.model.entities.Artist;
import com.marcelo721.rewind_back_end.domain.model.entities.ArtistSummary;
import com.marcelo721.rewind_back_end.domain.model.entities.Track;
import com.marcelo721.rewind_back_end.domain.ports.AlbumProviderRepository;
import com.marcelo721.rewind_back_end.domain.ports.ArtistProviderRepository;
import com.marcelo721.rewind_back_end.domain.ports.TrackProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicDetailsUseCases {

    private final ArtistProviderRepository artistPort;
    private final AlbumProviderRepository albumPort;
    private final TrackProviderRepository trackPort;

    public MusicServiceImpl(ArtistProviderRepository artistPort, AlbumProviderRepository albumPort, TrackProviderRepository trackPort) {
        this.artistPort = artistPort;
        this.albumPort = albumPort;
        this.trackPort = trackPort;
    }

    public List<ArtistSummary> getCompleteArtistProfile(String artistName) {
        List<ArtistSummary> artist = artistPort.getArtistsByName(artistName);
        return artist;
    }

    public List<Album> getArtistAlbums(String artistId) {
        return albumPort.getAlbumsByArtist(artistId);
    }

    public List<Track> getAlbumTracks(String albumId) {
        return trackPort.getTracksByAlbum(albumId);
    }

    @Override
    public Artist getArtistById(String artistId) {
        return artistPort.getArtistById(artistId);
    }


}
