package pe.edu.idat.model.bd;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "alumno")
public class Alumno {

	@Id
	private String idalumno;
	@Column(name = "apealumno")
	private String apealumno;
	@Column(name = "nomalumno")
	private String nomalumno;
	@Column(name = "proce")
	private String proce;
	
	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "idesp")
	private Especialidad especialidad;
	
	
}
