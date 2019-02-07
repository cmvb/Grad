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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@NamedQuery(name = "TbClub.findAll", query = "SELECT t FROM TbClub t")
@Table(name = "tb_club", schema = SCHEMA_BD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TbClub extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -76135262284740730L;

    @Id
    @NotNull
    @GeneratedValue
    @Getter
    @Setter
    @Column(name = "club_id_club")
    private long idClub;

    @NotNull
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "club_id_pais")
    private TbPais pais;

    @NotNull
    @Getter
    @Setter
    @Column(name = "club_nombre_club")
    private String nombreClub;

    @NotNull
    @Getter
    @Setter
    @Column(name = "club_cantidad_copas")
    private long cantidadCopas;

    @NotNull
    @Getter
    @Setter
    @Column(name = "club_mejor_participacion")
    private String mejorParticipacion;

    public TbClub() {

    }
}
