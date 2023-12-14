package com.example.projetPI.agenceDeVoyage.Models;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class destination {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DESTINATION_ID")
	private Long id ;
	@Column(name="nom")
	private String name;
	private String pays;
	
	@Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;
	
	
	
	public destination() {
		
	}

	
	

	public destination(Long id, String name, String pays, byte[] image) {
		this.id = id;
		this.name = name;
		this.pays = pays;
		this.image = image;
	}




	public destination( String name, String pays, byte[] image) {
		this.name = name;
		this.pays = pays;
		this.image = image;
	}
	
	



	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "destination [id=" + id + ", name=" + name + ", pays=" + pays + ", image=" + Arrays.toString(image)
				+ "]";
	}


	
	
	
	
}
