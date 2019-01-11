package com.cmvb.gradash.rest;

import com.cmvb.gradash.dto.TbUsuarioDto;
import com.cmvb.gradash.entidades.TbUsuario;
import java.io.Serializable;
import java.util.List;

public interface IRestController extends Serializable {

    /**
     *
     * Servicio REST que devuelve una lista de usuarios
     *
     * @Autor Carlos.Vera
     *
     * @return List<>
     *
     */
    List<TbUsuario> findAllUsuarios();

    /**
     *
     * Servicio REST que loguea en el sistema
     *
     * @param Json
     * @Autor Carlos.Vera
     *
     * @return TbUsuarioDto
     *
     */
    TbUsuarioDto login(String Json);
}
