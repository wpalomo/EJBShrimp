package anexos.sri.comprobantes.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;

public class EnvioComprobantesWs {

//    private static RecepcionComprobantesService service;
//    private static final String VERSION = "1.0.0";
//    public static final String ESTADO_RECIBIDA = "RECIBIDA";
//    public static final String ESTADO_DEVUELTA = "DEVUELTA";
//
//    public EnvioComprobantesWs(String wsdlLocation) throws MalformedURLException, WebServiceException {
//        URL url = new URL(wsdlLocation);
//        QName qname = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService");
//        service = new RecepcionComprobantesService(url, qname);
//    }
//
//    public RespuestaSolicitud enviarComprobante(String ruc, File xmlFile, String tipoComprobante, String versionXsd) {
//        RespuestaSolicitud response = new RespuestaSolicitud();
//        try {
//            RecepcionComprobantes port = service.getRecepcionComprobantesPort();
//            
//            ((BindingProvider) port).getRequestContext().put(
//					"com.sun.xml.internal.ws.connect.timeout", 9999);
//            ((BindingProvider) port).getRequestContext().put(
//					"com.sun.xml.internal.ws.request.timeout", 9999);
//            response = port.validarComprobante(ArchivoUtils.archivoToByte(xmlFile));
//          
//        } catch (Exception e) {
//            Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
//            response.setEstado(e.getMessage());
//            e.printStackTrace();
//        }
//        return response;
//    }
//
//    public RespuestaSolicitud enviarComprobanteLotes(String ruc, byte[] xml, String tipoComprobante, String versionXsd) {
//        RespuestaSolicitud response = new RespuestaSolicitud();
//        try {
//            RecepcionComprobantes port = service.getRecepcionComprobantesPort();
//            response = port.validarComprobante(xml);
//        } catch (Exception e) {
//            Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
//            response.setEstado(e.getMessage());
//        }
//        return response;
//    }
//
//    public RespuestaSolicitud enviarComprobanteLotes(String ruc, File xml, String tipoComprobante, String versionXsd) {
//        RespuestaSolicitud response = new RespuestaSolicitud();
//        try {
//            RecepcionComprobantes port = service.getRecepcionComprobantesPort();
//            response = port.validarComprobante(ArchivoUtils.archivoToByte(xml));
//        } catch (Exception e) {
//            Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
//            response.setEstado(e.getMessage());
//        }
//        return response;
//    }
//
//    public static RespuestaSolicitud obtenerRespuestaEnvio(File archivo, String ruc, String tipoComprobante, String claveDeAcceso, String urlWsdl) {
//        RespuestaSolicitud respuesta = new RespuestaSolicitud();
//        try {
//            EnvioComprobantesWs cliente = new EnvioComprobantesWs(urlWsdl);
//            respuesta = cliente.enviarComprobante(ruc, archivo, tipoComprobante, "1.0.0");
//        } catch (Exception ex) {
//            Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
//            respuesta.setEstado(ex.getMessage());
//        }
//        return respuesta;
//    }
//
//    public static String obtenerMensajeRespuesta(RespuestaSolicitud respuesta) {
//        StringBuilder mensajeDesplegable = new StringBuilder();
//        if (respuesta.getEstado().equals("DEVUELTA") == true) {
//            RespuestaSolicitud.Comprobantes comprobantes = respuesta.getComprobantes();
//            for (Comprobante comp : comprobantes.getComprobante()) {
//                mensajeDesplegable.append("Clave de Acceso: ").append(comp.getClaveAcceso());
//                mensajeDesplegable.append("\n");
//                for (Mensaje m : comp.getMensajes().getMensaje()) {
//                    mensajeDesplegable.append("-(CE(" + m.getIdentificador() + "): " + m.getMensaje() + ")-").append(" \n");
////           mensajeDesplegable.append("Mensaje: ").append(m.getMensaje()).append(" \n");
//                    mensajeDesplegable.append(m.getInformacionAdicional() != null ? "Información Adicional: " + m.getInformacionAdicional() : "");
//                    mensajeDesplegable.append("\n");
//                }
//                mensajeDesplegable.append("\n");
//            }
//        }
//
//        return mensajeDesplegable.toString();
//    }
//
//    public static final Object webService(String wsdlLocation) {
//        try {
//            QName qname = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService");
//            URL url = new URL(wsdlLocation);
//            service = new RecepcionComprobantesService(url, qname);
//            return null;
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(EnvioComprobantesWs.class.getName()).log(Level.SEVERE, null, ex);
//            return ex;
//        } catch (WebServiceException ws) {
//            return ws;
//        }
//    }
}
