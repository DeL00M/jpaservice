package ru.deloom.jpaservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.deloom.jpaservice.entities.Keywords;
import ru.deloom.jpaservice.services.KeywordsService;
import ru.deloom.jpaservice.repositories.KeywordsRepository;

@Service
@Transactional
public class KeywordsServiceImpl implements KeywordsService{
	
	@Autowired
	private KeywordsRepository repository;

	@Override
	public Boolean add(String name) {
		Keywords keywords = new Keywords(name);
		return repository.saveAndFlush(keywords).equals(keywords);
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
	public Boolean edit(Integer id, String newname) {
		if (!repository.exists(id)) return false;
		return repository.saveAndFlush(new Keywords(id, newname)).getName().equals(newname);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Keywords> getByName(String name) {
		return repository.findByName(name);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Keywords> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Keywords getById(Integer id) {
		return repository.findOne(id);
	}

}
