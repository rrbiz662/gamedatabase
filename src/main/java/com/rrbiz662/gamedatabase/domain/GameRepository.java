package com.rrbiz662.gamedatabase.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface GameRepository extends CrudRepository<Game, Long>{
	
	List<Game> findByPublisher(@Param("name") String name);
	List<Game> findByPublisherOrderByYearAsc(@Param("name") String name);
	@Query("select g from Game g where g.price < 40.00")
	List<Game> findCheapest();

}
