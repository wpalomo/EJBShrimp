/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package caja.TO;

import java.math.BigDecimal;

/**
 *
 * @author Charly
 */
public class CajValesConceptoTO implements java.io.Serializable{   
    private String concEmpresa;
    private String concCodigo;
    private String concDetalle;
    private Boolean concInactivo;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public CajValesConceptoTO() {
    }

    public CajValesConceptoTO(String concEmpresa, String concCodigo, String concDetalle, Boolean concInactivo, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.concEmpresa = concEmpresa;
        this.concCodigo = concCodigo;
        this.concDetalle = concDetalle;
        this.concInactivo = concInactivo;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    

    public String getConcCodigo() {
        return concCodigo;
    }

    public void setConcCodigo(String concCodigo) {
        this.concCodigo = concCodigo;
    }

    public String getConcDetalle() {
        return concDetalle;
    }

    public void setConcDetalle(String concDetalle) {
        this.concDetalle = concDetalle;
    }

    public String getConcEmpresa() {
        return concEmpresa;
    }

    public void setConcEmpresa(String concEmpresa) {
        this.concEmpresa = concEmpresa;
    }

    public Boolean getConcInactivo() {
        return concInactivo;
    }

    public void setConcInactivo(Boolean concInactivo) {
        this.concInactivo = concInactivo;
    }

    public String getUsrCodigo() {
        return usrCodigo;
    }

    public void setUsrCodigo(String usrCodigo) {
        this.usrCodigo = usrCodigo;
    }

    public String getUsrEmpresa() {
        return usrEmpresa;
    }

    public void setUsrEmpresa(String usrEmpresa) {
        this.usrEmpresa = usrEmpresa;
    }

    public String getUsrFechaInserta() {
        return usrFechaInserta;
    }

    public void setUsrFechaInserta(String usrFechaInserta) {
        this.usrFechaInserta = usrFechaInserta;
    }    
}
