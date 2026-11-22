package dws.ut5_reto.cvAPI.dtos.alumnos;

import dws.ut5_reto.cvAPI.entities.Conduccion;

public record AlumnoInfoResponseDto(Long idAlumno,
									String nombre,
									String apellido1,
									String apellido2,
									String emailPersonal,
									String telefonoPersonal,
									String direccion,
									String ciclo,
									String curso,
									Conduccion conduccion) {

}
