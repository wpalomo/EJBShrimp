/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

import anexos.sri.ws.autorizacion.RespuestaComprobante;
import anexos.sri.ws.recepcion.RespuestaSolicitud;
 

/**
 *
 * @author Carlos
 */
public class AnxComprobanteElectronicoUtilTO implements java.io.Serializable{
    private anexos.sri.ws.autorizacion.RespuestaComprobante respuestaComprobante;
    private anexos.sri.ws.recepcion.RespuestaSolicitud respuestaSolicitud;
    private byte[] eXml;
    
    public AnxComprobanteElectronicoUtilTO() {
    }

    
    
    public AnxComprobanteElectronicoUtilTO(RespuestaComprobante respuestaComprobante, RespuestaSolicitud respuestaSolicitud, byte[] eXml) {
        this.respuestaComprobante = respuestaComprobante;
        this.respuestaSolicitud = respuestaSolicitud;
        this.eXml = eXml;
    }

    public byte[] geteXml() {
        return eXml;
    }

    public void seteXml(byte[] eXml) {
        this.eXml = eXml;
    }

    public RespuestaComprobante getRespuestaComprobante() {
        return respuestaComprobante;
    }

    public void setRespuestaComprobante(RespuestaComprobante respuestaComprobante) {
        this.respuestaComprobante = respuestaComprobante;
    }

    public RespuestaSolicitud getRespuestaSolicitud() {
        return respuestaSolicitud;
    }

    public void setRespuestaSolicitud(RespuestaSolicitud respuestaSolicitud) {
        this.respuestaSolicitud = respuestaSolicitud;
    }
}
