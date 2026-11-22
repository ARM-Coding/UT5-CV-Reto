package dws.ut5_reto.cvAPI.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dws.ut5_reto.cvAPI.dtos.alumnos.FormacionRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.FormacionResponseDto;
import dws.ut5_reto.cvAPI.entities.Formacion;
import dws.ut5_reto.cvAPI.repositories.FormacionRepository;
import dws.ut5_reto.cvAPI.services.FormacionService;

@Service
public class FormacionServiceImplementation implements FormacionService {

	private FormacionResponseDto mapToResponseDto(Formacion formacion) {
		return new FormacionResponseDto(formacion.getIdFormacion(), formacion.getNombreTitulación(),
				formacion.getFecha(), formacion.getDescripcion(), formacion.getAlumno());
	}

	// Inyeccion del repositorio

	private FormacionRepository formacionRepository;

	public FormacionServiceImplementation(FormacionRepository formacionRepository) {
		super();
		this.formacionRepository = formacionRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public FormacionResponseDto obtainById(Long idFormacion) {
		Formacion found = formacionRepository.findById(idFormacion).orElseThrow();

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public FormacionResponseDto create(FormacionRequestDto requestDto) {
		Formacion newFormacion = new Formacion(null, requestDto.nombreTitulacion(), requestDto.fecha(),
				requestDto.descripcion(), requestDto.alumno());

		Formacion created = formacionRepository.save(newFormacion);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public FormacionResponseDto updateById(Long idFormacion, FormacionRequestDto requestDto) {
		Formacion formacionFound = formacionRepository.findById(idFormacion).orElseThrow();

		formacionFound.setNombreTitulación(requestDto.nombreTitulacion());
		formacionFound.setFecha(requestDto.fecha());
		formacionFound.setDescripcion(requestDto.descripcion());
		formacionFound.setAlumno(requestDto.alumno());

		Formacion updated = formacionRepository.save(formacionFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long idFormacion) {
		if (!formacionRepository.existsById(idFormacion)) {
			throw new Error();
		} else {
			formacionRepository.deleteById(idFormacion);
		}
	}

}