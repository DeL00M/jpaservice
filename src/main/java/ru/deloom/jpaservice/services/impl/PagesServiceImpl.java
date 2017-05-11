package ru.deloom.jpaservice.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.deloom.jpaservice.entities.IEntity;
import ru.deloom.jpaservice.entities.Pages;
import ru.deloom.jpaservice.repositories.PagesRepository;
import ru.deloom.jpaservice.services.PagesService;

@Service
@Transactional
public class PagesServiceImpl implements PagesService{
	
	@Autowired
	private PagesRepository repository;

	@Override
	public Boolean add(String url, String text, Date modified) {
		Pages pages = new Pages(url, text, modified);
		return repository.saveAndFlush(pages).equals(pages);
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean exist(Integer id) {
		return repository.exists(id);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

	@Override
	public Boolean edit(Integer id, String url, String text, Date modified) {
		if (!repository.exists(id)) return false;
		Pages pages = new Pages(url, text, modified);
		return repository.saveAndFlush(pages).equals(pages);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pages> getByUrl(String url) {
		return repository.findByUrl(url);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Pages> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Pages getById(Integer id) {
		return repository.getOne(id);
	}

	@Override
	public List<? extends IEntity> getBySiteId(Integer id) {
		return repository.findBySitesId(id);
	}

}
