/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package contabilidad.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class ConDiarioAuxiliarTO implements java.io.Serializable{
    private Integer daOrden;
    private String daCuenta;
    private String daDetalle;
    private String daCP;
    private String daCC;
    private String daDocumento;
    private java.math.BigDecimal daDebe;
    private java.math.BigDecimal daDHaber;
    private String daBloque;

    public ConDiarioAuxiliarTO() {
    }

    public ConDiarioAuxiliarTO(Integer daOrden, String daCuenta, String daDetalle, String daCP, String daCC, String daDocumento, BigDecimal daDebe, BigDecimal daDHaber, String daBloque) {
        this.daOrden = daOrden;
        this.daCuenta = daCuenta;
        this.daDetalle = daDetalle;
        this.daCP = daCP;
        this.daCC = daCC;
        this.daDocumento = daDocumento;
        this.daDebe = daDebe;
        this.daDHaber = daDHaber;
        this.daBloque = daBloque;
    }

    public String getDaBloque() {
        return daBloque;
    }

    public void setDaBloque(String daBloque) {
        this.daBloque = daBloque;
    }

    public String getDaCC() {
        return daCC;
    }

    public void setDaCC(String daCC) {
        this.daCC = daCC;
    }

    public String getDaCP() {
        return daCP;
    }

    public void setDaCP(String daCP) {
        this.daCP = daCP;
    }

    public String getDaCuenta() {
        return daCuenta;
    }

    public void setDaCuenta(String daCuenta) {
        this.daCuenta = daCuenta;
    }

    public BigDecimal getDaDHaber() {
        return daDHaber;
    }

    public void setDaDHaber(BigDecimal daDHaber) {
        this.daDHaber = daDHaber;
    }

    public BigDecimal getDaDebe() {
        return daDebe;
    }

    public void setDaDebe(BigDecimal daDebe) {
        this.daDebe = daDebe;
    }

    public String getDaDetalle() {
        return daDetalle;
    }

    public void setDaDetalle(String daDetalle) {
        this.daDetalle = daDetalle;
    }

    public String getDaDocumento() {
        return daDocumento;
    }

    public void setDaDocumento(String daDocumento) {
        this.daDocumento = daDocumento;
    }

    public Integer getDaOrden() {
        return daOrden;
    }

    public void setDaOrden(Integer daOrden) {
        this.daOrden = daOrden;
    }
}
