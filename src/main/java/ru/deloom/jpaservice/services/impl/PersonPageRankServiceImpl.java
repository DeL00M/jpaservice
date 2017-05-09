package ru.deloom.jpaservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.deloom.jpaservice.entities.IEntity;
import ru.deloom.jpaservice.entities.PageRankId;
import ru.deloom.jpaservice.entities.PersonPageRank;
import ru.deloom.jpaservice.repositories.PersonPageRankRepository;
import ru.deloom.jpaservice.services.PersonPageRankService;

@Service
@Transactional
public class PersonPageRankServiceImpl implements PersonPageRankService{

	@Autowired
	private PersonPageRankRepository repository;

	@Override
	public Boolean add(Integer personId, Integer pageId, Integer rank) {
		PersonPageRank personPageRank = new PersonPageRank(personId, pageId, rank);
		return repository.saveAndFlush(personPageRank).equals(personPageRank);
	}

	@Override
	@Transactional
	public Boolean exist(Integer personId, Integer pageId) {
		return null;
	}

	@Override
	public void delete(Integer personId, Integer pageId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Boolean edit(Integer personId, Integer pageId, Integer rank) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<? extends IEntity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public IEntity getById(Integer personId, Integer pageId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
