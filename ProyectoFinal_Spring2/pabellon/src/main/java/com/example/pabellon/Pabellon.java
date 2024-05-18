package com.example.pabellon;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pabellon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String nombre;
    private String ubicacion;
    private int aforo;

    private boolean disponibilidad;
    private String photo;
    
	public Pabellon(Long id, String nombre, String ubicacion, int aforo,
			boolean disponibilidad, String photo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.aforo = aforo;
		this.disponibilidad = disponibilidad;
		this.photo = photo;
	}
	
	public Pabellon() {
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getAforo() {
		return aforo;
	}

	public void setAforo(int aforo) {
		this.aforo = aforo;
	}

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
    @Override
	public String toString() {
		return "Pabellon [id=" + id + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", aforo=" + aforo
				+ ", disponibilidad=" + disponibilidad + ", photo=" + photo + "]";
	}
	
}
