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
}
