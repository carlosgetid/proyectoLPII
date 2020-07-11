create database asesoramiento_ml;
use asesoramiento_ml;


CREATE TABLE `tb_menu` (
  `cod_men` int(11) NOT NULL AUTO_INCREMENT,
  `des_men` varchar(30) DEFAULT NULL,
  `url_men` varchar(400) DEFAULT NULL,
  PRIMARY KEY (`cod_men`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


CREATE TABLE `tb_usuario` (
  `cod_usu` int(11) NOT NULL AUTO_INCREMENT,
  `log_usu` varchar(15) DEFAULT NULL,
  `pas_usu` varchar(15) DEFAULT NULL,
  `nom_usu` varchar(30) DEFAULT NULL,
  `ape_usu` varchar(50) DEFAULT NULL,
  `eda_usu` smallint(6) DEFAULT NULL,
  `est_usu` char(1) DEFAULT NULL,
  PRIMARY KEY (`cod_usu`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


CREATE TABLE `tb_acceso` (
  `cod_men` int(11) NOT NULL,
  `cod_usu` int(11) NOT NULL,
  PRIMARY KEY (`cod_men`,`cod_usu`),
  KEY `cod_usu` (`cod_usu`),
  CONSTRAINT `tb_acceso_ibfk_1` FOREIGN KEY (`cod_men`) REFERENCES `tb_menu` (`cod_men`),
  CONSTRAINT `tb_acceso_ibfk_2` FOREIGN KEY (`cod_usu`) REFERENCES `tb_usuario` (`cod_usu`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE `tb_requerimiento` (
  `cod_req` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion_req` varchar(200) DEFAULT NULL,
  `origen_req` varchar(200) DEFAULT NULL,
  `area_req` varchar(25) DEFAULT NULL,
  `criticidad_req` varchar(25) DEFAULT NULL,
  `estado_req` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`cod_req`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;


CREATE TABLE `tb_informe` (
  `cod_inf` int(11) NOT NULL AUTO_INCREMENT,
  `introduccion_inf` varchar(200) DEFAULT NULL,
  `antecedentes_inf` varchar(200) DEFAULT NULL,
  `analisis_inf` varchar(200) DEFAULT NULL,
  `conclusiones_inf` varchar(200) DEFAULT NULL,
  `recomendaciones_inf` varchar(200) DEFAULT NULL,
  `estado_inf` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`cod_inf`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;



create table tb_sol_certificado
(
	cod_sol_cert int primary key auto_increment,
    fec_sol_cert timestamp default current_timestamp,
    obj_sol_cert varchar(200),
    monto_sol_cert decimal(8,2),
    area_so_cert varchar(50)
);


create table tb_certificado
(
	cod_cert int primary key auto_increment,
    fec_cert timestamp default current_timestamp,
    hora_cert timestamp default current_timestamp,
    url_cert varchar(250),
    nom_cert varchar(50),
    file_cert mediumblob
);


create table tb_software
(
	cod_soft int primary key auto_increment,
    nom_soft varchar(35),
    ver_soft varchar(45),
    desc_soft varchar(200)
);

create table tb_informe_instalacion
(
	cod_info_insta int primary key auto_increment,
    nom_tec varchar(35),
    ape_tec varchar(35),
    dni_tec char(8),
    tel_tec char(9),
    lug_insta varchar(150),
    area_lab_ varchar(150),
    fec_insta timestamp default current_timestamp,
    hora_insta timestamp default current_timestamp
);
