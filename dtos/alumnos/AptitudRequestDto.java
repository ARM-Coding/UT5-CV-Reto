package dws.ut5_reto.cvAPI.dtos.alumnos;

import dws.ut5_reto.cvAPI.entities.Alumno;

public record AptitudRequestDto(String nombre,
								String descripcion,
								Alumno alumno) {

}
