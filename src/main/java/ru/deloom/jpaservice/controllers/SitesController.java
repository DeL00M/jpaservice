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

import ru.deloom.jpaservice.entities.Model;
import ru.deloom.jpaservice.entities.Sites;
import ru.deloom.jpaservice.services.Service;
import ru.deloom.jpaservice.services.SitesService;
import ru.deloom.jpaservice.services.impl.SitesServiceImpl;

@RestController
@RequestMapping(value = "/sites")
public class SitesController extends Controller {

	@Autowired
	public SitesController(SitesService service) {
		super(service);
	}
	


	/*@RequestMapping(value = "/name/{name}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<Sites>> getByName(@PathVariable("name") String name) {
		List<Sites> sitesList= sitesService.getByName(name);
		return !sitesList.isEmpty() ? new ResponseEntity<>(sitesList, HttpStatus.OK)
				: new ResponseEntity<>(sitesList, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<Sites> getById(@PathVariable("id") Long id) {
		Sites sites = sitesService.getById(id);
		return sites != null ? new ResponseEntity<>(sites, HttpStatus.OK)
				: new ResponseEntity<>(sites, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/add/name/{name}", method = RequestMethod.POST)
	public HttpEntity<Boolean> add(@PathVariable("name") String name) {
		return sitesService.add(name) ? new ResponseEntity<>(true, HttpStatus.CREATED)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/edit/id/{id}/{name}", method = RequestMethod.PATCH)
	public HttpEntity<Boolean> update(@PathVariable("id") Long id, @PathVariable("name") String name) {
		return sitesService.edit(id, name) ? new ResponseEntity<>(true, HttpStatus.OK)
				: new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/delete/id/{id}", method = RequestMethod.DELETE)
	public HttpEntity<Boolean> delete(@PathVariable("id") Long id) {
		if (sitesService.exist(id)) {
			sitesService.delete(id);
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}*/
}
