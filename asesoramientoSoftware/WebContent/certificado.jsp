<jsp:include page="menu.jsp"/>
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
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css"/>

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
  		<form method="post" action="ServletCertificado?accion=REGISTRAR" method="post" id="id_registrar" enctype="multipart/form-data">
			<div class="container mt-3">
				<h2>Custom File</h2>
				<p>To create a custom file upload, wrap a container element with
					a class of .custom-file around the input with type="file". Then add
					the .custom-file-input to the file input:</p>


					<p>Default file:</p>
					<input type="file" id="myFile" name="documento">

					<table id="table_id" class="table-bordered">
			</div>
			    <thead>
			        <tr>
			            <th>Fecha y hora</th>
			            <th>Ubicacion</th>
			            <th>Nombre de archivo</th>
			            <th></th>
			           
			        </tr>
			    </thead>
			    <tbody>
			    
			        
			    </tbody>
			</table>

					<div class="mt-3">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
					
					
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
	
		<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	
		<script src="js/jquery.dataTables.min.js"></script>
	
	
	<script>
	$(".btn-success").click(function(){
		window.location.href='lista.jsp';
	})
	</script>
  	
  	<script>
	// Add the following code if you want the name of the file appear on select
	$(".custom-file-input").on("change", function() {
 	 var fileName = $(this).val().split("\\").pop();
 	 $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
	});
</script>

	<script type="text/javascript">
$(document).ready( function () {
	tabla();
    //$('#table_id').DataTable();
} );
$(".btn-primary").click(function(){
	window.location.href="certifcado.jsp";
})

function tabla(){
		$.getJSON("ServletRequerimiento",{accion:"LISTAR"},function(response){
			//bucle para realizar recorrido sobre response
			$.each(response,function(index,item){
				var editar= "<a href='ServletRequerimiento?accion=BUSCAR&codigo="+item.codigo+"'>Editar</a>"
				
				$("#table_id").append("<tr><td>"+item.codigo +"</td><td>"+
												item.descripcion+"</td><td>"+
												item.origen +"</td><td>"+
												item.area +"</td><td>"+
												item.criticidad +"</td><td>"+
												item.estado +"</td><td>"+editar+"</td></tr>")
			});
			$('#table_id').DataTable();
		})		
	}

</script>
</body>
</html>