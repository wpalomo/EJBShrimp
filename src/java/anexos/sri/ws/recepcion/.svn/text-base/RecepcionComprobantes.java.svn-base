
package anexos.sri.ws.recepcion;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


@WebService(name = "RecepcionComprobantes", targetNamespace = "http://ec.gob.sri.ws.recepcion")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RecepcionComprobantes {

    @WebMethod
    @WebResult(name = "RespuestaRecepcionComprobante", targetNamespace = "")
    @RequestWrapper(localName = "validarComprobante", targetNamespace = "http://ec.gob.sri.ws.recepcion", className = "anexos.sri.ws.recepcion.ValidarComprobante")
    @ResponseWrapper(localName = "validarComprobanteResponse", targetNamespace = "http://ec.gob.sri.ws.recepcion", className = "anexos.sri.ws.recepcion.ValidarComprobanteResponse")
    public RespuestaSolicitud validarComprobante(
        @WebParam(name = "xml", targetNamespace = "")
        byte[] xml);

}
