package ru.deloom.jpaservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;*/
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.deloom.jpaservice.entities.Persons;
import ru.deloom.jpaservice.repositories.PersonsRepository;
import ru.deloom.jpaservice.services.PersonsService;

@Service
@Transactional
public class PersonsServiceImpl implements PersonsService {

	@Autowired
	private PersonsRepository personsRepository;

	@Override
	public Boolean add(String name) {
		Persons person = new Persons(name);
		return personsRepository.saveAndFlush(person).equals(person);
	}

	@Override
	public void delete(Long id) {
		personsRepository.delete(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persons> getByName(String name) {
		return personsRepository.findByName(name);
	}

	@Override
	public Boolean edit(Long id, String newname) {
		if (!personsRepository.exists(id)) return false;
		return personsRepository.saveAndFlush(new Persons(id, newname)).getName().equals(newname);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Persons> getAll() {
		return personsRepository.findAll();
	}

	/*@Override
	public Page<Persons> getAllByPage(Pageable pageable) {
		return personsRepository.findAll(pageable);
	}*/

	@Override
	@Transactional(readOnly = true)
	public Persons getById(Long id) {
		return personsRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Boolean exist(Long id) {
		return personsRepository.exists(id);
	}
}
