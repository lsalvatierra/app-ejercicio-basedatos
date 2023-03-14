package pe.edu.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.idat.model.bd.Curso;
import pe.edu.idat.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public List<Curso> listarCursos(){
		return cursoRepository.findAll();
	}
	
	public void registrarCurso(Curso curso) {
		cursoRepository.registrarCurso(curso.getNomcurso(), 
				curso.getCredito());
	}
	
	
	

}
