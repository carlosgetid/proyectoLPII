create database asesoramiento_ml;
use asesoramiento_ml;
create table tb_requerimiento
(
 cod_req int primary key auto_increment,
 descripcion_req varchar(200),
 origen_req varchar(200),
 area_req varchar(25),
 criticidad_req varchar(25),
 estado_req varchar(25)
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
    hora_insta time
);