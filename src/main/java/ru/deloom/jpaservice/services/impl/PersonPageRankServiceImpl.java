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
		PersonPageRank savedEntity = repository.saveAndFlush(personPageRank);
		return (personPageRank.getPersonId() == savedEntity.getPersonId() &&
				personPageRank.getPageId() == savedEntity.getPageId());
	}

	@Override
	@Transactional
	public Boolean exist(Integer personId, Integer pageId) {
		return repository.exists(new PageRankId(personId, pageId));
	}

	@Override
	public void delete(Integer personId, Integer pageId) {
		repository.delete(new PageRankId(personId, pageId));
	}

	@Override
	public Boolean edit(Integer personId, Integer pageId, Integer rank) {
		if (!repository.exists(new PageRankId(personId, pageId))) return false;
		return repository.saveAndFlush(new PersonPageRank(personId, pageId, rank)).getRank() == rank;
	}

	@Override
	@Transactional
	public List<? extends IEntity> getAll() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public IEntity getById(Integer personId, Integer pageId) {
		return repository.getOne(new PageRankId(personId, pageId));
	}
	
	@Override
	@Transactional
	public List<? extends IEntity> getByPersonId(Integer personId) {
		return repository.findByPersonId(personId);
	}
	
}
