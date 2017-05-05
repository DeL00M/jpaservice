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
@Table(name = "Sites")
public class Sites extends Model implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3800960441052181181L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	public Sites(Long id, String name) {
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

	@Column(name = "Name")
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "sites", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pages> pages = new HashSet<Pages>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
