package com.cmvb.gradash.util;

import com.cmvb.gradash.enumerados.ECriterioBusqueda;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import javolution.util.FastList;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Util {

    private static final Logger LOG = LoggerFactory.getLogger(Util.class);

    public static final String CLIENT_DATE_FORMAT = "yyyy/MM/dd";
    public static final String DB_DATE_FORMAT = "yyyy/MM/dd";
    public static final String FORMAT_LETTERS = "dd 'de' MMMM 'de' yyyy";
    public static final String FORMAT_LETTERS_2 = "MMMM yyyy";
    public static final String FORMAT_DATE_TIME = "yyyy/MM/dd HH:mm";

    public static final String NOMBRE_ARCHIVO = "REPORTE";
    public static final String CODIGO_PRESTADOR = "IPS001";
    public static final String RAZON_SOCIAL = "NO SE TODAVIA";
    public static final String TIPO_IDENTIFICACION = "NIT";
    public static final String NUMERO_IDENTIFICACION = "123456789";

    public static final short REDONDEO_TIPO_FLOOR = 0;
    public static final short REDONDEO_TIPO_CEIL = 1;
    public static final short REDONDEO_TIPO_ROUND = 2;
    public static final short CHROME = 3;
    public static final short FIREFOX = 4;
    public static final short MSIE = 5;
    public static final String ERROR_DATE = "01/01/1900";
    public static final String ERROR_STRING = "*";
    public static final String ERROR_NUMERO = "-1";
    public static boolean descargaExterna = false;
    public static String descargaUrl = null;
    public static String descargaUrlMenu = null;
    public static String descargaRuta = null;
    public static String descargaLogo = null;
    public static String descargaReporte = null;
    public static String cargaArchivos = null;

    public static String PREFIJO_FORMULARIO = null;

    public static String CORREO_SERVER = "";
    public static String CORREO_USUARIO = "";
    public static String CORREO_PASSWORD = "";
    public static String CORREO_PUERTO = "";
    public static String CORREO_PROTOCOLO = "";
    public static String CORREO_FROM = "Administrador_CTA";
    public static String CONTEXTO_WEB = "ips";

    // Carpetas para descarga
    public static final String CARPETA_TEMPORAL = "temporal/";
    public static final String CARPETA_PATOLOGO_FIRMA = "patologo_firma/";

    public static final int CANTIDAD_SUBLISTA = 400;
    public static final String DIVISOR_TEXTO = ";";
    public static boolean validarFechasHoy = true;
    public static boolean validarRangoEdad = true;
    public static String routeApplicationsResource;

    public static final int NRO_CAMPOS_LOW = 30;
    public static final int NRO_CAMPOS_HIGH = 41;
    public static String prefijoErrorBase = "@BD";
    public static final int SALIDA_WHILE = 10000;

    public static final String CHAR_SET = "ISO-8859-1";
    public static final String LOCALIDAD = "es";

    public static final int MAX_ROW_AUTOCOMPLETE = 100;
    public static final int MAX_RESULT = 500;

    public static String MAXIMO_TAMANO_ARCHIVO = "20000000";

    public static Properties props = new Properties();

    public static final boolean TEST_NG = false;

    public static final int MAXIMO_REGISTRO_MASIVAS = 1000;

    public static final int DIAS_SEMANA = 7;

    public static final int LICENCIA_INICIAL = 90;
    public static final int LICENCIA_PRORROGA = 180;

    public static final String RUTA_IMAGEN_PERFIL = "../assets/img/faces/";
    public static final String NOMBRE_IMAGEN_PERFIL_DEFAULT = "profile.png";
    public static final String RUTA_SRC_PROYECTO = "/home/system/creandosoft/software/ProyectosOxygen/ipsAngular/src/";
    public static final String RUTA_ENTREGA_SOPORTES = "/home/system/creandosoft/software/ProyectosOxygen/ips_presentacion/src/main/webapp/ips_descargas/entrega_soporte/";
    public static final String RUTA_PERFILES_IMG_FACES = "assets/img/faces/";
    public static final String RUTA_TEMPLATES = "assets/templates/";
    public static final String RUTA_TEMPLATES_CORREO_RESTAURAR_CLAVE = "assets/templates/correo_restaurar_clave.html";
    public static final String RUTA_FORM_RESET_PASS = "http://localhost:4200/ipsResetPass";
    public static final short ANIO_ACTUAL = 2018;
    public static final String RUTA_ENTREGAS_PDF = "entregas/";

    private Util() {
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    /**
     *
     * Metodo que permite convertir un arreglo de bytes en un archivo
     *
     * @author carlos.vera
     *
     * @param vectorBytes
     * @param rutaArchivo
     * @return
     *
     */
    public static boolean convertirBytesAFile(byte[] vectorBytes, String rutaArchivo) {
        boolean resultado = true;
        try {
            File f = new File(rutaArchivo);
            try (OutputStream salida = new FileOutputStream(f)) {
                salida.write(vectorBytes, 0, vectorBytes.length);
            }
            File existe = new File(rutaArchivo);
            if (!existe.exists()) {
                LOG.error(rutaArchivo + "****");
                return false;
            }
        } catch (IOException e) {
            resultado = false;
            LOG.error(e.getMessage());
        }
        return resultado;
    }

    /**
     *
     * Metodo que permite descargar un archivo alojado en el servidor
     *
     * @author carlos.vera
     *
     * @param archivo
     * @param ruta
     * @param nombre
     *
     */
    public static void descargarArchivo(InputStream archivo, String ruta, String nombre) {
        FacesContext faces = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
        OutputStream output = null;
        try {
            response.reset();
            response.setContentType("application/download");
            response.setCharacterEncoding("ISO-8859-1");
            response.setHeader("Content-Disposition", "attachment;filename=" + nombre);
            int read;
            byte[] bytes = new byte[1024];
            output = response.getOutputStream();
            if (archivo == null) {
                archivo = convertirFileAStream(ruta);
            }
            if (archivo != null) {
                while ((read = archivo.read(bytes)) != -1) {
                    output.write(bytes, 0, read);
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
            faces.responseComplete();
        }
    }

    /**
     *
     * Metodo que permite conocer si una cadena es nula o vacia
     *
     * @author carlos.vera
     *
     * @param cadena
     * @return
     */
    public static boolean esVacio(String cadena) {
        if (cadena == null) {
            return true;
        } else {
            return cadena.length() == 0 || cadena.equals("null") || StringUtils.isBlank(cadena) || StringUtils.isEmpty(cadena);
        }
    }

    /**
     *
     * Metodo que retorna objecto Date de la Fecha Actual
     *
     * @autor carlos.vera
     *
     * @return Date
     */
    public static Date getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            LOG.error(e.getMessage());
        }
        return date;
    }

    /**
     *
     * Metodo que retorna objecto Date(+Time) de la Fecha Actual
     *
     * @autor carlos.vera
     *
     * @return DateTime
     */
    public static Date getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(sdf.format(new Date()));
        } catch (ParseException e) {
            LOG.error(e.getMessage());
        }
        return date;
    }

    /**
     *
     * Transforma un parametro para busqueda en la base
     *
     * @author carlos.vera
     *
     * @param texto
     * @param criterio
     * @return
     */
    public static String incluirCriterio(String texto, ECriterioBusqueda criterio) {
        if (esVacio(texto)) {
            return "%";
        }
        switch (criterio) {
            case START:
                return "%" + texto.toUpperCase();
            case END:
                return texto.toUpperCase() + "%";
            case ANYWHERE:
                return "%" + texto.toUpperCase() + "%";
            default:
                return texto.toUpperCase();
        }
    }

    /**
     *
     * Registra infos al contexto de JSF
     *
     * @author carlos.vera
     *
     * @param id
     * @param mensaje
     */
    public static void logInfosById(String id, String mensaje) {
        showLogs(id, mensaje, FacesMessage.SEVERITY_INFO);
    }

    /**
     *
     * Registra warnings al contexto de JSF
     *
     * @author carlos.vera
     *
     * @param id
     * @param mensaje
     */
    public static void logWarningsById(String id, String mensaje) {
        showLogs(id, mensaje, FacesMessage.SEVERITY_WARN);
    }

    /**
     *
     * Registra errores al contexto de JSF
     *
     * @author carlos.vera
     *
     * @param id
     * @param mensaje
     */
    public static void logErrorsById(String id, String mensaje) {
        showLogs(id, mensaje, FacesMessage.SEVERITY_ERROR);
    }

    /**
     *
     * Permite registrar los errores dada una severidad
     *
     * @author carlos.vera
     *
     * @param id
     * @param mensaje
     * @param severidad
     */
    private static void showLogs(String id, String mensaje, Severity severidad) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(severidad, id, mensaje));
    }

    /**
     *
     * Permite registrar los errores dada una severidad (Cliente)
     *
     * @author carlos.vera
     *
     * @param idClient
     * @param id
     * @param mensaje
     * @param severidad
     */
    public static void showLogsCliente(String idClient, String id, String mensaje, Severity severidad) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(idClient, new FacesMessage(severidad, id, mensaje));
    }

    /**
     *
     * Convierte una cadena a --> (true=MD5; false=SHA)
     *
     * @author carlos.vera
     *
     * @param texto
     * @param tipo
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String getEncriptado(String texto, boolean tipo) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String tipoEnctriptado = tipo ? "SHA" : "MD5";
        if (tipoEnctriptado.equals("MD5")) {
            return getMD5(texto);
        }
        if (tipoEnctriptado.equals("SHA")) {
            return getSHA256(texto);
        }

        return texto;
    }

    /**
     *
     * Codificar MD5
     *
     * @author carlos.vera
     *
     * @param texto
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static String getMD5(String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        return hex(md.digest(texto.getBytes("CP1252")));
    }

    /**
     *
     * Codificar SHA256
     *
     * @author carlos.vera
     *
     * @param texto
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    private static String getSHA256(String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        String inicialComodin = "%&3*,";
        String finComodin = "@$#)?¿";

        String text = inicialComodin + texto + finComodin;
        md.update(text.getBytes("UTF-8"));
        byte[] digest = md.digest();
        String a = String.format("%064x", new java.math.BigInteger(1, digest));

        return a;
    }

    /**
     *
     * Traduce byte a Hexadecimales
     *
     * @author carlos.vera
     *
     * @param array
     * @return
     */
    private static String hex(byte[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; ++i) {
            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }

    /**
     *
     * Devuelve la fecha actual en formato timestamp
     *
     * @author carlos.vera
     *
     * @return
     */
    public static String getTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
        Date now = new Date();
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-05"));
        return sdf.format(now);
    }

    /**
     *
     * Metodo que permite exportar una lista de String
     *
     * @author carlos.vera
     *
     * @param contenido
     * @param nombre
     * @param extension
     */
    public static void exportarByExtension(FastList<String> contenido, String nombre, String extension) {
        FacesContext faces = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
        String enter = "\r\n";
        OutputStream output = null;
        String encoding = "ISO-8859-1";
        try {
            response.reset();
            response.setContentType("application/download");
            response.setCharacterEncoding(encoding);
            response.setHeader("Content-Disposition", "attachment;filename=" + nombre + extension);
            StringBuilder buffer = new StringBuilder();
            for (String c : contenido) {
                buffer.append(c).append(enter);
            }
            output = response.getOutputStream();
            output.write(buffer.toString().getBytes(Charset.forName(encoding)));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        } finally {

            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
            faces.responseComplete();
        }
    }

    /**
     * Arma la ruta para descargar un archivo
     *
     * @author carlos.vera
     * @param archivo
     * @return
     */
    public static String getRutaDescarga(String archivo) {
        return Util.descargaRuta + "/" + archivo;

    }

    /**
     * Arma la ruta para cargar un archivo
     *
     * @author carlos.vera
     * @param archivo
     * @return
     */
    public static String getRutaCargaArhivos(String archivo) {
        return Util.descargaRuta + "/" + archivo;

    }

    /**
     *
     * Metodo que evalua si el texto es letra
     *
     * @autor carlos.vera
     *
     * @param texto
     * @return
     */
    public static boolean esLetra(String texto) {
        return Pattern.matches("A-Za-z", texto);
    }

    /**
     *
     * Metodo que evalua si el texto es letra o numero
     *
     * @autor carlos.vera
     *
     * @param texto
     * @return
     */
    public static boolean esLetraONumero(String texto) {
        return Pattern.matches("A-Za-z0-9", texto);
    }

    /**
     *
     * Metodo que evalua si el texto es numero
     *
     * @autor carlos.vera
     *
     * @param texto
     * @return
     */
    public static boolean esNumero(String texto) {
        return Pattern.matches("0-9", texto);
    }

    /**
     *
     * Metodo que devuelve un valor redondeado de un número decimal
     *
     * @autor carlos.vera
     *
     * @param numero
     * @param decimales
     * @param modoRedondeo
     * @return
     */
    public static double redondear(double numero, double decimales, short modoRedondeo) {
        double resultado = 0d;
        double potencia = Math.pow(10, decimales);
        if (modoRedondeo == REDONDEO_TIPO_FLOOR) {
            resultado = Math.floor(numero * potencia) / potencia;
        }
        if (modoRedondeo == REDONDEO_TIPO_CEIL) {
            resultado = Math.ceil(numero * potencia) / potencia;
        }
        if (modoRedondeo == REDONDEO_TIPO_ROUND) {
            resultado = Math.round(numero * potencia) / potencia;
        }
        return resultado;
    }

    /**
     *
     * Dada una fecha, retorna el calendar de dicha fecha
     *
     * @author carlos.vera
     *
     * @param fecha
     * @return
     */
    public static Calendar getCalendarByDate(Date fecha) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);

        return c;
    }

    /**
     *
     * Metodo que permite convertir un stream en un archivo
     *
     * @author carlos.vera
     *
     * @param stream
     * @param rutaArchivo
     * @return
     *
     */
    public static boolean convertirStreamAFile(InputStream stream, String rutaArchivo) {
        boolean resultado = true;
        try {
            File f = new File(rutaArchivo);
            try (OutputStream salida = new FileOutputStream(f)) {
                byte[] buf = new byte[1024];
                int len;
                while ((len = stream.read(buf)) > 0) {
                    salida.write(buf, 0, len);
                }
            }
            stream.close();
            File existe = new File(rutaArchivo);
            if (!existe.exists()) {
                LOG.error(rutaArchivo + "****");
                return false;
            }
        } catch (IOException e) {
            resultado = false;
            LOG.error(e.getMessage(), e);
        }
        return resultado;
    }

    /**
     *
     * Metodo que permite convertir un archivo en un stream
     *
     * @author carlos.vera
     *
     * @param rutaArchivo
     * @return
     *
     */
    public static InputStream convertirFileAStream(String rutaArchivo) {
        InputStream resultado = null;
        try {
            resultado = new FileInputStream(new File(rutaArchivo));
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        return resultado;
    }

    /**
     * Metodo que permite retornar una lista que contiene listas
     *
     * @param <T>
     * @param lista
     * @param longitud
     * @return
     *
     * @author carlos.vera
     */
    public static <T extends Object> List<List<T>> getSubLista(Set<T> lista, int longitud) {
        List<T> listaInterna = new ArrayList<>();
        listaInterna.addAll(lista);

        List<List<T>> resultado = new ArrayList<>();
        int size = listaInterna.size();
        int inicio = 0;
        int fin = 0;
        boolean salir = false;

        if (longitud >= size) {
            if (!listaInterna.isEmpty()) {
                resultado.add(listaInterna);
            }

            return resultado;
        }

        salir = false;
        while (!salir) {
            fin = inicio + longitud;
            resultado.add(listaInterna.subList(inicio, fin));

            inicio = fin;
            fin = fin + longitud;
            if (fin >= size) {
                fin = size;
                resultado.add(listaInterna.subList(inicio, fin));
                salir = true;
            }
        }

        return resultado;
    }

    /**
     * Metodo que permite eliminar un archivo del servidor
     *
     * @author carlos.vera
     * @param rutaArchivo
     */
    public static void eliminarArchivo(String rutaArchivo) {
        File f = new File(rutaArchivo);
        if (f.exists()) {
            f.delete();
        }
    }

    /**
     * Metodo para comprimir un archivo o carpeta dada su ruta
     *
     * @author carlos.vera
     * @param fileName
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void comprimirEnZip(String fileName) throws IOException, FileNotFoundException {
        ZipOutputStream zos;

        File file = new File(fileName);
        zos = new ZipOutputStream(new FileOutputStream(file + ".zip"));
        comprimirRecursivo(file, zos);

        zos.close();
    }

    /**
     * Metodo recursivo para comprimir los archivos internos de una carpeta
     *
     * @author carlos.vera
     * @param file
     * @param zos
     * @throws IOException
     * @throws FileNotFoundException
     */
    private static void comprimirRecursivo(File file, ZipOutputStream zos) throws IOException, FileNotFoundException {
        if (file.isDirectory()) {
            String[] fileNames = file.list();

            if (fileNames != null) {
                for (String fileName : fileNames) {
                    comprimirRecursivo(new File(file, fileName), zos);
                }
            }
        } else {
            byte[] buf = new byte[1024];
            int len;

            ZipEntry zipEntry = new ZipEntry(file.toString());

            FileInputStream fin = new FileInputStream(file);
            try (BufferedInputStream in = new BufferedInputStream(fin)) {
                zos.putNextEntry(zipEntry);

                while ((len = in.read(buf)) >= 0) {
                    zos.write(buf, 0, len);
                }
            }
            zos.closeEntry();
        }
    }

    /**
     * Metodo que copia un archivo de una ruta a otra
     *
     * @author carlos.vera
     * @param sourceFile
     * @param destFile
     * @throws IOException
     */
    @SuppressWarnings("empty-statement")
    public static void copiarArchivo(File sourceFile, File destFile) throws IOException {
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        FileChannel origen = null;
        FileChannel destino = null;
        try {
            origen = new FileInputStream(sourceFile).getChannel();
            destino = new FileOutputStream(destFile).getChannel();

            long count = 0;
            long size = origen.size();
            while ((count += destino.transferFrom(origen, count, size - count)) < size)
        ;
        } finally {
            if (origen != null) {
                origen.close();
            }
            if (destino != null) {
                destino.close();
            }
        }
    }

    /**
     * Metodo que verifica la estructura de un correo
     *
     * @author carlos.vera
     * @param correo
     * @return
     */
    public static boolean esCorreo(String correo) {
        try {
            if (esVacio(correo)) {
                return true;
            }
            Pattern pat = null;
            Matcher mat = null;
            String email = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            pat = Pattern.compile(email);
            mat = pat.matcher(correo);
            return mat.find();
        } catch (Exception ex) {
            LOG.error(ex.getMessage());
            return false;
        }
    }

    /**
     * Metodo que devuelve el nombre de un mes dado su numero (1-12)
     *
     * @author carlos.vera
     * @param mes
     * @return
     */
    public static String traduceMes(int mes) {
        String strMes = "";
        switch (mes) {
            case 1:
                strMes = "Enero";
                break;
            case 2:
                strMes = "Febrero";
                break;
            case 3:
                strMes = "Marzo";
                break;
            case 4:
                strMes = "Abril";
                break;
            case 5:
                strMes = "Mayo";
                break;
            case 6:
                strMes = "Junio";
                break;
            case 7:
                strMes = "Julio";
                break;
            case 8:
                strMes = "Agosto";
                break;
            case 9:
                strMes = "Septiembre";
                break;
            case 10:
                strMes = "Octubre";
                break;
            case 11:
                strMes = "Noviembre";
                break;
            case 12:
                strMes = "Diciembre";
                break;
        }
        return strMes;
    }

    /**
     * Metodo que devuelve el contenido de un archivo en un String
     *
     * @author carlos.vera
     * @param rutaArchivo
     * @return
     * @throws java.io.FileNotFoundException
     */
    public static String getStringOfFile(String rutaArchivo) throws FileNotFoundException, IOException {
        String texto = "";
        FileReader f = new FileReader(rutaArchivo);
        try (BufferedReader b = new BufferedReader(f)) {
            String cadena;
            while ((cadena = b.readLine()) != null) {
                texto = texto + cadena;
            }
        }

        return texto;
    }

    /**
     * Metodo que devuelve el arreglo de bytes de un objeto Stringbuilder
     *
     * @author carlos.vera
     * @param builder
     * @return
     * @throws java.nio.charset.CharacterCodingException
     */
    public static byte[] getbytes(StringBuilder builder) throws CharacterCodingException {

        Charset charset = StandardCharsets.UTF_8;
        CharsetEncoder encoder = charset.newEncoder();

        CharBuffer buffer = CharBuffer.wrap(builder);

        ByteBuffer bytes = encoder.encode(buffer);
        byte[] array;
        int arrayLen = bytes.limit();
        if (arrayLen == bytes.capacity()) {
            array = bytes.array();
        } else {
            array = new byte[arrayLen];
            bytes.get(array);
        }

        return array;
    }

    /**
     * almacena llave - valor en el mapa de sesión
     *
     * @param llave
     * @param valor
     */
    public static void addAtributoSesion(String llave, Object valor) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(llave, valor);

    }

    /**
     * recupera el valor de la llave en el mapa de sesión
     *
     * @param llave
     * @return
     */
    public static Object getAtributoSesion(String llave) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(llave) == null ? "" : FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(llave);
    }

}
