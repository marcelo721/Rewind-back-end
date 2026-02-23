package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Application.useCases.SeriesDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.SeriesDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/series")
public class SeriesDetailsController {

    private final SeriesDetailsUseCases useCases;

    public SeriesDetailsController(SeriesDetailsUseCases useCases) {
        this.useCases = useCases;
    }


    @GetMapping("/{id}")
    public SeriesDetails getUser(@PathVariable UUID id) {
        return useCases.findById(id);
    }

    @GetMapping
    public List<SeriesDetails> getAll() {
        return useCases.findAll();
    }

    @PostMapping
    public void create(@RequestBody SeriesDetails obj) {
        useCases.create(obj);
    }
}
