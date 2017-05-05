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

import ru.deloom.jpaservice.entities.Keywords;
import ru.deloom.jpaservice.services.KeywordsService;

@RestController
@RequestMapping(value = "/keywords")
public class KeywordsController {
	
	/*@Autowired
	private KeywordsService keywordsService;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<Keywords>> getAll() {
		List<Keywords> keywordsList = keywordsService.getAll();
		return !keywordsList.isEmpty() ? new ResponseEntity<>(keywordsList, HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<Keywords>> getByName(@PathVariable("name") String name) {
		List<Keywords> keywordsList= keywordsService.getByName(name);
		return !keywordsList.isEmpty() ? new ResponseEntity<>(keywordsList, HttpStatus.OK)
				: new ResponseEntity<>(keywordsList, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<Keywords> getById(@PathVariable("id") Long id) {
		Keywords keywords = keywordsService.getById(id);
		return keywords != null ? new ResponseEntity<>(keywords, HttpStatus.OK)
				: new ResponseEntity<>(keywords, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/add/name/{name}", method = RequestMethod.POST)
	public HttpEntity<Boolean> add(@PathVariable("name") String name) {
		return keywordsService.add(name) ? new ResponseEntity<>(true, HttpStatus.CREATED)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/edit/id/{id}/{name}", method = RequestMethod.PATCH)
	public HttpEntity<Boolean> update(@PathVariable("id") Long id, @PathVariable("name") String name) {
		return keywordsService.edit(id, name) ? new ResponseEntity<>(true, HttpStatus.OK)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Boolean> delete(@PathVariable("id") Long id) {
		if (keywordsService.exist(id)) {
			keywordsService.delete(id);
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
*/
}
