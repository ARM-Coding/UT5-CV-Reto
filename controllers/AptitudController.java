package dws.ut5_reto.cvAPI.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dws.ut5_reto.cvAPI.dtos.alumnos.AptitudRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.AptitudResponseDto;
import dws.ut5_reto.cvAPI.services.AptitudService;

@RestController
@RequestMapping("/api/aptitudes")
public class AptitudController {
	
	private AptitudService aptitudService;

	public AptitudController(AptitudService aptitudService) {
		super();
		this.aptitudService = aptitudService;
	}
	
	@GetMapping("/id/{idAptitudes}")
	public ResponseEntity<AptitudResponseDto> obtainById(@PathVariable Long idAptitudes) {
		return ResponseEntity.ok(aptitudService.obtainById(idAptitudes));
	}
	
	@PostMapping
	public ResponseEntity<AptitudResponseDto> create(@RequestBody AptitudRequestDto requestDto) {
		AptitudResponseDto creado = aptitudService.create(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}
	
	@PutMapping("/id/{idAptitudes}")
	public ResponseEntity<AptitudResponseDto> update(@PathVariable Long idAptitudes, 
			@RequestBody AptitudRequestDto requestDto) {
		return ResponseEntity.ok(aptitudService.updateById(idAptitudes, requestDto));
	}
	
	@DeleteMapping("/id/{idAptitudes}")
	public ResponseEntity<AptitudResponseDto> delete(@PathVariable Long idAptitudes) {
		aptitudService.deleteById(idAptitudes);
		return ResponseEntity.noContent().build();
	}
	
}