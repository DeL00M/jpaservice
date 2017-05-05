package ru.deloom.jpaservice.services;

import java.util.List;

import ru.deloom.jpaservice.entities.Model;

public interface Service {
	Boolean add(String name);
	Boolean exist(Integer id);
	void delete(Integer id);
	Boolean edit(Integer id, String newname);
	List<? extends Model> getByName(String name);
	List<? extends Model> getAll();
	Model getById(Integer id);
}
