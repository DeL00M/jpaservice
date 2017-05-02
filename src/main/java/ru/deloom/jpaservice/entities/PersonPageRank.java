package ru.deloom.jpaservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PersonPageRank")
public class PersonPageRank implements Serializable{
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8656878207442592762L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "personId")
	private Long personId;
	
	@Column(name = "pageId")
	private Long pageId;
	
	@Column(name = "rank")
	private Integer rank;

	public Long getPersonId() {
		return id;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public Long getPageId() {
		return pageId;
	}

	public void setPageId(Long pageID) {
		this.pageId = pageID;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}
}
