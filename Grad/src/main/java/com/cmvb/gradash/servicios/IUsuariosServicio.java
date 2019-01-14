package com.cmvb.gradash.servicios;

import com.cmvb.gradash.entidades.TbUsuario;
import com.cmvb.gradash.responses.BaseResponse;
import java.io.Serializable;
import java.util.List;

public interface IUsuariosServicio extends Serializable {

    /**
     *
     * Servicio que devuelve una lista de todos los usuarios activos
     *
     * @throws java.lang.Exception
     * @Autor Carlos.Vera
     *
     * @return List<>
     *
     */
    public List<TbUsuario> findAllUsuarios() throws Exception;

    /**
     *
     * Servicio que elimina a un usuario por su ID
     *
     * @throws java.lang.Exception
     * @Autor Carlos.Vera
     * @param usuario
     *
     * @return List<>
     *
     */
    public List<TbUsuario> getUsuarios(TbUsuario usuario) throws Exception;

    /**
     *
     * Servicio que guarda:crea/actualiza un usuario
     *
     * @param usuario
     * @throws java.lang.Exception
     * @Autor Carlos.Vera
     *
     * @return BaseResponse
     *
     */
    public BaseResponse saveUpdateUsuario(TbUsuario usuario) throws Exception;

    /**
     *
     * Servicio que elimina a un usuario por su ID
     *
     * @throws java.lang.Exception
     * @Autor Carlos.Vera
     * @param usuario
     *
     * @return BaseResponse
     *
     */
    public BaseResponse deleteUsuario(TbUsuario usuario) throws Exception;

}
