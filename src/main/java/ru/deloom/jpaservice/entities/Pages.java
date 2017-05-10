package ru.deloom.jpaservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "pages")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Pages extends IEntity implements Serializable {

	public Pages(String url, String text, Date modified) {
		super();
		// this.id = id;
		this.url = url;
		this.text = text;
		this.modified = modified;
	}

	public Pages() {

	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -495803062037317095L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "url", nullable = false, unique = true, length = 2048)
	private String url;

	@Lob
	@Column(name = "text")
	private String text;

	@Column(name = "modified", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@JsonIgnore
	@OneToMany(mappedBy = "pages")
	private Set<PersonPageRank> personPageRanks = new HashSet<PersonPageRank>();

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "site_id")
	private Sites sites;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Set<PersonPageRank> getPersonPageRanks() {
		return personPageRanks;
	}

	public void setPersonPageRanks(Set<PersonPageRank> personPageRanks) {
		this.personPageRanks = personPageRanks;
	}

	public Sites getSites() {
		return sites;
	}

	public void setSites(Sites sites) {
		this.sites = sites;
	}
}
