package com.cmvb.gradash.servicios;

import com.cmvb.gradash.entidades.TbUsuario;
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

}
