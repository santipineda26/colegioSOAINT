package com.escuelasoaint.colegio.dto;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data

public class EstudianteRequest {
	
	@ApiModelProperty ( notes = "nombre del estudiante",example = "santiago" ,required = true)
	private String nombre;
	@ApiModelProperty ( notes = "numero de identificacion del estudiante",example = "1053820691" ,required = true)
	private Long numeroIdentificacion;
	@ApiModelProperty ( notes = "correo electronico del estudiante",example = "santiago@gmail.com")
	private String correoElectronico;
	@ApiModelProperty ( notes = "edad del estudiante",example = "15" ,required = true)
	private int edad;
	@ApiModelProperty ( notes = "estado del estudiante",example = "activo / inactivo" ,required = true)
	private String estado;
	
	private List<AcudienteEstudianteRequest> acudientes;

}
