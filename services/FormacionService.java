package dws.ut5_reto.cvAPI.services;

import dws.ut5_reto.cvAPI.dtos.alumnos.FormacionRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.FormacionResponseDto;

public interface FormacionService {
	
	public FormacionResponseDto obtainById(Long idFormacion);
	public FormacionResponseDto create(FormacionRequestDto requestDto);
	public FormacionResponseDto updateById(Long idFormacion, FormacionRequestDto requestDto);
	
	public void deleteById(Long idFormacion);
	
}