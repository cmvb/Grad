/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cmvb.gradash.rest;

import com.cmvb.gradash.dto.TbUsuarioDto;
import com.cmvb.gradash.entidades.TbUsuario;
import com.cmvb.gradash.serviciosImpl.SeguridadServicioImpl;
import com.cmvb.gradash.serviciosImpl.UsuariosServicioImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 *
 * @author veracm
 */
@Path("/RestServices")
public class RestController implements Serializable, IRestController {

    private static final long serialVersionUID = 2675228724826879643L;
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(RestController.class);

    @PostConstruct
    public void init() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Autowired
    private static final UsuariosServicioImpl usuarioSB = new UsuariosServicioImpl();
    @Autowired
    private static final SeguridadServicioImpl seguridadSB = new SeguridadServicioImpl();

    @GET //Indicamos que este método se ejecutará al recibir una petición por get
    @Path("/findAllUsuarios")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @CrossOrigin
    @Override
    public List<TbUsuario> findAllUsuarios() {
        try {
            return usuarioSB.findAllUsuarios();
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
    }

    @POST
    @Path("/login")
    @Consumes({MediaType.APPLICATION_JSON}) // -->recibir json
    @Produces({MediaType.APPLICATION_JSON}) // -->regresar json
    @Override
    public TbUsuarioDto login(@RequestBody String Json) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            TbUsuarioDto dto = mapper.readValue(Json, TbUsuarioDto.class);

            return seguridadSB.login(dto.getUsuario(), dto.getClave());
        } catch (Exception e) {
            LOG.error(e.getMessage());
            return null;
        }
    }
}
