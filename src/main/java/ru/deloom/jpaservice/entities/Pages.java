package ru.deloom.jpaservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Pages")
public class Pages implements Serializable{
	
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
	
	@Column(name = "siteId")
	private Long siteId;
	
	@Column(name = "FoundDateTime", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date foundDateTime;
	
	@Column(name = "LastScanDate", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastScanDate;

	public Long getPageId() {
		return id;
	}

	public void setPageId(Long pageId) {
		this.id = pageId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteID(Long siteId) {
		this.siteId = siteId;
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
}
