package dws.ut5_reto.cvAPI.services;

import dws.ut5_reto.cvAPI.dtos.alumnos.ExperienciaRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.ExperienciaResponseDto;

public interface ExperienciaService {
	
	public ExperienciaResponseDto obtainById(Long idExperiencia);
	public ExperienciaResponseDto create(ExperienciaRequestDto requestDto);
	public ExperienciaResponseDto updateById(Long idExperiencia, ExperienciaRequestDto requestDto);
	
	public void deleteById(Long idExperiencia);
	
}
