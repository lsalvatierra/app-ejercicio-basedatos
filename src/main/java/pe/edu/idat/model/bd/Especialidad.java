package pe.edu.idat.model.bd;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "especialidad")
public class Especialidad {

	@Id
	private String idesp;
	@Column(name = "nomesp")
	private String nomesp;
	@Column(name = "costo")
	private Double costo;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "especialidad", 
			cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Alumno> listaalumno = new ArrayList<>();
	
	
}
