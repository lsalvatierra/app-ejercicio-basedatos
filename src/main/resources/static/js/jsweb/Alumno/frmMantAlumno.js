$(document).on("click", "#btnagregaralumno", function() {
	$("#modalNuevoAlumno").modal("show");
	$("#txtnombre").val("");
	$("#txtapellido").val("");
	$("#cboEspecialidad").val("0");
	$("#txtproce").val("");
	$("#hddidalumno").val("0");
	$("#cboEspecialidad").empty();
	$.ajax({
		type: "GET",
		url: "/Especialidad/listarEspecialidad",
		dataType: 'json',
		success: function(resultado) {
			$.each(resultado, function(index, value) {
				$('#cboEspecialidad').append(`<option value="${value.idesp}">
                                       ${value.nomesp}
                                  </option>`);
			});
		}
	});
});

$(document).on("click", "#btnGuardarAlumno", function() {
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/Alumno/registrarAlumno",
		data: JSON.stringify({
			idalumno: $("#hddidalumno").val(),
			nomalumno: $("#txtnombre").val(),
			apealumno: $("#txtapellido").val(),
			idesp: $("#cboEspecialidad").val(),
			proce: $("#txtproce").val()
		}),
		success: function(resultado) {
			if (resultado.respuesta) {
				console.log(resultado.mensaje);
				mostrarMensaje(resultado.mensaje, "success");
				//ListarCursos();
			} else {
				console.log(resultado.mensaje);
				mostrarMensaje(resultado.mensaje, "danger");
			}
		}
	})
	$("#modalNuevoAlumno").modal("hide");

});

$(document).on("click", ".btnactualizaralumno", function() {
	$("#modalNuevoAlumno").modal("show");
	$("#txtnombre").val($(this).attr("data-nomalumno"));
	$("#txtapellido").val($(this).attr("data-apealumno"));
	var idesp = $(this).attr("data-idesp");
	$("#txtproce").val($(this).attr("data-proce"));
	$("#hddidalumno").val($(this).attr("data-codalumno"));
	$("#cboEspecialidad").empty();
	$.ajax({
		type: "GET",
		url: "/Especialidad/listarEspecialidad",
		dataType: 'json',
		success: function(resultado) {
			$.each(resultado, function(index, value) {
				$('#cboEspecialidad').append($("<option>", {
						    value: value.idesp,
						    text: value.nomesp
						  }));				
			});
			$("#cboEspecialidad").val(idesp);
			//$("#cboEspecialidad option[value="+idesp+"]").attr("selected",true);
		}
	});
	//$("#cboEspecialidad").val($(this).attr("data-idesp"));
	$("#modalNuevoAlumno").modal("show");
});

$(document).on("click", ".btneliminaralumno", function() {
	$("#hddidcursoeliminar").val("");
	$("#mensajeeliminar").text("¿Está seguro de eliminar el curso: " +
		$(this).attr("data-nomalumno") + "?");
	$("#hddidcursoeliminar").val($(this).attr("data-codalumno"));
	$("#modalEliminarAlumno").modal("show");
});

$(document).on("click", "#btnEliminarAlumno", function() {
	$.ajax({
		type: "DELETE",
		contentType: "application/json",
		url: "/Alumno/eliminarAlumno",
		data: JSON.stringify({
			idalumno: $("#hddidcursoeliminar").val()
		}),
		success: function(resultado) {
			if (resultado.respuesta) {
				console.log(resultado.mensaje);
				mostrarMensaje(resultado.mensaje, "success");
				//ListarCursos();
			}else{
				console.log(resultado.mensaje);
				mostrarMensaje(resultado.mensaje, "danger");
			}
			$("#modalEliminarAlumno").modal("hide");
		}
	})
});

function mostrarMensaje(mensaje, estilo){
	$("#mensaje").html("")
	$("#mensaje").append("<div class='alert alert-"+estilo+" alert-dismissible fade show' role='alert'>"+
	"<strong>"+mensaje+"</strong>"+
	"<button type='button' class='btn-close' data-bs-dismiss='alert' aria-label='Close'></button>"+
	"</div>")
}

function ListarCursos() {
	$.ajax({
		type: "GET",
		url: "/Alumno/listarAlumno",
		dataType: 'json',
		success: function(resultado) {
			$("#tblcurso > tbody").html("");
			$.each(resultado, function(index, value) {
				$("#tblcurso > tbody").append("<tr>" +
					"<td>" + value.idcurso + "</td>" +
					"<td>" + value.nomcurso + "</td>" +
					"<td>" + value.credito + "</td>" +
					"<td><button type='button' class='btn btn-primary btnactualizarcurso'" +
					" data-codcurso='" + value.idcurso + "' " +
					" data-nomcurso='" + value.nomcurso + "' " +
					" data-credcurso='" + value.credito + "' " +
					">Actualizar</button></td>" +
					"<td><button type='button' class='btn btn-danger btneliminarcurso'" +
					" data-codcurso='" + value.idcurso + "' " +
					" data-nomcurso='" + value.nomcurso + "' " +
					">Eliminar</button></td>" +
					"</tr>"
				)
			})
		}
	})
}