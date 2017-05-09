package ru.deloom.jpaservice.services;

import java.util.List;

import ru.deloom.jpaservice.entities.IEntity;

public interface Service {
	Boolean add(String name);
	Boolean exist(Integer id);
	void delete(Integer id);
	Boolean edit(Integer id, String newname);
	List<? extends IEntity> getByName(String name);
	List<? extends IEntity> getAll();
	IEntity getById(Integer id);
}
