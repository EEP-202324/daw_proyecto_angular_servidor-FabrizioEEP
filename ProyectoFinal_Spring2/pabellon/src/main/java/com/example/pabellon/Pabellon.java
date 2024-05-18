package com.example.pabellon;

import java.sql.Date;

public class Pabellon {

	private Long id;
    private String nombre;
    private String ubicacion;
    private int aforo;
    private FuncionalidadTipo funcionalidad;
    private boolean disponibilidad;
    private String photo;
    private Date fechaDisponibilidad;
    
	public Pabellon(Long id, String nombre, String ubicacion, int aforo, FuncionalidadTipo funcionalidad,
			boolean disponibilidad, String photo, Date fechaDisponibilidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.aforo = aforo;
		this.funcionalidad = funcionalidad;
		this.disponibilidad = disponibilidad;
		this.photo = photo;
		this.fechaDisponibilidad = fechaDisponibilidad;
	}
}
