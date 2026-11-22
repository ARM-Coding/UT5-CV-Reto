package dws.ut5_reto.cvAPI.dtos.alumnos;

import java.time.LocalDate;

import dws.ut5_reto.cvAPI.entities.Alumno;

public record FormacionRequestDto(String nombreTitulacion,
								LocalDate fecha,
								String descripcion,
								Alumno alumno) {
}
