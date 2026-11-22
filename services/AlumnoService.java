package dws.ut5_reto.cvAPI.services;

import dws.ut5_reto.cvAPI.dtos.alumnos.AlumnoInfoRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.AlumnoInfoResponseDto;

public interface AlumnoService {
	
	public AlumnoInfoResponseDto obtainById(Long idAlumno);
	public AlumnoInfoResponseDto create(AlumnoInfoRequestDto requestDto);
	public AlumnoInfoResponseDto updateByTlf(String telefonoPersonal, AlumnoInfoRequestDto requestDto);
	
	public void deleteByTlf(String telefonoPersonal);
	
}
