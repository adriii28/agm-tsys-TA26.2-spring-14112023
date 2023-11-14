package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cientificos")
public class Cientifico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_cientifico;
	
	private String dni;	
	private String nom_apels;
	
	@OneToMany
    @JoinColumn(name="id_cientifico")
	private List<Asignado> asignado;
	
	public Cientifico() {
	
	}

	public Cientifico(int id_cientifico, String dni, String nom_apels, List<Asignado> asignado) {
		this.id_cientifico = id_cientifico;
		this.dni = dni;
		this.nom_apels = nom_apels;
		this.asignado = asignado;
	}

	public int getId_cientifico() {
		return id_cientifico;
	}

	public void setId_cientifico(int id_cientifico) {
		this.id_cientifico = id_cientifico;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom_apels() {
		return nom_apels;
	}

	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado")
	public List<Asignado> getAsignado() {
		return asignado;
	}

	public void setAsignado(List<Asignado> asignado) {
		this.asignado = asignado;
	}

	
}
