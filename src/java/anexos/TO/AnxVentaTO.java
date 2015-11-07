/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package anexos.TO;

import java.math.BigDecimal;

/**
 *
 * @author jack
 */
public class AnxVentaTO implements java.io.Serializable{
    private String venEmpresa;
    private String venPeriodo;
    private String venMotivo;
    private String venNumero;
    private String venRetencionNumero;
    private String venRetencionAutorizacion;
    private String venRetencionFechaEmision;
    private java.math.BigDecimal venBase0;
    private java.math.BigDecimal venBaseImponible;
    private java.math.BigDecimal venBaseNoObjetoIva;
    private java.math.BigDecimal venMontoIva;
    private java.math.BigDecimal venValorRetenidoIva;
    private java.math.BigDecimal venValorRetenidoRenta;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public AnxVentaTO() {
    }

    public AnxVentaTO(String venEmpresa, String venPeriodo, String venMotivo, String venNumero, String venRetencionNumero, String venRetencionAutorizacion, String venRetencionFechaEmision, BigDecimal venBase0, BigDecimal venBaseImponible, BigDecimal venBaseNoObjetoIva, BigDecimal venMontoIva, BigDecimal venValorRetenidoIva, BigDecimal venValorRetenidoRenta, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.venEmpresa = venEmpresa;
        this.venPeriodo = venPeriodo;
        this.venMotivo = venMotivo;
        this.venNumero = venNumero;
        this.venRetencionNumero = venRetencionNumero;
        this.venRetencionAutorizacion = venRetencionAutorizacion;
        this.venRetencionFechaEmision = venRetencionFechaEmision;
        this.venBase0 = venBase0;
        this.venBaseImponible = venBaseImponible;
        this.venBaseNoObjetoIva = venBaseNoObjetoIva;
        this.venMontoIva = venMontoIva;
        this.venValorRetenidoIva = venValorRetenidoIva;
        this.venValorRetenidoRenta = venValorRetenidoRenta;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
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

    public BigDecimal getVenBase0() {
        return venBase0;
    }

    public void setVenBase0(BigDecimal venBase0) {
        this.venBase0 = venBase0;
    }

    public BigDecimal getVenBaseImponible() {
        return venBaseImponible;
    }

    public void setVenBaseImponible(BigDecimal venBaseImponible) {
        this.venBaseImponible = venBaseImponible;
    }

    public BigDecimal getVenBaseNoObjetoIva() {
        return venBaseNoObjetoIva;
    }

    public void setVenBaseNoObjetoIva(BigDecimal venBaseNoObjetoIva) {
        this.venBaseNoObjetoIva = venBaseNoObjetoIva;
    }

    public String getVenEmpresa() {
        return venEmpresa;
    }

    public void setVenEmpresa(String venEmpresa) {
        this.venEmpresa = venEmpresa;
    }

    public BigDecimal getVenMontoIva() {
        return venMontoIva;
    }

    public void setVenMontoIva(BigDecimal venMontoIva) {
        this.venMontoIva = venMontoIva;
    }

    public String getVenMotivo() {
        return venMotivo;
    }

    public void setVenMotivo(String venMotivo) {
        this.venMotivo = venMotivo;
    }

    public String getVenNumero() {
        return venNumero;
    }

    public void setVenNumero(String venNumero) {
        this.venNumero = venNumero;
    }

    public String getVenPeriodo() {
        return venPeriodo;
    }

    public void setVenPeriodo(String venPeriodo) {
        this.venPeriodo = venPeriodo;
    }

    public String getVenRetencionAutorizacion() {
        return venRetencionAutorizacion;
    }

    public void setVenRetencionAutorizacion(String venRetencionAutorizacion) {
        this.venRetencionAutorizacion = venRetencionAutorizacion;
    }

    public String getVenRetencionFechaEmision() {
        return venRetencionFechaEmision;
    }

    public void setVenRetencionFechaEmision(String venRetencionFechaEmision) {
        this.venRetencionFechaEmision = venRetencionFechaEmision;
    }

    public String getVenRetencionNumero() {
        return venRetencionNumero;
    }

    public void setVenRetencionNumero(String venRetencionNumero) {
        this.venRetencionNumero = venRetencionNumero;
    }

    public BigDecimal getVenValorRetenidoIva() {
        return venValorRetenidoIva;
    }

    public void setVenValorRetenidoIva(BigDecimal venValorRetenidoIva) {
        this.venValorRetenidoIva = venValorRetenidoIva;
    }

    public BigDecimal getVenValorRetenidoRenta() {
        return venValorRetenidoRenta;
    }

    public void setVenValorRetenidoRenta(BigDecimal venValorRetenidoRenta) {
        this.venValorRetenidoRenta = venValorRetenidoRenta;
    }
}
