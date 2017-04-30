package ru.deloom.jpaservice.services;

import java.util.List;

import ru.deloom.jpaservice.entities.Persons;

public interface PersonsService {
	Persons addPerson(Persons person);
	void delete(Integer id);
	List<Persons> getByName(String name);
	Persons editPerson(Persons person);
	List<Persons> getAll();
}
