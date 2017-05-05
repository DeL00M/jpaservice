package ru.deloom.jpaservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.deloom.jpaservice.services.KeywordsService;

@RestController
@RequestMapping(value = "/keywords")
public class KeywordsController extends Controller {

	@Autowired
	public KeywordsController(KeywordsService service) {
		super(service);
	}
}
