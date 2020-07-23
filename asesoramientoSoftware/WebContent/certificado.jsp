<jsp:include page="menu.jsp" />
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" />

</head>
<body>
	<c:if test="${requestScope.MENSAJE!=null}">
		<div class="alert alert-warning alert-dismissible fade show"
			role="alert">
			<strong>${requestScope.MENSAJE}</strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
	</c:if>
	<div class="container">
		<form method="post" action="ServletCertificado?accion=REGISTRAR"
			method="post" id="id_registrar" enctype="multipart/form-data">
			  		 <input type="hidden" value="${requestScope.codigoSolicCerti}" name="codigoSolicCerti">
			<div class="container mt-3">
				<h2>Custom File</h2>
				<p>To create a custom file upload, wrap a container element with
					a class of .custom-file around the input with type="file". Then add
					the .custom-file-input to the file input:</p>


				<p>Default file:</p>
				<input type="file" id="myFile" name="documento"> <input
					type="button" onclick="agregarRegistro()" id="agregar"
					class="btn btn-primary" value="Agregar">


				<table id="table_id" class="table-bordered">
					</div>
					<thead>
						<tr>
							<th>Fecha y hora</th>
							<th>Nombre de archivo</th>
							<th>Tamaño</th>
							<th></th>
						</tr>
					</thead>
					<tbody>


					</tbody>
				</table>

				<div class="mt-3">
					<button type="submit" class="btn btn-primary">Agregar</button>
				</div>
		</form>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>

	<!-- jQuery validate -->
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/jquery.validate.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.1/dist/additional-methods.min.js"></script>

	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

	<script src="js/jquery.dataTables.min.js"></script>

	<script type="text/javascript">
$(document).ready( function () {
	$('#table_id').DataTable();

} );

var datos = new Array();


			function showFileSize() {
				  let file = document.getElementById("myFile").files[0];
				  let salida = file.size; 
				  return salida;
				}
			
			
		   function capturaPath()
	       {
	           var ruta = $('#myFile').on('change',function ()
	           {
	              $(this).val();
	           });
	           return ruta.val();
	       };
	       
	       function agregarRegistro(){
	    	   var tablita = $('#table_id').DataTable();
	    	   tablita.destroy();
	    	      var url = capturaPath();
		           var archivo = url. slice(url. lastIndexOf("\\")+1);
		           var tamanio = showFileSize();
		           tamanio = tamanio/1024/1024;
		           var hoy = new Date();
		           var fecha = hoy.getDate() + '-' + ( hoy.getMonth() + 1 ) + '-' + hoy.getFullYear();
		           
					$("#table_id").append("<tr><td>"+fecha +"</td><td>"+
													archivo+"</td><td>"+
													tamanio +'</td><td><input type="button"'+
													'onclick="eliminarRegistro()" id="eliminar"'+
													' class="btn btn-primary" value="Eliminar"></td></tr>');
					$('#table_id').DataTable();

			}
	       
	       
	       function eliminarRegistro(){
				
	       };
	    	  
	       
</script>
</body>
</html>