package ru.deloom.jpaservice.services;

import java.util.List;

import ru.deloom.jpaservice.entities.IEntity;

public interface PersonPageRankService {
	Boolean add(Integer personId, Integer pageId, Integer rank);
	Boolean exist(Integer personId, Integer pageId);
	void delete(Integer personId, Integer pageId);
	Boolean edit(Integer personId, Integer pageId, Integer rank);
	List<? extends IEntity> getAll();
	IEntity getById(Integer personId, Integer pageId);
	List<? extends IEntity> getByPersonId(Integer personId);
}
