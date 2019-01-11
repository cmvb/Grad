package com.cmvb.gradash.enumerados;

import com.cmvb.gradash.util.Mensaje;
import com.cmvb.gradash.util.Util;

public enum ESexo implements IEnum {

    MASCULINO {
        @Override
        public short getId() {
            return 1;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_sexo_masculino");
        }

        @Override
        public boolean isEditable() {
            return false;
        }
    },
    FEMENINO {
        @Override
        public short getId() {
            return 2;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_sexo_femenino");
        }

        @Override
        public boolean isEditable() {
            return true;
        }
    },
    AMBOS {
        @Override
        public short getId() {
            return 3;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_sexo_ambos");
        }

        @Override
        public boolean isEditable() {
            return true;
        }
    };

    public abstract boolean isEditable();

    @Override
    public abstract short getId();

    @Override
    public abstract String getName(String localidad);

    @Override
    public ESexo[] getContent() {
        return ESexo.values();
    }

    public static ESexo getValue(short id) {
        for (ESexo e : ESexo.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static String getName(short id) {
        for (ESexo e : ESexo.values()) {
            if (e.getId() == id) {
                return e.getName(Util.LOCALIDAD);
            }
        }
        return null;
    }

    @Deprecated
    public static String Name(short id) {
        for (ESexo e : ESexo.values()) {
            if (e.getId() == id) {
                return e.getName(Util.LOCALIDAD);
            }
        }
        return null;
    }

    public static boolean isEditable(short id) {
        for (ESexo e : ESexo.values()) {
            if (e.getId() == id) {
                return e.isEditable();
            }
        }
        return true;
    }

    public static Short getIdByValue(String name) {
        for (ESexo e : ESexo.values()) {
            if (e.getName(Util.LOCALIDAD).equals(name)) {
                return e.getId();
            }
        }
        return null;
    }
}
