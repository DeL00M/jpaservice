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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Pages")
public class Pages extends Model implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -495803062037317095L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "Url", nullable = false, unique = true)
	private String url;

	@Column(name = "FoundDateTime", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date foundDateTime;

	@Column(name = "LastScanDate", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastScanDate;

	@OneToMany(mappedBy = "pages", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PersonPageRank> personPageRanks = new HashSet<PersonPageRank>();
	
	@ManyToOne
	@JoinColumn(name = "siteId")
	private Sites sites;
	
	public Sites getSites() {
		return sites;
	}

	public void setSites(Sites sites) {
		this.sites = sites;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getFoundDateTime() {
		return foundDateTime;
	}

	public void setFoundDateTime(Date foundDateTime) {
		this.foundDateTime = foundDateTime;
	}

	public Date getLastScanDate() {
		return lastScanDate;
	}

	public void setLastScanDate(Date lastScanDate) {
		this.lastScanDate = lastScanDate;
	}

	public Set<PersonPageRank> getPersonPageRanks() {
		return personPageRanks;
	}

	public void setPersonPageRanks(Set<PersonPageRank> personPageRanks) {
		this.personPageRanks = personPageRanks;
	}
}
