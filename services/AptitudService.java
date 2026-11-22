package dws.ut5_reto.cvAPI.services;

import dws.ut5_reto.cvAPI.dtos.alumnos.AptitudRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.AptitudResponseDto;

public interface AptitudService {
	
	public AptitudResponseDto obtainById(Long idAptitudes);
	public AptitudResponseDto create(AptitudRequestDto requestDto);
	public AptitudResponseDto updateById(Long idAptitudes, AptitudRequestDto requestDto);
	
	public void deleteById(Long idAptitudes);
	
}