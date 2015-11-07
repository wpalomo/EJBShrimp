/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;

/**
 *
 * @author misael
 */
public class RhAnticipoCabeceraTO implements Serializable{
    private String empCodigo;
    private String antFecha;
    private String antFormasPago;
    private String antMotivo;
    private String conDetDocumento;
    private String conObservaciones;
    private Boolean reversar;
    private String usrInsertaAnticipo;

    public RhAnticipoCabeceraTO() {
    }

    
    public RhAnticipoCabeceraTO(String empCodigo, String antFecha, String antMotivo, 
            String conObservaciones, Boolean reversar, String usrInsertaAnticipo) {
        this.empCodigo = empCodigo;
        this.antFecha = antFecha;        
        this.antMotivo = antMotivo;        
        this.conObservaciones = conObservaciones;
        this.reversar = reversar;
        this.usrInsertaAnticipo = usrInsertaAnticipo;
    }
            
    public RhAnticipoCabeceraTO(String empCodigo, String antFecha, String antFormasPago, String antMotivo, String conDetDocumento, String conObservaciones, Boolean reversar, String usrInsertaAnticipo) {
        this.empCodigo = empCodigo;
        this.antFecha = antFecha;
        this.antFormasPago = antFormasPago;
        this.antMotivo = antMotivo;
        this.conDetDocumento = conDetDocumento;
        this.conObservaciones = conObservaciones;
        this.reversar = reversar;
        this.usrInsertaAnticipo = usrInsertaAnticipo;
    }

    public String getAntFecha() {
        return antFecha;
    }

    public void setAntFecha(String antFecha) {
        this.antFecha = antFecha;
    }

    public String getAntFormasPago() {
        return antFormasPago;
    }

    public void setAntFormasPago(String antFormasPago) {
        this.antFormasPago = antFormasPago;
    }

    public String getAntMotivo() {
        return antMotivo;
    }

    public void setAntMotivo(String antMotivo) {
        this.antMotivo = antMotivo;
    }

    public String getConDetDocumento() {
        return conDetDocumento;
    }

    public void setConDetDocumento(String conDetDocumento) {
        this.conDetDocumento = conDetDocumento;
    }

    public String getConObservaciones() {
        return conObservaciones;
    }

    public void setConObservaciones(String conObservaciones) {
        this.conObservaciones = conObservaciones;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public Boolean getReversar() {
        return reversar;
    }

    public void setReversar(Boolean reversar) {
        this.reversar = reversar;
    }

    public String getUsrInsertaAnticipo() {
        return usrInsertaAnticipo;
    }

    public void setUsrInsertaAnticipo(String usrInsertaAnticipo) {
        this.usrInsertaAnticipo = usrInsertaAnticipo;
    }
}
