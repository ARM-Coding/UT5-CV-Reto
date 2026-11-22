package dws.ut5_reto.cvAPI.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dws.ut5_reto.cvAPI.dtos.alumnos.AptitudRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.AptitudResponseDto;
import dws.ut5_reto.cvAPI.entities.Aptitud;
import dws.ut5_reto.cvAPI.repositories.AptitudRepository;
import dws.ut5_reto.cvAPI.services.AptitudService;

@Service
public class AptitudServiceImplementation implements AptitudService {

	private AptitudResponseDto mapToResponseDto(Aptitud aptitud) {
		return new AptitudResponseDto(aptitud.getIdAptitudes(), aptitud.getNombre(), aptitud.getDescripcion(),
				aptitud.getAlumno());
	}

	// Inyeccion del repositorio

	private AptitudRepository aptitudRepository;

	public AptitudServiceImplementation(AptitudRepository aptitudRepository) {
		super();
		this.aptitudRepository = aptitudRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public AptitudResponseDto obtainById(Long idAptitudes) {
		Aptitud found = aptitudRepository.findById(idAptitudes).orElseThrow();

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public AptitudResponseDto create(AptitudRequestDto requestDto) {
		Aptitud newAptitud = new Aptitud(null, requestDto.nombre(), requestDto.descripcion(), requestDto.alumno());

		Aptitud created = aptitudRepository.save(newAptitud);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public AptitudResponseDto updateById(Long idAptitudes, AptitudRequestDto requestDto) {
		Aptitud aptitudFound = aptitudRepository.findById(idAptitudes).orElseThrow();

		aptitudFound.setNombre(requestDto.nombre());
		aptitudFound.setDescripcion(requestDto.descripcion());
		aptitudFound.setAlumno(requestDto.alumno());

		Aptitud updated = aptitudRepository.save(aptitudFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long idAptitudes) {
		if (!aptitudRepository.existsById(idAptitudes)) {
			throw new Error();
		} else {
			aptitudRepository.deleteById(idAptitudes);
		}
	}

}