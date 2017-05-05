package ru.deloom.jpaservice.services;

import java.util.List;

/*import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;*/

import ru.deloom.jpaservice.entities.Persons;

public interface PersonsService {
	Boolean add(String name);
	Boolean exist(Long id);
	void delete(Long id);
	Boolean edit(Long id, String newname);
	List<Persons> getByName(String name);
	List<Persons> getAll();
	Persons getById(Long id);
	//Page<Persons> getAllByPage(Pageable pageable);
}
