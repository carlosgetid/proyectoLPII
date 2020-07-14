<jsp:include page="menu.jsp"/>
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
	<div class="container">
		<h1>Listado</h1>
		<button type="button" class="btn btn-primary">Nuevo</button>
	
			<table id="table_id" class="table-bordered">
			    <thead>
			        <tr>
			            <th>RUC</th>
			            <th>Nombre</th>
			            <th>Apellido</th>
			            <th>Telefono</th>
			            <th>Email</th>
			            <th></th>
			           
			        </tr>
			    </thead>
			    <tbody>
			    
			        
			    </tbody>
			</table>
			
			
			
	</div>
    
   
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="js/jquery.dataTables.min.js"></script>

<script type="text/javascript">
$(document).ready( function () {
	tabla();
    //$('#table_id').DataTable();
} );
$(".btn-primary").click(function(){
	window.location.href="proveedor.jsp";
})

function tabla(){
		$.getJSON("ServletProveedor",{accion:"LISTAR"},function(response){
			//bucle para realizar recorrido sobre response
			$.each(response,function(index,item){
				var editar= "<a href='ServletProveedor?accion=BUSCAR&codigo="+item.codigo+"'>Editar</a>"
				
				$("#table_id").append("<tr><td>"+item.codigo +"</td><td>"+
												item.nombre+"</td><td>"+
												item.apellido +"</td><td>"+
												item.telefono +"</td><td>"+
												item.email +"</td><td>"
												+editar+"</td></tr>")
			});
			$('#table_id').DataTable();
		})		
	}

</script>
</body>
</html>