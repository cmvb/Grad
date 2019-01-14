/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmvb.gradash.entidades;

import static com.cmvb.gradash.util.Constantes.SCHEMA_BD;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@NamedQuery(name = "TbConsecutivo.findAll", query = "SELECT t FROM TbConsecutivo t")
@Table(name = "tb_consecutivo", schema = SCHEMA_BD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TbConsecutivo implements Serializable {

    private static final long serialVersionUID = 1640011313652512129L;

    @Id
    @NotNull
    @GeneratedValue
    @Getter
    @Setter
    @Column(name = "con_id_consecutivo")
    private long idConsecutivo;

    @NotNull
    @Getter
    @Setter
    @Column(name = "con_tabla")
    private String tabla;

    @NotNull
    @Getter
    @Setter
    @Column(name = "con_secuencia")
    private long secuencia;

    public TbConsecutivo() {
    }
}
