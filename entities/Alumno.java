package dws.ut5_reto.cvAPI.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumno", schema = "crmCV")
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_alumno")
	private Long idAlumno;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "apellido_1", nullable = false, length = 50)
	private String apellido1;

	@Column(name = "apellido_2", nullable = false, length = 50)
	private String apellido2;

	@Column(name = "email_personal", length = 100)
	private String emailPersonal;

	@Column(name = "telefono_personal", length = 12)
	private String telefonoPersonal;

	@Column(name = "direccion", length = 100)
	private String direccion;

	@Column(name = "ciclo", nullable = false, length = 6)
	private String ciclo;

	@Column(name = "curso", nullable = false, length = 6)
	private String curso;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_conduccion", foreignKey = @ForeignKey(name = "fk_conduccion_idConduccion"))
	private Conduccion conduccion;

	// Constructores

	public Alumno() {
	};

	public Alumno(Long idAlumno, String nombre, String apellido1, String apellido2, String emailPersonal,
			String telefonoPersonal, String direccion, String ciclo, String curso, Conduccion conduccion) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.emailPersonal = emailPersonal;
		this.telefonoPersonal = telefonoPersonal;
		this.direccion = direccion;
		this.ciclo = ciclo;
		this.curso = curso;
		this.conduccion = conduccion;
	}

	// Getters & Setters

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public String getTelefonoPersonal() {
		return telefonoPersonal;
	}

	public void setTelefonoPersonal(String telefonoPersonal) {
		this.telefonoPersonal = telefonoPersonal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public Conduccion getConduccion() {
		return conduccion;
	}

	public void setConduccion(Conduccion conduccion) {
		this.conduccion = conduccion;
	}

}
