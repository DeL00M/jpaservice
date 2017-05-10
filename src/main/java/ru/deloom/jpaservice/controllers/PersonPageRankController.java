package ru.deloom.jpaservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.deloom.jpaservice.entities.IEntity;
import ru.deloom.jpaservice.services.PersonPageRankService;

@RestController
@RequestMapping(value = "/rank")
public class PersonPageRankController {

	@Autowired
	private PersonPageRankService service;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<? extends IEntity>> getAll() {
		List<? extends IEntity> list = service.getAll();
		return !list.isEmpty() ? new ResponseEntity<>(list, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@RequestMapping(value = "/personid/{personid}/pageid/{pageid}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<? extends IEntity> getById(
			@PathVariable("personid") Integer personId,
			@PathVariable("pageid") Integer pageId) {
		IEntity entity = service.getById(personId, pageId);
		return entity != null ? new ResponseEntity<>(entity, HttpStatus.OK)
				: new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/personid/{personid}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<? extends IEntity>> getByPersonId(
			@PathVariable("personid") Integer personId) {
		List<? extends IEntity> list = service.getByPersonId(personId);
		return !list.isEmpty() ? new ResponseEntity<>(list, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/pageid/{pageid}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<? extends IEntity>> getByPageId(
			@PathVariable("pageid") Integer pageId) {
		List<? extends IEntity> list = service.getByPageId(pageId);
		return !list.isEmpty() ? new ResponseEntity<>(list, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/add/personid/{personid}/pageid/{pageid}/rank/{rank}", method = RequestMethod.POST)
	public HttpEntity<Boolean> add(
			@PathVariable("personid") Integer personId, 
			@PathVariable("pageid") Integer pageId,
			@PathVariable("rank") Integer rank) {
		return service.add(personId, pageId, rank) ? new ResponseEntity<>(true, HttpStatus.CREATED)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/edit/personid/{personid}/pageid/{pageid}/rank/{rank}", method = RequestMethod.PATCH)
	public HttpEntity<Boolean> update(
			@PathVariable("personid") Integer personId, 
			@PathVariable("pageid") Integer pageId,
			@PathVariable("rank") Integer rank) {
		return service.edit(personId, pageId, rank) ? new ResponseEntity<>(true, HttpStatus.CREATED)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/delete/personid/{personid}/pageid/{pageid}", method = RequestMethod.DELETE)
	public HttpEntity<Boolean> delete(
			@PathVariable("personid") Integer personId, 
			@PathVariable("pageid") Integer pageId) {
		if (service.exist(personId, pageId)) {
			service.delete(personId, pageId);
			return new ResponseEntity<>(true, HttpStatus.OK);
			}
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
}
