package pe.edu.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.idat.model.bd.Especialidad;

@Repository
public interface EspecialidadRepository 
	extends JpaRepository<Especialidad, String> {

}
