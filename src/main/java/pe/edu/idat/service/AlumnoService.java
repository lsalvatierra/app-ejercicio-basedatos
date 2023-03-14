package pe.edu.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.idat.model.bd.Alumno;
import pe.edu.idat.model.bd.sp.AlumnoEspecialidadSp;
import pe.edu.idat.repository.AlumnoEspecialidadRepository;
import pe.edu.idat.repository.AlumnoRepository;

@Service
public class AlumnoService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	
	@Autowired
	private AlumnoEspecialidadRepository aEspecialidadRepository;
	
	public List<AlumnoEspecialidadSp> listarAlumnos(){
		return aEspecialidadRepository.listarAlumnos();
	}
	
	public void registrarAlumno(Alumno alumno) {
		if(alumno.getIdalumno().equals("0")) {
			alumnoRepository.registrarAlumno(alumno.getNomalumno(), 
					alumno.getApealumno(), 
					alumno.getEspecialidad().getIdesp(), 
					alumno.getProce());
		}else {
			alumnoRepository.save(alumno);
		}
	}
	
	public void eliminarAlumno(String idAlumno) {
		alumnoRepository.deleteById(idAlumno);
	}
	
}
