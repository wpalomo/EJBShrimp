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
public class RhViaticoTO implements Serializable{
    private String empCodigo;
    private String perCodigo;
    private String tipCodigo;
    private String conNumero;
    private String secCodigo;
    private String empId;
    private String empApellidosNombres;
    private String viaFecha;
    private BigDecimal viaValor;
    private String conObservaciones;
    private Boolean reversar;
    private String usrInsertaViatico;
    private Integer viaSecuencial;

    public RhViaticoTO() {
    }

    public RhViaticoTO(String empCodigo, String perCodigo, String tipCodigo, String conNumero, String secCodigo, String empId, String empApellidosNombres, String viaFecha, BigDecimal viaValor, String conObservaciones, Boolean reversar, String usrInsertaViatico, Integer viaSecuencial) {
        this.empCodigo = empCodigo;
        this.perCodigo = perCodigo;
        this.tipCodigo = tipCodigo;
        this.conNumero = conNumero;
        this.secCodigo = secCodigo;
        this.empId = empId;
        this.empApellidosNombres = empApellidosNombres;
        this.viaFecha = viaFecha;
        this.viaValor = viaValor;
        this.conObservaciones = conObservaciones;
        this.reversar = reversar;
        this.usrInsertaViatico = usrInsertaViatico;
        this.viaSecuencial = viaSecuencial;
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

    public String getUsrInsertaViatico() {
        return usrInsertaViatico;
    }

    public void setUsrInsertaViatico(String usrInsertaViatico) {
        this.usrInsertaViatico = usrInsertaViatico;
    }

    public String getViaFecha() {
        return viaFecha;
    }

    public void setViaFecha(String viaFecha) {
        this.viaFecha = viaFecha;
    }

    public Integer getViaSecuencial() {
        return viaSecuencial;
    }

    public void setViaSecuencial(Integer viaSecuencial) {
        this.viaSecuencial = viaSecuencial;
    }

    public BigDecimal getViaValor() {
        return viaValor;
    }

    public void setViaValor(BigDecimal viaValor) {
        this.viaValor = viaValor;
    }

    public String getInformacion(){
        return "Empresa: "+empCodigo+
                "\nPeriodo: "+perCodigo+
                "\nTipo: "+tipCodigo+
                "\nNumero: "+conNumero+
                "\nSector: "+secCodigo+
                "\nId: "+empId+
                "\nApellidos Nombres: "+empApellidosNombres+
                "\nFecha preicipo: "+viaFecha+
                "\nValor Prestamo: "+viaValor+
                "\nObservacion: "+conObservaciones+
                "\nReversar: "+reversar+
                "\nUsuario: "+usrInsertaViatico;
    }
}
