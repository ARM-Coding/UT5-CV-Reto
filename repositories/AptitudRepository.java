package dws.ut5_reto.cvAPI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dws.ut5_reto.cvAPI.entities.Alumno;
import dws.ut5_reto.cvAPI.entities.Aptitud;

@Repository
public interface AptitudRepository extends JpaRepository<Aptitud, Long> {
	
	// Métodos derivados para la info de Aptitud
	
	boolean existsByNombre(String nombre);
	boolean existsByAlumno(Alumno alumno);
	
	List<Aptitud> findByNombre(String nombre);
	List<Aptitud> findByAlumno(Alumno alumno);
	
}