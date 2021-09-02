package com.escuelasoaint.colegio.dto;

import javax.persistence.Column;

import lombok.Data;

@Data
public class EstudianteResponse {
	
	private Long id;
	private String nombre;
	private Long numeroIdentificacion;
	private String correoElectronico;
	private int edad;
	private String estado;

}
