package com.example.pabellon;

import java.util.Objects;

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
	public int hashCode() {
		return Objects.hash(aforo, disponibilidad, id, nombre, photo, ubicacion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pabellon other = (Pabellon) obj;
		return aforo == other.aforo && disponibilidad == other.disponibilidad && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(photo, other.photo)
				&& Objects.equals(ubicacion, other.ubicacion);
	}
	
    @Override
	public String toString() {
		return "Pabellon [id=" + id + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", aforo=" + aforo
				+ ", disponibilidad=" + disponibilidad + ", photo=" + photo + "]";
	}
	
}
