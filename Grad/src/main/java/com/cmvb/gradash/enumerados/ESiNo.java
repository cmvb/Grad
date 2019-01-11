package com.cmvb.gradash.enumerados;

import com.cmvb.gradash.util.Mensaje;
import com.cmvb.gradash.util.Util;

public enum ESiNo implements IEnum {

    SI {
        @Override
        public short getId() {
            return 1;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_si_no_si");
        }
    },
    NO {
        @Override
        public short getId() {
            return 0;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_si_no_no");
        }
    };

    @Override
    public abstract short getId();

    @Override
    public abstract String getName(String localidad);

    @Override
    public ESiNo[] getContent() {
        return ESiNo.values();
    }

    public static ESiNo getValue(short id) {
        for (ESiNo e : ESiNo.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static String getName(short id) {
        for (ESiNo e : ESiNo.values()) {
            if (e.getId() == id) {
                return e.getName(Util.LOCALIDAD);
            }
        }
        return null;
    }

    public static Short getIdByValue(String name) {
        for (ESiNo e : ESiNo.values()) {
            if (e.getName(Util.LOCALIDAD).equals(name)) {
                return e.getId();
            }
        }
        return null;
    }
}
