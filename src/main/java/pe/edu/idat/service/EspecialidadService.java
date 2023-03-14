package pe.edu.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.idat.model.bd.Especialidad;
import pe.edu.idat.repository.EspecialidadRepository;

@Service
public class EspecialidadService {

	
	@Autowired
	private EspecialidadRepository especialidadRepository;
	
	public List<Especialidad> listarEspecialidad(){
		return especialidadRepository.findAll();
	}
	
}
