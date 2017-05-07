package ru.deloom.jpaservice.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PageRankId implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -614211485698684185L;

	private Persons persons;

	private Pages pages;

	public PageRankId(Persons persons, Pages pages) {
		super();
		this.persons = persons;
		this.pages = pages;
	}

	public PageRankId() {
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

	@Override
	public boolean equals(Object arg0) {
		if (this == arg0) return true;
		if (!(arg0 instanceof PageRankId)) return false;
		PageRankId that = (PageRankId) arg0;
		return Objects.equals(getPersons().getId(), that.getPersons().getId()) &&
			Objects.equals(getPages().getId(), that.getPages().getId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPersons().getId(), getPages().getId());
	}
}
