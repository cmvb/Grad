//package com.hts.ips.publico.rest;
//
//import java.io.ByteArrayInputStream;
//import java.io.File;
//import java.io.InputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//import org.json.JSONException;
//import org.springframework.beans.BeanUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.hts.ips.datos.dtos.CtContratoActividadDto;
//import com.hts.ips.datos.dtos.CtContratoDto;
//import com.hts.ips.datos.dtos.CtContratoHabilitadoCupDto;
//import com.hts.ips.datos.dtos.CtContratoInsumoDto;
//import com.hts.ips.datos.dtos.CtContratoMedicamentoDto;
//import com.hts.ips.datos.dtos.CtInfraestructuraDto;
//import com.hts.ips.datos.dtos.CtPacienteComplementoDto;
//import com.hts.ips.datos.dtos.CtPacienteDto;
//import com.hts.ips.datos.dtos.CtProgramaServicioDto;
//import com.hts.ips.datos.dtos.CtSucursalDto;
//import com.hts.ips.datos.dtos.EntAutorizacionDetalleDto;
//import com.hts.ips.datos.dtos.EntAutorizacionEncabezadoDto;
//import com.hts.ips.datos.dtos.EntEntregaEncabezadoDto;
//import com.hts.ips.datos.dtos.EspecialidadDto;
//import com.hts.ips.datos.dtos.GrupoEspecialidadDto;
//import com.hts.ips.datos.dtos.LogMedicamentoDto;
//import com.hts.ips.datos.dtos.ModuloXPerfilDto;
//import com.hts.ips.datos.dtos.RipsResumenDto;
//import com.hts.ips.datos.dtos.ScCentroCostoDto;
//import com.hts.ips.datos.dtos.ScContabilizaDto;
//import com.hts.ips.datos.dtos.ScCuentaDto;
//import com.hts.ips.datos.dtos.ScEmpleadoDto;
//import com.hts.ips.datos.dtos.ScEmpleadoEducacionDto;
//import com.hts.ips.datos.dtos.ScEmpleadoFamiliaDto;
//import com.hts.ips.datos.dtos.ScEmpleadoLaboralDto;
//import com.hts.ips.datos.dtos.ScFacturaDetalleDto;
//import com.hts.ips.datos.dtos.ScFacturaEncabezadoDto;
//import com.hts.ips.datos.dtos.ScFacturaMedicamentoDto;
//import com.hts.ips.datos.dtos.ScFacturaPagoDto;
//import com.hts.ips.datos.dtos.ScFondoDto;
//import com.hts.ips.datos.dtos.ScFormaPagoDto;
//import com.hts.ips.datos.dtos.ScProductoDto;
//import com.hts.ips.datos.dtos.ScProfesionDto;
//import com.hts.ips.datos.dtos.ScTerceroDto;
//import com.hts.ips.datos.dtos.ScTipoFacturaDto;
//import com.hts.ips.datos.dtos.ScValorIvaDto;
//import com.hts.ips.datos.dtos.ScValorRetefuenteDto;
//import com.hts.ips.datos.dtos.ScValorReteicaDto;
//import com.hts.ips.datos.dtos.TbAseguradoraCodigoDto;
//import com.hts.ips.datos.dtos.TbAseguradoraDto;
//import com.hts.ips.datos.dtos.TbConjuntoDetalleDto;
//import com.hts.ips.datos.dtos.TbConjuntoEncabezadoDto;
//import com.hts.ips.datos.dtos.TbCuentaDto;
//import com.hts.ips.datos.dtos.TbCupDto;
//import com.hts.ips.datos.dtos.TbEmpresaDto;
//import com.hts.ips.datos.dtos.TbExamenDetalleDto;
//import com.hts.ips.datos.dtos.TbExamenEncabezadoDto;
//import com.hts.ips.datos.dtos.TbHorarioDetalleDto;
//import com.hts.ips.datos.dtos.TbHorarioEncabezadoDto;
//import com.hts.ips.datos.dtos.TbIndiceDto;
//import com.hts.ips.datos.dtos.TbInsumoDto;
//import com.hts.ips.datos.dtos.TbIpsCuentaDto;
//import com.hts.ips.datos.dtos.TbIpsDto;
//import com.hts.ips.datos.dtos.TbIssDto;
//import com.hts.ips.datos.dtos.TbLaboratorioDto;
//import com.hts.ips.datos.dtos.TbMecanismoVerificacionDto;
//import com.hts.ips.datos.dtos.TbMedicamentoDto;
//import com.hts.ips.datos.dtos.TbModuloDto;
//import com.hts.ips.datos.dtos.TbMotivoPendienteDto;
//import com.hts.ips.datos.dtos.TbMunicipioDto;
//import com.hts.ips.datos.dtos.TbPerfilDto;
//import com.hts.ips.datos.dtos.TbPeriodoReporteDto;
//import com.hts.ips.datos.dtos.TbProcesoDetalleDto;
//import com.hts.ips.datos.dtos.TbProcesoEncabezadoDto;
//import com.hts.ips.datos.dtos.TbServicioCupDto;
//import com.hts.ips.datos.dtos.TbServicioDto;
//import com.hts.ips.datos.dtos.TbSoatDto;
//import com.hts.ips.datos.dtos.TbSoatValorDto;
//import com.hts.ips.datos.dtos.TbSubmoduloDto;
//import com.hts.ips.datos.dtos.TbTipoConsultorioDto;
//import com.hts.ips.datos.dtos.TbTipoEstablecimientoDto;
//import com.hts.ips.datos.dtos.TbTipoIdentificacionDto;
//import com.hts.ips.datos.dtos.TbTipoSoporteDto;
//import com.hts.ips.datos.dtos.TbUnidadDto;
//import com.hts.ips.datos.dtos.UsuarioAccesoDto;
//import com.hts.ips.datos.dtos.UsuarioDto;
//import com.hts.ips.datos.dtos.UsuarioIpsDto;
//import com.hts.ips.datos.persistences.CtPaciente;
//import com.hts.ips.datos.persistences.CtProgramaServicio;
//import com.hts.ips.datos.persistences.LogMedicamento;
//import com.hts.ips.datos.persistences.TbEspecialidad;
//import com.hts.ips.datos.pojos.POJOAutorizacionItem;
//import com.hts.ips.datos.pojos.POJOCtContrato;
//import com.hts.ips.datos.pojos.POJOCtContratoActividad;
//import com.hts.ips.datos.pojos.POJOCtContratoInsumo;
//import com.hts.ips.datos.pojos.POJOCtContratoMedicamento;
//import com.hts.ips.datos.pojos.POJOCtInfraestructura;
//import com.hts.ips.datos.pojos.POJOCtPaciente;
//import com.hts.ips.datos.pojos.POJOCtPacienteComplemento;
//import com.hts.ips.datos.pojos.POJOCtProgramaServicio;
//import com.hts.ips.datos.pojos.POJOCtSucursal;
//import com.hts.ips.datos.pojos.POJOEmpresa;
//import com.hts.ips.datos.pojos.POJOEntAutorizacionEncabezado;
//import com.hts.ips.datos.pojos.POJOEntEntregaEncabezado;
//import com.hts.ips.datos.pojos.POJOEnums;
//import com.hts.ips.datos.pojos.POJOEspecialidad;
//import com.hts.ips.datos.pojos.POJOExcepcion;
//import com.hts.ips.datos.pojos.POJOExitoso;
//import com.hts.ips.datos.pojos.POJOFileUpload;
//import com.hts.ips.datos.pojos.POJOGrupoEspecialidad;
//import com.hts.ips.datos.pojos.POJOHorarioDetalle;
//import com.hts.ips.datos.pojos.POJOHorarioEncabezado;
//import com.hts.ips.datos.pojos.POJOHorarioEncabezadoQuery;
//import com.hts.ips.datos.pojos.POJOInformacionAutorizacion;
//import com.hts.ips.datos.pojos.POJOInformacionAutorizacionAfiliado;
//import com.hts.ips.datos.pojos.POJOModuloXPerfil;
//import com.hts.ips.datos.pojos.POJOPeriodoReporte;
//import com.hts.ips.datos.pojos.POJORipsResumen;
//import com.hts.ips.datos.pojos.POJOScCentroCosto;
//import com.hts.ips.datos.pojos.POJOScContabiliza;
//import com.hts.ips.datos.pojos.POJOScCuenta;
//import com.hts.ips.datos.pojos.POJOScEmpleado;
//import com.hts.ips.datos.pojos.POJOScEmpleadoEducacion;
//import com.hts.ips.datos.pojos.POJOScEmpleadoFamilia;
//import com.hts.ips.datos.pojos.POJOScEmpleadoLaboral;
//import com.hts.ips.datos.pojos.POJOScFacturaDetalle;
//import com.hts.ips.datos.pojos.POJOScFacturaEncabezado;
//import com.hts.ips.datos.pojos.POJOScFacturaMedicamento;
//import com.hts.ips.datos.pojos.POJOScFacturaPago;
//import com.hts.ips.datos.pojos.POJOScFondo;
//import com.hts.ips.datos.pojos.POJOScFormaPago;
//import com.hts.ips.datos.pojos.POJOScProducto;
//import com.hts.ips.datos.pojos.POJOScProfesion;
//import com.hts.ips.datos.pojos.POJOScTercero;
//import com.hts.ips.datos.pojos.POJOScTipoFactura;
//import com.hts.ips.datos.pojos.POJOScValorIva;
//import com.hts.ips.datos.pojos.POJOScValorRetefuente;
//import com.hts.ips.datos.pojos.POJOScValorReteica;
//import com.hts.ips.datos.pojos.POJOTbAseguradora;
//import com.hts.ips.datos.pojos.POJOTbAseguradoraCodigo;
//import com.hts.ips.datos.pojos.POJOTbConjuntoDetalle;
//import com.hts.ips.datos.pojos.POJOTbConjuntoEcabezado;
//import com.hts.ips.datos.pojos.POJOTbCuenta;
//import com.hts.ips.datos.pojos.POJOTbCup;
//import com.hts.ips.datos.pojos.POJOTbExamenDetalle;
//import com.hts.ips.datos.pojos.POJOTbExamenEcabezado;
//import com.hts.ips.datos.pojos.POJOTbIndice;
//import com.hts.ips.datos.pojos.POJOTbInsumo;
//import com.hts.ips.datos.pojos.POJOTbIps;
//import com.hts.ips.datos.pojos.POJOTbIpsCuenta;
//import com.hts.ips.datos.pojos.POJOTbIss;
//import com.hts.ips.datos.pojos.POJOTbLaboratorio;
//import com.hts.ips.datos.pojos.POJOTbMecanismoVerificacion;
//import com.hts.ips.datos.pojos.POJOTbMedicamento;
//import com.hts.ips.datos.pojos.POJOTbModulo;
//import com.hts.ips.datos.pojos.POJOTbMotivoPendiente;
//import com.hts.ips.datos.pojos.POJOTbMunicipio;
//import com.hts.ips.datos.pojos.POJOTbPerfil;
//import com.hts.ips.datos.pojos.POJOTbProcesoDetalle;
//import com.hts.ips.datos.pojos.POJOTbProcesoEncabezado;
//import com.hts.ips.datos.pojos.POJOTbServicio;
//import com.hts.ips.datos.pojos.POJOTbSoat;
//import com.hts.ips.datos.pojos.POJOTbSoatValor;
//import com.hts.ips.datos.pojos.POJOTbSubmodulo;
//import com.hts.ips.datos.pojos.POJOTbTipoEstablecimiento;
//import com.hts.ips.datos.pojos.POJOTbTipoIdentificacion;
//import com.hts.ips.datos.pojos.POJOTbTipoSoporte;
//import com.hts.ips.datos.pojos.POJOTbUnidad;
//import com.hts.ips.datos.pojos.POJOTipoConsultorio;
//import com.hts.ips.datos.pojos.POJOUsuario;
//import com.hts.ips.datos.pojos.POJOUsuarioIps;
//import com.hts.ips.publico.autorizacion.ws.AutorizacionItemDto;
//import com.hts.ips.publico.autorizacion.ws.InformacionAutorizacionAfiliadoDto;
//import com.hts.ips.publico.autorizacion.ws.InformacionAutorizacionDto;
//import com.hts.ips.publico.autorizacion.ws.InformacionAutorizacionWS;
//import com.hts.ips.publico.dtos.PermisoDto;
//import com.hts.ips.publico.dtos.UserDto;
//import com.hts.ips.publico.dtos.ValidacionDto;
//import com.hts.ips.publico.enumerados.EAccion;
//import com.hts.ips.publico.enumerados.EEnums;
//import com.hts.ips.publico.enumerados.EEstado;
//import com.hts.ips.publico.enumerados.EEstadoRespuestaHTTP;
//import com.hts.ips.publico.enumerados.EEstadoVigencia;
//import com.hts.ips.publico.enumerados.EMeses;
//import com.hts.ips.publico.enumerados.EProceso;
//import com.hts.ips.publico.enumerados.ESiNo;
//import com.hts.ips.publico.enumerados.ETarifaContrato;
//import com.hts.ips.publico.enumerados.ETipo;
//import com.hts.ips.publico.enumerados.ETipoAfiliadoOtro;
//import com.hts.ips.publico.enumerados.ETipoCuenta;
//import com.hts.ips.publico.enumerados.ETipoFactura;
//import com.hts.ips.publico.enumerados.ETipoJuridica;
//import com.hts.ips.publico.enumerados.ETipoMovimiento;
//import com.hts.ips.publico.enumerados.ETipoPago;
//import com.hts.ips.publico.enumerados.ETipoRegimenSalud;
//import com.hts.ips.publico.enumerados.ETipoServicioEspecialInsumo;
//import com.hts.ips.publico.enumerados.ETipoUnidad;
//import com.hts.ips.publico.enumerados.ETipoValidacion;
//import com.hts.ips.publico.enumerados.EtipoValor;
//import com.hts.ips.publico.models.Mensaje;
//import com.hts.ips.publico.services.BaseImplService;
//import com.hts.ips.publico.services.IEmailService;
//import com.hts.ips.publico.services.IFacturacionService;
//import com.hts.ips.publico.services.IMantenimientoService;
//import com.hts.ips.publico.services.IRipsService;
//import com.hts.ips.publico.utils.FileUtilities;
//import com.hts.ips.publico.utils.Util;
//
//import javolution.util.FastList;
//import javolution.util.FastMap;
//import javolution.util.FastSet;
//import javolution.util.FastTable;
//
//@Service("restServiceImpl")
//@Path("/restServices")
//public class RestService extends BaseImplService implements IRestService {
//  private static final long serialVersionUID = 985964153410401471L;
//
//  @Autowired
//  private IMantenimientoService mantenimientoService;
//
//  public IMantenimientoService getMantenimientoService() {
//    return mantenimientoService;
//  }
//
//  @Autowired
//  private InformacionAutorizacionWS informacionAutorizacionWSService;
//
//  public void setMantenimientoService(IMantenimientoService mantenimientoService) {
//    this.mantenimientoService = mantenimientoService;
//  }
//
//  public InformacionAutorizacionWS getInformacionAutorizacionWSService() {
//    return informacionAutorizacionWSService;
//  }
//
//  public void setInformacionAutorizacionWSService(InformacionAutorizacionWS informacionAutorizacionWSService) {
//    this.informacionAutorizacionWSService = informacionAutorizacionWSService;
//  }
//
//  @Autowired
//  private IEmailService emailService;
//
//  public IEmailService getEmailService() {
//    return emailService;
//  }
//
//  @Autowired
//  private IFacturacionService facturacionService;
//
//  public IFacturacionService getFacturacionService() {
//    return facturacionService;
//  }
//
//  @Autowired
//  private IRipsService ripsService;
//
//  public IRipsService getRipsService() {
//    return ripsService;
//  }
//
//  @PostConstruct
//  public void init() {
//    SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//  }
//
//  /*
//   * Para Mostrar las Excepciones
//   */
//  public Response atraparExc(short id, String msg) throws JsonProcessingException {
//    ObjectMapper mapper = new ObjectMapper();
//    POJOExcepcion excResponse = new POJOExcepcion();
//    excResponse.setStatusId(id);
//    excResponse.setStatusMsg(msg);
//
//    String jsonInString = mapper.writeValueAsString(excResponse);
//
//    return Response.ok(jsonInString).build();
//  }
//
//  /*
//   * Para Mostrar los procesos exitosos
//   */
//  public Response atraparSucces(short id, String msg) throws JsonProcessingException {
//    ObjectMapper mapper = new ObjectMapper();
//    POJOExitoso succesResponse = new POJOExitoso();
//    succesResponse.setStatusId(id);
//    succesResponse.setStatusMsg(msg);
//
//    String jsonInString = mapper.writeValueAsString(succesResponse);
//
//    return Response.ok(jsonInString).build();
//  }
//
//  /*
//   * Para realizar las validaciones de campos obligatorios
//   * 
//   */
//  private String validaciones(String path, Object obj) {
//    FastTable<ValidacionDto> validaciones = new FastTable<ValidacionDto>();
//
//    if (path.equalsIgnoreCase("saveOrUpdateOrDeleteUser")) {
//      UsuarioDto f = (UsuarioDto) obj;
//      validaciones.add(new ValidacionDto(f.getUsuario(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_pages_login_usuario"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_pages_login_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getApellido(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_pages_login_apellido"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFechaNacimiento() == null ? "" : f.getFechaNacimiento().toString(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_pages_login_fecha_naci"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("setProfile")) {
//      TbPerfilDto f = (TbPerfilDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_insumos_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteInsumo")) {
//      TbInsumoDto f = (TbInsumoDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getCodigoInterno(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_insumos_codigo_interno"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_insumos_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteModulo")) {
//      TbModuloDto f = (TbModuloDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_modulos_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_conjunto_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteSubModulo")) {
//      TbSubmoduloDto f = (TbSubmoduloDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_submodulos_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_conjunto_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteConjunto")) {
//      TbConjuntoEncabezadoDto f = (TbConjuntoEncabezadoDto) obj;
//      validaciones.add(new ValidacionDto(f.getNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_submodulos_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_conjunto_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      // validar los detalles
//      int i = 1;
//      for (TbConjuntoDetalleDto d : f.getConjuntosDetalles()) {
//        validaciones.add(new ValidacionDto(d.getNombre(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_conjunto_detalle_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(d.getValor(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_conjunto_detalle_valor"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        i++;
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteCups")) {
//      TbCupDto f = (TbCupDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCodigoInterno() == null ? "" : f.getCodigoInterno().toString(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_codigo_interno"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwPos() < 0 ? "" : String.valueOf(f.getSwPos()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_pos"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoValor() <= 0 ? "" : String.valueOf(f.getTipoValor()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_tipo_valor"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwResolucion() < 0 ? "" : String.valueOf(f.getSwResolucion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_swResolucion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSeccion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_seccion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCapitulo(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_capitulo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getGrupo(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_grupo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getResolucion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_resolucion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwCres() < 0 ? "" : String.valueOf(f.getSwCres()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_cres"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSexo() <= 0 ? "" : String.valueOf(f.getSexo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_sexo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getAmbito() <= 0 ? "" : String.valueOf(f.getAmbito()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_ambito"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwDepurado() < 0 ? "" : String.valueOf(f.getSwDepurado()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_depurado"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipo() <= 0 ? "" : String.valueOf(f.getTipo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_tipo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      // validaciones.add(new ValidacionDto(f.getInternacion() != null && f.getInternacion() > 0 ? String.valueOf(f.getInternacion()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_internacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoServicio() <= 0 ? "" : String.valueOf(f.getTipoServicio()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_tipo_servicio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValorEstandar() != null && f.getValorEstandar() > 0 ? String.valueOf(f.getValorEstandar()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_valor_estandar"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwActivo() < 0 ? "" : String.valueOf(f.getSwActivo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_activo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoResolucion() < 0 ? "" : String.valueOf(f.getTipoResolucion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_tipo_resolucion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwActivoAutorizacion() < 0 ? "" : String.valueOf(f.getSwActivoAutorizacion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_activo_autorizacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwActivoAuditoria() < 0 ? "" : String.valueOf(f.getSwActivoAuditoria()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_activo_auditoria"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getServicioEspecial() != null && f.getServicioEspecial() >= 0 ? String.valueOf(f.getServicioEspecial()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cup_servicio_especial"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteIndice")) {
//      TbIndiceDto f = (TbIndiceDto) obj;
//      validaciones.add(new ValidacionDto(f.getNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_indice_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoDato() == null ? "" : f.getTipoDato().toString(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_indice_tipo_dato"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteExamen")) {
//      TbExamenEncabezadoDto f = (TbExamenEncabezadoDto) obj;
//      validaciones.add(new ValidacionDto(f.getNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_examen_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCup() == null ? "" : f.getCup().toString(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_examen_cup"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      // validar los detalles
//      int i = 1;
//      for (TbExamenDetalleDto d : f.getExamenesDetalles()) {
//        validaciones.add(new ValidacionDto(d.getDescripcion(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_examen_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(d.getConsecutivoUnidad() == null ? "" : d.getConsecutivoUnidad().toString(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_examen_consecutivo_unidad"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(d.getValorMaximo() < 0 ? "" : String.valueOf(d.getValorMaximo()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_examen_valor_maximo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(d.getValorMinimo() < 0 ? "" : String.valueOf(d.getValorMinimo()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_examen_valor_minimo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//        i++;
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteUnidad")) {
//      TbUnidadDto f = (TbUnidadDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_unidad_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCodigoInterno(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_unidad_codigo_interno"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoUnidad() <= 0 ? "" : String.valueOf(f.getTipoUnidad()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_unidad_tipo_unidad"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteMunicipio")) {
//      TbMunicipioDto f = (TbMunicipioDto) obj;
//      validaciones.add(new ValidacionDto(f.getMunicipio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_municipio_codigo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_municipio_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCentroCosto(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_municipio_centro_costo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteLaboratorio")) {
//      TbLaboratorioDto f = (TbLaboratorioDto) obj;
//      validaciones.add(new ValidacionDto(f.getMunicipio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_laboratorio_municipio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_laboratorio_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteCentroCosto")) {
//      ScCentroCostoDto f = (ScCentroCostoDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_centro_costo_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    if (path.equalsIgnoreCase("saveOrUpdateOrDeleteTipoIdentificacion")) {
//      TbUnidadDto f = (TbUnidadDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_identificacion_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteCuenta")) {
//      ScCuentaDto f = (ScCuentaDto) obj;
//      validaciones.add(new ValidacionDto(f.getCodigo(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cuenta_codigo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cuenta_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNaturaleza() <= 0 ? "" : String.valueOf(f.getNaturaleza()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_cuenta_naturaleza"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteValorRetefuente")) {
//      ScValorRetefuenteDto f = (ScValorRetefuenteDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_retefuente_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getLeyenda(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_retefuente_leyenda"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValor() <= 0 ? "" : String.valueOf(f.getValor()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_retefuente_valor"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwActivo() < 0 ? "" : String.valueOf(f.getSwActivo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_retefuente_activo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaVenta() == null ? "" : String.valueOf(f.getCuentaVenta()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_retefuente_cuenta_venta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaCompra() == null ? "" : String.valueOf(f.getCuentaCompra()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_retefuente_cuenta_compra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaPago() == null ? "" : String.valueOf(f.getCuentaPago()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_retefuente_cuenta_pago"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoProceso() <= 0 ? "" : String.valueOf(f.getTipoProceso()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_retefuente_tipo_proceso"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteValorIva")) {
//      ScValorIvaDto f = (ScValorIvaDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iva_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getLeyenda(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iva_leyenda"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValor() < 0 ? "" : String.valueOf(f.getValor()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iva_valor"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwActivo() < 0 ? "" : String.valueOf(f.getSwActivo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iva_activo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaVenta() == null ? "" : String.valueOf(f.getCuentaVenta()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iva_cuenta_venta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaCompra() == null ? "" : String.valueOf(f.getCuentaCompra()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iva_cuenta_compra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaPago() == null ? "" : String.valueOf(f.getCuentaPago()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iva_cuenta_pago"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteFormaPago")) {
//      ScFormaPagoDto f = (ScFormaPagoDto) obj;
//      validaciones.add(new ValidacionDto(f.getCodigo(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_forma_pago_codigo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_forma_pago_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuenta() == null ? "" : String.valueOf(f.getCuenta()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_forma_pago_cuenta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipo() < 0 ? "" : String.valueOf(f.getTipo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_forma_pago_tipo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoAjuste() <= 0 ? "" : String.valueOf(f.getTipoAjuste()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_forma_pago_tipoajuste"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwPagoDefecto() < 0 ? "" : String.valueOf(f.getSwPagoDefecto()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_forma_pago_pago_defecto"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwAnticipoDefecto() < 0 ? "" : String.valueOf(f.getSwAnticipoDefecto()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_forma_pago_anticipo_defecto"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwDocumento() < 0 ? "" : String.valueOf(f.getSwDocumento()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_forma_pago_documento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteReteica")) {
//      ScValorReteicaDto f = (ScValorReteicaDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_reteica_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getLeyenda(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_reteica_leyenda"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValor() < 0 ? "" : String.valueOf(f.getValor()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_reteica_valor"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwActivo() < 0 ? "" : String.valueOf(f.getSwActivo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_reteica_activo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaVenta() == null ? "" : String.valueOf(f.getCuentaVenta()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_reteica_cuenta_venta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaCompra() == null ? "" : String.valueOf(f.getCuentaCompra()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_reteica_cuenta_compra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaPago() == null ? "" : String.valueOf(f.getCuentaPago()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_reteica_cuenta_pago"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteProducto")) {
//      ScProductoDto f = (ScProductoDto) obj;
//      validaciones.add(new ValidacionDto(f.getCodigoBarra(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_codigo_barra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getResumen(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_resumen"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCantidad() < 0 ? "" : String.valueOf(f.getCantidad()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_cantidad"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getStockMinimo() < 0 ? "" : String.valueOf(f.getStockMinimo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_stock_minimo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValorCompra() < 0 ? "" : String.valueOf(f.getValorCompra()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_valor_compra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValorVenta() < 0 ? "" : String.valueOf(f.getValorVenta()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_valor_venta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoIva() <= 0 ? "" : String.valueOf(f.getConsecutivoIva()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_iva"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaVenta() <= 0 ? "" : String.valueOf(f.getCuentaVenta()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_cuenta_venta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaCompra() <= 0 ? "" : String.valueOf(f.getCuentaCompra()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_cuenta_compra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaCliente() <= 0 ? "" : String.valueOf(f.getCuentaCliente()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_cuenta_cliente"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCuentaProveedor() <= 0 ? "" : String.valueOf(f.getCuentaProveedor()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_cuenta_proveedor"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwProducto() < 0 ? "" : String.valueOf(f.getSwProducto()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_sw_producto"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwIva() < 0 ? "" : String.valueOf(f.getSwIva()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_sw_iva"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoFacturaVenta() < 0 ? "" : String.valueOf(f.getTipoFacturaVenta()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_tipo_factura_venta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoFacturaCompra() < 0 ? "" : String.valueOf(f.getTipoFacturaCompra()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_tipo_factura_compra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwActivo() < 0 ? "" : String.valueOf(f.getSwActivo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_activo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getClaseProducto() < 0 ? "" : String.valueOf(f.getClaseProducto()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_producto_clase_producto"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteTercero")) {
//      ScTerceroDto f = (ScTerceroDto) obj;
//      validaciones.add(new ValidacionDto(f.getTipoJuridica() <= 0 ? "" : String.valueOf(f.getTipoJuridica()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_tipo_juridica"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      // valdaciones tipo natural
//      if (f.getTipoJuridica() > 0 && f.getTipoJuridica() == ETipoJuridica.NATURAL.getId()) {        
//        validaciones.add(new ValidacionDto((f.getTipoIdentificacion() == null ? "" : (f.getTipoIdentificacion() <= 0 ? "" : String.valueOf(f.getTipoIdentificacion()))), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_tipo_identificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getNroIdentificacion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_numero_identificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getDireccion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_direccion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getMunicipio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_municipio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getBarrio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_barrio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getTipo() < 0 ? "" : String.valueOf(f.getTipoRegimen()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_tipo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      }
//      else if (f.getTipoJuridica() > 0 && f.getTipoJuridica() == ETipoJuridica.JURIDICA.getId()){
//        validaciones.add(new ValidacionDto((f.getTipoIdentificacion() == null ? "" : (f.getTipoIdentificacion() <= 0 ? "" : String.valueOf(f.getTipoIdentificacion()))), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_tipo_identificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getNroIdentificacion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_numero_identificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getDireccion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_direccion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getMunicipio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_municipio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getBarrio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_barrio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getTipo() < 0 ? "" : String.valueOf(f.getTipoRegimen()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_tipo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getDigitoVerificacion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_digito_verificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getRazonSocial(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_razon_social"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(f.getTipoRegimen() < 0 ? "" : String.valueOf(f.getTipoRegimen()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tercero_tipo_regimen"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      }      
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteMecanismoVerificacion")) {
//      TbMecanismoVerificacionDto f = (TbMecanismoVerificacionDto) obj;
//      validaciones.add(new ValidacionDto(f.getCodigo(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_mecanismo_verificacion_codigo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_mecanismo_verificacion_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteSucursal")) {
//      CtSucursalDto f = (CtSucursalDto) obj;
//      validaciones.add(new ValidacionDto(f.getRazonSocial(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_razon_social"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCodigoPrestador(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_codigo_prestador"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCodigoInterno(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_codigo_interno"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNit(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_nit"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDigitoVerificacion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_digito_verificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDireccion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_direccion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getMunicipio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_municipio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoMecanismo() == null ? "" : String.valueOf(f.getConsecutivoMecanismo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_mecanismo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getHabilitada() < 0 ? "" : String.valueOf(f.getHabilitada()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_habilitada"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getEstadoSucursal() < 0 ? "" : String.valueOf(f.getEstadoSucursal()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_sucursal_estado_sucursal"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteTipoFactura")) {
//      ScTipoFacturaDto f = (ScTipoFacturaDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getResolucionDian(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_resolucion_dian"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getResolucionDianEquivalente(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_resolucion_dian_equivalente"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNumeroActual() < 0 ? "" : String.valueOf(f.getNumeroActual()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_numero_actual"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNumeroInicial() < 0 ? "" : String.valueOf(f.getNumeroInicial()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_numero_inicial"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNumeroFinal() < 0 ? "" : String.valueOf(f.getNumeroFinal()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_numero_final"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNumeroActualEquivalente() < 0 ? "" : String.valueOf(f.getNumeroActualEquivalente()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_numero_actual_equivalente"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFormatoNumeracion() < 0 ? "" : String.valueOf(f.getFormatoNumeracion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_formato_numeracion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoFactura() <= 0 ? "" : String.valueOf(f.getTipoFactura()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_tipo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFechaVencimiento() == null ? "" : String.valueOf(f.getFechaVencimiento()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_factura_fecha_vencimiento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteMedicamento")) {
//      TbMedicamentoDto f = (TbMedicamentoDto) obj;
//      validaciones.add(new ValidacionDto(f.getFechaExpedicion() == null ? "" : f.getFechaExpedicion().toString(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_fecha_expedicion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFechaVencimiento() == null ? "" : f.getFechaVencimiento().toString(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_fecha_vencimiento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getExpediente(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_expediente"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getExpedienteCum(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_expediente_cum"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getProducto(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_producto"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getAtc(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_atc"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcionAtc(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_descripcion_atc"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwMuestraMedica() < 0 ? "" : String.valueOf(f.getSwMuestraMedica()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_sw_muestra_medica"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getEstadoCum() < 0 ? "" : String.valueOf(f.getEstadoCum()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_estado_cum"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getEstadoRegistro() < 0 ? "" : String.valueOf(f.getEstadoRegistro()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_estado_registro"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivo() != null && f.getConsecutivo() > 0 ? String.valueOf(f.getConsecutivo()) : "", Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_consecutivo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCantidad() <= 0 ? "" : String.valueOf(f.getCantidad()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_cantidad"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTitular() != null && f.getConsecutivo() > 0 ? String.valueOf(f.getTitular()) : "", Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_medicamento_titular"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("updatePassUser")) {
//      UsuarioDto f = (UsuarioDto) obj;
//      validaciones.add(new ValidacionDto(f.getClave(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_usuario_clave"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteAutocontabilizacion")) {
//      ScContabilizaDto f = (ScContabilizaDto) obj;
//      validaciones.add(new ValidacionDto(f.getContabiliza() <= 0 ? "" : String.valueOf(f.getContabiliza()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_reteica_valor"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      // validar el iterador
//      int i = 1;
//      for (ScContabilizaDto d : f.getAutocontabilizacionesDetalles()) {
//        validaciones.add(new ValidacionDto(d.getCuenta() <= 0 ? "" : String.valueOf(d.getCuenta()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_autocontabilizacion_cuenta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(d.getValorDebito() < 0 ? "" : String.valueOf(d.getValorDebito()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_autocontabilizacion_valor_debito"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(d.getValorCredito() < 0 ? "" : String.valueOf(d.getValorCredito()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_autocontabilizacion_valor_credito"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//        i++;
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteAseguradora")) {
//      TbAseguradoraDto f = (TbAseguradoraDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getRazonSocial(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_aseguradora_razon_social"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCorreoElectronico(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_aseguradora_correo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getContacto(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_aseguradora_contacto"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTelefono(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_aseguradora_telefono"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteContrato")) {
//      CtContratoDto f = (CtContratoDto) obj;
//      validaciones.add(new ValidacionDto(f.getConsecutivoAseguradora() != null && f.getConsecutivoAseguradora() > 0 ? String.valueOf(f.getConsecutivoAseguradora()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_aseguradora"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFechaInicio() == null ? null : String.valueOf(f.getFechaInicio()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_fecha_inicio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFechaFin() == null ? null : String.valueOf(f.getFechaFin()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_fecha_fin"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFechaSuscripcion() == null ? null : String.valueOf(f.getFechaSuscripcion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_fecha_suscripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoContrato() <= 0 ? "" : String.valueOf(f.getTipoContrato()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_tipo_contrato"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTarifaContrato() <= 0 ? "" : String.valueOf(f.getTarifaContrato()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_tarifa_contrato"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getModalidadContrato() <= 0 ? "" : String.valueOf(f.getModalidadContrato()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_modalidad_contrato"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getComplejidad() <= 0 ? "" : String.valueOf(f.getComplejidad()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_complejidad"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFormaPago() <= 0 ? "" : String.valueOf(f.getFormaPago()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_forma_pago"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getPorcentajeTarifa() < 0 ? "" : String.valueOf(f.getPorcentajeTarifa()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_porcentaje_tarifa"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValor() < 0 ? "" : String.valueOf(f.getValor()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_valor"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSaldo() < 0 ? "" : String.valueOf(f.getSaldo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_saldo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getPorcentajeDescuento() < 0 ? "" : String.valueOf(f.getPorcentajeDescuento()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_porcentaje_descuento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//
//      if (f.getFechaInicio() != null && f.getFechaFin() != null) {
//        if (f.getFechaInicio().after(f.getFechaFin())) {
//          validaciones.add(new ValidacionDto(null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_fecha_fin"), Mensaje.getMensaje(Util.LOCALIDAD, "error_fecha_fin_antes_fecha_inicio"), ETipoValidacion.OTHER));
//        }
//
//        if (f.getFechaSuscripcion() != null) {
//          if (f.getFechaInicio().after(f.getFechaSuscripcion()) || f.getFechaFin().before(f.getFechaSuscripcion())) {
//            validaciones.add(new ValidacionDto(null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_fecha_suscripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_fecha_suscripcion_no_rango"), ETipoValidacion.OTHER));
//          }
//        }
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeletePaciente")) {
//      CtPacienteDto f = (CtPacienteDto) obj;
//      validaciones.add(new ValidacionDto(f.getTipoIdentificacion() != null && f.getTipoIdentificacion() > 0 ? String.valueOf(f.getTipoIdentificacion()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_paciente_tipo_identificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFechaNacimiento() == null ? null : String.valueOf(f.getFechaNacimiento()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_paciente_fecha_nacimiento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getPrimerNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_paciente_primer_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getPrimerApellido(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_paciente_primer_apellido"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNumeroIdentificacion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_paciente_numero_identificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSerial(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_paciente_serial"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      // Complemento
//      validaciones.add(new ValidacionDto(f.getPacienteComplemento().getGenero() > 0 ? String.valueOf(f.getPacienteComplemento().getGenero() > 0) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_paciente_genero"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getPacienteComplemento().getMunicipio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_municipio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteProfesion")) {
//      ScProfesionDto f = (ScProfesionDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_profesion_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteFondo")) {
//      ScFondoDto f = (ScFondoDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_fondo_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNit(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_fondo_nit"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDigitoVerificacion() < 0 ? "" : String.valueOf(f.getDigitoVerificacion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_fondo_digito_verificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCodigo(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_fondo_codigo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDireccion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_fondo_direccion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTelefono(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_fondo_telefono"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoFondo() <= 0 ? "" : String.valueOf(f.getTipoFondo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_fondo_tipo_fondo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteEmpleado")) {
//      ScEmpleadoDto f = (ScEmpleadoDto) obj;
//      validaciones.add(new ValidacionDto(f.getTipoIdentificacion() <= 0 ? "" : String.valueOf(f.getTipoIdentificacion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_tipo_identificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNumeroIdentificacion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_numero_identificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      // validaciones.add(new ValidacionDto(f.getTercero() <= 0 ? "" : String.valueOf(f.getTercero()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_tercero"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getPrimerNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_primer_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getPrimerApellido(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_primer_apellido"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDireccion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_direccion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getMunicipio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_municipio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFechaNacimiento() == null ? null : String.valueOf(f.getFechaNacimiento()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fecha_nacimiento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getGrupoSanguineo() <= 0 ? "" : String.valueOf(f.getGrupoSanguineo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_grupo_sanguineo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getRh() < 0 ? "" : String.valueOf(f.getRh()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_rh"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getProfesion() <= 0 ? "" : String.valueOf(f.getProfesion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_profesion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTallaCamisa(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_talla_camisa"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTallaPantalon(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_talla_pantalon"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTallaCalzado(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_talla_calzado"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwUsaGafas() < 0 ? "" : String.valueOf(f.getSwUsaGafas()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_usa_lentes"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFondoEntidadFinanciera() <= 0 ? "" : String.valueOf(f.getFondoEntidadFinanciera()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fondo_entidad_financiera"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getMunicipioEntidadFinanciera(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_municipio_entidad_financiera"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getClaseCuenta() <= 0 ? "" : String.valueOf(f.getClaseCuenta()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_clase_cuenta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNumeroCuenta(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_numero_cuenta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFondoPensiones() <= 0 ? "" : String.valueOf(f.getFondoPensiones()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fondo_pensiones"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFondoCesantias() <= 0 ? "" : String.valueOf(f.getFondoCesantias()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fondo_cesantias"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFondoEps() <= 0 ? "" : String.valueOf(f.getFondoEps()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fondo_eps"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFondoArp() <= 0 ? "" : String.valueOf(f.getFondoArp()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fondo_arp"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFondoAportes() <= 0 ? "" : String.valueOf(f.getFondoAportes()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fondo_aportes"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFondoCajaCompensacion() <= 0 ? "" : String.valueOf(f.getFondoCajaCompensacion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fondo_caja_compensacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFondoIcbf() <= 0 ? "" : String.valueOf(f.getFondoIcbf()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fondo_icbf"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFondoSena() <= 0 ? "" : String.valueOf(f.getFondoSena()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fondo_sena"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwAplicaNomina() < 0 ? "" : String.valueOf(f.getSwAplicaNomina()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_sw_aplica_nomina"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      // Iteradores
//      if (f.getEmpleadoEducacionIterador() != null && !f.getEmpleadoEducacionIterador().isEmpty()) {
//        int i = 1;
//        for (ScEmpleadoEducacionDto it : f.getEmpleadoEducacionIterador()) {
//          validaciones.add(new ValidacionDto(it.getEstablecimientoEducativo(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_edu_establecimiento_educativo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getTitulo(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_edu_titulo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getFecha() == null ? null : String.valueOf(it.getFecha()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_edu_fecha"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          i++;
//        }
//      }
//
//      if (f.getEmpleadoFamiliaIterador() != null && !f.getEmpleadoFamiliaIterador().isEmpty()) {
//        int i = 1;
//        for (ScEmpleadoFamiliaDto it : f.getEmpleadoFamiliaIterador()) {
//          validaciones.add(new ValidacionDto(it.getGrado(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fam_grado"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getNombres(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fam_nombres"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getParentesco() <= 0 ? "" : String.valueOf(it.getParentesco()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_fam_parentesco"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          i++;
//        }
//      }
//
//      if (f.getEmpleadoLaboralIterador() != null && !f.getEmpleadoLaboralIterador().isEmpty()) {
//        int i = 1;
//        for (ScEmpleadoLaboralDto it : f.getEmpleadoLaboralIterador()) {
//          validaciones.add(new ValidacionDto(it.getEmpresa(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_lab_empresa"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getCargo(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_lab_cargo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getExperiencia(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_empleado_lab_experiencia"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          i++;
//        }
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteTbCuenta")) {
//      TbCuentaDto f = (TbCuentaDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tb_cuenta_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoCuenta() <= 0 ? "" : String.valueOf(f.getTipoCuenta()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tb_cuenta_tipo_cuenta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteTipoEstablecimiento")) {
//      TbTipoEstablecimientoDto f = (TbTipoEstablecimientoDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_establecimiento_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteIpsCuenta")) {
//      TbIpsDto f = (TbIpsDto) obj;
//      validaciones.add(new ValidacionDto(f.getCodigoInterno(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_ips_cuenta_codigo_interno"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_ips_cuenta_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDireccion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_ips_cuenta_direccion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getMunicipio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_ips_cuenta_municipio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoTipoEstablecimiento() != null && f.getConsecutivoTipoEstablecimiento() > 0 ? String.valueOf(f.getConsecutivoTipoEstablecimiento()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_ips_cuenta_tipo_establecimiento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      // Iteradores
//      if (f.getIpsCuentaIterador() != null && !f.getIpsCuentaIterador().isEmpty()) {
//        int i = 1;
//        for (TbIpsCuentaDto it : f.getIpsCuentaIterador()) {
//          validaciones.add(new ValidacionDto(it.getConsecutivoCuenta() != null && it.getConsecutivoCuenta() > 0 ? String.valueOf(it.getConsecutivoCuenta()) : null, "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_ips_cuenta_tipo_cuenta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          i++;
//        }
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteGruposEspecialidad")) {
//      GrupoEspecialidadDto f = (GrupoEspecialidadDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_grupoespecialidad_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteEspecialidad")) {
//      EspecialidadDto f = (EspecialidadDto) obj;
//      validaciones.add(new ValidacionDto(f.getCodigoInterno(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_especialidad_codigointerno"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_especialidad_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(String.valueOf(f.getGrupoEspecialidad() <= 0 ? null : f.getGrupoEspecialidad()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_especialidad_grupoespecialidad"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteTipoConsultorio")) {
//      TbTipoConsultorioDto f = (TbTipoConsultorioDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_tipoconsultorio_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("apiUrlGenerateSchedule")) {
//      TbHorarioEncabezadoDto f = (TbHorarioEncabezadoDto) obj;
//
//      if (f.getAccion() != null) {
//        validaciones.add(new ValidacionDto(String.valueOf(f.getDuracion() <= 0 ? null : f.getDuracion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_duracion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        //validaciones.add(new ValidacionDto("", Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_hora_vacia"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      }
//      else {
//        validaciones.add(new ValidacionDto(String.valueOf(f.getDuracion() <= 0 ? null : f.getDuracion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_duracion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(String.valueOf(f.getHoraInicio() == null ? null : f.getHoraInicio()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_horainicio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        validaciones.add(new ValidacionDto(String.valueOf(f.getHoraFin() == null ? null : f.getHoraFin()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_horafin"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//        if (f.getHoraInicio() != null && f.getHoraFin() != null) {
//          if (f.getHoraFin().before(f.getHoraInicio())) {
//            validaciones.add(new ValidacionDto("", Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_msg_horafin_menor"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          }
//        }
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteHorario")) {
//      TbHorarioEncabezadoDto f = (TbHorarioEncabezadoDto) obj;
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      //validaciones.add(new ValidacionDto(String.valueOf(f.getDuracion() <= 0 ? null : f.getDuracion()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_duracion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(String.valueOf(f.getHoraInicio() == null ? null : f.getHoraInicio()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_horainicio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(String.valueOf(f.getHoraFin() == null ? null : f.getHoraFin()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_horafin"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      if (f.getDetalles().isEmpty()) {
//        validaciones.add(new ValidacionDto("", Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_msg_detalle_vacio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      }
//      else {
//        int i = 1;
//        for (TbHorarioDetalleDto d : f.getDetalles()) {
//          validaciones.add(new ValidacionDto(String.valueOf(d.getHoraInicio() == null ? "It. (" + i + ") " : d.getHoraInicio()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_horainicio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(String.valueOf(f.getHoraFin() == null ? "It. (" + i + ") " : f.getHoraFin()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_horarios_horafin"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          i++;
//        }
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteSoat")) {
//      TbSoatDto f = (TbSoatDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getCodigo(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_soat_codigo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_soat_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getReferencia(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_soat_referencia"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCup() > 0 ? String.valueOf(f.getCup()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_soat_cup"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      if (f.getValoresSoat() != null && !f.getValoresSoat().isEmpty()) {
//        int i = 1;
//        for (TbSoatValorDto it : f.getValoresSoat()) {
//          validaciones.add(new ValidacionDto(it.getAno() < 0 ? "" : String.valueOf(it.getAno()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_soat_detalle_anio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getValorPesos() < 0 ? "" : String.valueOf(it.getValorPesos()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_soat_detalle_valor_pesos"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getValorUvr() < 0 ? "" : String.valueOf(it.getValorUvr()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_soat_detalle_valor_uvr"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          i++;
//        }
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteIss")) {
//      TbIssDto f = (TbIssDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getCodigo(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iss_codigo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iss_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getReferencia(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iss_referencia"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValorPesos() < 0 ? "" : String.valueOf(f.getValorPesos()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iss_valor_pesos"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValorUvr() < 0 ? "" : String.valueOf(f.getValorUvr()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iss_valor_uvr"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCup() > 0 ? String.valueOf(f.getCup()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iss_cup"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoIss() <= 0 ? "" : String.valueOf(f.getTipoIss()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iss_tipo_iss"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoValor() <= 0 ? "" : String.valueOf(f.getTipoValor()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_iss_tipo_valor_iss"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("updateValueContratoInsumo")) {
//      CtContratoInsumoDto f = (CtContratoInsumoDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getValorInsumo() < 0 ? "" : String.valueOf(f.getValorInsumo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_insumo_valor_insumo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("updateValueContratoMedicamento")) {
//      CtContratoMedicamentoDto f = (CtContratoMedicamentoDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getValorMedicamento() < 0 ? "" : String.valueOf(f.getValorMedicamento()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_contrato_medicamento_valor_medicamento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteServicio")) {
//      TbServicioDto f = (TbServicioDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getCodigoInterno(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_servicio_codigo_interno"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_servicio_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSwHijo() < 0 ? "" : String.valueOf(f.getSwHijo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_servicio_sw_hijo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoServicio() <= 0 ? "" : String.valueOf(f.getTipoServicio()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_servicio_tipo_servicio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoComplejidad() < 0 ? "" : String.valueOf(f.getTipoComplejidad()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_servicio_tipo_complejidad"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteProgramaServicio")) {
//      CtProgramaServicioDto f = (CtProgramaServicioDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getNombre(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_programaservicio_nombre"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_programaservicio_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getCodigoInterno(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_programaservicio_codigointerno"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(String.valueOf(f.getConsecutivoServicio() == null ? null : f.getConsecutivoServicio()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_programaservicio_serviciohabilitado"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(String.valueOf(f.getConsecutivoTipo() == null ? null : f.getConsecutivoTipo()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_programaservicio_tipoconsultorio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(String.valueOf(f.getConsecutivoHorario() == null ? null : f.getConsecutivoHorario()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_programaservicio_horarioasistencial"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateAutorizacion")) {
//      InformacionAutorizacionDto f = (InformacionAutorizacionDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getNumeroAutorizacion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_autorizacion_numeroautorizacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteFacturaCompra")) {
//      ScFacturaEncabezadoDto f = (ScFacturaEncabezadoDto) obj;
//      // validaciones.add(new ValidacionDto(f.getNumeroFactura(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_numero_factura"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoTercero() != null && f.getConsecutivoTercero() > 0 ? String.valueOf(f.getConsecutivoTercero()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_tercero"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoTerceroRetencion() != null && f.getConsecutivoTerceroRetencion() > 0 ? String.valueOf(f.getConsecutivoTerceroRetencion()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_tercero_retencion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoFormaPago() != null && f.getConsecutivoFormaPago() > 0 ? String.valueOf(f.getConsecutivoFormaPago()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_forma_pago"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFecha() == null ? null : String.valueOf(f.getFecha()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_fecha"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFechaVencimiento() == null ? null : String.valueOf(f.getFechaVencimiento()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_fecha_vencimiento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getValorFactura() < 0 ? "" : String.valueOf(f.getValorFactura()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_valor_factura"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDescuento() < 0 ? "" : String.valueOf(f.getDescuento()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_descuento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSaldoFactura() < 0 ? "" : String.valueOf(f.getSaldoFactura()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_saldo_factura"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoRetefuente() != null && f.getConsecutivoRetefuente() > 0 ? String.valueOf(f.getConsecutivoRetefuente()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_retefuente"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoIva() != null && f.getConsecutivoIva() > 0 ? String.valueOf(f.getConsecutivoIva()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_iva"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoReteica() != null && f.getConsecutivoReteica() > 0 ? String.valueOf(f.getConsecutivoReteica()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_reteica"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getBaseReteica() < 0 ? "" : String.valueOf(f.getBaseReteica()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_base_reteica"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getBaseReteiva() < 0 ? "" : String.valueOf(f.getBaseReteiva()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_base_reteiva"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getBaseRetefuente() < 0 ? "" : String.valueOf(f.getBaseRetefuente()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_base_retefuente"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTotalReteica() < 0 ? "" : String.valueOf(f.getTotalReteica()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_total_reteica"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTotalReteiva() < 0 ? "" : String.valueOf(f.getTotalReteiva()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_total_reteiva"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTotalRetefuente() < 0 ? "" : String.valueOf(f.getTotalRetefuente()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_total_retefuente"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//      // validaciones.add(new ValidacionDto(f.getTipoFactura() <= 0 ? "" : String.valueOf(f.getTipoFactura()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_tipo_factura"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTipoPago() <= 0 ? "" : String.valueOf(f.getTipoPago()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_tipo_pago"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getEstadoFactura() < 0 ? "" : String.valueOf(f.getEstadoFactura()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_estado_factura"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      if (f.getDetallesFactura() != null && !f.getDetallesFactura().isEmpty()) {
//        int i = 1;
//        for (ScFacturaDetalleDto it : f.getDetallesFactura()) {
//          validaciones.add(new ValidacionDto(it.getConsecutivoProducto() != null && it.getConsecutivoProducto() > 0 ? String.valueOf(it.getConsecutivoProducto()) : null, "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_producto"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getCantidad() < 0 ? "" : String.valueOf(it.getCantidad()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_cantidad"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getCantidadReal() < 0 ? "" : String.valueOf(it.getCantidadReal()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_cantidad_real"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getValorCompra() < 0 ? "" : String.valueOf(it.getValorCompra()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_valor_compra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getValorVenta() < 0 ? "" : String.valueOf(it.getValorVenta()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_valor_venta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getConsecutivoIva() != null && it.getConsecutivoIva() > 0 ? String.valueOf(it.getConsecutivoIva()) : null, "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_iva"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getSwIva() < 0 ? "" : String.valueOf(it.getSwIva()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_sw_iva"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getSubTotal() < 0 ? "" : String.valueOf(it.getSubTotal()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_subtotal"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getSaldoDetalle() < 0 ? "" : String.valueOf(it.getSaldoDetalle()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_saldo_detalle"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getValorExtra() < 0 ? "" : String.valueOf(it.getValorExtra()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_valor_extra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getValorImprimir() < 0 ? "" : String.valueOf(it.getValorImprimir()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_valor_imprimir"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          // validaciones.add(new ValidacionDto(it.getConsecutivoTercero() != null && it.getConsecutivoTercero() > 0 ? String.valueOf(it.getConsecutivoTercero()) : null, "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_tercero"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getConsecutivoCuenta() != null && it.getConsecutivoCuenta() > 0 ? String.valueOf(it.getConsecutivoCuenta()) : null, "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_cuenta"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//          i++;
//        }
//      }
//      if (f.getPagosFactura() != null && !f.getPagosFactura().isEmpty()) {
//        int i = 1;
//        for (ScFacturaPagoDto it : f.getPagosFactura()) {
//          validaciones.add(new ValidacionDto(it.getFecha() == null ? null : String.valueOf(it.getFecha()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_fecha"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getConsecutivoFormaPago() > 0 ? String.valueOf(it.getConsecutivoFormaPago()) : null, "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_forma_pago"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getValorPago() < 0 ? "" : String.valueOf(it.getValorPago()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_valor_pago"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//
//          i++;
//        }
//      }
//      if (f.getMedicamentosFactura() != null && !f.getMedicamentosFactura().isEmpty()) {
//        int i = 1;
//        for (ScFacturaMedicamentoDto it : f.getMedicamentosFactura()) {
//          validaciones.add(new ValidacionDto(it.getConsecutivoMedicamento() > 0 ? String.valueOf(it.getConsecutivoMedicamento()) : null, "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_medicamento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getLote(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_lote"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getFechaVencimiento() == null ? null : String.valueOf(it.getFechaVencimiento()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_fecha_vencimiento"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getCantidad() < 0 ? "" : String.valueOf(it.getCantidad()), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_cantidad"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio_menor_cero"), ETipoValidacion.EMPTY));
//          validaciones.add(new ValidacionDto(it.getCodigoBarra(), "It. (" + i + ") " + Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_factura_compra_codigo_barra"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//          i++;
//        }
//      }
//    }
//    else if (path.equalsIgnoreCase("saveOrUpdateOrDeleteInfraestructura")) {
//      CtInfraestructuraDto f = (CtInfraestructuraDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_infraestructura_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoTipo() != null && f.getConsecutivoTipo() > 0 ? String.valueOf(f.getConsecutivoTipo()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_infraestructura_tipo_consultorio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getConsecutivoIps() != null && f.getConsecutivoIps() > 0 ? String.valueOf(f.getConsecutivoIps()) : null, Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_infraestructura_ips"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//    }
//    else if (path.equals("saveOrUpdateOrDeletePeriodoReporte")) {
//      TbPeriodoReporteDto f = (TbPeriodoReporteDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_periodo_reporte_descricpion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(String.valueOf(f.getFechaInicio()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_periodo_reporte_fecha_inicio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(String.valueOf(f.getFechaFin()), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_periodo_reporte_fecha_fin"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      if (f.getFechaInicio() != null && f.getFechaFin() != null) {
//        if (f.getFechaInicio().after(f.getFechaFin())) {
//          validaciones.add(new ValidacionDto("", Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mto_periodo_reporte_fechas_error"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        }
//      }
//    }
//    else if (path.equals("saveOrUpdateOrDeleteTipoSoporte")) {
//      TbTipoSoporteDto f = (TbTipoSoporteDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_tipo_soporte_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equals("saveOrUpdateOrDeleteMotivoPendiente")) {
//      TbMotivoPendienteDto f = (TbMotivoPendienteDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getDescripcion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_motivo_pendiente_descripcion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//    else if (path.equals("saveOrUpdateOrDeleteEmpresa")) {
//      TbEmpresaDto f = (TbEmpresaDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getNit(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mtto_empresa_nit"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDigitoVerificacion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mtto_empresa_digitoverificacion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getRazonSocial(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mtto_empresa_razon_social"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getSigla(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mtto_empresa_sigla"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getFrase(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mtto_empresa_frase"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getDireccion(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mtto_empresa_direccion"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getMunicipio(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mtto_empresa_municipio"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//      validaciones.add(new ValidacionDto(f.getTelefono(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mtto_empresa_telefono"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//
//      if (!Util.vacio(f.getEmail())) {
//        if (!Util.isEmail(f.getEmail())) {
//          validaciones.add(new ValidacionDto("", Mensaje.getMensaje(Util.LOCALIDAD, "lbl_mtto_empresa_email_invalido"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//        }
//      }
//    }
//    else if (path.equals("saveAutorizacionPago")) {
//      EntAutorizacionEncabezadoDto f = (EntAutorizacionEncabezadoDto) obj;
//
//      validaciones.add(new ValidacionDto(f.getFechaPago() == null ? null : f.getFechaPago().toString(), Mensaje.getMensaje(Util.LOCALIDAD, "lbl_modulo_autorizacion_pago_fecha_recibo"), Mensaje.getMensaje(Util.LOCALIDAD, "error_vacio"), ETipoValidacion.EMPTY));
//    }
//
//    return Util.validacionesString(validaciones);
//  }
//
//  public Response errores(Exception e) throws JSONException, JsonProcessingException {
//    try {
//
//      e.getStackTrace().toString();
//      short idError = 0;
//      String msgError = "Un nuevo tipo de error fue encontrado, informar al admin para agregarlo a las validaciones.";
//
//      if (e.toString().indexOf("NullPointerException") != -1) {
//        idError = EEstadoRespuestaHTTP.ERROR_JAVA_NULL.getId();
//        msgError = EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_NULL.getId());
//      }
//      else if (e.toString().indexOf("IOException") != -1) {
//        idError = EEstadoRespuestaHTTP.ERROR_JAVA_IO.getId();
//        msgError = EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_IO.getId());
//      }
//      else if (e.toString().indexOf("ArithmeticException") != -1) {
//        idError = EEstadoRespuestaHTTP.ERROR_JAVA_ARITMETICO.getId();
//        msgError = EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_ARITMETICO.getId());
//      }
//      else if (e.toString().indexOf("IndexOutOfBoundsException") != -1) {
//        idError = EEstadoRespuestaHTTP.ERROR_JAVA_INDEX_OF_BOUND.getId();
//        msgError = EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_INDEX_OF_BOUND.getId());
//      }
//      else if (e.toString().indexOf("ConstraintViolationException") != -1) {
//        idError = EEstadoRespuestaHTTP.ERROR_BD_RELACION_INCUMPLIDA.getId();
//        msgError = EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_BD_RELACION_INCUMPLIDA.getId());
//      }
//      else if (e.toString().indexOf("TransactionSystemException") != -1 || e.toString().indexOf("TransactionRequiredException") != -1) {
//        idError = EEstadoRespuestaHTTP.ERROR_BD_TRANSACCION_FALLIDA.getId();
//        msgError = EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_BD_TRANSACCION_FALLIDA.getId());
//      }
//      else if (e.toString().indexOf("MissingResourceException") != -1) {
//        idError = EEstadoRespuestaHTTP.ERROR_JAVA_NULL.getId();
//        msgError = EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_NULL.getId());
//      }
//      else if (e.toString().indexOf("FileNotFoundException") != -1) {
//        idError = EEstadoRespuestaHTTP.ERROR_JAVA_IO_FILE.getId();
//        msgError = EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_IO_FILE.getId());
//      }
//
//      return this.atraparExc(idError, msgError);
//    }
//    catch (Exception ex) {
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/sendLogin")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response sendLogin(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOUsuario usuario = mapper.readValue(Json, POJOUsuario.class);
//
//      UserDto userSession = mantenimientoService.login(usuario.getUsuario(), usuario.getClave());
//      if (userSession != null && userSession.isActivo()) {
//        userSession.setLocalidad(Util.LOCALIDAD);
//        POJOUsuario usuarioResponse = new POJOUsuario();
//
//        // --> Permisos
//        BeanUtils.copyProperties(userSession.getUsuarioDto(), usuarioResponse);
//        FastTable<PermisoDto> permisosDto = new FastTable<PermisoDto>();
//        for (Short keySet : userSession.getPermisos().keySet()) {
//          PermisoDto perm = userSession.getPermisos().get(keySet);
//          permisosDto.add(perm);
//        }
//        usuarioResponse.setPermisos(permisosDto);
//        usuarioResponse.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        usuarioResponse.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        if (Util.vacio(usuarioResponse.getUrl())) {
//          usuarioResponse.setUrl(Util.RUTA_IMAGEN_PERFIL + Util.NOMBRE_IMAGEN_PERFIL_DEFAULT);
//        }
//
//        // Cargar los usuariosIPS
//        usuarioResponse.setListaIpsSeleccionadasLogin(new FastTable<POJOUsuarioIps>());
//        if (usuario.getSwIndicadorIps() == ESiNo.SI.getId()) {
//          boolean isAdmin = usuarioResponse.getSwAdministrador() == ESiNo.SI.getId();
//          FastTable<UsuarioIpsDto> usuariosIpsDto = this.mantenimientoService.getUsuariosIpsLogin(usuario.getUsuario(), isAdmin);
//          for (UsuarioIpsDto usips : usuariosIpsDto) {
//            POJOUsuarioIps pojo = new POJOUsuarioIps();
//            BeanUtils.copyProperties(usips, pojo);
//            usuarioResponse.getListaIpsSeleccionadasLogin().add(pojo);
//          }
//        }
//
//        String jsonInString = mapper.writeValueAsString(usuarioResponse);
//        return Response.ok(jsonInString).build();
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_BD_NO_EXISTE_USUARIO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_BD_NO_EXISTE_USUARIO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/sendResetPass")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response sendResetPass(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOUsuario usuario = mapper.readValue(Json, POJOUsuario.class);
//
//      // La ip del usuario que solicita la restauracion de clave se almacena en el campo UrlFirma solo para este proceso
//      String ipCliente = usuario.getUrlFirma().replace("\\", "");
//
//      // Método sincronizado para generar un numero aleatorio para el
//      String codeV = String.valueOf(System.currentTimeMillis());
//      codeV = Util.getEncriptado(codeV);
//      codeV = codeV.substring(codeV.length() - 10, codeV.length());
//
//      // Buscamos que el usuario exista y sea usuario activo
//      UsuarioDto user = mantenimientoService.findUserByEmail(usuario.getEmail());
//      if (user != null && (user.getSwActivo() == ESiNo.SI.getId())) {
//        UsuarioAccesoDto accesoDto = new UsuarioAccesoDto();
//        accesoDto.setUsuario(user.getUsuario());
//        accesoDto.setToken(codeV);
//        accesoDto.setIp(ipCliente);
//        // Se guarda el acceso, se inactivan los enlaces anteriores y si todo sale bien se envía el correo notificando
//        boolean correcto = mantenimientoService.saveUserAccess(accesoDto);
//        if (correcto) {
//          // Se envia el correo al usuario
//          if (!Util.vacio(user.getEmail()) && Util.isEmail(user.getEmail())) {
//            // Declaramos fecha de hoy
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(new Date());
//            cal.set(Calendar.HOUR_OF_DAY, 0);
//            cal.set(Calendar.MINUTE, 0);
//            cal.set(Calendar.SECOND, 0);
//            cal.set(Calendar.MILLISECOND, 0);
//            Date fechaHoy = cal.getTime();
//            // Declaramos los parametros que se pasan por la URL
//            String codigoVerificacion = "?psw=" + codeV;
//            String usuarioVerificacion = "&usr=" + user.getUsuario();
//            // La URL del formulario para reestablecer la contraseña
//            String URL = Util.RUTA_FORM_RESET_PASS;
//
//            // Definicion de variables para reemplazar
//            String fecha = Util.getFechaCorta(fechaHoy, false);
//            String correo = user.getEmail();
//            short mesTexto = Short.parseShort(fecha.split("/")[1]);
//            String asunto = Mensaje.getMensaje("lbl_correo_rec_clave_asunto");
//            String enlace = URL + codigoVerificacion + usuarioVerificacion;
//            String rutaHTML = Util.RUTA_SRC_PROYECTO + Util.RUTA_TEMPLATES_CORREO_RESTAURAR_CLAVE;
//            String texto = Util.getStringOfFile(rutaHTML);
//            // TODO DEFINIR
//            // String remitente = this.mantenimientoService.getGenCorreoXCodigoYModulo(codigoCorreo, Util.MODULO_CITAS);
//
//            if (texto != null) {
//              // Reemplazando variables
//              texto = texto.replace("$asunto", asunto);
//              texto = texto.replace("$mes_letras", EMeses.getName(mesTexto));
//              texto = texto.replace("$dia", fecha.split("/")[2]);
//              texto = texto.replace("$anio", fecha.split("/")[0]);
//              texto = texto.replace("$username", user.getNombre().toUpperCase() + " - " + user.getApellido().toUpperCase());
//              texto = texto.replace("$user", user.getUsuario().toUpperCase());
//              texto = texto.replace("$mensaje", Mensaje.getMensaje("lbl_correo_rec_clave_mensaje"));
//              texto = texto.replace("$enlace", enlace);
//              texto = texto.replace("$en_mensaje", Mensaje.getMensaje("lbl_correo_rec_clave_enlace_mensaje"));
//              texto = texto.replace("$recomendaciones", Mensaje.getMensaje("lbl_correo_rec_clave_recomendaciones"));
//
//              // Para codificar acentos y enies
//              texto.replace("á", "&aacute");
//              texto.replace("é", "&eacute");
//              texto.replace("í", "&iacute");
//              texto.replace("ó", "&oacute");
//              texto.replace("ú", "&uacute");
//              texto.replace("ñ", "&ntilde");
//
//              // Enviar el correo (Email a enviar, Asunto, Mensaje, remitente, claveRemitente)
//              emailService.send(user.getEmail(), asunto, texto);
//            }
//            else {
//              return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_NULL.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_NULL.getId()));
//            }
//          }
//        }
//        else {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_BD_NO_EXISTE_USUARIO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_BD_NO_EXISTE_USUARIO.getId()));
//        }
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_BD_NO_EXISTE_USUARIO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_BD_NO_EXISTE_USUARIO.getId()));
//      }
//
//      return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getDocumentTypes")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getDocumentTypes() throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      List<POJOTbTipoIdentificacion> POJOTipoIdentificacion = new ArrayList<POJOTbTipoIdentificacion>();
//      FastTable<TbTipoIdentificacionDto> TipoIdentificacion = mantenimientoService.getListaTiposDocumento(new TbTipoIdentificacionDto());
//      for (TbTipoIdentificacionDto tipoDoc : TipoIdentificacion) {
//        POJOTbTipoIdentificacion pojoCombo = new POJOTbTipoIdentificacion();
//        BeanUtils.copyProperties(tipoDoc, pojoCombo);
//        POJOTipoIdentificacion.add(pojoCombo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOTipoIdentificacion);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getUsers")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getUsers(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOUsuario usuarioPOJO = mapper.readValue(Json, POJOUsuario.class);
//      UsuarioDto userFiltro = new UsuarioDto();
//      userFiltro.setUsuario(usuarioPOJO.getUsuario());
//      userFiltro.setNombre(usuarioPOJO.getNombre());
//      FastTable<UsuarioDto> usuarios = mantenimientoService.getListaUsuarios(userFiltro);
//
//      FastMap<String, ArrayList<POJOTbPerfil>> mapaPerfilesXUsuario = mantenimientoService.getMapaPerfilesXUsuarios();
//      FastTable<TbPerfilDto> listaPerfilesDto = mantenimientoService.getListaTbPerfil(new TbPerfilDto());
//      ArrayList<POJOTbPerfil> perfilesGeneral = new ArrayList<POJOTbPerfil>();
//
//      for (TbPerfilDto perfilDto : listaPerfilesDto) {
//        POJOTbPerfil pojoPerf = new POJOTbPerfil();
//        BeanUtils.copyProperties(perfilDto, pojoPerf);
//        perfilesGeneral.add(pojoPerf);
//      }
//
//      List<POJOUsuario> usersPOJO = new ArrayList<POJOUsuario>();
//      for (UsuarioDto user : usuarios) {
//        POJOUsuario pojoUser = new POJOUsuario();
//        BeanUtils.copyProperties(user, pojoUser);
//        pojoUser.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoUser.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        pojoUser.setPerfiles(mapaPerfilesXUsuario.get(user.getUsuario()) == null ? new ArrayList<POJOTbPerfil>() : mapaPerfilesXUsuario.get(user.getUsuario()));
//
//        FastSet<Long> llavesPerfiles = new FastSet<Long>();
//        for (POJOTbPerfil poj : pojoUser.getPerfiles()) {
//          llavesPerfiles.add(poj.getPerfil());
//        }
//
//        ArrayList<POJOTbPerfil> perfilesSeleccionados = new ArrayList<POJOTbPerfil>();
//        for (POJOTbPerfil pjo : perfilesGeneral) {
//          if (!llavesPerfiles.contains(pjo.getPerfil())) {
//            perfilesSeleccionados.add(pjo);
//          }
//        }
//        pojoUser.setPerfilesSeleccionados(perfilesSeleccionados);
//
//        usersPOJO.add(pojoUser);
//      }
//
//      String jsonInString = mapper.writeValueAsString(usersPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteUser")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteUser(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbUsuario
//    try {
//      String path = "saveOrUpdateOrDeleteUser";
//      ObjectMapper mapper = new ObjectMapper();
//      UsuarioDto usuarioDto = new UsuarioDto();
//      POJOUsuario usuario = mapper.readValue(Json, POJOUsuario.class);
//
//      BeanUtils.copyProperties(usuario, usuarioDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(usuario.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(usuario.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) usuarioDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else if (!Util.isEmail(usuarioDto.getEmail())) {
//          // validar Email
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_EMAIL.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_EMAIL.getId()));
//        }
//        else {
//          FastTable<UsuarioDto> usuarios = mantenimientoService.getListaUsuarios(new UsuarioDto());
//          boolean flag = true;
//          for (UsuarioDto obj : usuarios) {
//            if (!Util.vacio(usuarioDto.getEmail())) {
//              if (EAccion.ADD.getText().equalsIgnoreCase(usuario.getStatusAction())) {
//                if (obj.getEmail().equals(usuarioDto.getEmail())) {
//                  flag = false;
//                  break;
//                }
//              }
//              else {
//                if (!obj.getUsuario().equals(usuarioDto.getUsuario()) && obj.getEmail().equals(usuarioDto.getEmail())) {
//                  flag = false;
//                  break;
//                }
//              }
//            }
//          }
//
//          if (!flag) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_EMAIL_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_EMAIL_REPETIDO.getId()));
//          }
//        }
//
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteUser(usuarioDto, usuario.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/setProfile")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response setProfile(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbPerfil
//    try {
//      String path = "setProfile";
//      ObjectMapper mapper = new ObjectMapper();
//      TbPerfilDto tbPerfilDto = new TbPerfilDto();
//      POJOTbPerfil tbPerfil = mapper.readValue(Json, POJOTbPerfil.class);
//
//      ArrayList<ModuloXPerfilDto> nuevaTemp = new ArrayList<ModuloXPerfilDto>();
//      for (POJOModuloXPerfil pojoInt : tbPerfil.getPerfilesXModulos()) {
//        ModuloXPerfilDto dto = new ModuloXPerfilDto();
//        BeanUtils.copyProperties(pojoInt, dto);
//
//        nuevaTemp.add(dto);
//      }
//
//      tbPerfil.setPerfilesXModulos(null);
//      BeanUtils.copyProperties(tbPerfil, tbPerfilDto);
//      tbPerfilDto.setPerfilesXModulos(nuevaTemp);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(tbPerfil.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(tbPerfil.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) tbPerfilDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.setProfile(tbPerfilDto, tbPerfil.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getProfiles")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getProfiles(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "getProfiles";
//      ObjectMapper mapper = new ObjectMapper();
//      TbPerfilDto tbPerfilDto = new TbPerfilDto();
//      POJOTbPerfil tbPerfil = mapper.readValue(Json, POJOTbPerfil.class);
//
//      BeanUtils.copyProperties(tbPerfil, tbPerfilDto);
//      /*
//       * if (tbPerfil.getSwAdministrador() == ESiNo.NO.getId()) { boolean flagPermit = Util.evaluarPermisoModuloPerfil(EModulo.TB_USUARIO.getId(), tbPerfil.getStatusAction(), tbPerfil.getPermisos()); if (!flagPermit) { return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_PERMISO_DENEGADO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_PERMISO_DENEGADO.getId())); } }
//       */
//
//      List<POJOTbPerfil> perfilesGeneral = new ArrayList<>();
//      POJOTbPerfil perfilPOJO = mapper.readValue(Json, POJOTbPerfil.class);
//      TbPerfilDto perfilFiltro = new TbPerfilDto();
//      perfilFiltro.setDescripcion(perfilPOJO.getDescripcion());
//      FastTable<TbPerfilDto> perfiles = mantenimientoService.getListaTbPerfil(perfilFiltro);
//
//      // traer los modulos x peril
//      FastTable<ModuloXPerfilDto> listaModulos = mantenimientoService.getModulos(new ModuloXPerfilDto());
//      FastMap<Long, FastTable<POJOModuloXPerfil>> mapaModuloXperfil = new FastMap<Long, FastTable<POJOModuloXPerfil>>();
//      FastTable<POJOModuloXPerfil> temp = new FastTable<POJOModuloXPerfil>();
//
//      ArrayList<POJOModuloXPerfil> tempPojo = new ArrayList<POJOModuloXPerfil>();
//      for (ModuloXPerfilDto m : listaModulos) {
//        POJOModuloXPerfil pojo = new POJOModuloXPerfil();
//        BeanUtils.copyProperties(m, pojo);
//        tempPojo.add(pojo);
//      }
//
//      for (POJOModuloXPerfil modulo : tempPojo) {
//        if (mapaModuloXperfil.isEmpty()) {
//          temp.add(modulo);
//          mapaModuloXperfil.put(modulo.getPerfil(), temp);
//        }
//        else {
//          if (mapaModuloXperfil.containsKey(modulo.getPerfil())) {
//            mapaModuloXperfil.get(modulo.getPerfil()).add(modulo);
//          }
//          else {
//            temp = new FastTable<POJOModuloXPerfil>();
//            temp.add(modulo);
//            mapaModuloXperfil.put(modulo.getPerfil(), temp);
//          }
//        }
//      }
//
//      for (TbPerfilDto perfilDto : perfiles) {
//        POJOTbPerfil pojoPerf = new POJOTbPerfil();
//        BeanUtils.copyProperties(perfilDto, pojoPerf);
//
//        pojoPerf.setPerfilesXModulos(new ArrayList<POJOModuloXPerfil>());
//        if (mapaModuloXperfil.get(pojoPerf.getPerfil()) != null) {
//          pojoPerf.getPerfilesXModulos().addAll(mapaModuloXperfil.get(perfilDto.getPerfil()));
//        }
//
//        perfilesGeneral.add(pojoPerf);
//      }
//
//      String jsonInString = mapper.writeValueAsString(perfilesGeneral);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getCups")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getCups(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOTbCup cupsPOJO = mapper.readValue(Json, POJOTbCup.class);
//      TbCupDto cupsFiltro = new TbCupDto();
//
//      cupsFiltro.setDescripcion(cupsPOJO.getDescripcion());
//      cupsFiltro.setCodigoInterno(cupsPOJO.getCodigoInterno());
//      FastTable<TbCupDto> cups = mantenimientoService.getListaCups(cupsFiltro);
//
//      List<POJOTbCup> cupPOJO = new ArrayList<POJOTbCup>();
//
//      for (TbCupDto dto : cups) {
//        POJOTbCup pojo = new POJOTbCup();
//        BeanUtils.copyProperties(dto, pojo);
//        cupPOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(cupPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getConjuntos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getConjuntos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOTbConjuntoEcabezado conjuntoEncanezadoPOJO = mapper.readValue(Json, POJOTbConjuntoEcabezado.class);
//      TbConjuntoEncabezadoDto conjuntoEncanezadoFiltro = new TbConjuntoEncabezadoDto();
//
//      conjuntoEncanezadoFiltro.setConsecutivoConjunto(conjuntoEncanezadoPOJO.getConsecutivoConjunto());
//      conjuntoEncanezadoFiltro.setNombre(conjuntoEncanezadoPOJO.getNombre());
//      FastTable<TbConjuntoEncabezadoDto> conjuntos = mantenimientoService.getListaConjunto(conjuntoEncanezadoFiltro);
//
//      List<POJOTbConjuntoEcabezado> POJOresult = new ArrayList<POJOTbConjuntoEcabezado>();
//
//      FastTable<TbConjuntoDetalleDto> listaDeTemp = new FastTable<TbConjuntoDetalleDto>();
//      for (TbConjuntoEncabezadoDto dto : conjuntos) {
//        listaDeTemp.addAll(dto.getConjuntosDetalles());
//
//        POJOTbConjuntoEcabezado pojo = new POJOTbConjuntoEcabezado();
//        // limpiar la lista antes de pasar al POJO
//        dto.getConjuntosDetalles().clear();
//        BeanUtils.copyProperties(dto, pojo);
//
//        // pasar los detalles
//        for (TbConjuntoDetalleDto detalle : listaDeTemp) {
//          POJOTbConjuntoDetalle pojoDetalle = new POJOTbConjuntoDetalle();
//          BeanUtils.copyProperties(detalle, pojoDetalle);
//          pojo.getConjuntosDetalles().add(pojoDetalle);
//        }
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//        listaDeTemp.clear();
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getExamenes")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getExamenes(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOTbExamenEcabezado examenEncabezadoPOJO = mapper.readValue(Json, POJOTbExamenEcabezado.class);
//      TbExamenEncabezadoDto examenEncanezadoFiltro = new TbExamenEncabezadoDto();
//
//      examenEncanezadoFiltro.setConsecutivoExamen(examenEncabezadoPOJO.getConsecutivoExamen());
//      examenEncanezadoFiltro.setNombre(examenEncabezadoPOJO.getNombre());
//      FastTable<TbExamenEncabezadoDto> examenes = mantenimientoService.getListaExamen(examenEncanezadoFiltro);
//
//      List<POJOTbExamenEcabezado> POJOresult = new ArrayList<POJOTbExamenEcabezado>();
//
//      FastTable<TbExamenDetalleDto> listaDeTemp = new FastTable<TbExamenDetalleDto>();
//      for (TbExamenEncabezadoDto dto : examenes) {
//        listaDeTemp.addAll(dto.getExamenesDetalles());
//
//        POJOTbExamenEcabezado pojo = new POJOTbExamenEcabezado();
//        // limpiar la lista antes de pasar al POJO
//        dto.getExamenesDetalles().clear();
//        BeanUtils.copyProperties(dto, pojo);
//
//        // pasar los detalles
//        for (TbExamenDetalleDto detalle : listaDeTemp) {
//          POJOTbExamenDetalle pojoDetalle = new POJOTbExamenDetalle();
//          BeanUtils.copyProperties(detalle, pojoDetalle);
//          pojo.getExamenesDetalles().add(pojoDetalle);
//        }
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//        listaDeTemp.clear();
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getIndices")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getIndices(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOTbIndice indicePOJO = mapper.readValue(Json, POJOTbIndice.class);
//      TbIndiceDto indiceFiltro = new TbIndiceDto();
//
//      indiceFiltro.setConsecutivoIndice(indicePOJO.getConsecutivoIndice());
//      indiceFiltro.setNombre(indicePOJO.getNombre());
//
//      FastTable<TbIndiceDto> indices = mantenimientoService.getListaIndice(indiceFiltro);
//
//      List<POJOTbIndice> POJOresult = new ArrayList<POJOTbIndice>();
//
//      for (TbIndiceDto dto : indices) {
//        POJOTbIndice pojo = new POJOTbIndice();
//        BeanUtils.copyProperties(dto, pojo);
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteCups")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteCups(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbUsuario
//    try {
//      String path = "saveOrUpdateOrDeleteCups";
//      ObjectMapper mapper = new ObjectMapper();
//      TbCupDto cupsDto = new TbCupDto();
//      POJOTbCup pojoCup = mapper.readValue(Json, POJOTbCup.class);
//      // TODO // ¿Tiene Permisos?
//      BeanUtils.copyProperties(pojoCup, cupsDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojoCup.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojoCup.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) cupsDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteCups(cupsDto, pojoCup.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteConjunto")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteConjunto(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteConjunto";
//      ObjectMapper mapper = new ObjectMapper();
//      TbConjuntoEncabezadoDto dto = new TbConjuntoEncabezadoDto();
//      POJOTbConjuntoEcabezado pojo = mapper.readValue(Json, POJOTbConjuntoEcabezado.class);
//
//      FastTable<TbConjuntoDetalleDto> detalles = new FastTable<TbConjuntoDetalleDto>();
//      for (POJOTbConjuntoDetalle d : pojo.getConjuntosDetalles()) {
//        TbConjuntoDetalleDto detalle = new TbConjuntoDetalleDto();
//        BeanUtils.copyProperties(d, detalle);
//        detalles.add(detalle);
//      }
//      BeanUtils.copyProperties(pojo, dto);
//      dto.setConjuntosDetalles(new FastTable<TbConjuntoDetalleDto>());
//      dto.getConjuntosDetalles().addAll(detalles);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteConjunto(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteIndice")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteIndice(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteIndice";
//      ObjectMapper mapper = new ObjectMapper();
//      TbIndiceDto dto = new TbIndiceDto();
//      POJOTbIndice pojo = mapper.readValue(Json, POJOTbIndice.class);
//      BeanUtils.copyProperties(pojo, dto);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteIndice(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/updateProfilesXUser")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response updateProfilesXUser(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOUsuario usuario = mapper.readValue(Json, POJOUsuario.class);
//      UsuarioDto usuarioDto = new UsuarioDto();
//      FastTable<TbPerfilDto> perfilesSel = new FastTable<TbPerfilDto>();
//
//      for (POJOTbPerfil pojoPerfil : usuario.getPerfiles()) {
//        TbPerfilDto perfilDto = new TbPerfilDto();
//        BeanUtils.copyProperties(pojoPerfil, perfilDto);
//        perfilesSel.add(perfilDto);
//      }
//
//      usuario.setPerfiles(new ArrayList<POJOTbPerfil>());
//      BeanUtils.copyProperties(usuario, usuarioDto);
//
//      boolean correcto = mantenimientoService.updateProfilesXUser(usuarioDto, perfilesSel, usuario.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/urlUpdateImageProfile")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response urlUpdateImageProfile(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOFileUpload filePOJO = mapper.readValue(Json, POJOFileUpload.class);
//
//      String usuario = filePOJO.getFilename();
//      String url = Util.RUTA_IMAGEN_PERFIL + filePOJO.getFilename() + filePOJO.getMimeType();
//      String ruta = Util.RUTA_SRC_PROYECTO + Util.RUTA_PERFILES_IMG_FACES + filePOJO.getFilename() + filePOJO.getMimeType();
//      boolean correcto = Util.convertirStreamAFile(filePOJO.getFile(), ruta);
//      if (correcto) {
//        boolean correct = this.mantenimientoService.updateImageProfileUser(usuario, url);
//        if (correct) {
//          return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        }
//        else {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//        }
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_ARCHIVO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_ARCHIVO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getInsumos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getInsumos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbInsumo insumoPOJO = mapper.readValue(Json, POJOTbInsumo.class);
//      TbInsumoDto insumoFiltro = new TbInsumoDto();
//      insumoFiltro.setCodigoInterno(insumoPOJO.getCodigoInterno());
//      insumoFiltro.setDescripcion(insumoPOJO.getDescripcion());
//      FastTable<TbInsumoDto> insumos = mantenimientoService.getListaInsumos(insumoFiltro);
//
//      List<POJOTbInsumo> insumosPOJO = new ArrayList<POJOTbInsumo>();
//      for (TbInsumoDto insumo : insumos) {
//        POJOTbInsumo pojoInsumo = new POJOTbInsumo();
//        BeanUtils.copyProperties(insumo, pojoInsumo);
//        pojoInsumo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoInsumo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        insumosPOJO.add(pojoInsumo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(insumosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteInsumo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteInsumo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbInsumo
//    try {
//      String path = "saveOrUpdateOrDeleteInsumo";
//      ObjectMapper mapper = new ObjectMapper();
//      TbInsumoDto insumoDto = new TbInsumoDto();
//      POJOTbInsumo insumo = mapper.readValue(Json, POJOTbInsumo.class);
//
//      BeanUtils.copyProperties(insumo, insumoDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(insumo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(insumo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) insumoDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else {
//          FastTable<TbInsumoDto> insumos = mantenimientoService.getListaInsumos(new TbInsumoDto());
//          boolean flag = true;
//          for (TbInsumoDto ins : insumos) {
//            if (EAccion.ADD.getText().equalsIgnoreCase(insumo.getStatusAction())) {
//              if (ins.getCodigoInterno().equals(insumoDto.getCodigoInterno())) {
//                flag = false;
//                break;
//              }
//            }
//            else {
//              if (ins.getInsumo() != insumoDto.getInsumo() && ins.getCodigoInterno().equals(insumoDto.getCodigoInterno())) {
//                flag = false;
//                break;
//              }
//            }
//          }
//
//          if (!flag) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId()));
//          }
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteInsumo(insumoDto, insumo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getEnums")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getEnums(String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOEnums enums = mapper.readValue(Json, POJOEnums.class);
//      FastTable<POJOEnums> listaCombo = new FastTable<POJOEnums>();
//      FastTable<Object> lista = new FastTable<Object>();
//
//      if (enums.getTipo() == EEnums.TIPO_IDENTIFICACION.getId()) {
//        FastTable<TbTipoIdentificacionDto> TipoIdentificacion = mantenimientoService.getListaTiposDocumento(new TbTipoIdentificacionDto());
//        for (TbTipoIdentificacionDto o : TipoIdentificacion) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.CONJUNTO.getId()) {
//        FastTable<TbConjuntoEncabezadoDto> conjunto = mantenimientoService.getListaConjunto(new TbConjuntoEncabezadoDto());
//        for (TbConjuntoEncabezadoDto o : conjunto) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.EXPRESION.getId()) {
//        FastTable<TbConjuntoEncabezadoDto> conjunto = mantenimientoService.getListaConjunto(new TbConjuntoEncabezadoDto());
//        for (TbConjuntoEncabezadoDto o : conjunto) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.CUPS.getId()) {
//        FastTable<TbCupDto> cups = mantenimientoService.getListaCups(new TbCupDto());
//        for (TbCupDto o : cups) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.UNIDAD.getId()) {
//        FastTable<TbUnidadDto> unidades = mantenimientoService.getListaUnidades(new TbUnidadDto());
//        for (TbUnidadDto o : unidades) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.MUNICIPIO.getId()) {
//        FastTable<TbMunicipioDto> municipo = mantenimientoService.getListaMunicipios(new TbMunicipioDto());
//        for (TbMunicipioDto o : municipo) {
//          if (o.getDepartamento() != null) {
//            Object obj = (Object) o;
//            lista.add(obj);
//          }
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.DEPARTAMENTO.getId()) {
//        FastTable<TbMunicipioDto> departamento = mantenimientoService.getListaMunicipios(new TbMunicipioDto());
//        for (TbMunicipioDto o : departamento) {
//          if (o.getDepartamento() == null) {
//            Object obj = (Object) o;
//            lista.add(obj);
//          }
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.CUENTA.getId()) {
//        FastTable<ScCuentaDto> cuentas = mantenimientoService.getListaCuentas(new ScCuentaDto());
//        for (ScCuentaDto o : cuentas) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.VALOR_IVA.getId()) {
//        FastTable<ScValorIvaDto> valoresIva = mantenimientoService.getListaValorIva(new ScValorIvaDto());
//        for (ScValorIvaDto o : valoresIva) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.VALOR_RETEFUENTE.getId()) {
//        FastTable<ScValorRetefuenteDto> valoresRetefuente = mantenimientoService.getListaValorRetefuente(new ScValorRetefuenteDto());
//        for (ScValorRetefuenteDto o : valoresRetefuente) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.VALOR_RETEICA.getId()) {
//        FastTable<ScValorReteicaDto> valoresReteica = mantenimientoService.getListaValorReteica(new ScValorReteicaDto());
//        for (ScValorReteicaDto o : valoresReteica) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.MECANISMO_VERIFICACION.getId()) {
//        FastTable<TbMecanismoVerificacionDto> valoresMecanismosVerf = mantenimientoService.getListaMecanismosVerificacion(new TbMecanismoVerificacionDto());
//        for (TbMecanismoVerificacionDto o : valoresMecanismosVerf) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TERCERO.getId()) {
//        FastTable<ScTerceroDto> valoresTerceros = mantenimientoService.getListaTerceros(new ScTerceroDto());
//        for (ScTerceroDto o : valoresTerceros) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.UNIDAD_MEDIDA.getId()) {
//        FastTable<TbUnidadDto> unidades = mantenimientoService.getListaUnidades(new TbUnidadDto());
//        for (TbUnidadDto o : unidades) {
//          if (o.getTipoUnidad() == ETipoUnidad.MEDIDA.getId()) {
//            Object obj = (Object) o;
//            lista.add(obj);
//          }
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.UNIDAD_REFERENCIA.getId()) {
//        FastTable<TbUnidadDto> unidades = mantenimientoService.getListaUnidades(new TbUnidadDto());
//        for (TbUnidadDto o : unidades) {
//          if (o.getTipoUnidad() == ETipoUnidad.REFERENCIA.getId()) {
//            Object obj = (Object) o;
//            lista.add(obj);
//          }
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.UNIDAD_FARMACEUTICA.getId()) {
//        FastTable<TbUnidadDto> unidades = mantenimientoService.getListaUnidades(new TbUnidadDto());
//        for (TbUnidadDto o : unidades) {
//          if (o.getTipoUnidad() == ETipoUnidad.FARMACEUTICA.getId()) {
//            Object obj = (Object) o;
//            lista.add(obj);
//          }
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.SUCURSAL.getId()) {
//        FastTable<CtSucursalDto> sucursales = mantenimientoService.getListaSucursales(new CtSucursalDto());
//        for (CtSucursalDto o : sucursales) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.ASEGURADORA.getId()) {
//        FastTable<TbAseguradoraDto> aseguradoras = mantenimientoService.getListaAseguradoras(new TbAseguradoraDto());
//        for (TbAseguradoraDto o : aseguradoras) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.PROFESION.getId()) {
//        FastTable<ScProfesionDto> profesiones = mantenimientoService.getListaProfesiones(new ScProfesionDto());
//        for (ScProfesionDto o : profesiones) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.FONDO.getId()) {
//        FastTable<ScFondoDto> fondos = mantenimientoService.getListaFondos(new ScFondoDto());
//        for (ScFondoDto o : fondos) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_CUENTA.getId()) {
//        FastTable<TbCuentaDto> cuentas = mantenimientoService.getListaTbCuentas(new TbCuentaDto());
//        for (TbCuentaDto o : cuentas) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TIPO_ESTABLECIMIENTO.getId()) {
//        FastTable<TbTipoEstablecimientoDto> tiposEstablecimiento = mantenimientoService.getListaTiposEstablecimiento(new TbTipoEstablecimientoDto());
//        for (TbTipoEstablecimientoDto o : tiposEstablecimiento) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_GRUPO_ESPECIALIDAD.getId()) {
//        FastTable<GrupoEspecialidadDto> listaGrupoEspecialidad = mantenimientoService.getListaGrupoEspecialidad(new GrupoEspecialidadDto());
//        for (GrupoEspecialidadDto o : listaGrupoEspecialidad) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_ESPECIALIDAD.getId()) {
//        FastTable<EspecialidadDto> listaEspecialidad = mantenimientoService.getListaEspecialidad(new EspecialidadDto());
//        for (EspecialidadDto o : listaEspecialidad) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_TIPO_CONSULTORIO.getId()) {
//        FastTable<TbTipoConsultorioDto> listaTipoConsultorio = mantenimientoService.getListaTipoConsultorios(new TbTipoConsultorioDto());
//        for (TbTipoConsultorioDto o : listaTipoConsultorio) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_HORARIOS.getId()) {
//        FastTable<TbHorarioEncabezadoDto> listaHorario = mantenimientoService.getListaHorarios(new TbHorarioEncabezadoDto());
//        for (TbHorarioEncabezadoDto o : listaHorario) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.CT_PROGRAMA_SERVICIO.getId()) {
//        FastTable<CtProgramaServicioDto> listaPrograma = mantenimientoService.getListaProgramas(new CtProgramaServicioDto());
//        for (CtProgramaServicioDto o : listaPrograma) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.SC_PRODUCTO.getId()) {
//        FastTable<ScProductoDto> listaProducto = mantenimientoService.getListaproducto(new ScProductoDto());
//        for (ScProductoDto o : listaProducto) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_SERVICIOS.getId()) {
//        FastTable<TbServicioDto> listaServicios = mantenimientoService.getListaServicios(new TbServicioDto());
//        for (TbServicioDto o : listaServicios) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.IPS_CUENTAS.getId()) {
//        POJOUsuario usuario = mapper.readValue(Json, POJOUsuario.class);
//        FastTable<TbIpsDto> listaIps = mantenimientoService.getListaIpsCuentas(new TbIpsDto());
//        if (usuario.getListaIpsSeleccionadasLogin() != null && !usuario.getListaIpsSeleccionadasLogin().isEmpty() && (usuario.getSwIndicadorIps() == ESiNo.SI.getId())) {
//          FastSet<Long> llavesIPS = new FastSet<Long>();
//          for (POJOUsuarioIps userIps : usuario.getListaIpsSeleccionadasLogin()) {
//            llavesIPS.add(userIps.getConsecutivoIps());
//          }
//
//          for (TbIpsDto o : listaIps) {
//            if (llavesIPS.contains(o.getConsecutivoIps())) {
//              Object obj = (Object) o;
//              lista.add(obj);
//            }
//          }
//        }
//        else {
//          for (TbIpsDto o : listaIps) {
//            Object obj = (Object) o;
//            lista.add(obj);
//          }
//        }
//
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.CENTROS_COSTO.getId()) {
//        FastTable<ScCentroCostoDto> listaDtos = mantenimientoService.getListaCentrosCosto(new ScCentroCostoDto());
//        for (ScCentroCostoDto o : listaDtos) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.FORMAS_PAGO.getId()) {
//        FastTable<ScFormaPagoDto> listaDtos = mantenimientoService.getListaFormaPago(new ScFormaPagoDto());
//        for (ScFormaPagoDto o : listaDtos) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_IPS.getId()) {
//        // TODO FALTA IPS---es el mismo IPSCUENTAS?
//        // FastTable<TbServicioDto> listaServicios = mantenimientoService.getListai(new TbServicioDto());
//        // for (TbServicioDto o : listaServicios) {
//        // Object obj = (Object) o;
//        // lista.add(obj);
//        // }
//        // listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_MOTIVO_PENDIENTE.getId()) {
//        FastTable<TbMotivoPendienteDto> listaMotivos = mantenimientoService.getListaMotivoPendiente(new TbMotivoPendienteDto());
//        for (TbMotivoPendienteDto o : listaMotivos) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_PERIODO_REPORTE.getId()) {
//        FastTable<TbPeriodoReporteDto> listaPeriodo = mantenimientoService.getListaPeriodoReporte(new TbPeriodoReporteDto());
//        for (TbPeriodoReporteDto o : listaPeriodo) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//      else if (enums.getTipo() == EEnums.TB_TIPO_SOPORTE.getId()) {
//        FastTable<TbTipoSoporteDto> listaTiposSoportes = mantenimientoService.getListaTiposSoporte(new TbTipoSoporteDto());
//        for (TbTipoSoporteDto o : listaTiposSoportes) {
//          Object obj = (Object) o;
//          lista.add(obj);
//        }
//        listaCombo.addAll(this.armarCombo(lista, enums.getTipo()));
//      }
//
//      String jsonInString = mapper.writeValueAsString(listaCombo);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  public FastTable<POJOEnums> armarCombo(FastTable<Object> lista, Short tipo) {
//    FastTable<POJOEnums> listaCombo = new FastTable<POJOEnums>();
//    POJOEnums combo;
//    if (tipo == EEnums.TIPO_IDENTIFICACION.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbTipoIdentificacionDto obj = (TbTipoIdentificacionDto) o;
//        combo.setValue(obj.getTipoIdentificacion().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.CONJUNTO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbConjuntoEncabezadoDto obj = (TbConjuntoEncabezadoDto) o;
//        combo.setValue(obj.getConsecutivoConjunto().toString());
//        combo.setLabel(obj.getNombre());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.EXPRESION.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbConjuntoEncabezadoDto obj = (TbConjuntoEncabezadoDto) o;
//        combo.setValue(obj.getConsecutivoConjunto().toString());
//        combo.setLabel(obj.getNombre());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.CUPS.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbCupDto obj = (TbCupDto) o;
//        combo.setValue(obj.getCup().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.UNIDAD.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbUnidadDto obj = (TbUnidadDto) o;
//        combo.setValue(obj.getConsecutivoUnidad().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.MUNICIPIO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbMunicipioDto obj = (TbMunicipioDto) o;
//        combo.setValue(obj.getMunicipio());
//        combo.setLabel(obj.getDescripcion() + " - " + obj.getDepartamentoTexto());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.DEPARTAMENTO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbMunicipioDto obj = (TbMunicipioDto) o;
//        combo.setValue(obj.getMunicipio());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.CUENTA.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScCuentaDto obj = (ScCuentaDto) o;
//        combo.setValue(obj.getCuenta().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.VALOR_IVA.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScValorIvaDto obj = (ScValorIvaDto) o;
//        combo.setValue(obj.getConsecutivoIva().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.VALOR_RETEFUENTE.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScValorRetefuenteDto obj = (ScValorRetefuenteDto) o;
//        combo.setValue(obj.getConsecutivoRetefuente().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.VALOR_RETEICA.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScValorReteicaDto obj = (ScValorReteicaDto) o;
//        combo.setValue(obj.getConsecutivoReteica().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.MECANISMO_VERIFICACION.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbMecanismoVerificacionDto obj = (TbMecanismoVerificacionDto) o;
//        combo.setValue(obj.getConsecutivoMecanismo().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TERCERO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScTerceroDto obj = (ScTerceroDto) o;
//        combo.setValue(obj.getConsecutivoTercero().toString());
//        combo.setLabel(!Util.vacio(obj.getRazonSocial()) ? obj.getRazonSocial() : obj.getPrimerNombre() + " " + obj.getPrimerApellido());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.UNIDAD_MEDIDA.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbUnidadDto obj = (TbUnidadDto) o;
//        combo.setValue(obj.getConsecutivoUnidad().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.UNIDAD_REFERENCIA.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbUnidadDto obj = (TbUnidadDto) o;
//        combo.setValue(obj.getConsecutivoUnidad().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.UNIDAD_FARMACEUTICA.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbUnidadDto obj = (TbUnidadDto) o;
//        combo.setValue(obj.getConsecutivoUnidad().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.SUCURSAL.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        CtSucursalDto obj = (CtSucursalDto) o;
//        combo.setValue(obj.getConsecutivoSucursal().toString());
//        combo.setLabel(obj.getRazonSocial());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.ASEGURADORA.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbAseguradoraDto obj = (TbAseguradoraDto) o;
//        combo.setValue(obj.getConsecutivoAseguradora().toString());
//        combo.setLabel(obj.getRazonSocial());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.PROFESION.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScProfesionDto obj = (ScProfesionDto) o;
//        combo.setValue(obj.getConsecutivoProfesion().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.FONDO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScFondoDto obj = (ScFondoDto) o;
//        combo.setValue(obj.getConsecutivoFondo().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_CUENTA.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbCuentaDto obj = (TbCuentaDto) o;
//        combo.setValue(obj.getConsecutivoCuenta().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TIPO_ESTABLECIMIENTO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbTipoEstablecimientoDto obj = (TbTipoEstablecimientoDto) o;
//        combo.setValue(obj.getConsecutivoTipoEstablecimiento().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_GRUPO_ESPECIALIDAD.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        GrupoEspecialidadDto obj = (GrupoEspecialidadDto) o;
//        combo.setValue(obj.getGrupoEspecialidad().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_ESPECIALIDAD.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        EspecialidadDto obj = (EspecialidadDto) o;
//        combo.setValue(obj.getEspecialidad().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_TIPO_CONSULTORIO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbTipoConsultorioDto obj = (TbTipoConsultorioDto) o;
//        combo.setValue(obj.getConsecutivoTipo().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_HORARIOS.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbHorarioEncabezadoDto obj = (TbHorarioEncabezadoDto) o;
//        combo.setValue(obj.getConsecutivoHorario().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.CT_PROGRAMA_SERVICIO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        CtProgramaServicioDto obj = (CtProgramaServicioDto) o;
//        combo.setValue(obj.getConsecutivoPrograma().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.SC_PRODUCTO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScProductoDto obj = (ScProductoDto) o;
//        combo.setValue(obj.getConsecutivoProducto() + "");
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_SERVICIOS.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbServicioDto obj = (TbServicioDto) o;
//        combo.setValue(obj.getConsecutivoServicio().toString());
//        combo.setLabel(obj.getNombre());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.IPS_CUENTAS.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbIpsDto obj = (TbIpsDto) o;
//        combo.setValue(obj.getConsecutivoIps().toString());
//        combo.setLabel(obj.getNombre());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.CENTROS_COSTO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScCentroCostoDto obj = (ScCentroCostoDto) o;
//        combo.setValue(obj.getConsecutivoCentroCosto().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.FORMAS_PAGO.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        ScFormaPagoDto obj = (ScFormaPagoDto) o;
//        combo.setValue(obj.getConsecutivoFormaPago().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_IPS.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbIpsDto obj = (TbIpsDto) o;
//        combo.setValue(obj.getConsecutivoIps().toString());
//        combo.setLabel(obj.getNombre());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_MOTIVO_PENDIENTE.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbMotivoPendienteDto obj = (TbMotivoPendienteDto) o;
//        combo.setValue(obj.getConsecutivoMotivo() + "");
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_PERIODO_REPORTE.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbPeriodoReporteDto obj = (TbPeriodoReporteDto) o;
//        combo.setValue(obj.getConsecutivoReporte().toString());
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//    else if (tipo == EEnums.TB_TIPO_SOPORTE.getId()) {
//      for (Object o : lista) {
//        combo = new POJOEnums();
//        TbTipoSoporteDto obj = (TbTipoSoporteDto) o;
//        combo.setValue(String.valueOf(obj.getConsecutivoSoporte()));
//        combo.setLabel(obj.getDescripcion());
//        listaCombo.add(combo);
//      }
//    }
//
//    return listaCombo;
//  }
//
//  @POST
//  @Path("/getModulos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getModulos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbModulo moduloPOJO = mapper.readValue(Json, POJOTbModulo.class);
//      TbModuloDto moduloFiltro = new TbModuloDto();
//      moduloFiltro.setConsecutivoModulo(moduloPOJO.getConsecutivoModulo());
//      moduloFiltro.setNombre(moduloPOJO.getNombre());
//      FastTable<TbModuloDto> modulos = mantenimientoService.getListaModulos(moduloFiltro);
//
//      List<POJOTbModulo> modulosPOJO = new ArrayList<POJOTbModulo>();
//      for (TbModuloDto modulo : modulos) {
//        POJOTbModulo pojoModulo = new POJOTbModulo();
//        BeanUtils.copyProperties(modulo, pojoModulo);
//        pojoModulo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoModulo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        modulosPOJO.add(pojoModulo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(modulosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteModulo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteModulo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbModulo
//    try {
//      String path = "saveOrUpdateOrDeleteModulo";
//      ObjectMapper mapper = new ObjectMapper();
//      TbModuloDto moduloDto = new TbModuloDto();
//      POJOTbModulo modulo = mapper.readValue(Json, POJOTbModulo.class);
//
//      BeanUtils.copyProperties(modulo, moduloDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(modulo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(modulo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) moduloDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteModulo(moduloDto, modulo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getSubModulos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getSubModulos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbSubmodulo submoduloPOJO = mapper.readValue(Json, POJOTbSubmodulo.class);
//      TbSubmoduloDto submoduloFiltro = new TbSubmoduloDto();
//      submoduloFiltro.setConsecutivoSubmodulo(submoduloPOJO.getConsecutivoSubmodulo());
//      submoduloFiltro.setNombre(submoduloPOJO.getNombre());
//      FastTable<TbSubmoduloDto> submodulos = mantenimientoService.getListaSubModulos(submoduloFiltro);
//
//      List<POJOTbSubmodulo> submodulosPOJO = new ArrayList<POJOTbSubmodulo>();
//      for (TbSubmoduloDto submodulo : submodulos) {
//        POJOTbSubmodulo pojoSubmodulo = new POJOTbSubmodulo();
//        BeanUtils.copyProperties(submodulo, pojoSubmodulo);
//        pojoSubmodulo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoSubmodulo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        submodulosPOJO.add(pojoSubmodulo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(submodulosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteSubModulo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteSubModulo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbSubModulo
//    try {
//      String path = "saveOrUpdateOrDeleteSubModulo";
//      ObjectMapper mapper = new ObjectMapper();
//      TbSubmoduloDto submoduloDto = new TbSubmoduloDto();
//      POJOTbSubmodulo submodulo = mapper.readValue(Json, POJOTbSubmodulo.class);
//
//      BeanUtils.copyProperties(submodulo, submoduloDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(submodulo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(submodulo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) submoduloDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteSubModulo(submoduloDto, submodulo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/uploadImportInsumosMasivo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response uploadImportInsumosMasivo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOFileUpload filePOJO = mapper.readValue(Json, POJOFileUpload.class);
//
//      // byte[] name = Base64.getEncoder().encode("hello World".getBytes());
//      // byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
//
//      InputStream stream = new ByteArrayInputStream(filePOJO.getContentDecodeB64().getBytes(StandardCharsets.UTF_8));
//      FastTable<String> lista = FileUtilities.toListFileStringPipe(stream);
//      lista.remove(0);
//
//      int LONGITUD_REF = 6;
//      FastTable<String> listaErroresEstructura = new FastTable<String>();
//      FastTable<String> listaErroresContenido = new FastTable<String>();
//
//      // validando que no venga vacío el archivo
//      if (lista.isEmpty()) {
//        ArrayList<String> errores = new ArrayList<String>();
//        String error = "El archivo se encuentra vacío o su contenido no es suficiente para la importación. Por favor Revise el fichero.";
//        errores.add(error);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//
//      // Validando Estructura
//      int i = 1;
//      for (String linea : lista) {
//        int longitud = linea.split("\\|").length;
//        if (longitud != LONGITUD_REF) {
//          listaErroresEstructura.add("Línea #" + i + ": (" + linea + ") - ERROR => No cumple con la estructura - Cant. Permitida: " + LONGITUD_REF);
//        }
//
//        i++;
//      }
//
//      // Validando Contenido
//      if (listaErroresEstructura.isEmpty()) {
//        int j = 1;
//
//        final int CODIGO_INTERNO = 0;
//        final int DESCRIPCION = 1;
//        final int POS = 2;
//        final int SERVICIO_ESPECIAL = 3;
//        final int VALOR = 4;
//        final int ACTIVO = 5;
//        FastTable<TbInsumoDto> insumosImportar = new FastTable<TbInsumoDto>();
//        FastSet<String> codigosInternos = new FastSet<String>();
//
//        for (String linea : lista) {
//          TbInsumoDto insumoDto = new TbInsumoDto();
//          String[] campos = linea.split("\\|");
//          // Estructura: Código Interno|Descripción|P.O.S.|Servicio Especial|Valor|Activo
//          // CINS10|Insumo Importado 10|0|1|300000|1
//
//          insumoDto.setCodigoInterno(!Util.vacio(campos[CODIGO_INTERNO]) ? campos[CODIGO_INTERNO] : null);
//          insumoDto.setDescripcion(!Util.vacio(campos[DESCRIPCION]) ? campos[DESCRIPCION] : null);
//          insumoDto.setSwPos(!Util.vacio(campos[POS]) ? (Util.isNumber(campos[POS]) ? Short.parseShort(campos[POS]) : -1) : -1);
//          insumoDto.setServicioEspecial(!Util.vacio(campos[SERVICIO_ESPECIAL]) ? (Util.isNumber(campos[SERVICIO_ESPECIAL]) ? Short.parseShort(campos[SERVICIO_ESPECIAL]) : -1) : null);
//          insumoDto.setValor(!Util.vacio(campos[VALOR]) ? (Util.isNumber(campos[VALOR]) ? Double.parseDouble(campos[VALOR]) : -1) : -1);
//          insumoDto.setSwActivo(!Util.vacio(campos[ACTIVO]) ? (Util.isNumber(campos[ACTIVO]) ? Short.parseShort(campos[ACTIVO]) : -1) : -1);
//          boolean flag = true;
//
//          String errorLinea = "Línea #" + j + ": (" + linea + ") - ";
//          if (insumoDto.getCodigoInterno() == null) {
//            errorLinea = errorLinea + "(ERROR => Código Interno): -Texto- Campo Obligatorio vacío. ";
//            flag = false;
//          }
//          else {
//            if (!codigosInternos.contains(insumoDto.getCodigoInterno())) {
//              codigosInternos.add(insumoDto.getCodigoInterno());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Código Interno): -Texto- Ya existe el código en otra línea del archivo para importar. ";
//              flag = false;
//            }
//          }
//          if (insumoDto.getDescripcion() == null) {
//            errorLinea = errorLinea + "(ERROR => Descripción): -Texto- Campo Obligatorio vacío. ";
//            flag = false;
//          }
//          if (insumoDto.getSwPos() != ESiNo.SI.getId() && insumoDto.getSwPos() != ESiNo.NO.getId()) {
//            errorLinea = errorLinea + "(ERROR => P.O.S.): -Numérico- Valor no aceptado. (Opciones " + Util.getStringOfValuesEnumeration(ESiNo.values()) + "). ";
//            flag = false;
//          }
//          if (insumoDto.getServicioEspecial() != null) {
//            if (insumoDto.getServicioEspecial() != ETipoServicioEspecialInsumo.EXCLUSION.getId() && insumoDto.getServicioEspecial() != ETipoServicioEspecialInsumo.NO_FINANCIADO.getId()) {
//              errorLinea = errorLinea + "(ERROR => Servicio Especial): -Numérico- Valor no aceptado. (Opciones " + Util.getStringOfValuesEnumeration(ETipoServicioEspecialInsumo.values()) + "). ";
//              flag = false;
//            }
//          }
//          if (insumoDto.getValor() < 0) {
//            errorLinea = errorLinea + "(ERROR => Valor): -Numérico- Debe ser mayor a cero o no es número. ";
//            flag = false;
//          }
//          if (insumoDto.getSwActivo() != ESiNo.SI.getId() && insumoDto.getSwActivo() != ESiNo.NO.getId()) {
//            errorLinea = errorLinea + "(ERROR => Activo): -Numérico- Valor no aceptado. (Opciones " + Util.getStringOfValuesEnumeration(ESiNo.values()) + "). ";
//            flag = false;
//          }
//
//          if (!flag) {
//            listaErroresContenido.add(errorLinea);
//          }
//          else {
//            insumosImportar.add(insumoDto);
//          }
//
//          j++;
//        }
//
//        if (listaErroresContenido.isEmpty()) {
//          boolean correcto = mantenimientoService.saveOrUpdateMasivoInsumo(insumosImportar);
//          if (correcto) {
//            return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//          }
//          else {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//          }
//        }
//        else {
//          ArrayList<String> errores = new ArrayList<String>();
//          errores.addAll(listaErroresEstructura);
//          errores.addAll(listaErroresContenido);
//          filePOJO.setErrores(errores);
//          filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//          filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//          String jsonInString = mapper.writeValueAsString(filePOJO);
//
//          return Response.ok(jsonInString).build();
//        }
//      }
//      else {
//        ArrayList<String> errores = new ArrayList<String>();
//        errores.addAll(listaErroresEstructura);
//        errores.addAll(listaErroresContenido);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getUnidades")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getUnidades(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbUnidad unidadPOJO = mapper.readValue(Json, POJOTbUnidad.class);
//      TbUnidadDto unidadFiltro = new TbUnidadDto();
//      unidadFiltro.setCodigoInterno(unidadPOJO.getCodigoInterno());
//      unidadFiltro.setDescripcion(unidadPOJO.getDescripcion());
//      FastTable<TbUnidadDto> unidades = mantenimientoService.getListaUnidades(unidadFiltro);
//
//      List<POJOTbUnidad> unidadesPOJO = new ArrayList<POJOTbUnidad>();
//      for (TbUnidadDto unidad : unidades) {
//        POJOTbUnidad pojoUnidad = new POJOTbUnidad();
//        BeanUtils.copyProperties(unidad, pojoUnidad);
//        pojoUnidad.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoUnidad.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        unidadesPOJO.add(pojoUnidad);
//      }
//
//      String jsonInString = mapper.writeValueAsString(unidadesPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteUnidad")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteUnidad(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbUnidad
//    try {
//      String path = "saveOrUpdateOrDeleteUnidad";
//      ObjectMapper mapper = new ObjectMapper();
//      TbUnidadDto unidadDto = new TbUnidadDto();
//      POJOTbUnidad unidad = mapper.readValue(Json, POJOTbUnidad.class);
//
//      BeanUtils.copyProperties(unidad, unidadDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(unidad.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(unidad.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) unidadDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else {
//          FastTable<TbUnidadDto> unidades = mantenimientoService.getListaUnidades(new TbUnidadDto());
//          boolean flag = true;
//          for (TbUnidadDto obj : unidades) {
//            if (EAccion.ADD.getText().equalsIgnoreCase(unidad.getStatusAction())) {
//              if (obj.getCodigoInterno().equals(unidadDto.getCodigoInterno())) {
//                flag = false;
//                break;
//              }
//            }
//            else {
//              if (obj.getConsecutivoUnidad() != unidadDto.getConsecutivoUnidad() && obj.getCodigoInterno().equals(unidadDto.getCodigoInterno())) {
//                flag = false;
//                break;
//              }
//            }
//          }
//
//          if (!flag) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId()));
//          }
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteUnidad(unidadDto, unidad.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getMunicipios")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getMunicipios(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbMunicipio municipioPOJO = mapper.readValue(Json, POJOTbMunicipio.class);
//      TbMunicipioDto municipioFiltro = new TbMunicipioDto();
//      municipioFiltro.setMunicipio(municipioPOJO.getMunicipio());
//      municipioFiltro.setDescripcion(municipioPOJO.getDescripcion());
//      municipioFiltro.setDepartamento(municipioPOJO.getDepartamento());
//      FastTable<TbMunicipioDto> municipios = mantenimientoService.getListaMunicipios(municipioFiltro);
//
//      List<POJOTbMunicipio> municipiosPOJO = new ArrayList<POJOTbMunicipio>();
//      for (TbMunicipioDto municipio : municipios) {
//        POJOTbMunicipio pojoMunicipio = new POJOTbMunicipio();
//        BeanUtils.copyProperties(municipio, pojoMunicipio);
//        pojoMunicipio.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoMunicipio.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        municipiosPOJO.add(pojoMunicipio);
//      }
//
//      String jsonInString = mapper.writeValueAsString(municipiosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteMunicipio")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteMunicipio(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbMunicipio
//    try {
//      String path = "saveOrUpdateOrDeleteMunicipio";
//      ObjectMapper mapper = new ObjectMapper();
//      TbMunicipioDto municipioDto = new TbMunicipioDto();
//      POJOTbMunicipio municipio = mapper.readValue(Json, POJOTbMunicipio.class);
//
//      BeanUtils.copyProperties(municipio, municipioDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(municipio.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(municipio.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) municipioDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteMunicipio(municipioDto, municipio.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteExamen")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteExamen(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteExamen";
//      ObjectMapper mapper = new ObjectMapper();
//      TbExamenEncabezadoDto dto = new TbExamenEncabezadoDto();
//      POJOTbExamenEcabezado pojo = mapper.readValue(Json, POJOTbExamenEcabezado.class);
//
//      FastTable<TbExamenDetalleDto> detalles = new FastTable<TbExamenDetalleDto>();
//      for (POJOTbExamenDetalle d : pojo.getExamenesDetalles()) {
//        TbExamenDetalleDto detalle = new TbExamenDetalleDto();
//        BeanUtils.copyProperties(d, detalle);
//        detalles.add(detalle);
//      }
//      BeanUtils.copyProperties(pojo, dto);
//      dto.setExamenesDetalles(new FastTable<TbExamenDetalleDto>());
//      dto.getExamenesDetalles().addAll(detalles);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteExamen(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getLaboratorios")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getLaboratorios(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbLaboratorio laboratorioPOJO = mapper.readValue(Json, POJOTbLaboratorio.class);
//      TbLaboratorioDto laboratorioFiltro = new TbLaboratorioDto();
//      laboratorioFiltro.setConsecutivoLaboratorio(laboratorioPOJO.getConsecutivoLaboratorio());
//      laboratorioFiltro.setMunicipio(laboratorioPOJO.getMunicipio());
//      laboratorioFiltro.setDescripcion(laboratorioPOJO.getDescripcion());
//      FastTable<TbLaboratorioDto> laboratorios = mantenimientoService.getListaLaboratorios(laboratorioFiltro);
//
//      List<POJOTbLaboratorio> laboratoriosPOJO = new ArrayList<POJOTbLaboratorio>();
//      for (TbLaboratorioDto laboratorio : laboratorios) {
//        POJOTbLaboratorio pojoLaboratorio = new POJOTbLaboratorio();
//        BeanUtils.copyProperties(laboratorio, pojoLaboratorio);
//        pojoLaboratorio.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoLaboratorio.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        laboratoriosPOJO.add(pojoLaboratorio);
//      }
//
//      String jsonInString = mapper.writeValueAsString(laboratoriosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteLaboratorio")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteLaboratorio(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbLaboratorio
//    try {
//      String path = "saveOrUpdateOrDeleteLaboratorio";
//      ObjectMapper mapper = new ObjectMapper();
//      TbLaboratorioDto laboratorioDto = new TbLaboratorioDto();
//      POJOTbLaboratorio laboratorio = mapper.readValue(Json, POJOTbLaboratorio.class);
//
//      BeanUtils.copyProperties(laboratorio, laboratorioDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(laboratorio.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(laboratorio.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) laboratorioDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteLaboratorio(laboratorioDto, laboratorio.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getCentrosCosto")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getCentrosCosto(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOScCentroCosto centroCostoPOJO = mapper.readValue(Json, POJOScCentroCosto.class);
//      ScCentroCostoDto centroCostoFiltro = new ScCentroCostoDto();
//      centroCostoFiltro.setConsecutivoCentroCosto(centroCostoPOJO.getConsecutivoCentroCosto());
//      centroCostoFiltro.setDescripcion(centroCostoPOJO.getDescripcion());
//      FastTable<ScCentroCostoDto> centrosCostos = mantenimientoService.getListaCentrosCosto(centroCostoFiltro);
//
//      List<POJOScCentroCosto> centrosCostosPOJO = new ArrayList<POJOScCentroCosto>();
//      for (ScCentroCostoDto centroCosto : centrosCostos) {
//        POJOScCentroCosto pojoCentroCosto = new POJOScCentroCosto();
//        BeanUtils.copyProperties(centroCosto, pojoCentroCosto);
//        pojoCentroCosto.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoCentroCosto.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        centrosCostosPOJO.add(pojoCentroCosto);
//      }
//
//      String jsonInString = mapper.writeValueAsString(centrosCostosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteCentroCosto")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteCentroCosto(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbCentroCosto
//    try {
//      String path = "saveOrUpdateOrDeleteCentroCosto";
//      ObjectMapper mapper = new ObjectMapper();
//      ScCentroCostoDto centroCostoDto = new ScCentroCostoDto();
//      POJOScCentroCosto centroCosto = mapper.readValue(Json, POJOScCentroCosto.class);
//
//      BeanUtils.copyProperties(centroCosto, centroCostoDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(centroCosto.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(centroCosto.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) centroCostoDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteCentroCosto(centroCostoDto, centroCosto.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getTipoIdentificacion")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getTipoIdentificacion(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbTipoIdentificacion tipoIdentificacionPOJO = mapper.readValue(Json, POJOTbTipoIdentificacion.class);
//      TbTipoIdentificacionDto tipoIdentificacionFiltro = new TbTipoIdentificacionDto();
//      tipoIdentificacionFiltro.setTipoIdentificacion(tipoIdentificacionPOJO.getTipoIdentificacion());
//      tipoIdentificacionFiltro.setAbreviatura(tipoIdentificacionPOJO.getAbreviatura());
//      tipoIdentificacionFiltro.setDescripcion(tipoIdentificacionPOJO.getDescripcion());
//      FastTable<TbTipoIdentificacionDto> tiposIdentificacion = mantenimientoService.getListaTiposDocumento(tipoIdentificacionFiltro);
//
//      List<POJOTbTipoIdentificacion> tiposIdentificacionesPOJO = new ArrayList<POJOTbTipoIdentificacion>();
//      for (TbTipoIdentificacionDto tipoIdentificacion : tiposIdentificacion) {
//        POJOTbTipoIdentificacion pojoTipoIdentificacion = new POJOTbTipoIdentificacion();
//        BeanUtils.copyProperties(tipoIdentificacion, pojoTipoIdentificacion);
//        pojoTipoIdentificacion.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoTipoIdentificacion.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        tiposIdentificacionesPOJO.add(pojoTipoIdentificacion);
//      }
//
//      String jsonInString = mapper.writeValueAsString(tiposIdentificacionesPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteTipoIdentificacion")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteTipoIdentificacion(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbTipoIdentificacion
//    try {
//      String path = "saveOrUpdateOrDeleteTipoIdentificacion";
//      ObjectMapper mapper = new ObjectMapper();
//      TbTipoIdentificacionDto tipoIdentificacionDto = new TbTipoIdentificacionDto();
//      POJOTbTipoIdentificacion tipoIdentificacion = mapper.readValue(Json, POJOTbTipoIdentificacion.class);
//
//      BeanUtils.copyProperties(tipoIdentificacion, tipoIdentificacionDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(tipoIdentificacion.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(tipoIdentificacion.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) tipoIdentificacionDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteTipoIdentificacion(tipoIdentificacionDto, tipoIdentificacion.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getCuentas")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getCuentas(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOScCuenta cuentaPOJO = mapper.readValue(Json, POJOScCuenta.class);
//      ScCuentaDto cuentaFiltro = new ScCuentaDto();
//      cuentaFiltro.setCodigo(cuentaPOJO.getCodigo());
//      cuentaFiltro.setDescripcion(cuentaPOJO.getDescripcion());
//      FastTable<ScCuentaDto> cuentas = mantenimientoService.getListaCuentas(cuentaFiltro);
//
//      List<POJOScCuenta> cuentasPOJO = new ArrayList<POJOScCuenta>();
//      for (ScCuentaDto cuenta : cuentas) {
//        POJOScCuenta pojoCuenta = new POJOScCuenta();
//        BeanUtils.copyProperties(cuenta, pojoCuenta);
//        pojoCuenta.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoCuenta.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        cuentasPOJO.add(pojoCuenta);
//      }
//
//      String jsonInString = mapper.writeValueAsString(cuentasPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteCuenta")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteCuenta(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbCuenta
//    try {
//      String path = "saveOrUpdateOrDeleteCuenta";
//      ObjectMapper mapper = new ObjectMapper();
//      ScCuentaDto cuentaDto = new ScCuentaDto();
//      POJOScCuenta cuenta = mapper.readValue(Json, POJOScCuenta.class);
//
//      BeanUtils.copyProperties(cuenta, cuentaDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(cuenta.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(cuenta.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) cuentaDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteCuenta(cuentaDto, cuenta.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getValorRetefuente")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getValorRetefuente(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOScValorRetefuente valorRetefuentePOJO = mapper.readValue(Json, POJOScValorRetefuente.class);
//      ScValorRetefuenteDto valorRetefuenteFiltro = new ScValorRetefuenteDto();
//
//      valorRetefuenteFiltro.setConsecutivoRetefuente(valorRetefuentePOJO.getConsecutivoRetefuente());
//      valorRetefuenteFiltro.setDescripcion(valorRetefuentePOJO.getDescripcion());
//      FastTable<ScValorRetefuenteDto> valorRetefuente = mantenimientoService.getListaValorRetefuente(valorRetefuenteFiltro);
//
//      List<POJOScValorRetefuente> retefuentePOJO = new ArrayList<POJOScValorRetefuente>();
//
//      for (ScValorRetefuenteDto dto : valorRetefuente) {
//        POJOScValorRetefuente pojo = new POJOScValorRetefuente();
//        BeanUtils.copyProperties(dto, pojo);
//        retefuentePOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(retefuentePOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getValorIva")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getValorIva(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOScValorIva valorIvaPOJO = mapper.readValue(Json, POJOScValorIva.class);
//      ScValorIvaDto valorIvaFiltro = new ScValorIvaDto();
//
//      valorIvaFiltro.setConsecutivoIva(valorIvaPOJO.getConsecutivoIva());
//      valorIvaFiltro.setDescripcion(valorIvaPOJO.getDescripcion());
//      FastTable<ScValorIvaDto> valorIva = mantenimientoService.getListaValorIva(valorIvaFiltro);
//
//      List<POJOScValorIva> ivaPOJO = new ArrayList<POJOScValorIva>();
//
//      for (ScValorIvaDto dto : valorIva) {
//        POJOScValorIva pojo = new POJOScValorIva();
//        BeanUtils.copyProperties(dto, pojo);
//        pojo.setSwActivoTexto(ESiNo.getName(pojo.getSwActivo()));
//        ivaPOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(ivaPOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteValorRetefuente")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteValorRetefuente(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteValorRetefuente";
//      ObjectMapper mapper = new ObjectMapper();
//      ScValorRetefuenteDto dto = new ScValorRetefuenteDto();
//      POJOScValorRetefuente pojo = mapper.readValue(Json, POJOScValorRetefuente.class);
//      BeanUtils.copyProperties(pojo, dto);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteValorRetefuente(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteValorIva")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteValorIva(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteValorIva";
//      ObjectMapper mapper = new ObjectMapper();
//      ScValorIvaDto dto = new ScValorIvaDto();
//      POJOScValorIva pojo = mapper.readValue(Json, POJOScValorIva.class);
//      BeanUtils.copyProperties(pojo, dto);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteValorIva(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getFormaPago")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getFormaPago(String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOScFormaPago formaPagoPOJO = mapper.readValue(Json, POJOScFormaPago.class);
//      ScFormaPagoDto formaPagoFiltro = new ScFormaPagoDto();
//
//      formaPagoFiltro.setConsecutivoFormaPago(formaPagoPOJO.getConsecutivoFormaPago());
//      formaPagoFiltro.setDescripcion(formaPagoPOJO.getDescripcion());
//      FastTable<ScFormaPagoDto> formaPago = mantenimientoService.getListaFormaPago(formaPagoFiltro);
//
//      List<POJOScFormaPago> resultadoPOJO = new ArrayList<POJOScFormaPago>();
//
//      for (ScFormaPagoDto dto : formaPago) {
//        POJOScFormaPago pojo = new POJOScFormaPago();
//        BeanUtils.copyProperties(dto, pojo);
//        resultadoPOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(resultadoPOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteFormaPago")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteFormaPago(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteFormaPago";
//      ObjectMapper mapper = new ObjectMapper();
//      ScFormaPagoDto dto = new ScFormaPagoDto();
//      POJOScFormaPago pojo = mapper.readValue(Json, POJOScFormaPago.class);
//      BeanUtils.copyProperties(pojo, dto);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteFormaPago(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getReteicas")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getReteicas(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOScValorReteica valorReteicaPOJO = mapper.readValue(Json, POJOScValorReteica.class);
//      ScValorReteicaDto valorReteicaFiltro = new ScValorReteicaDto();
//
//      valorReteicaFiltro.setConsecutivoReteica(valorReteicaPOJO.getConsecutivoReteica());
//      valorReteicaFiltro.setDescripcion(valorReteicaPOJO.getDescripcion());
//      FastTable<ScValorReteicaDto> valorReteica = mantenimientoService.getListaValorReteica(valorReteicaFiltro);
//
//      List<POJOScValorReteica> reteicaPOJO = new ArrayList<POJOScValorReteica>();
//
//      for (ScValorReteicaDto dto : valorReteica) {
//        POJOScValorReteica pojo = new POJOScValorReteica();
//        BeanUtils.copyProperties(dto, pojo);
//        pojo.setSwActivoTexto(dto.getSwActivoTexto());
//        reteicaPOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(reteicaPOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteReteica")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteReteica(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteReteica";
//      ObjectMapper mapper = new ObjectMapper();
//      ScValorReteicaDto dto = new ScValorReteicaDto();
//      POJOScValorReteica pojo = mapper.readValue(Json, POJOScValorReteica.class);
//      BeanUtils.copyProperties(pojo, dto);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteValorReteica(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getProductos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getProductos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOScProducto productoPOJO = mapper.readValue(Json, POJOScProducto.class);
//      ScProductoDto productoFiltro = new ScProductoDto();
//
//      productoFiltro.setCodigoBarra(productoPOJO.getCodigoBarra());
//      productoFiltro.setDescripcion(productoPOJO.getDescripcion());
//      FastTable<ScProductoDto> producto = mantenimientoService.getListaproducto(productoFiltro);
//
//      List<POJOScProducto> productosPOJO = new ArrayList<POJOScProducto>();
//
//      for (ScProductoDto dto : producto) {
//        POJOScProducto pojo = new POJOScProducto();
//        BeanUtils.copyProperties(dto, pojo);
//        productosPOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(productosPOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteProducto")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteProducto(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteProducto";
//      ObjectMapper mapper = new ObjectMapper();
//      ScProductoDto dto = new ScProductoDto();
//      POJOScProducto pojo = mapper.readValue(Json, POJOScProducto.class);
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else {
//          FastTable<ScProductoDto> productos = mantenimientoService.getListaproducto(new ScProductoDto());
//          boolean flag = true;
//          for (ScProductoDto obj : productos) {
//            if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//              if (obj.getCodigoBarra().equals(dto.getCodigoBarra())) {
//                flag = false;
//                break;
//              }
//            }
//            else {
//              if (obj.getConsecutivoProducto() != dto.getConsecutivoProducto() && obj.getCodigoBarra().equals(dto.getCodigoBarra())) {
//                flag = false;
//                break;
//              }
//            }
//          }
//
//          if (!flag) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_BARRAS_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_BARRAS_REPETIDO.getId()));
//          }
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteProducto(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getTerceros")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getTerceros(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOScTercero POJO = mapper.readValue(Json, POJOScTercero.class);
//      ScTerceroDto filtro = new ScTerceroDto();
//      filtro.setTipoIdentificacion(POJO.getTipoIdentificacion());
//      filtro.setNroIdentificacion(POJO.getNroIdentificacion());
//      filtro.setRazonSocial(POJO.getRazonSocial());
//      FastTable<ScTerceroDto> listaDtos = mantenimientoService.getListaTerceros(filtro);
//
//      List<POJOScTercero> listaPOJO = new ArrayList<POJOScTercero>();
//      for (ScTerceroDto dtoObj : listaDtos) {
//        POJOScTercero pojoObj = new POJOScTercero();
//        BeanUtils.copyProperties(dtoObj, pojoObj);
//        pojoObj.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoObj.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        listaPOJO.add(pojoObj);
//      }
//
//      String jsonInString = mapper.writeValueAsString(listaPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteTercero")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteTercero(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = scTercero
//    try {
//      String path = "saveOrUpdateOrDeleteTercero";
//      ObjectMapper mapper = new ObjectMapper();
//      ScTerceroDto dto = new ScTerceroDto();
//      POJOScTercero pojo = mapper.readValue(Json, POJOScTercero.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteTercero(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getMecanismosVerificacion")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getMecanismosVerificacion(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbMecanismoVerificacion POJO = mapper.readValue(Json, POJOTbMecanismoVerificacion.class);
//      TbMecanismoVerificacionDto filtro = new TbMecanismoVerificacionDto();
//      filtro.setConsecutivoMecanismo(POJO.getConsecutivoMecanismo());
//      filtro.setCodigo(POJO.getCodigo());
//      filtro.setDescripcion(POJO.getDescripcion());
//      FastTable<TbMecanismoVerificacionDto> listaDtos = mantenimientoService.getListaMecanismosVerificacion(filtro);
//
//      List<POJOTbMecanismoVerificacion> listaPOJO = new ArrayList<POJOTbMecanismoVerificacion>();
//      for (TbMecanismoVerificacionDto dtoObj : listaDtos) {
//        POJOTbMecanismoVerificacion pojoObj = new POJOTbMecanismoVerificacion();
//        BeanUtils.copyProperties(dtoObj, pojoObj);
//        pojoObj.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoObj.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        listaPOJO.add(pojoObj);
//      }
//
//      String jsonInString = mapper.writeValueAsString(listaPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteMecanismoVerificacion")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteMecanismoVerificacion(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tsMecanismoVerificacion
//    try {
//      String path = "saveOrUpdateOrDeleteMecanismoVerificacion";
//      ObjectMapper mapper = new ObjectMapper();
//      TbMecanismoVerificacionDto dto = new TbMecanismoVerificacionDto();
//      POJOTbMecanismoVerificacion pojo = mapper.readValue(Json, POJOTbMecanismoVerificacion.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteMecanismoVerificacion(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getSucursales")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getSucursales(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOCtSucursal POJO = mapper.readValue(Json, POJOCtSucursal.class);
//      CtSucursalDto filtro = new CtSucursalDto();
//      filtro.setNit(POJO.getNit());
//      filtro.setRazonSocial(POJO.getRazonSocial());
//      filtro.setCodigoInterno(POJO.getCodigoInterno());
//      filtro.setCodigoPrestador(POJO.getCodigoPrestador());
//      FastTable<CtSucursalDto> listaDtos = mantenimientoService.getListaSucursales(filtro);
//
//      List<POJOCtSucursal> listaPOJO = new ArrayList<POJOCtSucursal>();
//      for (CtSucursalDto dtoObj : listaDtos) {
//        POJOCtSucursal pojoObj = new POJOCtSucursal();
//        BeanUtils.copyProperties(dtoObj, pojoObj);
//        pojoObj.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoObj.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        listaPOJO.add(pojoObj);
//      }
//
//      String jsonInString = mapper.writeValueAsString(listaPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteSucursal")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteSucursal(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = ctSucursal
//    try {
//      String path = "saveOrUpdateOrDeleteSucursal";
//      ObjectMapper mapper = new ObjectMapper();
//      CtSucursalDto dto = new CtSucursalDto();
//      POJOCtSucursal pojo = mapper.readValue(Json, POJOCtSucursal.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else {
//          FastTable<CtSucursalDto> sucursales = mantenimientoService.getListaSucursales(new CtSucursalDto());
//          boolean flag = true;
//          for (CtSucursalDto obj : sucursales) {
//            if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//              if (obj.getCodigoInterno().equals(dto.getCodigoInterno())) {
//                flag = false;
//                break;
//              }
//            }
//            else {
//              if (obj.getConsecutivoSucursal() != dto.getConsecutivoSucursal() && obj.getCodigoInterno().equals(dto.getCodigoInterno())) {
//                flag = false;
//                break;
//              }
//            }
//          }
//
//          if (!flag) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId()));
//          }
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteSucursal(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getTiposFactura")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getTiposFactura(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOScTipoFactura POJO = mapper.readValue(Json, POJOScTipoFactura.class);
//      ScTipoFacturaDto filtro = new ScTipoFacturaDto();
//      filtro.setConsecutivoTipoFactura(POJO.getConsecutivoTipoFactura());
//      filtro.setDescripcion(POJO.getDescripcion());
//      FastTable<ScTipoFacturaDto> listaDtos = mantenimientoService.getListaTiposFactura(filtro);
//
//      List<POJOScTipoFactura> listaPOJO = new ArrayList<POJOScTipoFactura>();
//      for (ScTipoFacturaDto dtoObj : listaDtos) {
//        POJOScTipoFactura pojoObj = new POJOScTipoFactura();
//        BeanUtils.copyProperties(dtoObj, pojoObj);
//        pojoObj.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoObj.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        listaPOJO.add(pojoObj);
//      }
//
//      String jsonInString = mapper.writeValueAsString(listaPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteTipoFactura")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteTipoFactura(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = scTipoFactura
//    try {
//      String path = "saveOrUpdateOrDeleteTipoFactura";
//      ObjectMapper mapper = new ObjectMapper();
//      ScTipoFacturaDto dto = new ScTipoFacturaDto();
//      POJOScTipoFactura pojo = mapper.readValue(Json, POJOScTipoFactura.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteTipoFactura(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/updatePassUser")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response updatePassUser(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "updatePassUser";
//      ObjectMapper mapper = new ObjectMapper();
//      UsuarioDto dto = new UsuarioDto();
//      POJOUsuario pojo = mapper.readValue(Json, POJOUsuario.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      String textoValidaciones = this.validaciones(path, (Object) dto);
//      if (!Util.vacio(textoValidaciones)) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//      }
//
//      boolean correcto = mantenimientoService.updatePassUser(dto);
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getMedicamentos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getMedicamentos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbMedicamento medicamentoPOJO = mapper.readValue(Json, POJOTbMedicamento.class);
//      TbMedicamentoDto medicamentoFiltro = new TbMedicamentoDto();
//      medicamentoFiltro.setProducto(medicamentoPOJO.getProducto());
//      medicamentoFiltro.setDescripcionComercial(medicamentoPOJO.getDescripcionComercial());
//      medicamentoFiltro.setTitular(medicamentoPOJO.getTitular());
//      medicamentoFiltro.setExpedienteCum(medicamentoPOJO.getExpedienteCum());
//      medicamentoFiltro.setAtc(medicamentoPOJO.getAtc());
//
//      medicamentoFiltro.setExpediente(medicamentoPOJO.getExpediente());
//      medicamentoFiltro.setRegistroSanitario(medicamentoPOJO.getRegistroSanitario());
//      medicamentoFiltro.setPrincipioActivo(medicamentoPOJO.getPrincipioActivo());
//      medicamentoFiltro.setUnidadReferencia(medicamentoPOJO.getUnidadReferencia());
//      medicamentoFiltro.setUnidadFormaFarmaceutica(medicamentoPOJO.getUnidadFormaFarmaceutica());
//      FastTable<TbMedicamentoDto> medicamentos = mantenimientoService.getListaMedicamentos(medicamentoFiltro);
//
//      List<POJOTbMedicamento> medicamentosPOJO = new ArrayList<POJOTbMedicamento>();
//      for (TbMedicamentoDto medicamento : medicamentos) {
//        POJOTbMedicamento pojoMedicamento = new POJOTbMedicamento();
//        BeanUtils.copyProperties(medicamento, pojoMedicamento);
//        pojoMedicamento.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoMedicamento.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        medicamentosPOJO.add(pojoMedicamento);
//      }
//
//      String jsonInString = mapper.writeValueAsString(medicamentosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteMedicamento")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteMedicamento(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbInsumo
//    try {
//      String path = "saveOrUpdateOrDeleteMedicamento";
//      ObjectMapper mapper = new ObjectMapper();
//      TbMedicamentoDto medicamentoDto = new TbMedicamentoDto();
//      POJOTbMedicamento medicamento = mapper.readValue(Json, POJOTbMedicamento.class);
//
//      BeanUtils.copyProperties(medicamento, medicamentoDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(medicamento.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(medicamento.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) medicamentoDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else {
//          FastTable<TbMedicamentoDto> medicamentos = mantenimientoService.getListaMedicamentos(new TbMedicamentoDto());
//          boolean flag = true;
//          for (TbMedicamentoDto obj : medicamentos) {
//            if (EAccion.ADD.getText().equalsIgnoreCase(medicamento.getStatusAction())) {
//              if (obj.getExpedienteCum().equals(medicamentoDto.getExpedienteCum())) {
//                flag = false;
//                break;
//              }
//            }
//            else {
//              if (obj.getConsecutivoMedicamento() != medicamentoDto.getConsecutivoMedicamento() && obj.getExpedienteCum().equals(medicamentoDto.getExpedienteCum())) {
//                flag = false;
//                break;
//              }
//            }
//          }
//
//          if (!flag) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_EXPEDIENTE_CUM_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_EXPEDIENTE_CUM_REPETIDO.getId()));
//          }
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteMedicamento(medicamentoDto, medicamento.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/uploadImportMedicamentosMasivo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response uploadImportMedicamentosMasivo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOFileUpload filePOJO = mapper.readValue(Json, POJOFileUpload.class);
//
//      // byte[] name = Base64.getEncoder().encode("hello World".getBytes());
//      // byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
//
//      InputStream stream = new ByteArrayInputStream(filePOJO.getContentDecodeB64().getBytes(StandardCharsets.UTF_8));
//      FastTable<String> lista = FileUtilities.toListFileStringPipe(stream);
//      lista.remove(0);
//
//      int LONGITUD_REF = 24;
//      FastTable<String> listaErroresEstructura = new FastTable<String>();
//      FastTable<String> listaErroresContenido = new FastTable<String>();
//
//      // validando que no venga vacío el archivo
//      if (lista.isEmpty()) {
//        ArrayList<String> errores = new ArrayList<String>();
//        String error = "El archivo se encuentra vacío o su contenido no es suficiente para la importación. Por favor Revise el fichero.";
//        errores.add(error);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//
//      // Formateando acentos
//      for (String linea : lista) {
//        linea = linea.replace("á", "&aacute");
//        linea = linea.replace("é", "&eacute");
//        linea = linea.replace("í", "&iacute");
//        linea = linea.replace("ó", "&oacute");
//        linea = linea.replace("ú", "&uacute");
//        linea = linea.replace("ñ", "&ntilde");
//      }
//
//      // Validando Estructura
//      int i = 1;
//      for (String linea : lista) {
//        int longitud = linea.split("\\|").length;
//        if (longitud != LONGITUD_REF) {
//          listaErroresEstructura.add("Línea #" + i + ": (" + linea + ") - ERROR => No cumple con la estructura - Cant. Permitida: " + LONGITUD_REF);
//        }
//
//        i++;
//      }
//
//      // Validando Contenido
//      if (listaErroresEstructura.isEmpty()) {
//        int j = 1;
//
//        final int EXPEDIENTE = 0;
//        final int PRODUCTO = 1;
//        final int TITULAR = 2;
//        final int REGISTRO_SANITARIO = 3;
//        final int FECHA_EXPEDICION = 4;
//        final int FECHA_VENCIMIENTO = 5;
//        final int ESTADO_REGISTRO = 6;
//        final int EXPEDIENTE_CUM = 7;
//        final int CONSECUTIVO = 8;
//        final int DESCRIPCION_COMERCIAL = 9;
//        final int ESTADO_CUM = 10;
//        final int FECHA_ACTIVO = 11;
//        final int FECHA_INACTIVO = 12;
//        final int MUESTRA_MEDICA = 13;
//        final int UNIDAD = 14;
//        final int ATC_DESCRIPCION = 15;
//        final int ATC = 16;
//        final int VIA_ADMINISTRACION = 17;
//        final int CONCENTRACION = 18;
//        final int PRINCIPIO_ACTIVO = 19;
//        final int UNIDAD_MEDIDA = 20;
//        final int CANTIDAD = 21;
//        final int UNIDAD_REFERENCIA = 22;
//        final int UNIDAD_FORMA_FARMACEUTICA = 23;
//
//        FastTable<TbMedicamentoDto> medicamentosImportar = new FastTable<TbMedicamentoDto>();
//        FastTable<ScTerceroDto> listaTercerosValidar = mantenimientoService.getListaTerceros(new ScTerceroDto());
//        FastMap<String, ScTerceroDto> mapaTitulares = new FastMap<String, ScTerceroDto>();
//        for (ScTerceroDto titular : listaTercerosValidar) {
//          mapaTitulares.put(titular.getNroIdentificacion(), titular);
//        }
//        FastTable<TbUnidadDto> listaUnidadesValidar = mantenimientoService.getListaUnidades(new TbUnidadDto());
//        FastMap<Long, TbUnidadDto> mapaUnidades = new FastMap<Long, TbUnidadDto>();
//        for (TbUnidadDto unidad : listaUnidadesValidar) {
//          mapaUnidades.put(unidad.getConsecutivoUnidad(), unidad);
//        }
//
//        FastSet<String> expedientesCum = new FastSet<String>();
//        FastTable<TbMedicamentoDto> temporalMedicamentos = mantenimientoService.getListaMedicamentos(new TbMedicamentoDto());
//        FastMap<String, TbMedicamentoDto> mapaTemp = new FastMap<String, TbMedicamentoDto>();
//        for (TbMedicamentoDto med : temporalMedicamentos) {
//          expedientesCum.add(med.getExpedienteCum());
//          mapaTemp.put(med.getExpedienteCum(), med);
//        }
//
//        // Definir Fechas Actuales
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        Date fechaActual = cal.getTime();
//
//        for (String linea : lista) {
//          TbMedicamentoDto medicamentoDto = new TbMedicamentoDto();
//          String[] campos = linea.split("\\|");
//          // Estructura:
//          // EXPEDIENTE|PRODUCTO|TITULAR|REGISTRO SANITARIO|FECHA EXPEDICION|FECHA VENCIMIENTO|ESTADO REGISTRO|
//          // EXPEDIENTE CUM|CONSECUTIVO|DESCRIPCION COMERCIAL|ESTADO CUM|FECHA ACTIVO|FECHA INACTIVO|
//          // MUESTRA MEDICA|UNIDAD|ATC DESCRIPCION|ATC|VIA ADMINISTRACION|CONCENTRACION|PRINCIPIO ACTIVO|UNIDAD MEDIDA|
//          // CANTIDAD|UNIDAD REFERENCIA|UNIDAD FORMA FARMACEUTICA
//          // 004|Medicamento 4|37317575|EH92402DD|2015-11-25|2019-01-1|1|004-CUM|1|Descripción Comercial Medicamento 4 Prueba|1|2017-12-25||1|1|Desc. ATC Prueba #4Med|ATC004|Intravenosa|C|Medicament 4 Principio Activo Prueba|1|8|2|3
//          // INTERACCION CON OTRAS TABLAS POR MEDIO DE LAS LLAVES PARA LAS UNIDADES Y EL NRO_IDENTIFICACION PARA EL CASO DEL TITULAR (TERCERO)
//          // LOS QUE SON ENUMERADOS ES POR MEDIO DEL ID
//
//          medicamentoDto.setExpediente(!Util.vacio(campos[EXPEDIENTE]) ? campos[EXPEDIENTE] : null);
//          medicamentoDto.setProducto(!Util.vacio(campos[PRODUCTO]) ? campos[PRODUCTO] : null);
//          String titularDoc = !Util.vacio(campos[TITULAR]) ? campos[TITULAR] : null;
//          medicamentoDto.setRegistroSanitario(!Util.vacio(campos[REGISTRO_SANITARIO]) ? campos[REGISTRO_SANITARIO] : null);
//          medicamentoDto.setEstadoRegistro(!Util.vacio(campos[ESTADO_REGISTRO]) ? (Util.isNumber(campos[ESTADO_REGISTRO]) ? Short.parseShort(campos[ESTADO_REGISTRO]) : -1) : -1);
//          medicamentoDto.setExpedienteCum(!Util.vacio(campos[EXPEDIENTE_CUM]) ? campos[EXPEDIENTE_CUM] : null);
//          medicamentoDto.setConsecutivo(!Util.vacio(campos[CONSECUTIVO]) ? (Util.isNumber(campos[CONSECUTIVO]) ? Integer.parseInt(campos[CONSECUTIVO]) : -1) : -1);
//          medicamentoDto.setDescripcionComercial(!Util.vacio(campos[DESCRIPCION_COMERCIAL]) ? campos[DESCRIPCION_COMERCIAL] : null);
//          medicamentoDto.setEstadoCum(!Util.vacio(campos[ESTADO_CUM]) ? (Util.isNumber(campos[ESTADO_CUM]) ? Short.parseShort(campos[ESTADO_CUM]) : -1) : -1);
//          medicamentoDto.setSwMuestraMedica(!Util.vacio(campos[MUESTRA_MEDICA]) ? (Util.isNumber(campos[MUESTRA_MEDICA]) ? Short.parseShort(campos[MUESTRA_MEDICA]) : -1) : -1);
//          medicamentoDto.setUnidad(!Util.vacio(campos[UNIDAD]) ? (Util.isNumber(campos[UNIDAD]) ? Long.parseLong(campos[UNIDAD]) : -1) : null);
//          medicamentoDto.setDescripcionAtc(!Util.vacio(campos[ATC_DESCRIPCION]) ? campos[ATC_DESCRIPCION] : null);
//          medicamentoDto.setAtc(!Util.vacio(campos[ATC]) ? campos[ATC] : null);
//          medicamentoDto.setViaAdministracion(!Util.vacio(campos[VIA_ADMINISTRACION]) ? campos[VIA_ADMINISTRACION] : null);
//          medicamentoDto.setConcentracion(!Util.vacio(campos[CONCENTRACION]) ? campos[CONCENTRACION] : null);
//          medicamentoDto.setPrincipioActivo(!Util.vacio(campos[PRINCIPIO_ACTIVO]) ? campos[PRINCIPIO_ACTIVO] : null);
//          medicamentoDto.setUnidadMedida(!Util.vacio(campos[UNIDAD_MEDIDA]) ? (Util.isNumber(campos[UNIDAD_MEDIDA]) ? Long.parseLong(campos[UNIDAD_MEDIDA]) : -1) : null);
//          medicamentoDto.setCantidad(!Util.vacio(campos[CANTIDAD]) ? (Util.isNumber(campos[CANTIDAD]) ? Long.parseLong(campos[CANTIDAD]) : -1) : -1);
//          medicamentoDto.setUnidadReferencia(!Util.vacio(campos[UNIDAD_REFERENCIA]) ? (Util.isNumber(campos[UNIDAD_REFERENCIA]) ? Long.parseLong(campos[UNIDAD_REFERENCIA]) : -1) : null);
//          medicamentoDto.setUnidadFormaFarmaceutica(!Util.vacio(campos[UNIDAD_FORMA_FARMACEUTICA]) ? (Util.isNumber(campos[UNIDAD_FORMA_FARMACEUTICA]) ? Long.parseLong(campos[UNIDAD_FORMA_FARMACEUTICA]) : -1) : null);
//
//          boolean flag = true;
//
//          String errorLinea = "Línea #" + j + ": (" + linea + ") - ";
//          if (medicamentoDto.getExpediente() == null) {
//            errorLinea = errorLinea + "(ERROR => Expediente): -Texto- Campo Obligatorio vacío. ";
//            flag = false;
//          }
//          if (medicamentoDto.getConsecutivo() <= 0) {
//            errorLinea = errorLinea + "(ERROR => Consecutivo): -Numérico- Debe ser mayor a cero o no es número. ";
//            flag = false;
//          }
//          if (medicamentoDto.getExpediente() != null && medicamentoDto.getConsecutivo() > 0 && medicamentoDto.getExpediente() == null) {
//            medicamentoDto.setExpedienteCum(medicamentoDto.getExpediente() + "-" + medicamentoDto.getConsecutivo());
//          }
//          if (Util.vacio(medicamentoDto.getExpedienteCum())) {
//            errorLinea = errorLinea + "(ERROR => Expediente CUM): -Texto- Campo Obligatorio vacío. ";
//            flag = false;
//          }
//          else {
//            if (!expedientesCum.contains(medicamentoDto.getExpedienteCum())) {
//              expedientesCum.add(medicamentoDto.getExpedienteCum());
//            }
//            else {
//              if (mapaTemp.get(medicamentoDto.getExpedienteCum()).getConsecutivoMedicamento() != medicamentoDto.getConsecutivoMedicamento()) {
//                errorLinea = errorLinea + "(ERROR => Expediente CUM): -Texto- Ya existe el código del Expediente CUM en otra línea del archivo para importar o en el sistema. ";
//                flag = false;
//              }
//            }
//          }
//
//          // Primero las fechas
//          if (!Util.vacio(campos[FECHA_EXPEDICION])) {
//            medicamentoDto.setFechaExpedicion(Util.validarFechaImportacion(campos[FECHA_EXPEDICION]));
//            if (medicamentoDto.getFechaExpedicion() == null) {
//              errorLinea = errorLinea + "(ERROR => Fecha Expedición): -Fecha- La fecha o el formato de la fecha no es válido. ";
//              flag = false;
//            }
//
//            if (medicamentoDto.getFechaExpedicion().after(fechaActual)) {
//              errorLinea = errorLinea + "(ERROR => Fecha Expedición): -Fecha- La fecha no debe ser posterior a la Fecha Actual. ";
//              flag = false;
//            }
//          }
//          if (!Util.vacio(campos[FECHA_VENCIMIENTO])) {
//            medicamentoDto.setFechaVencimiento(Util.validarFechaImportacion(campos[FECHA_VENCIMIENTO]));
//            if (medicamentoDto.getFechaVencimiento() == null) {
//              errorLinea = errorLinea + "(ERROR => Fecha Vencimiento): -Fecha- La fecha o el formato de la fecha no es válido. ";
//              flag = false;
//            }
//            else {
//              if (!medicamentoDto.getFechaVencimiento().after(fechaActual)) {
//                errorLinea = errorLinea + "(ERROR => Fecha Vencimiento): -Fecha- La fecha no debe ser anterior o igual a la Fecha Actual. ";
//                flag = false;
//              }
//
//              if (medicamentoDto.getFechaExpedicion() != null) {
//                if (!medicamentoDto.getFechaVencimiento().after(medicamentoDto.getFechaExpedicion())) {
//                  errorLinea = errorLinea + "(ERROR => Fecha Vencimiento): -Fecha- La fecha no debe ser anterior o igual a la Fecha de Expedición. ";
//                  flag = false;
//                }
//              }
//            }
//          }
//          if (!Util.vacio(campos[FECHA_ACTIVO])) {
//            medicamentoDto.setFechaActivo(Util.validarFechaImportacion(campos[FECHA_ACTIVO]));
//            if (medicamentoDto.getFechaActivo() == null) {
//              errorLinea = errorLinea + "(ERROR => Fecha Activo): -Fecha- La fecha o el formato de la fecha no es válido. ";
//              flag = false;
//            }
//            else {
//              if (medicamentoDto.getFechaActivo().after(fechaActual)) {
//                errorLinea = errorLinea + "(ERROR => Fecha Activo): -Fecha- La fecha no debe ser posterior a la Fecha Actual. ";
//                flag = false;
//              }
//            }
//          }
//          if (!Util.vacio(campos[FECHA_INACTIVO])) {
//            medicamentoDto.setFechaInactivo(Util.validarFechaImportacion(campos[FECHA_INACTIVO]));
//            if (medicamentoDto.getFechaInactivo() == null) {
//              errorLinea = errorLinea + "(ERROR => Fecha Inactivo): -Fecha- La fecha o el formato de la fecha no es válido. ";
//              flag = false;
//            }
//            else {
//              if (medicamentoDto.getFechaInactivo().after(fechaActual)) {
//                errorLinea = errorLinea + "(ERROR => Fecha Inactivo): -Fecha- La fecha no debe ser posterior a la Fecha Actual. ";
//                flag = false;
//              }
//            }
//          }
//
//          if (titularDoc != null) {
//            if (mapaTitulares.get(titularDoc) != null) {
//              medicamentoDto.setTitular(mapaTitulares.get(titularDoc).getConsecutivoTercero());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Titular): -Ref. a otra tabla- No existe un tercero con ese número de identificación. ";
//              flag = false;
//            }
//          }
//          if (medicamentoDto.getSwMuestraMedica() != ESiNo.SI.getId() && medicamentoDto.getSwMuestraMedica() != ESiNo.NO.getId()) {
//            errorLinea = errorLinea + "(ERROR => Muestra Médica): -Numérico- Valor no aceptado. (Opciones " + Util.getStringOfValuesEnumeration(ESiNo.values()) + "). ";
//            flag = false;
//          }
//          if (medicamentoDto.getEstadoCum() != EEstado.ACTIVO.getId() && medicamentoDto.getEstadoCum() != EEstado.INACTIVO.getId()) {
//            errorLinea = errorLinea + "(ERROR => Estado CUM): -Numérico- Valor no aceptado. (Opciones " + Util.getStringOfValuesEnumeration(EEstado.values()) + "). ";
//            flag = false;
//          }
//          if (medicamentoDto.getEstadoRegistro() != EEstadoVigencia.VIGENTE.getId() && medicamentoDto.getEstadoRegistro() != EEstadoVigencia.NO_VIGENTE.getId()) {
//            errorLinea = errorLinea + "(ERROR => Estado Registro): -Numérico- Valor no aceptado. (Opciones " + Util.getStringOfValuesEnumeration(EEstadoVigencia.values()) + "). ";
//            flag = false;
//          }
//          if (medicamentoDto.getCantidad() < 0) {
//            errorLinea = errorLinea + "(ERROR => Cantidad): -Numérico- Debe ser mayor a cero o no es número. ";
//            flag = false;
//          }
//          if (medicamentoDto.getUnidad() != null) {
//            if (mapaUnidades.get(medicamentoDto.getUnidad()) != null) {
//              medicamentoDto.setUnidad(mapaUnidades.get(medicamentoDto.getUnidad()).getConsecutivoUnidad());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Unidad): -Ref. a otra tabla- No existe la unidad diligenciada. ";
//              flag = false;
//            }
//          }
//          if (medicamentoDto.getUnidadMedida() != null) {
//            if (mapaUnidades.get(medicamentoDto.getUnidadMedida()) != null) {
//              medicamentoDto.setUnidadMedida(mapaUnidades.get(medicamentoDto.getUnidadMedida()).getConsecutivoUnidad());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Unidad de Medida): -Ref. a otra tabla- No existe la unidad diligenciada o no es del tipo Unidad de Medida. ";
//              flag = false;
//            }
//          }
//          if (medicamentoDto.getUnidadReferencia() != null) {
//            if (mapaUnidades.get(medicamentoDto.getUnidadReferencia()) != null) {
//              medicamentoDto.setUnidadReferencia(mapaUnidades.get(medicamentoDto.getUnidadReferencia()).getConsecutivoUnidad());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Unidad de Referencia): -Ref. a otra tabla- No existe la unidad diligenciada o no es del tipo Unidad de Referencia. ";
//              flag = false;
//            }
//          }
//          if (medicamentoDto.getUnidadFormaFarmaceutica() != null) {
//            if (mapaUnidades.get(medicamentoDto.getUnidadFormaFarmaceutica()) != null) {
//              medicamentoDto.setUnidadFormaFarmaceutica(mapaUnidades.get(medicamentoDto.getUnidadFormaFarmaceutica()).getConsecutivoUnidad());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Unidad de Forma Farmacéutica): -Ref. a otra tabla- No existe la unidad diligenciada o no es del tipo Unidad de Forma Farmacéutica. ";
//              flag = false;
//            }
//          }
//
//          if (!flag) {
//            listaErroresContenido.add(errorLinea);
//          }
//          else {
//            medicamentosImportar.add(medicamentoDto);
//          }
//
//          j++;
//        }
//
//        if (listaErroresContenido.isEmpty()) {
//          boolean correcto = mantenimientoService.saveOrUpdateMasivoMedicamento(medicamentosImportar);
//          if (correcto) {
//            return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//          }
//          else {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//          }
//        }
//        else {
//          ArrayList<String> errores = new ArrayList<String>();
//          errores.addAll(listaErroresEstructura);
//          errores.addAll(listaErroresContenido);
//          filePOJO.setErrores(errores);
//          filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//          filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//          String jsonInString = mapper.writeValueAsString(filePOJO);
//
//          return Response.ok(jsonInString).build();
//        }
//      }
//      else {
//        ArrayList<String> errores = new ArrayList<String>();
//        errores.addAll(listaErroresEstructura);
//        errores.addAll(listaErroresContenido);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/loadInfoContable")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response loadInfoContable(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbInsumo
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      ScContabilizaDto contabilizaDto = new ScContabilizaDto();
//      POJOScContabiliza contabiliza = mapper.readValue(Json, POJOScContabiliza.class);
//
//      contabilizaDto.setContabiliza(contabiliza.getContabiliza());
//      FastTable<ScContabilizaDto> contabilizaciones = mantenimientoService.getListaContabilizaciones(contabilizaDto);
//
//      List<POJOScContabiliza> POJOresult = new ArrayList<POJOScContabiliza>();
//
//      FastTable<ScContabilizaDto> listaDeTemp = new FastTable<ScContabilizaDto>();
//      for (ScContabilizaDto dto : contabilizaciones) {
//        listaDeTemp.addAll(dto.getAutocontabilizacionesDetalles());
//
//        POJOScContabiliza pojo = new POJOScContabiliza();
//        // limpiar la lista antes de pasar al POJO
//        dto.getAutocontabilizacionesDetalles().clear();
//        BeanUtils.copyProperties(dto, pojo);
//
//        // pasar los detalles
//        for (ScContabilizaDto detalle : listaDeTemp) {
//          POJOScContabiliza pojoDetalle = new POJOScContabiliza();
//          BeanUtils.copyProperties(detalle, pojoDetalle);
//          pojo.getAutocontabilizacionesDetalles().add(pojoDetalle);
//        }
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//        listaDeTemp.clear();
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult.get(0));
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteAutocontabilizacion")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteAutocontabilizacion(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = scContabiliza
//    try {
//      String path = "saveOrUpdateOrDeleteAutocontabilizacion";
//      ObjectMapper mapper = new ObjectMapper();
//      ScContabilizaDto contabilizaDto = new ScContabilizaDto();
//      POJOScContabiliza contabiliza = mapper.readValue(Json, POJOScContabiliza.class);
//
//      FastTable<ScContabilizaDto> detalles = new FastTable<ScContabilizaDto>();
//      for (POJOScContabiliza d : contabiliza.getAutocontabilizacionesDetalles()) {
//        ScContabilizaDto detalle = new ScContabilizaDto();
//        BeanUtils.copyProperties(d, detalle);
//        detalles.add(detalle);
//      }
//      BeanUtils.copyProperties(contabiliza, contabilizaDto);
//      contabilizaDto.setAutocontabilizacionesDetalles(new FastTable<ScContabilizaDto>());
//      contabilizaDto.getAutocontabilizacionesDetalles().addAll(detalles);
//
//      String textoValidaciones = this.validaciones(path, (Object) contabilizaDto);
//      if (!Util.vacio(textoValidaciones)) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteAutocontabilizacion(contabilizaDto);
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getAseguradoras")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getAseguradoras(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbAseguradora POJO = mapper.readValue(Json, POJOTbAseguradora.class);
//      TbAseguradoraDto filtro = new TbAseguradoraDto();
//      filtro.setConsecutivoAseguradora(POJO.getConsecutivoAseguradora());
//      filtro.setRazonSocial(POJO.getRazonSocial());
//      FastTable<TbAseguradoraDto> listaDtos = mantenimientoService.getListaAseguradoras(filtro);
//
//      List<POJOTbAseguradora> POJOresult = new ArrayList<POJOTbAseguradora>();
//
//      FastTable<TbAseguradoraCodigoDto> listaDeTemp = new FastTable<TbAseguradoraCodigoDto>();
//      for (TbAseguradoraDto dto : listaDtos) {
//        listaDeTemp.addAll(dto.getAseguradoraCodigoDetalles());
//
//        POJOTbAseguradora pojo = new POJOTbAseguradora();
//        // limpiar la lista antes de pasar al POJO
//        dto.getAseguradoraCodigoDetalles().clear();
//        BeanUtils.copyProperties(dto, pojo);
//
//        // pasar los detalles
//        for (TbAseguradoraCodigoDto detalle : listaDeTemp) {
//          POJOTbAseguradoraCodigo pojoDetalle = new POJOTbAseguradoraCodigo();
//          BeanUtils.copyProperties(detalle, pojoDetalle);
//          pojo.getAseguradoraCodigoDetalles().add(pojoDetalle);
//        }
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//        listaDeTemp.clear();
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteAseguradora")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteAseguradora(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = scAseguradora
//    try {
//      String path = "saveOrUpdateOrDeleteAseguradora";
//      ObjectMapper mapper = new ObjectMapper();
//      TbAseguradoraDto dto = new TbAseguradoraDto();
//      POJOTbAseguradora pojo = mapper.readValue(Json, POJOTbAseguradora.class);
//
//      FastTable<TbAseguradoraCodigoDto> detalles = new FastTable<TbAseguradoraCodigoDto>();
//      for (POJOTbAseguradoraCodigo d : pojo.getAseguradoraCodigoDetalles()) {
//        TbAseguradoraCodigoDto detalle = new TbAseguradoraCodigoDto();
//        BeanUtils.copyProperties(d, detalle);
//        detalles.add(detalle);
//      }
//      BeanUtils.copyProperties(pojo, dto);
//      dto.setAseguradoraCodigoDetalles(new FastTable<TbAseguradoraCodigoDto>());
//      dto.getAseguradoraCodigoDetalles().addAll(detalles);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else {
//          FastTable<TbAseguradoraDto> aseguradoras = mantenimientoService.getListaAseguradoras(new TbAseguradoraDto());
//          FastSet<String> codigosAseguradoras = new FastSet<String>();
//          for (TbAseguradoraDto ase : aseguradoras) {
//            for (TbAseguradoraCodigoDto deta : ase.getAseguradoraCodigoDetalles()) {
//              codigosAseguradoras.add(deta.getCodigoAseguradora());
//            }
//          }
//
//          boolean flag = true;
//          for (TbAseguradoraCodigoDto detalle : dto.getAseguradoraCodigoDetalles()) {
//            if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//              if (codigosAseguradoras.contains(detalle.getCodigoAseguradora())) {
//                flag = false;
//                break;
//              }
//            }
//            else {
//              for (TbAseguradoraDto ase : aseguradoras) {
//                for (TbAseguradoraCodigoDto cod : ase.getAseguradoraCodigoDetalles()) {
//                  if (ase.getConsecutivoAseguradora() != dto.getConsecutivoAseguradora() && codigosAseguradoras.contains(cod.getCodigoAseguradora())) {
//                    flag = false;
//                    break;
//                  }
//                }
//              }
//            }
//          }
//
//          if (!flag) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_ASEGURADORA_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_ASEGURADORA_REPETIDO.getId()));
//          }
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteAseguradora(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/uploadImportAseguradorasMasivo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response uploadImportAseguradorasMasivo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOFileUpload filePOJO = mapper.readValue(Json, POJOFileUpload.class);
//
//      // byte[] name = Base64.getEncoder().encode("hello World".getBytes());
//      // byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
//
//      InputStream stream = new ByteArrayInputStream(filePOJO.getContentDecodeB64().getBytes(StandardCharsets.UTF_8));
//      FastTable<String> lista = FileUtilities.toListFileStringPipe(stream);
//      lista.remove(0);
//
//      int LONGITUD_REF = 10;
//      FastTable<String> listaErroresEstructura = new FastTable<String>();
//      FastTable<String> listaErroresContenido = new FastTable<String>();
//
//      // validando que no venga vacío el archivo
//      if (lista.isEmpty()) {
//        ArrayList<String> errores = new ArrayList<String>();
//        String error = "El archivo se encuentra vacío o su contenido no es suficiente para la importación. Por favor Revise el fichero.";
//        errores.add(error);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//
//      // Validando Estructura
//      int i = 1;
//      for (String linea : lista) {
//        int longitud = linea.split("\\|").length;
//        if (longitud != LONGITUD_REF) {
//          listaErroresEstructura.add("Línea #" + i + ": (" + linea + ") - ERROR => No cumple con la estructura - Cant. Permitida: " + LONGITUD_REF);
//        }
//
//        i++;
//      }
//
//      // Validando Contenido
//      if (listaErroresEstructura.isEmpty()) {
//        int j = 1;
//
//        final int CONSECUTIVO_ASEGURADORA = 0;
//        final int RAZON_SOCIAL = 1;
//        final int CONTACTO = 2;
//        final int CORREO = 3;
//        final int TELEFONO = 4;
//        final int NIT = 5;
//        final int DIGITO_VERIFICACION = 6;
//        final int TERCERO = 7;
//        final int TIPO_ASEGURADORA = 8;
//        final int CODIGO_ASEGURADORA = 9;
//
//        FastTable<TbAseguradoraDto> aseguradorasImportar = new FastTable<TbAseguradoraDto>();
//        FastTable<ScTerceroDto> listaTercerosValidar = mantenimientoService.getListaTerceros(new ScTerceroDto());
//        FastMap<String, ScTerceroDto> mapaTitulares = new FastMap<String, ScTerceroDto>();
//        for (ScTerceroDto titular : listaTercerosValidar) {
//          mapaTitulares.put(titular.getNroIdentificacion(), titular);
//        }
//
//        FastSet<String> codigosAseguradora = new FastSet<String>();
//        // FastTable<TbAseguradoraDto> temporalAseguradoras = mantenimientoService.getListaAseguradoras(new TbAseguradoraDto());
//        // FastMap<String, TbAseguradoraCodigoDto> mapaTemp = new FastMap<String, TbAseguradoraCodigoDto>();
//        // for (TbAseguradoraDto enc : temporalAseguradoras) {
//        // for (TbAseguradoraCodigoDto det : enc.getAseguradoraCodigoDetalles()) {
//        // codigosAseguradora.add(det.getCodigoAseguradora());
//        //
//        // mapaTemp.put(det.getCodigoAseguradora(), det);
//        // }
//        // }
//
//        FastMap<Long, TbAseguradoraDto> mapEncabezados = new FastMap<Long, TbAseguradoraDto>();
//        for (String linea : lista) {
//          TbAseguradoraDto aseguradoraDto = new TbAseguradoraDto();
//          TbAseguradoraCodigoDto aseguradoraCodigoDto = new TbAseguradoraCodigoDto();
//          String[] campos = linea.split("\\|");
//          // Estructura:
//          // CONSECUTIVO ASEGURADORA|RAZON SOCIAL|CONTACTO|CORREO ELECTRONICO|TELEFONO|NIT|DIGITO VERIFICACION|TERCERO|TIPO ASEGURADORA|CODIGO ASEGURADORA
//          // 1|La Taguara|Olga Rangel|cmverab@ufpso.edu.co|6455656|99978787|5|37317575|1|CED1
//          // INTERACCION CON OTRAS TABLAS POR MEDIO DEL NRO_IDENTIFICACION PARA EL CASO DEL TERCERO
//          // LOS QUE SON ENUMERADOS ES POR MEDIO DEL ID
//
//          aseguradoraDto.setConsecutivoAseguradora(!Util.vacio(campos[CONSECUTIVO_ASEGURADORA]) ? (Util.isNumber(campos[CONSECUTIVO_ASEGURADORA]) ? Long.parseLong(campos[CONSECUTIVO_ASEGURADORA]) : -1) : null);
//          aseguradoraDto.setRazonSocial(!Util.vacio(campos[RAZON_SOCIAL]) ? campos[RAZON_SOCIAL] : null);
//          aseguradoraDto.setContacto(!Util.vacio(campos[CONTACTO]) ? campos[CONTACTO] : null);
//          aseguradoraDto.setCorreoElectronico(!Util.vacio(campos[CORREO]) ? campos[CORREO] : null);
//          aseguradoraDto.setTelefono(!Util.vacio(campos[TELEFONO]) ? campos[TELEFONO] : null);
//          aseguradoraDto.setNit(!Util.vacio(campos[NIT]) ? campos[NIT] : null);
//          aseguradoraDto.setDigitoVerificacion(!Util.vacio(campos[DIGITO_VERIFICACION]) ? campos[DIGITO_VERIFICACION] : null);
//          String titularDoc = !Util.vacio(campos[TERCERO]) ? campos[TERCERO] : null;
//
//          aseguradoraCodigoDto.setConsecutivoAseguradora(aseguradoraDto.getConsecutivoAseguradora());
//          aseguradoraCodigoDto.setTipoAseguradora(!Util.vacio(campos[TIPO_ASEGURADORA]) ? (Util.isNumber(campos[TIPO_ASEGURADORA]) ? Short.parseShort(campos[TIPO_ASEGURADORA]) : -1) : -1);
//          aseguradoraCodigoDto.setCodigoAseguradora(!Util.vacio(campos[CODIGO_ASEGURADORA]) ? campos[CODIGO_ASEGURADORA] : null);
//
//          boolean flag = true;
//
//          String errorLinea = "Línea #" + j + ": (" + linea + ") - ";
//          // Aseguradora
//          if (aseguradoraDto.getConsecutivoAseguradora() == null) {
//            errorLinea = errorLinea + "(ERROR => Consecutivo Aseguradora): -Numérico- Campo Obligatorio vacío o no es numérico. ";
//            flag = false;
//          }
//          if (Util.vacio(aseguradoraDto.getRazonSocial())) {
//            errorLinea = errorLinea + "(ERROR => Razón Social): -Texto- Campo Obligatorio vacío. ";
//            flag = false;
//          }
//          if (Util.vacio(aseguradoraDto.getContacto())) {
//            errorLinea = errorLinea + "(ERROR => Contacto): -Texto- Campo Obligatorio vacío. ";
//            flag = false;
//          }
//          if (Util.vacio(aseguradoraDto.getCorreoElectronico())) {
//            errorLinea = errorLinea + "(ERROR => Correo Electrónico): -Texto- Campo Obligatorio vacío. ";
//            flag = false;
//          }
//          else {
//            if (!Util.isEmail(aseguradoraDto.getCorreoElectronico())) {
//              errorLinea = errorLinea + "(ERROR => Correo Electrónico): -Texto- No tiene la estrucutura correcta de un correo. ";
//              flag = false;
//            }
//          }
//          if (Util.vacio(aseguradoraDto.getTelefono())) {
//            errorLinea = errorLinea + "(ERROR => Teléfono): -Numérico- Campo Obligatorio vacío. ";
//            flag = false;
//          }
//          else {
//            if (!Util.isNumber(aseguradoraDto.getTelefono())) {
//              errorLinea = errorLinea + "(ERROR => Teléfono): -Numérico- Campo Obligatorio debe ser Numérico. ";
//              flag = false;
//            }
//          }
//          if (titularDoc != null) {
//            if (mapaTitulares.get(titularDoc) != null) {
//              aseguradoraDto.setConsecutivoTercero(mapaTitulares.get(titularDoc).getConsecutivoTercero());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Tercero): -Ref. a otra tabla- No existe un tercero con ese número de identificación. ";
//              flag = false;
//            }
//          }
//          // AseguradoraCodigo
//          if (aseguradoraCodigoDto.getTipoAseguradora() <= 0) {
//            errorLinea = errorLinea + "(ERROR => Tipo Aseguradora): -Numérico- Debe ser mayor a cero o no es número. ";
//            flag = false;
//          }
//          if (Util.vacio(aseguradoraCodigoDto.getCodigoAseguradora())) {
//            errorLinea = errorLinea + "(ERROR => Código Aseguradora): -Texto- Campo Obligatorio vacío. ";
//            flag = false;
//          }
//          else {
//            if (!codigosAseguradora.contains(aseguradoraCodigoDto.getCodigoAseguradora())) {
//              codigosAseguradora.add(aseguradoraCodigoDto.getCodigoAseguradora());
//            }
//            else {
//              // if (mapaTemp.get(aseguradoraCodigoDto.getCodigoAseguradora()).getConsecutivoAseguradora() != aseguradoraCodigoDto.getConsecutivoAseguradora()) {
//              errorLinea = errorLinea + "(ERROR => Código Aseguradora): -Texto- Ya existe el código de la Aseguradora en otra línea del archivo para importar. ";
//              flag = false;
//              // }
//            }
//          }
//
//          if (!flag) {
//            listaErroresContenido.add(errorLinea);
//          }
//          else {
//            if (!mapEncabezados.containsKey(aseguradoraDto.getConsecutivoAseguradora())) {
//              aseguradoraDto.setAseguradoraCodigoDetalles(new FastTable<TbAseguradoraCodigoDto>());
//              mapEncabezados.put(aseguradoraDto.getConsecutivoAseguradora(), aseguradoraDto);
//            }
//
//            mapEncabezados.get(aseguradoraDto.getConsecutivoAseguradora()).getAseguradoraCodigoDetalles().add(aseguradoraCodigoDto);
//          }
//
//          j++;
//        }
//
//        if (listaErroresContenido.isEmpty()) {
//          for (Long llaveAseguradora : mapEncabezados.keySet()) {
//            aseguradorasImportar.add(mapEncabezados.get(llaveAseguradora));
//          }
//
//          boolean correcto = mantenimientoService.saveOrUpdateMasivoAseguradora(aseguradorasImportar);
//          if (correcto) {
//            return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//          }
//          else {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//          }
//        }
//        else {
//          ArrayList<String> errores = new ArrayList<String>();
//          errores.addAll(listaErroresEstructura);
//          errores.addAll(listaErroresContenido);
//          filePOJO.setErrores(errores);
//          filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//          filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//          String jsonInString = mapper.writeValueAsString(filePOJO);
//
//          return Response.ok(jsonInString).build();
//        }
//      }
//      else {
//        ArrayList<String> errores = new ArrayList<String>();
//        errores.addAll(listaErroresEstructura);
//        errores.addAll(listaErroresContenido);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getContratos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getContratos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOCtContrato POJO = mapper.readValue(Json, POJOCtContrato.class);
//      CtContratoDto filtro = new CtContratoDto();
//      filtro.setConsecutivoContrato(POJO.getConsecutivoContrato());
//      filtro.setConsecutivoAseguradora(POJO.getConsecutivoAseguradora());
//      filtro.setFechaInicio(POJO.getFechaInicio());
//      filtro.setFechaFin(POJO.getFechaFin());
//      filtro.setEstado(POJO.getEstado());
//
//      FastTable<CtContratoDto> listaDtos = mantenimientoService.getListaContratos(filtro);
//
//      List<POJOCtContrato> POJOresult = new ArrayList<POJOCtContrato>();
//
//      for (CtContratoDto dto : listaDtos) {
//        POJOCtContrato pojo = new POJOCtContrato();
//        BeanUtils.copyProperties(dto, pojo);
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteContrato")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteContrato(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = ctContrato
//    try {
//      String path = "saveOrUpdateOrDeleteContrato";
//      ObjectMapper mapper = new ObjectMapper();
//      CtContratoDto dto = new CtContratoDto();
//      POJOCtContrato pojo = mapper.readValue(Json, POJOCtContrato.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteContrato(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getPacientes")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getPacientes(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOCtPaciente POJO = mapper.readValue(Json, POJOCtPaciente.class);
//      CtPacienteDto filtro = new CtPacienteDto();
//      filtro.setTipoIdentificacion(POJO.getTipoIdentificacion());
//      filtro.setNumeroIdentificacion(POJO.getNumeroIdentificacion());
//      filtro.setFechaNacimiento(POJO.getFechaNacimiento());
//      filtro.setPrimerNombre(POJO.getPrimerNombre());
//      filtro.setSegundoNombre(POJO.getSegundoNombre());
//      filtro.setPrimerApellido(POJO.getPrimerApellido());
//      filtro.setSegundoApellido(POJO.getSegundoApellido());
//
//      FastTable<CtPacienteDto> listaDtos = mantenimientoService.getListaPacientes(filtro);
//      List<POJOCtPaciente> POJOresult = new ArrayList<POJOCtPaciente>();
//
//      for (CtPacienteDto dto : listaDtos) {
//        POJOCtPacienteComplemento pojoComplemento = new POJOCtPacienteComplemento();
//        BeanUtils.copyProperties(dto.getPacienteComplemento(), pojoComplemento);
//        dto.setPacienteComplemento(null);
//
//        POJOCtPaciente pojo = new POJOCtPaciente();
//        BeanUtils.copyProperties(dto, pojo);
//        // llenamos el complemento para mostrarlo en la vista
//        pojo.setActividadEconomica(pojoComplemento.getActividadEconomica());
//        pojo.setCuotaModeradora(pojoComplemento.getCuotaModeradora());
//        pojo.setDireccion(pojoComplemento.getDireccion());
//        pojo.setEmail(pojoComplemento.getEmail());
//        pojo.setEmpresa(pojoComplemento.getEmpresa());
//        pojo.setEstadoCivil(pojoComplemento.getEstadoCivil());
//        pojo.setFechaAfiliacion(pojoComplemento.getFechaAfiliacion());
//        pojo.setGenero(pojoComplemento.getGenero());
//        pojo.setMunicipio(pojoComplemento.getMunicipio());
//        pojo.setNivelEducativo(pojoComplemento.getNivelEducativo());
//        pojo.setNivelSisben(pojoComplemento.getNivelSisben());
//        pojo.setNombreResponsable(pojoComplemento.getNombreResponsable());
//        pojo.setOcupacion(pojoComplemento.getOcupacion());
//        pojo.setParentesco(pojoComplemento.getParentesco());
//        pojo.setParentescoResponsable(pojoComplemento.getParentescoResponsable());
//        pojo.setTelefono(pojoComplemento.getTelefono());
//        pojo.setTelefonoResponsable(pojoComplemento.getTelefonoResponsable());
//        pojo.setTipoAfiliacion(pojoComplemento.getTipoAfiliacion());
//        pojo.setTipoAfiliado(pojoComplemento.getTipoAfiliado());
//        pojo.setTipoIdentificacionCotizante(pojoComplemento.getTipoIdentificacionCotizante());
//        pojo.setTipoPoblacion(pojoComplemento.getTipoPoblacion());
//        pojo.setTipoZona(pojoComplemento.getTipoZona());
//        pojo.setNombreCompleto(dto.getFullName());
//        pojo.setFechaNacimientoTexto(Util.getFechaCorta(dto.getFechaNacimiento(), false));
//        pojo.setSerial(dto.getSerial());
//        pojo.setCopiaSerial(dto.getSerial());
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeletePaciente")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeletePaciente(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = ctPaciente
//    try {
//      String path = "saveOrUpdateOrDeletePaciente";
//      ObjectMapper mapper = new ObjectMapper();
//      CtPacienteDto dto = new CtPacienteDto();
//      CtPacienteComplementoDto dtoComplemento = new CtPacienteComplementoDto();
//      POJOCtPaciente pojo = mapper.readValue(Json, POJOCtPaciente.class);
//      POJOCtPacienteComplemento pojoComplemento = mapper.readValue(Json, POJOCtPacienteComplemento.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//      BeanUtils.copyProperties(pojoComplemento, dtoComplemento);
//      dto.setPacienteComplemento(dtoComplemento);
//
//      boolean existe = false;
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//
//        if (EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//          if (!pojo.getSerial().equalsIgnoreCase(pojo.getCopiaSerial())) {
//            existe = mantenimientoService.validarCodigoInterno(CtPaciente.class, "serial", dto.getSerial());
//            if (existe) {
//              return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_SERIAL_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_SERIAL_REPETIDO.getId()));
//            }
//          }
//        }
//        else {
//          existe = mantenimientoService.validarCodigoInterno(CtPaciente.class, "serial", dto.getSerial());
//          if (existe) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_SERIAL_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_SERIAL_REPETIDO.getId()));
//          }
//        }
//
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeletePaciente(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getProfesiones")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getProfesiones(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOScProfesion POJO = mapper.readValue(Json, POJOScProfesion.class);
//      ScProfesionDto filtro = new ScProfesionDto();
//      filtro.setConsecutivoProfesion(POJO.getConsecutivoProfesion());
//      filtro.setDescripcion(POJO.getDescripcion());
//
//      FastTable<ScProfesionDto> listaDtos = mantenimientoService.getListaProfesiones(filtro);
//
//      List<POJOScProfesion> POJOresult = new ArrayList<POJOScProfesion>();
//
//      for (ScProfesionDto dto : listaDtos) {
//        POJOScProfesion pojo = new POJOScProfesion();
//        BeanUtils.copyProperties(dto, pojo);
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteProfesion")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteProfesion(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = scProfesion
//    try {
//      String path = "saveOrUpdateOrDeleteProfesion";
//      ObjectMapper mapper = new ObjectMapper();
//      ScProfesionDto dto = new ScProfesionDto();
//      POJOScProfesion pojo = mapper.readValue(Json, POJOScProfesion.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteProfesion(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getFondos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getFondos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOScFondo POJO = mapper.readValue(Json, POJOScFondo.class);
//      ScFondoDto filtro = new ScFondoDto();
//      filtro.setConsecutivoFondo(POJO.getConsecutivoFondo());
//      filtro.setDescripcion(POJO.getDescripcion());
//      filtro.setTipoFondo(POJO.getTipoFondo());
//
//      FastTable<ScFondoDto> listaDtos = mantenimientoService.getListaFondos(filtro);
//
//      List<POJOScFondo> POJOresult = new ArrayList<POJOScFondo>();
//
//      for (ScFondoDto dto : listaDtos) {
//        POJOScFondo pojo = new POJOScFondo();
//        BeanUtils.copyProperties(dto, pojo);
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteFondo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteFondo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = scFondo
//    try {
//      String path = "saveOrUpdateOrDeleteFondo";
//      ObjectMapper mapper = new ObjectMapper();
//      ScFondoDto dto = new ScFondoDto();
//      POJOScFondo pojo = mapper.readValue(Json, POJOScFondo.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteFondo(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getEmpleados")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getEmpleados(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOScEmpleado POJO = mapper.readValue(Json, POJOScEmpleado.class);
//      ScEmpleadoDto filtro = new ScEmpleadoDto();
//      filtro.setConsecutivoEmpleado(POJO.getConsecutivoEmpleado());
//      filtro.setNumeroIdentificacion(POJO.getNumeroIdentificacion());
//      filtro.setPrimerNombre(POJO.getPrimerNombre());
//      filtro.setPrimerApellido(POJO.getPrimerApellido());
//
//      FastTable<ScEmpleadoDto> listaDtos = mantenimientoService.getListaEmpleados(filtro);
//      List<POJOScEmpleado> POJOresult = new ArrayList<POJOScEmpleado>();
//
//      for (ScEmpleadoDto dto : listaDtos) {
//        POJOScEmpleado pojo = new POJOScEmpleado();
//
//        FastTable<ScEmpleadoEducacionDto> iteradorEducacion = new FastTable<ScEmpleadoEducacionDto>();
//        FastTable<POJOScEmpleadoEducacion> iteradorEducacionPOJO = new FastTable<POJOScEmpleadoEducacion>();
//        if (dto.getEmpleadoEducacionIterador() != null) {
//          iteradorEducacion.addAll(dto.getEmpleadoEducacionIterador());
//        }
//        for (ScEmpleadoEducacionDto itEducacion : iteradorEducacion) {
//          POJOScEmpleadoEducacion pojEducacion = new POJOScEmpleadoEducacion();
//          BeanUtils.copyProperties(itEducacion, pojEducacion);
//          pojEducacion.setFechaTexto(Util.getFechaCorta(pojEducacion.getFecha(), false));
//
//          iteradorEducacionPOJO.add(pojEducacion);
//        }
//
//        FastTable<ScEmpleadoFamiliaDto> iteradorFamilia = new FastTable<ScEmpleadoFamiliaDto>();
//        FastTable<POJOScEmpleadoFamilia> iteradorFamiliaPOJO = new FastTable<POJOScEmpleadoFamilia>();
//        if (dto.getEmpleadoFamiliaIterador() != null) {
//          iteradorFamilia.addAll(dto.getEmpleadoFamiliaIterador());
//        }
//        for (ScEmpleadoFamiliaDto itFamilia : iteradorFamilia) {
//          POJOScEmpleadoFamilia pojFamilia = new POJOScEmpleadoFamilia();
//          BeanUtils.copyProperties(itFamilia, pojFamilia);
//          pojFamilia.setFechaNacimientoTexto(pojFamilia.getFechaNacimiento() == null ? null : Util.getFechaCorta(pojFamilia.getFechaNacimiento(), false));
//
//          iteradorFamiliaPOJO.add(pojFamilia);
//        }
//
//        FastTable<ScEmpleadoLaboralDto> iteradorLaboral = new FastTable<ScEmpleadoLaboralDto>();
//        FastTable<POJOScEmpleadoLaboral> iteradorLaboralPOJO = new FastTable<POJOScEmpleadoLaboral>();
//        if (dto.getEmpleadoLaboralIterador() != null) {
//          iteradorLaboral.addAll(dto.getEmpleadoLaboralIterador());
//        }
//        for (ScEmpleadoLaboralDto itLaboral : iteradorLaboral) {
//          POJOScEmpleadoLaboral pojLaboral = new POJOScEmpleadoLaboral();
//          BeanUtils.copyProperties(itLaboral, pojLaboral);
//          pojLaboral.setFechaIngresoTexto(pojLaboral.getFechaIngreso() == null ? null : Util.getFechaCorta(pojLaboral.getFechaIngreso(), false));
//          pojLaboral.setFechaRetiroTexto(pojLaboral.getFechaRetiro() == null ? null : Util.getFechaCorta(pojLaboral.getFechaRetiro(), false));
//
//          iteradorLaboralPOJO.add(pojLaboral);
//        }
//
//        dto.setEmpleadoEducacionIterador(null);
//        dto.setEmpleadoFamiliaIterador(null);
//        dto.setEmpleadoLaboralIterador(null);
//
//        BeanUtils.copyProperties(dto, pojo);
//        pojo.setEmpleadoEducacionIterador(iteradorEducacionPOJO);
//        pojo.setEmpleadoFamiliaIterador(iteradorFamiliaPOJO);
//        pojo.setEmpleadoLaboralIterador(iteradorLaboralPOJO);
//
//        // Fechas
//        pojo.setFechaExpedicionLibretaTexto(pojo.getExpedicionLibreta() == null ? null : Util.getFechaCorta(pojo.getExpedicionLibreta(), false));
//        pojo.setFechaExpedicionLicenciaConduccionTexto(pojo.getFechaExpedicionLicenciaConduccion() == null ? null : Util.getFechaCorta(pojo.getFechaExpedicionLicenciaConduccion(), false));
//        pojo.setFechaExpedicionPasadoJudicialTexto(pojo.getFechaExpedicionPasadoJudicial() == null ? null : Util.getFechaCorta(pojo.getFechaExpedicionPasadoJudicial(), false));
//        pojo.setFechaIngresoConyugeTexto(pojo.getFechaIngresoConyuge() == null ? null : Util.getFechaCorta(pojo.getFechaIngresoConyuge(), false));
//        pojo.setFechaNacimientoTexto(Util.getFechaCorta(pojo.getFechaNacimiento(), false));
//        pojo.setFechaNacimientoConyugeTexto(pojo.getFechaNacimientoConyuge() == null ? null : Util.getFechaCorta(pojo.getFechaNacimientoConyuge(), false));
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteEmpleado")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteEmpleado(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = scEmpleado
//    try {
//      String path = "saveOrUpdateOrDeleteEmpleado";
//      ObjectMapper mapper = new ObjectMapper();
//      mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
//
//      ScEmpleadoDto dto = new ScEmpleadoDto();
//      POJOScEmpleado pojo = mapper.readValue(Json, POJOScEmpleado.class);
//
//      FastTable<ScEmpleadoEducacionDto> iteradorEducacion = new FastTable<ScEmpleadoEducacionDto>();
//      for (POJOScEmpleadoEducacion d : pojo.getEmpleadoEducacionIterador()) {
//        ScEmpleadoEducacionDto itera = new ScEmpleadoEducacionDto();
//        BeanUtils.copyProperties(d, itera);
//        iteradorEducacion.add(itera);
//      }
//
//      FastTable<ScEmpleadoFamiliaDto> iteradorFamilia = new FastTable<ScEmpleadoFamiliaDto>();
//      for (POJOScEmpleadoFamilia d : pojo.getEmpleadoFamiliaIterador()) {
//        ScEmpleadoFamiliaDto itera = new ScEmpleadoFamiliaDto();
//        BeanUtils.copyProperties(d, itera);
//        iteradorFamilia.add(itera);
//      }
//
//      FastTable<ScEmpleadoLaboralDto> iteradorLaboral = new FastTable<ScEmpleadoLaboralDto>();
//      for (POJOScEmpleadoLaboral d : pojo.getEmpleadoLaboralIterador()) {
//        ScEmpleadoLaboralDto itera = new ScEmpleadoLaboralDto();
//        BeanUtils.copyProperties(d, itera);
//        iteradorLaboral.add(itera);
//      }
//
//      pojo.setEmpleadoEducacionIterador(null);
//      pojo.setEmpleadoFamiliaIterador(null);
//      pojo.setEmpleadoLaboralIterador(null);
//
//      BeanUtils.copyProperties(pojo, dto);
//      dto.setEmpleadoEducacionIterador(iteradorEducacion);
//      dto.setEmpleadoFamiliaIterador(iteradorFamilia);
//      dto.setEmpleadoLaboralIterador(iteradorLaboral);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteEmpleado(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getTbCuentas")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getTbCuentas(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbCuenta tbCuentaPOJO = mapper.readValue(Json, POJOTbCuenta.class);
//      TbCuentaDto tbCuentaFiltro = new TbCuentaDto();
//      tbCuentaFiltro.setConsecutivoCuenta(tbCuentaPOJO.getConsecutivoCuenta());
//      tbCuentaFiltro.setDescripcion(tbCuentaPOJO.getDescripcion());
//      FastTable<TbCuentaDto> tbCuentas = mantenimientoService.getListaTbCuentas(tbCuentaFiltro);
//
//      List<POJOTbCuenta> tbCuentasPOJO = new ArrayList<POJOTbCuenta>();
//      for (TbCuentaDto tbCuenta : tbCuentas) {
//        POJOTbCuenta pojoTbCuenta = new POJOTbCuenta();
//        BeanUtils.copyProperties(tbCuenta, pojoTbCuenta);
//        pojoTbCuenta.setTipoCuentaTexto(ETipoCuenta.getName(pojoTbCuenta.getTipoCuenta()));
//
//        pojoTbCuenta.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoTbCuenta.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        tbCuentasPOJO.add(pojoTbCuenta);
//      }
//
//      String jsonInString = mapper.writeValueAsString(tbCuentasPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteTbCuenta")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteTbCuenta(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbCuenta
//    try {
//      String path = "saveOrUpdateOrDeleteTbCuenta";
//      ObjectMapper mapper = new ObjectMapper();
//      TbCuentaDto tbCuentaDto = new TbCuentaDto();
//      POJOTbCuenta tbCuenta = mapper.readValue(Json, POJOTbCuenta.class);
//
//      BeanUtils.copyProperties(tbCuenta, tbCuentaDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(tbCuenta.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(tbCuenta.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) tbCuentaDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteTbCuenta(tbCuentaDto, tbCuenta.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getTiposEstablecimiento")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getTiposEstablecimiento(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbTipoEstablecimiento tipoEstablecimientoPOJO = mapper.readValue(Json, POJOTbTipoEstablecimiento.class);
//      TbTipoEstablecimientoDto tipoEstablecimientoFiltro = new TbTipoEstablecimientoDto();
//      tipoEstablecimientoFiltro.setConsecutivoTipoEstablecimiento(tipoEstablecimientoPOJO.getConsecutivoTipoEstablecimiento());
//      tipoEstablecimientoFiltro.setDescripcion(tipoEstablecimientoPOJO.getDescripcion());
//      FastTable<TbTipoEstablecimientoDto> tiposEstablecimiento = mantenimientoService.getListaTiposEstablecimiento(tipoEstablecimientoFiltro);
//
//      List<POJOTbTipoEstablecimiento> tiposEstablecimientoPOJO = new ArrayList<POJOTbTipoEstablecimiento>();
//      for (TbTipoEstablecimientoDto tipoEstablecimiento : tiposEstablecimiento) {
//        POJOTbTipoEstablecimiento pojoTipoEstablecimiento = new POJOTbTipoEstablecimiento();
//        BeanUtils.copyProperties(tipoEstablecimiento, pojoTipoEstablecimiento);
//        pojoTipoEstablecimiento.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoTipoEstablecimiento.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        tiposEstablecimientoPOJO.add(pojoTipoEstablecimiento);
//      }
//
//      String jsonInString = mapper.writeValueAsString(tiposEstablecimientoPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteTipoEstablecimiento")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteTipoEstablecimiento(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbTipoEstablecimiento
//    try {
//      String path = "saveOrUpdateOrDeleteTipoEstablecimiento";
//      ObjectMapper mapper = new ObjectMapper();
//      TbTipoEstablecimientoDto tipoEstablecimientoDto = new TbTipoEstablecimientoDto();
//      POJOTbTipoEstablecimiento tipoEstablecimiento = mapper.readValue(Json, POJOTbTipoEstablecimiento.class);
//
//      BeanUtils.copyProperties(tipoEstablecimiento, tipoEstablecimientoDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(tipoEstablecimiento.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(tipoEstablecimiento.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) tipoEstablecimientoDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteTipoEstablecimiento(tipoEstablecimientoDto, tipoEstablecimiento.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getIpsCuentas")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getIpsCuentas(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbIps POJO = mapper.readValue(Json, POJOTbIps.class);
//      TbIpsDto filtro = new TbIpsDto();
//      filtro.setConsecutivoTipoEstablecimiento(POJO.getConsecutivoTipoEstablecimiento());
//      filtro.setNombre(POJO.getNombre());
//      filtro.setMunicipio(POJO.getMunicipio());
//
//      FastTable<TbIpsDto> listaDtos = mantenimientoService.getListaIpsCuentas(filtro);
//      List<POJOTbIps> POJOresult = new ArrayList<POJOTbIps>();
//
//      for (TbIpsDto dto : listaDtos) {
//        POJOTbIps pojo = new POJOTbIps();
//
//        FastTable<TbIpsCuentaDto> iteradorIpsCuenta = new FastTable<TbIpsCuentaDto>();
//        FastTable<POJOTbIpsCuenta> iteradorIpsCuentaPOJO = new FastTable<POJOTbIpsCuenta>();
//        if (dto.getIpsCuentaIterador() != null) {
//          iteradorIpsCuenta.addAll(dto.getIpsCuentaIterador());
//        }
//        for (TbIpsCuentaDto itIpsCuenta : iteradorIpsCuenta) {
//          POJOTbIpsCuenta pojIpsCuenta = new POJOTbIpsCuenta();
//          BeanUtils.copyProperties(itIpsCuenta, pojIpsCuenta);
//          iteradorIpsCuentaPOJO.add(pojIpsCuenta);
//        }
//
//        dto.setIpsCuentaIterador(null);
//
//        BeanUtils.copyProperties(dto, pojo);
//        pojo.setIpsCuentaIterador(iteradorIpsCuentaPOJO);
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteIpsCuenta")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteIpsCuenta(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbIpsCuenta
//    try {
//      String path = "saveOrUpdateOrDeleteIpsCuenta";
//      ObjectMapper mapper = new ObjectMapper();
//      TbIpsDto dto = new TbIpsDto();
//      POJOTbIps pojo = mapper.readValue(Json, POJOTbIps.class);
//
//      FastTable<TbIpsCuentaDto> iteradorIpsCuenta = new FastTable<TbIpsCuentaDto>();
//      for (POJOTbIpsCuenta d : pojo.getIpsCuentaIterador()) {
//        TbIpsCuentaDto itera = new TbIpsCuentaDto();
//        BeanUtils.copyProperties(d, itera);
//        iteradorIpsCuenta.add(itera);
//      }
//
//      pojo.setIpsCuentaIterador(null);
//
//      BeanUtils.copyProperties(pojo, dto);
//      dto.setIpsCuentaIterador(iteradorIpsCuenta);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteIpsCuenta(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getGruposEspecialidad")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getGrupoEspecialidad(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOGrupoEspecialidad grupoEspecialidadPOJO = mapper.readValue(Json, POJOGrupoEspecialidad.class);
//      GrupoEspecialidadDto grupoEspecialidadFiltro = new GrupoEspecialidadDto();
//      grupoEspecialidadFiltro.setGrupoEspecialidad(grupoEspecialidadPOJO.getGrupoEspecialidad());
//      grupoEspecialidadFiltro.setDescripcion(grupoEspecialidadPOJO.getDescripcion());
//      FastTable<GrupoEspecialidadDto> grupoEspecialiadad = mantenimientoService.getListaGrupoEspecialidad(grupoEspecialidadFiltro);
//
//      List<POJOGrupoEspecialidad> gruposEspecialidadesPOJO = new ArrayList<POJOGrupoEspecialidad>();
//      for (GrupoEspecialidadDto grupo : grupoEspecialiadad) {
//        POJOGrupoEspecialidad pojoGrupoEspecialidad = new POJOGrupoEspecialidad();
//        BeanUtils.copyProperties(grupo, pojoGrupoEspecialidad);
//        pojoGrupoEspecialidad.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoGrupoEspecialidad.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        gruposEspecialidadesPOJO.add(pojoGrupoEspecialidad);
//      }
//
//      String jsonInString = mapper.writeValueAsString(gruposEspecialidadesPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteGruposEspecialidad")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteGrupoEspecialidad(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteGruposEspecialidad";
//      ObjectMapper mapper = new ObjectMapper();
//      GrupoEspecialidadDto grupoEspecialidadDto = new GrupoEspecialidadDto();
//      POJOGrupoEspecialidad grupoEspecialidadPojo = mapper.readValue(Json, POJOGrupoEspecialidad.class);
//
//      BeanUtils.copyProperties(grupoEspecialidadPojo, grupoEspecialidadDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(grupoEspecialidadPojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(grupoEspecialidadPojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) grupoEspecialidadDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteGrupoEspecialidad(grupoEspecialidadDto, grupoEspecialidadPojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getEspecialidades")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getListaEspecialidad(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOEspecialidad especialidadPOJO = mapper.readValue(Json, POJOEspecialidad.class);
//      EspecialidadDto especialidadFiltro = new EspecialidadDto();
//      especialidadFiltro.setEspecialidad(especialidadPOJO.getEspecialidad());
//      especialidadFiltro.setDescripcion(especialidadPOJO.getDescripcion());
//      especialidadFiltro.setCodigoInterno(especialidadPOJO.getCodigoInterno());
//      FastTable<EspecialidadDto> especialidad = mantenimientoService.getListaEspecialidad(especialidadFiltro);
//
//      List<POJOEspecialidad> especialidadesPOJO = new ArrayList<POJOEspecialidad>();
//      for (EspecialidadDto esp : especialidad) {
//        POJOEspecialidad pojoEspecialidad = new POJOEspecialidad();
//        BeanUtils.copyProperties(esp, pojoEspecialidad);
//        pojoEspecialidad.setCopiaCodigoInterno(esp.getCodigoInterno());
//        pojoEspecialidad.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoEspecialidad.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        especialidadesPOJO.add(pojoEspecialidad);
//      }
//
//      String jsonInString = mapper.writeValueAsString(especialidadesPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteEspecialidad")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteEspecialidad(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      boolean exist = false;
//      String path = "saveOrUpdateOrDeleteEspecialidad";
//      ObjectMapper mapper = new ObjectMapper();
//      EspecialidadDto especialidadDto = new EspecialidadDto();
//      POJOEspecialidad especialidadPojo = mapper.readValue(Json, POJOEspecialidad.class);
//
//      BeanUtils.copyProperties(especialidadPojo, especialidadDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(especialidadPojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(especialidadPojo.getStatusAction())) {
//
//        if (EAccion.EDIT.getText().equalsIgnoreCase(especialidadPojo.getStatusAction())) {
//          if (!especialidadPojo.getCodigoInterno().equalsIgnoreCase(especialidadPojo.getCopiaCodigoInterno())) {
//            exist = mantenimientoService.validarCodigoInterno(TbEspecialidad.class, "codigoInterno", especialidadDto.getCodigoInterno());
//            if (exist) {
//              return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId()));
//            }
//          }
//        }
//        else {
//          exist = mantenimientoService.validarCodigoInterno(TbEspecialidad.class, "codigoInterno", especialidadDto.getCodigoInterno());
//          if (exist) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId()));
//          }
//        }
//
//        String textoValidaciones = this.validaciones(path, (Object) especialidadDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteEspecialidad(especialidadDto, especialidadPojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getTipoConsultorio")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getListaTipoConsultorio(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTipoConsultorio tipoConsultorioPojo = mapper.readValue(Json, POJOTipoConsultorio.class);
//      TbTipoConsultorioDto tipoConsultorioFiltro = new TbTipoConsultorioDto();
//      tipoConsultorioFiltro.setConsecutivoTipo(tipoConsultorioPojo.getConsecutivoTipo());
//      tipoConsultorioFiltro.setDescripcion(tipoConsultorioPojo.getDescripcion());
//      FastTable<TbTipoConsultorioDto> consultorios = mantenimientoService.getListaTipoConsultorios(tipoConsultorioFiltro);
//
//      List<POJOTipoConsultorio> consultoriosPOJO = new ArrayList<POJOTipoConsultorio>();
//      for (TbTipoConsultorioDto esp : consultorios) {
//        POJOTipoConsultorio pojoConsultorios = new POJOTipoConsultorio();
//        BeanUtils.copyProperties(esp, pojoConsultorios);
//        pojoConsultorios.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoConsultorios.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        consultoriosPOJO.add(pojoConsultorios);
//      }
//
//      String jsonInString = mapper.writeValueAsString(consultoriosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteTipoConsultorio")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteTipoConsultorio(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteTipoConsultorio";
//      ObjectMapper mapper = new ObjectMapper();
//      TbTipoConsultorioDto tipoConsultorioDto = new TbTipoConsultorioDto();
//      POJOTipoConsultorio tipoConsultorioPojo = mapper.readValue(Json, POJOTipoConsultorio.class);
//
//      BeanUtils.copyProperties(tipoConsultorioPojo, tipoConsultorioDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(tipoConsultorioPojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(tipoConsultorioPojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) tipoConsultorioDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteTipoConsultorio(tipoConsultorioDto, tipoConsultorioPojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getHorarios")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getListaHorarios(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOHorarioEncabezadoQuery encabezadoPojo = mapper.readValue(Json, POJOHorarioEncabezadoQuery.class);
//      TbHorarioEncabezadoDto encabezadoFiltro = new TbHorarioEncabezadoDto();
//      encabezadoFiltro.setConsecutivoHorario(encabezadoPojo.getConsecutivoHorario());
//      encabezadoFiltro.setDescripcion(encabezadoPojo.getDescripcion());
//      FastTable<TbHorarioEncabezadoDto> encabezados = mantenimientoService.getListaHorarios(encabezadoFiltro);
//
//      FastTable<POJOHorarioEncabezado> encabezadosPOJO = new FastTable<POJOHorarioEncabezado>();
//      for (TbHorarioEncabezadoDto enc : encabezados) {
//        POJOHorarioEncabezado pojoEncabezados = new POJOHorarioEncabezado();
//        pojoEncabezados.setHorarioDetalles(new FastTable<POJOHorarioDetalle>());
//        short inc = 0;
//        int tamanoLista = enc.getDetalles().size();
//        for (TbHorarioDetalleDto detalle : enc.getDetalles()) {
//          inc++;
//          POJOHorarioDetalle detallePojo = new POJOHorarioDetalle();
//
//          Calendar cli = Calendar.getInstance();
//          Calendar clf = Calendar.getInstance();
//
//          cli.setTime(detalle.getHoraInicio());
//          clf.setTime(detalle.getHoraFin());
//
//          int hi = cli.get(Calendar.HOUR_OF_DAY);
//          int mi = cli.get(Calendar.MINUTE);
//          int hf = clf.get(Calendar.HOUR_OF_DAY);
//          int mf = clf.get(Calendar.MINUTE);
//
//          String strHi = (hi < 10 ? "0" + hi : hi) + ":" + (mi < 10 ? "0" + mi : mi);
//          String strHf = (hf < 10 ? "0" + hf : hf) + ":" + (mf < 10 ? "0" + mf : mf);
//
//          if (inc == 1) {
//            pojoEncabezados.setHoraInicioTexto(strHi);
//            pojoEncabezados.setHoraInicio(detalle.getHoraInicio());
//          }
//          if (inc == tamanoLista) {
//            pojoEncabezados.setHoraFinTexto(strHf);
//            pojoEncabezados.setHoraFin(detalle.getHoraFin());
//          }
//
//          detallePojo.setConsecutivoHorario(detalle.getConsecutivoHorario());
//          detallePojo.setHoraInicioTexto(strHi);
//          detallePojo.setHoraFinTexto(strHf);
//          detallePojo.setHoraInicio(detalle.getHoraInicio());
//          detallePojo.setHoraFin(detalle.getHoraFin());
//
//          pojoEncabezados.getHorarioDetalles().add(detallePojo);
//        }
//
//        BeanUtils.copyProperties(enc, pojoEncabezados);
//        pojoEncabezados.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoEncabezados.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        encabezadosPOJO.add(pojoEncabezados);
//      }
//
//      String jsonInString = mapper.writeValueAsString(encabezadosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/apiUrlGenerateSchedule")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response apiUrlGenerateSchedule(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "apiUrlGenerateSchedule";
//      ObjectMapper mapper = new ObjectMapper();
//      TbHorarioEncabezadoDto encabezadoDto = new TbHorarioEncabezadoDto();
//      POJOHorarioEncabezado encabezadoPojo = new POJOHorarioEncabezado();
//      
//      boolean correcto = this.validarHoras(Json, encabezadoDto);
//
//      if (!correcto) {
//        POJOHorarioEncabezadoQuery encabezadoQuery = mapper.readValue(Json, POJOHorarioEncabezadoQuery.class);
//        BeanUtils.copyProperties(encabezadoQuery, encabezadoDto);
//        encabezadoDto.setAccion("GENERAR");
//      }
//      else {
//        encabezadoPojo = mapper.readValue(Json, POJOHorarioEncabezado.class);
//        BeanUtils.copyProperties(encabezadoPojo, encabezadoDto);
//      }
//
//      String textoValidaciones = this.validaciones(path, (Object) encabezadoDto);
//      if (!Util.vacio(textoValidaciones)) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//      }
//
//      FastTable<POJOHorarioDetalle> pojoResultado = new FastTable<POJOHorarioDetalle>();
//      encabezadoDto.setDetalles(mantenimientoService.getListSchedule(encabezadoDto));
//      if (encabezadoDto.getDetalles() != null) {
//        for (TbHorarioDetalleDto detalle : encabezadoDto.getDetalles()) {
//          POJOHorarioDetalle pojoDetalle = new POJOHorarioDetalle();
//
//          pojoDetalle.setSecuencia(detalle.getSecuencia());
//          pojoDetalle.setHoraInicio(detalle.getHoraInicio());
//          pojoDetalle.setHoraFin(detalle.getHoraFin());
//
//          // se llena las variables tipo texto para ver en la vista
//          Calendar cli = Calendar.getInstance();
//          Calendar clf = Calendar.getInstance();
//
//          cli.setTime(pojoDetalle.getHoraInicio());
//          clf.setTime(pojoDetalle.getHoraFin());
//
//          int hi = cli.get(Calendar.HOUR_OF_DAY);
//          int mi = cli.get(Calendar.MINUTE);
//          int hf = clf.get(Calendar.HOUR_OF_DAY);
//          int mf = clf.get(Calendar.MINUTE);
//
//          String strHi = (hi < 10 ? "0" + hi : hi) + ":" + (mi < 10 ? "0" + mi : mi);
//          String strHf = (hf < 10 ? "0" + hf : hf) + ":" + (mf < 10 ? "0" + mf : mf);
//
//          pojoDetalle.setHoraInicioTexto(strHi);
//          pojoDetalle.setHoraFinTexto(strHf);
//          pojoDetalle.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//          pojoDetalle.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//          pojoResultado.add(pojoDetalle);
//        }
//      }
//
//      String jsonInString = mapper.writeValueAsString(pojoResultado);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteHorario")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteHorario(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteHorario";
//      ObjectMapper mapper = new ObjectMapper();
//      TbHorarioEncabezadoDto encabezadoDto = new TbHorarioEncabezadoDto();
//      POJOHorarioEncabezado encabezadoPojo = new POJOHorarioEncabezado();
//      encabezadoDto.setDetalles(new FastTable<TbHorarioDetalleDto>());
//
//      boolean valido = this.validarHoras(Json, encabezadoDto);
//
//      if (!valido) {
//        POJOHorarioEncabezadoQuery encabezadoQuery = mapper.readValue(Json, POJOHorarioEncabezadoQuery.class);
//        BeanUtils.copyProperties(encabezadoQuery, encabezadoDto);
//        encabezadoPojo.setStatusAction(encabezadoQuery.getStatusAction());
//        encabezadoDto.setAccion("GENERAR");
//      }
//      else {
//        encabezadoPojo = mapper.readValue(Json, POJOHorarioEncabezado.class);
//        BeanUtils.copyProperties(encabezadoPojo, encabezadoDto);
//        
//        Calendar cli = Calendar.getInstance();
//        Calendar clf = Calendar.getInstance();
//        
//        for (POJOHorarioDetalle detallePojo : encabezadoPojo.getHorarioDetalles()) {
//          TbHorarioDetalleDto detalleDto = new TbHorarioDetalleDto();
//          
//          cli.set(Calendar.HOUR_OF_DAY, Integer.parseInt(detallePojo.getHoraInicioTexto().split(":")[0]));
//          cli.set(Calendar.MINUTE, Integer.parseInt(detallePojo.getHoraInicioTexto().split(":")[1]));
//          
//          clf.set(Calendar.HOUR_OF_DAY, Integer.parseInt(detallePojo.getHoraFinTexto().split(":")[0]));
//          clf.set(Calendar.MINUTE, Integer.parseInt(detallePojo.getHoraFinTexto().split(":")[1]));
//          
//          detalleDto.setHoraInicio(cli.getTime());
//          detalleDto.setHoraFin(clf.getTime());
//
//          encabezadoDto.getDetalles().add(detalleDto);
//        }
//      }
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(encabezadoPojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(encabezadoPojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) encabezadoDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteHorario(encabezadoDto, encabezadoPojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getServicios")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getServicios(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOTbServicio servicioPOJO = mapper.readValue(Json, POJOTbServicio.class);
//      TbServicioDto servicioFiltro = new TbServicioDto();
//
//      servicioFiltro.setCodigoInterno(servicioPOJO.getCodigoInterno());
//      servicioFiltro.setNombre(servicioPOJO.getNombre());
//      FastTable<TbServicioDto> servicio = mantenimientoService.getListaServicios(servicioFiltro);
//
//      List<POJOTbServicio> serviciosPOJO = new ArrayList<POJOTbServicio>();
//
//      for (TbServicioDto dto : servicio) {
//        POJOTbServicio pojo = new POJOTbServicio();
//        BeanUtils.copyProperties(dto, pojo);
//        serviciosPOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(serviciosPOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteServicio")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteServicio(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteServicio";
//      ObjectMapper mapper = new ObjectMapper();
//      TbServicioDto dto = new TbServicioDto();
//      POJOTbServicio pojo = mapper.readValue(Json, POJOTbServicio.class);
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else {
//          FastTable<TbServicioDto> productos = mantenimientoService.getListaServicios(new TbServicioDto());
//          boolean flag = true;
//          for (TbServicioDto obj : productos) {
//            if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//              if (obj.getCodigoInterno().equals(dto.getCodigoInterno())) {
//                flag = false;
//                break;
//              }
//            }
//            else {
//              if (obj.getConsecutivoServicio() != dto.getConsecutivoServicio() && obj.getCodigoInterno().equals(dto.getCodigoInterno())) {
//                flag = false;
//                break;
//              }
//            }
//          }
//
//          if (!flag) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId()));
//          }
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteServicio(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getProgramaServicio")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getListaProgramas(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOCtProgramaServicio programaPojo = mapper.readValue(Json, POJOCtProgramaServicio.class);
//      CtProgramaServicioDto programaFiltro = new CtProgramaServicioDto();
//      programaFiltro.setConsecutivoProducto(programaPojo.getConsecutivoProducto());
//      programaFiltro.setNombre(programaPojo.getNombre());
//      programaFiltro.setCodigoInterno(programaPojo.getCodigoInterno());
//      FastTable<CtProgramaServicioDto> programas = mantenimientoService.getListaProgramas(programaFiltro);
//
//      List<POJOCtProgramaServicio> programasPOJO = new ArrayList<POJOCtProgramaServicio>();
//      for (CtProgramaServicioDto programa : programas) {
//        POJOCtProgramaServicio pojoPrograma = new POJOCtProgramaServicio();
//        BeanUtils.copyProperties(programa, pojoPrograma);
//        pojoPrograma.setCopiaCodigoInterno(programa.getCodigoInterno());
//
//        pojoPrograma.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoPrograma.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        programasPOJO.add(pojoPrograma);
//      }
//
//      String jsonInString = mapper.writeValueAsString(programasPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteProgramaServicio")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteProgramaServicio(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteProgramaServicio";
//      boolean exist = false;
//      ObjectMapper mapper = new ObjectMapper();
//      CtProgramaServicioDto programaDto = new CtProgramaServicioDto();
//      POJOCtProgramaServicio programaPojo = mapper.readValue(Json, POJOCtProgramaServicio.class);
//
//      BeanUtils.copyProperties(programaPojo, programaDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(programaPojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(programaPojo.getStatusAction())) {
//
//        if (EAccion.EDIT.getText().equalsIgnoreCase(programaPojo.getStatusAction())) {
//          if (!programaPojo.getCodigoInterno().equalsIgnoreCase(programaPojo.getCopiaCodigoInterno())) {
//            exist = mantenimientoService.validarCodigoInterno(CtProgramaServicio.class, "codigoInterno", programaPojo.getCodigoInterno());
//            if (exist) {
//              return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId()));
//            }
//          }
//        }
//        else {
//          exist = mantenimientoService.validarCodigoInterno(CtProgramaServicio.class, "codigoInterno", programaDto.getCodigoInterno());
//          if (exist) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO.getId()));
//          }
//        }
//
//        String textoValidaciones = this.validaciones(path, (Object) programaDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteProgramaServicio(programaDto, programaPojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getSoat")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getSoat(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOTbSoat soatPOJO = mapper.readValue(Json, POJOTbSoat.class);
//      TbSoatDto soatFiltro = new TbSoatDto();
//
//      soatFiltro.setSoat(soatPOJO.getSoat());
//      soatFiltro.setDescripcion(soatPOJO.getDescripcion());
//      FastTable<TbSoatDto> soats = mantenimientoService.getListaSoat(soatFiltro);
//
//      List<POJOTbSoat> POJOresult = new ArrayList<POJOTbSoat>();
//
//      FastTable<TbSoatValorDto> listaDeTemp = new FastTable<TbSoatValorDto>();
//      for (TbSoatDto dto : soats) {
//        listaDeTemp.addAll(dto.getValoresSoat());
//
//        POJOTbSoat pojo = new POJOTbSoat();
//        // limpiar la lista antes de pasar al POJO
//        dto.getValoresSoat().clear();
//        BeanUtils.copyProperties(dto, pojo);
//
//        // pasar los detalles
//        for (TbSoatValorDto detalle : listaDeTemp) {
//          POJOTbSoatValor pojoDetalle = new POJOTbSoatValor();
//          BeanUtils.copyProperties(detalle, pojoDetalle);
//          pojo.getValoresSoat().add(pojoDetalle);
//        }
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//        listaDeTemp.clear();
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteSoat")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteSoat(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteSoat";
//      ObjectMapper mapper = new ObjectMapper();
//      TbSoatDto dto = new TbSoatDto();
//      POJOTbSoat pojo = mapper.readValue(Json, POJOTbSoat.class);
//
//      FastTable<TbSoatValorDto> detalles = new FastTable<TbSoatValorDto>();
//      for (POJOTbSoatValor d : pojo.getValoresSoat()) {
//        TbSoatValorDto detalle = new TbSoatValorDto();
//        BeanUtils.copyProperties(d, detalle);
//        detalles.add(detalle);
//      }
//
//      BeanUtils.copyProperties(pojo, dto);
//      dto.setValoresSoat(new FastTable<TbSoatValorDto>());
//      dto.getValoresSoat().addAll(detalles);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteSoat(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getIss")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getIss(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOTbIss issPOJO = mapper.readValue(Json, POJOTbIss.class);
//      TbIssDto issFiltro = new TbIssDto();
//
//      issFiltro.setIss(issPOJO.getIss());
//      issFiltro.setDescripcion(issPOJO.getDescripcion());
//      FastTable<TbIssDto> iss = mantenimientoService.getListaIss(issFiltro);
//
//      List<POJOTbIss> issListPOJO = new ArrayList<POJOTbIss>();
//
//      for (TbIssDto dto : iss) {
//        POJOTbIss pojo = new POJOTbIss();
//        BeanUtils.copyProperties(dto, pojo);
//        issListPOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(issListPOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteIss")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteIss(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteIss";
//      ObjectMapper mapper = new ObjectMapper();
//      TbIssDto dto = new TbIssDto();
//      POJOTbIss pojo = mapper.readValue(Json, POJOTbIss.class);
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteIss(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getContratoMedicamentos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getContratoMedicamentos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOCtContratoMedicamento objPOJO = mapper.readValue(Json, POJOCtContratoMedicamento.class);
//      POJOTbMedicamento medicamentoPOJO = mapper.readValue(Json, POJOTbMedicamento.class);
//      FastTable<CtContratoMedicamentoDto> list = mantenimientoService.getListaContratoMedicamentos(objPOJO.getConsecutivoContrato(), medicamentoPOJO.getProducto(), medicamentoPOJO.getDescripcionComercial());
//
//      List<POJOCtContratoMedicamento> objListPOJO = new ArrayList<POJOCtContratoMedicamento>();
//
//      for (CtContratoMedicamentoDto dto : list) {
//        POJOCtContratoMedicamento pojo = new POJOCtContratoMedicamento();
//        BeanUtils.copyProperties(dto, pojo);
//        objListPOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(objListPOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getContratoInsumos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getContratoInsumos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOCtContratoInsumo objPOJO = mapper.readValue(Json, POJOCtContratoInsumo.class);
//      POJOTbInsumo insumoPOJO = mapper.readValue(Json, POJOTbInsumo.class);
//      FastTable<CtContratoInsumoDto> list = mantenimientoService.getListaContratoInsumos(objPOJO.getConsecutivoContrato(), insumoPOJO.getCodigoInterno(), insumoPOJO.getDescripcion());
//
//      List<POJOCtContratoInsumo> objListPOJO = new ArrayList<POJOCtContratoInsumo>();
//
//      for (CtContratoInsumoDto dto : list) {
//        POJOCtContratoInsumo pojo = new POJOCtContratoInsumo();
//        BeanUtils.copyProperties(dto, pojo);
//        objListPOJO.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(objListPOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  private boolean validarHoras(String Json, TbHorarioEncabezadoDto dto) {
//    String[] str = Json.split(",");
//    for (String c : str) {
//      if (c.contains("horaInicioTexto")) {
//        String[] v = c.split(":");
//        if (v[1].length() > 3) {
//          Calendar cl = Calendar.getInstance();
//          cl.setTime(new Date());
//          String hora = v[1].replace("\"", "");
//          String min = v[2].replace("\"", "");
//          cl.set(Calendar.HOUR_OF_DAY, Integer.valueOf(hora.trim()));
//          cl.set(Calendar.MINUTE, Integer.parseInt(min.trim()));
//          dto.setHoraInicio(cl.getTime());
//          continue;
//        }
//      }
//      else if (c.contains("horaFinTexto")) {
//        String[] v = c.split(":");
//        if (v[1].length() > 3) {
//          Calendar cl = Calendar.getInstance();
//          cl.setTime(new Date());
//          String hora = v[1].replace("\"", "");
//          String min = v[2].replace("\"", "");
//          cl.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora.trim()));
//          cl.set(Calendar.MINUTE, Integer.parseInt(min.trim()));
//          dto.setHoraFin(cl.getTime());
//        }
//      }
//
//      if (dto.getHoraInicio() != null && dto.getHoraFin() != null) {
//        return true;
//      }
//      else if (c.contains("horaInicio") || c.contains("horaFin")) {
//        String[] r = c.split(":");
//        if (r[1].contains("{}")) {
//          return false;
//        }
//      }
//    }
//    return false;
//  }
//
//  @POST
//  @Path("/uploadImportServiciosXCupsMasivo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response uploadImportServiciosXCupsMasivo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOFileUpload filePOJO = mapper.readValue(Json, POJOFileUpload.class);
//
//      InputStream stream = new ByteArrayInputStream(filePOJO.getContentDecodeB64().getBytes(StandardCharsets.UTF_8));
//      FastTable<String> lista = FileUtilities.toListFileStringPipe(stream);
//      lista.remove(0);
//
//      int LONGITUD_REF = 3;
//      FastTable<String> listaErroresEstructura = new FastTable<String>();
//      FastTable<String> listaErroresContenido = new FastTable<String>();
//
//      // validando que no venga vacío el archivo
//      if (lista.isEmpty()) {
//        ArrayList<String> errores = new ArrayList<String>();
//        String error = "El archivo se encuentra vacío o su contenido no es suficiente para la importación. Por favor Revise el fichero.";
//        errores.add(error);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//
//      // Validando Estructura
//      int i = 1;
//      for (String linea : lista) {
//        int longitud = linea.split("\\|").length;
//        if (longitud != LONGITUD_REF) {
//          listaErroresEstructura.add("Línea #" + i + ": (" + linea + ") - ERROR => No cumple con la estructura - Cant. Permitida: " + LONGITUD_REF);
//        }
//        i++;
//      }
//
//      // Validando Contenido
//      if (listaErroresEstructura.isEmpty()) {
//        int j = 1;
//
//        final int CODIGO_SERVICIO = 0;
//        final int CODIGO_CUP = 1;
//        final int INDICADOR = 2;
//
//        FastTable<TbServicioCupDto> serviciosImportar = new FastTable<TbServicioCupDto>();
//        FastMap<Long, TbCupDto> mapCups = mantenimientoService.getMapCups();
//        FastMap<Long, TbServicioDto> mapServices = mantenimientoService.getMapServices();
//        FastMap<String, TbServicioCupDto> mapServicesXCups = mantenimientoService.getMapServicesXCups();
//        boolean correct = true;
//
//        for (String linea : lista) {
//          TbServicioCupDto dto = new TbServicioCupDto();
//          String[] campos = linea.split("\\|");
//
//          dto.setConsecutivoServicio(Util.vacio(campos[CODIGO_SERVICIO]) ? null : Long.parseLong(campos[CODIGO_SERVICIO]));
//          dto.setConsecutivoCup(Util.vacio(campos[CODIGO_CUP]) ? null : Long.parseLong(campos[CODIGO_CUP]));
//          dto.setIndicador(Util.vacio(campos[INDICADOR]) ? null : Short.parseShort(campos[INDICADOR]));
//
//          String errorLinea = "Línea #" + j + ": (" + linea + ") - ";
//          if (dto.getConsecutivoServicio() == null) {
//            errorLinea = errorLinea + "(ERROR => Consecutivo Servicio): -Texto- Campo Obligatorio vacío. ";
//            correct = false;
//          }
//          else {
//            if (mapServices.get(dto.getConsecutivoServicio()) == null) {
//              errorLinea = errorLinea + "(ERROR => Consecutivo Servicio): - No existe en el Sistema. ";
//              correct = false;
//            }
//          }
//
//          if (dto.getConsecutivoCup() == null) {
//            errorLinea = errorLinea + "(ERROR => Consecutivo Cup): -Texto- Campo Obligatorio vacío. ";
//            correct = false;
//          }
//          else {
//            if (mapCups.get(dto.getConsecutivoCup()) == null) {
//              errorLinea = errorLinea + "(ERROR => Consecutivo Cup): - No existe en el Sistema. ";
//              correct = false;
//            }
//          }
//
//          if (dto.getIndicador() == null) {
//            errorLinea = errorLinea + "(ERROR => Indicador): -Texto- Campo Obligatorio vacío. ";
//            correct = false;
//          }
//          else {
//            if (dto.getIndicador().shortValue() < 1 && dto.getIndicador() > 2) {
//              errorLinea = errorLinea + "(ERROR => Indicador): - El indicador debe ser 1 o 2. ";
//              correct = false;
//            }
//            else {
//              if (dto.getIndicador() == ESiNo.SI.getId()) {
//                String key = dto.getConsecutivoServicio() + "-" + dto.getConsecutivoCup();
//
//                if (mapServicesXCups.get(key) != null) {
//                  errorLinea = errorLinea + "(ERROR => El servicio - cup): - Ya existe en el sistema. ";
//                  correct = false;
//                }
//              }
//            }
//          }
//
//          if (!correct) {
//            listaErroresContenido.add(errorLinea);
//          }
//          else {
//            serviciosImportar.add(dto);
//          }
//
//          j++;
//        }
//
//        if (listaErroresContenido.isEmpty()) {
//          boolean result = mantenimientoService.saveOrDeleteServicioCup(serviciosImportar);
//          if (result) {
//            return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//          }
//          else {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//          }
//        }
//        else {
//          ArrayList<String> errores = new ArrayList<String>();
//          errores.addAll(listaErroresEstructura);
//          errores.addAll(listaErroresContenido);
//          filePOJO.setErrores(errores);
//          filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//          filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//          String jsonInString = mapper.writeValueAsString(filePOJO);
//
//          return Response.ok(jsonInString).build();
//        }
//      }
//      else {
//        ArrayList<String> errores = new ArrayList<String>();
//        errores.addAll(listaErroresEstructura);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/consultaAutorizacionWS")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response consultaAutorizacionWS(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOInformacionAutorizacion autorizacionPojo = mapper.readValue(Json, POJOInformacionAutorizacion.class);
//
//      autorizacionPojo.setAfiliado(new POJOInformacionAutorizacionAfiliado());
//      String numeroAutorizacion = autorizacionPojo.getNumeroAutorizacion();
//      InformacionAutorizacionDto autorizacionDto = informacionAutorizacionWSService.getAutorizacion(numeroAutorizacion, "");
//
//      if (autorizacionDto.getNumeroAutorizacion() != null) {
//
//        BeanUtils.copyProperties(autorizacionDto, autorizacionPojo);
//        BeanUtils.copyProperties(autorizacionDto.getAfiliado(), autorizacionPojo.getAfiliado());
//        Object[] medicamentos = autorizacionDto.getMedicamentos();
//        Long consecutivoIps = Long.parseLong(autorizacionPojo.getIpsSesion());
//
//        // se valida el afiliado y el contrato
//        if (!mantenimientoService.validarInformacionAutorizacion(autorizacionPojo.getAfiliado(), autorizacionDto.getContrato())) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_PACIENTE_CONTRATO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_PACIENTE_CONTRATO.getId()));
//        }
//
//        // mapa carga los detalles de las autorizaciones para conocer las cantidades entregadas
//        FastMap<Long, EntAutorizacionDetalleDto> mapaEntregas = mantenimientoService.getMapaAutorizacionDetalleXMedicamento();
//
//        Object[] copiaMedicamentos = new Object[medicamentos.length];
//        int inc = 0;
//        for (Object obj : medicamentos) {
//          com.hts.ips.datos.dtos.AutorizacionItemDto dto = new com.hts.ips.datos.dtos.AutorizacionItemDto();
//          AutorizacionItemDto aut = (AutorizacionItemDto) obj;
//
//          BeanUtils.copyProperties(aut, dto);
//          copiaMedicamentos[inc] = dto;
//          inc++;
//        }
//
//        // lista de los medicamentos autorizados o contratados
//        FastTable<CtContratoMedicamentoDto> medicamentosAutorizados = mantenimientoService.getMedicamentosAutorizados(copiaMedicamentos, autorizacionDto.getContrato());
//        // mapa de medicamentos
//        FastMap<String, TbMedicamentoDto> mapaMedicamento = mantenimientoService.getMedicamentosXAtc();
//        List<POJOAutorizacionItem> items = new ArrayList<POJOAutorizacionItem>();
//        FastMap<Long, LogMedicamentoDto> mapaLogMedicamento = mantenimientoService.getMapaLogMedicamento(consecutivoIps);
//
//        int posicion = 0;
//        // se crea una lista con las coincidencias de los medicamentos contratados
//        if (medicamentosAutorizados != null) {
//          for (CtContratoMedicamentoDto dto : medicamentosAutorizados) {
//            TbMedicamentoDto medi = mapaMedicamento.get(dto.getTbMedicamento().getAtc());
//            LogMedicamentoDto log = mapaLogMedicamento.get(dto.getConsecutivoMedicamento());
//            if (medi != null && log != null) {
//              POJOAutorizacionItem pojoItem = new POJOAutorizacionItem();
//
//              pojoItem.setCantidad("");
//              pojoItem.setCodigo(medi.getExpediente());
//              pojoItem.setCodigoExtra(medi.getRegistroSanitario() + " " + medi.getProducto() + " " + medi.getDescripcionComercial() + " " + medi.getAtc());
//              pojoItem.setConsecutivoMedicamento(dto.getConsecutivoMedicamento());
//              pojoItem.setLogCantidadReal((int) log.getCantidadReal());
//              pojoItem.setLogCantidad((int) log.getCantidad());
//
//              items.add(pojoItem);
//            }
//          }
//        }
//
//        List<POJOAutorizacionItem> FinalMedicamentoPojo = new ArrayList<POJOAutorizacionItem>();
//
//        // se crea una lista y se organizan los medicamentos con las coincidencias
//        posicion = 0;
//        for (AutorizacionItemDto medicamentoDto : autorizacionDto.getMedicamentos()) {
//          posicion++;
//
//          if (posicion == autorizacionDto.getMedicamentos().length) {
//            break;
//          }
//
//          // se agrega la cabecera de los medicamentos
//          POJOAutorizacionItem pojoItem = new POJOAutorizacionItem();
//
//          TbMedicamentoDto medicamento = mapaMedicamento.get(medicamentoDto.getCodigo());
//          pojoItem.setConsecutivoMedicamento(medicamento == null ? null : medicamento.getConsecutivoMedicamento());
//
//          BeanUtils.copyProperties(medicamentoDto, pojoItem);
//          FinalMedicamentoPojo.add(pojoItem);
//
//          for (POJOAutorizacionItem pojo : items) {
//            // se agregan las coincidencias al medicamento
//            if (pojo.getConsecutivoMedicamento() == pojoItem.getConsecutivoMedicamento()) {
//              FinalMedicamentoPojo.add(pojo);
//            }
//          }
//        }
//
//        POJOAutorizacionItem[] listaItems = new POJOAutorizacionItem[FinalMedicamentoPojo.size()];
//
//        // se llena la lista final de medicamentos
//        if (FinalMedicamentoPojo != null) {
//          posicion = 0;
//          for (POJOAutorizacionItem i : FinalMedicamentoPojo) {
//            if ((!Util.vacio(i.getCantidad()) && i.getConsecutivoMedicamento() != null)) {
//              EntAutorizacionDetalleDto entrega = mapaEntregas.get(i.getConsecutivoMedicamento());
//              if (entrega != null) {
//                i.setCadenaCantidad(i.getCantidad() + "/" + (int) entrega.getCantidadEntrega());
//              }
//              else {
//                i.setCadenaCantidad(i.getCantidad() + "/" + 0);
//              }
//            }
//            else if (!Util.vacio(i.getCantidad())) {
//              i.setCadenaCantidad(i.getCantidad() + "/" + 0);
//            }
//
//            listaItems[posicion] = i;
//            posicion++;
//          }
//        }
//
//        // se llenan los insumos
//        POJOAutorizacionItem[] insumosPojo = new POJOAutorizacionItem[autorizacionDto.getInsumos().length];
//        posicion = 0;
//        for (AutorizacionItemDto insumo : autorizacionDto.getInsumos()) {
//          POJOAutorizacionItem pojoItem = new POJOAutorizacionItem();
//          BeanUtils.copyProperties(insumo, pojoItem);
//
//          insumosPojo[posicion] = pojoItem;
//          posicion++;
//        }
//
//        // se llenan los procedimientos
//        POJOAutorizacionItem[] procedimientosPojo = new POJOAutorizacionItem[autorizacionDto.getProcedimientos().length];
//        posicion = 0;
//        for (AutorizacionItemDto procedimiento : autorizacionDto.getProcedimientos()) {
//
//          POJOAutorizacionItem pojoItem = new POJOAutorizacionItem();
//          BeanUtils.copyProperties(procedimiento, pojoItem);
//
//          procedimientosPojo[posicion] = pojoItem;
//          posicion++;
//        }
//
//        autorizacionPojo.setInsumos(insumosPojo);
//        autorizacionPojo.setMedicamentos(listaItems);
//        autorizacionPojo.setProcedimientos(procedimientosPojo);
//
//        String nombreCompleto = autorizacionDto.getAfiliado().getPrimerNombre() + " " + (Util.vacio(autorizacionDto.getAfiliado().getSegundoNombre()) ? "" : autorizacionDto.getAfiliado().getSegundoNombre()) + " " + autorizacionDto.getAfiliado().getPrimerApellido() + " " + (Util.vacio(autorizacionDto.getAfiliado().getSegundoApellido()) ? " " : autorizacionDto.getAfiliado().getSegundoApellido());
//
//        autorizacionPojo.getAfiliado().setTipoAfiliado(ETipoAfiliadoOtro.getName(Short.parseShort(autorizacionDto.getAfiliado().getTipoAfiliado())));
//        autorizacionPojo.getAfiliado().setCategoria(autorizacionDto.getAfiliado().getCategoria());
//        autorizacionPojo.getAfiliado().setNombreCompleto(nombreCompleto);
//        autorizacionPojo.getAfiliado().setUbicacionCompleto(autorizacionDto.getAfiliado().getMunicipio() + "/" + autorizacionDto.getAfiliado().getDepartamento());
//        autorizacionPojo.getAfiliado().setRegimen(ETipoRegimenSalud.getName(Short.parseShort(autorizacionDto.getAfiliado().getRegimen())));
//
//        autorizacionPojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        autorizacionPojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        // Cargando Soportes entrega que puede permitir
//        FastTable<TbTipoSoporteDto> soportes = mantenimientoService.getListaTiposSoporte(new TbTipoSoporteDto());
//        FastMap<Long, TbTipoSoporteDto> mapaSoportes = new FastMap<Long, TbTipoSoporteDto>();
//        for (TbTipoSoporteDto sopor : soportes) {
//          if (!mapaSoportes.containsKey(sopor.getConsecutivoSoporte())) {
//            mapaSoportes.put(sopor.getConsecutivoSoporte(), sopor);
//          }
//        }
//
//        short proc = Util.vacio(autorizacionDto.getSwPos()) ? EProceso.AUTORIZACION_NO_POS.getId() : (Util.isNumber(autorizacionDto.getSwPos()) ? Short.parseShort(autorizacionDto.getSwPos()) : EProceso.AUTORIZACION_NO_POS.getId());
//        autorizacionPojo.setProceso(proc == 1 ? EProceso.AUTORIZACION_POS.getId() : EProceso.AUTORIZACION_NO_POS.getId());
//        TbProcesoEncabezadoDto dtoProceso = new TbProcesoEncabezadoDto();
//        dtoProceso.setProceso(autorizacionPojo.getProceso());
//        FastTable<TbProcesoEncabezadoDto> procesos = mantenimientoService.getListaTiposSoporteXProceso(dtoProceso);
//        FastTable<POJOTbProcesoDetalle> pojosDetProceso = new FastTable<POJOTbProcesoDetalle>();
//        if (procesos != null && !procesos.isEmpty()) {
//          FastTable<TbProcesoDetalleDto> detallesProceso = procesos.getFirst().getDetallesProceso();
//          if (detallesProceso != null && !detallesProceso.isEmpty()) {
//            for (TbProcesoDetalleDto det : detallesProceso) {
//              // Solo los soportes activos
//              if (det.getSwActivo() == ESiNo.SI.getId()) {
//                POJOTbProcesoDetalle tempPojo = new POJOTbProcesoDetalle();
//                BeanUtils.copyProperties(det, tempPojo);
//                tempPojo.setSwObligatorioTexto(ESiNo.getName(det.getSwObligatorio()));
//                tempPojo.setSwActivoTexto(ESiNo.getName(det.getSwActivo()));
//                tempPojo.setSoporteTexto(mapaSoportes.get(det.getConsecutivoSoporte()).getDescripcion());
//                pojosDetProceso.add(tempPojo);
//              }
//            }
//          }
//        }
//        autorizacionPojo.setSoportesEntrega(pojosDetProceso);
//      }
//
//      String jsonInString = mapper.writeValueAsString(autorizacionPojo);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/uploadImportContratoInsumosMasivo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response uploadImportContratoInsumosMasivo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOFileUpload filePOJO = mapper.readValue(Json, POJOFileUpload.class);
//
//      // byte[] name = Base64.getEncoder().encode("hello World".getBytes());
//      // byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
//
//      InputStream stream = new ByteArrayInputStream(filePOJO.getContentDecodeB64().getBytes(StandardCharsets.UTF_8));
//      FastTable<String> lista = FileUtilities.toListFileStringPipe(stream);
//      lista.remove(0);
//
//      int LONGITUD_REF = 2;
//      FastTable<String> listaErroresEstructura = new FastTable<String>();
//      FastTable<String> listaErroresContenido = new FastTable<String>();
//
//      // validando que no venga vacío el archivo
//      if (lista.isEmpty()) {
//        ArrayList<String> errores = new ArrayList<String>();
//        String error = "El archivo se encuentra vacío o su contenido no es suficiente para la importación. Por favor Revise el fichero.";
//        errores.add(error);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//
//      // Validando Estructura
//      int i = 1;
//      for (String linea : lista) {
//        int longitud = linea.split("\\|").length;
//        if (longitud != LONGITUD_REF) {
//          listaErroresEstructura.add("Línea #" + i + ": (" + linea + ") - ERROR => No cumple con la estructura - Cant. Permitida: " + LONGITUD_REF);
//        }
//
//        i++;
//      }
//
//      // Validando Contenido
//      if (listaErroresEstructura.isEmpty()) {
//        int j = 1;
//
//        final int CODIGO_INTERNO = 0;
//        final int VALOR = 1;
//
//        FastTable<CtContratoInsumoDto> conInsumosImportar = new FastTable<CtContratoInsumoDto>();
//        FastTable<TbInsumoDto> listaInsumos = mantenimientoService.getListaInsumos(new TbInsumoDto());
//        FastMap<String, TbInsumoDto> mapaInsumosXCod = new FastMap<String, TbInsumoDto>();
//        for (TbInsumoDto insu : listaInsumos) {
//          if (!mapaInsumosXCod.containsKey(insu.getCodigoInterno())) {
//            mapaInsumosXCod.put(insu.getCodigoInterno(), insu);
//          }
//        }
//        FastSet<String> codigosInternos = new FastSet<String>();
//
//        for (String linea : lista) {
//          CtContratoInsumoDto contratoInsumoDto = new CtContratoInsumoDto();
//          TbInsumoDto insumoDto = new TbInsumoDto();
//          String[] campos = linea.split("\\|");
//          // Estructura: Código Interno|Valor (valor decimal separado por punto '.'
//          // CINS10|100.20
//
//          contratoInsumoDto.setConsecutivoContrato(filePOJO.getConsecutivoContrato());
//          contratoInsumoDto.setUsuarioGrabado(filePOJO.getUsuario());
//          insumoDto.setCodigoInterno(!Util.vacio(campos[CODIGO_INTERNO]) ? (mapaInsumosXCod.get(campos[CODIGO_INTERNO]) != null ? campos[CODIGO_INTERNO] : null) : null);
//          contratoInsumoDto.setValorInsumo(!Util.vacio(campos[VALOR]) ? (Util.isNumber(campos[VALOR].replace(",", ".")) ? Double.parseDouble(campos[VALOR].replace(",", ".")) : -1) : -1);
//          boolean flag = true;
//
//          String errorLinea = "Línea #" + j + ": (" + linea + ") - ";
//          if (insumoDto.getCodigoInterno() == null) {
//            errorLinea = errorLinea + "(ERROR => Código Insumo): -Texto- Campo Obligatorio vacío o el código digitado no existe. ";
//            flag = false;
//          }
//          else {
//            if (!codigosInternos.contains(insumoDto.getCodigoInterno())) {
//              contratoInsumoDto.setConsecutivoInsumo(mapaInsumosXCod.get(insumoDto.getCodigoInterno()).getInsumo());
//              codigosInternos.add(insumoDto.getCodigoInterno());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Código Insumo): -Texto- Ya existe el código en otra línea del archivo para importar. ";
//              flag = false;
//            }
//          }
//          if (contratoInsumoDto.getValorInsumo() < 0) {
//            errorLinea = errorLinea + "(ERROR => Valor Insumo): -Numérico- Debe ser mayor a cero o no es número. ";
//            flag = false;
//          }
//
//          if (!flag) {
//            listaErroresContenido.add(errorLinea);
//          }
//          else {
//            conInsumosImportar.add(contratoInsumoDto);
//          }
//
//          j++;
//        }
//
//        if (listaErroresContenido.isEmpty()) {
//          boolean correcto = mantenimientoService.saveOrUpdateMasivoContratoInsumo(conInsumosImportar);
//          if (correcto) {
//            return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//          }
//          else {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//          }
//        }
//        else {
//          ArrayList<String> errores = new ArrayList<String>();
//          errores.addAll(listaErroresEstructura);
//          errores.addAll(listaErroresContenido);
//          filePOJO.setErrores(errores);
//          filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//          filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//          String jsonInString = mapper.writeValueAsString(filePOJO);
//
//          return Response.ok(jsonInString).build();
//        }
//      }
//      else {
//        ArrayList<String> errores = new ArrayList<String>();
//        errores.addAll(listaErroresEstructura);
//        errores.addAll(listaErroresContenido);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/uploadImportContratoMedicamentosMasivo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response uploadImportContratoMedicamentosMasivo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOFileUpload filePOJO = mapper.readValue(Json, POJOFileUpload.class);
//
//      // byte[] name = Base64.getEncoder().encode("hello World".getBytes());
//      // byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
//
//      InputStream stream = new ByteArrayInputStream(filePOJO.getContentDecodeB64().getBytes(StandardCharsets.UTF_8));
//      FastTable<String> lista = FileUtilities.toListFileStringPipe(stream);
//      lista.remove(0);
//
//      int LONGITUD_REF = 2;
//      FastTable<String> listaErroresEstructura = new FastTable<String>();
//      FastTable<String> listaErroresContenido = new FastTable<String>();
//
//      // validando que no venga vacío el archivo
//      if (lista.isEmpty()) {
//        ArrayList<String> errores = new ArrayList<String>();
//        String error = "El archivo se encuentra vacío o su contenido no es suficiente para la importación. Por favor Revise el fichero.";
//        errores.add(error);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//
//      // Formateando acentos
//      for (String linea : lista) {
//        linea = linea.replace("á", "&aacute");
//        linea = linea.replace("é", "&eacute");
//        linea = linea.replace("í", "&iacute");
//        linea = linea.replace("ó", "&oacute");
//        linea = linea.replace("ú", "&uacute");
//        linea = linea.replace("ñ", "&ntilde");
//      }
//
//      // Validando Estructura
//      int i = 1;
//      for (String linea : lista) {
//        int longitud = linea.split("\\|").length;
//        if (longitud != LONGITUD_REF) {
//          listaErroresEstructura.add("Línea #" + i + ": (" + linea + ") - ERROR => No cumple con la estructura - Cant. Permitida: " + LONGITUD_REF);
//        }
//
//        i++;
//      }
//
//      // Validando Contenido
//      if (listaErroresEstructura.isEmpty()) {
//        int j = 1;
//
//        final int LLAVE_MEDICAMENTO = 0;
//        final int VALOR = 1;
//
//        FastTable<CtContratoMedicamentoDto> conMedicamentosImportar = new FastTable<CtContratoMedicamentoDto>();
//        FastTable<TbMedicamentoDto> listaMedicamentos = mantenimientoService.getListaMedicamentos(new TbMedicamentoDto());
//        FastMap<Long, TbMedicamentoDto> mapaMedicamentosXKey = new FastMap<Long, TbMedicamentoDto>();
//        for (TbMedicamentoDto med : listaMedicamentos) {
//          if (!mapaMedicamentosXKey.containsKey(med.getConsecutivoMedicamento())) {
//            mapaMedicamentosXKey.put(med.getConsecutivoMedicamento(), med);
//          }
//        }
//        FastSet<Long> keysMedicamentos = new FastSet<Long>();
//
//        for (String linea : lista) {
//          CtContratoMedicamentoDto contratoMedicamentoDto = new CtContratoMedicamentoDto();
//          TbMedicamentoDto medicamentoDto = new TbMedicamentoDto();
//          String[] campos = linea.split("\\|");
//          // Estructura: Código Interno|Valor (valor decimal separado por punto '.'
//          // CINS10|100.20
//
//          contratoMedicamentoDto.setConsecutivoContrato(filePOJO.getConsecutivoContrato());
//          contratoMedicamentoDto.setUsuarioGrabado(filePOJO.getUsuario());
//          medicamentoDto.setConsecutivoMedicamento(!Util.vacio(campos[LLAVE_MEDICAMENTO]) ? (Util.isNumber(campos[LLAVE_MEDICAMENTO]) ? Long.parseLong(campos[LLAVE_MEDICAMENTO]) : -1) : -1);
//          contratoMedicamentoDto.setValorMedicamento(!Util.vacio(campos[VALOR]) ? (Util.isNumber(campos[VALOR].replace(",", ".")) ? Double.parseDouble(campos[VALOR].replace(",", ".")) : -1) : -1);
//          boolean flag = true;
//
//          String errorLinea = "Línea #" + j + ": (" + linea + ") - ";
//          if (medicamentoDto.getConsecutivoMedicamento() < 0) {
//            errorLinea = errorLinea + "(ERROR => Código Medicamento): -Numérico- Campo Obligatorio vacío o el código digitado no existe. ";
//            flag = false;
//          }
//          else {
//            if (!keysMedicamentos.contains(medicamentoDto.getConsecutivoMedicamento())) {
//              contratoMedicamentoDto.setConsecutivoMedicamento(mapaMedicamentosXKey.get(medicamentoDto.getConsecutivoMedicamento()).getConsecutivoMedicamento());
//              keysMedicamentos.add(medicamentoDto.getConsecutivoMedicamento());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Código Medicamento): -Numérico- Ya existe el código en otra línea del archivo para importar. ";
//              flag = false;
//            }
//          }
//          if (contratoMedicamentoDto.getValorMedicamento() < 0) {
//            errorLinea = errorLinea + "(ERROR => Valor Medicamento): -Numérico- Debe ser mayor a cero o no es número. ";
//            flag = false;
//          }
//
//          if (!flag) {
//            listaErroresContenido.add(errorLinea);
//          }
//          else {
//            conMedicamentosImportar.add(contratoMedicamentoDto);
//          }
//
//          j++;
//        }
//
//        if (listaErroresContenido.isEmpty()) {
//          boolean correcto = mantenimientoService.saveOrUpdateMasivoContratoMedicamento(conMedicamentosImportar);
//          if (correcto) {
//            return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//          }
//          else {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//          }
//        }
//        else {
//          ArrayList<String> errores = new ArrayList<String>();
//          errores.addAll(listaErroresEstructura);
//          errores.addAll(listaErroresContenido);
//          filePOJO.setErrores(errores);
//          filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//          filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//          String jsonInString = mapper.writeValueAsString(filePOJO);
//
//          return Response.ok(jsonInString).build();
//        }
//      }
//      else {
//        ArrayList<String> errores = new ArrayList<String>();
//        errores.addAll(listaErroresEstructura);
//        errores.addAll(listaErroresContenido);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/updateValueContratoInsumo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response updateValueContratoInsumo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = ctContrato
//    try {
//      String path = "updateValueContratoInsumo";
//      ObjectMapper mapper = new ObjectMapper();
//      CtContratoInsumoDto dto = new CtContratoInsumoDto();
//      POJOCtContratoInsumo pojo = mapper.readValue(Json, POJOCtContratoInsumo.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      String textoValidaciones = this.validaciones(path, (Object) dto);
//      if (!Util.vacio(textoValidaciones)) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//      }
//
//      boolean correcto = mantenimientoService.updateValueContratoInsumo(dto);
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/updateValueContratoMedicamento")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response updateValueContratoMedicamento(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = ctContrato
//    try {
//      String path = "updateValueContratoMedicamento";
//      ObjectMapper mapper = new ObjectMapper();
//      CtContratoMedicamentoDto dto = new CtContratoMedicamentoDto();
//      POJOCtContratoMedicamento pojo = mapper.readValue(Json, POJOCtContratoMedicamento.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      String textoValidaciones = this.validaciones(path, (Object) dto);
//      if (!Util.vacio(textoValidaciones)) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//      }
//
//      boolean correcto = mantenimientoService.updateValueContratoMedicamento(dto);
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getContratoActividadesXServicio")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getContratoActividadesXServicio(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//
//      POJOCtContratoActividad objPOJO = mapper.readValue(Json, POJOCtContratoActividad.class);
//      POJOTbServicio servicioPOJO = mapper.readValue(Json, POJOTbServicio.class);
//      TbServicioDto servicioFiltro = new TbServicioDto();
//      servicioFiltro.setCodigoInterno(servicioPOJO.getCodigoInterno());
//      servicioFiltro.setNombre(servicioPOJO.getNombre());
//      FastTable<TbServicioDto> listaServicios = mantenimientoService.getListaServicios(servicioFiltro);
//
//      // Consultamos los CUPS y armamos un mapa de ellos
//      FastTable<TbCupDto> listaCups = mantenimientoService.getListaCups(new TbCupDto());
//      FastMap<Long, TbCupDto> mapaCups = new FastMap<Long, TbCupDto>();
//      for (TbCupDto cup : listaCups) {
//        if (!mapaCups.containsKey(cup.getCup())) {
//          mapaCups.put(cup.getCup(), cup);
//        }
//      }
//
//      // Consultamos las actividades con sus cups y contratosXactividad
//      FastTable<TbServicioDto> list = mantenimientoService.getListaContratoServiciosXActividad(objPOJO.getConsecutivoContrato(), listaServicios, listaCups);
//
//      // Mapa Soat
//      FastTable<TbSoatDto> listaSoat = mantenimientoService.getListaSoat(new TbSoatDto());
//      FastMap<Long, TbSoatDto> mapaSoat = new FastMap<Long, TbSoatDto>();
//      for (TbSoatDto soat : listaSoat) {
//        if (!mapaSoat.containsKey(soat.getSoat())) {
//          mapaSoat.put(soat.getSoat(), soat);
//        }
//      }
//      // Mapa Iss
//      FastTable<TbIssDto> listaIss = mantenimientoService.getListaIss(new TbIssDto());
//      FastMap<Long, TbIssDto> mapaIss = new FastMap<Long, TbIssDto>();
//      for (TbIssDto iss : listaIss) {
//        if (!mapaIss.containsKey(iss.getIss())) {
//          mapaIss.put(iss.getIss(), iss);
//        }
//      }
//
//      List<POJOTbServicio> objListPOJO = new ArrayList<POJOTbServicio>();
//      FastTable<TbCupDto> listCupTemp = new FastTable<TbCupDto>();
//      for (TbServicioDto dto : list) {
//        List<POJOTbCup> objListCupPOJO = new ArrayList<POJOTbCup>();
//        FastTable<CtContratoActividadDto> listaDeTemp = new FastTable<CtContratoActividadDto>();
//        for (TbCupDto cupDto : dto.getListaCups()) {
//          listaDeTemp.addAll(cupDto.getIteradorContratoActividades());
//          POJOTbCup pojoCup = new POJOTbCup();
//          // limpiar la lista antes de pasar al POJO
//          cupDto.getIteradorContratoActividades().clear();
//          BeanUtils.copyProperties(cupDto, pojoCup);
//
//          // pasar los detalles
//          for (CtContratoActividadDto detalle : listaDeTemp) {
//            POJOCtContratoActividad pojoDetalle = new POJOCtContratoActividad();
//            BeanUtils.copyProperties(detalle, pojoDetalle);
//            pojoDetalle.setNombreCup(mapaCups.get(pojoDetalle.getConsecutivoCup()).getDescripcion());
//            pojoDetalle.setCodigoCup(mapaCups.get(pojoDetalle.getConsecutivoCup()).getCodigoInterno());
//            if (pojoDetalle.getConsecutivoIss() != null) {
//              pojoDetalle.setNombreTarifa(mapaIss.get(pojoDetalle.getConsecutivoIss()).getDescripcion());
//              pojoDetalle.setCodigoTarifa(mapaIss.get(pojoDetalle.getConsecutivoIss()).getCodigo());
//            }
//            else if (pojoDetalle.getConsecutivoSoat() != null) {
//              pojoDetalle.setNombreTarifa(mapaSoat.get(pojoDetalle.getConsecutivoSoat()).getDescripcion());
//              pojoDetalle.setCodigoTarifa(mapaSoat.get(pojoDetalle.getConsecutivoSoat()).getCodigo());
//            }
//            pojoCup.getIteradorContratoActividades().add(pojoDetalle);
//          }
//
//          objListCupPOJO.add(pojoCup);
//          listaDeTemp.clear();
//        }
//
//        POJOTbServicio pojo = new POJOTbServicio();
//        // limpiar la lista antes de pasar al POJO
//        dto.getListaCups().clear();
//        BeanUtils.copyProperties(dto, pojo);
//
//        pojo.setListaCups(new FastTable<POJOTbCup>());
//        pojo.getListaCups().addAll(objListCupPOJO);
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        objListPOJO.add(pojo);
//        listCupTemp.clear();
//      }
//
//      String jsonInString = mapper.writeValueAsString(objListPOJO);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/uploadImportContratoActividadesXServicioMasivo")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response uploadImportContratoActividadesXServicioMasivo(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOFileUpload filePOJO = mapper.readValue(Json, POJOFileUpload.class);
//
//      // byte[] name = Base64.getEncoder().encode("hello World".getBytes());
//      // byte[] decodedString = Base64.getDecoder().decode(new String(name).getBytes("UTF-8"));
//
//      InputStream stream = new ByteArrayInputStream(filePOJO.getContentDecodeB64().getBytes(StandardCharsets.UTF_8));
//      FastTable<String> lista = FileUtilities.toListFileStringPipe(stream);
//      lista.remove(0);
//
//      int LONGITUD_REF = 2;
//      FastTable<String> listaErroresEstructura = new FastTable<String>();
//      FastTable<String> listaErroresContenido = new FastTable<String>();
//
//      // validando que no venga vacío el archivo
//      if (lista.isEmpty()) {
//        ArrayList<String> errores = new ArrayList<String>();
//        String error = "El archivo se encuentra vacío o su contenido no es suficiente para la importación. Por favor Revise el fichero.";
//        errores.add(error);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//
//      // Validando Estructura
//      int i = 1;
//      for (String linea : lista) {
//        int longitud = linea.split("\\|").length;
//        if (longitud != LONGITUD_REF) {
//          listaErroresEstructura.add("Línea #" + i + ": (" + linea + ") - ERROR => No cumple con la estructura - Cant. Permitida: " + LONGITUD_REF);
//        }
//
//        i++;
//      }
//
//      // Validando Contenido
//      if (listaErroresEstructura.isEmpty()) {
//        int j = 1;
//
//        final int CODIGO_INTERNO = 0;
//        final int VALOR = 1;
//
//        FastTable<CtContratoHabilitadoCupDto> conCupImportar = new FastTable<CtContratoHabilitadoCupDto>();
//        FastTable<TbCupDto> listaCups = mantenimientoService.getListaCups(new TbCupDto());
//        FastMap<String, TbCupDto> mapaCupsXCod = new FastMap<String, TbCupDto>();
//        for (TbCupDto cup : listaCups) {
//          if (!mapaCupsXCod.containsKey(cup.getCodigoInterno())) {
//            mapaCupsXCod.put(cup.getCodigoInterno(), cup);
//          }
//        }
//        FastSet<String> codigosInternos = new FastSet<String>();
//
//        for (String linea : lista) {
//          CtContratoHabilitadoCupDto contratoCupDto = new CtContratoHabilitadoCupDto();
//          TbCupDto cupDto = new TbCupDto();
//          String[] campos = linea.split("\\|");
//          // Estructura: Código Interno|Valor (valor decimal separado por punto '.'
//          // CINS10|100.20
//
//          contratoCupDto.setConsecutivoContrato(filePOJO.getConsecutivoContrato());
//          contratoCupDto.setUsuarioGrabado(filePOJO.getUsuario());
//          cupDto.setCodigoInterno(!Util.vacio(campos[CODIGO_INTERNO]) ? (mapaCupsXCod.get(campos[CODIGO_INTERNO]) != null ? campos[CODIGO_INTERNO] : null) : null);
//          contratoCupDto.setValor(!Util.vacio(campos[VALOR]) ? (Util.isNumber(campos[VALOR].replace(",", ".")) ? Double.parseDouble(campos[VALOR].replace(",", ".")) : -1) : -1);
//          boolean flag = true;
//
//          String errorLinea = "Línea #" + j + ": (" + linea + ") - ";
//          if (cupDto.getCodigoInterno() == null) {
//            errorLinea = errorLinea + "(ERROR => Código Cup): -Texto- Campo Obligatorio vacío o el código digitado no existe. ";
//            flag = false;
//          }
//          else {
//            if (!codigosInternos.contains(cupDto.getCodigoInterno())) {
//              contratoCupDto.setConsecutivoCup(mapaCupsXCod.get(cupDto.getCodigoInterno()).getCup());
//              codigosInternos.add(cupDto.getCodigoInterno());
//            }
//            else {
//              errorLinea = errorLinea + "(ERROR => Código Cup): -Texto- Ya existe el código en otra línea del archivo para importar. ";
//              flag = false;
//            }
//          }
//          if (contratoCupDto.getValor() < 0) {
//            errorLinea = errorLinea + "(ERROR => Valor Cup): -Numérico- Debe ser mayor a cero o no es número. ";
//            flag = false;
//          }
//
//          if (!flag) {
//            listaErroresContenido.add(errorLinea);
//          }
//          else {
//            conCupImportar.add(contratoCupDto);
//          }
//
//          j++;
//        }
//
//        if (listaErroresContenido.isEmpty()) {
//          // Mapa Contratos
//          FastTable<CtContratoDto> listaContratos = mantenimientoService.getListaContratos(new CtContratoDto());
//          FastMap<Long, CtContratoDto> mapaContratos = new FastMap<Long, CtContratoDto>();
//          for (CtContratoDto contrato : listaContratos) {
//            if (!mapaContratos.containsKey(contrato.getConsecutivoContrato())) {
//              mapaContratos.put(contrato.getConsecutivoContrato(), contrato);
//            }
//          }
//          // Mapa Soat X Cup
//          FastTable<TbSoatDto> listaSoat = mantenimientoService.getListaSoat(new TbSoatDto());
//          FastMap<Long, FastTable<TbSoatDto>> mapaSoatXCup = new FastMap<Long, FastTable<TbSoatDto>>();
//          FastTable<TbSoatDto> temporalSOAT = new FastTable<TbSoatDto>();
//          for (TbSoatDto soat : listaSoat) {
//            if (mapaSoatXCup.isEmpty()) {
//              temporalSOAT.add(soat);
//              mapaSoatXCup.put(soat.getCup(), temporalSOAT);
//            }
//            else {
//              if (mapaSoatXCup.containsKey(soat.getCup())) {
//                mapaSoatXCup.get(soat.getCup()).add(soat);
//              }
//              else {
//                temporalSOAT = new FastTable<TbSoatDto>();
//                temporalSOAT.add(soat);
//                mapaSoatXCup.put(soat.getCup(), temporalSOAT);
//              }
//            }
//          }
//          // Mapa Iss X Cup
//          FastTable<TbIssDto> listaIss = mantenimientoService.getListaIss(new TbIssDto());
//          FastMap<Long, FastTable<TbIssDto>> mapaIssXCup = new FastMap<Long, FastTable<TbIssDto>>();
//          FastTable<TbIssDto> temporalISS = new FastTable<TbIssDto>();
//          for (TbIssDto iss : listaIss) {
//            if (mapaIssXCup.isEmpty()) {
//              temporalISS.add(iss);
//              mapaIssXCup.put(iss.getCup(), temporalISS);
//            }
//            else {
//              if (mapaIssXCup.containsKey(iss.getCup())) {
//                mapaIssXCup.get(iss.getCup()).add(iss);
//              }
//              else {
//                temporalISS = new FastTable<TbIssDto>();
//                temporalISS.add(iss);
//                mapaIssXCup.put(iss.getCup(), temporalISS);
//              }
//            }
//          }
//
//          // Acoplando servicios
//          // TODO CONTROLAR EXCEPCION SI LISTA ES VACIA
//          FastTable<TbServicioCupDto> listaServiciosXCup = mantenimientoService.getListaServiciosXCup(new TbServicioCupDto());
//          FastMap<Long, FastSet<Long>> mapaCupXListaServicios = new FastMap<Long, FastSet<Long>>();
//          FastSet<Long> keysServicios = new FastSet<Long>();
//          for (TbServicioCupDto cXs : listaServiciosXCup) {
//            if (mapaCupXListaServicios.isEmpty()) {
//              keysServicios.add(cXs.getConsecutivoServicio());
//              mapaCupXListaServicios.put(cXs.getConsecutivoCup(), keysServicios);
//            }
//            else {
//              if (mapaCupXListaServicios.containsKey(cXs.getConsecutivoCup())) {
//                mapaCupXListaServicios.get(cXs.getConsecutivoCup()).add(cXs.getConsecutivoServicio());
//              }
//              else {
//                keysServicios = new FastSet<Long>();
//                keysServicios.add(cXs.getConsecutivoServicio());
//                mapaCupXListaServicios.put(cXs.getConsecutivoCup(), keysServicios);
//              }
//            }
//          }
//
//          FastTable<CtContratoHabilitadoCupDto> newConCupImportar = new FastTable<CtContratoHabilitadoCupDto>();
//          for (CtContratoHabilitadoCupDto habilitadoCup : conCupImportar) {
//            FastSet<Long> tempServicios = mapaCupXListaServicios.get(habilitadoCup.getConsecutivoCup());
//            for (long serv : tempServicios) {
//              CtContratoHabilitadoCupDto habCup = new CtContratoHabilitadoCupDto();
//              BeanUtils.copyProperties(habilitadoCup, habCup);
//              habCup.setConsecutivoServicio(serv);
//              newConCupImportar.add(habCup);
//            }
//          }
//
//          // TODO CONTROLAR EXCEPCION SI LISTAS DE TARIFAS SON VACIAS
//          FastTable<CtContratoActividadDto> conActividadImportar = new FastTable<CtContratoActividadDto>();
//          for (CtContratoHabilitadoCupDto habilitadoCup : newConCupImportar) {
//            CtContratoDto contDto = mapaContratos.get(habilitadoCup.getConsecutivoContrato());
//            short tipoTarifa = contDto.getTarifaContrato();
//            if (ETarifaContrato.SOAT.getId() == tipoTarifa) {
//              FastTable<TbSoatDto> listaSoatValores = mapaSoatXCup.get(habilitadoCup.getConsecutivoCup());
//              for (TbSoatDto soatValor : listaSoatValores) {
//                CtContratoActividadDto actividad = new CtContratoActividadDto();
//                actividad.setConsecutivoContrato(habilitadoCup.getConsecutivoContrato());
//                actividad.setConsecutivoServicio(habilitadoCup.getConsecutivoServicio());
//                actividad.setConsecutivoCup(habilitadoCup.getConsecutivoCup());
//                actividad.setConsecutivoSoat(soatValor.getSoat());
//                if (habilitadoCup.getValor() > 0) {
//                  actividad.setValorTarifa(habilitadoCup.getValor());
//                  actividad.setSwTarifa(ESiNo.SI.getId());
//                }
//                else {
//                  double valor = 0;
//                  for (TbSoatValorDto valorSS : soatValor.getValoresSoat()) {
//                    Date fechaInicioContrato = mapaContratos.get(habilitadoCup.getConsecutivoContrato()).getFechaInicio();
//                    Calendar cal = Calendar.getInstance();
//                    cal.setTime(fechaInicioContrato);
//                    if (valorSS.getAno() == cal.get(Calendar.YEAR)) {
//                      valor = valorSS.getValorPesos();
//                      break;
//                    }
//                  }
//                  actividad.setValorTarifa(valor);
//                  actividad.setSwTarifa(ESiNo.NO.getId());
//                }
//                double valor = 0;
//                for (TbSoatValorDto valorSS : soatValor.getValoresSoat()) {
//                  Date fechaInicioContrato = mapaContratos.get(habilitadoCup.getConsecutivoContrato()).getFechaInicio();
//                  Calendar cal = Calendar.getInstance();
//                  cal.setTime(fechaInicioContrato);
//                  if (valorSS.getAno() == cal.get(Calendar.YEAR)) {
//                    valor = valorSS.getValorPesos();
//                    break;
//                  }
//                }
//                actividad.setValorActividad(valor);
//                actividad.setValorPactado(actividad.getValorTarifa());
//                actividad.setUsuarioGrabado(habilitadoCup.getUsuarioGrabado());
//                conActividadImportar.add(actividad);
//              }
//            }
//            else {
//              FastTable<TbIssDto> listaIssValores = mapaIssXCup.get(habilitadoCup.getConsecutivoCup());
//              for (TbIssDto issValor : listaIssValores) {
//                CtContratoActividadDto actividad = new CtContratoActividadDto();
//                actividad.setConsecutivoContrato(habilitadoCup.getConsecutivoContrato());
//                actividad.setConsecutivoServicio(habilitadoCup.getConsecutivoServicio());
//                actividad.setConsecutivoCup(habilitadoCup.getConsecutivoCup());
//                actividad.setConsecutivoIss(issValor.getIss());
//                if (habilitadoCup.getValor() > 0) {
//                  actividad.setValorTarifa(habilitadoCup.getValor());
//                  actividad.setSwTarifa(ESiNo.SI.getId());
//                }
//                else {
//                  double valor = 0;
//                  if (issValor.getTipoValor() == EtipoValor.PESOS.getId()) {
//                    valor = issValor.getValorPesos();
//                  }
//                  else {
//                    valor = issValor.getValorUvr();
//                  }
//                  actividad.setValorTarifa(valor);
//                  actividad.setSwTarifa(ESiNo.NO.getId());
//                }
//                double valor = 0;
//                if (issValor.getTipoValor() == EtipoValor.PESOS.getId()) {
//                  valor = issValor.getValorPesos();
//                }
//                else {
//                  valor = issValor.getValorUvr();
//                }
//                actividad.setValorActividad(valor);
//                actividad.setValorPactado(actividad.getValorTarifa());
//                actividad.setUsuarioGrabado(habilitadoCup.getUsuarioGrabado());
//                conActividadImportar.add(actividad);
//              }
//            }
//          }
//
//          boolean correcto = mantenimientoService.saveOrUpdateMasivoContratoActividadesXServicio(newConCupImportar, conActividadImportar);
//          if (correcto) {
//            return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//          }
//          else {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//          }
//        }
//        else {
//          ArrayList<String> errores = new ArrayList<String>();
//          errores.addAll(listaErroresEstructura);
//          errores.addAll(listaErroresContenido);
//          filePOJO.setErrores(errores);
//          filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId());
//          filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO.getId()));
//
//          String jsonInString = mapper.writeValueAsString(filePOJO);
//
//          return Response.ok(jsonInString).build();
//        }
//      }
//      else {
//        ArrayList<String> errores = new ArrayList<String>();
//        errores.addAll(listaErroresEstructura);
//        errores.addAll(listaErroresContenido);
//        filePOJO.setErrores(errores);
//        filePOJO.setStatusId(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId());
//        filePOJO.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePOJO);
//
//        return Response.ok(jsonInString).build();
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/updateValueContratoActividadesXServicio")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response updateValueContratoActividadesXServicio(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = ctContrato
//    try {
//      String path = "updateValueContratoActividadesXServicio";
//      ObjectMapper mapper = new ObjectMapper();
//      CtContratoInsumoDto dto = new CtContratoInsumoDto();
//      POJOCtContratoInsumo pojo = mapper.readValue(Json, POJOCtContratoInsumo.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      String textoValidaciones = this.validaciones(path, (Object) dto);
//      if (!Util.vacio(textoValidaciones)) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//      }
//
//      // boolean correcto = mantenimientoService.updateValueContratoActividadesXServicio(dto);
//      // if (correcto) {
//      return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      // }
//      // else {
//      // return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      // }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/consultaMedicamentosXBarra")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response consultaMedicamentosXBarra(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      String cadena = Json.toString();
//      String[] str = cadena.split("-");
//      TbMedicamentoDto dto = new TbMedicamentoDto();
//      dto.setCodigoBarra(str[0]);
//      String numeroContrato = str.length < 2 ? "" : str[1];
//
//      POJOTbMedicamento pojo = null;
//
//      if (Util.vacio(numeroContrato)) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + Mensaje.getMensaje("error_autorizacion_sin_consulta") + "</div>");
//      }
//      else {
//        FastTable<TbMedicamentoDto> respuesta = mantenimientoService.getListaMedicamentos(dto);
//        if (!respuesta.isEmpty()) {
//          FastTable<CtContratoMedicamentoDto> resultado = mantenimientoService.getListaMedicamentosAutorizados(numeroContrato, respuesta);
//
//          if (!resultado.isEmpty()) {
//            for (CtContratoMedicamentoDto cm : resultado) {
//              pojo = new POJOTbMedicamento();
//              TbMedicamentoDto medicamento = cm.getTbMedicamento();
//              pojo.setConsecutivoMedicamento(medicamento.getConsecutivoMedicamento());
//              pojo.setExpediente(medicamento.getExpediente());
//              pojo.setCodigoBarra(medicamento.getCodigoBarra());
//              pojo.setNombreCadena(medicamento.getNombreCadena());
//              pojo.setCantidad(ESiNo.SI.getId());
//            }
//          }
//        }
//      }
//
//      String response = mapper.writeValueAsString(pojo);
//
//      return Response.ok(response).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateAutorizacion")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateAutorizacion(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateAutorizacion";
//      FastMap<Long, Integer> mapaCantidad = new FastMap<Long, Integer>();
//      FastMap<Long, Integer> mapaCantidadEntregar = new FastMap<Long, Integer>();
//      FastMap<String, Integer> mapa = new FastMap<String, Integer>();
//      ObjectMapper mapper = new ObjectMapper();
//      InformacionAutorizacionDto autorizacionDto = new InformacionAutorizacionDto();
//      POJOInformacionAutorizacion autorizacionPojo = mapper.readValue(Json, POJOInformacionAutorizacion.class);
//      Long consecutivoIps = Long.parseLong(autorizacionPojo.getIpsSesion());
//      boolean correcto = true;
//
//      boolean flagSoporte = true;
//      FastTable<POJOTbProcesoDetalle> listaSoportes = new FastTable<POJOTbProcesoDetalle>();
//
//      if (autorizacionPojo.getSoportesEntrega() != null && !autorizacionPojo.getSoportesEntrega().isEmpty()) {
//        for (POJOTbProcesoDetalle aut : autorizacionPojo.getSoportesEntrega()) {
//          if (Util.vacio(aut.getNombreSoporte()) && aut.getSwObligatorio() == ESiNo.SI.getId()) {
//            flagSoporte = false;
//            break;
//          }
//        }
//      }
//      if (!flagSoporte) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_SOPORTES_OBLIGATORIOS_FALTANTES.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()));
//      }
//      else {
//        listaSoportes.addAll(autorizacionPojo.getSoportesEntrega());
//      }
//
//      POJOUsuario usuarioPojo = autorizacionPojo.getUsuarioSesion();
//
//      autorizacionDto.setAfiliado(new InformacionAutorizacionAfiliadoDto());
//      BeanUtils.copyProperties(autorizacionPojo, autorizacionDto);
//      BeanUtils.copyProperties(autorizacionPojo.getAfiliado(), autorizacionDto.getAfiliado());
//      POJOInformacionAutorizacionAfiliado afiliadoPojo = null;
//
//      String textoValidaciones = this.validaciones(path, (Object) autorizacionDto);
//      if (!Util.vacio(textoValidaciones)) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//      }
//
//      // se consulta la autorización y sus detalles
//      EntAutorizacionEncabezadoDto autorizacionIps = mantenimientoService.getAutorizacionIps(autorizacionDto.getNumeroAutorizacion(), consecutivoIps);
//      // se consulta el web service de autorización
//      InformacionAutorizacionDto autorizacionWs = informacionAutorizacionWSService.getAutorizacion(autorizacionDto.getNumeroAutorizacion(), "");
//
//      // mapa de cantidades actualizadas leidas del ws
//      for (AutorizacionItemDto item : autorizacionWs.getMedicamentos()) {
//        mapa.put(item.getCodigo(), Integer.parseInt(item.getCantidad()));
//      }
//
//      boolean valido = false;
//      if (autorizacionWs != null) {
//
//        valido = this.validarEdadPaciente(autorizacionWs.getAfiliado() == null ? "" : autorizacionWs.getAfiliado().getFechaNacimiento());
//
//        if (autorizacionPojo.getObjDatosEntrega() != null) {
//          afiliadoPojo = new POJOInformacionAutorizacionAfiliado();
//          afiliadoPojo = autorizacionPojo.getObjDatosEntrega();
//        }
//
//        else if (valido) {
//          // mostrar modal para ingresar datos de persona recibe
//          autorizacionPojo.setMostrarModal(true);
//          String response = mapper.writeValueAsString(autorizacionPojo);
//          return Response.ok(response).build();
//        }
//      }
//
//      POJOAutorizacionItem[] medicamentosXAtc = autorizacionPojo.getMedicamentos();
//      FastMap<Long, LogMedicamentoDto> mapaLogMedicamento = mantenimientoService.getMapaLogMedicamento(consecutivoIps);
//
//      if (autorizacionIps == null) {
//        // no existe la autorización para la ips en sesion
//        if (!correcto) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId()));
//        }
//
//        autorizacionIps = new EntAutorizacionEncabezadoDto();
//
//        // sincronizar las cantidades del ws con las que vienen del formulario
//        int cantidadTotal = 0;
//        boolean total = true;
//        int sumatoria = 0;
//        for (POJOAutorizacionItem item : medicamentosXAtc) {
//          // se sincronizan las cantidades con el web service
//          if (!Util.vacio(item.getCantidad())) {
//            cantidadTotal = Integer.parseInt(item.getCantidad());
//            Integer c = mapa.get(item.getCodigo());
//            if (c != null) {
//              item.setCantidad(c + "");
//            }
//          }
//
//          // se verifica que la cantidad a entregar no sea superior
//          if (Util.vacio(item.getCantidad())) {
//            sumatoria += item.getDespacho();
//
//            int cantidadEntrega = cantidadTotal - item.getDespacho();
//
//            if (cantidadEntrega == ESiNo.NO.getId()) {
//              continue;
//            }
//
//            if (item.getDespacho() > cantidadTotal) {
//              return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId()));
//            }
//
//            if (item.getDespacho() > 0) {
//              if (cantidadTotal == cantidadEntrega) {
//                continue;
//              }
//              else {
//                total = false;
//              }
//            }
//
//            // se verifica la cantidad disponible en el log
//            if (item.getDespacho() > item.getLogCantidadReal()) { // LogCantidadReal
//              return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId()));
//            }
//
//            if (sumatoria > cantidadTotal) {
//              return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId()));
//            }
//          }
//        }
//
//        // se llena la autorización a enviar
//        CtContratoDto contratoDto = mantenimientoService.getCtContratoXNumeroContrato(autorizacionDto.getContrato());
//        autorizacionIps.setTipoIdentificacion(autorizacionDto.getAfiliado().getTipoIdentificacion());
//        autorizacionIps.setNumeroIdentificacion(autorizacionDto.getAfiliado().getNumeroIdentificacion());
//        autorizacionIps.setPrimerNombre(autorizacionDto.getAfiliado().getPrimerNombre());
//        autorizacionIps.setSegundoNombre(autorizacionDto.getAfiliado().getSegundoNombre());
//        autorizacionIps.setPrimerApellido(autorizacionDto.getAfiliado().getPrimerApellido());
//        autorizacionIps.setSegundoApellido(autorizacionDto.getAfiliado().getSegundoApellido());
//        autorizacionIps.setConsecutivoContrato(contratoDto.getConsecutivoContrato());
//        autorizacionIps.setNumeroAutorizacion(autorizacionDto.getNumeroAutorizacion());
//        autorizacionIps.setTipoAutorizacion(autorizacionDto.getTipoAutorizacion() == null ? 0 : Short.parseShort(autorizacionDto.getTipoAutorizacion()));
//        autorizacionIps.setFechaAutorizacion(Util.getFechaReal(autorizacionWs.getFechaAutorizacion().replace("/", "")));
//        autorizacionIps.setValorCuotaModeradora(Double.parseDouble(autorizacionWs.getValorCuotaModeradora()));
//        autorizacionIps.setValorCopago(Double.parseDouble(autorizacionWs.getValorCopago()));
//        autorizacionIps.setFechaNacimiento(Util.getFechaReal(autorizacionDto.getAfiliado().getFechaNacimiento().replace("/", "")));
//        autorizacionIps.setMunicipio(autorizacionDto.getAfiliado().getMunicipio());
//        autorizacionIps.setTipoRegimen(autorizacionDto.getAfiliado().getRegimen());
//        autorizacionIps.setTipoAfiliado(autorizacionDto.getAfiliado().getTipoAfiliado());
//        autorizacionIps.setCategoria(autorizacionWs.getAfiliado().getCategoria());
//        autorizacionIps.setEstadoEntrega(total == false ? (short) 2 : (short) 1);
//        autorizacionIps.setSwPos(autorizacionDto.getSwPos() == null ? 0 : Short.parseShort(autorizacionDto.getSwPos()));
//        autorizacionIps.setConsecutivoIps(consecutivoIps);
//
//        // se llenan los detalles a enviar
//        autorizacionIps.setDetalles(new FastTable<EntAutorizacionDetalleDto>());
//        for (POJOAutorizacionItem item : medicamentosXAtc) {
//          EntAutorizacionDetalleDto detalle = new EntAutorizacionDetalleDto();
//          if (mapaCantidad.isEmpty()) {
//            mapaCantidad.put(item.getConsecutivoMedicamento(), Integer.parseInt(item.getCantidad()));
//          }
//          else {
//            if (mapaCantidad.get(item.getConsecutivoMedicamento() == null ? 0 : item.getConsecutivoMedicamento()) == null) {
//              mapaCantidad.put(item.getConsecutivoMedicamento() == null ? 0 : item.getConsecutivoMedicamento(), Integer.parseInt(item.getCantidad()));
//            }
//          }
//
//          if (Util.vacio(item.getCantidad())) {
//            int cant = mapaCantidad.get(item.getConsecutivoMedicamento());
//            detalle.setCantidad(cant);
//            detalle.setCodigo(item.getCodigo());
//            detalle.setCodigoExtra(item.getCodigoExtra());
//            detalle.setCantidadEntrega(item.getDespacho());
//            detalle.setConsecutivoMedicamento(item.getConsecutivoMedicamento());
//            detalle.setConsecutivoMotivo(item.getConsecutivoMotivo());
//            detalle.setFechaDisponibilidad(item.getFechaDisponibilidad());
//
//            autorizacionIps.getDetalles().add(detalle);
//          }
//        }
//      }
//      else {
//        if (autorizacionIps.getEstadoEntrega() == ESiNo.SI.getId()) {
//          // mensaje para no mas entregas de medicamentos para la autorización
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_ENTREGA_COMPLETA.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_ENTREGA_COMPLETA.getId()));
//        }
//        else {
//          int cantidadAIngresar = 0;
//
//          // se validan las cantidades de los medicamentos consultados por ATC enviados desde el formulario
//          mapaCantidad.clear();
//          FastMap<String, POJOAutorizacionItem> mapaDisponibilidad = new FastMap<String, POJOAutorizacionItem>();
//          for (POJOAutorizacionItem item : medicamentosXAtc) {
//            if (!Util.vacio(item.getCantidad())) {
//              if (mapaCantidad.get(item.getConsecutivoMedicamento() == null ? 0 : item.getConsecutivoMedicamento()) == null) {
//                mapaCantidad.put(item.getConsecutivoMedicamento() == null ? 0 : item.getConsecutivoMedicamento(), Integer.parseInt(item.getCantidad()));
//              }
//            }
//            else {
//              Long consecutivoMedicamento = item.getConsecutivoMedicamento();
//              String llave = consecutivoMedicamento + "-" + item.getCodigo();
//
//              if (mapaCantidad.get(consecutivoMedicamento) != null) {
//                cantidadAIngresar += item.getDespacho();
//
//                Integer cantEntregar = mapaCantidadEntregar.get(consecutivoMedicamento);
//                if (cantEntregar == null) {
//                  mapaCantidadEntregar.put(consecutivoMedicamento, cantidadAIngresar);
//                }
//                else {
//                  mapaCantidadEntregar.put(consecutivoMedicamento, cantEntregar + cantidadAIngresar);
//                }
//              }
//
//              if (mapaDisponibilidad.get(llave) == null) {
//                mapaDisponibilidad.put(item.getConsecutivoMedicamento() + "-" + item.getCodigo(), item);
//              }
//              else {
//                mapaDisponibilidad.put(item.getConsecutivoMedicamento() + "-" + item.getCodigo(), item);
//              }
//            }
//          }
//
//          // se verifica las cantidades de entrega de los medicamentos para la autorización
//          boolean total = true;
//          int suma = 0;
//          if (!autorizacionIps.getDetalles().isEmpty()) {
//            for (EntAutorizacionDetalleDto detalle : autorizacionIps.getDetalles()) {
//
//              // cantidad disponible a entregar
//              int cantidadDisponible = (int) (detalle.getCantidad() - detalle.getCantidadEntrega());
//              String llave = detalle.getConsecutivoMedicamento() + "-" + detalle.getCodigo();
//
//              Integer cantidadEntregar = mapaCantidadEntregar.get(detalle.getConsecutivoMedicamento());
//              POJOAutorizacionItem item = mapaDisponibilidad.get(llave);
//
//              if (cantidadEntregar != null) {
//                if (cantidadEntregar > cantidadDisponible) {
//                  return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId()));
//                }
//                else if (cantidadDisponible == ESiNo.NO.getId()) {
//                  // no es posible hacer entrega de mas medicamentos
//                  return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_ENTREGA_COMPLETA.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_ENTREGA_COMPLETA.getId()));
//                }
//
//                LogMedicamentoDto log = mapaLogMedicamento.get(detalle.getConsecutivoMedicamento());
//                if (log != null) {
//                  if (cantidadEntregar > log.getCantidadReal()) { // cantidad real
//                    return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId()));
//                  }
//                }
//
//                suma = (int) detalle.getCantidadEntrega() + cantidadEntregar;
//
//                // se compara la sumatoria de las cantidades contra la cantidad disponible en el log de medicamentos
//                if (suma > log.getCantidadReal()) {
//                  return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR.getId()));
//                }
//
//                else if (suma <= mapaCantidad.get(detalle.getConsecutivoMedicamento())) {
//                  detalle.setCantidadEntrega(cantidadEntregar);
//                  detalle.setConsecutivoMotivo(item.getConsecutivoMotivo());
//                  detalle.setFechaDisponibilidad(item.getFechaDisponibilidad());
//                  total = false;
//                }
//              }
//            }
//          }
//
//          autorizacionIps.setValorCuotaModeradora(Double.parseDouble(autorizacionWs.getValorCuotaModeradora()));
//          autorizacionIps.setValorCopago(Double.parseDouble(autorizacionWs.getValorCopago()));
//          autorizacionIps.setTipoRegimen(autorizacionWs.getAfiliado().getRegimen());
//          autorizacionIps.setTipoAfiliado(autorizacionWs.getAfiliado().getTipoAfiliado());
//          autorizacionIps.setCategoria(autorizacionWs.getAfiliado().getCategoria());
//          autorizacionIps.setSwPos(Short.parseShort(autorizacionWs.getSwPos()));
//          autorizacionIps.setTipoAutorizacion(Short.parseShort(autorizacionWs.getTipoAutorizacion()));
//          autorizacionIps.setConsecutivoIps(consecutivoIps);
//
//          // se actualiza el estado de la autorización
//          if (total) {
//            autorizacionIps.setEstadoEntrega((short) 1);
//          }
//          else {
//            autorizacionIps.setEstadoEntrega((short) 2);
//          }
//        }
//      }
//      if (!autorizacionIps.getDetalles().isEmpty()) {
//        String[] entrega = mantenimientoService.saveOrUpdateOrAutorizacionIps(autorizacionIps, afiliadoPojo, usuarioPojo, listaSoportes);
//        if (entrega != null) {
//
//          String urlDocumentoEntrega = entrega[0];// mantenimientoService.crearReporteMedicamentosEntregaPDF(entrega[0], usuarioPojo);
//          String urlDocumentoPendientes = entrega[1];// mantenimientoService.crearReporteMedicamentosPendientesPDF(entrega.getConsecutivoEntrega(), usuarioPojo);
//
//          if (urlDocumentoEntrega != null && urlDocumentoPendientes != null) {
//
//            InputStream inputEntrega = Util.convertirFileAStream(urlDocumentoEntrega);
//            InputStream inputPendiente = Util.convertirFileAStream(urlDocumentoPendientes);
//
//            autorizacionPojo.setPdfEntrega(Util.covertInputToBytes(inputEntrega));
//            autorizacionPojo.setPdfPendiente(Util.covertInputToBytes(inputPendiente));
//
//            autorizacionPojo.setMostrarModalDocumentos(true);
//            // autorizacionPojo.setPdfEntrega(urlDocumentoEntrega.split("webapp")[1]);
//            // autorizacionPojo.setPdfEntrega("http://localhost:8080/ips" + urlDocumentoEntrega.split("webapp")[1]);
//            // autorizacionPojo.setPdfEntrega(urlDocumentoPendientes.split("webapp")[1]);
//            // autorizacionPojo.setPdfPendiente("http://localhost:8080/ips" + urlDocumentoPendientes.split("webapp")[1]);
//          }
//          // POJOInformacionAutorizacion autorizacionPojo = new POJOInformacionAutorizacion();
//          // ObjectMapper mapper = new ObjectMapper();
//          // autorizacionPojo.setMostrarModalDocumentos(true);
//          // String urlDocumentoPendientes2 = Util.descargaReporte + "/"+Util.RUTA_ENTREGAS_PDF + "root_medicamentos_pendientes.pdf";
//          // autorizacionPojo.setPdfEntrega(urlDocumentoPendientes2.split("webapp")[1]);
//          // autorizacionPojo.setPdfPendiente("http://localhost:8080/ips"+urlDocumentoPendientes2.split("webapp")[1]);
//          // autorizacionPojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//          // autorizacionPojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//          // String response2 = mapper.writeValueAsString(autorizacionPojo);
//          // return Response.ok(response2).build();
//
//          // autorizacionPojo.setPdfEntrega(Base64.getEncoder().encode(Util.getbytes(Util.convertirInputAString(inputEntrega))));
//          // autorizacionPojo.setPdfPendiente(Base64.getEncoder().encode(Util.getbytes(Util.convertirInputAString(inputPendiente))));
//          // autorizacionPojo.setPdfEntrega(Base64.getEncoder().encode(Util.covertInputToBytes(inputEntrega)));
//          // autorizacionPojo.setPdfPendiente(Base64.getEncoder().encode(Util.covertInputToBytes(inputPendiente)));
//
//          String response = mapper.writeValueAsString(autorizacionPojo);
//          return Response.ok(response).build();
//        }
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_SIN_MEDICAMENTOS_CONTRATADOS.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_SIN_MEDICAMENTOS_CONTRATADOS.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//
//    return null;
//  }
//
//  @GET
//  @Path("/downloadFilePdf")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ "application/pdf" }) // -->conten-type > application/pdf
//  @Override
//  public Response downloadFilePdf(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      String FILE_PATH_ENTREGAS = "";
//      String FILE_PATH_PENDIENTES = "";
//      String report = "";
//      File file = null;
//
//      POJOInformacionAutorizacion autorizacionPojo = mapper.readValue(Json, POJOInformacionAutorizacion.class);
//      // FILE_PATH_ENTREGAS = autorizacionPojo.getPdfEntrega();
//      // FILE_PATH_PENDIENTES = autorizacionPojo.getPdfPendiente();
//      if (autorizacionPojo.getBandera() == 1) {
//        report = "medicamentos_entregados.pdf";
//        file = new File(FILE_PATH_ENTREGAS);
//      }
//      else {
//        report = "medicamentos_pendientes.pdf";
//        file = new File(FILE_PATH_PENDIENTES);
//      }
//
//      Response.ResponseBuilder response = Response.ok((Object) file);
//      response.header("Content-Disposition", "attachment; filename=" + report);
//
//      return response.build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  public boolean validarEdadPaciente(String fechaNacimiento) {
//    try {
//      if (Util.vacio(fechaNacimiento)) {
//        return false;
//      }
//
//      int edad = Util.getEdad(fechaNacimiento);
//      if (edad < 18) {
//        return true;
//      }
//      return false;
//    }
//    catch (Exception ex) {
//      ex.printStackTrace();
//      return false;
//    }
//  }
//
//  @POST
//  @Path("/getFacturasCompra")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getFacturasCompra(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOScFacturaEncabezado POJO = mapper.readValue(Json, POJOScFacturaEncabezado.class);
//      ScFacturaEncabezadoDto filtro = new ScFacturaEncabezadoDto();
//      filtro.setNumeroFactura(POJO.getNumeroFactura());
//      filtro.setTipoFactura(ETipoFactura.COMPRA.getId());
//      filtro.setTipoPago(POJO.getTipoPago());
//
//      // Mapa Terceros
//      FastTable<ScTerceroDto> listaTerceros = mantenimientoService.getListaTerceros(new ScTerceroDto());
//      FastMap<Long, ScTerceroDto> mapaTerceros = new FastMap<Long, ScTerceroDto>();
//      for (ScTerceroDto ter : listaTerceros) {
//        mapaTerceros.put(ter.getConsecutivoTercero(), ter);
//      }
//
//      // Mapa Productos
//      FastTable<ScProductoDto> listaProductos = mantenimientoService.getListaproducto(new ScProductoDto());
//      FastMap<Long, ScProductoDto> mapaProductos = new FastMap<Long, ScProductoDto>();
//      for (ScProductoDto pro : listaProductos) {
//        mapaProductos.put(pro.getConsecutivoProducto(), pro);
//      }
//
//      // Mapa Iva
//      FastTable<ScValorIvaDto> listaIvas = mantenimientoService.getListaValorIva(new ScValorIvaDto());
//      FastMap<Long, ScValorIvaDto> mapaIvas = new FastMap<Long, ScValorIvaDto>();
//      for (ScValorIvaDto iva : listaIvas) {
//        mapaIvas.put(iva.getConsecutivoIva(), iva);
//      }
//
//      FastTable<ScFacturaEncabezadoDto> listaDtos = facturacionService.getListaFacturasCompra(filtro);
//      List<POJOScFacturaEncabezado> POJOresult = new ArrayList<POJOScFacturaEncabezado>();
//
//      for (ScFacturaEncabezadoDto dto : listaDtos) {
//        POJOScFacturaEncabezado pojo = new POJOScFacturaEncabezado();
//
//        FastTable<ScFacturaDetalleDto> detallesFactura = new FastTable<ScFacturaDetalleDto>();
//        FastTable<POJOScFacturaDetalle> detallesFacturaPOJO = new FastTable<POJOScFacturaDetalle>();
//        if (dto.getDetallesFactura() != null) {
//          detallesFactura.addAll(dto.getDetallesFactura());
//        }
//        for (ScFacturaDetalleDto detFactura : detallesFactura) {
//          POJOScFacturaDetalle pojDetallesFactura = new POJOScFacturaDetalle();
//          BeanUtils.copyProperties(detFactura, pojDetallesFactura);
//          pojDetallesFactura.setProductoTexto(mapaProductos.get(detFactura.getConsecutivoProducto()).getDescripcion());
//          pojDetallesFactura.setIvaTexto(mapaIvas.get(detFactura.getConsecutivoIva()).getValor());
//          pojDetallesFactura.setClaseProducto(mapaProductos.get(detFactura.getConsecutivoProducto()).getClaseProducto());
//
//          detallesFacturaPOJO.add(pojDetallesFactura);
//        }
//
//        FastTable<ScFacturaPagoDto> pagosFactura = new FastTable<ScFacturaPagoDto>();
//        FastTable<POJOScFacturaPago> pagosFacturaPOJO = new FastTable<POJOScFacturaPago>();
//        if (dto.getPagosFactura() != null) {
//          pagosFactura.addAll(dto.getPagosFactura());
//        }
//        for (ScFacturaPagoDto payFactura : pagosFactura) {
//          POJOScFacturaPago pojPagosFactura = new POJOScFacturaPago();
//          BeanUtils.copyProperties(payFactura, pojPagosFactura);
//          pojPagosFactura.setFechaTexto(Util.getFechaCorta(pojPagosFactura.getFecha(), false));
//          pagosFacturaPOJO.add(pojPagosFactura);
//        }
//
//        FastTable<ScFacturaMedicamentoDto> medicamentosFactura = new FastTable<ScFacturaMedicamentoDto>();
//        FastTable<POJOScFacturaMedicamento> medicamentosFacturaPOJO = new FastTable<POJOScFacturaMedicamento>();
//        if (dto.getMedicamentosFactura() != null) {
//          medicamentosFactura.addAll(dto.getMedicamentosFactura());
//        }
//        for (ScFacturaMedicamentoDto medFactura : medicamentosFactura) {
//          POJOScFacturaMedicamento pojMedicamentosFactura = new POJOScFacturaMedicamento();
//          BeanUtils.copyProperties(medFactura, pojMedicamentosFactura);
//          medicamentosFacturaPOJO.add(pojMedicamentosFactura);
//        }
//
//        dto.setDetallesFactura(null);
//        dto.setPagosFactura(null);
//        dto.setMedicamentosFactura(null);
//
//        BeanUtils.copyProperties(dto, pojo);
//        pojo.setDetallesFactura(detallesFacturaPOJO);
//        pojo.setPagosFactura(pagosFacturaPOJO);
//        pojo.setMedicamentosFactura(medicamentosFacturaPOJO);
//        pojo.setFechaTexto(Util.getFechaCorta(pojo.getFecha(), false));
//        pojo.setTerceroTexto(mapaTerceros.get(pojo.getConsecutivoTercero()).getRazonSocial());
//        pojo.setTipoFacturaTexto(ETipoFactura.getName(pojo.getTipoFactura()));
//        pojo.setEstadoFacturaTexto(EEstado.getName(pojo.getEstadoFactura()));
//        pojo.setFechaVencimientoTexto(Util.getFechaCorta(pojo.getFechaVencimiento(), false));
//        pojo.setValorFacturaTexto(String.format("%1$,.2f", pojo.getValorFactura()));
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteFacturaCompra")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteFacturaCompra(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = scEmpleado
//    try {
//      String path = "saveOrUpdateOrDeleteFacturaCompra";
//      ObjectMapper mapper = new ObjectMapper();
//      mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
//
//      ScFacturaEncabezadoDto dto = new ScFacturaEncabezadoDto();
//      POJOScFacturaEncabezado pojo = mapper.readValue(Json, POJOScFacturaEncabezado.class);
//
//      FastTable<ScFacturaDetalleDto> detallesFactura = new FastTable<ScFacturaDetalleDto>();
//      for (POJOScFacturaDetalle d : pojo.getDetallesFactura()) {
//        ScFacturaDetalleDto itera = new ScFacturaDetalleDto();
//        BeanUtils.copyProperties(d, itera);
//        detallesFactura.add(itera);
//      }
//
//      FastTable<ScFacturaPagoDto> pagosFactura = new FastTable<ScFacturaPagoDto>();
//      if (pojo.getTipoPago() == ETipoPago.CONTADO.getId()) {
//        for (POJOScFacturaPago d : pojo.getPagosFactura()) {
//          ScFacturaPagoDto itera = new ScFacturaPagoDto();
//          BeanUtils.copyProperties(d, itera);
//          pagosFactura.add(itera);
//        }
//      }
//
//      FastTable<ScFacturaMedicamentoDto> medicamentosFactura = new FastTable<ScFacturaMedicamentoDto>();
//      for (POJOScFacturaMedicamento d : pojo.getMedicamentosFactura()) {
//        ScFacturaMedicamentoDto itera = new ScFacturaMedicamentoDto();
//        BeanUtils.copyProperties(d, itera);
//        medicamentosFactura.add(itera);
//      }
//
//      pojo.setDetallesFactura(new FastTable<POJOScFacturaDetalle>());
//      pojo.setPagosFactura(new FastTable<POJOScFacturaPago>());
//      pojo.setMedicamentosFactura(new FastTable<POJOScFacturaMedicamento>());
//
//      BeanUtils.copyProperties(pojo, dto);
//      dto.getDetallesFactura().addAll(detallesFactura);
//      dto.getPagosFactura().addAll(pagosFactura);
//      dto.getMedicamentosFactura().addAll(medicamentosFactura);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else {
//          if (dto.getTipoPago() == ETipoPago.CONTADO.getId()) {
//            double valorFactura = dto.getValorFactura();
//            double valorTotal = 0;
//
//            for (ScFacturaPagoDto pago : dto.getPagosFactura()) {
//              valorTotal = valorTotal + pago.getValorPago();
//            }
//
//            if (valorFactura != valorTotal) {
//              return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALOR_FACTURA_PAGOS_INCORRECTO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALOR_FACTURA_PAGOS_INCORRECTO.getId()));
//            }
//          }
//        }
//      }
//
//      boolean correcto = facturacionService.saveOrUpdateOrDeleteFacturaCompra(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getPeriodosReporte")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getPeriodosReporte(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOPeriodoReporte pojo = mapper.readValue(Json, POJOPeriodoReporte.class);
//      TbPeriodoReporteDto dto = new TbPeriodoReporteDto();
//      dto.setConsecutivoReporte(pojo.getConsecutivoReporte());
//      dto.setDescripcion(pojo.getDescripcion());
//      dto.setFechaInicio(pojo.getFechaInicio());
//      dto.setFechaFin(pojo.getFechaFin());
//
//      FastTable<POJOPeriodoReporte> listaPojo = new FastTable<POJOPeriodoReporte>();
//      FastTable<TbPeriodoReporteDto> lista = mantenimientoService.getListaPeriodoReporte(dto);
//      if (!lista.isEmpty()) {
//        for (TbPeriodoReporteDto r : lista) {
//          POJOPeriodoReporte p = new POJOPeriodoReporte();
//          BeanUtils.copyProperties(r, p);
//
//          listaPojo.add(p);
//        }
//      }
//
//      String jsonInString = mapper.writeValueAsString(listaPojo);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeletePeriodoReporte")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeletePeriodoReporte(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeletePeriodoReporte";
//      ObjectMapper mapper = new ObjectMapper();
//      TbPeriodoReporteDto periodoDto = new TbPeriodoReporteDto();
//      POJOPeriodoReporte periodoPojo = mapper.readValue(Json, POJOPeriodoReporte.class);
//
//      BeanUtils.copyProperties(periodoPojo, periodoDto);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(periodoPojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(periodoPojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) periodoDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeletePeriodoReporte(periodoDto, periodoPojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/consultaListaEntrega")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response consultaListaEntrega(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOEntEntregaEncabezado pojo = mapper.readValue(Json, POJOEntEntregaEncabezado.class);
//      EntEntregaEncabezadoDto dto = new EntEntregaEncabezadoDto();
//      dto.setFechaEntrega(pojo.getFechaInicio());
//      dto.setFechaFin(pojo.getFechaFin());
//      Long consecutivoAseguradora = pojo.getConsecutivoAseguradora();
//
//      FastTable<POJOEntEntregaEncabezado> listaPojo = new FastTable<POJOEntEntregaEncabezado>();
//      FastTable<EntAutorizacionEncabezadoDto> lista = mantenimientoService.getListaEntregasXFechaEntrega(dto, consecutivoAseguradora);
//      if (!lista.isEmpty()) {
//        for (EntAutorizacionEncabezadoDto r : lista) {
//          POJOEntEntregaEncabezado p = new POJOEntEntregaEncabezado();
//          p.setConsecutivoAutorizacion(r.getConsecutivoAutorizacion());
//          p.setConsecutivoPaciente(r.getConsecutivoPaciente());
//          p.setTipoIdentificacion(r.getTipoIdentificacion());
//          p.setNumeroIdentificacion(r.getNumeroIdentificacion());
//          p.setNombreCompleto(r.getNombreCompleto());
//          p.setFechaNacimiento(Util.getDateFormat(r.getFechaNacimiento(), null));
//
//          listaPojo.add(p);
//        }
//      }
//
//      String jsonInString = mapper.writeValueAsString(listaPojo);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveLogMedicamento")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveLogMedicamento(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = logMedicamento
//    try {
//      String path = "saveLogMedicamento";
//      ObjectMapper mapper = new ObjectMapper();
//      mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
//
//      ScFacturaEncabezadoDto dto = new ScFacturaEncabezadoDto();
//      POJOScFacturaEncabezado pojo = mapper.readValue(Json, POJOScFacturaEncabezado.class);
//
//      FastTable<ScFacturaMedicamentoDto> medicamentosFactura = new FastTable<ScFacturaMedicamentoDto>();
//      for (POJOScFacturaMedicamento d : pojo.getListaTrasladoMedicamentos()) {
//        ScFacturaMedicamentoDto itera = new ScFacturaMedicamentoDto();
//        BeanUtils.copyProperties(d, itera);
//        medicamentosFactura.add(itera);
//      }
//
//      pojo.setListaTrasladoMedicamentos(new FastTable<POJOScFacturaMedicamento>());
//
//      BeanUtils.copyProperties(pojo, dto);
//      dto.getListaTrasladoMedicamentos().addAll(medicamentosFactura);
//
//      FastMap<Long, Double> mapaLogs = new FastMap<Long, Double>();
//      // Cargar logMedicamento Compra
//      FastTable<LogMedicamento> listaLogsCompra = facturacionService.getListaLogMedicamento(ETipoMovimiento.FC.getId());
//      for (LogMedicamento log : listaLogsCompra) {
//        if (dto.getConsecutivoIpsOrigen() == log.getConsecutivoIps()) {
//          if (mapaLogs.containsKey(log.getConsecutivoMedicamento())) {
//            double cantidad = mapaLogs.get(log.getConsecutivoMedicamento());
//            mapaLogs.put(log.getConsecutivoMedicamento(), cantidad + log.getCantidad());
//          }
//          else {
//            mapaLogs.put(log.getConsecutivoMedicamento(), log.getCantidad());
//          }
//        }
//      }
//      // Cargar logMedicamento Compra
//      FastTable<LogMedicamento> listaLogsVenta = facturacionService.getListaLogMedicamento(ETipoMovimiento.FV.getId());
//      for (LogMedicamento log : listaLogsVenta) {
//        if (dto.getConsecutivoIpsOrigen() == log.getConsecutivoIps()) {
//          if (mapaLogs.containsKey(log.getConsecutivoMedicamento())) {
//            double cantidad = mapaLogs.get(log.getConsecutivoMedicamento());
//            mapaLogs.put(log.getConsecutivoMedicamento(), cantidad - log.getCantidad());
//          }
//          else {
//            mapaLogs.put(log.getConsecutivoMedicamento(), log.getCantidad());
//          }
//        }
//      }
//      // Cargar logMedicamento Traslado
//      FastTable<LogMedicamento> listaLogsTraslado = facturacionService.getListaLogMedicamento(ETipoMovimiento.MOV.getId());
//      for (LogMedicamento log : listaLogsTraslado) {
//        if (dto.getConsecutivoIpsOrigen() == log.getConsecutivoIps()) {
//          if (mapaLogs.containsKey(log.getConsecutivoMedicamento())) {
//            double cantidad = mapaLogs.get(log.getConsecutivoMedicamento());
//            mapaLogs.put(log.getConsecutivoMedicamento(), cantidad - log.getCantidad());
//          }
//          else {
//            mapaLogs.put(log.getConsecutivoMedicamento(), log.getCantidad());
//          }
//        }
//      }
//
//      FastMap<Long, Double> mapaMediXCanti = new FastMap<Long, Double>();
//      for (ScFacturaMedicamentoDto med : medicamentosFactura) {
//        if (mapaMediXCanti.containsKey(med.getConsecutivoMedicamento())) {
//          double cantidad = mapaMediXCanti.get(med.getConsecutivoMedicamento());
//          mapaMediXCanti.put(med.getConsecutivoMedicamento(), cantidad + med.getNuevaCantidad());
//        }
//        else {
//          mapaMediXCanti.put(med.getConsecutivoMedicamento(), med.getNuevaCantidad());
//        }
//      }
//
//      // Validando Cantidades Actuales
//      boolean flag = true;
//      for (Long medicamento : mapaMediXCanti.keySet()) {
//        double cantidadPedida = mapaMediXCanti.get(medicamento);
//        double cantidadDisponible = mapaLogs.get(medicamento);
//        if (cantidadDisponible < cantidadPedida) {
//          flag = false;
//          break;
//        }
//      }
//
//      if (!flag) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_CANTIDADES_MEDICAMENTO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_CANTIDADES_MEDICAMENTO.getId()));
//      }
//
//      boolean correcto = facturacionService.saveLogMedicamento(dto);
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getInfraestructura")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getInfraestructura(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOCtInfraestructura POJO = mapper.readValue(Json, POJOCtInfraestructura.class);
//      CtInfraestructuraDto filtro = new CtInfraestructuraDto();
//      filtro.setConsecutivoConsultorio(POJO.getConsecutivoConsultorio());
//      filtro.setDescripcion(POJO.getDescripcion());
//      filtro.setConsecutivoIps(POJO.getConsecutivoIps());
//
//      FastTable<TbTipoConsultorioDto> listaTiposConsultorios = mantenimientoService.getListaTipoConsultorios(new TbTipoConsultorioDto());
//      FastMap<Long, TbTipoConsultorioDto> mapaTiposConsultorios = new FastMap<Long, TbTipoConsultorioDto>();
//      for (TbTipoConsultorioDto tipo : listaTiposConsultorios) {
//        mapaTiposConsultorios.put(tipo.getConsecutivoTipo(), tipo);
//      }
//
//      FastTable<CtInfraestructuraDto> listaDtos = mantenimientoService.getListaInfraestructura(filtro);
//      List<POJOCtInfraestructura> POJOresult = new ArrayList<POJOCtInfraestructura>();
//
//      for (CtInfraestructuraDto dto : listaDtos) {
//        POJOCtInfraestructura pojo = new POJOCtInfraestructura();
//
//        BeanUtils.copyProperties(dto, pojo);
//        pojo.setSwActivoTexto(ESiNo.getName(pojo.getSwActivo()));
//        pojo.setConsecutivoTipoTexto(mapaTiposConsultorios.get(dto.getConsecutivoTipo()).getDescripcion());
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteInfraestructura")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteInfraestructura(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = ctInfraestructura
//    try {
//      String path = "saveOrUpdateOrDeleteInfraestructura";
//      ObjectMapper mapper = new ObjectMapper();
//
//      CtInfraestructuraDto dto = new CtInfraestructuraDto();
//      POJOCtInfraestructura pojo = mapper.readValue(Json, POJOCtInfraestructura.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteInfraestructura(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getMotivosPendiente")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getMotivosPendiente(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbMotivoPendiente motivoPOJO = mapper.readValue(Json, POJOTbMotivoPendiente.class);
//      TbMotivoPendienteDto motivoFiltro = new TbMotivoPendienteDto();
//      motivoFiltro.setConsecutivoMotivo(motivoPOJO.getConsecutivoMotivo());
//      motivoFiltro.setDescripcion(motivoPOJO.getDescripcion());
//      FastTable<TbMotivoPendienteDto> motivos = mantenimientoService.getListaMotivosPendiente(motivoFiltro);
//
//      List<POJOTbMotivoPendiente> motivosPOJO = new ArrayList<POJOTbMotivoPendiente>();
//      for (TbMotivoPendienteDto motivo : motivos) {
//        POJOTbMotivoPendiente pojoMotivo = new POJOTbMotivoPendiente();
//        BeanUtils.copyProperties(motivo, pojoMotivo);
//        pojoMotivo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoMotivo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        motivosPOJO.add(pojoMotivo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(motivosPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteMotivoPendiente")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteMotivoPendiente(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbMotivoPendiente
//    try {
//      String path = "saveOrUpdateOrDeleteMotivoPendiente";
//      ObjectMapper mapper = new ObjectMapper();
//      TbMotivoPendienteDto motivoDto = new TbMotivoPendienteDto();
//      POJOTbMotivoPendiente motivo = mapper.readValue(Json, POJOTbMotivoPendiente.class);
//
//      BeanUtils.copyProperties(motivo, motivoDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(motivo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(motivo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) motivoDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteMotivoPendiente(motivoDto, motivo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getTiposSoporte")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getTiposSoporte(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbTipoSoporte tipoSoportePOJO = mapper.readValue(Json, POJOTbTipoSoporte.class);
//      TbTipoSoporteDto tipoSoporteFiltro = new TbTipoSoporteDto();
//      tipoSoporteFiltro.setConsecutivoSoporte(tipoSoportePOJO.getConsecutivoSoporte());
//      tipoSoporteFiltro.setDescripcion(tipoSoportePOJO.getDescripcion());
//      FastTable<TbTipoSoporteDto> tiposSoporte = mantenimientoService.getListaTiposSoporte(tipoSoporteFiltro);
//
//      List<POJOTbTipoSoporte> tiposSoportePOJO = new ArrayList<POJOTbTipoSoporte>();
//      for (TbTipoSoporteDto tipoSoporte : tiposSoporte) {
//        POJOTbTipoSoporte pojoTipoSoporte = new POJOTbTipoSoporte();
//        BeanUtils.copyProperties(tipoSoporte, pojoTipoSoporte);
//        pojoTipoSoporte.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoTipoSoporte.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        tiposSoportePOJO.add(pojoTipoSoporte);
//      }
//
//      String jsonInString = mapper.writeValueAsString(tiposSoportePOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteTipoSoporte")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteTipoSoporte(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = tbTipoSoporte
//    try {
//      String path = "saveOrUpdateOrDeleteTipoSoporte";
//      ObjectMapper mapper = new ObjectMapper();
//      TbTipoSoporteDto moduloDto = new TbTipoSoporteDto();
//      POJOTbTipoSoporte modulo = mapper.readValue(Json, POJOTbTipoSoporte.class);
//
//      BeanUtils.copyProperties(modulo, moduloDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(modulo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(modulo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) moduloDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteTipoSoporte(moduloDto, modulo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getTiposSoporteXProceso")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getTiposSoporteXProceso(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOTbProcesoEncabezado POJO = mapper.readValue(Json, POJOTbProcesoEncabezado.class);
//      TbProcesoEncabezadoDto filtro = new TbProcesoEncabezadoDto();
//      filtro.setProceso(POJO.getProceso());
//      filtro.setDescripcion(POJO.getDescripcion());
//
//      FastTable<TbTipoSoporteDto> listaTiposSoporte = mantenimientoService.getListaTiposSoporte(new TbTipoSoporteDto());
//      FastMap<Long, TbTipoSoporteDto> mapaTipoSoporte = new FastMap<Long, TbTipoSoporteDto>();
//      for (TbTipoSoporteDto tipoSoporte : listaTiposSoporte) {
//        mapaTipoSoporte.put(tipoSoporte.getConsecutivoSoporte(), tipoSoporte);
//      }
//
//      FastTable<TbProcesoEncabezadoDto> listaDtos = mantenimientoService.getListaTiposSoporteXProceso(filtro);
//      List<POJOTbProcesoEncabezado> POJOresult = new ArrayList<POJOTbProcesoEncabezado>();
//
//      for (TbProcesoEncabezadoDto dto : listaDtos) {
//        POJOTbProcesoEncabezado pojo = new POJOTbProcesoEncabezado();
//
//        FastTable<TbProcesoDetalleDto> detallesProceso = new FastTable<TbProcesoDetalleDto>();
//        FastTable<POJOTbProcesoDetalle> detallesProcesoPOJO = new FastTable<POJOTbProcesoDetalle>();
//        if (dto.getDetallesProceso() != null) {
//          detallesProceso.addAll(dto.getDetallesProceso());
//        }
//        for (TbProcesoDetalleDto detProceso : detallesProceso) {
//          POJOTbProcesoDetalle pojDetallesProceso = new POJOTbProcesoDetalle();
//          BeanUtils.copyProperties(detProceso, pojDetallesProceso);
//          detallesProcesoPOJO.add(pojDetallesProceso);
//        }
//
//        dto.setDetallesProceso(null);
//
//        BeanUtils.copyProperties(dto, pojo);
//        pojo.setDetallesProceso(detallesProcesoPOJO);
//        pojo.setProcesoTexto(EProceso.getName(pojo.getProceso()));
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        POJOresult.add(pojo);
//      }
//
//      String jsonInString = mapper.writeValueAsString(POJOresult);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteTipoSoporteXProceso")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteTipoSoporteXProceso(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = scEmpleado
//    try {
//      String path = "saveOrUpdateOrDeleteTipoSoporteXProceso";
//      ObjectMapper mapper = new ObjectMapper();
//      mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
//
//      TbProcesoEncabezadoDto dto = new TbProcesoEncabezadoDto();
//      POJOTbProcesoEncabezado pojo = mapper.readValue(Json, POJOTbProcesoEncabezado.class);
//
//      FastTable<TbProcesoDetalleDto> detallesProceso = new FastTable<TbProcesoDetalleDto>();
//      for (POJOTbProcesoDetalle d : pojo.getDetallesProceso()) {
//        TbProcesoDetalleDto itera = new TbProcesoDetalleDto();
//        BeanUtils.copyProperties(d, itera);
//        detallesProceso.add(itera);
//      }
//
//      pojo.setDetallesProceso(new FastTable<POJOTbProcesoDetalle>());
//
//      BeanUtils.copyProperties(pojo, dto);
//      dto.getDetallesProceso().addAll(detallesProceso);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//        else {
//          FastTable<TbProcesoEncabezadoDto> procesos = mantenimientoService.getListaTiposSoporteXProceso(new TbProcesoEncabezadoDto());
//          boolean flag = true;
//          for (TbProcesoEncabezadoDto obj : procesos) {
//            if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//              if (obj.getProceso() == dto.getProceso()) {
//                flag = false;
//                break;
//              }
//            }
//            else {
//              if (obj.getConsecutivoProceso() != dto.getConsecutivoProceso() && obj.getProceso() == dto.getProceso()) {
//                flag = false;
//                break;
//              }
//            }
//          }
//
//          if (!flag) {
//            return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_PROCESO_REPETIDO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_PROCESO_REPETIDO.getId()));
//          }
//        }
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteTipoSoporteXProceso(dto, pojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getPeriodoReporte")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getPeriodoReporte(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOPeriodoReporte pojo = mapper.readValue(Json, POJOPeriodoReporte.class);
//      TbPeriodoReporteDto dto = new TbPeriodoReporteDto();
//
//      dto.setConsecutivoReporte(pojo.getConsecutivoReporte());
//
//      FastTable<TbPeriodoReporteDto> listaPeriodo = mantenimientoService.getListaPeriodoReporte(dto);
//      if (!listaPeriodo.isEmpty()) {
//        dto = listaPeriodo.get(0);
//        BeanUtils.copyProperties(dto, pojo);
//
//        pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//      }
//
//      String jsonInString = mapper.writeValueAsString(pojo);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/generarRips")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response generarRips(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//
//      ObjectMapper mapper = new ObjectMapper();
//      POJOPeriodoReporte pojo = mapper.readValue(Json, POJOPeriodoReporte.class);
//      FastList<Long> idEncabezados = new FastList<Long>();
//
//      Long periodo = pojo.getConsecutivoReporte();
//      Date fechaInicio = pojo.getFechaInicio();
//      Date fechaFin = pojo.getFechaFin();
//      String usuarioSesion = pojo.getUsuarioSesion();
//      Long ipsSesion = pojo.getIpsSesion();
//      Long consecutivoAseguradora = pojo.getConsecutivoAseguradora();
//
//      POJOEntEntregaEncabezado[] encabezadosPojo = pojo.getListaEntregaEncabezado();
//      if (encabezadosPojo.length > 0) {
//        for (POJOEntEntregaEncabezado enc : encabezadosPojo) {
//          idEncabezados.add(enc.getConsecutivoAutorizacion().longValue());
//        }
//      }
//
//      if (periodo != null && !idEncabezados.isEmpty()) {
//        boolean result = mantenimientoService.saveRips(fechaInicio, fechaFin, periodo, consecutivoAseguradora, idEncabezados, usuarioSesion, ipsSesion);
//        if (!result) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//        }
//      }
//
//      pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//      String jsonInString = mapper.writeValueAsString(pojo);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getUsersIps")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getUsersIps(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOUsuario usuarioPOJO = mapper.readValue(Json, POJOUsuario.class);
//      UsuarioDto userFiltro = new UsuarioDto();
//      userFiltro.setUsuario(usuarioPOJO.getUsuario());
//      userFiltro.setNombre(usuarioPOJO.getNombre());
//      FastTable<UsuarioDto> usuarios = mantenimientoService.getListaUsuarios(userFiltro);
//
//      FastTable<UsuarioIpsDto> listaUsersIps = mantenimientoService.getUsuariosIpsLogin(null, true);
//      FastMap<String, FastTable<POJOUsuarioIps>> mapaUsuariosXIps = new FastMap<String, FastTable<POJOUsuarioIps>>();
//      FastTable<POJOUsuarioIps> listaTempo = new FastTable<POJOUsuarioIps>();
//      for (UsuarioIpsDto userIpsDto : listaUsersIps) {
//        POJOUsuarioIps userIps = new POJOUsuarioIps();
//        BeanUtils.copyProperties(userIpsDto, userIps);
//
//        if (mapaUsuariosXIps.isEmpty()) {
//          listaTempo.add(userIps);
//          mapaUsuariosXIps.put(userIps.getUsuario(), listaTempo);
//        }
//        else {
//          if (mapaUsuariosXIps.containsKey(userIps.getUsuario())) {
//            mapaUsuariosXIps.get(userIps.getUsuario()).add(userIps);
//          }
//          else {
//            listaTempo = new FastTable<POJOUsuarioIps>();
//            listaTempo.add(userIps);
//            mapaUsuariosXIps.put(userIps.getUsuario(), listaTempo);
//          }
//        }
//      }
//
//      List<POJOUsuario> usersPOJO = new ArrayList<POJOUsuario>();
//      for (UsuarioDto user : usuarios) {
//        POJOUsuario pojoUser = new POJOUsuario();
//        BeanUtils.copyProperties(user, pojoUser);
//        pojoUser.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        pojoUser.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//        pojoUser.setIteradorUsuarioIps(new FastTable<POJOUsuarioIps>());
//        pojoUser.getIteradorUsuarioIps().addAll(mapaUsuariosXIps.get(user.getUsuario()) != null ? mapaUsuariosXIps.get(user.getUsuario()) : new FastTable<POJOUsuarioIps>());
//
//        usersPOJO.add(pojoUser);
//      }
//
//      String jsonInString = mapper.writeValueAsString(usersPOJO);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateUserIps")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateUserIps(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    // TODO urlIdModulo = usuarioIps
//    try {
//      String path = "saveOrUpdateUserIps";
//      ObjectMapper mapper = new ObjectMapper();
//      UsuarioDto usuarioDto = new UsuarioDto();
//      POJOUsuario usuario = mapper.readValue(Json, POJOUsuario.class);
//
//      if (usuario.getIteradorUsuarioIps().isEmpty()) {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_USUARIO_IPS_ITERADOR_VACIO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_USUARIO_IPS_ITERADOR_VACIO.getId()));
//      }
//
//      FastTable<UsuarioIpsDto> iteradorIps = new FastTable<UsuarioIpsDto>();
//      for (POJOUsuarioIps d : usuario.getIteradorUsuarioIps()) {
//        UsuarioIpsDto itera = new UsuarioIpsDto();
//        BeanUtils.copyProperties(d, itera);
//        iteradorIps.add(itera);
//      }
//
//      usuario.setIteradorUsuarioIps(new FastTable<POJOUsuarioIps>());
//      BeanUtils.copyProperties(usuario, usuarioDto);
//
//      boolean correcto = mantenimientoService.saveOrUpdateUserIps(usuarioDto);
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getEmpresa")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getEmpresa(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOEmpresa pojo = mapper.readValue(Json, POJOEmpresa.class);
//      TbEmpresaDto dto = new TbEmpresaDto();
//
//      dto.setNit(pojo.getNit());
//      dto.setRazonSocial(pojo.getRazonSocial());
//
//      TbEmpresaDto empresa = mantenimientoService.getEmpresa(dto);
//      BeanUtils.copyProperties(empresa, pojo);
//
//      pojo.setMunicipioTexto(empresa.getTbMunicipio().getDescripcion());
//      pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//
//      String jsonInString = mapper.writeValueAsString(pojo);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveOrUpdateOrDeleteEmpresa")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveOrUpdateOrDeleteEmpresa(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveOrUpdateOrDeleteEmpresa";
//      ObjectMapper mapper = new ObjectMapper();
//      TbEmpresaDto empresaDto = new TbEmpresaDto();
//      POJOEmpresa empresaPojo = mapper.readValue(Json, POJOEmpresa.class);
//
//      BeanUtils.copyProperties(empresaPojo, empresaDto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(empresaPojo.getStatusAction()) || EAccion.EDIT.getText().equalsIgnoreCase(empresaPojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) empresaDto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//      }
//
//      TbEmpresaDto empresa = mantenimientoService.getEmpresa(new TbEmpresaDto());
//      if (empresa.getConsecutivoEmpresa() != null) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.ERROR_JAVA_EXISTE_CONFIGURACION_EMPRESA.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_EXISTE_CONFIGURACION_EMPRESA.getId()));
//      }
//
//      boolean correcto = mantenimientoService.saveOrUpdateOrDeleteEmpresa(empresaDto, empresaPojo.getStatusAction());
//      if (correcto) {
//        return this.atraparSucces(EEstadoRespuestaHTTP.OK.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//      }
//      else {
//        return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getAutorizacionesPagos")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getAutorizacionesPagos(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJOEntAutorizacionEncabezado pojo = mapper.readValue(Json, POJOEntAutorizacionEncabezado.class);
//      EntAutorizacionEncabezadoDto dto = new EntAutorizacionEncabezadoDto();
//      dto.setNumeroAutorizacion(pojo.getNumeroAutorizacion());
//      dto.setNumeroIdentificacion(pojo.getNumeroIdentificacion());
//
//      FastTable<EntAutorizacionEncabezadoDto> listaDtos = mantenimientoService.getAutorizacionesAplicaCopago(dto);
//
//      List<POJOEntAutorizacionEncabezado> listaPOJOS = new ArrayList<POJOEntAutorizacionEncabezado>();
//      for (EntAutorizacionEncabezadoDto dt : listaDtos) {
//        POJOEntAutorizacionEncabezado poj = new POJOEntAutorizacionEncabezado();
//        BeanUtils.copyProperties(dt, poj);
//        poj.setTipoIdentificacionTexto(dt.getTipoIdentificacion());
//        poj.setNombreCompleto(dt.getNombreCompleto());
//        poj.setValorCopagoTexto(String.format("%1$,.2f", pojo.getValorCopago()));
//        poj.setValorCuotaModeradoraTexto(String.format("%1$,.2f", pojo.getValorCuotaModeradora()));
//        poj.setFechaAutorizacionTexto(Util.getFechaCorta(dt.getFechaAutorizacion(), false));
//
//        poj.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        poj.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        listaPOJOS.add(poj);
//      }
//
//      String jsonInString = mapper.writeValueAsString(listaPOJOS);
//
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/saveAutorizacionPago")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response saveAutorizacionPago(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      String path = "saveAutorizacionPago";
//      ObjectMapper mapper = new ObjectMapper();
//      EntAutorizacionEncabezadoDto dto = new EntAutorizacionEncabezadoDto();
//      POJOEntAutorizacionEncabezado pojo = mapper.readValue(Json, POJOEntAutorizacionEncabezado.class);
//
//      BeanUtils.copyProperties(pojo, dto);
//
//      // ¿Cumple las Validaciones?
//      if (EAccion.ADD.getText().equalsIgnoreCase(pojo.getStatusAction())) {
//        String textoValidaciones = this.validaciones(path, (Object) dto);
//        if (!Util.vacio(textoValidaciones)) {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId(), "<span style=\"font-weight:bolder\">" + EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS.getId()) + "</span><br/><br/>" + "<div style=\"text-align: left !important;\">" + textoValidaciones + "</div>");
//        }
//
//        boolean correcto = mantenimientoService.saveAutorizacionPago(dto);
//        if (correcto) {
//          String nombreReporte = pojo.getNumeroAutorizacion() + "-" + pojo.getNumeroIdentificacion() + "-soporte-pago.pdf";
//          POJOFileUpload filePojo = new POJOFileUpload();
//          String urlSoportePago = mantenimientoService.crearReportePagoPDF(dto.getConsecutivoAutorizacion(), nombreReporte);
//          if (urlSoportePago != null) {
//            InputStream inputPago = Util.convertirFileAStream(urlSoportePago);
//            filePojo.setFile(Util.covertInputToBytes(inputPago));
//            filePojo.setFilename(pojo.getNumeroAutorizacion() + "-" + pojo.getNumeroIdentificacion() + "-soporte-pago.pdf");
//          }
//          filePojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//          filePojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//          String jsonInString = mapper.writeValueAsString(filePojo);
//
//          return Response.ok(jsonInString).build();
//        }
//        else {
//          return this.atraparExc(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId(), EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.ERROR_JAVA_FALLO_PROCESO.getId()));
//        }
//      }
//      else {
//        String nombreReporte = pojo.getNumeroAutorizacion() + "-" + pojo.getNumeroIdentificacion() + "-soporte-pago.pdf";
//        POJOFileUpload filePojo = new POJOFileUpload();
//        String urlSoportePago = mantenimientoService.crearReportePagoPDF(dto.getConsecutivoAutorizacion(), nombreReporte);
//        if (urlSoportePago != null) {
//          InputStream inputPago = Util.convertirFileAStream(urlSoportePago);
//          filePojo.setFile(Util.covertInputToBytes(inputPago));
//          filePojo.setFilename(pojo.getNumeroAutorizacion() + "-" + pojo.getNumeroIdentificacion() + "-soporte-pago.pdf");
//        }
//        filePojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//        filePojo.setStatusMsg(EEstadoRespuestaHTTP.getMessage(EEstadoRespuestaHTTP.OK.getId()));
//
//        String jsonInString = mapper.writeValueAsString(filePojo);
//
//        return Response.ok(jsonInString).build();
//      }
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  @POST
//  @Path("/getRipsGenerated")
//  @Consumes({ MediaType.APPLICATION_JSON }) // -->recibir json
//  @Produces({ MediaType.APPLICATION_JSON }) // -->regresar json
//  @Override
//  public Response getRipsGenerated(@RequestBody String Json) throws JSONException, JsonProcessingException {
//    try {
//      ObjectMapper mapper = new ObjectMapper();
//      POJORipsResumen pojo = mapper.readValue(Json, POJORipsResumen.class);
//      RipsResumenDto dto = new RipsResumenDto();
//
//      dto.setFechaProceso(pojo.getFechaProceso());
//      dto.setFechaFin(pojo.getFechaFin());
//      dto.setRecepcionRips(pojo.getRecepcionRips());
//      dto.setConsecutivoAseguradora(pojo.getConsecutivoAseguradora());
//
//      FastTable<POJORipsResumen> lista = new FastTable<POJORipsResumen>();
//      FastTable<RipsResumenDto> listaRips = mantenimientoService.getListaRipsGenerados(dto);
//      if (!listaRips.isEmpty()) {
//        for (RipsResumenDto r : listaRips) {
//
//          POJORipsResumen resumen = new POJORipsResumen();
//          resumen.setConsecutivoRips(r.getConsecutivoRips());
//          resumen.setFechaProceso(r.getFechaProceso());
//          resumen.setAseguradoraTexto(r.getTbAseguradora().getRazonSocial());
//          resumen.setConsecutivoAseguradora(r.getConsecutivoAseguradora());
//          resumen.setConsecutivoContrato(r.getConsecutivoContrato());
//
//          lista.add(resumen);
//        }
//      }
//
//      pojo.setStatusId(EEstadoRespuestaHTTP.OK.getId());
//      String jsonInString = mapper.writeValueAsString(lista);
//      return Response.ok(jsonInString).build();
//    }
//    catch (Exception e) {
//      e.printStackTrace();
//      this.errores(e);
//      return Response.serverError().build();
//    }
//  }
//
//  // TODO REVISION 205 -> IPSMTTO008_PRODUCTOS_ENTRADA
//  // TODO REVISION 215 -> IPSMTTO008_PRODUCTOS_ENTRADA
//
//  // TODO PARA TENER EN CUENTA LUEGO
//  // Persist.setAttribute("usuario", userSession);
//  // Persist.setAttribute("changePass", null);
//  // Persist.setAttribute("changePassNewUser", null);
//  // return Response.ok(json, MediaType.APPLICATION_JSON).build();
//  // int a = 0;
//  // int b = a / 0;
//
//  // Integer a = null;
//  // int b = a / 4;
//
//  // String[] vect = new String[1];
//  // String ho = vect[5];
//
//  // TODO probar IOException
//  // File sa = new File("asad");
//  // sa.getAbsoluteFile();
//}