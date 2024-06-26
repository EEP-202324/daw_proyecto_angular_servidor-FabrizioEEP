package com.example.pabellon;

import java.sql.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Pabellon {

		
		@jakarta.persistence.Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
//		private @Id Long id;
	    private String nombre;
	    private String ubicacion;
	    private int aforo;
	    private FuncionalidadTipo funcionalidad;
	    private boolean disponibilidad;
	    private String photo;
	    private Date fechaDisponibilidad;

	    public Pabellon(Long id, String nombre, String ubicacion, int aforo, FuncionalidadTipo funcionalidad,
			boolean disponibilidad, String photo, Date fechaDisponibilidad) {
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.aforo = aforo;
		this.funcionalidad = funcionalidad;
		this.disponibilidad = disponibilidad;
		this.photo = photo;
		this.fechaDisponibilidad = fechaDisponibilidad;
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

		public FuncionalidadTipo getFuncionalidad() {
			return funcionalidad;
		}

		public void setFuncionalidad(FuncionalidadTipo funcionalidad) {
			this.funcionalidad = funcionalidad;
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

		public Date getFechaDisponibilidad() {
			return fechaDisponibilidad;
		}

		public void setFechaDisponibilidad(Date fechaDisponibilidad) {
			this.fechaDisponibilidad = fechaDisponibilidad;
		}
		

		@Override
	public String toString() {
		return "Pabellon [id=" + id + ", nombre=" + nombre + ", ubicacion=" + ubicacion + ", aforo=" + aforo
				+ ", funcionalidad=" + funcionalidad + ", disponibilidad=" + disponibilidad + ", photo=" + photo
				+ ", fechaDisponibilidad=" + fechaDisponibilidad + "]";
	}
}


/* package com.example.pabellon;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pabellon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Pabellon(Long id, String nombre, String ubicacion, int aforo, FuncionalidadTipo funcionalidad,
			boolean disponibilidad, String photo, Date date) {
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.aforo = aforo;
		this.funcionalidad = funcionalidad;
		this.disponibilidad = disponibilidad;
		this.photo = photo;
		this.fechaDisponibilidad = date;
	}

	private String nombre;
    private String ubicacion;
    private int aforo;
    private FuncionalidadTipo funcionalidad;
    private boolean disponibilidad;
    private String photo;
    private Date fechaDisponibilidad;

    public Pabellon() {
        // Constructor vacío requerido por JPA
    }

    // Getters y setters

    @Override
    public String toString() {
        return "Pabellon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", aforo=" + aforo +
                ", funcionalidad=" + funcionalidad +
                ", disponibilidad=" + disponibilidad +
                ", photo='" + photo + '\'' +
                ", fechaDisponibilidad=" + fechaDisponibilidad +
                '}';
    }
} */
