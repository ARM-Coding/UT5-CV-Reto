package dws.ut5_reto.cvAPI.services.implementations;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dws.ut5_reto.cvAPI.dtos.alumnos.ConduccionRequestDto;
import dws.ut5_reto.cvAPI.dtos.alumnos.ConduccionResponseDto;
import dws.ut5_reto.cvAPI.entities.Conduccion;
import dws.ut5_reto.cvAPI.repositories.ConduccionRepository;
import dws.ut5_reto.cvAPI.services.ConduccionService;

@Service
public class ConduccionServiceImplementation implements ConduccionService {

	private ConduccionResponseDto mapToResponseDto(Conduccion conduccion) {
		return new ConduccionResponseDto(conduccion.getIdConduccion(), conduccion.isTieneCarnet(),
				conduccion.isTieneVehiculo());
	}

	// Inyeccion del repositorio

	private ConduccionRepository conduccionRepository;

	public ConduccionServiceImplementation(ConduccionRepository conduccionRepository) {
		super();
		this.conduccionRepository = conduccionRepository;
	}

	@Override
	@Transactional(readOnly = true)
	public ConduccionResponseDto obtainById(Long idConduccion) {
		Conduccion found = conduccionRepository.findById(idConduccion).orElseThrow();

		return mapToResponseDto(found);
	}

	@Override
	@Transactional(readOnly = false)
	public ConduccionResponseDto create(ConduccionRequestDto requestDto) {
		Conduccion newConduccion = new Conduccion(null, requestDto.tieneCarnet(), requestDto.tieneVehiculo());

		Conduccion created = conduccionRepository.save(newConduccion);

		return mapToResponseDto(created);
	}

	@Override
	@Transactional(readOnly = false)
	public ConduccionResponseDto updateById(Long idConduccion, ConduccionRequestDto requestDto) {
		Conduccion conduccionFound = conduccionRepository.findById(idConduccion).orElseThrow();

		conduccionFound.setTieneCarnet(requestDto.tieneCarnet());
		conduccionFound.setTieneVehiculo(requestDto.tieneVehiculo());

		Conduccion updated = conduccionRepository.save(conduccionFound);

		return mapToResponseDto(updated);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteById(Long idConduccion) {
		if (!conduccionRepository.existsById(idConduccion)) {
			throw new Error();
		} else {
			conduccionRepository.deleteById(idConduccion);
		}
	}

}