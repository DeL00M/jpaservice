package ru.deloom.jpaservice.services;

import java.util.List;

import ru.deloom.jpaservice.entities.Model;

public interface Service {
	Boolean add(String name);
	Boolean exist(Long id);
	void delete(Long id);
	Boolean edit(Long id, String newname);
	List<? extends Model> getByName(String name);
	List<? extends Model> getAll();
	Model getById(Long id);
}
