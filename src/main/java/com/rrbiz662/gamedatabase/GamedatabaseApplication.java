package com.rrbiz662.gamedatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import com.rrbiz662.gamedatabase.domain.Game;
import com.rrbiz662.gamedatabase.domain.GameRepository;
import com.rrbiz662.gamedatabase.domain.Owner;
import com.rrbiz662.gamedatabase.domain.OwnerRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.Arrays;

@SpringBootApplication
public class GamedatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(GamedatabaseApplication.class);
	private final GameRepository repository;
	private final OwnerRepository ownerRepository;
	
	public GamedatabaseApplication(GameRepository repository, OwnerRepository ownerRepository) {
		this.repository = repository;
		this.ownerRepository = ownerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(GamedatabaseApplication.class, args);
		logger.info("Application started...");
	}

	@Override
	public void run(String... args) throws Exception {
		// Add temp owners to Db
		Owner owner1 = new Owner("Test", "Owner1");
		Owner owner2 = new Owner("Test", "Owner2");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		
		// Add temp games to Db
		repository.save(new Game("Stellar Blade", "Shift Up", "1234SU", 2024, new BigDecimal(60), owner1));
		repository.save(new Game("Star Wars Outlaws", "Ubisoft", "1234UB", 2024, new BigDecimal(39.99), owner2));
		repository.save(new Game("Persona 3", "Atlus", "1234AT", 2024, new BigDecimal(35), owner1));
		repository.save(new Game("Assasin's Creed Mirage", "Ubisoft", "1235UB", 2023, new BigDecimal(20), owner2));

		// Read game data
		for (Game game : repository.findAll()) {
			logger.info("name: {}, publisher {}", game.getName(), game.getPublisher());
		}	
		
		for (Game game : repository.findByPublisherOrderByYearAsc("Ubisoft")) {
			logger.info("name: {}, publisher {}", game.getName(), game.getPublisher());
		}	
		
		for (Game game : repository.findCheapest()) {
			logger.info("name: {}, publisher {}", game.getName(), game.getPublisher());
		}	
		
	}

}
