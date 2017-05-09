package ru.deloom.jpaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ru.deloom.jpaservice.entities.IEntity;
import ru.deloom.jpaservice.services.PagesService;

@RestController
@RequestMapping(value = "/pages")
public class PagesController {
	
	@Autowired
	private PagesService service;
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<? extends IEntity> getById(@PathVariable("id") Integer id) {
		IEntity entity = service.getById(id);
		return entity != null ? new ResponseEntity<>(entity, HttpStatus.OK)
				: new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
	}
}
