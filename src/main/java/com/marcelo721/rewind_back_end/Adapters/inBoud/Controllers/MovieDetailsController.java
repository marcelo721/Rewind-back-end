package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Application.useCases.MovieDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.MovieDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieDetailsController {

    private final MovieDetailsUseCases useCases;

    public MovieDetailsController(MovieDetailsUseCases useCases) {
        this.useCases = useCases;
    }

    @GetMapping("/{id}")
    public MovieDetails getUser(@PathVariable UUID id) {
        return useCases.findById(id);
    }

    @GetMapping
    public List<MovieDetails> getAll() {
        return useCases.findAll();
    }

    @PostMapping
    public void create(@RequestBody MovieDetails obj) {
        useCases.create(obj);
    }
}
