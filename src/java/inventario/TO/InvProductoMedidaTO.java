/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package inventario.TO;

import java.math.BigDecimal;

/**
 *
 * @author misayo
 */
public class InvProductoMedidaTO implements java.io.Serializable{
    private String medEmpresa;
    private String medCodigo;
    private String medDetalle;
    private BigDecimal medConvLibras;
    private BigDecimal medConvKilos;
    private String usrEmpresa;
    private String usrCodigo;
    private String usrFechaInserta;

    public InvProductoMedidaTO() {
    }

    public InvProductoMedidaTO(String medEmpresa, String medCodigo, String medDetalle, BigDecimal medConvLibras, BigDecimal medConvKilos, String usrEmpresa, String usrCodigo, String usrFechaInserta) {
        this.medEmpresa = medEmpresa;
        this.medCodigo = medCodigo;
        this.medDetalle = medDetalle;
        this.medConvLibras = medConvLibras;
        this.medConvKilos = medConvKilos;
        this.usrEmpresa = usrEmpresa;
        this.usrCodigo = usrCodigo;
        this.usrFechaInserta = usrFechaInserta;
    }

    public BigDecimal getMedConvKilos() {
        return medConvKilos;
    }

    public void setMedConvKilos(BigDecimal medConvKilos) {
        this.medConvKilos = medConvKilos;
    }

    public BigDecimal getMedConvLibras() {
        return medConvLibras;
    }

    public void setMedConvLibras(BigDecimal medConvLibras) {
        this.medConvLibras = medConvLibras;
    }

    public String getMedCodigo() {
        return medCodigo;
    }

    public void setMedCodigo(String medCodigo) {
        this.medCodigo = medCodigo;
    }

    public String getMedDetalle() {
        return medDetalle;
    }

    public void setMedDetalle(String medDetalle) {
        this.medDetalle = medDetalle;
    }

    public String getMedEmpresa() {
        return medEmpresa;
    }

    public void setMedEmpresa(String medEmpresa) {
        this.medEmpresa = medEmpresa;
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
