
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
 		 <form method="post" action="ServletRequerimiento?accion=REGISTRAR" id="form_registrar">
			  <div class="form-group">
			    <label for="exampleInputEmail1">Descripcion</label>
			    <input type="text" class="form-control"  name="descripcion" placeholder="Ingresar descripcion">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Origen</label>
			    <input type="text" class="form-control" name="origen" placeholder="Ingresar origen">
			  </div>
			  <div class="form-group">
			    <label for="exampleInputPassword1">Area</label>
			    <input type="text" class="form-control" name="area" placeholder="Ingresar area">
			  </div>	
			  <div class="form-group">
			    <label for="exampleFormControlSelect1">Criticidad</label>
			    <select class="form-control" name="criticidad">
			      <option>[Seleccione]</option>
			      <option value="Necesario">Necesario</option>
			      <option value="Importante">Importante</option>
			       <option value="Deseado">Deseado</option>
			    </select>
			  </div>
			  <button type="submit" class="btn btn-primary">Grabar</button>
			  <button type="button" class="btn btn-success">Listar</button>
		 </form>
 	</div> 
 		 
	<!-- JS, Popper.js, and jQuery -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>

	<!-- jQuery validation -->
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.min.js"></script>

	<script>
		$(".btn-success").click(function(){
			window.location.href='ServletDocente?accion=LISTAR';
		})
	
	</script>

	<script>    
	  $('#form_registrar').validate({
	    rules: {
	    	descripcion:{
	    		required:true,
	    		pattern:'[a-zA-Z\\s]+'
	    	},
	    	origen:{
	    		required:true
	    	},
	    	area:{
	    		required:true
	    	},
	    	criticidad:{
	    		required:true,
	    	}
	    	
	    },
	    messages:{
	    	descripcion:{
	    		required:'Nombre es un campo obligatorio',
	    		pattern:'El campo nombre acepta letras'
	    	},
	    	origen:{
	    		required:'Apellido paterno es un campo obligatorio'
	    	},
	    	area:{
	    		required:'Apellido paterno es un campo obligatorio'
	    	},
	    	criticidad:{
	    		required:'Sueldo es un campo obligatorio',
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