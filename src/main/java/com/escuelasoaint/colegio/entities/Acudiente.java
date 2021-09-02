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
import javax.persistence.ManyToOne;
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
@Builder
@Entity
@Table(name = "tbl_acudiente")

public class Acudiente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre_acudiente",length = 50)
	private String nombre;
	@Column(name = "parentesco_acudiente",length = 50)
	private String parentesco;
	@Column(name = "telefono_acudiente",length = 50)
	private String telefono;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Estudiante EstudianteR;

}
