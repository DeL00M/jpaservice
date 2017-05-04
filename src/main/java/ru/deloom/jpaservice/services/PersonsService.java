package ru.deloom.jpaservice.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ru.deloom.jpaservice.entities.Persons;

public interface PersonsService {
	Boolean addPerson(String name);
	void delete(Long id);
	List<Persons> getByName(String name);
	Persons editPerson(Persons person);
	List<Persons> getAll();
	Page<Persons> getAllByPage(Pageable pageable);
}
