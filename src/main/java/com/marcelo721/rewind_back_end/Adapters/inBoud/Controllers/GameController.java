package com.marcelo721.rewind_back_end.Adapters.inBoud.Controllers;

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
}
