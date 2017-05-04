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
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<Persons>> getAllPersons() {
		List<Persons> personsList = personsService.getAll();
		return !personsList.isEmpty() ? new ResponseEntity<>(personsList, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<Persons>> getByName(@PathVariable("name") String name) {
		List<Persons> personsList = personsService.getByName(name);
		return !personsList.isEmpty() ? new ResponseEntity<>(personsList, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.POST)
	public ResponseEntity<Persons> add(@RequestBody Persons person) {
		return personsService.addPerson(person).equals(person) ? new ResponseEntity<>(person, HttpStatus.CREATED)
				: new ResponseEntity<>(person, HttpStatus.NOT_ACCEPTABLE);
	}

	/*
	 * @RequestMapping(value = "", method = RequestMethod.GET, produces =
	 * "application/json") HttpEntity<Page<Persons>> getAllPersons(Pageable
	 * pageable) { Page<Persons> personsPage =
	 * personsService.getAllByPage(pageable); return new
	 * ResponseEntity<>(personsPage, HttpStatus.OK); }
	 */
}
