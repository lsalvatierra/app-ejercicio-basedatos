package pe.edu.idat.model.bd;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.idat.model.bd.primarykey.NotasId;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "notas")
public class Notas {
	@EmbeddedId
	private NotasId notasId;
	@Column(name ="exaparcial")
	private Double exaparcial;
	@Column(name = "exafinal")
	private Double exafinal;

}
