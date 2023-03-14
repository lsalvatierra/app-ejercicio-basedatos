package pe.edu.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pe.edu.idat.model.bd.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, String> {

	@Transactional
	@Modifying
	@Query(
			value = "{call sp_MantRegistrarAlumno(:nomalumno,:apealumno,:idesp,:proce)}",
			nativeQuery = true)
	void registrarAlumno(@Param("nomalumno") String nomalumno, 
			@Param("apealumno")String apealumno, 
			@Param("idesp")String idesp, 
			@Param("proce")String proce);
	
}
