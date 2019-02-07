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

/*TABLA TB_PAIS*/
CREATE TABLE gradash.tb_pais (
	pais_id_pais int8 NOT NULL,
	pais_nombre_pais varchar(20) NOT NULL,
	pais_cantidad_copas int8 NOT NULL DEFAULT 0,
	pais_mejor_participacion varchar(50) NULL,
	estado int2 NOT NULL,
	fecha_creacion timestamp NOT NULL,
	usuario_creacion varchar(20) NOT NULL,
	fecha_actualiza timestamp NOT NULL,
	usuario_actualiza varchar(20) NOT NULL,
	CONSTRAINT tb_pais_pk PRIMARY KEY (pais_id_pais)
);

/*TABLA TB_CLUB*/
CREATE TABLE gradash.tb_club (
	club_id_club int8 NOT NULL,
	club_id_pais int8 NOT NULL,
	club_nombre_club varchar(20) NOT NULL,
	club_cantidad_copas int8 NULL,
	club_mejor_participacion varchar(50) NULL,
	estado int2 NOT NULL,
	fecha_creacion varchar NOT NULL,
	usuario_creacion varchar(20) NOT NULL,
	fecha_actualiza varchar NOT NULL,
	usuario_actualiza varchar(20) NULL,
	CONSTRAINT tb_club_pk PRIMARY KEY (club_id_club),
	CONSTRAINT tb_club_tb_pais_fk FOREIGN KEY (club_id_pais) REFERENCES gradash.tb_pais(pais_id_pais)
);

/*TABLA TB_JUGADOR*/
CREATE TABLE gradash.tb_jugador (
	jug_id_jugador int8 NOT NULL,
	jug_numero_jugador int8 NOT NULL,
	jug_nombre_jugador varchar(50) NOT NULL,
	jug_apellido_jugador varchar(50) NOT NULL,
	jug_id_pais int8 NOT NULL,
	jug_id_club int8 NULL,
	jug_lesionado int2 NULL,
	jug_sancionado_club int2 NULL,
	jug_sancionado_pais int2 NULL,
	jug_posicion int2 NOT NULL,
	jug_habilidad_pie int2 NOT NULL,
	estado int2 NOT NULL,
	fecha_creacion timestamp NOT NULL,
	usuario_creacion varchar(20) NOT NULL,
	fecha_actualiza timestamp NOT NULL,
	usuario_actualiza varchar(20) NOT NULL,
	CONSTRAINT tb_jugador_pk PRIMARY KEY (jug_id_jugador),
	CONSTRAINT tb_jugador_tb_pais_fk FOREIGN KEY (jug_id_pais) REFERENCES gradash.tb_pais(pais_id_pais),
	CONSTRAINT tb_jugador_tb_club_fk FOREIGN KEY (jug_id_club) REFERENCES gradash.tb_club(club_id_club)
);

