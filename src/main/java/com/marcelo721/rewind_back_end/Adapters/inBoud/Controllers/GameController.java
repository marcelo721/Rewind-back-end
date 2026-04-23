package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;
import com.marcelo721.rewind_back_end.Application.useCases.GameDetailsUseCases;
import com.marcelo721.rewind_back_end.domain.model.entities.GameDetails;
import com.marcelo721.rewind_back_end.domain.model.entities.GameSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameDetailsUseCases gameDetailsUseCases;

    public GameController(GameDetailsUseCases gameDetailsUseCases) {
        this.gameDetailsUseCases = gameDetailsUseCases;
    }

    @GetMapping("/search")
    public ResponseEntity<List<GameSummary>> search(@RequestParam String title) {
        return  ResponseEntity.ok(gameDetailsUseCases.searchByTitle(title));
    }


    @GetMapping("/{id}")
    public ResponseEntity<GameDetails> getDetails(@PathVariable String id) {
        return ResponseEntity.ok(gameDetailsUseCases.getById(id));
    }
}
