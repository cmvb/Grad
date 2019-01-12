/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  veracm
 * Created: 3/01/2019
 */

/*TABLA TB_CONSECUTIVO*/
CREATE TABLE gradash.tb_consecutivo (
	con_id_consecutivo bigint NOT NULL,
	con_tabla varchar(30) NOT NULL,
	secuencia bigint NOT NULL DEFAULT 0,
	CONSTRAINT consecutivo_pk PRIMARY KEY (con_id_consecutivo),
	CONSTRAINT consecutivo_un UNIQUE (con_tabla)
);
ALTER TABLE gradash.tb_consecutivo RENAME COLUMN secuencia TO con_secuencia;

/*TABLA TB_USUARIO*/
CREATE TABLE gradash.tb_usuario (
	usu_id_usuario bigint NOT NULL,
	usu_usuario varchar(20) NOT NULL,
	usu_clave varchar(20) NOT NULL,
	usu_tipo_documento smallint NOT NULL,
	usu_numero_documento varchar(15) NOT NULL,
	usu_primer_nombre varchar(20) NOT NULL,
	usu_segundo_nombre varchar(20) NULL,
	usu_primer_apellido varchar(20) NOT NULL,
	usu_segundo_apellido varchar(20) NULL,
	usu_sexo smallint NOT NULL,
	estado smallint NOT NULL DEFAULT 1,
	fecha_creacion timestamp NOT NULL,
	usuario_creacion varchar(10) NOT NULL,
	fecha_actualiza timestamp NOT NULL,
	usuario_actualiza varchar(10) NOT NULL,
	CONSTRAINT tb_usuario_pk PRIMARY KEY (usu_id_usuario)
);
ALTER TABLE gradash.tb_usuario ADD CONSTRAINT tb_usuario_un_usuario UNIQUE (usu_usuario);
ALTER TABLE gradash.tb_usuario ADD CONSTRAINT tb_usuario_un_clave UNIQUE (usu_clave);
ALTER TABLE gradash.tb_usuario ADD CONSTRAINT tb_usuario_un_num_documento UNIQUE (usu_numero_documento);
ALTER TABLE gradash.tb_usuario ALTER COLUMN usu_sexo TYPE smallint USING usu_sexo::smallint;
ALTER TABLE gradash.tb_usuario ALTER COLUMN usu_tipo_documento TYPE smallint USING usu_tipo_documento::smallint;
ALTER TABLE gradash.tb_usuario ALTER COLUMN estado TYPE smallint USING estado::smallint;
ALTER TABLE gradash.tb_usuario ALTER COLUMN usuario_creacion TYPE varchar(20) USING usuario_creacion::varchar;
ALTER TABLE gradash.tb_usuario ALTER COLUMN usuario_actualiza TYPE varchar(20) USING usuario_actualiza::varchar;

/*TABLA TB_SESION*/
CREATE TABLE gradash.tb_sesion (
	ses_id_sesion bigint NOT NULL,
	ses_token_sesion varchar(50) NOT NULL,
	ses_usuario varchar(20) NOT NULL,
	ses_activo smallint NOT NULL,
	estado smallint NOT NULL DEFAULT 1,
	fecha_creacion timestamp NOT NULL,
	usuario_creacion varchar(20) NOT NULL,
	fecha_actualiza timestamp NOT NULL,
	usuario_actualiza varchar(20) NOT NULL,
	CONSTRAINT tb_sesion_pk PRIMARY KEY (ses_id_sesion),
	CONSTRAINT tb_sesion_un UNIQUE (ses_token_sesion)
);

