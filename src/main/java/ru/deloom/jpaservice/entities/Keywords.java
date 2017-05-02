package ru.deloom.jpaservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Keywords")
public class Keywords implements Serializable{

	/**
	 * serialVersionUIDs.
	 */
	private static final long serialVersionUID = 5976628831754685397L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name", unique = true)
	private String name;
	
	@Column(name = "personId")
	private Long personId;
	
	@ManyToOne(
	        targetEntity = Persons.class
	    )
	    private Persons persons;

	public Long getKeywordId() {
		return id;
	}

	public void setKeywordId(Long keywordId) {
		this.id = keywordId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}
}
