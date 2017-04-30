package ru.deloom.jpaservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.deloom.jpaservice.entities.Persons;

public interface PersonsRepository extends JpaRepository<Persons, Integer>{
	List<Persons> findByName(String name);
}
