package pe.edu.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.edu.idat.model.bd.Alumno;
import pe.edu.idat.model.bd.Curso;
import pe.edu.idat.model.bd.Especialidad;
import pe.edu.idat.model.bd.sp.AlumnoEspecialidadSp;
import pe.edu.idat.model.request.AlumnoRequest;
import pe.edu.idat.model.response.ResultadoResponse;
import pe.edu.idat.service.AlumnoService;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

	@Autowired
	private AlumnoService aService;
	
	
	@GetMapping("/frmMantAlumno")
	public String frmListarAlumnos(Model model) {
		model.addAttribute("listalumnos", aService.listarAlumnos());
		return "Alumno/frmMantAlumno";
	}
	
	@PostMapping("/registrarAlumno")
	@ResponseBody
	public ResultadoResponse registrarCurso(@RequestBody AlumnoRequest objAlumnoReq) {
		String mensaje ="Curso registrado correctamente";
		Boolean respuesta = true;
		try {
			Alumno objAlumno = new Alumno();
			objAlumno.setIdalumno(objAlumnoReq.getIdalumno());
			objAlumno.setNomalumno(objAlumnoReq.getNomalumno());
			objAlumno.setApealumno(objAlumnoReq.getApealumno());
			Especialidad objEspecialidad = new Especialidad();
			objEspecialidad.setIdesp(objAlumnoReq.getIdesp());
			objAlumno.setEspecialidad(objEspecialidad);
			objAlumno.setProce(objAlumnoReq.getProce());
			aService.registrarAlumno(objAlumno);
		}catch (Exception e) {
			mensaje ="Curso no registrado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@DeleteMapping("/eliminarAlumno")
	@ResponseBody
	public ResultadoResponse eliminarCurso(@RequestBody AlumnoRequest objAlumnoReq) {
		String mensaje ="Curso eliminado correctamente";
		Boolean respuesta = true;
		try {
			aService.eliminarAlumno(objAlumnoReq.getIdalumno());
		}catch (Exception e) {
			mensaje ="Curso no eliminado";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@GetMapping("/listarAlumno")
	@ResponseBody
	public List<AlumnoEspecialidadSp> listarAlumno(){
		return aService.listarAlumnos();
	}
	
	
}
