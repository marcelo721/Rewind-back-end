package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.GameDetailsDto.GameDetailsCreateDto;
import com.marcelo721.rewind_back_end.Adapters.inBoud.Dto.GameDetailsDto.GameDetailsResponseDto;
import com.marcelo721.rewind_back_end.Application.useCases.ContentUseCases;
import com.marcelo721.rewind_back_end.Application.useCases.GameDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.Content;
import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameDetailsUseCases gameDetailsUseCases;
    private final ContentUseCases contentUseCases;

    public GameController(GameDetailsUseCases gameDetailsUseCases, ContentUseCases contentUseCases) {
        this.gameDetailsUseCases = gameDetailsUseCases;
        this.contentUseCases = contentUseCases;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid GameDetailsCreateDto game) {
        Content content = contentUseCases.findById(game.contentId());
        GameDetails obj = game.toDomain();
        obj.setContent(content);
        gameDetailsUseCases.create(obj);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GameDetailsResponseDto> findById(@PathVariable UUID id) {
        GameDetails obj = gameDetailsUseCases.findById(id);
        return ResponseEntity.ok(GameDetailsResponseDto.toDto(obj));
    }

    @GetMapping
    public ResponseEntity<List<GameDetailsResponseDto>> getAll() {
        List<GameDetails> games = gameDetailsUseCases.findAll();
        return ResponseEntity.ok(GameDetailsResponseDto.toListDto(games));
    }
}
