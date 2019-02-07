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
@NamedQuery(name = "TbJugador.findAll", query = "SELECT t FROM TbJugador t")
@Table(name = "tb_jugador", schema = SCHEMA_BD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TbJugador extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -63070878092590056L;

    @Id
    @NotNull
    @GeneratedValue
    @Getter
    @Setter
    @Column(name = "jug_id_jugador")
    private long idJugador;

    @NotNull
    @Getter
    @Setter
    @Column(name = "jug_numero_jugador")
    private long numeroJugador;

    @NotNull
    @Getter
    @Setter
    @Column(name = "jug_nombre_jugador")
    private String nombreJugador;

    @NotNull
    @Getter
    @Setter
    @Column(name = "jug_apellido_jugador")
    private String nombreApellido;

    @NotNull
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "jug_id_pais")
    private TbPais pais;

    @NotNull
    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "jug_id_club")
    private TbClub club;

    @Getter
    @Setter
    @Column(name = "jug_lesionado")
    private Short lesionado;

    @Getter
    @Setter
    @Column(name = "jug_sancionado_pais")
    private Short sancionadoPais;

    @Getter
    @Setter
    @Column(name = "jug_sancionado_club")
    private Short sancionadoClub;

    @NotNull
    @Getter
    @Setter
    @Column(name = "jug_posicion")
    private short posicion;

    @NotNull
    @Getter
    @Setter
    @Column(name = "jug_habilidad_pie")
    private short habilidadPie;

    public TbJugador() {

    }
}
