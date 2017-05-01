package ru.deloom.jpaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.deloom.jpaservice.entities.Sites;

public interface SitesRepository extends JpaRepository<Sites, Integer>{
	List<Sites> findByName(String name);
}
