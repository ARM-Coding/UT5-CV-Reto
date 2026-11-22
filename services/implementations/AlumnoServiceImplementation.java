package dws.ut5_reto.cvAPI.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dws.ut5_reto.cvAPI.dtos.alumnos.AlumnoInfoRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.AlumnoInfoResponseDto;
import dws.ut5_reto.cvAPI.entities.Alumno;
import dws.ut5_reto.cvAPI.repositories.AlumnoRepository;
import dws.ut5_reto.cvAPI.services.AlumnoService;

@Service
public class AlumnoServiceImplementation implements AlumnoService {

	private AlumnoInfoResponseDto mapToResponseDto(Alumno alumno) {
		return new AlumnoInfoResponseDto(alumno.getIdAlumno(), alumno.getNombre(), alumno.getApellido1(),
				alumno.getApellido2(), alumno.getEmailPersonal(), alumno.getTelefonoPersonal(), alumno.getDireccion(),
				alumno.getCiclo(), alumno.getCurso(), alumno.getConduccion());
	}

	// Inyeccion del repositorio

	private AlumnoRepository alumnoRepository;

	public AlumnoServiceImplementation(AlumnoRepository alumnoRepository) {
		super();
		this.alumnoRepository = alumnoRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public AlumnoInfoResponseDto obtainById(Long idAlumno) {
		// TODO Auto-generated method stub
		Alumno alumno = alumnoRepository.findById(idAlumno).orElseThrow();

		Alumno found = alumnoRepository.save(alumno);

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public AlumnoInfoResponseDto create(AlumnoInfoRequestDto requestDto) {
		// TODO Auto-generated method stub
		if (alumnoRepository.existsByTelefonoPersonal(requestDto.telefonoPersonal())
				|| alumnoRepository.existsByEmailPersonal(requestDto.emailPersonal())) {
			throw new Error();
		}

		Alumno newAlumno = new Alumno(null, requestDto.nombre(), requestDto.apellido1(), requestDto.apellido2(),
				requestDto.emailPersonal(), requestDto.telefonoPersonal(), requestDto.direccion(), requestDto.ciclo(),
				requestDto.curso(), requestDto.conduccion());

		Alumno created = alumnoRepository.save(newAlumno);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public AlumnoInfoResponseDto updateByTlf(String telefonoPersonal, AlumnoInfoRequestDto requestDto) {
		// TODO Auto-generated method stub
		Alumno alumnoFound = alumnoRepository.findByTelefonoPersonal(telefonoPersonal).orElseThrow();

		alumnoFound.setNombre(requestDto.nombre());
		alumnoFound.setApellido1(requestDto.apellido1());
		alumnoFound.setApellido2(requestDto.apellido2());
		alumnoFound.setEmailPersonal(requestDto.emailPersonal());
		alumnoFound.setTelefonoPersonal(requestDto.telefonoPersonal());
		alumnoFound.setDireccion(requestDto.direccion());
		alumnoFound.setCiclo(requestDto.ciclo());
		alumnoFound.setCurso(requestDto.curso());
		alumnoFound.setConduccion(requestDto.conduccion());

		Alumno updated = alumnoRepository.save(alumnoFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteByTlf(String telefonoPersonal) {
		// TODO Auto-generated method stub
		if (!alumnoRepository.existsByTelefonoPersonal(telefonoPersonal)) {
			throw new Error();
		} else {
			alumnoRepository.deleteById(alumnoRepository.findByTelefonoPersonal(telefonoPersonal)
														.orElseThrow().getIdAlumno());
		}

	}

}
