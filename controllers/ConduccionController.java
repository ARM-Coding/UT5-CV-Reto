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

import dws.ut5_reto.cvAPI.dtos.alumnos.ConduccionRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.ConduccionResponseDto;
import dws.ut5_reto.cvAPI.services.ConduccionService;

@RestController
@RequestMapping("/api/conducciones")
public class ConduccionController {
	
	private ConduccionService conduccionService;

	public ConduccionController(ConduccionService conduccionService) {
		super();
		this.conduccionService = conduccionService;
	}
	
	@GetMapping("/id/{idConduccion}")
	public ResponseEntity<ConduccionResponseDto> obtainById(@PathVariable Long idConduccion) {
		return ResponseEntity.ok(conduccionService.obtainById(idConduccion));
	}
	
	@PostMapping
	public ResponseEntity<ConduccionResponseDto> create(@RequestBody ConduccionRequestDto requestDto) {
		ConduccionResponseDto creado = conduccionService.create(requestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(creado);
	}
	
	@PutMapping("/id/{idConduccion}")
	public ResponseEntity<ConduccionResponseDto> update(@PathVariable Long idConduccion, 
			@RequestBody ConduccionRequestDto requestDto) {
		return ResponseEntity.ok(conduccionService.updateById(idConduccion, requestDto));
	}
	
	@DeleteMapping("/id/{idConduccion}")
	public ResponseEntity<ConduccionResponseDto> delete(@PathVariable Long idConduccion) {
		conduccionService.deleteById(idConduccion);
		return ResponseEntity.noContent().build();
	}
	
}