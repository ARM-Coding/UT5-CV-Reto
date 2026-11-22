package dws.ut5_reto.cvAPI.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "conduccion", schema = "crmCV")
public class Conduccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conduccion")
	private Long idConduccion;
	
	@Column(name = "tiene_carnet")
	private boolean tieneCarnet;
	
	@Column(name = "tiene_vehiculo")
	private boolean tieneVehiculo;
	
	// Constructores
	
	public Conduccion() {};
	
	public Conduccion(Long idConduccion, boolean tieneCarnet, boolean tieneVehiculo) {
		super();
		this.idConduccion = idConduccion;
		this.tieneCarnet = tieneCarnet;
		this.tieneVehiculo = tieneVehiculo;
	}
	
	// Getters & Setters
	
	public Long getIdConduccion() {
		return idConduccion;
	}

	public void setIdConduccion(Long idConduccion) {
		this.idConduccion = idConduccion;
	}

	public boolean isTieneCarnet() {
		return tieneCarnet;
	}

	public void setTieneCarnet(boolean tieneCarnet) {
		this.tieneCarnet = tieneCarnet;
	}

	public boolean isTieneVehiculo() {
		return tieneVehiculo;
	}

	public void setTieneVehiculo(boolean tieneVehiculo) {
		this.tieneVehiculo = tieneVehiculo;
	}
	
}
