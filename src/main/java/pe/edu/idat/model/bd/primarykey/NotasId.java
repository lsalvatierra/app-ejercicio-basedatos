package pe.edu.idat.model.bd.primarykey;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Embeddable
public class NotasId implements Serializable {

	private static final long serialVersionUID = 1L;
	private String idalumno;
	private String idcurso;
}
