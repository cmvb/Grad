package com.cmvb.gradash.rest;

import com.cmvb.gradash.dto.TbUsuarioDto;
import com.cmvb.gradash.entidades.TbUsuario;
import com.cmvb.gradash.responses.BaseResponse;
import java.io.Serializable;
import java.util.List;

interface IRestController extends Serializable {

    /**
     *
     * Servicio REST que devuelve una lista de todos los usuarios
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

    /**
     *
     * Servicio REST que devuelve una lista de usuarios filtradaa
     *
     * @param Json
     * @Autor Carlos.Vera
     *
     * @return TbUsuarioDto
     *
     */
    List<TbUsuario> getUsuarios(String Json);

    /**
     *
     * Servicio REST que guarda:crea/actualiza un usuario
     *
     * @param Json
     * @Autor Carlos.Vera
     *
     * @return BaseResponse
     *
     */
    BaseResponse saveUpdateUsuario(String Json);

    /**
     *
     * Servicio REST que borra un usuario
     *
     * @param usuario
     * @Autor Carlos.Vera
     *
     * @return BaseResponse
     *
     */
    BaseResponse deleteUsuario(String usuario);
}
