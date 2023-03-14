package pe.edu.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.idat.model.bd.sp.AlumnoEspecialidadSp;

@Repository
public interface AlumnoEspecialidadRepository 
	extends JpaRepository<AlumnoEspecialidadSp, String> {
	
	@Query(value = "{call sp_MantListarAlumno()}",
			nativeQuery = true)
	List<AlumnoEspecialidadSp> listarAlumnos();

}
