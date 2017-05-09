package ru.deloom.jpaservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import ru.deloom.jpaservice.repositories.PagesRepository;
import ru.deloom.jpaservice.services.impl.PersonsServiceImpl;

@Entity
@Table(name = "person_page_rank")
public class PersonPageRank extends IEntity implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8656878207442592762L;
	
	@Autowired
	private PagesRepository repository;

	public PersonPageRank(Integer personId, Integer pageId, Integer rank) {
		super();
		pages = (Pages) repository.getOne(pageId);
		persons = new PersonsServiceImpl().getById(personId);
		this.rank = rank;
		this.pageRankId = new PageRankId(personId, pageId);
	}
	
	public PersonPageRank() {
		
	}
	
	@Column(name = "rank")
	private Integer rank;
	
	@EmbeddedId
	private PageRankId pageRankId;

	@ManyToOne
	@MapsId("personId")
	@JoinColumn(name = "person_id")
	private Persons persons;
	
	@ManyToOne
	@MapsId("pageId")
	@JoinColumn(name = "page_id")
	private Pages pages;

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public PageRankId getPageRankId() {
		return pageRankId;
	}

	public void setPageRankId(PageRankId pageRankId) {
		this.pageRankId = pageRankId;
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
