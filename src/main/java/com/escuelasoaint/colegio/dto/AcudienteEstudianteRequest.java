package com.escuelasoaint.colegio.dto;

import javax.persistence.Column;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ApiModel (description = "Representa los acudientes de un estudiante") 
public class AcudienteEstudianteRequest {
	
	@ApiModelProperty ( notes = "nombre del acudiente",example = "carlos" ,required = true)
	private String nombre;
	@ApiModelProperty ( notes = "parentesco del acudiente",example = "padre" ,required = true)
	private String parentesco;
	@ApiModelProperty ( notes = "telefono del acudiente",example = "888888" ,required = true)
	private String telefono;

}
