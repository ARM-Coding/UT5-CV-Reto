package dws.ut5_reto.cvAPI.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dws.ut5_reto.cvAPI.entities.Conduccion;

@Repository
public interface ConduccionRepository extends JpaRepository<Conduccion, Long> {
	
	// Métodos derivados para la info de Conduccion
	
	boolean existsByTieneCarnet(boolean tieneCarnet);
	boolean existsByTieneVehiculo(boolean tieneVehiculo);
	
	List<Conduccion> findByTieneCarnet(boolean tieneCarnet);
	List<Conduccion> findByTieneVehiculo(boolean tieneVehiculo);
	
}