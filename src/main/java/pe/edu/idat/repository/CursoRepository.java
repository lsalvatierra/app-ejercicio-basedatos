package pe.edu.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import pe.edu.idat.model.bd.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, String> 
{
	@Transactional
	@Modifying
	@Query(value = 
			"{call sp_MantRegistrarCurso(:nombrecurso, :creditocurso)}",
			nativeQuery = true)
	void registrarCurso(@Param("nombrecurso") String nombrecurso, 
			@Param("creditocurso") Integer creditocurso);

}
