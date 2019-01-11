/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmvb.gradash.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author veracm
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 41890806152158714L;

    @NotNull
    @Getter
    @Setter
    @Column(name = "estado")
    private short estado;

    @NotNull
    @Getter
    @Setter
    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @NotNull
    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @NotNull
    @Getter
    @Setter
    @Column(name = "usuario_actualiza")
    private String usuarioActualiza;

    @NotNull
    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_actualiza")
    private Date fechaActualiza;

    public AbstractEntity() {

    }
}
