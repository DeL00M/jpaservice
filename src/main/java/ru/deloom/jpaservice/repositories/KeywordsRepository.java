package ru.deloom.jpaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.deloom.jpaservice.entities.Keywords;

public interface KeywordsRepository extends JpaRepository<Keywords, Long>{
	List<Keywords> findByName(String name);
}
