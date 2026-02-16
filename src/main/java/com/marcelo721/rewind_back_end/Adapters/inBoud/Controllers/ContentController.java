package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Application.useCases.ContentUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/contents")
public class ContentController {

    private final ContentUseCases useCases;

    public ContentController(ContentUseCases useCases) {
        this.useCases = useCases;
    }

    @GetMapping("/{id}")
    public Content getContent(@PathVariable UUID id) {
        return useCases.findById(id);
    }

    @GetMapping
    public List<Content> getAllContents() {
        return useCases.findAll();
    }

    @PostMapping
    public void createContent(@RequestBody Content content) {
        useCases.createContent(content);
    }
}
