package com.escuelasoaint.colegio.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import com.escuelasoaint.colegio.dto.EstudianteRequest;
import com.escuelasoaint.colegio.entities.Acudiente;
import com.escuelasoaint.colegio.entities.Estudiante;
import com.escuelasoaint.colegio.repository.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	public Estudiante crearEstudiante(EstudianteRequest payload) {
		Estudiante estudiante = new Estudiante();

		estudiante.setNombre(payload.getNombre());
		estudiante.setNumeroIdentificacion(payload.getNumeroIdentificacion());
		estudiante.setCorreoElectronico(payload.getCorreoElectronico());
		estudiante.setEdad(payload.getEdad());
		estudiante.setEstado(payload.getEstado());

		List<Acudiente> acudientes = payload.getAcudientes().stream()
				.map(acudiente -> Acudiente.builder().nombre(acudiente.getNombre())
						.parentesco(acudiente.getParentesco()).telefono(acudiente.getTelefono()).EstudianteR(estudiante)
						.build())
				.collect(Collectors.toList());
		estudiante.setAcudientes(acudientes);
		
			
			estudianteRepository.save(estudiante);

			return estudiante;
			
		
		
	
		
	}

	public List<Estudiante> listarEstudiantes() {
		List<Estudiante> listaEstudiante = estudianteRepository.findAll();
		return listaEstudiante;
	}

	public Estudiante buscarEstudiante(Long id) {
		Estudiante estudiante = estudianteRepository.findById(id).get();
		return estudiante;
	}

	public Estudiante actualizarEstudiante(Long id, EstudianteRequest payload) {
		Estudiante estudianteActualizado = buscarEstudiante(id);

		estudianteActualizado.setNombre(payload.getNombre());
		estudianteActualizado.setNumeroIdentificacion(payload.getNumeroIdentificacion());
		estudianteActualizado.setCorreoElectronico(payload.getCorreoElectronico());
		estudianteActualizado.setEdad(payload.getEdad());
		estudianteActualizado.setEstado(payload.getEstado());

		estudianteRepository.save(estudianteActualizado);

		return estudianteActualizado;
	}

	/*public boolean borrarEstudiante(Long id) {
		if (estudianteRepository.existsById(id)) {
			// estudianteRepository.deleteById(id);
			Estudiante estudianteInactivo = buscarEstudiante(id);
			estudianteInactivo.setEstado("INACTIVO");

			return true;
		}
		return false;*/
	public Estudiante borrarEstudiante(Long id) {
		
		Estudiante estudianteInactivo = buscarEstudiante(id);
		estudianteInactivo.setEstado("INACTIVO");
		return estudianteInactivo;
	}

	public List<Estudiante> consultarEdadEstado(Integer edad, String estado) {
		return estudianteRepository.findByEdadAndEstado(edad, estado);
	}

}
