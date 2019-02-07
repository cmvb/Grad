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
@NamedQuery(name = "TbPais.findAll", query = "SELECT t FROM TbPais t")
@Table(name = "tb_pais", schema = SCHEMA_BD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TbPais extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -4069198804715772228L;

    @Id
    @NotNull
    @GeneratedValue
    @Getter
    @Setter
    @Column(name = "pais_id_pais")
    private long idPais;

    @NotNull
    @Getter
    @Setter
    @Column(name = "pais_nombre_pais")
    private String nombrePais;

    @NotNull
    @Getter
    @Setter
    @Column(name = "pais_cantidad_copas")
    private long cantidadCopas;

    @NotNull
    @Getter
    @Setter
    @Column(name = "pais_mejor_participacion")
    private String mejorParticipacion;

    public TbPais() {

    }
}
