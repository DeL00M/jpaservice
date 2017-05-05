package ru.deloom.jpaservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.deloom.jpaservice.entities.Persons;
import ru.deloom.jpaservice.services.PersonsService;

@RestController
@RequestMapping(value = "/persons")
public class PersonsController {

	@Autowired
	private PersonsService personsService;

	/**
	 * GET %APP%/persons
	 * @return List<Persons>
	 * all content from table "persons" in json format
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<Persons>> getAllPersons() {
		List<Persons> personsList = personsService.getAll();
		return !personsList.isEmpty() ? new ResponseEntity<>(personsList, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * GET %APP%/persons/name/{name}
	 * @param name
	 * @return List<Persons>
	 * content from table persons where column name = @param {name}
	 */
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<Persons>> getByName(@PathVariable("name") String name) {
		List<Persons> personsList = personsService.getByName(name);
		return !personsList.isEmpty() ? new ResponseEntity<>(personsList, HttpStatus.OK)
				: new ResponseEntity<>(personsList, HttpStatus.NOT_FOUND);
	}

	/**
	 * GET %APP%/persons/id/{id}
	 * @param id
	 * @return Persons
	 * content from table persons where column id = @param {id}
	 */
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<Persons> getById(@PathVariable("id") Long id) {
		Persons persons = personsService.getById(id);
		return persons != null ? new ResponseEntity<>(persons, HttpStatus.OK)
				: new ResponseEntity<>(persons, HttpStatus.NOT_FOUND);
	}

	/**
	 * POST %APP%/persons/add/{name}
	 * @param name
	 * @return Boolean
	 * add new person in table "persons" with name = @param {name}
	 */
	@RequestMapping(value = "/add/{name}", method = RequestMethod.POST)
	public HttpEntity<Boolean> add(@PathVariable("name") String name) {
		return personsService.addPerson(name) ? new ResponseEntity<>(true, HttpStatus.CREATED)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

	/**
	 * PATCH %APP%/persons/id/{id}/{name}
	 * @param id
	 * @param name
	 * @return Boolean
	 * edit person in table "persons" with id = {id}, set name to {name}
	 */
	@RequestMapping(value = "/edit/id/{id}/{name}", method = RequestMethod.PATCH)
	public HttpEntity<Boolean> update(@PathVariable("id") Long id, @PathVariable("name") String name) {
		return personsService.editPerson(id, name) ? new ResponseEntity<>(true, HttpStatus.OK)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

	/*
	 * @RequestMapping(value = "", method = RequestMethod.GET, produces =
	 * "application/json") HttpEntity<Page<Persons>> getAllPersons(Pageable
	 * pageable) { Page<Persons> personsPage =
	 * personsService.getAllByPage(pageable); return new
	 * ResponseEntity<>(personsPage, HttpStatus.OK); }
	 */
}
