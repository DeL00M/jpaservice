package ru.deloom.jpaservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.deloom.jpaservice.entities.Sites;
import ru.deloom.jpaservice.repositories.SitesRepository;
import ru.deloom.jpaservice.services.SitesService;

@Service
@Transactional
public class SitesServiceImpl implements SitesService{
	
	@Autowired
	private SitesRepository sitesRepository;

	@Override
	public Boolean add(String name) {
		Sites sites = new Sites(name);
		return sitesRepository.saveAndFlush(sites).equals(sites);
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean exist(Long id) {
		return sitesRepository.exists(id);
	}

	@Override
	public void delete(Long id) {
		sitesRepository.delete(id);
	}

	@Override
	public Boolean edit(Long id, String newname) {
		if (!sitesRepository.exists(id)) return false;
		return sitesRepository.saveAndFlush(new Sites(id, newname)).getName().equals(newname);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sites> getByName(String name) {
		return sitesRepository.findByName(name);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sites> getAll() {
		return sitesRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Sites getById(Long id) {
		return sitesRepository.findOne(id);
	}

}
