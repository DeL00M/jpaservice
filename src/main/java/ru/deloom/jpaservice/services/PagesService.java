package ru.deloom.jpaservice.services;

import java.util.Date;
import java.util.List;

import ru.deloom.jpaservice.entities.IEntity;

public interface PagesService{
	Boolean add(String url, String text, Date modified);
	Boolean exist(Integer id);
	void delete(Integer id);
	Boolean edit(Integer id, String url, String text, Date modified);
	List<? extends IEntity> getByUrl(String url);
	List<? extends IEntity> getAll();
	IEntity getById(Integer id);
	List<? extends IEntity> getBySiteId(Integer id);
}
