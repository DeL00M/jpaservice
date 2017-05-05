package ru.deloom.jpaservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Keywords")
public class Keywords extends Model implements Serializable {

	/**
	 * serialVersionUIDs.
	 */
	private static final long serialVersionUID = 5976628831754685397L;
	
	public Keywords(String name) {
		super();
		this.name = name;
	}
	
	public Keywords(Integer id, String name) {
		super();
		this.name = name;
		this.id = id;
	}
	
	public Keywords() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 2048, nullable = false)
	private String name;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false)
	private Persons persons;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Persons getPersons() {
		return persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}
}
