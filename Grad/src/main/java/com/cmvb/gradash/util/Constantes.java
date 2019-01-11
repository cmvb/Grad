/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmvb.gradash.util;

import java.io.Serializable;

/**
 *
 * @author veracm
 */
public class Constantes implements Serializable {

    private static final long serialVersionUID = 721762626659936371L;

    public static final String SCHEMA_BD = "gradash";
    public static final String CONTEXTO_WEB = "Grad";
    public static final String NOMBRE_ATRIBUTO_REGISTRO_ACTIVO = "activo";
    public static final String COLUMNA_ID = "id";
    public static final String NOMBRE_ESQUEMA_GESTIONNEW = "GESTIONNEW";
    public static final String NOMBRE_ESQUEMA_MGL = "MGL_SCHEME";
    public static final String ESTADO_REGISTRO_ALIADO_ACTIVO = "Y";
    public static final String NOMBRE_ESQUEMA_GESTIONWFM = "GESTIONWFM";
    public static final String ESTADO_REGISTRO_TECNICO_ACTIVO = "A";
    public static final Long ID_VACIO = 0L;
    public static final String ID_VACIO_STRING = "0";
    public static final String FORMATO_FILTRO_LIKE = "%%%s%%";
    public static final Long ID_PAIS = 1L;

    private Constantes() {
        throw new AssertionError();
    }
}
