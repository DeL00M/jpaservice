package ru.deloom.jpaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.deloom.jpaservice.converters.JsonConverter;
import ru.deloom.jpaservice.services.PersonsService;

@RestController
public class PersonsController {

	@Autowired
	private PersonsService personsService;

	@Autowired
	private JsonConverter jsonConverter;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public String getAllPersons() {
		return jsonConverter.toJson(personsService.getAll());
	}

	@RequestMapping(value = "/{name}", method = RequestMethod.GET, produces = "application/json")
	public String getByName(@PathVariable("name") String name) {
		return jsonConverter.toJson(personsService.getByName(name));
	}
}
