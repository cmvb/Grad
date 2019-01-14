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
@NamedQuery(name = "TbUsuario.findAll", query = "SELECT t FROM TbUsuario t")
@Table(name = "tb_usuario", schema = SCHEMA_BD)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TbUsuario extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -532773761282260328L;

    @Id
    @NotNull
    @GeneratedValue
    @Getter
    @Setter
    @Column(name = "usu_id_usuario")
    private long idUsuario;

    @NotNull
    @Getter
    @Setter
    @Column(name = "usu_usuario")
    private String usuario;

    @NotNull
    @Getter
    @Setter
    @Column(name = "usu_clave")
    private String clave;

    @NotNull
    @Getter
    @Setter
    @Column(name = "usu_tipo_documento")
    private short tipoDocumento;

    @NotNull
    @Getter
    @Setter
    @Column(name = "usu_numero_documento")
    private String numeroDocumento;

    @NotNull
    @Getter
    @Setter
    @Column(name = "usu_primer_nombre")
    private String primerNombre;

    @Getter
    @Setter
    @Column(name = "usu_segundo_nombre")
    private String segundoNombre;

    @NotNull
    @Getter
    @Setter
    @Column(name = "usu_primer_apellido")
    private String primerApellido;

    @Getter
    @Setter
    @Column(name = "usu_segundo_apellido")
    private String segundoApellido;

    @NotNull
    @Getter
    @Setter
    @Column(name = "usu_sexo")
    private short sexo;

    public TbUsuario() {

    }
}
