package ru.deloom.jpaservice.controllers;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.deloom.jpaservice.entities.Model;
import ru.deloom.jpaservice.services.Service;

public class Controller {

	public Service service;

	public Controller(Service service) {
		super();
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public HttpEntity<List<? extends Model>> getAll() {
		List<? extends Model> list = service.getAll();
		return !list.isEmpty() ? new ResponseEntity<>(list, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
