package anexos.sri.comprobantes.util;

import anexos.TO.anxUrlWebServicesTO;
import anexos.sri.ws.autorizacion.AutorizacionComprobantes;
import anexos.sri.ws.autorizacion.AutorizacionComprobantesService;
import anexos.sri.ws.autorizacion.RespuestaComprobante;
import anexos.sri.ws.autorizacion.RespuestaLote;
import anexos.sri.ws.recepcion.RecepcionComprobantes;
import anexos.sri.ws.recepcion.RecepcionComprobantesService;
import anexos.sri.ws.recepcion.RespuestaSolicitud;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceException;
import sistema.TO.SisPckeystoreTO;
//import anexos.sri.recepcion.RecepcionComprobantes;
//import anexos.sri.recepcion.RecepcionComprobantesService;
//import anexos.sri.recepcion.RespuestaSolicitud;

public class UtilsWebService {

    private static String serviceUrlWS = "";
    private static String rutaKeystore = "";
    private static String passwordKeystore = "";

//    private static boolean ambiente = parametro.getTipoAmbiente();
//    private static String rWS = "http://" + parametro.getWsBucket() + "/redepronikWS/";
//	public static void almacenamiento(String nombreArchivo, File xml, File ride) {
//		RestTemplate restTemplate = new RestTemplate();
//		MultiValueMap<String, Object> map = new LinkedMultiValueMap<String, Object>();
//		map.add("userAwsS3", parametro.getUserAwsS3());
//		map.add("passAwsS3", parametro.getPassAwsS3());
//		map.add("bucketAwsS3", parametro.getBucketAwsS3());
//		map.add("nombreArchivo", nombreArchivo);
//		map.add("xml", new FileSystemResource(xml));
//		map.add("ride", new FileSystemResource(ride));
//
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Content-Type", "multipart/form-data");
//		headers.set("Accept", "text/plain");
//
//		restTemplate.exchange(redepronikWS + "almacenamiento", HttpMethod.POST, new HttpEntity<MultiValueMap<String, Object>>(map, headers),
//				String.class);
//	}
//	public static Date fechaCorte(String ruc) {
//		RestTemplate restTemplate = new RestTemplate();
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("ruc", ruc);
//		String respuesta = restTemplate.getForObject(redepronikWS + "fechaCorte?ruc={ruc}", String.class, map);
//		return fechaFormatoCorte(respuesta);
//	}
    public static void devuelveUrlWs(String tipoAmbiente, String nombreServicio, anxUrlWebServicesTO anxUrlWebServicesTO, SisPckeystoreTO sisPckeystoreTO) {
        if (anxUrlWebServicesTO != null) {
            StringBuilder url = new StringBuilder();
            String direccionIPServicio = null;
            rutaKeystore = sisPckeystoreTO.getInfKeystoreRuta();
            passwordKeystore = sisPckeystoreTO.getInfKeystorePassword();

            if (anxUrlWebServicesTO != null) {
                direccionIPServicio = tipoAmbiente.equals(TipoAmbienteEnum.PRODUCCION.getCode()) ? anxUrlWebServicesTO.getUrlAmbienteProduccion() : anxUrlWebServicesTO.getUrlAmbientePruebas();
                url.append(direccionIPServicio);
                url.append("/comprobantes-electronicos-ws/");
                url.append(nombreServicio);
                url.append("?wsdl");
                serviceUrlWS = url.toString();
            }
        }

    }

    public static RespuestaComprobante autorizacionComprobante(String claveAccesoComprobante) {
        try {
            certificadoSeguridadSRI();
            AutorizacionComprobantesService service = new AutorizacionComprobantesService(new URL(serviceUrlWS),
                    new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService"));
            AutorizacionComprobantes port = service.getAutorizacionComprobantesPort();
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 9999);
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 9999);
            return port.autorizacionComprobante(claveAccesoComprobante);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RespuestaLote autorizacionComprobanteLote(String claveAccesoLote) {
        try {
            certificadoSeguridadSRI();
            AutorizacionComprobantesService service = new AutorizacionComprobantesService(new URL(serviceUrlWS),
                    new QName("http://ec.gob.sri.ws.autorizacion", "AutorizacionComprobantesService"));
            AutorizacionComprobantes port = service.getAutorizacionComprobantesPort();
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 9999);
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 9999);
            return port.autorizacionComprobanteLote(claveAccesoLote);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void certificadoSeguridadSRI() {
        System.setProperty("javax.net.ssl.keyStore", rutaKeystore);
        System.setProperty("javax.net.ssl.keyStorePassword", passwordKeystore);
        System.setProperty("javax.net.ssl.trustStore", rutaKeystore);
        System.setProperty("javax.net.ssl.trustStorePassword", passwordKeystore);
    }

    public static RespuestaSolicitud validarComprobante(byte[] xml) {
        try {
            certificadoSeguridadSRI();
            RecepcionComprobantesService service = new RecepcionComprobantesService(new URL(serviceUrlWS), new QName(
                    "http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService"));
            RecepcionComprobantes port = service.getRecepcionComprobantesPort();
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.connect.timeout", 9999);
            ((BindingProvider) port).getRequestContext().put("com.sun.xml.internal.ws.request.timeout", 9999);
            return port.validarComprobante(xml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /////////////////////////////////////////////////////
    public static boolean existConnection(String tipoAmbiente, String nombreServicio, anxUrlWebServicesTO anxUrlWebServicesTO, sistema.TO.SisPckeystoreTO sisPckeystoreTO) {

        devuelveUrlWs(tipoAmbiente, nombreServicio, anxUrlWebServicesTO, sisPckeystoreTO);
        int i = 0;
        boolean respuesta = false;
        while (i < 3) {
            Object c = webService(serviceUrlWS);
            if (c == null) {
                respuesta = true;
                break;
            }
            if ((c instanceof WebServiceException)) {
                respuesta = false;
            }
            i++;
        }
        return respuesta;
    }

    public static final Object webService(String wsdlLocation) {
        try {
            QName qname = new QName("http://ec.gob.sri.ws.recepcion", "RecepcionComprobantesService");
            URL url = new URL(wsdlLocation);
            RecepcionComprobantesService service = new RecepcionComprobantesService(url, qname);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return e;
        } 
    }
}
