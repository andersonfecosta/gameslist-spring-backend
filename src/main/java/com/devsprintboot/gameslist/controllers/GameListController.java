package com.devsprintboot.gameslist.controllers;

import com.devsprintboot.gameslist.dto.GameListDTO;
import com.devsprintboot.gameslist.dto.GameMinDTO;
import com.devsprintboot.gameslist.dto.ReplacementDTO;
import com.devsprintboot.gameslist.services.GameListService;
import com.devsprintboot.gameslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameService gameService;
    @Autowired
    private GameListService gameListService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDTO body) {
        gameListService.move(listId,body.getSourceIndex(), body.getDestinationIndex());
    }
}
