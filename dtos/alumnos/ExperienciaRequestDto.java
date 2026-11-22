package dws.ut5_reto.cvAPI.dtos.alumnos;

import java.time.LocalDate;

import dws.ut5_reto.cvAPI.entities.Alumno;

public record ExperienciaRequestDto(String nombreEmpresa,
									LocalDate fechaComienzo,
									LocalDate fechaFinalizacion,
									String puesto,
									String descripcion,
									Alumno alumno) {

}
