package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.movieDto.MovieDetailsCreateDto;
import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.movieDto.MovieResponseDto;
import com.marcelo721.rewind_back_end.Application.useCases.ContentUseCases;
import com.marcelo721.rewind_back_end.Application.useCases.MovieDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieSummary;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieDetailsController {

    private final MovieDetailsUseCases service;
    private final ContentUseCases contentUseCases;

    public MovieDetailsController(MovieDetailsUseCases service, ContentUseCases contentUseCases) {
        this.service = service;
        this.contentUseCases = contentUseCases;
    }

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<MovieResponseDto> getFromOmdb(@PathVariable String imdbId) {
        MovieDetails movie = service.getFromProvider(imdbId);
        return ResponseEntity.ok(MovieResponseDto.toDto(movie));
    }

    @GetMapping("/search")
    public List<MovieSummary> search(@RequestParam String title) {
        return service.searchByTitle(title);
    }

    @GetMapping("/genre")
    public List<MovieDetails> searchByGenre(
            @RequestParam String genre,
            @RequestParam(defaultValue = "1") int page) {

        return service.searchByGenre(genre, page);
    }
}
