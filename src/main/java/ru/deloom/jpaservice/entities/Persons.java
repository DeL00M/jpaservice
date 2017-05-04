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

@Entity
@Table(name = "Persons")
public class Persons implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4803092317061414070L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, unique = true)
	private String name;

	@OneToMany(mappedBy = "persons", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Keywords> keywords = new HashSet<Keywords>();

	@OneToMany(mappedBy = "persons", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PersonPageRank> personPageRanks = new HashSet<PersonPageRank>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
