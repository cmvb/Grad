package com.cmvb.gradash.enumerados;

import com.cmvb.gradash.util.Mensaje;
import com.cmvb.gradash.util.Util;

public enum EMeses implements IEnum {

    ENERO {
        @Override
        public short getId() {
            return 1;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_enero");
        }
    },
    FEBRERO {
        @Override
        public short getId() {
            return 2;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_febrero");
        }
    },
    MARZO {
        @Override
        public short getId() {
            return 3;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_marzo");
        }
    },
    ABRIL {
        @Override
        public short getId() {
            return 4;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_abril");
        }
    },
    MAYO {
        @Override
        public short getId() {
            return 5;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_mayo");
        }
    },
    JUNIO {
        @Override
        public short getId() {
            return 6;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_junio");
        }
    },
    JULIO {
        @Override
        public short getId() {
            return 7;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_julio");
        }
    },
    AGOSTO {
        @Override
        public short getId() {
            return 8;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_agosto");
        }
    },
    SEPTIEMBRE {
        @Override
        public short getId() {
            return 9;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_septiembre");
        }
    },
    OCTUBRE {
        @Override
        public short getId() {
            return 10;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_octubre");
        }
    },
    NOVIEMBRE {
        @Override
        public short getId() {
            return 11;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_noviembre");
        }
    },
    DICIEMBRE {
        @Override
        public short getId() {
            return 12;
        }

        @Override
        public String getName(String localidad) {
            return Mensaje.getMensaje(localidad, "enum_meses_diciembre");
        }
    };

    @Override
    public abstract short getId();

    @Override
    public abstract String getName(String localidad);

    @Override
    public EMeses[] getContent() {
        return EMeses.values();
    }

    public static EMeses getValue(short id) {
        for (EMeses e : EMeses.values()) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public static String getName(short id) {
        for (EMeses e : EMeses.values()) {
            if (e.getId() == id) {
                return e.getName(Util.LOCALIDAD);
            }
        }
        return null;
    }

    public static Short getIdByValue(String name) {
        for (EMeses e : EMeses.values()) {
            if (e.getName(Util.LOCALIDAD).equals(name)) {
                return e.getId();
            }
        }
        return null;
    }
}
