package ru.deloom.jpaservice.services;

import java.util.List;

import ru.deloom.jpaservice.entities.Keywords;

public interface KeywordsService {
	Boolean add(String name);
	Boolean exist(Long id);
	void delete(Long id);
	Boolean edit(Long id, String newname);
	List<Keywords> getByName(String name);
	List<Keywords> getAll();
	Keywords getById(Long id);
}
