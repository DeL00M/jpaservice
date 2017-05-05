package ru.deloom.jpaservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.deloom.jpaservice.entities.PersonPageRank;

public interface PersonPageRankRepository extends JpaRepository<PersonPageRank, Integer>{
	
}
