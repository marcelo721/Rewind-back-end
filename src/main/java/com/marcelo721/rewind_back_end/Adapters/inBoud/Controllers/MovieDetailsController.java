package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.movieDto.MovieDetailsCreateDto;
import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.movieDto.MovieResponseDto;
import com.marcelo721.rewind_back_end.Application.useCases.ContentUseCases;
import com.marcelo721.rewind_back_end.Application.useCases.MovieDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
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


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid MovieDetailsCreateDto movie) {
        Content content = contentUseCases.findById(movie.contentId());
        MovieDetails obj = movie.toDomain();
        obj.setContent(content);
        service.create(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieResponseDto> findById(@PathVariable UUID id) {
        MovieDetails obj = service.findById(id);
        return ResponseEntity.ok(MovieResponseDto.toDto(obj));
    }

    @GetMapping
    public ResponseEntity<List<MovieResponseDto>> getAll() {
        List<MovieDetails> movies = service.findAll();
        return ResponseEntity.ok(MovieResponseDto.toListDto(movies));
    }
}
