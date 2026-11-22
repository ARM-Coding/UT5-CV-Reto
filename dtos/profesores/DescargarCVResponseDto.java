package dws.ut5_reto.cvAPI.dtos.profesores;

import java.util.List;

import dws.ut5_reto.cvAPI.entities.Alumno;
import dws.ut5_reto.cvAPI.entities.Aptitud;
import dws.ut5_reto.cvAPI.entities.Experiencia;
import dws.ut5_reto.cvAPI.entities.Formacion;

public record DescargarCVResponseDto(Alumno alumno,
									List<Experiencia> experiencias,
									List<Formacion> formaciones,
									List<Aptitud> aptitudes) {

}
