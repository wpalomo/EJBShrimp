package anexos.sri.comprobantes.util;

//ec/gob/sri/comprobantes/ws/aut/AutorizacionComprobantesService
import anexos.sri.ws.autorizacion.*;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

public class AutorizacionComprobantesWs {

    static File comprobanteFactura = null;
    private AutorizacionComprobantesService service;
    public static final String ESTADO_AUTORIZADO = "AUTORIZADO";
    public static final String ESTADO_NO_AUTORIZADO = "NO AUTORIZADO";

    public AutorizacionComprobantesWs(String wsdlLocation) throws Exception {
        System.out.println("\n\n<<<<<<<<<<<<<<<<<<AutorizacionComprobantesWs>>>>>>>>>>>>><");
        System.out.println("wsdlLocation   :   " + wsdlLocation);
        //wsdlLocation = "https://celcer.sri.gob.ec/comprobantes-electronicos-ws/AutorizacionComprobantes?wsdl";
        System.out.println("\n\nwsdlLocation  :" + wsdlLocation);
        try {

            System.out.println("111");
            this.service = new AutorizacionComprobantesService(new URL(wsdlLocation), new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService"));
//          this.service = new AutorizacionComprobantesService(new URL(wsdlLocation), new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService"));
            System.out.println("222");
            System.out.println("puerto   " + service.getAutorizacionComprobantesPort());
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }

    public AutorizacionComprobantesWs() {
    }

    private static void certificadoSeguridadSRI() {
        //String rutaCertificado = ambiente ? getRutaCertificadoSeguridadSRIProduccion() : getRutaCertificadoSeguridadSRIPruebas();
//		System.setProperty("javax.net.ssl.keyStore", "/opt/development/jdk1.6.0_25/jre/lib/security/cacerts");
//		System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
//		System.setProperty("javax.net.ssl.trustStore", "/opt/development/jdk1.6.0_25/jre/lib/security/cacerts");
//		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        /*
         * System.setProperty("javax.net.ssl.keyStore",
         * "/home/developer1/glassfish/domains/domain1/config");
         * System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
         * System.setProperty("javax.net.ssl.trustStore",
         * "/home/developer1/glassfish/domains/domain1/config");
         * System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
         */
//		System.setProperty("javax.net.ssl.keyStore", "/etc/ssl/certs/java/cacert");
//		System.setProperty("javax.net.ssl.keyStorePassword", "changeit");
//		System.setProperty("javax.net.ssl.trustStore", "/etc/ssl/certs/java/cacert");
//		System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
//                System.out.println("8888888888888888888888888888888888888");
    }

    public RespuestaComprobante autorizacionComprobante(String claveAccesoComprobante, String wsdlLocation) {
        try {
            certificadoSeguridadSRI();
            AutorizacionComprobantesService service = new AutorizacionComprobantesService(new URL(wsdlLocation), new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService"));
            AutorizacionComprobantes port = service.getAutorizacionComprobantesPort();
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 9999);
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 9999);
            return port.autorizacionComprobante(claveAccesoComprobante);
        } catch (MalformedURLException ex) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public RespuestaComprobante llamadaWSAutorizacionInd(String claveDeAcceso) {
        try {
            AutorizacionComprobantes port = this.service.getAutorizacionComprobantesPort();
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 9999);
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 9999);
            return port.autorizacionComprobante(claveDeAcceso);
        } catch (Exception e) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public RespuestaLote llamadaWsAutorizacionLote(String claveDeAcceso) {
        try {
            AutorizacionComprobantes port = this.service.getAutorizacionComprobantesPort();
            return port.autorizacionComprobanteLote(claveDeAcceso);
        } catch (Exception e) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

//    public static String autorizarComprobanteIndividual(
//            String claveDeAcceso,
//            String nombreArchivo,
//            String tipoAmbiente,
//            String empCodigo,
//            SisPckeystoreTO sisPckeystoreTO,
//            SisInfoTO sisInfoTO,
//            anxUrlWebServicesTO anxUrlWebServicesTO) {
//        StringBuilder mensaje = new StringBuilder();
//        try {
//            String dirAutorizados = "tmp/comprobantesAutorizados";
//            String dirNoAutorizados = "tmp/comprobantesNoAutorizados";
//            RespuestaComprobante respuesta = null;
//            for (int i = 0; i < 5; i++) {
//                respuesta = new AutorizacionComprobantesWs(
//                        FormGenerales.devuelveUrlWs(
//                        tipoAmbiente, 
//                        "AutorizacionComprobantes", 
//                        sisPckeystoreTO,
//                        anxUrlWebServicesTO), 
//                        sisInfoTO).llamadaWSAutorizacionInd(claveDeAcceso);
//                if (!respuesta.getAutorizaciones().getAutorizacion().isEmpty()) {
//                    break;
//                }
//                Thread.currentThread();
//                Thread.sleep(300L);
//            }
//            int i;
//            if (respuesta != null) {
//                i = 0;
//                for (Autorizacion item : respuesta.getAutorizaciones().getAutorizacion()) {
//                    mensaje.append(item.getEstado());
//                    item.setComprobante("<![CDATA[" + item.getComprobante() + "]]>");
//                    XStream xstream = XStreamUtil.getRespuestaXStream();
//                    Writer writer = null;
//                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                    writer = new OutputStreamWriter(outputStream, "UTF-8");
//                    writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//
//                    xstream.toXML(item, writer);
//                    String xmlAutorizacion = outputStream.toString("UTF-8");
//                    if ((i == 0) && (item.getEstado().equals("AUTORIZADO"))) {
//                        comprobanteFactura = ArchivoUtils.stringToArchivo(dirAutorizados + File.separator + nombreArchivo, xmlAutorizacion);
//                        break;
//                    }
//                    if (item.getEstado().equals("NO AUTORIZADO")) {
//                        mensaje.append("|" + obtieneMensajesAutorizacion(item));
//                        verificarOCSP(item);
//                        break;
//                    }
//                    i++;
//                }
//            }
//            if ((respuesta == null) || (respuesta.getAutorizaciones().getAutorizacion().isEmpty() == true)) {
//                mensaje.append("TRANSMITIDO SIN RESPUESTA|Ha ocurrido un error en el proceso de la Autorización, por lo que se traslado el archivo a la carpeta de: transmitidosSinRespuesta");
//
//            }
//        } catch (Exception e) {
//             e.printStackTrace();
//        }
//        return mensaje.toString();
//    }
//
//    public static String descargarAutorizarComprobanteIndividual(
//            String claveDeAcceso,
//            String nombreArchivo,
//            String tipoAmbiente,
//            String empCodigo,
//            sistema.TO.SisPckeystoreTO sisPckeystoreTO,
//            sistema.TO.SisInfoTO sisInfoTO,
//             anxUrlWebServicesTO anxUrlWebServicesTO) {
//        StringBuilder mensaje = new StringBuilder();
//        try {
//            String dirAutorizados = "tmp/comprobantesAutorizados";
//            RespuestaComprobante respuesta = null;
//            for (int i = 0; i < 5; i++) {
//                respuesta = new AutorizacionComprobantesWs(
//                        FormGenerales.devuelveUrlWs(
//                        tipoAmbiente, 
//                        "AutorizacionComprobantes", 
//                        sisPckeystoreTO,
//                        anxUrlWebServicesTO), 
//                        sisInfoTO).llamadaWSAutorizacionInd(claveDeAcceso);
//                if (!respuesta.getAutorizaciones().getAutorizacion().isEmpty()) {
//                    break;
//                }
//                Thread.currentThread();
//                Thread.sleep(300L);
//            }
//            int i;
//            if (respuesta != null) {
//                i = 0;
//                for (Autorizacion item : respuesta.getAutorizaciones().getAutorizacion()) {
//                    if (item.getEstado().equals("AUTORIZADO")) {
//                        mensaje.append(item.getEstado());
//                        item.setComprobante("<![CDATA[" + item.getComprobante() + "]]>");
//                        XStream xstream = XStreamUtil.getRespuestaXStream();
//                        Writer writer = null;
//                        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                        writer = new OutputStreamWriter(outputStream, "UTF-8");
//                        writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//                        xstream.toXML(item, writer);
//                        String xmlAutorizacion = outputStream.toString("UTF-8");
//                        comprobanteFactura = ArchivoUtils.stringToArchivo(dirAutorizados + File.separator + nombreArchivo, xmlAutorizacion);
//                        break;
//                    }
//                }
//            }
//            if ((respuesta == null) || (respuesta.getAutorizaciones().getAutorizacion().isEmpty() == true)) {
//                mensaje.append("TRANSMITIDO SIN RESPUESTA|Ha ocurrido un error en el proceso de la Autorización, por lo que se traslado el archivo a la carpeta de: transmitidosSinRespuesta");
//            }
//        } catch (Exception e) {
//             e.printStackTrace();
//        }
//        return mensaje.toString();
//    }
    public static String obtieneMensajesAutorizacion(Autorizacion autorizacion) {
        StringBuilder mensaje = new StringBuilder();
        int cont = 0;
        for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
            if (m.getInformacionAdicional() != null) {
                mensaje.append("-(CE(" + m.getIdentificador() + "): " + m.getMensaje() + ")-");
                mensaje.append("\n" + m.getInformacionAdicional());
                cont++;
//         mensaje.append("\n" + m.getMensaje() + ": " + m.getInformacionAdicional());
            } else {
                if (cont == 0) {
                    mensaje.append("\n-(CE(" + m.getIdentificador() + "): " + m.getMensaje() + ")-");
                } else {
                    mensaje.append("\n" + m.getMensaje());
                }
                cont++;

            }
        }

        return mensaje.toString();
    }

    public static boolean verificarOCSP(Autorizacion autorizacion)
            throws SQLException, ClassNotFoundException {
        boolean respuesta = true;

        for (Mensaje m : autorizacion.getMensajes().getMensaje()) {
            if (m.getIdentificador().equals("61")) {
                int i = JOptionPane.showConfirmDialog(null, "No se puede validar el certificado digital.\n Desea emitir en contingencia?", "Advertencia", 0);
                if (i == 0) {
                }
                respuesta = false;
            }
        }
        return respuesta;
    }
}
