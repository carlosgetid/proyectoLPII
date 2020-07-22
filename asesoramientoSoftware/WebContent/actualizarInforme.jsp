<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%> 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<c:if test="${requestScope.MENSAJE!=null}">
		<div class="alert alert-warning alert-dismissible fade show" role="alert">
		  <strong>${requestScope.MENSAJE}</strong>
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
		    <span aria-hidden="true">&times;</span>
		  </button>
		</div>
	</c:if>
	<div class="container">
  		<form method="post" action="" method="post" id="id_registrar">
  		 <input type="hidden" id="idEstado" value="${informe.codigoEstado}">
		  <div class="form-group">
			    <label for="exampleFormControlTextarea1">Codigo</label>
			    <input class="form-control" id="exampleFormControlTextarea1" name="codigo" value="${informe.codigo}" placeholder="Ingresar descripcion" rows="3" readonly>
			  </div>
		  <div class="form-group">
			    <label for="exampleFormControlTextarea1">Introduccion</label>
			    <textarea  class="form-control" id="exampleFormControlTextarea1" name="introduccion"  placeholder="Ingresar introduccion" rows="3" >${informe.introduccion}</textarea>
			  </div>
			  <div class="form-group">
			    <label for="exampleFormControlTextarea1">Antecedentes</label>
			    <textarea  class="form-control" id="exampleFormControlTextarea1" name="antecedentes" placeholder="Ingresar antecedentes" rows="3" >${informe.antecedentes}</textarea>
			  </div>
			  <div class="form-group">
			    <label for="exampleFormControlTextarea1">Analisis</label>
			    <textarea  class="form-control" id="exampleFormControlTextarea1" name="analisis" placeholder="Ingresar analisis" rows="3" >${informe.analisis}</textarea>
			  </div>
			   <div class="form-group">
			    <label for="exampleFormControlTextarea1">Conclusiones</label>
			    <textarea  class="form-control" id="exampleFormControlTextarea1" name="conclusiones" placeholder="Ingresar descripcion" rows="3" >${informe.conclusiones}</textarea>
			  </div>
			   <div class="form-group">
			    <label for="exampleFormControlTextarea1">Recomendaciones</label>
			    <textarea  class="form-control" id="exampleFormControlTextarea1" name="recomendaciones" placeholder="Ingresar descripcion" rows="3" >${informe.recomendaciones}</textarea>
			  </div>
			  <div class="form-group">
			    <label for="exampleFormControlSelect1">¿Desea aprobar el documento?</label>
			    <select class="form-control" name="nombreEstado" id="idestado">
			      <option>[Seleccione]</option>
			      <option value=1>Postergar</option>
			      <option value=2>Si</option>
			       <option value=3>No, rechazar</option>
			    </select>
			  </div>

				
		  <button type="button" class="btn btn-primary">Actualizar</button>
<!-- 		  <button type="button" class="btn btn-warning">Eliminar</button> -->
		  <button type="button" class="btn btn-success">Regresar</button>
<!-- 		  <button type="button" class="btn btn-success">Nuevo Informe</button> -->
		</form>
	</div>		
	
	<!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
 
 	<!-- jQuery validate -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.min.js"></script>
	
	<script>
	$(".btn-primary").click(function(){
		$("#id_registrar").attr("action","ServletInforme?accion=ACTUALIZAR");
		id_registrar.submit();
	})
// 	$(".btn-warning").click(function(){
// 		$("#id_registrar").attr("action","ServletInforme?accion=ELIMINAR");
// 		id_registrar.submit();
// 	})
	$(".btn-success").click(function(){
		window.location.href='listaInformeTecnico.jsp';
	})
	
	$("#idestado").val($("#idEstado").val());
	</script>
	
  	
  <script>    
	  $('#id_registrar').validate({
	    rules: {
	    	codigo:{
	    		required:true,
	    	},
	    	introduccion:{
	    		required:true,
	    		pattern:'[a-zA-Z\\s\\Ñ\\ñ]{1,200}'
	    	},
	    	antecedentes:{
	    		required:true,
	    		pattern:'[a-zA-Z\\s\\Ñ\\ñ]{1,200}'
	    	},
	    	analisis:{
	    		required:true,
	    		pattern:'[a-zA-Z\\s\\Ñ\\ñ]{1,200}'
	    	},
	    	conclusiones:{
	    		required:true,
	    		pattern:'[a-zA-Z\\s\\Ñ\\ñ]{1,200}'
	    	},
	    	recomendaciones:{
	    		required:true,
	    		pattern:'[a-zA-Z\\s\\Ñ\\ñ]{1,200}'
	    	},
	    	estado:{
	    		required:true
	    		
	    	}
	    },
	    messages:{
	    	
	    	codigo:{
	    		required:'Ingresar nombre',
	    	},
	    	introduccion:{
	    		required:'Ingresar nombre',
	    		pattern:'Campo descripcion solo letras'
	    	},
	    	antecedentes:{
	    		required:'ingresar apellido',
	    		pattern:'Campo origen solo letras'
	    	},
	    	analisis:{
	    		required:'ingresar edad',
	    		pattern:'Campo area solo letras'
	    	
	    	},
	    	conclusiones:{
	    		required:'Ingresar nombre',
	    		pattern:'Campo descripcion solo letras'
	    	},
	    	recomendaciones:{
	    		required:'Ingresar recomendacion',
	    		pattern:'Campo recomendacion solo letras'
	    	},
	    	estado:{
	    		required:'ingresar estado'
	    	}
	    },
	    errorElement: 'span',
	    errorPlacement: function (error, element) {
	        error.addClass('invalid-feedback');
	        element.closest('.form-group').append(error);
	    },
	    highlight: function (element, errorClass, validClass) {
	        $(element).addClass('is-invalid');
	    },
	    unhighlight: function (element, errorClass, validClass) {
	        $(element).removeClass('is-invalid');
	    },
	})
	</script>				
</body>
</html>