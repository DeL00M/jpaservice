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
	@Column(name = "ID")
	private Integer pageId;
	
	@Column(name = "Url")
	private String url;
	
	@Column(name = "SiteID")
	private Integer siteID;
	
	@Column(name = "FoundDateTime", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date foundDateTime;
	
	@Column(name = "LastScanDate", columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastScanDate;

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSiteID() {
		return siteID;
	}

	public void setSiteID(Integer siteID) {
		this.siteID = siteID;
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
