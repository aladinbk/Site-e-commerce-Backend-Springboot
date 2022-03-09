package org.sid.lightecom.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name="produits")
public  class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    @Column
    private String description;
    private String marque;
    private double curentprix;
    private double commision ;
    private double newprix;
    private String photoName;
    private String photoName2;
    private String photoName3;
    private int quantity=1;

    @ManyToOne
    private Category category;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, String description, String marque, double curentprix, double commision,
			double newprix, String photoName, String photoName2, String photoName3, int quantity, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.marque = marque;
		this.curentprix = curentprix;
		this.commision = commision;
		this.newprix = newprix;
		this.photoName = photoName;
		this.photoName2 = photoName2;
		this.photoName3 = photoName3;
		this.quantity = quantity;
		this.category = category;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public double getCurentprix() {
		return curentprix;
	}

	public void setCurentprix(double curentprix) {
		this.curentprix = curentprix;
	}

	public double getCommision() {
		return commision;
	}

	public void setCommision(double commision) {
		this.commision = commision;
	}

	public double getNewprix() {
		return newprix;
	}

	public void setNewprix(double newprix) {
		this.newprix = newprix;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public String getPhotoName2() {
		return photoName2;
	}

	public void setPhotoName2(String photoName2) {
		this.photoName2 = photoName2;
	}

	public String getPhotoName3() {
		return photoName3;
	}

	public void setPhotoName3(String photoName3) {
		this.photoName3 = photoName3;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", marque=" + marque
				+ ", curentprix=" + curentprix + ", commision=" + commision + ", newprix=" + newprix + ", photoName="
				+ photoName + ", photoName2=" + photoName2 + ", photoName3=" + photoName3 + ", quantity=" + quantity
				+ ", category=" + category + "]";
	}

    
	
    
	
    
}
