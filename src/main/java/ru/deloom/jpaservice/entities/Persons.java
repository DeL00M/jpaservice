package ru.deloom.jpaservice.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Persons")
public class Persons implements Serializable{

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
	
	@JsonIgnore
    @OneToMany(
        targetEntity = Keywords.class,
        mappedBy = "person"
    )
    private Set<Keywords> keywords;
	
	@JsonIgnore
    @OneToMany(
        targetEntity = PersonPageRank.class,
        mappedBy = "personId"
    )
    private Set<PersonPageRank> personPageRanks;

	public Long getPersonId() {
		return id;
	}

	public void setPersonId(Long personId) {
		this.id = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
