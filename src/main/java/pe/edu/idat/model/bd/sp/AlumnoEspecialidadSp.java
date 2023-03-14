package pe.edu.idat.model.bd.sp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class AlumnoEspecialidadSp {

	@Id
	private String idalumno;
	@Column(name = "apealumno")
	private String apealumno;
	@Column(name = "nomalumno")
	private String nomalumno;
	@Column(name = "idesp")
	private String idesp;
	@Column(name = "nomesp")
	private String nomesp;
	@Column(name = "proce")
	private String proce;
	
}
