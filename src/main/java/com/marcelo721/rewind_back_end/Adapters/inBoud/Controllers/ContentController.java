package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.contentDto.ContentCreateDto;
import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.contentDto.ContentResponseDto;
import com.marcelo721.rewind_back_end.Application.useCases.ContentUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping
    public ResponseEntity<Void> createContent(@RequestBody @Valid ContentCreateDto content) {
        Content obj = content.toEntity();
        useCases.createContent(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContentResponseDto> getContent(@PathVariable UUID id) {
        Content obj =  useCases.findById(id);
        return ResponseEntity.ok(ContentResponseDto.toDto(obj));
    }

    @GetMapping
    public ResponseEntity<List<ContentResponseDto>> getAllContents() {
        List<Content> contents = useCases.findAll();
        return ResponseEntity.ok(ContentResponseDto.toListDto(contents));
    }
}
