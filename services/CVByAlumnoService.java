package dws.ut5_reto.cvAPI.services;

import java.util.List;

import dws.ut5_reto.cvAPI.dtos.alumnos.AlumnoInfoResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.AptitudResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.ExperienciaResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.FormacionResponseDto;

public interface CVByAlumnoService {
	
	public AlumnoInfoResponseDto obtainByIdAlumno(Long idAlumno);
	public List<ExperienciaResponseDto> obtainAllExperiencias();
	public List<FormacionResponseDto> obtainAllFormaciones();
	public List<AptitudResponseDto> obtainAllAptitudes();
	
}
