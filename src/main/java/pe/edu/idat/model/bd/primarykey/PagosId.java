package pe.edu.idat.model.bd.primarykey;

import java.io.Serializable;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PagosId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String idalumno;
	private String ciclo;
	private String ncuota;
	
}
