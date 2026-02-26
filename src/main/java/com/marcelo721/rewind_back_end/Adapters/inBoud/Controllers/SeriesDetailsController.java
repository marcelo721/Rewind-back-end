package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.SerieDetailsDto.SeriesDetailsCreateDto;
import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.SerieDetailsDto.SeriesDetailsResponseDto;
import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.movieDto.MovieDetailsCreateDto;
import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.movieDto.MovieResponseDto;
import com.marcelo721.rewind_back_end.Application.useCases.ContentUseCases;
import com.marcelo721.rewind_back_end.Application.useCases.SeriesDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/series")
public class SeriesDetailsController {

    private final SeriesDetailsUseCases useCases;
    private final ContentUseCases contentUseCases;


    public SeriesDetailsController(SeriesDetailsUseCases useCases, ContentUseCases contentUseCases) {
        this.useCases = useCases;
        this.contentUseCases = contentUseCases;
    }


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid SeriesDetailsCreateDto series) {
        Content content = contentUseCases.findById(series.contentId());
        SeriesDetails obj = series.toDomain();
        obj.setContent(content);
        useCases.create(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SeriesDetailsResponseDto> findById(@PathVariable UUID id) {
        SeriesDetails obj = useCases.findById(id);
        return ResponseEntity.ok(SeriesDetailsResponseDto.toDto(obj));
    }

    @GetMapping
    public ResponseEntity<List<SeriesDetailsResponseDto>> getAll() {
        List<SeriesDetails> series = useCases.findAll();
        return ResponseEntity.ok(SeriesDetailsResponseDto.toListDto(series));
    }
}
