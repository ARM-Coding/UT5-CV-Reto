package dws.ut5_reto.cvAPI.dtos.alumnos;

import java.util.List;

import dws.ut5_reto.cvAPI.entities.Alumno;
import dws.ut5_reto.cvAPI.entities.Aptitud;
import dws.ut5_reto.cvAPI.entities.Experiencia;
import dws.ut5_reto.cvAPI.entities.Formacion;

public record CVCompletoResponseDto(AlumnoInfoResponseDto alumno,
									List<ExperienciaResponseDto> Experiencia,
									List<FormacionResponseDto> Formacion,
									List<AptitudResponseDto> Aptitud) {

}
