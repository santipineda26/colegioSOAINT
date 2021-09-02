package com.escuelasoaint.colegio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.escuelasoaint.colegio.dto.EstudianteRequest;
import com.escuelasoaint.colegio.dto.EstudianteResponse;
import com.escuelasoaint.colegio.entities.Estudiante;
import com.escuelasoaint.colegio.service.EstudianteService;
import com.escuelasoaint.colegio.util.EntidadToConverter;

import io.swagger.annotations.ApiOperation;

@RestController
public class EstudianteController {
	
	@Autowired
	private EstudianteService estudianteService;
	@Autowired
	private EntidadToConverter convertidor;
	
	@PostMapping(value = "estudiante")
	public ResponseEntity<EstudianteResponse> crearEstudiante(@RequestBody EstudianteRequest payload) {
		if(payload.getEdad() < 18) {
			Estudiante estudiante = estudianteService.crearEstudiante(payload);
			return new ResponseEntity<>( convertidor.convertirEntidad(estudiante), HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping(value = "estudiante")
	@ApiOperation (value = "Listar estudiantes", notes = "lista todas los estudiantes almacenados")
	public ResponseEntity<List<EstudianteResponse>> listarEstudiantes() {
		List<Estudiante> listaEstudiantes = estudianteService.listarEstudiantes();
		return new ResponseEntity<>(convertidor.convertirEntidad(listaEstudiantes), HttpStatus.OK);
	}
	
	@PostMapping(value = "estudiante/{id}")
	public ResponseEntity<EstudianteResponse> buscarEstudiante(@PathVariable Long id) {
		Estudiante estudiante = estudianteService.buscarEstudiante(id);
		return new ResponseEntity<>(convertidor.convertirEntidad(estudiante), HttpStatus.OK);
	}
	
	@PutMapping(value = "estudiante/{id}")
	public ResponseEntity<EstudianteResponse> actualizarEstudiante(@PathVariable Long id, @RequestBody EstudianteRequest payload) {
		Estudiante estudiante = estudianteService.actualizarEstudiante(id, payload);
		return new ResponseEntity<>(convertidor.convertirEntidad(estudiante), HttpStatus.OK);
	}
	
	/*
	@DeleteMapping(value = "estudiante/{id}")
	public ResponseEntity<Boolean> borrarEstudiante(@PathVariable Long id) {
		boolean validacion = estudianteService.borrarEstudiante(id);
		if (validacion) {
			return new ResponseEntity<>(validacion, HttpStatus.OK);
		}
		return new ResponseEntity<>(validacion, HttpStatus.NOT_FOUND);
	}
	*/
	
	@DeleteMapping(value = "estudiante/{id}")
	public ResponseEntity<EstudianteResponse> borrarEstudiante(@PathVariable Long id) {
		Estudiante estudianteInactivo = estudianteService.borrarEstudiante(id);
		return new ResponseEntity<>(convertidor.convertirEntidad(estudianteInactivo), HttpStatus.OK);
		
	}
	

	@GetMapping(value="estudiantePorEdadEstado/{edad}/{estado}")
	public ResponseEntity<List<EstudianteResponse>> consultarEstudiantePorEdadEstado(@PathVariable Integer edad,@PathVariable String estado) {
		List<Estudiante> estudiante = estudianteService.consultarEdadEstado(edad, estado);
		return new ResponseEntity<>(convertidor.convertirEntidad(estudiante), HttpStatus.OK);
	}
	

}
