package dws.ut5_reto.cvAPI.services;

import dws.ut5_reto.cvAPI.dtos.alumnos.ConduccionRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.ConduccionResponseDto;

public interface ConduccionService {
	
	public ConduccionResponseDto obtainById(Long idConduccion);
	public ConduccionResponseDto create(ConduccionRequestDto requestDto);
	public ConduccionResponseDto updateById(Long idConduccion, ConduccionRequestDto requestDto);
	
	public void deleteById(Long idConduccion);
	
}