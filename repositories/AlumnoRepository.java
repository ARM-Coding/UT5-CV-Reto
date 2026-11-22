package dws.ut5_reto.cvAPI.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dws.ut5_reto.cvAPI.entities.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
	
	// Métodos derivados para la info de Alumno
	
	boolean existsByEmailPersonal(String emailPersonal);
	boolean existsByTelefonoPersonal(String telefonoPersonal);
	
	Optional<Alumno> findByEmailPersonal(String emailPersonal);
	Optional<Alumno> findByTelefonoPersonal(String telefonoPersonal);
	
}
