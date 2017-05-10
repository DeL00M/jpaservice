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
	
	@RequestMapping(value = "/add/personid/{personid}/pageid/{pageid}/rank/{rank}", method = RequestMethod.POST)
	public HttpEntity<Boolean> add(
			@PathVariable("personid") Integer personId, 
			@PathVariable("pageid") Integer pageId, 
			@PathVariable("rank") Integer rank) {
		return service.add(personId, pageId, rank) ? new ResponseEntity<>(true, HttpStatus.CREATED)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
}
