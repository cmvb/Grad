package com.cmvb.gradash.dto;

import com.cmvb.gradash.entidades.TbSesion;
import com.cmvb.gradash.util.Util;

import java.io.Serializable;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class TbUsuarioDto implements Serializable {

    private static final long serialVersionUID = 3094307423236865775L;

    @Getter
    @Setter
    private long idUsuario;

    @Getter
    @Setter
    private String usuario;

    @Getter
    @Setter
    private String clave;

    @Getter
    @Setter
    private short tipoDocumento;

    @Getter
    @Setter
    private String numeroDocumento;

    @Getter
    @Setter
    private String primerNombre;

    @Getter
    @Setter
    private String segundoNombre;

    @Getter
    @Setter
    private String primerApellido;

    @Getter
    @Setter
    private String segundoApellido;

    @Getter
    @Setter
    private short sexo;

    @Getter
    @Setter
    private boolean administrador;

    @Getter
    @Setter
    private String tokenSesion;

    @Getter
    @Setter
    private TbSesion tbSesion;

    @Getter
    @Setter
    private String mensajeErrorSesion;

    @Getter
    @Setter
    private short estado;

    @Getter
    @Setter
    private String usuarioCreacion;

    @Getter
    @Setter
    private Date fechaCreacion;

    @Getter
    @Setter
    private String usuarioActualiza;

    @Getter
    @Setter
    private Date fechaActualiza;

    public TbUsuarioDto() {
    }

    public String getNombreCompleto() {
        String nombre = "";
        if (!Util.esVacio(this.primerNombre)) {
            nombre = nombre + this.primerNombre;
        }
        if (!Util.esVacio(this.segundoNombre)) {
            nombre = nombre + this.segundoNombre;
        }
        if (!Util.esVacio(this.primerApellido)) {
            nombre = nombre + this.primerApellido;
        }
        if (!Util.esVacio(this.segundoApellido)) {
            nombre = nombre + this.segundoApellido;
        }
        return nombre;
    }

}
