package ru.deloom.jpaservice.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "sites")
public class Sites extends Model implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3800960441052181181L;

	public Sites(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Sites(String name) {
		super();
		this.name = name;
	}

	public Sites() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name", length = 256, nullable = false)
	private String name;

	@Column(name = "base_url", length = 2048)
	private String baseUrl;

	@Column(name = "open_tag", length = 512)
	private String openTag;

	@Column(name = "close_tag", length = 512)
	private String closeTag;

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	public String getOpenTag() {
		return openTag;
	}

	public void setOpenTag(String openTag) {
		this.openTag = openTag;
	}

	public String getCloseTag() {
		return closeTag;
	}

	public void setCloseTag(String closeTag) {
		this.closeTag = closeTag;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "sites", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pages> pages = new HashSet<Pages>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Pages> getPages() {
		return pages;
	}

	public void setPages(Set<Pages> pages) {
		this.pages = pages;
	}
}
