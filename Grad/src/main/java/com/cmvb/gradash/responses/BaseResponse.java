/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmvb.gradash.responses;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author veracm
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse implements Serializable {

    private static final long serialVersionUID = 9033846168916500832L;

    @Getter
    @Setter
    private long codigo;

    @Getter
    @Setter
    private boolean valor;

    @Getter
    @Setter
    private String descripcion;

    public BaseResponse() {
    }
}
