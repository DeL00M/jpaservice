package ru.deloom.jpaservice.services;

import java.util.List;

import ru.deloom.jpaservice.entities.Sites;

public interface SitesService {
	Boolean add(String name);
	Boolean exist(Long id);
	void delete(Long id);
	Boolean edit(Long id, String newname);
	List<Sites> getByName(String name);
	List<Sites> getAll();
	Sites getById(Long id);
}
