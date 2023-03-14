package pe.edu.idat.model.bd;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pe.edu.idat.model.bd.primarykey.PagosId;

@Getter
@Setter
@NoArgsConstructor
@Entity
@IdClass(PagosId.class)
@Table(name = "pagos")
public class Pagos {
	@Id
	private String idalumno;
	@Id
	private String ciclo;
	@Id
	private Integer ncuota;
	@Column(name = "monto")
	private Double monto;
	@Column(name = "fecha")
	private Date fecha;

}
