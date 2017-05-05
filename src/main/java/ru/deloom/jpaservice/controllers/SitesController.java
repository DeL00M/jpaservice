package ru.deloom.jpaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.deloom.jpaservice.services.SitesService;

@RestController
@RequestMapping(value = "/sites")
public class SitesController extends Controller {

	@Autowired
	public SitesController(SitesService service) {
		super(service);
	}
}
