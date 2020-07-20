create database asesoramiento_ml;

use asesoramiento_ml;


CREATE TABLE `tb_menu` (
  `cod_men` int(11) NOT NULL AUTO_INCREMENT,
  `des_men` varchar(50) DEFAULT NULL,
  `url_men` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`cod_men`)
);


CREATE TABLE `tb_usuario` (
  `cod_usu` int(11) NOT NULL AUTO_INCREMENT,
  `log_usu` varchar(15) DEFAULT NULL,
  `pas_usu` varchar(15) DEFAULT NULL,
  `nom_usu` varchar(30) DEFAULT NULL,
  `ape_usu` varchar(50) DEFAULT NULL,
  `eda_usu` smallint(6) DEFAULT NULL,
  `est_usu` char(1) DEFAULT NULL,
  dni_usu char(8),
  tel_susu char(9),
  depa_usu varchar(50),
  cargo_usu varchar(50),
  PRIMARY KEY (`cod_usu`)
);


CREATE TABLE `tb_acceso` (
  `cod_men` int(11) NOT NULL,
  `cod_usu` int(11) NOT NULL,
  PRIMARY KEY (`cod_men`,`cod_usu`),
  KEY `cod_usu` (`cod_usu`),
  CONSTRAINT `tb_acceso_ibfk_1` FOREIGN KEY (`cod_men`) REFERENCES `tb_menu` (`cod_men`),
  CONSTRAINT `tb_acceso_ibfk_2` FOREIGN KEY (`cod_usu`) REFERENCES `tb_usuario` (`cod_usu`)
);

create table tb_estado
(
	cod_est int primary key,
    nom_est varchar(20)
);

insert into tb_estado values (1, 'Emitido');
insert into tb_estado values (2, 'Aprobado');
insert into tb_estado values (3, 'Rechazado');

CREATE TABLE `tb_requerimiento` (
  `cod_req` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_req` varchar(200) DEFAULT NULL,
  `origen_req` varchar(200) DEFAULT NULL,
  `area_req` varchar(25) DEFAULT NULL,
  `criticidad_req` varchar(25) DEFAULT NULL,
  cod_est int,
  fec_req timestamp default current_timestamp,#fecha y hora del sistema cuando se envia a la BD
	cod_usu int(11) NOT NULL,
  PRIMARY KEY (`cod_req`),
  CONSTRAINT `tb_requerimiento_ibfk_1` FOREIGN KEY (cod_est) REFERENCES `tb_estado` (cod_est),
  CONSTRAINT `tb_requerimiento_ibfk_2` FOREIGN KEY (cod_usu) REFERENCES `tb_usuario` (cod_usu)
);

CREATE TABLE `tb_informe` (
  `cod_inf` int(11) NOT NULL AUTO_INCREMENT,
  `introduccion_inf` varchar(200) DEFAULT NULL,
  `antecedentes_inf` varchar(200) DEFAULT NULL,
  `analisis_inf` varchar(200) DEFAULT NULL,
  `conclusiones_inf` varchar(200) DEFAULT NULL,
  `recomendaciones_inf` varchar(200) DEFAULT NULL,
  cod_est int,
  fec_info_tec timestamp default current_timestamp,#fecha y hora del sistema cuando se envia a la BD
  file_info_tec mediumblob,
  PRIMARY KEY (`cod_inf`),
  CONSTRAINT `tb_informe_ibfk_1` FOREIGN KEY (cod_est) REFERENCES `tb_estado` (cod_est)
);

CREATE TABLE `tb_proveedor` (
  `ruc_prov` int(11) NOT NULL,
  `nom_prov` varchar(25) DEFAULT NULL,
  `ape_prov` varchar(25) DEFAULT NULL,
  `tel_prov` varchar(9) DEFAULT NULL,
  `ema_prov` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ruc_prov`)
);



create table tb_cotizacion
(
	cod_coti int primary key auto_increment,
    cali_coti char(1),
    fec_coti timestamp default current_timestamp,#fecha y hora del sistema cuando se envia a la BD
    file_coti mediumblob
);


create table tb_detalle_coti_prov
(
	cod_coti int not null,
    ruc_prov int not null,
    fec_sub_det date,#fecha de la subida del documento
    primary key (cod_coti, ruc_prov),
	constraint foreign key fk_tb_det_cod_coti (cod_coti) references tb_cotizacion (cod_coti),
	constraint foreign key fk_tb_det_ruc_prov (ruc_prov) references tb_proveedor (ruc_prov)
);

create table tb_sol_certificado
(
	cod_sol_cert int primary key auto_increment,
    obj_sol_cert varchar(200),
    monto_sol_cert decimal(8,2),
    area_sol_cert varchar(50),
    fec_sol_cert timestamp default current_timestamp,#fecha y hora del sistema cuando se envia a la BD
    file_sol_cert mediumblob
);


create table tb_certificado
(
	cod_cert int primary key auto_increment,
    fec_sub_cert date,#fecha y hora de la subida del documento
    url_cert varchar(250),
    nom_cert varchar(50),
    file_cert mediumblob
);


create table tb_software
(
	cod_soft int primary key auto_increment,
    nom_soft varchar(35),
    ver_soft varchar(45),
    fec_soft timestamp default current_timestamp,#fecha y hora del sistema cuando se envia a la BD
    file_soft mediumblob
);

create table tb_informe_instalacion
(
	cod_info_insta int primary key auto_increment,
    lug_insta varchar(150),
    area_lab varchar(150),
    fec_insta date,#fecha del momento de la instalacion
    hora_insta time,#hora del momento de la instalacion
    fec_info_insta timestamp default current_timestamp,#fecha y hora del sistema cuando se envia a la BD
	cod_est int,
    file_info_insta mediumblob,
	CONSTRAINT `tb_informe_instalacion_ibfk_1` FOREIGN KEY (cod_est) REFERENCES `tb_estado` (cod_est)
);

#Insertando usuarios
insert into tb_usuario values (null, 'enc001', 'enc001', 'Carlos', 'Gomez', 55, 1, 87654321, 987654321, 'Producción', 'Encargado');
insert into tb_usuario values (null, 'tec001', 'tec001', 'Angelo', 'Abregu', 44, 1, 87234322, 984654333, 'IT', 'Tecnico Especialista');
insert into tb_usuario values (null, 'sub001', 'sub001', 'Lulio', 'Herrera', 33, 1, 57544325, 945624536, 'IT', 'Subgerente');
insert into tb_usuario values (null, 'log001', 'log001', 'Ronald', 'Huaman', 22, 1, 67534528, 945328143, 'SLCP', 'Asistente');
insert into tb_usuario values (null, 'pre001', 'pre001', 'Ronald', 'Chinchay', 44, 1, 47534327, 985224627, 'GPPDC', 'Gerente');

#menus
insert into tb_menu values (null, 'Generar Solicitud de Requerimiento de Software', 'requerimiento.jsp');
insert into tb_menu values (null, 'Buscar Informe de Instalación', 'listaInformeInstalacion.jsp');
insert into tb_menu values (null, 'Generar Informe Técnico', 'listaRequerimiento.jsp');
insert into tb_menu values (null, 'Generar Informe de Instalación', 'listaSoftware.jsp');
insert into tb_menu values (null, 'Aprobar Informe Técnico Registrado', 'listaInformeTecnico.jsp');
insert into tb_menu values (null, 'Registrar Cotización', 'listaInformeTecnico.jsp');
insert into tb_menu values (null, 'Generar Solicitud de Certificación Presupuestal', 'listaCotizacion.jsp');#falta crear
insert into tb_menu values (null, 'Registrar Software Adquirido', 'listaCertificado.jsp');#f alta crear
insert into tb_menu values (null, 'Registrar Certificado Presupuestal', 'listaSolicitudCertificado.jsp');#falta crear

#accesos
insert into tb_acceso values (1,1);
insert into tb_acceso values (2,1);
insert into tb_acceso values (3,2);
insert into tb_acceso values (4,2);
insert into tb_acceso values (5,3);
insert into tb_acceso values (6,4);
insert into tb_acceso values (7,4);
insert into tb_acceso values (8,4);
insert into tb_acceso values (9,5);
