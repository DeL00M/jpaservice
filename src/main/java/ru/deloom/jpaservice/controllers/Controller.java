package ru.deloom.jpaservice.controllers;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.deloom.jpaservice.entities.IEntity;
import ru.deloom.jpaservice.entities.PersonPageRank;
import ru.deloom.jpaservice.services.Service;

public class Controller {

	public Service service;

	public Controller(Service service) {
		super();
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<? extends IEntity>> getAll() {
		List<? extends IEntity> list = service.getAll();
		return !list.isEmpty() ? new ResponseEntity<>(list, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<? extends IEntity>> getByName(@PathVariable("name") String name) {
		List<? extends IEntity> list = service.getByName(name);
		return !list.isEmpty() ? new ResponseEntity<>(list, HttpStatus.OK)
				: new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<? extends IEntity> getById(@PathVariable("id") Integer id) {
		IEntity entity = service.getById(id);
		return entity != null ? new ResponseEntity<>(entity, HttpStatus.OK)
				: new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/add/name/{name}", method = RequestMethod.POST)
	public HttpEntity<Boolean> add(@PathVariable("name") String name) {
		return service.add(name) ? new ResponseEntity<>(true, HttpStatus.CREATED)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/edit/id/{id}/{name}", method = RequestMethod.PATCH)
	public HttpEntity<Boolean> update(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		return service.edit(id, name) ? new ResponseEntity<>(true, HttpStatus.OK)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Boolean> delete(@PathVariable("id") Integer id) {
		if (service.exist(id)) {
			service.delete(id);
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
}
