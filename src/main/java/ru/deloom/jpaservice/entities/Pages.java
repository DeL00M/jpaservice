package ru.deloom.jpaservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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

@Entity
@Table(name = "pages")
public class Pages extends Model implements Serializable {

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

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "modified", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modified;

	@OneToMany(mappedBy = "pages", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PersonPageRank> personPageRanks = new HashSet<PersonPageRank>();

	@ManyToOne
	@JoinColumn(name = "site_id")
	private Sites sites;

	public Sites getSites() {
		return sites;
	}

	public void setSites(Sites sites) {
		this.sites = sites;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

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

	public Set<PersonPageRank> getPersonPageRanks() {
		return personPageRanks;
	}

	public void setPersonPageRanks(Set<PersonPageRank> personPageRanks) {
		this.personPageRanks = personPageRanks;
	}
}
