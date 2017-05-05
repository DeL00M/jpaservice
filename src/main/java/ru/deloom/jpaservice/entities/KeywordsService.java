package ru.deloom.jpaservice.entities;

import java.util.List;

public interface KeywordsService {
	Boolean add(String name);
	Boolean exist(Long id);
	void delete(Long id);
	Boolean edit(Long id, String newname);
	List<Keywords> getByName(String name);
	List<Keywords> getAll();
	Keywords getById(Long id);
}
