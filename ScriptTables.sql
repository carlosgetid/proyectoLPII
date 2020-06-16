use bdentidades;

-- Tabla de Certificado Presupuestal 
create table cerficado_presupuestal(
cod_cert int (5) not null auto_increment, 
num_doc int (10) not null,
num_memo int (10) not null,
PRIMARY KEY (cod_cert)
)ENGINE=InnoDB;

-- Tabla de Software
create table Software(
cod_sof int (10) not null auto_increment, 
nom_sof varchar (30) not null,
ver_sof varchar (30) not null,
PRIMARY KEY (cod_sof)
)ENGINE=InnoDB;

-- Tabla de Solicitud de Certificado Presupuestal
create table Solicitud_certificado_pres(
num_sol int  not null auto_increment, 
fec_sol date not null,
mon_sol decimal (10,2) not null,
cod_resp int (10) not null,
nom_resp varchar (30) not null,
ape_resp varchar (30) not null,
dni  int (8) not null,
departamento varchar (30) not null,
cargo varchar (30) not null,
PRIMARY KEY (num_sol)
)ENGINE=InnoDB;

-- Tabla de Informe Técnico
create table Informe_tecnico(
codigo int (10) not null auto_increment, 
introduccion varchar (50) not null,
antecedente varchar (50) not null,
analisis varchar (40) not null,
conclusiones varchar (40) not null,
recomendaciones varchar (30) not null,
estado_informe int (10) not null,
PRIMARY KEY (codigo)
)ENGINE=InnoDB;

-- Tabla de Proveedor
create table proveedor(
codigo int (10) not null auto_increment, 
Razon_social varchar (40) not null,
direccion varchar (50) not null,
PRIMARY KEY (codigo)
)ENGINE=InnoDB;

-- Tabla Detalle de Cotización del Proveedor
create table Detalle_Cotizacion_Proveedor(
Cotizacion_Proveedor decimal (10,2) not null,
Fecha date not null,
cod_cot int (10),
constraint cod_cot foreign key (cod_cot) references Cotizacion (cod_cot)
)ENGINE=InnoDB;

-- Tabla de Cotización
create table Cotizacion(
cod_cot int (10) not null auto_increment, 
calificacion int (10) not null,
primary key (cod_cot)
)ENGINE=InnoDB;

-- Tabla Informe de Instalación 
create table informe_instalacion(
cod_inf int (10) not null auto_increment, 
nombre varchar (30) not null,
dni int (8) not null,
apellido varchar(30) not null,
telefono int (9) not null,
lugar_instalacion varchar (45) not null,
area_laboral int (15) not null,
fecha date not null,
estado int (10) not null,
PRIMARY KEY (cod_inf)
)ENGINE=InnoDB;

-- Tabla de Solicitud de Requerimiento de Software
create table solicitud_requerimiento_software(
cod_sol int (10) not null auto_increment, 
descripcion varchar (40) not null,
justificacion varchar (35) not null,
areas varchar (15) not null,
criticidad int (10) not null,
imagen varchar (15) not null,
fecha date not null,
PRIMARY KEY (cod_sol)
)ENGINE=InnoDB;