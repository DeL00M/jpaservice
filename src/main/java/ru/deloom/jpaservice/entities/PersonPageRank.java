package ru.deloom.jpaservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person_page_rank")
@IdClass(PageRankId.class)
public class PersonPageRank extends IEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8656878207442592762L;

	public PersonPageRank( Integer personId, Integer pageId, Integer rank) {
		super();
		this.rank = rank;
		this.persons.setId(personId);
		this.pages.setId(pageId);
	}
	
	public PersonPageRank() {
		
	}
	
	@Column(name = "rank")
	private Integer rank;

	@Id
	@ManyToOne
	@JoinColumn(name = "person_id")
	private Persons persons;

	@Id
	@ManyToOne
	@JoinColumn(name = "page_id")
	private Pages pages;

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Persons getPersons() {
		return persons;
	}

	public void setPersons(Persons persons) {
		this.persons = persons;
	}

	public Pages getPages() {
		return pages;
	}

	public void setPages(Pages pages) {
		this.pages = pages;
	}
}
