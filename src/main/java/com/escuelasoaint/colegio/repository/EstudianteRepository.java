package com.escuelasoaint.colegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escuelasoaint.colegio.entities.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long>{
	
	public List<Estudiante> findByEdadAndEstado(Integer edad,String estado);
	

}
