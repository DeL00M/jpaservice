package ru.deloom.jpaservice.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PageRankId implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -614211485698684185L;
	
	@Column(name = "person_id")
	private Integer personId;
	
	@Column(name = "page_id")
	private Integer pageId;

	public PageRankId(Integer personId, Integer pageId) {
		super();
		this.personId = personId;
		this.pageId = pageId;
	}
	
	public PageRankId() {
		
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
	
	@Override
	public boolean equals(Object arg0) {
		if (this == arg0) return true;
		if (!(arg0 instanceof PageRankId)) return false;
		PageRankId that = (PageRankId) arg0;
		return Objects.equals(getPersonId(), that.getPersonId()) &&
			Objects.equals(getPageId(), that.getPageId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getPersonId(), getPageId());
	}
}
