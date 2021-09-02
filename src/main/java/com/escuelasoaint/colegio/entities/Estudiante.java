package com.escuelasoaint.colegio.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_estudiante")

public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_estudiante",length = 50)
	private String nombre;
	@Column(name = "numero_identificacion_estudiante")
	private Long numeroIdentificacion;
	@Column(name = "correo_electronico_estudiante",length = 20)
	private String correoElectronico;
	@Column(name = "edad_estudiante")
	private int edad;
	@Column(name = "estado_estudiante",length = 10)
	private String estado;
	
	@OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "EstudianteR") 
	private List<Acudiente> acudientes;

}
