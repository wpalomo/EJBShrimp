/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rrhh.TO;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author misael
 */
public class RhAnticipoTO implements Serializable{
    private String empCodigo;
    private String perCodigo;
    private String tipCodigo;
    private String conNumero;
    private String secCodigo;
    private String empId;
    private String empApellidosNombres;
    private String antFecha;
    private BigDecimal antValor;
    private String antFormasPago;
    private String conDetDocumento;
    private String conObservaciones;
    private Boolean reversar;
    private String usrInsertaAnticipo;
    private Integer antSecuencial;

    public RhAnticipoTO() {
    }

    public RhAnticipoTO(String empCodigo, String perCodigo, String tipCodigo, 
            String conNumero, String secCodigo, String empId, String empApellidosNombres, 
            String antFecha, BigDecimal antValor, String antFormasPago, 
            String conDetDocumento, String conObservaciones, Boolean reversar, 
            String usrInsertaAnticipo, Integer antSecuencial) {
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.tipCodigo = tipCodigo;
        this.conNumero = conNumero;
        this.secCodigo = secCodigo;
        this.empId = empId;
        this.empApellidosNombres = empApellidosNombres;
        this.antFecha = antFecha;
        this.antValor = antValor;
        this.antFormasPago = antFormasPago;
        this.conDetDocumento = conDetDocumento;
        this.conObservaciones = conObservaciones;
        this.reversar = reversar;
        this.usrInsertaAnticipo = usrInsertaAnticipo;
        this.antSecuencial = antSecuencial;
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

    public Integer getAntSecuencial() {
        return antSecuencial;
    }

    public void setAntSecuencial(Integer antSecuencial) {
        this.antSecuencial = antSecuencial;
    }

    public BigDecimal getAntValor() {
        return antValor;
    }

    public void setAntValor(BigDecimal antValor) {
        this.antValor = antValor;
    }

    public String getConDetDocumento() {
        return conDetDocumento;
    }

    public void setConDetDocumento(String conDetDocumento) {
        this.conDetDocumento = conDetDocumento;
    }

    public String getConNumero() {
        return conNumero;
    }

    public void setConNumero(String conNumero) {
        this.conNumero = conNumero;
    }

    public String getConObservaciones() {
        return conObservaciones;
    }

    public void setConObservaciones(String conObservaciones) {
        this.conObservaciones = conObservaciones;
    }

    public String getEmpApellidosNombres() {
        return empApellidosNombres;
    }

    public void setEmpApellidosNombres(String empApellidosNombres) {
        this.empApellidosNombres = empApellidosNombres;
    }

    public String getEmpCodigo() {
        return empCodigo;
    }

    public void setEmpCodigo(String empCodigo) {
        this.empCodigo = empCodigo;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(String perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Boolean getReversar() {
        return reversar;
    }

    public void setReversar(Boolean reversar) {
        this.reversar = reversar;
    }

    public String getSecCodigo() {
        return secCodigo;
    }

    public void setSecCodigo(String secCodigo) {
        this.secCodigo = secCodigo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getUsrInsertaAnticipo() {
        return usrInsertaAnticipo;
    }

    public void setUsrInsertaAnticipo(String usrInsertaAnticipo) {
        this.usrInsertaAnticipo = usrInsertaAnticipo;
    }

    public String getInformacion(){
        return "Empresa: "+empCodigo+
                "\nPeriodo: "+perCodigo+
                "\nTipo: "+tipCodigo+
                "\nNumero: "+conNumero+
                "\nSector: "+secCodigo+
                "\nId: "+empId+
                "\nApellidos Nombres: "+empApellidosNombres+
                "\nFecha Anticipo: "+antFecha+
                "\nValor Anticipo: "+antValor+
                "\nForma Pago: "+antFormasPago+
                "\nDocumento: "+conDetDocumento+
                "\nObservacion: "+conObservaciones+
                "\nReversar: "+reversar+
                "\nUsuario: "+usrInsertaAnticipo;
    }
}
