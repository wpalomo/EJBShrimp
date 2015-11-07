package anexos.sri.comprobantes.util;

import anexos.sri.comprobantes.modelo.factura.Factura;
import anexos.sri.comprobantes.modelo.notadebito.NotaDebito;
import anexos.sri.comprobantes.modelo.notadecredito.NotaCredito;
import anexos.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
import anexos.sri.comprobantes.util.xml.Java2XML;
import anexos.sri.comprobantes.util.xml.LectorXPath;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class ArchivoUtils {
    /*
     * REVISAR METODOS COMENTADOS - firmarArchivo
     */

//    public static String obtieneClaveAccesoAutorizacion(Autorizacion item) {
//        String claveAcceso = null;
//
//        String xmlAutorizacion = XStreamUtil.getRespuestaLoteXStream().toXML(item);
//        File archivoTemporal = new File("temp.xml");
//
//        stringToArchivo(archivoTemporal.getPath(), xmlAutorizacion);
//        String contenidoXML = decodeArchivoBase64(archivoTemporal.getPath());
//
//        if (contenidoXML != null) {
//            stringToArchivo(archivoTemporal.getPath(), contenidoXML);
//            claveAcceso = obtenerValorXML(archivoTemporal, "/*/infoTributaria/claveAcceso");
//        }
//
//        return claveAcceso;
//    }

    public static String decodeArchivoBase64(String pathArchivo) {
        String xmlDecodificado = null;
        try {
            File file = new File(pathArchivo);
            if (file.exists()) {
                String encd = obtenerValorXML(file, "/*/comprobante");
                xmlDecodificado = encd;
            } else {
                System.out.print("File not found!");
            }
        } catch (Exception e) {
            Logger.getLogger(AutorizacionComprobantesWs.class.getName()).log(Level.SEVERE, null, e);
        }
        return xmlDecodificado;
    }

    public static File stringToArchivo(String rutaArchivo, String contenidoArchivo) {
        FileOutputStream fos = null;
        File archivoCreado = null;
        int i = 0;
        try {
            fos = new FileOutputStream(rutaArchivo);
            OutputStreamWriter out = new OutputStreamWriter(fos, "UTF-8");
            for (i = 0; i < contenidoArchivo.length(); i++) {
                out.write(contenidoArchivo.charAt(i));
            }
            out.close();
            archivoCreado = new File(rutaArchivo);
        } catch (Exception ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
            i = 0;
            return null;
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception ex) {
                Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return archivoCreado;
    }

    // <editor-fold defaultstate="collapsed" desc="respuestaAutoriz">
    public static String obtenerValorXML(File xmlDocument, String expression) {
        String valor = null;
        try {
            LectorXPath reader = new LectorXPath(xmlDocument.getPath());
            valor = (String) reader.leerArchivo(expression, XPathConstants.STRING);
        } catch (Exception e) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, e);
        }

        return valor;
    }

    public static byte[] archivoToByte(File file) throws IOException {
        byte[] buffer = new byte[(int) file.length()];
        InputStream ios = null;
        try {
            ios = new FileInputStream(file);
            if (ios.read(buffer) == -1) {
                throw new IOException("EOF reached while trying to read the whole file");
            }
        } finally {
            try {
                if (ios != null) {
                    ios.close();
                }
            } catch (IOException e) {
                Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return buffer;
    }

    // </editor-fold>
    //public static String crearArchivoXml2(String pathArchivo, Object objetoModelo, ClaveContingencia claveContingencia, Long secuencial, String tipoComprobante)
    public static String crearArchivoXml2(String pathArchivo, Object objetoModelo) {
        String respuestaCreacion = null;
        if (objetoModelo != null) {
            try {
                respuestaCreacion = realizaMarshal(objetoModelo, pathArchivo);

//            if (respuestaCreacion == null)
//            {
////            if ((claveContingencia != null) && (claveContingencia.getCodigoComprobante() != null)) {
////                claveContingencia.setUsada("S");
////                new ClavesSQL().actualizaClave(claveContingencia);
////            }
//
//            new ComprobantesSQL().actualizaSecuencial(tipoComprobante, Long.valueOf(secuencial.longValue() + 1L));
//            }
            } catch (Exception ex) {
                Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            respuestaCreacion = "Ingrese los campos obligatorios del comprobante";
        }
        return respuestaCreacion;
    }

    private static String realizaMarshal(Object comprobante, String pathArchivo) {
        String respuesta = null;
        Class c = null;
        if (comprobante instanceof Factura) {
            c = Factura.class;
        } else if (comprobante instanceof NotaDebito) {
            c = NotaDebito.class;
        } else if (comprobante instanceof NotaCredito) {
            c = NotaCredito.class;
        } else if (comprobante instanceof ComprobanteRetencion) {
            c = ComprobanteRetencion.class;
        }
        Java2XML.objetoTOxml(c, pathArchivo, comprobante);
        return respuesta;
    }

    public static boolean copiarArchivo(File archivoOrigen, String pathDestino) {
        FileReader in = null;
        boolean resultado = false;
        try {
            File outputFile = new File(pathDestino);
            in = new FileReader(archivoOrigen);
            FileWriter out = new FileWriter(outputFile);
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.close();
            resultado = true;
        } catch (Exception ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                in.close();
            } catch (IOException ex) {
                Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return resultado;
    }

    private static Document merge(String exp, File[] files) throws Exception {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xpath = xPathFactory.newXPath();
        XPathExpression expression = xpath.compile(exp);

        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilderFactory.setIgnoringElementContentWhitespace(true);
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document base = docBuilder.parse(files[0]);

        Node results = (Node) expression.evaluate(base, XPathConstants.NODE);
        if (results == null) {
            throw new IOException(files[0] + ": expression does not evaluate to node");
        }

        for (int i = 1; i < files.length; i++) {
            Document merge = docBuilder.parse(files[i]);
            Node nextResults = (Node) expression.evaluate(merge, XPathConstants.NODE);
            results.appendChild(base.importNode(nextResults, true));
        }

        return base;
    }

    //import org.w3c.dom.Document;
    public static boolean adjuntarArchivo(File respuesta, File comprobante) {
        boolean exito = false;
        try {
            Document document = merge("*", new File[]{comprobante, respuesta});
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new OutputStreamWriter(new FileOutputStream(comprobante), "UTF-8"));
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer transformer = transFactory.newTransformer();
            transformer.transform(source, result);
        } catch (Exception ex) {
            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exito;
    }
    /*
     * >>>>>>>>>>>>>>>><<REVISAR >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><
     */
/// METODO PARA FIRMAR XML  
//    public static String firmarArchivo(
//            String xmlPath,
//            String pathSignature,
//            String passSignature,
//            String pathOut,
//            String nameFileOut) {
//        String respuestaFirma = null;
//        try {
//            if (xmlPath != null && pathSignature != null && passSignature != null && pathOut != null && nameFileOut != null) {
//                respuestaFirma = XAdESBESSignature.firmar(
//                        xmlPath,
//                        pathSignature,
//                        passSignature,
//                        pathOut,
//                        nameFileOut);
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(ArchivoUtils.class.getName()).log(Level.SEVERE, null, ex);
//            return ex.getMessage();
//        }
//        return respuestaFirma;
//    }

//    public static boolean anadirMotivosRechazo(File archivo, RespuestaSolicitud respuestaRecepcion) {
//        boolean exito = false;
////        File respuesta = new File("tmp/respuesta.xml");
////        Java2XML.objetoTOxml(RespuestaSolicitud.class, respuesta.getPath(), respuestaRecepcion);
////        if (adjuntarArchivo(respuesta, archivo) == true) {
////            exito = true;
////            respuesta.delete();
////        }
//        return exito;
//    }

    // devuelve un array byte de un string
    public static byte[] convertirStringByte(String archivo) {
        try {
            return archivo.getBytes("UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
