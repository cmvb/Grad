package com.cmvb.gradash.enumerados;

import com.cmvb.gradash.util.Mensaje;
import com.cmvb.gradash.util.Util;

public enum ETipoDocumento implements IEnum {

    CC {
        @Override
        public short getId() {
            return 1;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_tipo_identificacion_cedula");
        }
    },
    TI {
        @Override
        public short getId() {
            return 2;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_tipo_identificacion_tarjeta_identididad");
        }
    };

    @Override
    public abstract short getId();

    @Override
    public abstract String getName(String localidad);

    @Override
    public ETipoDocumento[] getContent() {
        return ETipoDocumento.values();
    }

    public static ETipoDocumento getValue(short id) {
        for (ETipoDocumento e : ETipoDocumento.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static String getName(short id) {
        for (ETipoDocumento e : ETipoDocumento.values()) {
            if (e.getId() == id) {
                return e.getName(Util.LOCALIDAD);
            }
        }
        return null;
    }

    public static Short getIdByValue(String name) {
        for (ETipoDocumento e : ETipoDocumento.values()) {
            if (e.getName(Util.LOCALIDAD).equals(name)) {
                return e.getId();
            }
        }
        return null;
    }
}
