package com.devsprintboot.gameslist.repositories;

import com.devsprintboot.gameslist.entities.Games;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GameRepository extends JpaRepository<Games, Long> {
}
