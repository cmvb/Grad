package com.cmvb.gradash.servicios;

import com.cmvb.gradash.dto.TbUsuarioDto;
import com.cmvb.gradash.entidades.TbSesion;
import java.io.Serializable;

public interface ISeguridadServicio extends Serializable {

    /**
     *
     * Servicio realiza el logueo en la aplicacion
     *
     * @param usuario
     * @param clave
     * @throws java.lang.Exception
     *
     * @Autor Carlos.Vera
     *
     * @return TbUsuarioDto
     *
     */
    public TbUsuarioDto login(String usuario, String clave) throws Exception;

    /**
     *
     * Servicio Genera la entidad de sesion para el aplicativo con su token
     *
     * @param usuario
     * @param token
     * @throws java.lang.Exception
     *
     * @Autor Carlos.Vera
     *
     * @return TbSesion
     *
     */
    public TbSesion obtenerSesion(String usuario, String token) throws Exception;

    /**
     *
     * Servicio que cierra la sesión actual e inactiva el token
     *
     * @param sesion
     * @param usuario
     * @throws java.lang.Exception
     *
     * @Autor Carlos.Vera
     *
     * @return long
     *
     */
    public boolean cerrarSesion(TbSesion sesion, String usuario) throws Exception;

}
