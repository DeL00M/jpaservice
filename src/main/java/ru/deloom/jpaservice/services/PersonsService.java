package ru.deloom.jpaservice.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ru.deloom.jpaservice.entities.Persons;

public interface PersonsService {
	Boolean addPerson(String name);
	void delete(Long id);
	List<Persons> getByName(String name);
	Boolean editPerson(Long id, String newname);
	List<Persons> getAll();
	Persons getById(Long id);
	Page<Persons> getAllByPage(Pageable pageable);
}
