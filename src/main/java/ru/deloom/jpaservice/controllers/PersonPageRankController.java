package ru.deloom.jpaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.deloom.jpaservice.services.PersonPageRankService;

@RestController
@RequestMapping(value = "/rank")
public class PersonPageRankController {
	
	@Autowired
	private PersonPageRankService service;
	
	@RequestMapping(value = "/add/personid/{personid}/pageid/{pageid}/rank/{rank}", method = RequestMethod.POST)
	public HttpEntity<Boolean> add(
			@PathVariable("personid") Integer personId, 
			@PathVariable("pageid") Integer pageId, 
			@PathVariable("rank") Integer rank) {
		return service.add(personId, pageId, rank) ? new ResponseEntity<>(true, HttpStatus.CREATED)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
}
