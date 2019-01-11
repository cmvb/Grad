package com.cmvb.gradash.servicios;

import java.io.Serializable;

public interface IBaseServicio extends Serializable {

    /**
     *
     * Servicio que devuelve la secuencia de la tabla y actualiza la tabla
     * tb_consecutivo
     *
     * @param tabla
     * @throws java.lang.Exception
     *
     * @Autor Carlos.Vera
     *
     * @return long
     *
     */
    public long autoID(String tabla) throws Exception;

}
