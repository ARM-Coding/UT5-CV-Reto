package dws.ut5_reto.cvAPI.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dws.ut5_reto.cvAPI.dtos.alumnos.AlumnoInfoResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.AptitudResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.ExperienciaResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.FormacionResponseDto;
import dws.ut5_reto.cvAPI.entities.Alumno;
import dws.ut5_reto.cvAPI.entities.Aptitud;
import dws.ut5_reto.cvAPI.entities.Experiencia;
import dws.ut5_reto.cvAPI.entities.Formacion;
import dws.ut5_reto.cvAPI.repositories.AlumnoRepository;
import dws.ut5_reto.cvAPI.repositories.AptitudRepository;
import dws.ut5_reto.cvAPI.repositories.ExperienciaRepository;
import dws.ut5_reto.cvAPI.repositories.FormacionRepository;
import dws.ut5_reto.cvAPI.services.CVByAlumnoService;

@Service
public class CVByAlumnoServiceImplementation implements CVByAlumnoService {

	private AlumnoInfoResponseDto mapToAlumnoResponseDto(Alumno alumno) {
		return new AlumnoInfoResponseDto(alumno.getIdAlumno(), alumno.getNombre(), alumno.getApellido1(),
				alumno.getApellido2(), alumno.getEmailPersonal(), alumno.getTelefonoPersonal(), alumno.getDireccion(),
				alumno.getCiclo(), alumno.getCurso(), alumno.getConduccion());
	}

	private ExperienciaResponseDto mapToExperienciaResponseDto(Experiencia experiencia) {
		return new ExperienciaResponseDto(experiencia.getIdExperiencia(), experiencia.getNombreEmpresa(),
				experiencia.getFechaComienzo(), experiencia.getFechaFinalizacion(), experiencia.getPuesto(),
				experiencia.getDescripcion(), experiencia.getAlumno());
	}

	private FormacionResponseDto mapToFormacionResponseDto(Formacion formacion) {
		return new FormacionResponseDto(formacion.getIdFormacion(), formacion.getNombreTitulación(),
				formacion.getFecha(), formacion.getDescripcion(), formacion.getAlumno());
	}

	private AptitudResponseDto mapToAptitudResponseDto(Aptitud aptitud) {
		return new AptitudResponseDto(aptitud.getIdAptitudes(), aptitud.getNombre(), aptitud.getDescripcion(),
				aptitud.getAlumno());
	}

	private AlumnoRepository alumnoRepository;
	private ExperienciaRepository experienciaRepository;
	private FormacionRepository formacionRepository;
	private AptitudRepository aptitudRepository;
	public CVByAlumnoServiceImplementation(AlumnoRepository alumnoRepository,
	        ExperienciaRepository experienciaRepository,
	        FormacionRepository formacionRepository,
	        AptitudRepository aptitudRepository) {
	    super();
	    this.alumnoRepository = alumnoRepository;
	    this.experienciaRepository = experienciaRepository;
	    this.formacionRepository = formacionRepository;
	    this.aptitudRepository = aptitudRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public AlumnoInfoResponseDto obtainByIdAlumno(Long idAlumno) {
		// TODO Auto-generated method stub
		Alumno alumno = alumnoRepository.findById(idAlumno).orElseThrow();

		Alumno found = alumnoRepository.save(alumno);

		return mapToAlumnoResponseDto(found);
	}

	@Override
	@Transactional(readOnly = true)
	public List<ExperienciaResponseDto> obtainAllExperiencias() {
		// TODO Auto-generated method stub
		return experienciaRepository.findAll().stream().map(this::mapToExperienciaResponseDto).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<FormacionResponseDto> obtainAllFormaciones() {
		// TODO Auto-generated method stub
		return formacionRepository.findAll().stream().map(this::mapToFormacionResponseDto).toList();
	}

	@Override
	@Transactional(readOnly = true)
	public List<AptitudResponseDto> obtainAllAptitudes() {
		// TODO Auto-generated method stub
		return aptitudRepository.findAll().stream().map(this::mapToAptitudResponseDto).toList();
	}

}
