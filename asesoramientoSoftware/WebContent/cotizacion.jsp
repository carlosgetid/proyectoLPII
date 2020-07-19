<jsp:include page="menu.jsp"/>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>

<link rel="stylesheet" href="css/bootstrapValidator.css"/>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<title>COTIZACION</title>

</head>
<body>
	<div class="container">
			<div class="modal-dialog" style="width: 100%">
			<form id="idRegistra" accept-charset="UTF-8" class="form-inline" method="post" action="ServletCotizacion?accion=REGISTRAR_COTIZACION" style="width: 100%">	
				<div class="modal-content">
					<div class="modal-header" style="padding: 5px 20px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>Cotizacion</h4>
					</div>
				
				<div class="modal-body" style="padding: 20px 10px;">
				Codigo Cotizacion: <input class="form-control" name="numero"/>
					
		                    <div class="panel panel-default">
		                            <div class="panel-heading" style="text-align: center;font-size: 14px">
		                               PROVEEDOR
		                            </div>
	
		                                <div class="panel-body">
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">RUC</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idCodigo" name="codigo" readonly="readonly"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idNombre" name="nombre" readonly="readonly"/>
		                                        </div>
		                                    </div>
		                                    <button type="button" data-toggle='modal'  
												class='btn btn-primary' id="idModalAlumno" >Buscar Proveedor</button>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Apellido</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idApellido" name="apellidoAlumno" readonly="readonly" />
		                                        </div>
		                                    </div>
		                           
		                  		</div>
		                  </div>	
		                  
		                  <div class="panel panel-default">
		                            <div class="panel-heading" style="text-align: center;font-size: 14px">
		                               SOFTWARE
		                            </div>
		                                <div class="panel-body">
		                               
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Codigo</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idCodigoSoftware" name="codigo" readonly="readonly"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idNombreSoftware" readonly="readonly"/>
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                    	<div class="col-lg-5">
				                                    <button type="button" data-toggle='modal' 
														class='btn btn-primary' id="idModalConcepto" >Buscar Software</button>
												</div>		
											</div><p>		
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Precio</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idPrecio" readonly="readonly" />
		                                        </div>
		                                    </div>
		                                    <div class="form-group">
		                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Cantidad</label>
		                                        <div class="col-lg-5">
													<input class="form-control" id="idCantidad"/>
		                                        </div>
		                                    </div>
		                                     <div class="form-group">
		                                     	<div class="col-lg-5">
				                                    <button type="button" data-toggle='modal' 
														class='btn btn-primary' id="btnAdicionar" >Adicionar</button>
												</div>		
											</div>	
		                              
		                  		</div>
		                  </div>	
		                  
		                   <div class="panel panel-default">
		                            <div class="panel-heading" style="text-align: center;font-size: 14px">
		                               DETALLE
		                            </div>
		                                <div class="panel-body">
		                                	<div id="divDetalle">
						 								<table id="id_tableDetalle" class="table table-striped table-bordered" >
																<thead>
																		<tr>
																			<th>Codigo</th>
																			<th>Nombre</th>
																			<th>Precio</th>
																			<th>Cantidad</th>
																			<th>Importe</th>
																		</tr>
																</thead>
																<tbody>
																<thead>
																<tr>
																<td colspan="5" style ="text-align: right;"><span id="idTotal"></span></td>
																</tr>
																</thead>
																</tbody>
															</table>											
													</div>
		                  				</div>
		                  				<div class="modal-footer" style="padding: 5px 20px; text-align:center">
											<button type="submit" class="btn btn-primary">Registrar Cotizacion</button>
										</div>
		                  </div>	
		            
				 		</div>
				 	</div>
				 	</form>
				 </div>              	               
	</div>
	
	<!-- INICIO DIV CONSULTA PROVEEDOR -->
	 <div class="modal fade" id="idModalBuscarAlumno">
				<div class="modal-dialog" style="width: 50%">
					<!-- Modal content-->
					<div class="modal-content">
					<div class="modal-header" style="padding: 5px 20px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>Buscar Proveedor</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="idRegistra" accept-charset="UTF-8"  class="form-inline"
								 method="post">						
			                    <div class="panel-group" id="steps">
			                        <!-- Step 1 -->
			                        <div class="panel panel-default">
			                            <div class="panel-heading" style="text-align: center;font-size: 14px">
			                               
			                            </div>
			                                <div class="panel-body">
			                                    <div class="form-group">
			                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Apellido</label>
			                                        <div class="col-lg-5">
														<input class="form-control" id="idBuscarApellido"/>
			                                        </div>
			                                    </div>
			                                
												<button type="button" class="btn btn-primary" id="btnBuscarAlumno">Buscar</button><p>
											
													<div id="divAlumno">
						 								<table id="id_tableAlumno" class="table table-striped table-bordered" >
																<thead>
																		<tr>
																			<th>Codigo</th>
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
			                                </div>		                        
			                  		</div>
			                  </div>
			            </form>      
					</div>
				</div>
			</div>
	  </div>
	<!-- FIN DIV CONSULTA ALUMNO -->

	<!-- INICIO DIV CONSULTA CONCEPTO -->
	 <div class="modal fade" id="idModalBuscarConcepto" >
				<div class="modal-dialog" style="width: 50%">
					<!-- Modal content-->
					<div class="modal-content">
					<div class="modal-header" style="padding: 5px 20px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>Buscar Software</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="idRegistra" accept-charset="UTF-8" class="form-inline"
								 method="post">						
			                    <div class="panel-group" id="steps">
			                        <!-- Step 1 -->
			                        <div class="panel panel-default">
			                            <div class="panel-heading" style="text-align: center;font-size: 14px">
			                               
			                            </div>
			                                <div class="panel-body">
			                                    <div class="form-group">
			                                        <label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
			                                        <div class="col-lg-5">
														<input class="form-control" id="idNombreConcepto"/>
			                                        </div>
			                                    </div>
			                                
												<button type="button" class="btn btn-primary" id="btnBuscarConcepto">Buscar</button><p>
											
													<div id="divConcepto">
						 								<table id="id_tableConcepto" class="table table-striped table-bordered" >
																<thead>
																		<tr>
																			<th>Codigo</th>
																			<th>Nombre</th>
																			<th>Precio</th>
																			<th></th>
																		</tr>
																</thead>
																<tbody>
																
																</tbody>
															</table>											
													</div>
			                                </div>		                        
			                  		</div>
			                  </div>
			            </form>      
					</div>
				</div>
			</div>
	  </div>
	<!-- FIN DIV CONSULTA CONCEPTO -->
	<script>
	
		$("#idModalAlumno").click(function(){
			
			$("#idModalBuscarAlumno").modal("show");
		})
		
		$("#idModalConcepto").click(function(){
			
			$("#idModalBuscarConcepto").modal("show");
		})
		
		$("#btnBuscarAlumno").click(function(){
			
			var ape;
			ape=$("#idBuscarApellido").val();
			
			$("#id_tableAlumno tbody").empty();
			$.getJSON("ServletCotizacion",{accion:"CONSULTA_PROVEEDOR",apellido:ape},function(response){
				
				$.each(response,function(index,item){
					//adicionar tabla
					$("#id_tableAlumno").append("<tr><td>"+item.codigo+"</td><td>"+
															item.nombre+"</td><td>"+
															item.apellido+"</td><td>"+
															item.telefono+"</td><td>"+
															item.email+"</td><td>"+
															"<button type='button' class='btn btn-primary' id='btnDatosProveedor'>Ver Datos</button></td></tr>");
				})
				
			})
		})
		
		$(document).on("click","#btnDatosProveedor",function(){
			var cod,nom,ape;
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			nom=$(this).parents("tr").find("td")[1].innerHTML;
			ape=$(this).parents("tr").find("td")[2].innerHTML;
			
			$("#idCodigo").val(cod);
			$("#idNombre").val(nom);
			$("#idApellido").val(ape);
			
			$("#idModalBuscarAlumno").modal("hide");
			
		})
		
		
		$("#btnBuscarConcepto").click(function(){
			
			var nom;
			nom=$("#idNombreConcepto").val();
			
			$("#id_tableConcepto tbody").empty();
			$.getJSON("ServletCotizacion",{accion:"CONSULTA_SOFTWARE",nombre:nom},function(response){
				
				$.each(response,function(index,item){
					//adicionar tabla
					$("#id_tableConcepto").append("<tr><td>"+item.codigo+"</td><td>"+
															item.nombre+"</td><td>"+
															item.precio+"</td><td>"+
															"<button type='button' class='btn btn-primary' id='btnDatosSoftware'>Ver Datos</button></td></tr>");
				})
				
			})
		})
		
		$(document).on("click","#btnDatosSoftware",function(){
			var cod,nom,pre;
			cod=$(this).parents("tr").find("td")[0].innerHTML;
			nom=$(this).parents("tr").find("td")[1].innerHTML;
			pre=$(this).parents("tr").find("td")[2].innerHTML;
			
			$("#idCodigoSoftware").val(cod);
			$("#idNombreSoftware").val(nom);
			$("#idPrecio").val(pre);
			
			$("#idModalBuscarConcepto").modal("hide");
			
		})
		
		
		$("#btnAdicionar").click(function(){
			
			var cod,nom,pre,can,suma=0;
			cod=$("#idCodigoSoftware").val();
			nom=$("#idNombreSoftware").val();
			pre=$("#idPrecio").val();
			can=$("#idCantidad").val();
			
			$("#id_tableDetalle tbody").empty();
			$.getJSON("ServletCotizacion",{accion:"ADICIONAR_SOFTWARE",codigo:cod,nombre:nom,precio:pre,cantidad:can},function(response){
				
				$.each(response,function(index,item){
					//suma
					suma+=item.importe;
					//adicionar tabla
					$("#id_tableDetalle").append("<tr><td>"+item.codigo+"</td><td>"+
															item.nombre+"</td><td>"+
															item.precio+"</td><td>"+
															item.cantidad+"</td><td>"+
															item.importe+"</td></tr>");
				})
				$("#idTotal").text(suma);
			})
		})
		
		
		
	</script>
</body>
</html>












