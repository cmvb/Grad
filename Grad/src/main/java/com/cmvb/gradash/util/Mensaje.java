package com.cmvb.gradash.util;

import java.io.Serializable;
import java.util.Locale;
import java.util.ResourceBundle;

import javolution.util.FastMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Mensaje implements Serializable {

    private static final Logger LOG = LoggerFactory.getLogger(Mensaje.class);

    private static final FastMap<String, ResourceBundle> mapRb = new FastMap<String, ResourceBundle>();
    private static final String BASE_FILE = "com.info.MsjProperties";
    private static final long serialVersionUID = -3751305993431389370L;

    private Mensaje() {
    }

    /**
     *
     * Permite obtener un lbl o mensaje del properties
     *
     * @author carlos.vera
     *
     * @param idioma
     * @param label
     * @return Valor del mensaje
     */
    public static String getMensaje(String idioma, String label) {
        ResourceBundle rb;
        String value;

        rb = mapRb.get(idioma);
        if (rb == null) {
            rb = ResourceBundle.getBundle(BASE_FILE, new Locale(idioma));
            mapRb.put(idioma, rb);
        }

        value = rb.getString(label);

        return value;
    }
}
