package dws.ut5_reto.cvAPI.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dws.ut5_reto.cvAPI.dtos.alumnos.ExperienciaRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.ExperienciaResponseDto;
import dws.ut5_reto.cvAPI.entities.Experiencia;
import dws.ut5_reto.cvAPI.repositories.ExperienciaRepository;
import dws.ut5_reto.cvAPI.services.ExperienciaService;

@Service
public class ExperienciaServiceImplementation implements ExperienciaService {

	private ExperienciaResponseDto mapToResponseDto(Experiencia experiencia) {
		return new ExperienciaResponseDto(experiencia.getIdExperiencia(), experiencia.getNombreEmpresa(),
				experiencia.getFechaComienzo(), experiencia.getFechaFinalizacion(), experiencia.getPuesto(),
				experiencia.getDescripcion(), experiencia.getAlumno());
	}

	// Inyeccion del repositorio

	private ExperienciaRepository experienciaRepository;

	public ExperienciaServiceImplementation(ExperienciaRepository experienciaRepository) {
		super();
		this.experienciaRepository = experienciaRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public ExperienciaResponseDto obtainById(Long idExperiencia) {
		Experiencia found = experienciaRepository.findById(idExperiencia).orElseThrow();

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public ExperienciaResponseDto create(ExperienciaRequestDto requestDto) {
		if (experienciaRepository.existsByNombreEmpresa(requestDto.nombreEmpresa())
				|| experienciaRepository.existsByPuesto(requestDto.puesto())) {
			throw new Error();
		}
		
		Experiencia newExperiencia = new Experiencia(null, requestDto.nombreEmpresa(), requestDto.fechaComienzo(),
				requestDto.fechaFinalizacion(), requestDto.puesto(), requestDto.descripcion(), requestDto.alumno());

		Experiencia created = experienciaRepository.save(newExperiencia);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public ExperienciaResponseDto updateById(Long idExperiencia, ExperienciaRequestDto requestDto) {
		Experiencia experienciaFound = experienciaRepository.findById(idExperiencia).orElseThrow();

		experienciaFound.setNombreEmpresa(requestDto.nombreEmpresa());
		experienciaFound.setFechaComienzo(requestDto.fechaComienzo());
		experienciaFound.setFechaFinalizacion(requestDto.fechaFinalizacion());
		experienciaFound.setPuesto(requestDto.puesto());
		experienciaFound.setDescripcion(requestDto.descripcion());

		Experiencia updated = experienciaRepository.save(experienciaFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long idExperiencia) {
		if (!experienciaRepository.existsById(idExperiencia)) {
			throw new Error();
		} else {
			experienciaRepository.deleteById(idExperiencia);
		}
	}

}
