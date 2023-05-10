package com.devsprintboot.gameslist.services;

import com.devsprintboot.gameslist.dto.GameDTO;
import com.devsprintboot.gameslist.dto.GameMinDTO;
import com.devsprintboot.gameslist.entities.Games;
import com.devsprintboot.gameslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        return gameRepository.searchByList(listId).stream()
                .map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long gameId) {
        Games game= gameRepository.findById(gameId).get();
        return new GameDTO(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        return gameRepository.findAll().stream().map(GameMinDTO::new).toList();
    }

}
