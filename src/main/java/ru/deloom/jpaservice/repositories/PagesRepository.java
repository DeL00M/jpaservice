package ru.deloom.jpaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.deloom.jpaservice.entities.Pages;

public interface PagesRepository extends JpaRepository<Pages, Long>{
	List<Pages> findByUrl(String url);
}
