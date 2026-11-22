package dws.ut5_reto.cvAPI.dtos.alumnos;

import dws.ut5_reto.cvAPI.entities.Alumno;

public record AptitudResponseDto(Long idAptitudes,
								String nombre,
								String descripcion,
								Alumno alumno) {

}