package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Application.useCases.MusicDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Album;
import com.marcelo721.rewind_back_end.domain.model.entities.Artist;
import com.marcelo721.rewind_back_end.domain.model.entities.ArtistSummary;
import com.marcelo721.rewind_back_end.domain.model.entities.Track;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicController {

    private final MusicDetailsUseCases musicService;

    public MusicController(MusicDetailsUseCases musicService) {
        this.musicService = musicService;
    }


    @GetMapping("/artist/{name}")
    public List<ArtistSummary> getArtist(@PathVariable String name) {
        return musicService.getCompleteArtistProfile(name);
    }

    @GetMapping("/artist/{id}/albums")
    public List<Album> getAlbums(@PathVariable String id) {
        return musicService.getArtistAlbums(id);
    }

    @GetMapping("/album/{albumId}/tracks")
    public List<Track> getTracks(@PathVariable String albumId) {
        return musicService.getAlbumTracks(albumId);
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Rewind Music API funcionando corretamente.";
    }

    @GetMapping("/artistid/{id}")
    public Artist getById(@PathVariable String id) {
        return musicService.getArtistById(id);
    }
}
