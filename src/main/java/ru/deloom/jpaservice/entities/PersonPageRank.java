package ru.deloom.jpaservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
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

	public PersonPageRank(Integer personId, Integer pageId, Integer rank) {
		super();
		this.personId = personId;
		this.pageId = pageId;
		this.rank = rank;
	}

	public PersonPageRank() {

	}

	@Id
	private Integer personId;

	@Id
	private Integer pageId;

	@Column(name = "rank")
	private Integer rank;

	@ManyToOne
	@JoinColumn(name = "person_id", insertable = false, updatable = false)
	private Persons persons;

	@ManyToOne
	@JoinColumn(name = "page_id", insertable = false, updatable = false)
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

	public Integer getPersonId() {
		return personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
