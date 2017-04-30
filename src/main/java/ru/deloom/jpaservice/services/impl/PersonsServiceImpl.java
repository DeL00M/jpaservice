package ru.deloom.jpaservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.deloom.jpaservice.entities.Persons;
import ru.deloom.jpaservice.repositories.PersonsRepository;
import ru.deloom.jpaservice.services.PersonsService;

@Service
public class PersonsServiceImpl implements PersonsService {

	@Autowired
	private PersonsRepository personsRepository;

	public Persons addPerson(Persons person) {
		return personsRepository.saveAndFlush(person);
	}

	public void delete(Integer id) {
		personsRepository.delete(id);
	}

	@Transactional(readOnly = true)
	public List<Persons> getByName(String name) {
		return personsRepository.findByName(name);
	}

	public Persons editPerson(Persons person) {
		return personsRepository.saveAndFlush(person);
	}

	@Transactional(readOnly = true)
	public List<Persons> getAll() {
		return personsRepository.findAll();
	}
}
