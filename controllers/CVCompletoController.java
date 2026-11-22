package dws.ut5_reto.cvAPI.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dws.ut5_reto.cvAPI.dtos.alumnos.AlumnoInfoResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.AptitudResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.CVCompletoResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.ExperienciaResponseDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.FormacionResponseDto;
import dws.ut5_reto.cvAPI.services.CVByAlumnoService;

@RestController
@RequestMapping("/api/cvs")
public class CVCompletoController {

	private CVByAlumnoService cvByAlumnoService;

	public CVCompletoController(CVByAlumnoService cvByAlumnoService) {
		super();
		this.cvByAlumnoService = cvByAlumnoService;
	}

	@GetMapping("/id/{idAlumno}")
	public ResponseEntity<CVCompletoResponseDto> obtainById(@PathVariable Long idAlumno) {
		AlumnoInfoResponseDto alumnoInfo = cvByAlumnoService.obtainByIdAlumno(idAlumno);

		List<ExperienciaResponseDto> listaExperiencias = cvByAlumnoService.obtainAllExperiencias().stream()
				.filter(experiencias -> experiencias.alumno().getIdAlumno().equals(alumnoInfo.idAlumno())).toList();

		List<FormacionResponseDto> listaFormaciones = cvByAlumnoService.obtainAllFormaciones().stream()
				.filter(formaciones -> formaciones.alumno().getIdAlumno().equals(alumnoInfo.idAlumno())).toList();

		List<AptitudResponseDto> listaAptitudes = cvByAlumnoService.obtainAllAptitudes().stream()
				.filter(aptitudes -> aptitudes.alumno().getIdAlumno().equals(alumnoInfo.idAlumno())).toList();

		CVCompletoResponseDto CVCompleto = new CVCompletoResponseDto(alumnoInfo, listaExperiencias, listaFormaciones,
				listaAptitudes);

		return ResponseEntity.ok(CVCompleto);
	}

}
