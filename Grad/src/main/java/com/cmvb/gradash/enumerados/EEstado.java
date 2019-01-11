package com.cmvb.gradash.enumerados;

import com.cmvb.gradash.util.Mensaje;
import com.cmvb.gradash.util.Util;

public enum EEstado implements IEnum {

    INACTIVO {
        @Override
        public short getId() {
            return 0;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_inactivo");
        }
    },
    ACTIVO {
        @Override
        public short getId() {
            return 1;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_activo");
        }
    },
    BLOQUEADO {
        @Override
        public short getId() {
            return 1;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_estado_bloqueado");
        }
    };

    @Override
    public abstract short getId();

    @Override
    public abstract String getName(String localidad);

    @Override
    public EEstado[] getContent() {
        return EEstado.values();
    }

    public static EEstado getValue(short id) {
        for (EEstado e : EEstado.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static String getName(short id) {
        for (EEstado e : EEstado.values()) {
            if (e.getId() == id) {
                return e.getName(Util.LOCALIDAD);
            }
        }
        return null;
    }

    public static Short getIdByValue(String name) {
        for (EEstado e : EEstado.values()) {
            if (e.getName(Util.LOCALIDAD).equals(name)) {
                return e.getId();
            }
        }
        return null;
    }
}
