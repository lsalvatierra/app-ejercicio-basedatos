package pe.edu.idat.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "curso")
public class Curso {
	
	@Id
	private String idcurso;
	
	@Column(name = "nomcurso")
	private String nomcurso;
	
	@Column(name = "credito")
	private Integer credito;
	

}
