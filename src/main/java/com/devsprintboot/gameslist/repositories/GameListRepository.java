package com.devsprintboot.gameslist.repositories;

import com.devsprintboot.gameslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
