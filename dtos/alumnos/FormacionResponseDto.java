package dws.ut5_reto.cvAPI.dtos.alumnos;

import java.time.LocalDate;

import dws.ut5_reto.cvAPI.entities.Alumno;

public record FormacionResponseDto(Long idFormacion,
								String nombreTitulacion,
								LocalDate fecha,
								String descripcion,
								Alumno alumno) {
}
