package ru.deloom.jpaservice.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "persons")
public class Persons extends IEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4803092317061414070L;

	public Persons() {

	}

	public Persons(Integer id, String name) {
		super();
		this.name = name;
		this.id = id;
	}
	public Persons(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 2048, nullable = false)
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "persons", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Keywords> keywords = new HashSet<Keywords>();

	@JsonIgnore
	@OneToMany(mappedBy = "persons", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PersonPageRank> personPageRanks = new HashSet<PersonPageRank>();

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

	public Set<Keywords> getKeywords() {
		return keywords;
	}

	public void setKeywords(Set<Keywords> keywords) {
		this.keywords = keywords;
	}

	public Set<PersonPageRank> getPersonPageRanks() {
		return personPageRanks;
	}

	public void setPersonPageRanks(Set<PersonPageRank> personPageRanks) {
		this.personPageRanks = personPageRanks;
	}
}
