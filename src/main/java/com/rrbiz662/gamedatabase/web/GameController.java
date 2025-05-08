package com.rrbiz662.gamedatabase.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrbiz662.gamedatabase.domain.Game;
import com.rrbiz662.gamedatabase.domain.GameRepository;

@RestController
public class GameController {
	
	private final GameRepository gameRepository;
	
	public GameController(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	
	@GetMapping("/games")
	public Iterable<Game> getGames(){
		return gameRepository.findAll();
	}
}
