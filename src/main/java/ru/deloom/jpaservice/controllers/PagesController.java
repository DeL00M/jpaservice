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
import ru.deloom.jpaservice.services.PagesService;

@RestController
@RequestMapping(value = "/pages")
public class PagesController {
	
	@Autowired
	private PagesService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<? extends IEntity>> getAll() {
		List<? extends IEntity> list = service.getAll();
		return !list.isEmpty() ? new ResponseEntity<>(list, HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<? extends IEntity> getById(@PathVariable("id") Integer id) {
		IEntity entity = service.getById(id);
		return entity != null ? new ResponseEntity<>(entity, HttpStatus.OK)
				: new ResponseEntity<>(entity, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/siteid/{id}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<? extends IEntity>> getBySiteId(@PathVariable("id") Integer id) {
		List<? extends IEntity> list = service.getBySiteId(id);
		return list != null ? new ResponseEntity<>(list, HttpStatus.OK)
				: new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/url/{url}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<? extends IEntity>> getByUrl(@PathVariable("url") String url) {
		List<? extends IEntity> list = service.getByUrl(url);
		return list != null ? new ResponseEntity<>(list, HttpStatus.OK)
				: new ResponseEntity<>(list, HttpStatus.NOT_FOUND);
	}
}
