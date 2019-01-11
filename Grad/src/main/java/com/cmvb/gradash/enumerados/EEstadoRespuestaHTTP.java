package com.cmvb.gradash.enumerados;

import com.cmvb.gradash.util.Mensaje;
import com.cmvb.gradash.util.Util;

public enum EEstadoRespuestaHTTP implements IEnum {

    /*
   * 
   * (1) Respuestas Informativas (2) Exito (3) Redireccion (4) Errores del Cliente (5) Errores del Servidor (6) Otros Errores de BD y Ejecucion
   * 
     */
    CONTINUAR {
        @Override
        public short getId() {
            return 100;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_100");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_100");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 1;
        }

    },
    PROTOCOLOS_CONMUTACION {
        @Override
        public short getId() {
            return 101;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_101");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_101");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 1;
        }

    },
    PROCESAMIENTO {
        @Override
        public short getId() {
            return 102;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_102");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_102");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 1;
        }

    },
    PRIMEROS_CONSEJOS {
        @Override
        public short getId() {
            return 103;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_103");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_103");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 1;
        }

    },
    OK {
        @Override
        public short getId() {
            return 200;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_200");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_200");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    CREADO {
        @Override
        public short getId() {
            return 201;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_201");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_201");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    ACEPTADO {
        @Override
        public short getId() {
            return 202;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_202");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_202");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    INFORMACION_NO_AUTORIZADA {
        @Override
        public short getId() {
            return 203;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_203");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_203");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    SIN_CONTENIDO {
        @Override
        public short getId() {
            return 204;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_204");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_204");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    REESTABLECER_CONTENIDO {
        @Override
        public short getId() {
            return 205;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_205");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_205");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    CONTENIDO_PARCIAL {
        @Override
        public short getId() {
            return 206;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_206");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_206");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    MULTI_STATUS {
        @Override
        public short getId() {
            return 207;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_207");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_207");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    YA_INFORMADO {
        @Override
        public short getId() {
            return 208;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_208");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_208");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    IM_USADOS {
        @Override
        public short getId() {
            return 226;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_226");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_226");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 2;
        }

    },
    OPCIONES_MULTIPLES {
        @Override
        public short getId() {
            return 300;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_300");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_300");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 3;
        }

    },
    MOVIDO_PERMANENTE {
        @Override
        public short getId() {
            return 301;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_301");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_301");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 3;
        }

    },
    ENCONTRADOS {
        @Override
        public short getId() {
            return 302;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_302");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_302");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 3;
        }

    },
    VER_OTRO {
        @Override
        public short getId() {
            return 303;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_303");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_303");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 3;
        }

    },
    NO_MODIFICADO {
        @Override
        public short getId() {
            return 304;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_304");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_304");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 3;
        }

    },
    USAR_PROXY {
        @Override
        public short getId() {
            return 305;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_305");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_305");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 3;
        }

    },
    SWITCH_PROXY {
        @Override
        public short getId() {
            return 306;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_306");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_306");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 3;
        }

    },
    REDIRECCION_TEMPORAL {
        @Override
        public short getId() {
            return 307;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_307");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_307");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 3;
        }

    },
    REDIRECCION_PERMANENTE {
        @Override
        public short getId() {
            return 308;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_308");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_308");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 3;
        }

    },
    PETICION_INCORRECTA {
        @Override
        public short getId() {
            return 400;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_400");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_400");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    NO_AUTORIZADO {
        @Override
        public short getId() {
            return 401;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_401");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_401");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    PAGO_REQUERIDO {
        @Override
        public short getId() {
            return 402;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_402");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_402");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    PROHIBIDO {
        @Override
        public short getId() {
            return 403;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_403");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_403");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    NO_ENCONTRADO {
        @Override
        public short getId() {
            return 404;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_404");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_404");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    METODO_NO_PERMITIDO {
        @Override
        public short getId() {
            return 405;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_405");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_405");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    NO_ACEPTABLE {
        @Override
        public short getId() {
            return 406;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_406");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_406");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    AUTENTICACION_PROXY_REQUERIDA {
        @Override
        public short getId() {
            return 407;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_407");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_407");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    TIEMPO_ESPERA_SOLICITUD {
        @Override
        public short getId() {
            return 408;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_408");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_408");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    CONFLICTO {
        @Override
        public short getId() {
            return 409;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_409");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_409");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    IDO {
        @Override
        public short getId() {
            return 410;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_410");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_410");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    LONGITUD_REQUERIDA {
        @Override
        public short getId() {
            return 411;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_411");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_411");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    CONDICION_PREVIA_FALLIDA {
        @Override
        public short getId() {
            return 412;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_412");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_412");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    CARGA_UTIL_DEMASIADO_GRANDE {
        @Override
        public short getId() {
            return 413;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_413");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_413");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    URI_DEMASIADO_LARGO {
        @Override
        public short getId() {
            return 414;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_414");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_414");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    TIPO_MEDIO_NO_ADMITIDO {
        @Override
        public short getId() {
            return 415;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_415");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_415");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    RANGO_NO_SATISFACTORIO {
        @Override
        public short getId() {
            return 416;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_416");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_416");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    EXPECTATIVA_FALLO {
        @Override
        public short getId() {
            return 417;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_417");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_417");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    SOLICITUD_MAL_DIRIGIDA {
        @Override
        public short getId() {
            return 421;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_421");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_421");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    ENTIDAD_NO_PROCESABLE {
        @Override
        public short getId() {
            return 422;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_422");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_422");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    BLOQUEADO {
        @Override
        public short getId() {
            return 423;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_423");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_423");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    DEPENDENCIA_FALLIDA {
        @Override
        public short getId() {
            return 424;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_424");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_424");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    ACTUALIZACION_REQUERIDA {
        @Override
        public short getId() {
            return 426;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_426");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_426");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    REQUISITO_PREVIO {
        @Override
        public short getId() {
            return 428;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_428");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_428");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    DEMASIADAS_SOLICITUDES {
        @Override
        public short getId() {
            return 429;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_429");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_429");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    CAMPOS_ENCABEZADO_SOLICITUD_DEMASIADO_GRANDES {
        @Override
        public short getId() {
            return 431;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_431");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_431");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    TIEMPO_ESPERA_INICIO_SESION {
        @Override
        public short getId() {
            return 440;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_440");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_440");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    REINTENTAR_INFORMACION_REQUERIDA {
        @Override
        public short getId() {
            return 449;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_449");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_449");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    NO_DISPONIBLE_POR_RAZONES_LEGALES {
        @Override
        public short getId() {
            return 451;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_451");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_451");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    ERROR_SSL {
        @Override
        public short getId() {
            return 495;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_495");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_495");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    SSL_REQUERIDO {
        @Override
        public short getId() {
            return 496;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_496");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_496");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    SOLICITUD_HTTP_ENVIADA_PUERTO_HTTPS {
        @Override
        public short getId() {
            return 497;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_497");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_497");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    SOLICITUD_CERRADA_CLIENTE {
        @Override
        public short getId() {
            return 499;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_499");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_499");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 4;
        }

    },
    ERROR_INTERNO_SERVIDOR {
        @Override
        public short getId() {
            return 500;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_500");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_500");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    NO_IMPLEMENTADO {
        @Override
        public short getId() {
            return 501;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_501");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_501");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    PUERTA_ENLACE_NO_VALIDA {
        @Override
        public short getId() {
            return 502;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_502");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_502");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    SERVICIO_NO_DISPONIBLE {
        @Override
        public short getId() {
            return 503;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_503");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_503");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    TIEMPO_ESPERA_PUERTA_ENLACE {
        @Override
        public short getId() {
            return 504;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_504");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_504");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    VERSION_HTTP_NO_ADMITIDA {
        @Override
        public short getId() {
            return 505;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_505");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_505");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    ALMACENAMIENTO_INSUFICIENTE {
        @Override
        public short getId() {
            return 507;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_507");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_507");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    BUCLE_INFINITO_DETECTADO {
        @Override
        public short getId() {
            return 508;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_508");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_508");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    SE_REQUIERE_EXTENSIONES {
        @Override
        public short getId() {
            return 510;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_510");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_510");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    AUTENTICACION_RED_REQUERIDA {
        @Override
        public short getId() {
            return 511;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_511");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_511");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    ERROR_DESCONOCIDO {
        @Override
        public short getId() {
            return 520;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_520");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_520");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    SERVIDOR_WEB_CAIDO {
        @Override
        public short getId() {
            return 521;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_521");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_521");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    TIEMPO_ESPERA_CONEXION_AGOTADO {
        @Override
        public short getId() {
            return 522;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_522");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_522");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    ORIGEN_INALCANZABLE {
        @Override
        public short getId() {
            return 523;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_523");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_523");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    SE_PRODUJO_TIEMPO_ESPERA {
        @Override
        public short getId() {
            return 524;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_524");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_524");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    SSL_HANDSHAKE_FALLO {
        @Override
        public short getId() {
            return 525;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_525");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_525");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    CERTIFICADO_SSL_NO_VALIDO {
        @Override
        public short getId() {
            return 526;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_526");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_526");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    ERROR_DE_RAILGUN {
        @Override
        public short getId() {
            return 527;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_527");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_527");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 5;
        }

    },
    ERROR_BD_NO_CONEXION {
        @Override
        public short getId() {
            return 600;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_600");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_600");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_BD_NO_EXISTEN_REGISTROS {
        @Override
        public short getId() {
            return 601;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_601");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_601");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_BD_NO_EXISTE_USUARIO {
        @Override
        public short getId() {
            return 602;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_602");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_602");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_JAVA_NULL {
        @Override
        public short getId() {
            return 603;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_603");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_603");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_JAVA_IO {
        @Override
        public short getId() {
            return 604;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_604");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_604");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_JAVA_ARITMETICO {
        @Override
        public short getId() {
            return 605;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_605");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_605");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_JAVA_INDEX_OF_BOUND {
        @Override
        public short getId() {
            return 606;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_606");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_606");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_JAVA_FALLO_PROCESO {
        @Override
        public short getId() {
            return 607;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_607");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_607");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_BD_RELACION_INCUMPLIDA {
        @Override
        public short getId() {
            return 608;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_608");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_608");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_JAVA_PERMISO_DENEGADO {
        @Override
        public short getId() {
            return 609;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_609");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_609");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_JAVA_VALIDACION_CAMPOS_OBLIGATORIOS {
        @Override
        public short getId() {
            return 610;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_610");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_610");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_JAVA_VALIDACION_CODIGO_INTERNO_REPETIDO {
        @Override
        public short getId() {
            return 611;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_611");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_611");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }

    },
    ERROR_JAVA_ESTRUCTURA_IMPORTAR_MASIVO {
        @Override
        public short getId() {
            return 612;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_612");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_612");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_CONTENIDO_IMPORTAR_MASIVO {
        @Override
        public short getId() {
            return 613;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_613");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_613");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_FALLO_ARCHIVO {
        @Override
        public short getId() {
            return 614;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_614");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_614");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_IO_FILE {
        @Override
        public short getId() {
            return 615;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_615");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_615");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_EMAIL_REPETIDO {
        @Override
        public short getId() {
            return 616;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_616");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_616");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_CODIGO_BARRAS_REPETIDO {
        @Override
        public short getId() {
            return 617;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_617");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_617");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_BD_TRANSACCION_FALLIDA {
        @Override
        public short getId() {
            return 618;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_618");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_618");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_RECURSO_NO_CARGADO {
        @Override
        public short getId() {
            return 619;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_619");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_619");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_EXPEDIENTE_CUM_REPETIDO {
        @Override
        public short getId() {
            return 620;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_620");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_620");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_CODIGO_ASEGURADORA_REPETIDO {
        @Override
        public short getId() {
            return 621;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_621");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_621");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_CANTIDAD_DESPACHO_SUPERIOR {
        @Override
        public short getId() {
            return 622;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_622");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_622");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_ENTREGA_COMPLETA {
        @Override
        public short getId() {
            return 623;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_623");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_623");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_SIN_MEDICAMENTOS_CONTRATADOS {
        @Override
        public short getId() {
            return 624;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_624");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_624");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_PACIENTE_CONTRATO {
        @Override
        public short getId() {
            return 625;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_625");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_625");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_PROCESO_REPETIDO {
        @Override
        public short getId() {
            return 626;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_626");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_626");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_SOPORTES_OBLIGATORIOS_FALTANTES {
        @Override
        public short getId() {
            return 627;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_627");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_627");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_SERIAL_REPETIDO {
        @Override
        public short getId() {
            return 628;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_628");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_628");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALOR_FACTURA_PAGOS_INCORRECTO {
        @Override
        public short getId() {
            return 629;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_629");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_629");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_CANTIDADES_MEDICAMENTO {
        @Override
        public short getId() {
            return 630;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_630");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_630");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_USUARIO_IPS_ITERADOR_VACIO {
        @Override
        public short getId() {
            return 631;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_631");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_631");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_EXISTE_CONFIGURACION_EMPRESA {
        @Override
        public short getId() {
            return 632;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_632");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_632");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    },
    ERROR_JAVA_VALIDACION_EMAIL {
        @Override
        public short getId() {
            return 633;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_nombre_633");
        }

        @Override
        public String getMessage(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_http_mensaje_633");
        }

        @Override
        public boolean isOk() {
            return false;
        }

        @Override
        public short getIdParent() {
            return 6;
        }
    };

    @Override
    public abstract short getId();

    @Override
    public abstract String getName(String localidad);

    public abstract String getMessage(String localidad);

    public abstract boolean isOk();

    public abstract short getIdParent();

    @Override
    public EEstadoRespuestaHTTP[] getContent() {
        return EEstadoRespuestaHTTP.values();
    }

    public static EEstadoRespuestaHTTP getValue(short id) {
        for (EEstadoRespuestaHTTP e : EEstadoRespuestaHTTP.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static String getName(short id) {
        for (EEstadoRespuestaHTTP e : EEstadoRespuestaHTTP.values()) {
            if (e.getId() == id) {
                return e.getName(Util.LOCALIDAD);
            }
        }
        return null;
    }

    public static String getMessage(short id) {
        for (EEstadoRespuestaHTTP e : EEstadoRespuestaHTTP.values()) {
            if (e.getId() == id) {
                return e.getMessage(Util.LOCALIDAD);
            }
        }
        return null;
    }

    public static boolean isOk(short id) {
        for (EEstadoRespuestaHTTP e : EEstadoRespuestaHTTP.values()) {
            if (e.getId() == id) {
                return e.isOk();
            }
        }
        return true;
    }

    public static short getIdParent(short id) {
        for (EEstadoRespuestaHTTP e : EEstadoRespuestaHTTP.values()) {
            if (e.getId() == id) {
                return e.getIdParent();
            }
        }
        return 0;
    }

    public static Short getIdByValue(String name) {
        for (EEstadoRespuestaHTTP e : EEstadoRespuestaHTTP.values()) {
            if (e.getName(Util.LOCALIDAD).equals(name)) {
                return e.getId();
            }
        }
        return null;
    }
}
