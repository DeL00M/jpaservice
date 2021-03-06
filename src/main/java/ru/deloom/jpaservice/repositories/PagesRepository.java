package ru.deloom.jpaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.deloom.jpaservice.entities.Pages;

public interface PagesRepository extends JpaRepository<Pages, Integer>{
	List<Pages> findByUrl(String url);
	List<Pages> findBySitesId(Integer id);
}
