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

@Entity
@Table(name = "Sites")
public class Sites implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3800960441052181181L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "Name")
	private String name;
	
	@OneToMany(mappedBy = "sites", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pages> Pages = new HashSet<Pages>();
	
	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Pages> getPages() {
		return Pages;
	}

	public void setPages(Set<Pages> pages) {
		Pages = pages;
	}
}
