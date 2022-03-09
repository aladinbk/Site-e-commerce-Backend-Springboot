package org.sid.lightecom.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private String photoCat;
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private Collection<Product> produits;

	
	
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(Long id, String name, String description, String photoCat, Collection<Product> produits) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.photoCat = photoCat;
		this.produits = produits;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setId_c(Long id_c) {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoCat() {
		return photoCat;
	}
	public void setPhotoCat(String photoCat) {
		this.photoCat = photoCat;
	}
	public Collection<Product> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Product> produits) {
		this.produits = produits;
	}

	
	
}
