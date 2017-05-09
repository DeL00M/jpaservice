package ru.deloom.jpaservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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

	@Column(name = "rank")
	private Integer rank;

	@Id
	@Column(name = "person_id", insertable = false, updatable = false)
	private Integer personId;

	@Id
	@Column(name = "page_id", insertable = false, updatable = false)
	private Integer pageId;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Persons persons;

	@ManyToOne
	@JoinColumn(name = "page_id")
	private Pages pages;

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
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
