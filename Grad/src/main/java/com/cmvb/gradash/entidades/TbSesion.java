/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmvb.gradash.entidades;

import static com.cmvb.gradash.util.Constantes.SCHEMA_BD;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author veracm
 */
@Entity
@NamedQuery(name = "TbSesion.findAll", query = "SELECT t FROM TbSesion t")
@Table(name = "tb_sesion", schema = SCHEMA_BD)
public class TbSesion extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1096825863251848107L;

    @Id
    @NotNull
    @GeneratedValue
    @Getter
    @Setter
    @Column(name = "ses_id_sesion")
    private long idSesion;

    @NotNull
    @Getter
    @Setter
    @Column(name = "ses_token_sesion")
    private String tokenSesion;

    @NotNull
    @Getter
    @Setter
    @Column(name = "ses_usuario")
    private String usuario;

    @NotNull
    @Getter
    @Setter
    @Column(name = "ses_activo")
    private short activo;

    public TbSesion() {
    }
}
